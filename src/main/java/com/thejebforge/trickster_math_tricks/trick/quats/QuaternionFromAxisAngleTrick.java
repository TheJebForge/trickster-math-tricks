package com.thejebforge.trickster_math_tricks.trick.quats;

import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import com.thejebforge.trickster_math_tricks.trick.base.MathDistortTrick;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import org.joml.AxisAngle4d;
import org.joml.Quaterniond;

import java.util.List;

public class QuaternionFromAxisAngleTrick extends MathDistortTrick {
    public QuaternionFromAxisAngleTrick() {
        super(Pattern.of( 6, 4, 3, 6, 7, 4, 2));
    }

    @Override
    public Fragment distort(SpellContext spellContext, List<Fragment> list) throws BlunderException {
        var axis = expectInput(list, FragmentType.VECTOR, 0).vector();
        var angle = expectInput(list, FragmentType.NUMBER, 1).number();

        return new QuaternionFragment(new Quaterniond(new AxisAngle4d(angle, axis)));
    }
}
