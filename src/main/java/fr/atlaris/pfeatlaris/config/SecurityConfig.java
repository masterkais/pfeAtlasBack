package fr.atlaris.pfeatlaris.config;/*package fr.byteCode.erp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
*/
   // @Override
   // protected void configure(HttpSecurity http) throws Exception {
        // http.csrf().disable();
        // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // http.authorizeRequests().antMatchers( "/login/**","/swagger-ui.html#**").permitAll();
        // http.authorizeRequests().antMatchers( "/api/**/**").hasAuthority("ADMIN");
        // http.authorizeRequests().anyRequest().authenticated();
        // http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        // http.addFilterBefore(new JWTAuthorizationFiltre(), UsernamePasswordAuthenticationFilter.class);
//    }
//}
