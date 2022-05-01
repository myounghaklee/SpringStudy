package com.hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member{

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;
    //Period
    @Embedded
    private Period workPeriod;

    //Address
    @Embedded
    private Address homeAddress;

}
