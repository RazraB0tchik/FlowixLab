//package flowix.main.flowixlab.api;
//
//import flowix.main.flowixlab.DTO.AdminDTO;
//import flowix.main.flowixlab.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/reg")
//public class RegistrationAdmin {
//    @Autowired
//    UserService userService;
//
//    @PostMapping(value = "/registrationAdmin")
//    public ResponseEntity<String> registrationAdmin(@RequestBody AdminDTO adminDTO){
//        boolean status = userService.registrationAdmin(adminDTO.getLogin(), adminDTO.getPassword());
//        if (status) {
//            return ResponseEntity.ok().body("Registration completed successfully");
//        }
//        else
//            return ResponseEntity.badRequest().body("User with login: " + adminDTO.getLogin() + " exist");
//    }
//}
