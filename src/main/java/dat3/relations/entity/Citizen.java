package dat3.relations.entity;

import jakarta.persistence.*;
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
  Integer id;

  String firstName;
  String lastName;
  String email;
  String phone;

  @ManyToOne
  Address address;

  @ManyToOne//(cascade = CascadeType.ALL)
  Town town;


}
