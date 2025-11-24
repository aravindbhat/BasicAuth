package com.authorization.basicauth.controller;

import com.authorization.basicauth.entity.UserRoles;
import com.authorization.basicauth.service.UserRolesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/admin/roles")
public class UserRolesController {

    @Autowired
    private UserRolesService userRolesService;

    @GetMapping("/allroles")
    public List<UserRoles> roles(){
        return userRolesService.allRoles();
    }

    @PostMapping("/add")
    public UserRoles addRole(@RequestParam Integer roleId, @RequestParam String roleName, @RequestParam Integer roleLevel){
        System.out.println("Add Request");
        System.out.println(roleId+"|"+roleName+"|"+roleLevel);
        return userRolesService.add(roleId, roleName, roleLevel);
    }

    @PutMapping("/modify")
    public String modifyRole(@RequestParam Integer roleId, @RequestParam String roleName, @RequestParam Integer roleLevel){
        return userRolesService.modify(roleId, roleName, roleLevel);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer userId){
        userRolesService.deleteById(userId);
        return userId+" has been deleted";
    }

    @GetMapping("csrf")
    public CsrfToken token(HttpServletRequest http){
        return (CsrfToken) http.getAttribute("_csrf");
    }

}
