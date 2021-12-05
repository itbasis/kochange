package dev.itbasis.kochange.core.currency

public actual fun Currency.Companion.all(): Set<Currency> = currencies.values.toSet()

// TODO code smell
// TODO migrate to kapt
internal actual fun initCurrencies(): MutableMap<String, Currency> {
	val baseCurrencies = SealedCurrency::class.sealedSubclasses.mapNotNull { it.objectInstance }

	val result = mutableMapOf<String, Currency>()
	baseCurrencies.forEach { currency ->
		result.getOrPut(currency.code) { currency }
	}
	baseCurrencies.forEach { currency ->
		currency.alternativeCodes.forEach { altCode ->
			result.getOrPut(altCode) { currency }
		}
	}

	return result
}
