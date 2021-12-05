package dev.itbasis.kochange.core.jackson.currency.pair

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import dev.itbasis.kochange.core.currency.pair.CurrencyPair

public class CurrencyPairJsonSerializer : JsonSerializer<CurrencyPair>() {
	override fun serialize(value: CurrencyPair, gen: JsonGenerator, serializers: SerializerProvider) {
		gen.writeString(value.toString())
	}
}
