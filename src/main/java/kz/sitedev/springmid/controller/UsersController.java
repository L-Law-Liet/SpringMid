package kz.sitedev.springmid.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.repository.RoleRepository;
import kz.sitedev.springmid.service.JobService;
import kz.sitedev.springmid.service.SphereService;
import kz.sitedev.springmid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Api
public class UsersController {
    @Autowired
    UserService userService;

    @Autowired
    JobService jobService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("")
   public List<User> all(){
        return userService.getAll();
    }

    @PostMapping("/register")
    public ResponseEntity create(@Valid @RequestBody User user) {
        String role = "company";
        if (user.getPhone() != null){
            role = "applicant";
        }

        user.setRoles(Arrays.asList(roleRepository.findFirstByName(role)));
        try {
            if (userService.getByUsername(user.getUsername()) == null){
                userService.create(user);
            }
            else {
                return ResponseEntity.badRequest()
                        .body("User already exist");
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
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

        responseHeaders.add("Access-Control-Expose-Headers", "Authorization");
        responseHeaders.add("Authorization",
                "Bearer " + token);
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(user);

    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id,
                       @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }
    @GetMapping("/fav/add/{id}")
    public User addFav(@RequestHeader Map<String, String> headers,
                       @PathVariable String id) {
        Claims body = Jwts.parser()
                .setSigningKey("secret-key".getBytes())
                .parseClaimsJws(headers.get("authorization").substring(7))
                .getBody();
        User user = userService.getByUsername(body.getSubject());
        System.out.println(user.toString());
        Job job = jobService.find(Long.parseLong(id));
        System.out.println(job.toString());
        user.getJobs().add(job);
        System.out.println(user.toString());
        return userService.update(user);
    }

    @GetMapping("/fav/remove/{id}")
    public User rmFav(@RequestHeader Map<String, String> headers,
                       @PathVariable String id) {
        Claims body = Jwts.parser()
                .setSigningKey("secret-key".getBytes())
                .parseClaimsJws(headers.get("authorization").substring(7))
                .getBody();
        User user = userService.getByUsername(body.getSubject());
        user.getJobs().remove(jobService.find(Long.parseLong(id)));
        return userService.update(user);
    }
    @GetMapping("/token")
    public ResponseEntity listAllHeaders(
            @RequestHeader Map<String, String> headers) {
//        return ResponseEntity.ok().body(headers.get("authorization"));
        System.out.println(headers.get("authorization").substring(7));
        Claims body = Jwts.parser()
                .setSigningKey("secret-key".getBytes())
                .parseClaimsJws(headers.get("authorization").substring(7))
                .getBody();
        System.out.println(body);
        return ResponseEntity.ok().body(userService.getByUsername(body.getSubject()));
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
