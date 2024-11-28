package com.thejebforge.trickster_math_tricks.trick.base;

import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.blunder.BlunderException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class MathDistortTrick extends MathTrick {
    private final Map<Fragment[], Fragment> cache = new LinkedHashMap<>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Fragment[], Fragment> eldest) {
            return size() > 20;
        }
    };

    public MathDistortTrick(Pattern pattern) {
        super(pattern);
    }

    @Override
    public Fragment activate(SpellContext ctx, List<Fragment> fragments) throws BlunderException {
        var fragmentArray = fragments.toArray(new Fragment[0]);
        var fragment = cache.get(fragmentArray);

        if (fragment == null) {
            fragment = distort(ctx, fragments);
            cache.put(fragmentArray, fragment);
        }

        return fragment;
    }

    public abstract Fragment distort(SpellContext ctx, List<Fragment> fragments) throws BlunderException;
}