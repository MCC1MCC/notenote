package com.note.back.controller;

import com.note.back.pojo.User;
import com.note.back.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin // 解决跨域请求
    @PostMapping("api/register")
    @ResponseBody
    public String Register(@RequestBody User user){ // 把接受到的字符串转换为对象
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username); // 清除一下格式问题
        user.setUsername(username);
        String password = user.getPassword();

        boolean isExist = userService.isExist(username);
        if(isExist){
            return "用户已存在,请直接登陆";
        }
        // 安全随机密码生成
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithm = "md5"; //        算法， 密码，盐， 迭代次数
        String pwdAfterHash = new SimpleHash(algorithm,password,salt,times).toString();
        user.setSalt(salt);
        user.setPassword(pwdAfterHash);

        userService.addUser(user);

        return "创建成功";

    }

}
