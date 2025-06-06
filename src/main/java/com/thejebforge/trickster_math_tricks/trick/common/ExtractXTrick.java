package com.thejebforge.trickster_math_tricks.trick.common;

import com.thejebforge.trickster_math_tricks.fragment.ModFragmentTypes;
import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import com.thejebforge.trickster_math_tricks.trick.ModTricks;
import com.thejebforge.trickster_math_tricks.trick.base.MathDistortTrick;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.blunder.IncompatibleTypesBlunder;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.fragment.NumberFragment;
import dev.enjarai.trickster.spell.fragment.VectorFragment;
import dev.enjarai.trickster.spell.type.Signature;
import dev.enjarai.trickster.spell.type.TypeVariadicArgType;

import java.util.List;

public class ExtractXTrick extends MathDistortTrick<ExtractXTrick> {
    public ExtractXTrick() {
        super(Pattern.of(0, 3, 6), Signature.of(ANY, ExtractXTrick::extract));
    }

    public Fragment extract(SpellContext spellContext, Fragment input) throws BlunderException {
        return switch (input) {
            case QuaternionFragment quaternion -> new NumberFragment(quaternion.quaternion().x());
            case VectorFragment vector -> new NumberFragment(vector.vector().x());
            case null, default -> throw new IncompatibleTypesBlunder(ModTricks.EXTRACT_X_TRICK);
        };
    }
}
