package com.sda.restaurant.service;

import com.sda.restaurant.entity.Person;
import com.sda.restaurant.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService  {

    @Autowired
    PersonService personService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Person person = personService.findByEmail(s).orElseThrow(() -> new PersonNotFoundException(s));
        List<SimpleGrantedAuthority> grantedAuthorities = person.getRoles().parallelStream().map(role -> new SimpleGrantedAuthority(role.getRoleTitle().name())).collect(Collectors.toList());
        return new User(person.getEmail(),person.getPassword(),grantedAuthorities);
    }

}
