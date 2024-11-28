package com.thejebforge.trickster_math_tricks.trick.blunder;

import dev.enjarai.trickster.spell.blunder.BlunderException;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class UnknownMathTrickBlunder extends BlunderException {
    public UnknownMathTrickBlunder() {}

    @Override
    public MutableText createMessage() {
        return Text.literal("Unknown math trick");
    }
}
