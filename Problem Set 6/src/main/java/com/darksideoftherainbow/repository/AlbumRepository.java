package com.darksideoftherainbow.repository;

import com.darksideoftherainbow.model.Album;

import java.util.List;

public interface AlbumRepository {
    List<Album> getAlbums();

    Album addAlbum(Album album);

    Album findAlbumById(Long albumId);

    Album editAlbum(Long albumId, String albumName, String albumArtist, String albumRelease, String albumGenre, int albumTracks,String albumPrice);

    boolean deleteAlbumById(Long albumId);
}
