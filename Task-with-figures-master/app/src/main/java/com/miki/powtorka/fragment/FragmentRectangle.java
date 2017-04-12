package com.miki.powtorka.fragment;

import com.miki.powtorka.R;
import com.miki.powtorka.calculations.Calculations;

/**
 * Created by Miki on 03.04.2017.
 */

public class FragmentRectangle extends BaseShapeFragment {

    public FragmentRectangle() {
        super(2, R.drawable.rectange_image);
    }

    @Override
    double getCircuit(Calculations calculations) {
        return calculations.rectangleCircuit(valueOfField(0), valueOfField(1));
    }

    @Override
    double getArea(Calculations calculations) {
        return calculations.rectangleArea(valueOfField(0), valueOfField(1));
    }
}
