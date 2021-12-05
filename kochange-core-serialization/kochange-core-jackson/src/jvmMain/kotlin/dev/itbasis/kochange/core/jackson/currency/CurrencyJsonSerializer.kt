package dev.itbasis.kochange.core.jackson.currency

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import dev.itbasis.kochange.core.currency.Currency

public class CurrencyJsonSerializer : JsonSerializer<Currency>() {
	override fun serialize(value: Currency, gen: JsonGenerator, serializers: SerializerProvider) {
		gen.writeString(value.toString())
	}
}
