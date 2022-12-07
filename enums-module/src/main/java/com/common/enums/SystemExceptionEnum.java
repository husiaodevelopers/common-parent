package com.common.enums;

/**
 * @author Hu
 *
 */
public enum SystemExceptionEnum implements ExceptionEnum {
    //系統異常
    SUCCESS(200, "成功"),
    UNKNOWN_ERROR(-1, "未知錯誤"),
    SYSTEM_ERROR(-2, "系統異常"),
    DATABASE_OPERATE_EXCEPTION(-3, "數據庫操作異常"),
    DATA_NULL(2, "數據未空"),

    TOKEN_NOT_NULL(50001, "token不能為空"),
    TOKEN_OVERDUE(50002, "token過期"),

    PARAMS_CHECK(50003, "請核對參數，缺少參數"),
    PARAMS_NOT_NULL(50004,"參數不能為空"),
    FREQUENT_REQUESTS(50005,"請求過於頻繁，請稍後再試"),

    ADD_FAIL(50006,"添加失敗"),
    MODIFY_FAIL(50007,"修改失敗"),
    DELETE_FAIL(50008,"刪除失敗"),
    SAVE_BATCH_FAIL(50009,"批量添加失敗"),
    QUERY_FAIL(50010,"查詢異常"),
    AUTHORITY_IS_NULL(50011,"沒有設置權限URL"),

    NO_ACCESS(50012,"無權限訪問"),
    ;

    private Integer code;

    private String msg;

    SystemExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static SystemExceptionEnum getCode(String param) {
        for (SystemExceptionEnum exceptionEnum : SystemExceptionEnum.values()) {
            String variable = exceptionEnum.toString().replaceAll("_", "");
            if (param.equalsIgnoreCase(variable)) {
                return exceptionEnum;
            }
        }
        return SystemExceptionEnum.PARAMS_CHECK;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}