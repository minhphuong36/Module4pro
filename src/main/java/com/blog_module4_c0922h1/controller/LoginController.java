package com.blog_module4_c0922h1.controller;

import com.blog_module4_c0922h1.model.Account;
import com.blog_module4_c0922h1.model.Blog;
import com.blog_module4_c0922h1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class LoginController {
   @Autowired
    AccountService accountService;
    @Autowired
    HttpSession httpSession;
    @GetMapping("/login")
    public String show(){
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        Account account = accountService.checkLogin(username,password);
        if(account == null){
            return "redirect:/login";
        }else {
            httpSession.setAttribute("account", account);
            return "redirect:/blogs";
        }
    }

    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView("signup");
        return modelAndView;
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute Account account){
        accountService.save(account);
        return "redirect:/login";
    }
}
