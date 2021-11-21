package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.Currency

public abstract class CurrencyPair protected constructor() {
	public abstract val code: String
	public abstract val base: Currency
	public abstract val counter: Currency

	override fun toString(): String = "$base/$counter"

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is CurrencyPair) return false

		if (code != other.code) return false
		if (base != other.base) return false
		if (counter != other.counter) return false

		return true
	}

	override fun hashCode(): Int {
		var result = code.hashCode()
		result = 31 * result + base.hashCode()
		result = 31 * result + counter.hashCode()
		return result
	}

	public companion object {
		public fun resetCache() {
			currencyPairs.clear()
			currencyPairs.putAll(initCurrencyPairs())
		}

		public fun getInstanceNotCreate(base: Currency, counter: Currency): CurrencyPair? = currencyPairs[base to counter]
	}
}
