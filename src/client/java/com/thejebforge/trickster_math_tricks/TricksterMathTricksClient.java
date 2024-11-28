package com.thejebforge.trickster_math_tricks;

import com.thejebforge.trickster_math_tricks.revision.ModRevisions;
import com.thejebforge.trickster_math_tricks.trick.ModTricks;
import dev.enjarai.trickster.screen.owo.GlyphComponent;
import io.wispforest.owo.ui.parsing.UIModelParsingException;
import io.wispforest.owo.ui.parsing.UIParsing;
import net.fabricmc.api.ClientModInitializer;
import org.w3c.dom.Element;

public class TricksterMathTricksClient implements ClientModInitializer {
	public static GlyphComponent parseMathTrick(Element element) {
		UIParsing.expectAttributes(element, "trick-id");
		UIParsing.expectAttributes(element, "size");

		var trickId = UIParsing.parseIdentifier(element.getAttributeNode("trick-id"));
		var trick = ModTricks.REGISTRY.get(trickId);

		if (trick == null) {
			throw new UIModelParsingException("Not a valid trick: " + trickId);
		}

		var size = UIParsing.parseUnsignedInt(element.getAttributeNode("size"));

		return new GlyphComponent(trick, size);
	}

	@Override
	public void onInitializeClient() {
		ModRevisions.register();
		UIParsing.registerFactory(TricksterMathTricks.id("glyph"), TricksterMathTricksClient::parseMathTrick);
	}
}