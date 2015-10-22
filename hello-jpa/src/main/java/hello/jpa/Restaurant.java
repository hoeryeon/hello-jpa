package hello.jpa;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 1002016 on 2015. 10. 22..
 */
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private String Id;
    private String name;

    @Column(name = "MAX_NUMBER_PEOPLE")
    private int maxNumberOfPeople;

//    @OneToMany(mappedBy = "reservation")
//    private List<Reservation> reservationList;

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
