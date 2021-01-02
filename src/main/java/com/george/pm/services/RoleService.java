package com.george.pm.services;

import com.george.pm.models.auth.Role;
import com.george.pm.repositories.auth.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {
        role.setId(UUID.randomUUID().toString());
        return roleRepository.save(role);
    }
}
