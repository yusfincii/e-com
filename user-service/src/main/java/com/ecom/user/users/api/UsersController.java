package com.ecom.user.users.api;

import com.ecom.user.users.api.dto.UsersRequestDTO;
import com.ecom.user.users.api.dto.UsersResponseDTO;
import com.ecom.user.users.api.dto.UsersUpdateRequestDTO;
import com.ecom.user.users.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "users")
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersResponseDTO>> getAllUsers(){
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDTO> getUserById(@PathVariable UUID id){
        return new ResponseEntity<>(usersService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsersResponseDTO> createUser(@Valid @RequestBody UsersRequestDTO usersDTO,
                                                       @RequestHeader(name = "created-by") UUID userId) {
        return new ResponseEntity<>(usersService.createUser(usersDTO, userId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersResponseDTO> updateUser(@PathVariable UUID id,
                                                       @Valid @RequestBody UsersUpdateRequestDTO usersDTO,
                                                       @RequestHeader("updated-by") UUID userId){
        return new ResponseEntity<>(usersService.updateUser(id, usersDTO, userId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id,
                                           @RequestHeader("deleted-by") UUID userId){
        usersService.deleteUser(id, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "is exist by user id")
    @GetMapping("/exist/{userId}")
    public ResponseEntity<Boolean> isExistUserById(@PathVariable UUID userId){
        return new ResponseEntity<>(usersService.isExistUserById(userId), HttpStatus.OK);
    }
}
