package com.example.demo.user;


import com.example.demo.user.objects.ChangePassword;
import com.example.demo.user.objects.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createAccount(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public LoginUser login(LoginUser loginUser){

        User user=userRepository.findByEmail(loginUser.getEmail());
        if(user==null) {
            throw new UserNotFoundException("User not found with email: " + loginUser.getEmail());
        }
        else if(user.getPassword()!=loginUser.getPassword()){
            throw new UserNotFoundException("Invalid Password: " + loginUser.getEmail());
        }
        else {

            // do Login;
        }
        return loginUser;
    }

    public User changePassword(ChangePassword changePassword){
        User currentUser=      //find currentUser;
        return userRepository.save(currentUser.setPassword(passwordEncoder.encode(changePassword.getNewPassword())));
    }
}

