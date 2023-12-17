package softuni.restaurant.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration {

    private final UserDetailsService userDetailsService;

    public ApplicationSecurityConfiguration(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
    	AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
    	builder.userDetailsService(userDetailsService);
    	return builder.build();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.authorizeHttpRequests(authorize -> authorize
        		.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        		.requestMatchers("/terminal/categories/**", "/terminal/users/**", "/terminal/check-username", "/terminal/stats",
                        "/terminal/categories/**", "/terminal/items/**", "/terminal/products/**",
                        "/terminal/delete-on-schedule").hasRole("ADMIN")
                .requestMatchers("/terminal", "/terminal/order/**").hasAnyRole("EMPLOYEE", "ADMIN")
                .requestMatchers("/", "/items/foods", "/items/drinks", "/items/others",
                        "/users/login", "/users/register",
                        "/categories", "/contacts",
                        "/items", "/categories/cat/**").permitAll()
                .requestMatchers("/cart/**", "/order/**", "/order-place").authenticated())

                .formLogin(login -> login
	                .loginPage("/users/login")
	                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
	                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
	                .defaultSuccessUrl("/")
	                .failureForwardUrl("/users/login-error"))

                .logout(logout -> logout
	                .logoutUrl("/users/logout")
	                .logoutSuccessUrl("/")
	                .invalidateHttpSession(true)
	                .deleteCookies("JSESSIONID"));
        
        return http.build();
    }

}
