package com.etix.web.controller.auth;

import com.etix.web.model.UploadFileModel;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@CrossOrigin("http://localhost:4200")
@CrossOrigin
public class AuthController {

    @GetMapping(value = "/ping")
    public ResponseEntity ping() {
        return new ResponseEntity("PING", HttpStatus.OK);
    }

    @GetMapping(value = "/pong")
    public ResponseEntity pong() {
        return new ResponseEntity("PONG", HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody UploadFileModel data) {

        return new ResponseEntity("saved", HttpStatus.OK);
    }
}
