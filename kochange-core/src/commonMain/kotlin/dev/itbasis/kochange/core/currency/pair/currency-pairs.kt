package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.Currency

internal expect fun initCurrencyPairs(): MutableMap<Pair<Currency, Currency>, CurrencyPair>

internal val currencyPairs: MutableMap<Pair<Currency, Currency>, CurrencyPair> = initCurrencyPairs()
