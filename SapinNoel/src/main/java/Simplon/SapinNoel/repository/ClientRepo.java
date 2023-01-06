package Simplon.SapinNoel.repository;

import Simplon.SapinNoel.Entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client,Long> {
}
