package study.datajpa.entity;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class JpaBaseEntity {
    @Column
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate =now;
    }

    public void preUpdate(){
        updatedDate = LocalDateTime.now();
    }
}
