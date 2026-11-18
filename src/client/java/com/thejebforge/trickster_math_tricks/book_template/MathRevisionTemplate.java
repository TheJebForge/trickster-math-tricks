package com.thejebforge.trickster_math_tricks.book_template;

import com.thejebforge.trickster_math_tricks.revision.ModRevisions;
import dev.enjarai.trickster.feyflower.braid.PatternOverviewWidget;
import dev.enjarai.trickster.feyflower.template.RevisionTemplate;
import fish.trans.feyflower.client.md.FeyflowerCompiler;
import io.wispforest.owo.braid.framework.widget.Widget;
import net.minecraft.util.Identifier;

public class MathRevisionTemplate extends RevisionTemplate {
    @Override
    public Widget common(FeyflowerCompiler<?> compiler, Args args) throws Exception {
        var id = Identifier.of(args.getOrThrow("id"));
        var revision = ModRevisions.REGISTRY.get(id);
        if (revision == null) {
            throw new RuntimeException("Revision " + id + " does not exist");
        }

        compiler.visitTag("revision&" + id);
        return new PatternOverviewWidget(revision.pattern(), revision.getName());
    }
}
