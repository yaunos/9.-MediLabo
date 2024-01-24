package com.preventDiabet.PatientMicroservice.controller;

import com.preventDiabet.PatientMicroservice.model.User;
import com.preventDiabet.PatientMicroservice.repository.UserRepository;
import com.preventDiabet.PatientMicroservice.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class LoginController
{

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm()

    {
        return "login";
        //return "redirect:/login.html";
        // return new RedirectView("login.html");
    }


    @PostMapping("/login")
    public RedirectView login(@RequestParam String login, @RequestParam String password)
    {
        User foundUser = userRepository.findById(login).orElse(null);
        if (foundUser != null && PasswordUtils.comparePassword(password,foundUser.getPassword()))
        {
            return new RedirectView("loginSuccess.html");
        }
        else
        {

            return new RedirectView("loginFailed.html");
        }
    }

}