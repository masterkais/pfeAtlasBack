package fr.atlaris.pfeatlaris.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import fr.atlaris.pfeatlaris.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static fr.atlaris.pfeatlaris.constants.SecurityConstant.*;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        User user = null;
        try {
            user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("userName:" + user.getUserName());
        System.out.println("password:" + user.getPassword());
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword())
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        org.springframework.security.core.userdetails.User userSpring= (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
        String jwt= Jwts.builder()
                .setSubject(userSpring.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIMES))
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .claim("groups",userSpring.getAuthorities())
                .compact();
        response.addHeader(HEADER_STRING,TOKEN_PREFIX+jwt);
    }
}

