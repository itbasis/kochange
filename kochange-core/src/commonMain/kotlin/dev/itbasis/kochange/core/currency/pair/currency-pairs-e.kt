@file:Suppress("ClassName", "unused")

package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.AUD
import dev.itbasis.kochange.core.currency.BTC
import dev.itbasis.kochange.core.currency.ETH
import dev.itbasis.kochange.core.currency.EUR
import dev.itbasis.kochange.core.currency.GBP
import dev.itbasis.kochange.core.currency.JPY
import dev.itbasis.kochange.core.currency.RUR
import dev.itbasis.kochange.core.currency.USD
import dev.itbasis.kochange.core.currency.USDT
import dev.itbasis.kochange.core.currency.XRP
import dev.itbasis.kochange.core.currency.XVN

public object ETH_BTC : SealedCurrencyPair(base = ETH, counter = BTC)
public object ETH_GBP : SealedCurrencyPair(base = ETH, counter = GBP)
public object ETH_USD : SealedCurrencyPair(base = ETH, counter = USD)
public object ETH_USDT : SealedCurrencyPair(base = ETH, counter = USDT)
public object ETH_EUR : SealedCurrencyPair(base = ETH, counter = EUR)
public object ETH_JPY : SealedCurrencyPair(base = ETH, counter = JPY)
public object ETH_AUD : SealedCurrencyPair(base = ETH, counter = AUD)

public object EUR_USD : SealedCurrencyPair(base = EUR, counter = USD)
public object EUR_RUR : SealedCurrencyPair(base = EUR, counter = RUR)
public object EUR_XRP : SealedCurrencyPair(base = EUR, counter = XRP)
public object EUR_XVN : SealedCurrencyPair(base = EUR, counter = XVN)
