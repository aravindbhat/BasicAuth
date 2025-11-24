package com.authorization.basicauth.repository;

import com.authorization.basicauth.entity.ApplicationUsers;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface UserAuthRepo extends JpaRepository<ApplicationUsers,Long> {
    Optional<ApplicationUsers> findByUserName(String userName);
    @Transactional
    @Modifying
    @Query("UPDATE ApplicationUsers au set  au.lastLogin=:loginTime WHERE au.userId=:userId")
    void updateLatestLoginTime(@Param("userId") Long userId, @Param("loginTime") Timestamp timestamp);
}
