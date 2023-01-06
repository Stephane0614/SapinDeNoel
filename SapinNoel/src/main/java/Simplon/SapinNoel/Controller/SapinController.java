package Simplon.SapinNoel.Controller;
import Simplon.SapinNoel.Entity.Decoration;
import Simplon.SapinNoel.Entity.Sapin;
import Simplon.SapinNoel.repository.DecoRepo;
import Simplon.SapinNoel.repository.SapinRepo;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Getter @Setter
@RequestMapping(path = "sapin")
 @AllArgsConstructor  @NoArgsConstructor @Builder
public class SapinController {
    @Autowired
    SapinRepo sapinRepository;
     @Autowired
    DecoRepo decoRepository;

    @GetMapping(path = "/get")
    public Optional<Sapin> getSapin(@RequestParam long sapinId) {
        if (sapinRepository.findById(sapinId).isEmpty() || sapinRepository.findById(sapinId).get().isVendu()) return Optional.empty();
        return sapinRepository.findById(sapinId);
    }
    @GetMapping(path = "/viewSapin")
    public Optional<Sapin> viewSapin(@RequestParam Long sapinId) {
        if (sapinRepository.findById(sapinId).isEmpty()) return Optional.empty();
        return sapinRepository.findById(sapinId);
    }
    @GetMapping(path = "/getDecoration")
    public Optional<Decoration> getDecoration(@RequestParam Long decorationId) {
        if (decoRepository.findById(decorationId).isEmpty()) return Optional.empty();
        return decoRepository.findById(decorationId);
    }
    @PostMapping(path = "create")
    public Long createSapin() {
        sapinRepository.save(new Sapin());
        return sapinRepository.count();
    }
    @PostMapping(path = "createDeco")
    public Long createDeco(@RequestParam String decoName, @RequestParam int decoPrix, @RequestParam int decoPoids, @RequestParam int stock) {
        decoRepository.save(Decoration.builder().decorationName(decoName).prixDeco(decoPrix).poidsDeco(decoPoids).stock(stock).build());
        return decoRepository.count();
    }
    @PostMapping(path = "addDecoration")
    public boolean addDecoration(@RequestParam Long decoId, @RequestParam Long sapinId, @RequestParam int nbrVouluDeDeco ) {
       if (sapinRepository.findById(sapinId).isEmpty() || decoRepository.findById(decoId).isEmpty())  return false;

       Optional<Sapin> OptionalSapin = sapinRepository.findById(sapinId);
       Optional<Decoration> OptionalDecoration = decoRepository.findById(decoId);

       Sapin sapin = OptionalSapin.get();
       if(sapin.isVendu()) return false;
       Decoration decoration = OptionalDecoration.get();
       if(decoration.getStock() == 0) return false;

       for (int i = 0; i < nbrVouluDeDeco; i++)
       {
           sapin.getDecoration().add(decoration);
          sapin.setPrixTotalDeco(sapin.getPrixTotalDeco() + decoration.getPrixDeco());
          sapin.setPoidsTotalDeco(sapin.getPoidsTotalDeco() + decoration.getPoidsDeco());
           decoration.setStock(decoration.getStock() - 1);
           sapinRepository.save(sapin);
       }

               return true;
    }
}







