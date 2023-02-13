package dat3.relations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Citizen {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  String firstName;
  String lastName;
  String email;
  String phone;



}
