package com.search.intellisearch.dao;

import com.search.intellisearch.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String theRoleName);
}
