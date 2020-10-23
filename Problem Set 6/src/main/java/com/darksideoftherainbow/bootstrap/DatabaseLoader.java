package com.darksideoftherainbow.bootstrap;

import com.darksideoftherainbow.model.ApplicationUser;
import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.repository.ApplicationUserRepository;
import com.darksideoftherainbow.repository.AlbumRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    //
    //  instance data
    // instance managed by spring!
    private final AlbumRepository albumRepository;
    private final ApplicationUserRepository applicationUserRepository;

    public DatabaseLoader(AlbumRepository albumRepository, ApplicationUserRepository applicationUserRepository) {

        // injected by constructor!
        this.albumRepository = albumRepository;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("This will run when Spring starts!");

        //
        //  Initialize the database

        // (ADD ALBUMS)
        this.albumRepository.addAlbum(new Album("Vertigo", "EDEN","Jan 19,2018", "Indie Pop", 13, 9.99));
        this.albumRepository.addAlbum(new Album("Dreams", "Laura Brehm","June 15,2010", "Indie Pop", 10, 4.99));
        this.albumRepository.addAlbum(new Album("Bounce Into The Music", "SIAMES","August 2,2016", "Alternative/Indie", 10, 7.99));
        this.albumRepository.addAlbum(new Album("Sincerely", "Stephen","May 10,2016", "Alternative/Indie", 10, 3.99));
        this.albumRepository.addAlbum(new Album("Scorpion", "Drake","June 29,2018", "Hip-Hop/Rap", 25, 13.99));

        // (ADD USERS)
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        ApplicationUser user1 = new ApplicationUser("admin", encoder.encode("secretpassword"), true);
        ApplicationUser user2 = new ApplicationUser("fred", encoder.encode("123456"), false);
        this.applicationUserRepository.addUser(user1);
        this.applicationUserRepository.addUser(user2);
    }
}
