package com.antifraud.user.service.userdetails;

import com.antifraud.user.repository.IAppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IAppUserRepository iAppUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return iAppUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with email: " + email + ", was not found"
                ));
    }

}
