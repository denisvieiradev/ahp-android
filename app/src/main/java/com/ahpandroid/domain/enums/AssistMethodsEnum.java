package com.ahpandroid.domain.enums;

/**
 * Created by denisvieira on 28/12/16.
 */
public enum AssistMethodsEnum {
    AHP(0), PROGRESSION(1), REGRESSION(2);

    private final int mValue;

    AssistMethodsEnum(int value) {
        mValue = value;
    }

    public int getValue(){
        return mValue;
    }
}
