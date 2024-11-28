package com.thejebforge.trickster_math_tricks.trick.quats;

import com.thejebforge.trickster_math_tricks.fragment.ModFragmentTypes;
import com.thejebforge.trickster_math_tricks.trick.base.MathDistortTrick;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.fragment.VectorFragment;
import org.joml.Vector3d;

import java.util.List;

public class QuaternionEulerTrick extends MathDistortTrick {
    public QuaternionEulerTrick() {
        super(Pattern.of(3, 6, 7, 4, 1, 2, 5, 4, 3));
    }

    @Override
    public Fragment distort(SpellContext ctx, List<Fragment> fragments) throws BlunderException {
        var quaternion = expectInput(fragments, ModFragmentTypes.QUATERNION, 0).quaternion();

        return new VectorFragment(quaternion.getEulerAnglesXYZ(new Vector3d()));
    }
}
