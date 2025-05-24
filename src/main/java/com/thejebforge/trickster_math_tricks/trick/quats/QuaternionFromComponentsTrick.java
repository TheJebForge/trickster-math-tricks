package com.thejebforge.trickster_math_tricks.trick.quats;

import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import com.thejebforge.trickster_math_tricks.trick.base.MathDistortTrick;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.fragment.NumberFragment;
import dev.enjarai.trickster.spell.type.Signature;
import org.joml.Quaterniond;

import java.util.List;

public class QuaternionFromComponentsTrick extends MathDistortTrick<QuaternionFromComponentsTrick> {
    public QuaternionFromComponentsTrick() {
        super(Pattern.of(3, 4, 5, 1, 3, 7, 4, 1), Signature.of(FragmentType.NUMBER, FragmentType.NUMBER, FragmentType.NUMBER, FragmentType.NUMBER, QuaternionFromComponentsTrick::construct));
    }

    public Fragment construct(SpellContext ctx, NumberFragment x, NumberFragment y, NumberFragment z, NumberFragment w) throws BlunderException {
        return new QuaternionFragment(new Quaterniond(x.number(), y.number(), z.number(), w.number()));
    }
}
