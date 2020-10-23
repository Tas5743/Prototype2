package com.darksideoftherainbow.service;

import com.darksideoftherainbow.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> getAlbums();

    Album addAlbum(String albumName, String albumArtist, String albumRelease, String albumGenre, int albumTracks, String albumPrice);

    List<Album> findAllFilteredAlbums(String filter);

    Album findAlbumById(Long albumId);

    Album editAlbum(Long albumId, String albumName, String albumArtist, String albumRelease, String albumGenre, int albumTracks, String albumPrice);

    boolean deleteAlbumById(Long albumId);
}
