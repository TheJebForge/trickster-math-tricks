package com.thejebforge.trickster_math_tricks.trick.common;

import com.thejebforge.trickster_math_tricks.fragment.ModFragmentTypes;
import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import com.thejebforge.trickster_math_tricks.trick.base.MathDistortTrick;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.exception.TricksterEngineException;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.fragment.VectorFragment;
import dev.enjarai.trickster.spell.type.Signature;
import org.joml.Quaterniond;
import org.joml.Vector3d;

public class NormalizeTrick extends MathDistortTrick<NormalizeTrick> {
    public NormalizeTrick() {
        super(
                Pattern.of(3, 4, 5, 6, 3),
                Signature.of(ModFragmentTypes.QUATERNION, NormalizeTrick::normalizeQuat, ModFragmentTypes.QUATERNION)
        );
        overload(Signature.of(FragmentType.VECTOR, NormalizeTrick::normalizeVec, FragmentType.VECTOR));
    }

    public QuaternionFragment normalizeQuat(SpellContext spellContext, QuaternionFragment quaternion) throws TricksterEngineException {
        return new QuaternionFragment(quaternion.quaternion().normalize(new Quaterniond()));
    }

    public VectorFragment normalizeVec(SpellContext spellContext, VectorFragment vector) throws TricksterEngineException {
        return new VectorFragment(vector.vector().normalize(new Vector3d()));
    }
}
