package dev.itbasis.kochange.core.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.addDeserializer
import com.fasterxml.jackson.module.kotlin.addSerializer
import dev.itbasis.kochange.core.currency.Currency
import dev.itbasis.kochange.core.currency.all
import dev.itbasis.kochange.core.currency.pair.CurrencyPair
import dev.itbasis.kochange.core.currency.pair.all
import dev.itbasis.kochange.core.jackson.currency.CurrencyJsonDeserializer
import dev.itbasis.kochange.core.jackson.currency.CurrencyJsonSerializer
import dev.itbasis.kochange.core.jackson.currency.pair.CurrencyPairJsonDeserializer
import dev.itbasis.kochange.core.jackson.currency.pair.CurrencyPairJsonSerializer

public fun ObjectMapper.registerKochangeModule(): ObjectMapper = registerModule(KochangeJacksonModule())

public class KochangeJacksonModule : SimpleModule() {
	override fun setupModule(context: SetupContext) {
		setupCurrencies()
		setupCurrencyPairs()

		super.setupModule(context)
	}

	private fun setupCurrencies() {
		val allCurrencies = Currency.all()

		CurrencyJsonSerializer().let { ser ->
			addSerializer(Currency::class, ser)
			allCurrencies.forEach { addSerializer(it.javaClass, ser) }
		}

		CurrencyJsonDeserializer().let { deser ->
			addDeserializer(Currency::class, deser)
			allCurrencies.forEach { addDeserializer(it.javaClass, deser) }
		}
	}

	private fun setupCurrencyPairs() {
		val allCurrencyPairs = CurrencyPair.all()

		CurrencyPairJsonSerializer().let { ser ->
			addSerializer(CurrencyPair::class, ser)
			allCurrencyPairs.forEach { addSerializer(it.javaClass, ser) }
		}

		CurrencyPairJsonDeserializer().let { deser ->
			addDeserializer(CurrencyPair::class, deser)
			allCurrencyPairs.forEach { addDeserializer(it.javaClass, deser) }
		}
	}
}
