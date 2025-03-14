package com.sugarspot.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sugarspot.common.base.BaseErrorStatus;
import com.sugarspot.common.base.BaseSuccessStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@Getter
@RequiredArgsConstructor
public class ApiResponse<T> {
    private final Boolean isSuccess; // 성공여부
    private final String code; // 사용자 정의 코드
    private final String message; // 응답 메시지
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data; // 응답데이터

    // 성공 응답 (데이터 X)
    public static <T> ResponseEntity<ApiResponse<T>> success(BaseSuccessStatus successStatus) {
        return ResponseEntity.status(successStatus.getHttpStatus())
                .body(new ApiResponse<>(true, successStatus.getCode(), successStatus.getMessage(), null));
    }

    // 성공 응답 (데이터 O)
    public static <T> ResponseEntity<ApiResponse<T>> success(BaseSuccessStatus successStatus, T data) {
        return ResponseEntity.status(successStatus.getHttpStatus())
                .body(new ApiResponse<>(true, successStatus.getCode(), successStatus.getMessage(), data));
    }

    // 에러 응답 (데이터 X)
    public static <T> ResponseEntity<ApiResponse<T>> error(BaseErrorStatus errorStatus) {
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(new ApiResponse<>(false, errorStatus.getCode(), errorStatus.getMessage(), null));
    }

    // 에러 응답 (데이터 O)
    public static <T> ResponseEntity<ApiResponse<T>> error(BaseErrorStatus errorStatus, T data) {
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(new ApiResponse<>(false, errorStatus.getCode(), errorStatus.getMessage(), data));
    }

    // 에러 응답 (오버라이드 메서드용)
    public static ResponseEntity<Object> error(BaseErrorStatus errorStatus, String message) {
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(new ApiResponse<>(false, errorStatus.getCode(), message, null));
    }
}
