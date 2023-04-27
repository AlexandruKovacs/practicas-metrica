package modelo.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class GeneratorFactory {

	private static Map<String, Supplier<CardGeneratorPro>> factory = new HashMap<String, Supplier<CardGeneratorPro>>() {
		{
			put("esp", () -> new SpanishCardGeneratorPro());
		}
	};

	public static CardGeneratorPro get(String type) {
		if(!factory.containsKey(type)) {
			throw new IllegalArgumentException("Not recongnized type.");
		}
		return factory.get(type).get();
	}
}
