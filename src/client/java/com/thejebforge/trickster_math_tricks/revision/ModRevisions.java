package com.thejebforge.trickster_math_tricks.revision;

import com.thejebforge.trickster_math_tricks.TricksterMathTricks;
import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import dev.enjarai.trickster.revision.ConstantRevision;
import dev.enjarai.trickster.revision.Revision;
import dev.enjarai.trickster.revision.Revisions;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.fragment.NumberFragment;
import org.joml.Quaterniond;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ModRevisions {
    private static final Map<Pattern, Revision> REGISTRY = new HashMap<>();

    public static Revision MAIN_REVISION = Revisions.register(new MathLibRevision());

    public static Revision PI_CONSTANT = register(new ConstantRevision(
            Pattern.of(6, 0, 2, 8, 5),
            new NumberFragment(Math.PI)
    ));
    public static Revision IDENTITY_QUATERNION = register(new ConstantRevision(
            Pattern.of(3, 4, 8, 7, 6, 3),
            new QuaternionFragment(new Quaterniond())
    ));

    public static Revision register(Revision revision) {
        if (REGISTRY.put(revision.pattern(), revision) != null) {
            TricksterMathTricks.LOGGER.warn(
                    "WARNING: Pattern like that is already defined! {}",
                    revision.pattern().toInt()
            );
        }

        return revision;
    }

    public static Optional<Revision> lookup(Pattern pattern) {
        return Optional.ofNullable(REGISTRY.get(pattern));
    }

    public static void register() {
        // init!
    }
}
