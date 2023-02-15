package dat3.relations.repositories;

import dat3.relations.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
  List<Citizen> findAllByTownId(int id);
  List<Citizen> findAllByTownName(String name);

}
