package nx.aden.miloaas.service;

import nx.aden.miloaas.domain.MiloPhoto;

import java.util.List;
import java.util.Optional;

public interface PhotoService {

    List<MiloPhoto> findAll();

    Optional<MiloPhoto> findById(Long id);

    Optional<MiloPhoto> findRandom();
}
