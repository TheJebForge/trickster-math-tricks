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

public class ExtractXTrick extends MathDistortTrick<ExtractXTrick> {
    public ExtractXTrick() {
        super(
                Pattern.of(0, 3, 6),
                Signature.of(ModFragmentTypes.QUATERNION, ExtractXTrick::extractQuat, FragmentType.NUMBER)
        );
        overload(Signature.of(FragmentType.VECTOR, ExtractXTrick::extractVec, FragmentType.NUMBER));
    }

    public NumberFragment extractQuat(SpellContext spellContext, QuaternionFragment quaternion) {
        return new NumberFragment(quaternion.quaternion().x());
    }

    public NumberFragment extractVec(SpellContext spellContext, VectorFragment vector)  {
        return new NumberFragment(vector.vector().x());
    }
}
