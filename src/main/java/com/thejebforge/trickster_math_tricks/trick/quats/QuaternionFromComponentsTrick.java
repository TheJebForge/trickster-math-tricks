package com.thejebforge.trickster_math_tricks.trick.quats;

import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import com.thejebforge.trickster_math_tricks.trick.base.MathDistortTrick;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import org.joml.Quaterniond;

import java.util.List;

public class QuaternionFromComponentsTrick extends MathDistortTrick {
    public QuaternionFromComponentsTrick() {
        super(Pattern.of(3, 4, 5, 1, 3, 7, 4, 1));
    }

    @Override
    public Fragment distort(SpellContext ctx, List<Fragment> fragments) throws BlunderException {
        var x = expectInput(fragments, FragmentType.NUMBER, 0).number();
        var y = expectInput(fragments, FragmentType.NUMBER, 1).number();
        var z = expectInput(fragments, FragmentType.NUMBER, 2).number();
        var w = expectInput(fragments, FragmentType.NUMBER, 3).number();

        return new QuaternionFragment(new Quaterniond(x, y, z, w));
    }
}
