package com.example.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    PostService postService;


    @GetMapping("third-party-api")
    public Object callThirdPartyApi() {
        return postService.callThirdPartyApi(2);
    }

}
