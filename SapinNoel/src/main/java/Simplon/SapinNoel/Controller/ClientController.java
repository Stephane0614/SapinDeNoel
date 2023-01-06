package Simplon.SapinNoel.Controller;

import Simplon.SapinNoel.Entity.Client;
import Simplon.SapinNoel.repository.ClientRepo;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter  @Setter
@RequestMapping(path = "client")
@AllArgsConstructor  @NoArgsConstructor  @Builder
public class ClientController {
    @Autowired
    ClientRepo clientRepo;

    @PostMapping(path = "creatClient")
    public Long creatClient(@RequestParam String clientName, @RequestParam String clientAdresse) {
        clientRepo.save(Client.builder().clientName(clientName).clientAddress(clientAdresse).build());
        return clientRepo.count();
    }
}

