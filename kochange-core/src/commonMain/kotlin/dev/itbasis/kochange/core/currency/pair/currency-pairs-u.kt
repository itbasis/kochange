@file:Suppress("unused", "ClassName")

package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.AUD
import dev.itbasis.kochange.core.currency.BTC
import dev.itbasis.kochange.core.currency.CAD
import dev.itbasis.kochange.core.currency.EUR
import dev.itbasis.kochange.core.currency.JPY
import dev.itbasis.kochange.core.currency.LTC
import dev.itbasis.kochange.core.currency.RUR
import dev.itbasis.kochange.core.currency.USD
import dev.itbasis.kochange.core.currency.UTC
import dev.itbasis.kochange.core.currency.XVN

public object USD_JPY : SealedCurrencyPair(base = USD, counter = JPY)
public object USD_AUD : SealedCurrencyPair(base = USD, counter = AUD)
public object USD_CAD : SealedCurrencyPair(base = USD, counter = CAD)
public object USD_RUR : SealedCurrencyPair(base = USD, counter = RUR)
public object USD_XVN : SealedCurrencyPair(base = USD, counter = XVN)

public object UTC_USD : SealedCurrencyPair(base = UTC, counter = USD)
public object UTC_EUR : SealedCurrencyPair(base = UTC, counter = EUR)
public object UTC_BTC : SealedCurrencyPair(base = UTC, counter = BTC)
public object UTC_LTC : SealedCurrencyPair(base = UTC, counter = LTC)
