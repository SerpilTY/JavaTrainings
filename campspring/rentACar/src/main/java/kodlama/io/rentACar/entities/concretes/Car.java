package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;


@Table(name="cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="plate", unique=true)
    private String plate;
    @Column(name="dailyprice")
    private double dailyPrice;
    @Column(name="modelyear")
    private int modelYear;
    @Column(name="state")
    private int state; //1. Available 2. Rented 3. Maintenance etc.
    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;

}
