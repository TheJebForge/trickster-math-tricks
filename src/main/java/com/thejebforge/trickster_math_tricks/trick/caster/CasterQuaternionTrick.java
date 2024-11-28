package com.thejebforge.trickster_math_tricks.trick.caster;

import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import com.thejebforge.trickster_math_tricks.trick.base.MathTrick;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.blunder.IncompatibleSourceBlunder;

import java.util.List;

import static com.thejebforge.trickster_math_tricks.MathUtils.getEntityRotation;

public class CasterQuaternionTrick extends MathTrick {
    public CasterQuaternionTrick() {
        super(Pattern.of(1, 0, 3, 6, 4, 2, 5, 8, 7));
    }

    @Override
    public Fragment activate(SpellContext spellContext, List<Fragment> list) throws BlunderException {
        var caster = spellContext.source().getCaster().orElseThrow(() -> new IncompatibleSourceBlunder(this));

        return new QuaternionFragment(getEntityRotation(caster));
    }
}
