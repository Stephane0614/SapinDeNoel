package Simplon.SapinNoel.Controller;

import Simplon.SapinNoel.Entity.BonDeCommande;
import Simplon.SapinNoel.Entity.Client;
import Simplon.SapinNoel.Entity.Sapin;
import Simplon.SapinNoel.repository.BDComRepo;
import Simplon.SapinNoel.repository.ClientRepo;
import Simplon.SapinNoel.repository.DecoRepo;
import Simplon.SapinNoel.repository.SapinRepo;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Getter  @Setter
@RequestMapping(path = "sapin")
@AllArgsConstructor @NoArgsConstructor @Builder
public class BdcCOntroller {
    @Autowired
    BDComRepo BDComRepository;
    @Autowired
    SapinRepo sapinRepository;
    @Autowired
    ClientRepo clientRepository;

    @PostMapping(path = "vente")
    public String vente(@RequestParam Long sapinId, @RequestParam Long clientId) {
       // Condition de sortie direct
        if (sapinRepository.findById(sapinId).isEmpty()) return null;
        // Recuperation sapin by ID
        Optional<Sapin> OptionalSapin = sapinRepository.findById(sapinId);
        Sapin sapin = OptionalSapin.get();
        // deuxieme condition de sortie
        if(sapin.isVendu()) return null;
        sapin.setVendu(true);
        // retire le sapin de la vente  en bdd
        sapinRepository.save(sapin);
        // Recuperation client By ID
        Optional<Client> OptionalClient = clientRepository.findById(clientId);
         Client client = OptionalClient.get();
         // recupère les prix et poids  totale
        int coutT= sapin.getPrixTotalDeco();
        int poidsT= sapin.getPoidsTotalDeco();
        // initialise le bon de commande
        BonDeCommande bonDeCommande = new BonDeCommande( client, sapin,coutT, poidsT);
        //sauvegarde en bdd
        BDComRepository.save(bonDeCommande);
        return  bonDeCommande.toString();
    }

    @GetMapping(path = "getBonDeCommande")
    public String getBonDeCommande(@RequestParam Long bonDeCommandeID)
    {
        if (BDComRepository.findById(bonDeCommandeID).isEmpty()) return null;
        BonDeCommande bonDeCommande =  BDComRepository.findById(bonDeCommandeID).get();
        return  bonDeCommande.toString();

    }




}
