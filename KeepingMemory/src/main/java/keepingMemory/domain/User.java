package keepingMemory.domain;

import com.sun.istack.NotNull;
import keepingMemory.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static org.springframework.util.StringUtils.hasText;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    @NotNull
    String name;//유저 한글명

    @Column(name = "email")
    @NotNull
    String email;//유저 이메일
    @Column(name = "encrypted_password")
    @NotNull
    String password;

    @Column(name = "mateId")
    @NotNull
    Long mateId;//유저의 커플id

    @Column(name = "start_date")
    @NotNull
    LocalDateTime startDate; //사귄 날짜

    @Builder
    public User(String name, String email, String password, Long mateId, LocalDateTime startDate) {
        if (!hasText(name)) throw new IllegalArgumentException("name null");
        if (!hasText(email)) throw new IllegalArgumentException("email null");
        if (!hasText(startDate.toString())) throw new IllegalArgumentException("startDate null");
        this.name = name;
        this.email = email;
        this.password = password;
        this.mateId = mateId;
        this.startDate = startDate;
    }
}
