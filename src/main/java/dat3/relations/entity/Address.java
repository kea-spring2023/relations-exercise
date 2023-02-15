package dat3.relations.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String street;
  private String zip;
  private String city;

  public Address(String street, String city, String zip) {
    this.street = street;
    this.zip = zip;
    this.city = city;
  }

  @OneToMany(mappedBy = "address", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  private List<Citizen> citizens;

  public void addCitizen(Citizen citizen) {
    if(citizens==null) {
      citizens = new ArrayList<>();
    }
    citizens.add(citizen);
    citizen.setAddress(this);

  }
}
