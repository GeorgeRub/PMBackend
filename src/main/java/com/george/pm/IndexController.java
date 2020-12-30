package com.george.pm;

import com.george.pm.models.auth.ERole;
import com.george.pm.models.auth.Role;
import com.george.pm.repositories.auth.RoleRepository;
import com.george.pm.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/")
    public String index(){

//        List<Role> roles = new ArrayList<>();
//        roles.add(new Role(ERole.ROLE_USER));
//        roles.add(new Role(ERole.ROLE_ADMIN));
//        roles.add(new Role(ERole.ROLE_MODERATOR));
//        roles.forEach(r -> roleService.save(r));

        return "index";
    }

}
