package dat3.relations.config;

import dat3.relations.repositories.AddressRepository;
import dat3.relations.repositories.CitizenRepository;
import dat3.relations.repositories.TownRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DeveloperData implements ApplicationRunner {

  TownRepository townRepository;
  AddressRepository addressRepository;
  CitizenRepository citizenRepository;

  public DeveloperData(TownRepository townRepository, AddressRepository addressRepository, CitizenRepository citizenRepository) {
    this.townRepository = townRepository;
    this.addressRepository = addressRepository;
    this.citizenRepository = citizenRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("Called");
  }

}
