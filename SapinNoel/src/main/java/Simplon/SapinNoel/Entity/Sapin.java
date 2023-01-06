package Simplon.SapinNoel.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor  @AllArgsConstructor @Builder
public class Sapin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToMany
    public List<Decoration>  decoration;
    boolean vendu;
    int prixTotalDeco ;
    int poidsTotalDeco ;

    }


