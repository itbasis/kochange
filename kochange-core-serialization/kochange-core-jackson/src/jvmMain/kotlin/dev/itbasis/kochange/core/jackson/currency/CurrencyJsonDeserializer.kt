package dev.itbasis.kochange.core.jackson.currency

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import dev.itbasis.kochange.core.currency.Currency

public class CurrencyJsonDeserializer : JsonDeserializer<Currency>() {
	override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Currency =
		Currency.getInstanceNotCreate(p.valueAsString)
			?: throw JsonParseException(p, "unknown currency")
}
