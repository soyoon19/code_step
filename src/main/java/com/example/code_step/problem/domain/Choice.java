package com.example.code_step.problem.domain;

import lombok.Builder;
import lombok.Getter;

/*
* Choice는 하나의 문제만 가르킴으로
* 어떤 하나의 문제에 대해서 선택지(choice)가
* 정답인지 아닌지를 출력한다.
 */

/*
* 선택지(choice)에 많은 정보를 담게 함으로
* 다양한 유형에 응답할 수 있도록 할 수 있지 않을까 추측
 */

@Builder
public record Choice(Long id, Long problemId, String description, boolean answer, int orderNumber) {
}
