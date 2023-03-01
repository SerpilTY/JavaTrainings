package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;


@Table(name="brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="name")
    private String name;

}
