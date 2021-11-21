package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.Currency

internal actual fun initCurrencyPairs(): MutableMap<Pair<Currency, Currency>, CurrencyPair> {
	val baseCurrencyPairs = SealedCurrencyPair::class.sealedSubclasses.mapNotNull { it.objectInstance }

	val result = mutableMapOf<Pair<Currency, Currency>, CurrencyPair>()
	baseCurrencyPairs.forEach { currencyPair ->
		result.getOrPut(currencyPair.base to currencyPair.counter) { currencyPair }
	}

	return result
}
