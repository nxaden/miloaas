package nx.aden.miloaas.controller;

import nx.aden.miloaas.domain.MiloPhoto;
import nx.aden.miloaas.service.PhotoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/photos")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public List<MiloPhoto> getAllPhotos() {
        return photoService.getAllPhotos();
    }
}