package com.breeze.summer.services;

import com.breeze.summer.dto.auth.AuthUserDetails;
import com.breeze.summer.dto.auth.CouzyUser;
import com.breeze.summer.dto.auth.User;
import com.breeze.summer.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.breeze.summer.dto.auth.AuthUserDetails.makeFreshUser;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    final UserRepository userRepo;

    public AuthUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public AuthUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUserName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + username));

        return user.map(AuthUserDetails::new).get();
    }

    public AuthUserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByEmail(email);

        user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + email));

        return user.map(AuthUserDetails::new).get();
    }

    public AuthUserDetails saveNewUser(CouzyUser couzyUser) {
        User userToSave = User.builder().email(couzyUser.getEmail())
                .password(couzyUser.getPassword()).userName(couzyUser.getUserName())
                .active(true).role("ROLE_USER").build();
        User savedUser = userRepo.save(userToSave);

        return makeFreshUser(savedUser);
    }
}