package dev.itbasis.kochange.core.currency

public sealed class SealedCurrency(
	code: String? = null,
	baseCurrency: Currency? = null,
	name: String? = null,
	alternatives: List<String>? = null,
	override val comment: String = ""
) : Currency() {
	public final override val code: String = requireNotNull(code ?: this::class.simpleName)
	public final override val name: String = requireNotNull(name ?: baseCurrency?.name ?: this.code)
	public final override val alternativeCodes: List<String> = alternatives
		?: baseCurrency?.let { it.alternativeCodes - this.code + it.code }
		?: emptyList()
}
