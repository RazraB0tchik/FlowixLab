package flowix.main.flowixlab.api;

import flowix.main.flowixlab.DTO.AdminDTO;
import flowix.main.flowixlab.entity.Admin;
import flowix.main.flowixlab.entity.UserDetailElementAd;
import flowix.main.flowixlab.exceptions.TelegramIdNotFoundException;
import flowix.main.flowixlab.service.UserService;
import org.apache.tomcat.util.descriptor.web.ContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;

@RestController
public class AdminController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;



    @PostMapping(value = "/login")
    public ResponseEntity<String> loginUser(@RequestBody AdminDTO adminDTO){
            try {
                Admin admin = userService.loadUserByTelegramId(adminDTO.getTelegramId());
                System.out.println(admin.getActive());
                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getUsername(), adminDTO.getPassword()));
                System.out.println(authentication);
                return ResponseEntity.ok().body("Authentication successful!");
            }

            catch (Exception exception){
                return ResponseEntity.badRequest().body(exception.getMessage());
            }
    }

    @GetMapping(value = "/admin")
    public void getMain(Principal principal){
        System.out.println(principal);
    }

}
