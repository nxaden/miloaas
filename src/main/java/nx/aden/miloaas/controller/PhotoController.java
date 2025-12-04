package nx.aden.miloaas.controller;

import nx.aden.miloaas.domain.MiloPhoto;
import nx.aden.miloaas.dto.PhotoResponseDto;
import nx.aden.miloaas.service.PhotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/photos")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    // GET /api/v1/photos
    @GetMapping
    public List<PhotoResponseDto> getAllPhotos() {
        return photoService.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    // GET /api/v1/photos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<PhotoResponseDto> getPhotoById(@PathVariable Long id) {
        return photoService.findById(id)
                .map(photo -> ResponseEntity.ok(toDto(photo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET /api/v1/photos/random
    @GetMapping("/random")
    public ResponseEntity<PhotoResponseDto> getRandomPhoto() {
        return photoService.findRandom()
                .map(photo -> ResponseEntity.ok(toDto(photo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // --- mapping helper ---
    private PhotoResponseDto toDto(MiloPhoto photo) {
        return new PhotoResponseDto(
                photo.getId(),
                photo.getUrl()
        );
    }
}
