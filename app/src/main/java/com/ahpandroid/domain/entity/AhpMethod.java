package com.ahpandroid.domain.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by denisvieira on 19/02/17.
 */

public class AhpMethod implements Serializable {

    private final List<String> mCriterions;
    private final List<String> mAlternatives;

    public AhpMethod(List<String> criterions, List<String> alternatives) {
        this.mCriterions      = criterions;
        this.mAlternatives     = alternatives;
    }

    public List<String> getCriterions() {
        return mCriterions;
    }

    public List<String> getAlternatives() {
        return mAlternatives;
    }
}
