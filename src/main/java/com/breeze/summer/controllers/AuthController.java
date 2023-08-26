package com.breeze.summer.controllers;

import com.breeze.summer.dto.auth.AuthResponse;
import com.breeze.summer.dto.auth.CouzyUser;
import com.breeze.summer.models.AuthRequest;
import com.breeze.summer.utils.log.Loggable;
import org.springframework.http.HttpStatus;
import com.breeze.summer.services.AuthUserDetailsService;
import com.breeze.summer.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;

// Controller to handle JWT Auth endpoints
@RestController
@RequestMapping("auth")
@Loggable
@RequiredArgsConstructor
public class AuthController {

    private Logger log;
    private AuthenticationManager authenticationManager;
    private AuthUserDetailsService authUserDetailsService;
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody CouzyUser couzyUser) throws Exception {
        log.info("Received request to sign up: " + couzyUser.toString());

        // return ResponseEntity.status(HttpStatus.OK)
        // .body("You have successfully logged in!");

        final UserDetails userDetails = authUserDetailsService.saveNewUser(couzyUser);

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> signin(@RequestBody CouzyUser couzyUser) throws Exception {
        log.info("Received request to sign in: " + couzyUser.toString());
        try {
            String email = couzyUser.getEmail();
            String password = couzyUser.getPassword();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Email or Password", e);
        }

        final UserDetails userDetails = authUserDetailsService.loadUserByEmail(couzyUser.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    // @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    // public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest
    // authRequest) throws Exception {

    // }

}
