package com.dgut.controller;

import com.dgut.entity.Admin;
import com.dgut.entity.User;
import com.dgut.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam("password")String password, @RequestParam("type")String type, HttpSession session){
        Object object = accountFeign.login(username,password,type);
        LinkedHashMap<String,Object> hashMap = (LinkedHashMap)object;
        String result = null;
        String idStr = null;
        long id = 0L;
        if(object==null){
            result = "login";
        }else{
            switch (type){
                case "user":
                    User user = new User();
                    idStr = hashMap.get("id")+"";
                    id = Long.parseLong(idStr);
                    String nickname = (String)hashMap.get("nickname");
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user",user);
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    idStr = hashMap.get("id")+"";
                    id = Long.parseLong(idStr);
                    String name = (String)hashMap.get("username");
                    admin.setId(id);
                    admin.setUsername(name);
                    session.setAttribute("admin",admin);
                    result = "main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }

    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }


}
