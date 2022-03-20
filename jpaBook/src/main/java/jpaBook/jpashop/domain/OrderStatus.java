package jpaBook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderStatus {
    @Id
    @GeneratedValue
    private Long id;
    private Long memberId;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
