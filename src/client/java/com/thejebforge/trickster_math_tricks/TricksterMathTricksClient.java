package com.thejebforge.trickster_math_tricks;

import com.thejebforge.trickster_math_tricks.book_template.MathRevisionTemplate;
import com.thejebforge.trickster_math_tricks.book_template.MathTrickTemplate;
import fish.trans.feyflower.FeyflowerAPI;
import net.fabricmc.api.ClientModInitializer;

public class TricksterMathTricksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		FeyflowerAPI.registerTemplate(TricksterMathTricks.id("revision"), new MathRevisionTemplate());
		FeyflowerAPI.registerTemplate(TricksterMathTricks.id("trick"), new MathTrickTemplate());
	}
}