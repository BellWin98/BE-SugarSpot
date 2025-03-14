package com.sugarspot.common.exception;

import com.sugarspot.common.base.BaseErrorStatus;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException{
    protected final BaseErrorStatus errorStatus;

    public GeneralException(BaseErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }
}
