package keepingMemory.interfaces;


import keepingMemory.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UserController {

    @PostMapping(value = "/v1/keeping_memory//user/register")
    public HttpStatus register(@RequestBody User user){

        return HttpStatus.OK;
    }
    @GetMapping(value = "/v1/keeping_memory/user/login")
    public User login(@RequestBody UserDto loginCommand){
        return new User("a", "b", "asdf", 1L, LocalDateTime.now());
    }
}
