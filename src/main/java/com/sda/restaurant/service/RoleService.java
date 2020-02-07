package com.sda.restaurant.service;

import com.sda.restaurant.dao.RoleRepository;
import com.sda.restaurant.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(@Valid @NotEmpty Role role) {return roleRepository.save(role); }

    public void delete(@Valid @NotEmpty Role role) {roleRepository.delete(role);}

    public void update(@Valid @NotEmpty Role role) {save(role); }

    public Role findById(@NotNull Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> findAll(){ return roleRepository.findAll(); }
}
