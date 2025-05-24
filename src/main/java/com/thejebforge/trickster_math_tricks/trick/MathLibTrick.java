package com.thejebforge.trickster_math_tricks.trick;

import com.thejebforge.trickster_math_tricks.trick.blunder.UnknownMathTrickBlunder;
import dev.enjarai.trickster.spell.*;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.trick.Trick;
import dev.enjarai.trickster.spell.type.Signature;

import java.util.List;

public class MathLibTrick extends Trick<MathLibTrick> {
    public MathLibTrick() {
        super(Pattern.of(6, 4, 3, 6, 7, 4, 8, 7), Signature.of(FragmentType.PATTERN, ANY_VARIADIC, MathLibTrick::activate));
    }

    public EvaluationResult activate(SpellContext spellContext, PatternGlyph pattern, List<Fragment> list) throws BlunderException {
        var mathTrick = ModTricks.lookup(pattern.pattern());
        if (mathTrick == null) throw new UnknownMathTrickBlunder();

        return mathTrick.activate(spellContext, list);
    }
}
