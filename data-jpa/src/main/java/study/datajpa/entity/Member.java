package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of= {"id", "username", "age"})
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String name){
        this.username = name;
    }
    public Member(String name, int age){
        this.username = name;
        this.age = age;
    }
    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }


}
