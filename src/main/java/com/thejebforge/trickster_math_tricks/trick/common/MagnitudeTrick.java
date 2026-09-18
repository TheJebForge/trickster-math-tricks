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

public class MagnitudeTrick extends MathDistortTrick<MagnitudeTrick> {
    public MagnitudeTrick() {
        super(
                Pattern.of(3, 4, 5, 2, 4, 1),
                Signature.of(ModFragmentTypes.QUATERNION, MagnitudeTrick::magnitudeQuat, FragmentType.NUMBER)
        );
        overload(Signature.of(FragmentType.VECTOR, MagnitudeTrick::magnitudeVec, FragmentType.NUMBER));
    }

    public NumberFragment magnitudeQuat(SpellContext spellContext, QuaternionFragment quaternion) {
        return new NumberFragment(
                Math.sqrt(quaternion.quaternion().lengthSquared())
        );
    }

    public NumberFragment magnitudeVec(SpellContext spellContext, VectorFragment vector) {
        return new NumberFragment(
                vector.vector().length()
        );
    }
}
