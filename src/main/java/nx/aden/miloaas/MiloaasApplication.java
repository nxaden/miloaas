package nx.aden.miloaas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nx.aden.miloaas.domain.MiloPhoto;
import nx.aden.miloaas.repository.PhotoRepository;

@SpringBootApplication
public class MiloaasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiloaasApplication.class, args);
    }

    @Bean
    CommandLineRunner seedPhotos(PhotoRepository photoRepository) {
        return args -> {
            if (photoRepository.count() == 0) {
                photoRepository.save(new MiloPhoto(
                    "https://example.com/milo/1.jpg",
                    "Milo staring at the camera"
                ));
                photoRepository.save(new MiloPhoto(
                    "https://example.com/milo/2.jpg",
                    "Sleepy Milo on the couch"
                ));
            }
        };
    }

}
