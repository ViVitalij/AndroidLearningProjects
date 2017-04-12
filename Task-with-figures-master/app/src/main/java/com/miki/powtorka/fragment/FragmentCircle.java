package com.miki.powtorka.fragment;

import com.miki.powtorka.R;
import com.miki.powtorka.calculations.Calculations;

/**
 * Created by Miki on 03.04.2017.
 */

public class FragmentCircle extends BaseShapeFragment {

    public FragmentCircle() {
        super(1, R.drawable.circle_image, new String[]{"R"});
    }

    @Override
    double getCircuit(Calculations calculations) {
        return calculations.circleArea(valueOfField(0));
    }

    @Override
    double getArea(Calculations calculations) {
        return calculations.circleCircuit(valueOfField(0));
    }
}
