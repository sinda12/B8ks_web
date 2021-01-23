package com.esprit.b8ks_web.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.esprit.b8ks_web.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager ;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            User user = new ObjectMapper().readValue(request.getInputStream(),User.class) ;
            System.out.println("Jawek behi");
            return  authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e) ;
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
        ArrayList<String> roles;
        roles = new ArrayList<>();
        authResult.getAuthorities().forEach(r->{roles.add(r.getAuthority());});

        String jwt = JWT.create()
                .withIssuer(request.getRequestURI()).
                        withSubject(user.getUsername())
                .withArrayClaim( "roles",roles.toArray(new String[roles.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis() + SecureParam.EXPIRATION))
                .sign(Algorithm.HMAC256(SecureParam.SECRET));
        System.out.println("behii barchaa");
        response.addHeader(SecureParam.HEADER_NAME,SecureParam.HEADER_PREFIX+jwt);


    }
}
