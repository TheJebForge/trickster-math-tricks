package com.thejebforge.trickster_math_tricks.trick.common;

import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import com.thejebforge.trickster_math_tricks.trick.ModTricks;
import com.thejebforge.trickster_math_tricks.trick.base.MathDistortTrick;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.blunder.IncompatibleTypesBlunder;
import dev.enjarai.trickster.spell.fragment.VectorFragment;
import org.joml.Quaterniond;
import org.joml.Vector3d;

import java.util.List;

public class NormalizeTrick extends MathDistortTrick {
    public NormalizeTrick() {
        super(Pattern.of(3, 4, 5, 6, 3));
    }

    @Override
    public Fragment distort(SpellContext spellContext, List<Fragment> list) throws BlunderException {
        var input = expectInput(list, 0);

        return switch (input) {
            case QuaternionFragment quaternion -> new QuaternionFragment(quaternion.quaternion().normalize(new Quaterniond()));
            case VectorFragment vector -> new VectorFragment(vector.vector().normalize(new Vector3d()));
            case null, default -> throw new IncompatibleTypesBlunder(ModTricks.NORMALIZE_TRICK);
        };
    }
}
