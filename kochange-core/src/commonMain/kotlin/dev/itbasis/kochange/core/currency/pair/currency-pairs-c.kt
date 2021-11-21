@file:Suppress("ClassName", "unused")

package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.BTC
import dev.itbasis.kochange.core.currency.COMP
import dev.itbasis.kochange.core.currency.CNC

public object CNC_BTC : SealedCurrencyPair(base = CNC, counter = BTC)

public object COMP_BTC : SealedCurrencyPair(base = COMP, counter = BTC)
