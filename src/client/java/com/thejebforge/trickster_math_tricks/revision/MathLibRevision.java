package com.thejebforge.trickster_math_tricks.revision;

import dev.enjarai.trickster.revision.Revision;
import dev.enjarai.trickster.revision.RevisionContext;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.PatternGlyph;
import dev.enjarai.trickster.spell.SpellPart;

public class MathLibRevision implements Revision {
    public static final Pattern PATTERN = Pattern.of(3, 4, 0, 3, 6, 4, 7, 6);

    @Override
    public Pattern pattern() {
        return PATTERN;
    }

    @Override
    public SpellPart apply(RevisionContext revisionContext, SpellPart root, SpellPart drawingPart) {
        if (drawingPart.glyph instanceof PatternGlyph patternGlyph) {
            var revision = ModRevisions.lookup(patternGlyph.pattern());

            if (revision.isPresent()) {
                return revision.get().apply(revisionContext, root, drawingPart);
            }
        }

        return drawingPart;
    }
}
