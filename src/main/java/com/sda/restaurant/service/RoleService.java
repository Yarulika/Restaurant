package com.sda.restaurant.service;

import com.sda.restaurant.dao.RoleRepository;
import com.sda.restaurant.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {return roleRepository.save(role); }

    public void delete(Role role) {roleRepository.delete(role);}

    public void update(Role role) {save(role); }

    public Role findById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> findAll(){ return roleRepository.findAll(); }
}
