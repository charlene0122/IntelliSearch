package com.search.intellisearch.dao;

import com.search.intellisearch.entity.User;

public interface UserDao {
    User findByUserName(String userName);
}
