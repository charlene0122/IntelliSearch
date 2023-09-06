package com.search.intellisearch.rest;

import com.search.intellisearch.dao.UserDao;
import com.search.intellisearch.entity.User;
import com.search.intellisearch.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam; import org.springframework.web.bind.annotation.RestController;
@RestController
public class SearchController {

    private UserService userService;
    @PostMapping("/api/search")
    public ResponseEntity search(
            //@RequestParam(name = "userId") Long userId,
            @RequestParam(name = "keywords") String keywords,
            @AuthenticationPrincipal UserDetails user) {
        System.out.println(user.getUsername() + " keywords: " + keywords);
        // Get results
        String result = "Searching for userId: " + user.getUsername() + " with keywords: " + keywords;
        // Create a ResponseEntity with an OK status (HTTP 200)
        return new ResponseEntity(result, HttpStatus.OK); }
}