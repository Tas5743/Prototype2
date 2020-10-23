package com.darksideoftherainbow.controller;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlbumController {

    //
    // auto-wired
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    /*
        Add album
     */

    @GetMapping("/admin/album/add")
    public String addAlbumForm(Model model) {
        return "addalbum";
    }

    @PostMapping("/admin/album/add")
    public String addAlbumSubmit(Model model, @RequestParam("albumName") String albumName, @RequestParam("albumArtist") String albumArtist,@RequestParam("albumRelease") String albumRelease,
                                 @RequestParam("albumGenre") String albumGenre,@RequestParam("albumTracks") int albumTracks,@RequestParam("albumPrice") String albumPrice) {

        //
        //  Add the album to the database
        try {
            this.albumService.addAlbum(albumName, albumArtist, albumRelease, albumGenre, albumTracks,albumPrice);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "addalbum";
        }

        model.addAttribute("success", "Your album was successfully added");
        return "redirect:/success";
    }

    /*
        Edit album
     */
    @GetMapping("/admin/albums/edit/{albumId}")
    public String editAlbumPage(@PathVariable Long albumId, Model model) {

        //
        //  find the album
        Album album = albumService.findAlbumById(albumId);

        //
        //  set the model
        model.addAttribute("albumId", album.getAlbumId());
        model.addAttribute("albumName", album.getAlbumName());
        model.addAttribute("albumArtist", album.getAlbumArtist());
        model.addAttribute("albumRelease", album.getAlbumRelease());
        model.addAttribute("albumGenre", album.getAlbumGenre());
        model.addAttribute("albumTracks", album.getAlbumTracks());
        model.addAttribute("albumPrice", album.getAlbumPrice());
        return "editalbum";
    }

    @PostMapping("/admin/albums/edit")
    public String editAlbumSubmit(@RequestParam Long albumId, @RequestParam String albumName, @RequestParam String albumArtist, @RequestParam String albumRelease,  @RequestParam String albumGenre,
                                  @RequestParam int albumTracks,@RequestParam String albumPrice, Model model) {

        //
        //  submit the form
        try {
            this.albumService.editAlbum(albumId, albumName, albumArtist, albumRelease, albumGenre, albumTracks, albumPrice);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
        }

        //
        //  success
        return "redirect:/success";
    }

}
