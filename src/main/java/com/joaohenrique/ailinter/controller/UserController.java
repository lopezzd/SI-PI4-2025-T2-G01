package com.joaohenrique.ailinter.controller;

import com.joaohenrique.ailinter.dto.UserRequestDTO;
import com.joaohenrique.ailinter.dto.UserResponseDTO;
import com.joaohenrique.ailinter.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable UUID id, @RequestBody @Valid UserRequestDTO dto) {
        UserResponseDTO newDto = service.updateUser(id, dto);
        return ResponseEntity.ok(newDto);
    }
}