package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.dto.EmailDTO;
import br.com.geovanejunior.cursomc.security.JWTUtil;
import br.com.geovanejunior.cursomc.security.UserSS;
import br.com.geovanejunior.cursomc.service.AuthService;
import br.com.geovanejunior.cursomc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value="/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @PostMapping(value="/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value="/forgot")
    public ResponseEntity<Void> forgotPassword(@RequestBody @Valid EmailDTO emailDTO) {

        authService.sendNewPassword(emailDTO.getEmail());
        return ResponseEntity.noContent().build();
    }
}
