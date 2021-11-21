@file:Suppress("unused", "ClassName")

package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.AUD
import dev.itbasis.kochange.core.currency.BTC
import dev.itbasis.kochange.core.currency.ETH
import dev.itbasis.kochange.core.currency.EUR
import dev.itbasis.kochange.core.currency.GBP
import dev.itbasis.kochange.core.currency.LINK
import dev.itbasis.kochange.core.currency.LTC
import dev.itbasis.kochange.core.currency.RUR
import dev.itbasis.kochange.core.currency.USD
import dev.itbasis.kochange.core.currency.USDT
import dev.itbasis.kochange.core.currency.XRP

public object LTC_AUD : SealedCurrencyPair(base = LTC, counter = AUD)
public object LTC_GBP : SealedCurrencyPair(base = LTC, counter = GBP)
public object LTC_USD : SealedCurrencyPair(base = LTC, counter = USD)
public object LTC_RUR : SealedCurrencyPair(base = LTC, counter = RUR)
public object LTC_EUR : SealedCurrencyPair(base = LTC, counter = EUR)
public object LTC_BTC : SealedCurrencyPair(base = LTC, counter = BTC)
public object LTC_XRP : SealedCurrencyPair(base = LTC, counter = XRP)
public object LTC_ETH : SealedCurrencyPair(base = LTC, counter = ETH)
public object LTC_USDT : SealedCurrencyPair(base = LTC, counter = USDT)

public object LINK_USD : SealedCurrencyPair(base = LINK, counter = USD)
public object LINK_EUR : SealedCurrencyPair(base = LINK, counter = EUR)
public object LINK_BTC : SealedCurrencyPair(base = LINK, counter = BTC)
public object LINK_ETH : SealedCurrencyPair(base = LINK, counter = ETH)
