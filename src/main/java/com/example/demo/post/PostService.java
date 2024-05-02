package com.example.demo.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class PostService {


    @Autowired
    PostRepository postRepository;


    public Object callThirdPartyApi(Integer postId) {
        String uri = "https://jsonplaceholder.org/posts/1";
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(uri, String.class);

        System.out.println("jsonResponse = " + jsonResponse);

        Post post = new Post();
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            post = objectMapper.readValue(jsonResponse, Post.class);

            postRepository.save(post);
        } catch (Exception e) {

            e.printStackTrace();
        }



        return jsonResponse;
    }
}
