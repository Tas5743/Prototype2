package com.darksideoftherainbow.controller;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {

    private final AlbumService albumService;

    //
    //  constructor injection!
    public IndexController(AlbumService albumService) {

        // by spring via the constructor!
        this.albumService = albumService;
    }

    @GetMapping("/")
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        return "index";
    }

    @GetMapping("/search")
    public String indexFiltered(Model model, @RequestParam("term") String term) {
        List<Album> albums = albumService.findAllFilteredAlbums(term);
        model.addAttribute("albums", albums);
        return "index";
    }

    @GetMapping("/success")
    public String indexWithSuccess(Model model) {
        List<Album> album = albumService.getAlbums();
        model.addAttribute("albums", album);
        model.addAttribute("success", "Your changes were successfully saved.");
        return "index";
    }

    @GetMapping("/albums/delete/{albumId}")
    public String deleteAlbum(@PathVariable Long albumId) {
        albumService.deleteAlbumById(albumId);
        return "redirect:/";
    }

}
