package com.search.intellisearch.service;

import com.search.intellisearch.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
public interface UserService extends UserDetailsService {
    public User findByUserName(String userName);
}