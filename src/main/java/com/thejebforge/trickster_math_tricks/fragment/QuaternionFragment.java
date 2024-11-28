package com.thejebforge.trickster_math_tricks.fragment;

import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.blunder.BlunderException;
import dev.enjarai.trickster.spell.blunder.IncompatibleTypesBlunder;
import dev.enjarai.trickster.spell.fragment.AddableFragment;
import dev.enjarai.trickster.spell.fragment.DivisibleFragment;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.fragment.MultiplicableFragment;
import dev.enjarai.trickster.spell.fragment.NumberFragment;
import dev.enjarai.trickster.spell.fragment.SubtractableFragment;
import dev.enjarai.trickster.spell.fragment.VectorFragment;
import dev.enjarai.trickster.spell.trick.Tricks;
import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import net.minecraft.text.Text;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;

public record QuaternionFragment(Quaterniondc quaternion) implements Fragment,
        AddableFragment, MultiplicableFragment, DivisibleFragment, SubtractableFragment {
    public static final Endec<Quaterniondc> QUATERNION_ENDEC = Endec.of(
            ((ctx, serializer, value) -> {
                serializer.writeDouble(ctx, value.x());
                serializer.writeDouble(ctx, value.y());
                serializer.writeDouble(ctx, value.z());
                serializer.writeDouble(ctx, value.w());
            }),
            ((ctx, serializer) -> {
                var x = serializer.readDouble(ctx);
                var y = serializer.readDouble(ctx);
                var z = serializer.readDouble(ctx);
                var w = serializer.readDouble(ctx);
                return new Quaterniond(x, y, z, w);
            })
    );

    public static final StructEndec<QuaternionFragment> ENDEC = StructEndecBuilder.of(
            QUATERNION_ENDEC.fieldOf("q", QuaternionFragment::quaternion),
            QuaternionFragment::new
    );

    @Override
    public FragmentType<?> type() {
        return ModFragmentTypes.QUATERNION;
    }

    @Override
    public Text asText() {
        return Text.literal("(")
                .append(new NumberFragment(quaternion.x()).asFormattedText())
                .append(", ")
                .append(new NumberFragment(quaternion.y()).asFormattedText())
                .append(", ")
                .append(new NumberFragment(quaternion.z()).asFormattedText())
                .append(", ")
                .append(new NumberFragment(quaternion.w()).asFormattedText())
                .append(")");
    }

    @Override
    public boolean asBoolean() {
        return true;
    }

    @Override
    public int getWeight() {
        return 4;
    }

    @Override
    public AddableFragment add(Fragment fragment) throws BlunderException {
        if (fragment instanceof QuaternionFragment other) {
            return new QuaternionFragment(quaternion.add(other.quaternion, new Quaterniond()));
        }

        throw new IncompatibleTypesBlunder(Tricks.ADD);
    }

    @Override
    public MultiplicableFragment multiply(Fragment fragment) throws BlunderException {
        if (fragment instanceof QuaternionFragment other) {
            return new QuaternionFragment(quaternion.mul(other.quaternion, new Quaterniond()));
        }

        if (fragment instanceof NumberFragment other) {
            return new QuaternionFragment(quaternion.mul(other.number(), new Quaterniond()));
        }

        if (fragment instanceof VectorFragment other) {
            return new VectorFragment(quaternion.transform(other.vector(), new Vector3d()));
        }

        throw new IncompatibleTypesBlunder(Tricks.MULTIPLY);
    }

    @Override
    public DivisibleFragment divide(Fragment fragment) throws BlunderException {
        if (fragment instanceof QuaternionFragment other) {
            return new QuaternionFragment(quaternion.div(other.quaternion, new Quaterniond()));
        }

        throw new IncompatibleTypesBlunder(Tricks.DIVIDE);
    }

    @Override
    public SubtractableFragment subtract(Fragment fragment) throws BlunderException {
        if (fragment instanceof QuaternionFragment other) {
            return new QuaternionFragment(quaternion.add(other.quaternion.mul(-1, new Quaterniond()), new Quaterniond()));
        }

        throw new IncompatibleTypesBlunder(Tricks.SUBTRACT);
    }
}
