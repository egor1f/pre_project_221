package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "carUser")
public class Car {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "model")
   private String model;

   @Column(name = "series")
   private int series;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "userCar")
   private User user;
   public Car() {}

   public Car(String model, int series) {
      this.model = model;
      this.series = series;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public int getSeries() {
      return series;
   }

   public void setSeries(int series) {
      this.series = series;
   }

   @Override
   public String toString() {
      return "model='" + model + '\'' +
              ", series=" + series +
              '}';
   }
}
