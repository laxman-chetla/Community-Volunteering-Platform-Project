package com.CommunityVolunteerPlatform.project.Services;



import com.CommunityVolunteerPlatform.project.Entity.User;
import com.CommunityVolunteerPlatform.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Load user for Spring Security login
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Convert role to uppercase to maintain consistency (e.g., volunteer becomes VOLUNTEER)
        // Spring Security's builder adds the ROLE_ prefix automatically.
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().toUpperCase())
                .disabled(!user.isEnabled())
                .build();
    }
}
