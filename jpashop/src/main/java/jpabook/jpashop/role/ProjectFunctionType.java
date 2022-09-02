package jpabook.jpashop.role;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProjectFunctionType {
    CODING("코딩"),
    CREATE_MEETING("미팅 주관"),
    GIVE_MONEY("용돈 주기"),
    DRINK_TOGETHER("회식 참석");
    private final String description;
}
