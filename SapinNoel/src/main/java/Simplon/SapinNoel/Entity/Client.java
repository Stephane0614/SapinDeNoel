package Simplon.SapinNoel.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter  @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String clientName;
    private String clientAddress;

}
