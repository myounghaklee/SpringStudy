package study.querydsl.repository;

import org.springframework.data.domain.Pageable;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> search(MemberSearchCondition condition);
    List<MemberTeamDto> searchSimple(MemberSearchCondition condition, Pageable pageable);
    List<MemberTeamDto> searchComplex(MemberSearchCondition condition, Pageable pageable);
}
