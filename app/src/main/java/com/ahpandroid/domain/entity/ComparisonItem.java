package com.ahpandroid.domain.entity;

import com.ahpandroid.domain.enums.ComparisonDefinitionEnum;

/**
 * Created by denisvieira on 22/02/17.
 */

public class ComparisonItem {

    private String mFirstAlternativeName;
    private String mSecondAlternativename;
    private String mFirstAlternativeStringValue;
    private String mSecondAlternativeStringValue;
    private int mDefinitionText;

    public ComparisonItem(String firstAlternativeName, String secondAlternativename) {
        this.mFirstAlternativeName = firstAlternativeName;
        this.mSecondAlternativename = secondAlternativename;
        this.mFirstAlternativeStringValue = "1";
        this.mSecondAlternativeStringValue = "1";
        this.mDefinitionText = ComparisonDefinitionEnum.EQUAL.getValue();
    }

    public String getFirstAlternativeName() {
        return mFirstAlternativeName;
    }

    public String getSecondAlternativename() {
        return mSecondAlternativename;
    }

    public float getFirstAlternativeValue() {
        if(mFirstAlternativeStringValue.contains("/"))
            return getDivisionResult(mFirstAlternativeStringValue);

        return Float.valueOf(mFirstAlternativeStringValue);
    }

    public float getSecondAlternativeValue() {
        if(mSecondAlternativeStringValue.contains("/"))
            return getDivisionResult(mSecondAlternativeStringValue);

        return Float.valueOf(mSecondAlternativeStringValue);
    }

    public float getDivisionResult(String stringValue){
        String[] parts = stringValue.split("/");
        Integer part1 = Integer.valueOf(parts[0]);
        Integer part2 = Integer.valueOf(parts[1]);

        float result = (float) part1/part2;

        return result;
    }

    public String getFirstAlternativeStringValue() {
        return mFirstAlternativeStringValue;
    }

    public String getSecondAlternativeStringValue() {
        return mSecondAlternativeStringValue;
    }

    public int getDefinitionText() {
        return mDefinitionText;
    }

    public void setFirstAlternativeValue(String firstAlternativeStringValue) {
        this.mFirstAlternativeStringValue = firstAlternativeStringValue;
    }

    public void setSecondAlternativeValue(String secondAlternativeStringValue) {
        this.mSecondAlternativeStringValue = secondAlternativeStringValue;
    }

    public void setDefinitionText(int mDefinitionText) {
        this.mDefinitionText = mDefinitionText;
    }
}
