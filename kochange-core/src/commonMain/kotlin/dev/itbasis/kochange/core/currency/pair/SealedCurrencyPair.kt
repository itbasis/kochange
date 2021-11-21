package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.Currency

public sealed class SealedCurrencyPair(
	final override val base: Currency,
	final override val counter: Currency
) : CurrencyPair() {
	final override val code: String = requireNotNull(this::class.simpleName)
}
