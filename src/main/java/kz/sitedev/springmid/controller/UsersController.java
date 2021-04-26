package kz.sitedev.springmid.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.repository.RoleRepository;
import kz.sitedev.springmid.service.SphereService;
import kz.sitedev.springmid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Api
public class UsersController {
    @Autowired
    UserService userService;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("")
   public List<User> all(){
        return userService.getAll();
    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user) {
        user.setRoles(Arrays.asList(roleRepository.findFirstByName("USER")));
        userService.create(user);
        Long now = System.currentTimeMillis();
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                // Convert to list of strings.
                // This is important because it affects the way we get them back in the Gateway.
                .claim("authorities", user.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 60*60 * 1000))  // in milliseconds
                .signWith(SignatureAlgorithm.HS512, "secret-key".getBytes())
                .compact();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization",
                "Bearer " + token);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(user);
    }

    @GetMapping("/find/job/{id}")
    public List<User> getUsersByJob(Long jobId) {
        return userService.getUsersByJob(jobId);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id,
                       @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
