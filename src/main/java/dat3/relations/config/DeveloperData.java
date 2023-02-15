package dat3.relations.config;

import dat3.relations.entity.Address;
import dat3.relations.entity.Citizen;
import dat3.relations.entity.Town;
import dat3.relations.repositories.AddressRepository;
import dat3.relations.repositories.CitizenRepository;
import dat3.relations.repositories.TownRepository;
import dat3.relations.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

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
  public void run(ApplicationArguments args) throws IOException {
    //step6();
    //step9();
    step9WithService();
    //step10();
  }

//  @Autowired
//  EntityManager entityManager;
  private void step10(){
    System.out.println("------- Step 10 ------------");
    Town town1 = Town.builder().name("Lyngby").mayor("borgmester A").schools(45).build();
    Town town2 = Town.builder().name("Odense").mayor("borgmester B").schools(65).build();
    townRepository.saveAndFlush(town1);
    townRepository.saveAndFlush(town2);

    a1 = new Address("Lyngbyvej 1", "Lyngby", "2800");
    Citizen citizen1 = Citizen.builder().firstName("Kurt").lastName("Wonnegut").build();
    Citizen citizen2 = Citizen.builder().firstName("Hanne").lastName("Wonnegut").build();
    a1.addCitizen(citizen1);
    a1.addCitizen(citizen2);
    citizen1.setTown(town1);
    citizen2.setTown(town1);
    addressRepository.save(a1);//Save the address

    List<Citizen> citizensInLyngby = citizenRepository.findAllByTownName("Lyngby");
    List<Citizen> citizensInOdense = citizenRepository.findAllByTownName("Odense");
    System.out.println("ByName --> (Lyngby , Odense) :"+citizensInLyngby.size() +", " +citizensInOdense.size());

    citizensInLyngby = citizenRepository.findAllByTownId(town1.getId());
    citizensInOdense = citizenRepository.findAllByTownId(town2.getId());
    System.out.println("By ID ---> (Lyngby , Odense) :"+citizensInLyngby.size() +", " +citizensInOdense.size());

  }


  @Autowired
  AddressService addressService;

  private void step9WithService() {
    step6();
    addressService.printFullAddressInfo(a1.getId(),true);
  }

  Address a1;
  public void step6()  {
    System.out.println("------- Step 6 ------------");

    a1 = new Address("Lyngbyvej 1", "Lyngby", "2800");
    Citizen citizen1 = Citizen.builder().firstName("Kurt").lastName("Wonnegut").build();
    Citizen citizen2 = Citizen.builder().firstName("Hanne").lastName("Wonnegut").build();
    a1.addCitizen(citizen1);
    a1.addCitizen(citizen2);
    addressRepository.save(a1);//Save the address
  }

  private void step9() throws IOException {
    step6();
    System.out.println("------- Select statements starts here ------------");
    Address address_1 = addressRepository.findById(a1.getId()).get();
    System.out.println(address_1.getStreet());
    System.out.println("Press Enter to continue");


    System.in.read();  //This will block so you have time to read the DEBUG statements
    System.out.println("Citizens: "+address_1.getCitizens().size());

  }


}
