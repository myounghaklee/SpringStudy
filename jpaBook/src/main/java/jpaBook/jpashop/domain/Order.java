package jpaBook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private Long memberId;
    private LocalDateTime orderDate;
    private orderStatus status;
}
