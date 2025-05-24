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

public class MagnitudeTrick extends MathDistortTrick<MagnitudeTrick> {
    public MagnitudeTrick() {
        super(Pattern.of(3, 4, 5, 2, 4, 1), Signature.of(ANY, MagnitudeTrick::magnitude));
    }

    public Fragment magnitude(SpellContext spellContext, Fragment input) throws BlunderException {
        return switch (input) {
            case QuaternionFragment quaternion -> new NumberFragment(
                    Math.sqrt(quaternion.quaternion().lengthSquared())
            );
            case VectorFragment vector -> new NumberFragment(vector.vector().length());
            case null, default -> throw new IncompatibleTypesBlunder(ModTricks.MAGNITUDE_TRICK);
        };
    }
}
