package com.thejebforge.trickster_math_tricks.fragment;

import com.thejebforge.trickster_math_tricks.TricksterMathTricks;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import io.wispforest.endec.StructEndec;
import net.minecraft.registry.Registry;

import java.util.OptionalInt;

public class ModFragmentTypes {
    public static final FragmentType<QuaternionFragment> QUATERNION = register("quaternion", QuaternionFragment.ENDEC);

    private static <T extends Fragment> FragmentType<T> register(String name, StructEndec<T> endec, int color) {
        return Registry.register(FragmentType.REGISTRY, TricksterMathTricks.id(name), new FragmentType<>(endec, OptionalInt.of(color)));
    }

    private static <T extends Fragment> FragmentType<T> register(String name, StructEndec<T> endec) {
        return Registry.register(FragmentType.REGISTRY, TricksterMathTricks.id(name), new FragmentType<>(endec, OptionalInt.empty()));
    }

    public static void register() {
        // init class
    }
}
