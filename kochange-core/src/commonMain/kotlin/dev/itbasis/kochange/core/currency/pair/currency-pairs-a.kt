@file:Suppress("unused", "ClassName")

package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.AAVE
import dev.itbasis.kochange.core.currency.ADA
import dev.itbasis.kochange.core.currency.ALGO
import dev.itbasis.kochange.core.currency.ATOM
import dev.itbasis.kochange.core.currency.BNB
import dev.itbasis.kochange.core.currency.BTC
import dev.itbasis.kochange.core.currency.CAD
import dev.itbasis.kochange.core.currency.ETH
import dev.itbasis.kochange.core.currency.EUR
import dev.itbasis.kochange.core.currency.USD
import dev.itbasis.kochange.core.currency.USDT

public object AAVE_BTC : SealedCurrencyPair(base = AAVE, counter = BTC)

public object ADA_BTC : SealedCurrencyPair(base = ADA, counter = BTC)
public object ADA_BNB : SealedCurrencyPair(base = ADA, counter = BNB)
public object ADA_USD : SealedCurrencyPair(base = ADA, counter = USD)
public object ADA_USDT : SealedCurrencyPair(base = ADA, counter = USDT)
public object ADA_EUR : SealedCurrencyPair(base = ADA, counter = EUR)
public object ADA_CAD : SealedCurrencyPair(base = ADA, counter = CAD)
public object ADA_ETH : SealedCurrencyPair(base = ADA, counter = ETH)

public object ALGO_BTC : SealedCurrencyPair(base = ALGO, counter = BTC)

public object ATOM_BTC : SealedCurrencyPair(base = ATOM, counter = BTC)
public object ATOM_ETH : SealedCurrencyPair(base = ATOM, counter = ETH)
public object ATOM_USD : SealedCurrencyPair(base = ATOM, counter = USD)
public object ATOM_EUR : SealedCurrencyPair(base = ATOM, counter = EUR)
public object ATOM_CAD : SealedCurrencyPair(base = ATOM, counter = CAD)
