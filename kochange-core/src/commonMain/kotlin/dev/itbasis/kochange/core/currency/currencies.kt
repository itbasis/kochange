package dev.itbasis.kochange.core.currency

internal expect fun initCurrencies(): MutableMap<String, Currency>
internal val currencies: MutableMap<String, Currency> = initCurrencies()
