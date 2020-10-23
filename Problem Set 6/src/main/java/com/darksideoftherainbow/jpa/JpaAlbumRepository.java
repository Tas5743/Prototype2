package com.darksideoftherainbow.jpa;

import com.darksideoftherainbow.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface JpaAlbumRepository extends CrudRepository<Album, Long> {
}
