package dev.itbasis.kochange.core.currency

public actual fun Currency.Companion.all(): Set<Currency> = currencies.values.toSet()
