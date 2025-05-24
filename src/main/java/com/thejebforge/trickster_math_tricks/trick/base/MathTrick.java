package com.thejebforge.trickster_math_tricks.trick.base;

import com.thejebforge.trickster_math_tricks.TricksterMathTricks;
import com.thejebforge.trickster_math_tricks.trick.ModTricks;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.trick.Trick;
import dev.enjarai.trickster.spell.type.Signature;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.List;

public abstract class MathTrick<T extends Trick<T>> extends Trick<T> {
    public MathTrick(Pattern pattern) {
        super(pattern);
    }

    public MathTrick(Pattern pattern, Signature<T> primary) {
        super(pattern, primary);
    }

    public MathTrick(Pattern pattern, List<Signature<T>> handlers) {
        super(pattern, handlers);
    }

    @Override
    public MutableText getName() {
        var id = ModTricks.REGISTRY.getId(this);

        if (id == null) {
            return Text.literal("Unregistered");
        }

        return Text.literal("").append(
                Text.translatable(TricksterMathTricks.MOD_ID + ".math_trick." + id.getPath())
                        .withColor(FragmentType.PATTERN.color().orElse(0)));
    }
}
