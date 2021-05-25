package kz.sitedev.springmid.config;

import com.google.common.collect.ImmutableList;
import kz.sitedev.springmid.filter.JwtTokenAuthenticationFilter;
import kz.sitedev.springmid.filter.JwtTokenGeneratorFilter;
import kz.sitedev.springmid.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserServiceImpl userService;

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/users/register").permitAll()
                .antMatchers("/jobs").permitAll()
                .antMatchers(HttpMethod.POST, "/jobs").hasAuthority("company")
                .antMatchers("/spheres").permitAll()
                .antMatchers("/users").permitAll()
                .antMatchers("/cities").permitAll()
                .antMatchers("/types").permitAll()
                .antMatchers("/users/delete/{id}").hasAuthority("admin")
                .antMatchers(HttpMethod.POST, "/spheres/{id}").hasAuthority("admin")
                .antMatchers(HttpMethod.POST, "/cvs").hasAuthority("applicant")
                .antMatchers(HttpMethod.POST, "/subs").hasAuthority("applicant")
                .antMatchers(HttpMethod.DELETE, "/subs/{id}").hasAuthority("applicant")
                .antMatchers(HttpMethod.PUT, "/cvs/{id}").hasAuthority("applicant")
                .antMatchers(HttpMethod.DELETE, "/cvs/{id}").hasAuthority("applicant")
                .antMatchers(HttpMethod.PUT, "/jobs/cvs/{id}/cv").hasAuthority("applicant")
                .antMatchers(HttpMethod.PUT, "/users/fav/add/{id}").hasAuthority("applicant")
                .antMatchers(HttpMethod.PUT, "/users/fav/remove/{id}").hasAuthority("applicant")
                .antMatchers(HttpMethod.PUT, "/jobs/cvs/{id}/job").hasAuthority("company")
                .antMatchers(HttpMethod.POST, "/jobs").hasAuthority("company")
                .antMatchers(HttpMethod.PUT, "/jobs/{id}").hasAuthority("company")
                .antMatchers(HttpMethod.DELETE, "/jobs/{id}").hasAuthority("company")
                .anyRequest().authenticated()
//                .and().formLogin()
                .and()
                // What's the authenticationManager()?
                // An object provided by WebSecurityConfigurerAdapter, used to authenticate the user passing user's credentials
                // The filter needs this auth manager to authenticate the user.
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))

                // Add a filter to validate the tokens with every request
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(ImmutableList.of("*"));
        configuration.setAllowedMethods(ImmutableList.of("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
//        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(ImmutableList.of(
                "Authorization",
                "Cache-Control",
                "Content-Type"
        ));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
