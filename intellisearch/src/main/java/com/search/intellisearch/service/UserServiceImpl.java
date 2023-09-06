package com.search.intellisearch.service;

import com.search.intellisearch.dao.UserDao;
import com.search.intellisearch.entity.Role;
import com.search.intellisearch.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public User findByUserName(String userName) {
        // check the database if the user already exists
        return userDao.findByUserName(userName);
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                user.getAuthorities());
    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role>
//                                                                                 roles) {
//        return roles.stream().map(role -> new
//                SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }

}
