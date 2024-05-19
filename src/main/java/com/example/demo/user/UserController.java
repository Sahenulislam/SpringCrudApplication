package com.example.demo.user;


import com.example.demo.user.objects.ChangePassword;
import com.example.demo.user.objects.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    UserService userService;
/*

    @PostMapping("/create-account")
    public User createAccount(@RequestBody User user){

        return userService.createAccount(user);
    }
*/


   /* @PostMapping("/change-password")
    public User changePassword(@RequestBody ChangePassword changePassword){
        return userService.changePassword(changePassword);
    }*/

}
