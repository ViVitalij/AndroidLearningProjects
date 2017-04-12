package com.miki.powtorka.fragment;

import com.miki.powtorka.R;
import com.miki.powtorka.calculations.Calculations;

/**
 * Created by Miki on 03.04.2017.
 */

public class FragmentTriangle extends BaseShapeFragment {

    public FragmentTriangle() {
        super(1, R.drawable.triangle_image, "a");
    }

    @Override
    double getCircuit(Calculations calculations) {
        return calculations.triangleCircuit(valueOfField(0));
    }

    @Override
    double getArea(Calculations calculations) {
        return calculations.triangleArea(valueOfField(0));
    }
}
