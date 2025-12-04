package nx.aden.miloaas.repository;

import nx.aden.miloaas.domain.MiloPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<MiloPhoto, Long> {
    // extra queries later
}