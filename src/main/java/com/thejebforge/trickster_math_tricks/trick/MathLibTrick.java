package com.thejebforge.trickster_math_tricks.trick;

import com.thejebforge.trickster_math_tricks.trick.blunder.UnknownMathTrickBlunder;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.trick.Trick;

import java.util.List;

public class MathLibTrick extends Trick {
    public MathLibTrick() {
        super(Pattern.of(6, 4, 3, 6, 7, 4, 8, 7));
    }

    @Override
    public Fragment activate(SpellContext spellContext, List<Fragment> list) throws BlunderException {
        var pattern = expectInput(list, FragmentType.PATTERN, 0);

        var mathTrick = ModTricks.lookup(pattern.pattern());
        if (mathTrick == null) throw new UnknownMathTrickBlunder();

        return mathTrick.activate(spellContext, list.subList(1, list.size()));
    }
}
