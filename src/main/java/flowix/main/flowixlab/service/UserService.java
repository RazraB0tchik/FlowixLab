package flowix.main.flowixlab.service;

import flowix.main.flowixlab.entity.Admin;
import flowix.main.flowixlab.entity.UserDetailElementAd;
import flowix.main.flowixlab.exceptions.TelegramIdNotFoundException;
import flowix.main.flowixlab.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserDetailElementAd userDetailElementAd;

    private Collection<GrantedAuthority> authorities;

    public UserService(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Admin admin = adminRepository.findAdminByUsername(username);
        authorities.add(new SimpleGrantedAuthority(admin.getRole()));
        return new UserDetailElementAd(admin.getUsername(), admin.getPassword(), authorities, admin.getActive());
    }

    public Admin loadUserByTelegramId(String telegramId) throws UsernameNotFoundException {
        Admin admin = adminRepository.findAdminByTelegramId(telegramId);
        if(admin == null){
            throw new UsernameNotFoundException("User with telegram_id - " + telegramId + " not found!");
        }
        else{
            return admin;
        }
    }

}
