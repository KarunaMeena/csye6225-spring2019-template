package com.example.assignment2.controller;

import com.example.assignment2.BO.User;
import com.example.assignment2.service.UserService;
import com.example.assignment2.tool.BCryptUtility;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user")

public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/signin", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView signIn() {
        return new ModelAndView("signin");
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView signUp() {
        return new ModelAndView("signup");
    }

    @RequestMapping(value = "/signinvalidate", method = {RequestMethod.POST})
    public ModelAndView signInValidate(@Valid User user, BindingResult result, HttpServletRequest request, Model model) {

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            String eMessage = errors.stream().map(e -> e.getDefaultMessage()).findFirst().get();
            return new ModelAndView("errorpage", "errorMessage", eMessage);
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean exists = userService.findUserbyUsername(username);
        if (!exists) {
            return new ModelAndView("errorpage", "errorMessage", "Account Not Found");
        }
        //System.out.println(BCrypt.gensalt());
        String enPassword = BCrypt.hashpw(password, BCryptUtility.SALT);
        boolean checked = userService.checkAccount(username, enPassword);
        if (!checked) {
            return new ModelAndView("errorpage", "errorMessage", "Username or Password Invalid");
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("user", username);
            mav.addObject("currentTime", new Date().toString());
            mav.setViewName("userindex");
            return mav;
        }

    }

    @RequestMapping(value = "/signupvalidate", method = {RequestMethod.POST})
    public ModelAndView signUpValidate(@Valid User user, BindingResult result, HttpServletRequest request, Model model) {

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            String eMessage = errors.stream().map(e -> e.getDefaultMessage()).findFirst().get();
            return new ModelAndView("errorpage", "errorMessage", eMessage);
        }

        String password = user.getPassword();
        //String enPassword = HashUtility.getHash(password);
        String enPassword = BCrypt.hashpw(password, BCryptUtility.SALT);
        User u = new User(request.getParameter("username"), enPassword);
        boolean exists = userService.findUserbyUsername(u.getUsername());
        if (exists) {
            return new ModelAndView("errorpage", "errorMessage", "Account Already Exists");
        }
        User uCheck = userService.save(u);
        if (uCheck != null) {
            return new ModelAndView("index");
        } else {
            return new ModelAndView("errorpage", "errorMessage", "Save User Failed");
        }

    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.invalidate();
        return new ModelAndView("index");
    }


}
