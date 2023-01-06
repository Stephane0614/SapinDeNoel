package Simplon.SapinNoel.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
public class BonDeCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;
    @ManyToOne
    @JoinColumn(name = "sapin_id")
    Sapin sapin;
    int coutTotal;
    int  poidsTotal;

    public BonDeCommande( Client client, Sapin sapin, int coutTotal, int poidsTotal) {
        this.client = client;
        this.sapin = sapin;
        this.coutTotal = coutTotal;
        this.poidsTotal = poidsTotal;
    }

    @Override
    public String toString() {
        return "BonDeCommande{" +
                "client = " + client.getClientName() +
                ", adresse = " + client.getClientAddress() +
                ", poidsTotal= " + poidsTotal + "kg" +
                ", coutTotal commande = " + coutTotal + "€ " + "}";
    }
}
