package dev.itbasis.kochange.core.currency

public expect fun Currency.Companion.all(): Set<Currency>

public abstract class Currency protected constructor() {
	public abstract val code: String
	public abstract val name: String
	public abstract val alternativeCodes: List<String>
	public abstract val comment: String

	public fun alternativesAsInstances(): Collection<Currency> = alternativeCodes.map {
		currencies.getValue(it)
	}

	override fun toString(): String = code

	override fun hashCode(): Int {
		var result = code.hashCode()
		result = 31 * result + name.hashCode()
		return result
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null) return false
		if (other !is Currency) return false

		if (code == other.code) return true
		if (alternativeCodes.contains(other.code)) return true
		if (other.alternativeCodes.contains(code)) return true

		return false
	}

	public companion object {
		public fun resetCache() {
			currencies.clear()
			currencies.putAll(initCurrencies())
		}

		public fun getInstanceNotCreate(code: String): Currency? = currencies[code]

		public fun getOrCreateInstance(code: String, baseCurrency: Currency? = null): Currency = currencies.getOrPut(code) {
			object : Currency() {
				override val code = code
				override val name = baseCurrency?.name ?: code
				override val alternativeCodes = baseCurrency?.let { it.alternativeCodes + it.code } ?: emptyList()
				override val comment = ""
			}
		}
	}
}
