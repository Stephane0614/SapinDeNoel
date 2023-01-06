package Simplon.SapinNoel.repository;

import Simplon.SapinNoel.Entity.BonDeCommande;
import Simplon.SapinNoel.Entity.Sapin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface BDComRepo extends CrudRepository<BonDeCommande,Long> {
}
