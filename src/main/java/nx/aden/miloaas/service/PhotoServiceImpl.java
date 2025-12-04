package nx.aden.miloaas.service;

import nx.aden.miloaas.domain.MiloPhoto;
import nx.aden.miloaas.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public List<MiloPhoto> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public Optional<MiloPhoto> findById(Long id) {
        return photoRepository.findById(id);
    }

    @Override
    public Optional<MiloPhoto> findRandom() {
        List<MiloPhoto> all = photoRepository.findAll();
        if (all.isEmpty()) {
            return Optional.empty();
        }

        int randomIndex = ThreadLocalRandom.current().nextInt(all.size());
        return Optional.of(all.get(randomIndex));
    }
}
