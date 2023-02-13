package dat3.relations.repositories;


import dat3.relations.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepository extends JpaRepository<Town, Integer>{
}
