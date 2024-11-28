package com.thejebforge.trickster_math_tricks.trick.base;

import com.thejebforge.trickster_math_tricks.TricksterMathTricks;
import com.thejebforge.trickster_math_tricks.trick.ModTricks;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.trick.Trick;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public abstract class MathTrick extends Trick {
    public MathTrick(Pattern pattern) {
        super(pattern);
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
