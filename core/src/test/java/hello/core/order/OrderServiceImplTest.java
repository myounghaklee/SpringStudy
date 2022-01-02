package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository mr = new MemoryMemberRepository();
        mr.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl os = new OrderServiceImpl(new MemoryMemberRepository() , new FixDiscountPolicy());
        Order or = os.createOrrder(1L, "itemA", 10000);

        Assertions.assertThat(or.getDiscountPrice()).isEqualTo(1000);
    }

}