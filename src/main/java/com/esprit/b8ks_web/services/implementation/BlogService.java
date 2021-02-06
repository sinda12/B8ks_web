package com.esprit.b8ks_web.services.implementation;

import com.esprit.b8ks_web.entities.Blog;
import com.esprit.b8ks_web.repository.BlogRepository;
import com.esprit.b8ks_web.services.IBlogService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogService implements IBlogService {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public Blog save(Blog blog) {
        //this call to clean the dirty text
        blog.setText(CursefilterService.cleanText(blog.getText()));
        //
        HttpHeaders hd = new HttpHeaders();
        hd.setBasicAuth("WoaXtPYDdWYi-g", "WOMYtWAQz3unnQXZnat7UEjViEjV3Q");
        hd.add("User-agent","PostmanRuntime/7.26.8");
        String authUrl = "https://ssl.reddit.com/api/v1/access_token?grant_type=password&username=B8ks&password=B8ks1514";
        HttpEntity<String> httpEntityAuth = new HttpEntity<>("", hd);

        ResponseEntity<JsonNode> jsonNode = restTemplate.postForEntity(authUrl, httpEntityAuth, JsonNode.class);
        JsonNode jsonNode1 = jsonNode.getBody();
        String token = jsonNode1.get("access_token").asText();
        System.out.println(token);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("User-agent","PostmanRuntime/7.26.8");
        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);
        StringBuilder url = new StringBuilder();
        url.append("https://oauth.reddit.com/api/submit");
        url.append("?");
        url.append("title=");
        url.append(blog.getTitle());
        url.append("&");
        url.append("text=");
        url.append(blog.getText());
        url.append("&");
        url.append("sr=u_b8ks");
        url.append("&");
        url.append("url=http://localhost:8080/api/blogs");
        url.append("&");
        url.append("kind=self");
        url.append("&");
        url.append("submit_type=profile");
        Map<String, String> map = new HashMap<>();
        map.put("title", "eeee");
        map.put("text", "this a text for test :)");
        map.put("sr", "u_b8ks");
        map.put("kind", "self");
        map.put("submit_type", "profile");
        map.put("url", "http://localhost:8080/api/blogs");
       ResponseEntity<String> s = restTemplate.postForEntity(url.toString(), httpEntity,  String.class, map);
        System.out.println(s.getBody());
        System.out.println(s.getHeaders());
        return blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }
}
