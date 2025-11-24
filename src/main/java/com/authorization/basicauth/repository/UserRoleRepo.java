package com.authorization.basicauth.repository;

import com.authorization.basicauth.entity.UserRoles;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRoles,Integer> {
    UserRoles findByRoleId(Integer roleId);
    @Transactional
    @Modifying
    @Query("UPDATE UserRoles rol SET rol.roleName=:roleName,rol.roleLevel=:roleLevel,rol.lastModified=:timestamp WHERE rol.roleId=:roleId")
    void modify(@Param("roleId") Integer roleId, @Param("roleName") String roleName, @Param("roleLevel") Integer roleLevel, @Param("timestamp") Timestamp timestamp);
}
