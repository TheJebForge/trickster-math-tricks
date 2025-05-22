package com.thejebforge.trickster_math_tricks.lisp;

import com.thejebforge.trickster_lisp.transpiler.SpellConverter;
import com.thejebforge.trickster_math_tricks.TricksterMathTricks;
import com.thejebforge.trickster_math_tricks.trick.ModTricks;
import dev.enjarai.trickster.spell.trick.Tricks;
import net.fabricmc.loader.api.FabricLoader;

import java.util.Objects;

public class ModASTConverters {
    public static void register() {
        if (!FabricLoader.getInstance().isModLoaded("trickster_lisp")) return;

        SpellConverter.CALL_ID_CONVERTERS.put("quat", new QuatToFragment());
        SpellConverter.FRAGMENT_IDS.add("quat");

        TricksterMathTricks.LOGGER.info("Registered Trickster LISP integration");
    }
}
