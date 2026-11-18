package com.thejebforge.trickster_math_tricks.revision;

import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.revision.ConstantRevision;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class MathConstantRevision extends ConstantRevision {
    public MathConstantRevision(Pattern pattern, Fragment fragment) {
        super(pattern, fragment);
    }

    @Override
    public MutableText getName() {
        return Text.empty().append(
                Text.translatable(
                        ModRevisions.REGISTRY.getId(this)
                                .toTranslationKey("trickster-math-tricks.math_revision")
                )
        );
    }
}
