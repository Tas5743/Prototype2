package com.darksideoftherainbow.model;

import javax.persistence.*;

@Entity
public class Album {

    //
    //  instance data
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_seq")
    @SequenceGenerator(name = "album_id_seq", sequenceName = "album_id_seq", allocationSize = 100)
    private Long albumId;
    private String albumName;
    private String albumArtist;
    private String albumRelease;
    private String albumGenre;
    private int albumTracks;
    private Double albumPrice;

    public Album() {
    }

    public Album(String albumName, String albumArtist, String albumRelease, String albumGenre, int albumTracks, Double albumPrice) {
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.albumRelease = albumRelease;
        this.albumGenre = albumGenre;
        this.albumTracks = albumTracks;
        this.albumPrice = albumPrice;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public String getAlbumRelease() {
        return albumRelease;
    }

    public void setAlbumRelease(String albumRelease) {
        this.albumRelease = albumRelease;
    }

    public String getAlbumGenre() {
        return albumGenre;
    }

    public void setAlbumGenre(String albumGenre) {
        this.albumGenre = albumGenre;
    }

    public int getAlbumTracks() {
        return albumTracks;
    }

    public void setAlbumTrack(int albumTracks) {
        this.albumTracks = albumTracks;
    }

    public Double getAlbumPrice() {
        return albumPrice;
    }

    public void setAlbumPrice(Double albumPrice) {
        this.albumPrice = albumPrice;
    }
}
