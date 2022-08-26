//package study.datajpa.entity;
//
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Table(name = "orders")
//@Getter @Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Entity
//public class Order2 {
//    @Id @GeneratedValue
//    @Column(name = "order_id")
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;
//
//    @OneToMany(mappedBy ="order2", cascade = CascadeType.ALL)
//    private List<OrderI>
//}
