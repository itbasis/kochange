package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.Currency

public expect fun CurrencyPair.Companion.all(): Set<CurrencyPair>

public abstract class CurrencyPair protected constructor() {
	public abstract val code: String
	public abstract val base: Currency
	public abstract val counter: Currency

	override fun toString(): String = "$base/$counter"

	public fun toString(separator: String = "/"): String = "$base$separator$counter"

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

		public fun getInstanceNotCreate(pair: String): CurrencyPair? = pair.split(":", "/").let {
			require(it.size == 2) {
				"The value passed in is not a pair"
			}
			val base = requireNotNull(Currency.getInstanceNotCreate(it[0])) {
				"Unknown currency: ${it[0]}"
			}
			val counter = requireNotNull(Currency.getInstanceNotCreate(it[1])) {
				"Unknown currency: ${it[1]}"
			}
			return@let getInstanceNotCreate(base = base, counter = counter)
		}
	}
}
