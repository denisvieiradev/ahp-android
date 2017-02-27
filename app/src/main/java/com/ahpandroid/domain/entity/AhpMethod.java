package com.ahpandroid.domain.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by denisvieira on 19/02/17.
 */

public class AhpMethod implements Serializable {

    private final List<Criterion> mCriterions;
    private final List<Alternative> mAlternatives;

    public AhpMethod(List<Criterion> criterions, List<Alternative> alternatives) {
        this.mCriterions      = criterions;
        this.mAlternatives     = alternatives;
    }

    public List<Criterion> getCriterions() {
        return mCriterions;
    }

    public List<Alternative> getAlternatives() {
        return mAlternatives;
    }
}
