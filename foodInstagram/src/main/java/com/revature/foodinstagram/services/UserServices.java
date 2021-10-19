package com.revature.foodinstagram.services;

import com.revature.foodinstagram.beans.User;
import com.revature.foodinstagram.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServices {

    private final UserRepo userRepo;

    @Autowired
    public UserServices(UserRepo userRepo){
            return userRepo.findById(id);
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserbyUsername(String username){
        User user = userRepo.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);

    }


}
