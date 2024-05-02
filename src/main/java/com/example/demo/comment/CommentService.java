package com.example.demo.comment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommentService {


    @Autowired
    CommentRepository commentRepository;


    public Object callThirdPartyApi() {
        String url = "https://jsonplaceholder.org/comments/1";
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        Comment comment = new Comment();

        try {

            comment = objectMapper.readValue(jsonResponse, Comment.class);

            commentRepository.save(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonResponse;

    }

    public Object callThirdPartyApi(Long id) {
        String url = "https://jsonplaceholder.org/comments/"+id;

        System.out.println(url);

        RestTemplate restTemplate = new RestTemplate();

        String jsonResponse = restTemplate.getForObject(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        Comment comment = new Comment();

        try {
            comment = objectMapper.readValue(jsonResponse, Comment.class);

            commentRepository.save(comment);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return jsonResponse;

    }

}