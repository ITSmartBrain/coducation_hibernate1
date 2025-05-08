package spring5_jwt.web;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring5_jwt.dto.UserRequestDto;
import spring5_jwt.service.UserBookServiceImpl;


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
