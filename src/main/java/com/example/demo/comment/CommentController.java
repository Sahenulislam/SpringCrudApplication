package com.example.demo.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    CommentService commentService;
    @GetMapping("third-party-api")
    public Object callThirdPartyApi(){
        return commentService.callThirdPartyApi();
    }

    @GetMapping("third-party-api/{id}")
    public Object callThirdPartyApi(@PathVariable Long id)
    {
        return commentService.callThirdPartyApi(id);
    }
}
