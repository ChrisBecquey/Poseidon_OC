package com.nnk.springboot.configuration;

import com.nnk.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Charge les détails de l'utilisateur à partir du nom d'utilisateur fourni.
     *
     * @param username Le nom d'utilisateur de l'utilisateur dont les détails doivent être chargés.
     * @return Les détails de l'utilisateur correspondant au nom d'utilisateur spécifié.
     * @throws UsernameNotFoundException Si aucun utilisateur correspondant au nom d'utilisateur spécifié n'est trouvé.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
    }

}
