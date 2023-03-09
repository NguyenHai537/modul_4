package com.codegym.service;


import com.codegym.model.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}