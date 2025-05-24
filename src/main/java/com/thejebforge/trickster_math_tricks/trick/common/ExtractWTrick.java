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
import dev.enjarai.trickster.spell.fragment.NumberFragment;
import dev.enjarai.trickster.spell.type.Signature;

import java.util.List;

public class ExtractWTrick extends MathDistortTrick<ExtractWTrick> {
    public ExtractWTrick() {
        super(Pattern.of(0, 2, 5), Signature.of(ModFragmentTypes.QUATERNION, ExtractWTrick::extract));
    }

    public Fragment extract(SpellContext spellContext, QuaternionFragment quat) throws BlunderException {
        return new NumberFragment(quat.quaternion().w());
    }
}
