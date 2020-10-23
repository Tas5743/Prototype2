package com.darksideoftherainbow.service.impl;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.repository.AlbumRepository;
import com.darksideoftherainbow.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    // managed by spring!
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAlbums() {
        return albumRepository.getAlbums();
    }

    @Override
    public Album addAlbum(String albumName, String albumArtist, String albumRelease, String albumGenre, int albumTracks, String albumPrice) {

        //
        //  validation
        if (albumName == null || albumName.isEmpty()) {
            throw new IllegalArgumentException("game name cannot be null");
        }
        Double price;
        try {
            price = Double.valueOf(albumPrice);
        } catch (NumberFormatException nfex) {
            throw new IllegalArgumentException("invalid game price");
        }

//        //  test if null/empty
        Album album = new Album(albumName, albumArtist, albumRelease,albumGenre,albumTracks, price);
        return albumRepository.addAlbum(album);
    }

    @Override
    public List<Album> findAllFilteredAlbums(String filter) {

        List<Album> allAlbums = albumRepository.getAlbums();
        return allAlbums.stream()
                .filter(g -> g.getAlbumName().toLowerCase().contains(filter))
                .collect(Collectors.toList());
    }

    @Override
    public Album findAlbumById(Long albumId) {
        return albumRepository.findAlbumById(albumId);
    }

    @Override
    public Album editAlbum(Long albumId, String albumName, String albumArtist, String albumRelease, String albumGenre, int albumTracks, String albumPrice) {
        return albumRepository.editAlbum(albumId, albumName, albumArtist, albumRelease, albumGenre, albumTracks, albumPrice);
    }

    @Override
    public boolean deleteAlbumById(Long albumId) {
        return albumRepository.deleteAlbumById(albumId);
    }
}
