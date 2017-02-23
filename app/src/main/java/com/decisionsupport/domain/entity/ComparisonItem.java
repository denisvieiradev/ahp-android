package com.decisionsupport.domain.entity;

import com.decisionsupport.domain.enums.ComparisonDefinitionEnum;

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
        return Float.valueOf(mFirstAlternativeStringValue);
    }

    public float getSecondAlternativeValue() {
        return Float.valueOf(mSecondAlternativeStringValue);
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
