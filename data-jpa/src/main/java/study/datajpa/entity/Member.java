package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter@Setter
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String name;

    protected Member(){}

    public Member(String name){
        this.name = name;
    }
}
