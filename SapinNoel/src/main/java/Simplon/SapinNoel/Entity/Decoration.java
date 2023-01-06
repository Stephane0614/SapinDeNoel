package Simplon.SapinNoel.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Decoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private  String decorationName;
    private  int prixDeco;
    private int poidsDeco;
    private int stock;


}
