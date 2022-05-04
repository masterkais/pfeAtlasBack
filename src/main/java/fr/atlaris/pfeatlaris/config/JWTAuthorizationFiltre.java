package fr.atlaris.pfeatlaris.config;/*
package fr.byteCode.erp.config;

import fr.byteCode.erp.persistance.constants.SecurityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static fr.byteCode.erp.persistance.constants.SecurityConstant.HEADER_STRING;
import static fr.byteCode.erp.persistance.constants.SecurityConstant.TOKEN_PREFIX;

public class JWTAuthorizationFiltre extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //pr accepter tous les domains
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
        //pr autoriser les entetes
        response.addHeader("Access-Control-Allow-Headers",
                "Origin,Accept,X-Requested-With,Content-Type,"
                        + "Acess-Control-Request-Method,"
                        + "Acces-Control-Request-Headers,"
                        + "Authorization");
        //pr exposer les entetes
        response.addHeader("Access-Control-Expose-Headers",
                "Access-Control-Allow-Origin,"
                        + "Acess-Control-Allow-Credentials,Authorization");
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            String jwtToken = request.getHeader(HEADER_STRING);
            if (jwtToken == null || !jwtToken.startsWith(TOKEN_PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }
            Claims claims = Jwts.parser()
                    .setSigningKey(SecurityConstant.SECRET)
                    .parseClaimsJws(jwtToken.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String username = claims.getSubject();
            ArrayList<Map<String, String>> groups = (ArrayList<Map<String, String>>) claims.get("groups");
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            groups.forEach(r -> {
                authorities.add(new SimpleGrantedAuthority(r.get("authority")));
            });
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);
        }
    }
}
*/
