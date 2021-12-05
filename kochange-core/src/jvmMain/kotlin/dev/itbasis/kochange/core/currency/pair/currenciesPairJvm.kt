package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.Currency

public actual fun CurrencyPair.Companion.all(): Set<CurrencyPair> = currencyPairs.values.toSet()

// TODO code smell
// TODO migrate to kapt
internal actual fun initCurrencyPairs(): MutableMap<Pair<Currency, Currency>, CurrencyPair> {
	val baseCurrencyPairs = SealedCurrencyPair::class.sealedSubclasses.mapNotNull { it.objectInstance }

	val result = mutableMapOf<Pair<Currency, Currency>, CurrencyPair>()
	baseCurrencyPairs.forEach { currencyPair ->
		result.getOrPut(currencyPair.base to currencyPair.counter) { currencyPair }
	}

	return result
}
