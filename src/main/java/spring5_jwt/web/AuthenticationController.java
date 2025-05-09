package spring5_jwt.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring5_jwt.security.JwtService;
import spring5_jwt.security.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        UserDetails user = userDetailsService.loadUserByUsername(request.login());
        String jwtToken = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }
}

record AuthenticationRequest(String login, String password) {}
record AuthenticationResponse(String token) {}