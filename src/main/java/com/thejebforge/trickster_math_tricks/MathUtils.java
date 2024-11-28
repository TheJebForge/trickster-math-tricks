package com.thejebforge.trickster_math_tricks;

import net.minecraft.entity.Entity;
import org.joml.AxisAngle4d;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;

public class MathUtils {
    public static Quaterniondc getEntityRotation(Entity entity) {
        return new Quaterniond()
                .mul(new Quaterniond(new AxisAngle4d(
                        -entity.getYaw() * (Math.PI / 180),
                        new Vector3d(0, 1, 0)
                )))
                .mul(new Quaterniond(new AxisAngle4d(
                        entity.getPitch() * (Math.PI / 180),
                        new Vector3d(1, 0, 0)
                )));
    }
}
