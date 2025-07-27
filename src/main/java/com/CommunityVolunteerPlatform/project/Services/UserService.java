package com.CommunityVolunteerPlatform.project.Services;


/*

import com.LoginApi.CVP.Entity.User;
import com.LoginApi.CVP.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ This is the method used by Spring Security during login
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException("User not found");

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(), // account enabled
                true,             // account not expired
                true,             // credentials not expired
                true,             // account not locked
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }

    // ⭐ Already existing methods below
    public void register(User user) {
        String otp = UUID.randomUUID().toString().substring(0, 6);
        user.setOtp(otp);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        userRepository.save(user);
        emailService.sendOtp(user.getEmail(), otp);
    }

    public boolean verifyOtp(String email, String otp) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getOtp().equals(otp)) {
            user.setEnabled(true);
            user.setOtp(null);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        }
    }

    public void deleteAccount(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            userRepository.deleteByEmail(user);
        }
    }
}








*/















//below is working code if above creates any error with register and reset pass and forget pass functionalities


import com.CommunityVolunteerPlatform.project.Entity.User;
import com.CommunityVolunteerPlatform.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(User user) {
        String otp = UUID.randomUUID().toString().substring(0, 6);
        user.setOtp(otp);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        userRepository.save(user);
        emailService.sendOtp(user.getEmail(), otp);
    }

    public boolean verifyOtp(String email, String otp) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getOtp().equals(otp)) {
            user.setEnabled(true);
            user.setOtp(null);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        }
    }

    public void deleteAccount(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            userRepository.deleteByEmail(user);
        }
    }


}
