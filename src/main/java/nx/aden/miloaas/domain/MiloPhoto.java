package nx.aden.miloaas.domain;

import jakarta.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "milo_photos")
public class MiloPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    @Column(length = 500)
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public MiloPhoto() {}

    public MiloPhoto(String url, String description) {
        this.url = url;
        this.description = description;
        this.createdAt = Instant.now();
    }

    public Long getId() { return id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
