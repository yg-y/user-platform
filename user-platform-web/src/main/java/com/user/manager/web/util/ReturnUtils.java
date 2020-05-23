package com.user.manager.web.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReturnUtils {

    private Object data;
    private Integer code;
    private String msg;

    public static ReturnUtils success() {
        return ReturnUtils.builder().code(200).msg("success").build();
    }

    public static ReturnUtils success(Object data) {
        return ReturnUtils.builder().code(200).data(data).msg("success").build();
    }

    public static ReturnUtils error() {
        return ReturnUtils.builder().code(400).build();
    }

    public static ReturnUtils error(String msg) {
        return ReturnUtils.builder().code(400).msg(msg).build();
    }


}
