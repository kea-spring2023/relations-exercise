package dat3.relations.config;

import dat3.relations.entity.Address;
import dat3.relations.entity.Citizen;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DeveloperData implements ApplicationRunner {


  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("Called");
  }


}
