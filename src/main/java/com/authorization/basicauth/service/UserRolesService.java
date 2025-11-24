package com.authorization.basicauth.service;

import com.authorization.basicauth.entity.UserRoles;
import com.authorization.basicauth.repository.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.List;


@Service
public class UserRolesService {
    @Autowired
    UserRoleRepo userRoleRepo;

    public List<UserRoles> allRoles(){
        return userRoleRepo.findAll();
    }

    public UserRoles add(Integer roleId, String roleName,  Integer roleLevel){

        return userRoleRepo.save(new UserRoles(roleId,roleName,roleLevel, new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis())));
    }

    public String modify(Integer roleId, String roleName,  Integer roleLevel){
        UserRoles dbUser=userRoleRepo.findByRoleId(roleId);
        if(dbUser== null){
            return "The Role with Role Id: "+roleId+" and Role name: "+roleName+" Does not exist";
        }

        userRoleRepo.modify(roleId,roleName,roleLevel,new Timestamp(System.currentTimeMillis()));
        return roleId+" updated successfully";
    }

    public void deleteById(Integer roleId){
        userRoleRepo.deleteById(roleId);
    }
}
