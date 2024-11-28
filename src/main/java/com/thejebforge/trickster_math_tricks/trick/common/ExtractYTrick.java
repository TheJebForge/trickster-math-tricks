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

import java.util.List;

public class ExtractYTrick extends MathDistortTrick {
    public ExtractYTrick() {
        super(Pattern.of(0, 4, 7));
    }

    @Override
    public Fragment distort(SpellContext spellContext, List<Fragment> list) throws BlunderException {
        var input = expectInput(list, 0);

        return switch (input) {
            case QuaternionFragment quaternion -> new NumberFragment(quaternion.quaternion().y());
            case VectorFragment vector -> new NumberFragment(vector.vector().y());
            case null, default -> throw new IncompatibleTypesBlunder(ModTricks.EXTRACT_Y_TRICK);
        };
    }
}
