package keepingMemory.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;
import java.util.List;

@Data
@RequiredArgsConstructor
@Table(schema = "mypage")
public class Mypage {
    @Id
    @GeneratedValue
    Integer id;

    @Column(name = "directory")
    List<File> files;

}
