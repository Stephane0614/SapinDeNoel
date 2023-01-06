package Simplon.SapinNoel.repository;

import Simplon.SapinNoel.Entity.Sapin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SapinRepo extends CrudRepository<Sapin, Long> {

}
