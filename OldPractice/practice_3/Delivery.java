package practice_3;

import jakarta.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    // 이렇게 잡음으로써 Order가 주인, Delivery가 양방향의 읽기 전용이 된다.
    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
