package com.luv2code.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}
