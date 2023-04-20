package com.dawdler.user.controller.enums;

public enum UserStateEnum {

    NORMAL(0,"正常"),
    DEL(1,"已删除");

    private int value;
    private String desc;

    UserStateEnum(int value, String desc){
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
