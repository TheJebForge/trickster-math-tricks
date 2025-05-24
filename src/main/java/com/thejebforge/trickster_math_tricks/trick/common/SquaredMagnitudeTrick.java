package com.thejebforge.trickster_math_tricks.trick.common;

import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import com.thejebforge.trickster_math_tricks.trick.ModTricks;
import com.thejebforge.trickster_math_tricks.trick.base.MathDistortTrick;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.blunder.IncompatibleTypesBlunder;
import dev.enjarai.trickster.spell.fragment.NumberFragment;
import dev.enjarai.trickster.spell.fragment.VectorFragment;
import dev.enjarai.trickster.spell.type.Signature;

import java.util.List;

public class SquaredMagnitudeTrick extends MathDistortTrick<SquaredMagnitudeTrick> {
    public SquaredMagnitudeTrick() {
        super(Pattern.of(3, 4, 5, 2, 4, 1, 0, 4), Signature.of(ANY, SquaredMagnitudeTrick::sqrMagnitude));
    }

    public Fragment sqrMagnitude(SpellContext spellContext, Fragment input) throws BlunderException {
        return switch (input) {
            case QuaternionFragment quaternion -> new NumberFragment(quaternion.quaternion().lengthSquared());
            case VectorFragment vector -> new NumberFragment(vector.vector().lengthSquared());
            case null, default -> throw new IncompatibleTypesBlunder(ModTricks.SQUARED_MAGNITUDE_TRICK);
        };
    }
}
