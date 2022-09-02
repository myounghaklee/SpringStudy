package jpabook.jpashop.role;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
    MANEGER("매니저",
            Map.of(ProjectFunctionType.CODING, false,
            ProjectFunctionType.CREATE_MEETING, true,
            ProjectFunctionType.DRINK_TOGETHER, false,
            ProjectFunctionType.GIVE_MONEY, true)),
    PL("프로젝트 리더",
            Map.of(ProjectFunctionType.CODING, false,
                    ProjectFunctionType.CREATE_MEETING, true,
                    ProjectFunctionType.DRINK_TOGETHER, false,
                    ProjectFunctionType.GIVE_MONEY, true)),
    JUNIOR("주니어",
            Map.of(ProjectFunctionType.CODING, false,
                    ProjectFunctionType.CREATE_MEETING, true,
                    ProjectFunctionType.DRINK_TOGETHER, false,
                    ProjectFunctionType.GIVE_MONEY, true));

    private final String description;
    private final Map<ProjectFunctionType, Boolean> hasPermission;
}
