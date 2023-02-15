package dat3.relations.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Town {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;


  @Column(unique = true)
  String name;
  String mayor;
  int schools;


}
