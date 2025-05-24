package com.thejebforge.trickster_math_tricks.lisp;

import com.thejebforge.trickster_lisp.transpiler.SpellConverter;
import com.thejebforge.trickster_lisp.transpiler.ast.builder.CallBuilder;
import com.thejebforge.trickster_math_tricks.TricksterMathTricks;
import com.thejebforge.trickster_math_tricks.fragment.ModFragmentTypes;
import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;

public class ModASTConverters {
    public static void register() {
        SpellConverter.CUSTOM_FRAGMENT_CONVERTERS.put(ModFragmentTypes.QUATERNION, fragment -> {
            var quat = ((QuaternionFragment) fragment).quaternion();
            return CallBuilder.builder("quat")
                    .addNumber(quat.x())
                    .addNumber(quat.y())
                    .addNumber(quat.z())
                    .addNumber(quat.w())
                    .build();
        });
        SpellConverter.CALL_ID_CONVERTERS.put("quat", new QuatToFragment());
        SpellConverter.FRAGMENT_IDS.add("quat");

        TricksterMathTricks.LOGGER.info("Registered Trickster LISP integration");
    }
}
