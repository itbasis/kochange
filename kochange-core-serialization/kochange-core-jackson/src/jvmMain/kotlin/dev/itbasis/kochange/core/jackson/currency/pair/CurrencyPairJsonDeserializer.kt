package dev.itbasis.kochange.core.jackson.currency.pair

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import dev.itbasis.kochange.core.currency.pair.CurrencyPair

public class CurrencyPairJsonDeserializer : JsonDeserializer<CurrencyPair>() {
	override fun deserialize(p: JsonParser, ctxt: DeserializationContext): CurrencyPair =
		CurrencyPair.getInstanceNotCreate(p.valueAsString)
			?: throw JsonParseException(p, "unknown currency pair")
}
