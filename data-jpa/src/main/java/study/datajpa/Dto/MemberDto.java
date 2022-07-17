package study.datajpa.Dto;

import lombok.Getter;

import javax.persistence.GeneratedValue;

@Getter
public class MemberDto {

    private Long id;
    private String username;
    private String teamName;

    public MemberDto(Long id, String username, String teamName){
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }
}
