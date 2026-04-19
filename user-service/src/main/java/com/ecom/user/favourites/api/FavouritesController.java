package com.ecom.user.favourites.api;

import com.ecom.user.favourites.api.dto.FavouritesDTO;
import com.ecom.user.favourites.service.FavouritesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Favourites")
@RequestMapping("/favourites")
@AllArgsConstructor
public class FavouritesController {

    private FavouritesService service;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FavouritesDTO>> getByUserId(@RequestHeader("x-user-id") UUID userId){
        return new ResponseEntity<>(service.findByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<FavouritesDTO>> getByProductId(@PathVariable UUID productId){
        return new ResponseEntity<>(service.findByProductId(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createFavourite(@RequestHeader("x-user-id") UUID userId,
                                                @RequestBody FavouritesDTO createDTO){
        service.createFavourite(createDTO, userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{productId}")
    public ResponseEntity<Void> deleteFavourite(@PathVariable UUID userId,
                                                @PathVariable UUID productId) {
        service.deleteFavourite(userId, productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
