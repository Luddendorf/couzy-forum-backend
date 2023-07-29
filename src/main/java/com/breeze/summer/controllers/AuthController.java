package com.breeze.summer.controllers;

import com.breeze.summer.models.AuthRequest;
import com.breeze.summer.utils.log.Loggable;
import org.springframework.http.HttpStatus;
//import com.breeze.summer.services.AuthUserDetailsService;
//import com.breeze.summer.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller to handle JWT Auth endpoints
@RestController
@RequestMapping("auth")
@Loggable
// @RequiredArgsConstructor
public class AuthController {

    // private Logger logger;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> signin(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println("Received request to sign in: " + authRequest.toString());
        return ResponseEntity.status(HttpStatus.OK)
                .body("You have successfully logged in!");
    }
    /*
     * private AuthenticationManager authenticationManager;
     * private AuthUserDetailsService authUserDetailsService;
     * private JwtUtil jwtUtil;
     * 
     * public AuthController(AuthenticationManager authenticationManager,
     * AuthUserDetailsService authUserDetailsService, JwtUtil jwtUtil) {
     * this.authenticationManager = authenticationManager;
     * this.authUserDetailsService = authUserDetailsService;
     * this.jwtUtil = jwtUtil;
     * }
     * 
     * @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
     * public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest
     * authRequest) throws Exception {
     * try {
     * String username = authRequest.getUsername();
     * String password = authRequest.getPassword();
     * Authentication authentication = authenticationManager.authenticate(
     * new UsernamePasswordAuthenticationToken(username, password)
     * );
     * SecurityContextHolder.getContext().setAuthentication(authentication);
     * } catch (BadCredentialsException e) {
     * throw new Exception("Incorrect Username or Password", e);
     * }
     * 
     * final UserDetails userDetails =
     * authUserDetailsService.loadUserByUsername(authRequest.getUsername());
     * 
     * final String jwt = jwtUtil.generateToken(userDetails);
     * 
     * return ResponseEntity.ok(new AuthResponse(jwt));
     * }
     */
}
