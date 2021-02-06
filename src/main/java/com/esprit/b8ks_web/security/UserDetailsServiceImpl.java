package com.esprit.b8ks_web.security;

import com.esprit.b8ks_web.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private  AccountServiceImpl accountServiceImpl;




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("load loula=== "+email);
        User user = accountServiceImpl.loadUserByEmail(email);
        System.out.println("load thenia");
        if(user==null)throw new UsernameNotFoundException("email not exist");
        System.out.println("load theltha");
        Collection<GrantedAuthority> authorities = new ArrayList<>() ;
        System.out.println("load rabeaa");
        user.getRoles().forEach(role ->  authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        System.out.println("maoujoud");
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
}
