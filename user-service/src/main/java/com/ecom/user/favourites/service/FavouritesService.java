package com.ecom.user.favourites.service;

import com.ecom.user.favourites.api.dto.FavouritesDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface FavouritesService {

    List<FavouritesDTO> findByUserId(UUID userId);

    List<FavouritesDTO> findByProductId(UUID productId);

    void createFavourite(FavouritesDTO createDTO, UUID userId);

    void deleteFavourite(UUID userId, UUID productId);

}
