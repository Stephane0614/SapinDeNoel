package Simplon.SapinNoel.repository;

import Simplon.SapinNoel.Entity.Decoration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecoRepo extends CrudRepository<Decoration, Long> {

}
