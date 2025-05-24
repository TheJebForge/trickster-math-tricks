package com.thejebforge.trickster_math_tricks.lisp;

import com.thejebforge.trickster_lisp.transpiler.ast.Call;
import com.thejebforge.trickster_lisp.transpiler.ast.SExpression;
import com.thejebforge.trickster_lisp.transpiler.fragment.ASTToFragment;
import com.thejebforge.trickster_lisp.transpiler.util.CallUtils;
import com.thejebforge.trickster_math_tricks.fragment.QuaternionFragment;
import dev.enjarai.trickster.spell.Fragment;
import org.joml.Quaterniond;

public class QuatToFragment implements ASTToFragment {
    @Override
    public Fragment apply(SExpression expression) {
        var call = (Call) expression;

        var x = CallUtils.getDoubleArgument(call, 0);
        var y = CallUtils.getDoubleArgument(call, 1);
        var z = CallUtils.getDoubleArgument(call, 2);
        var w = CallUtils.getDoubleArgument(call, 3);

        return new QuaternionFragment(new Quaterniond(x, y, z, w));
    }
}
