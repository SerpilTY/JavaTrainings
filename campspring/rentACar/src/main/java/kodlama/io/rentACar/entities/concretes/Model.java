package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;


@Table(name="models")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

}
