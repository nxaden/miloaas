package nx.aden.miloaas.service;

import nx.aden.miloaas.domain.MiloPhoto;
import nx.aden.miloaas.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public List<MiloPhoto> getAllPhotos() {
        return photoRepository.findAll();
    }
}
