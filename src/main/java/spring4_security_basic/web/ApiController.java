//package spring4_security_basic.web;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import spring4_security_basic.dto.UserRequestDto;
//
//
//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//public class ApiController {
//
//    @GetMapping("/public/hello")
//    public String publicHello() {
//        return "Hello Public!";
//    }
//
//    @GetMapping("/user/hello")
//    public String userHello() {
//        return "Hello User!";
//    }
//
//    @PostMapping("/user")
//    public String addUser(@RequestBody UserRequestDto userDto) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    }
//
//    @GetMapping("/admin/hello")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String adminHello() {
//        return "Hello Admin!";
//    }
//
//
//}
