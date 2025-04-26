package spring4_security_basic.web;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring4_security_basic.dto.UserRequestDto;
import spring4_security_basic.service.UserBookServiceImpl;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final UserBookServiceImpl userService;

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello Public!";
    }

    @PostMapping("/public/user")
    public void addUser(@RequestBody UserRequestDto userDto) {
        userService.addUser(userDto);
    }

    @GetMapping("/user/hello")
    public String userHello() {
        return "Hello User!";
    }

    @GetMapping("/admin/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminHello() {
        return "Hello Admin!";
    }


}
