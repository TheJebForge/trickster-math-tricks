package com.thejebforge.trickster_math_tricks.book_template;

import com.thejebforge.trickster_math_tricks.trick.ModTricks;
import dev.enjarai.trickster.ClientUtils;
import dev.enjarai.trickster.Trickster;
import dev.enjarai.trickster.feyflower.braid.PatternOverviewWidget;
import dev.enjarai.trickster.feyflower.braid.PloyCostWidget;
import dev.enjarai.trickster.spell.mana.storage.ManaVariant;
import dev.enjarai.trickster.spell.mana.type.Manae;
import dev.enjarai.trickster.spell.trick.Trick;
import fish.trans.feyflower.client.braid.state.BookTextureProviderWidget;
import fish.trans.feyflower.client.html.WebImageRenderer;
import fish.trans.feyflower.client.md.FeyflowerCompiler;
import fish.trans.feyflower.client.md.template.TemplateHandler;
import io.wispforest.owo.braid.core.Insets;
import io.wispforest.owo.braid.framework.widget.Widget;
import io.wispforest.owo.braid.widgets.basic.Padding;
import io.wispforest.owo.braid.widgets.basic.Tooltip;
import j2html.tags.ContainerTag;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.function.BiFunction;

import static j2html.TagCreator.p;

public class MathTrickTemplate implements TemplateHandler {
    @Override
    public void applyBraidTemplate(FeyflowerCompiler<Widget> compiler, Args args) throws Exception {
        var trick = common(compiler, args);
        //TODO: signatures should be handled differently on the braid side due to the limited page space
        var signatures = Text.empty();
        for (var iterator = trick.getSignatures().iterator(); iterator.hasNext();) {
            var signature = iterator.next();
            signatures = signatures.append(signature.asText());
            if (iterator.hasNext()) {
                signatures = signatures.append("\n");
            }
        }

        compiler.visitCustomElement(new PatternOverviewWidget(trick.getPattern(), trick.getName()));
        compiler.visitStyledText(signatures);

        costOrHr(compiler, args, (widget, tooltip) -> new Padding(
                Insets.vertical(3d),
                new Tooltip(
                        tooltip,
                        widget
                )
        ));
    }

    @Override
    public void applyHtmlTemplate(FeyflowerCompiler<ContainerTag<?>> compiler, WebImageRenderer webImageRenderer, Args args) throws Exception {
        var trick = common(compiler, args);
        var signatures = Text.empty();
        for (var iterator = trick.getSignatures().iterator(); iterator.hasNext();) {
            var signature = iterator.next();
            signatures = signatures.append(signature.asText());
            if (iterator.hasNext()) {
                signatures = signatures.append("\n");
            }
        }

        compiler.visitCustomElement(p()
                .withClass("center-contents")
                .with(webImageRenderer.renderBraidWidget(
                        new PatternOverviewWidget(trick.getPattern(), trick.getName()),
                        151,
                        93,
                        "trickster-trick-" + args.getOrThrow("id").replace(':', '.')
                ).asImg())
        );

        compiler.visitStyledText(signatures);

        costOrHr(compiler, args, (widget, tooltip) -> {
            return webImageRenderer.tooltip(tooltip, "trickster-cost-tooltip-" + tooltip.hashCode())
                    .with(p()
                            .withClass("center-contents")
                            .with(webImageRenderer.renderBraidWidget(
                                    new BookTextureProviderWidget(
                                            compiler.getBookTexture(),
                                            widget
                                    ),
                                    139,
                                    5,
                                    "trickster-cost-hr-" + widget.hashCode()
                            ).asImg()));
        });
    }

    private Trick<?> common(FeyflowerCompiler<?> compiler, Args args) throws Exception {
        var id = Identifier.of(args.getOrThrow("id"));
        var trick = ModTricks.REGISTRY.get(id);
        if (trick == null) {
            throw new RuntimeException("Trick " + id + " does not exist");
        }

        compiler.visitTag("trick&" + id);
        return trick;
    }

    private <T> void costOrHr(FeyflowerCompiler<T> compiler, Args args, BiFunction<PloyCostWidget, Text, T> mapper) throws Exception {
        args.get("cost").ifPresentOrElse(cost -> {
            var manaType = args.get("mana-type").map(s -> {
                var id = Identifier.tryParse(s);
                if (id == null) throw new IllegalArgumentException("Mana type " + s + " is not a valid identifier");
                var mana = Manae.REGISTRY.get(id);
                if (mana == null) throw new IllegalArgumentException("Mana type " + s + " does not exist");

                return mana;
            }).orElse(Manae.TRADITIONAL);
            var tooltip = Text.translatable("trickster.mana_cost.costs_mana")
                    .append(Text.literal("\n"))
                    .append(Text.literal(cost).styled(s -> s.withFormatting(Formatting.GRAY)));
            if (ClientUtils.hasAdvancement(Trickster.id("unusual_mana"))) {
                tooltip.append(Text.literal("\n\n")).append(Text.translatable(
                        "trickster.mana_cost.type",
                        manaType.getName(ManaVariant.of(manaType))
                ));
            }

            compiler.visitCustomElement(mapper.apply(new PloyCostWidget(cost, manaType), tooltip));
        }, compiler::visitHorizontalRule);
    }
}
