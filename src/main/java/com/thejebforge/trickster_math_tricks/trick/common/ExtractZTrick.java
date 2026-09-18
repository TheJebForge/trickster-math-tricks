package com.thejebforge.trickster_math_tricks.trick.common;

import com.thejebforge.trickster_math_tricks.fragment.ModFragmentTypes;
import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import com.thejebforge.trickster_math_tricks.trick.base.MathDistortTrick;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.fragment.NumberFragment;
import dev.enjarai.trickster.spell.fragment.VectorFragment;
import dev.enjarai.trickster.spell.type.Signature;

public class ExtractZTrick extends MathDistortTrick<ExtractZTrick> {
    public ExtractZTrick() {
        super(
                Pattern.of(0, 5, 8),
                Signature.of(ModFragmentTypes.QUATERNION, ExtractZTrick::extractQuat, FragmentType.NUMBER)
        );
        overload(Signature.of(FragmentType.VECTOR, ExtractZTrick::extractVec, FragmentType.NUMBER));
    }

    public NumberFragment extractQuat(SpellContext spellContext, QuaternionFragment quaternion) {
        return new NumberFragment(quaternion.quaternion().x());
    }

    public NumberFragment extractVec(SpellContext spellContext, VectorFragment vector) {
        return new NumberFragment(vector.vector().x());
    }
}
