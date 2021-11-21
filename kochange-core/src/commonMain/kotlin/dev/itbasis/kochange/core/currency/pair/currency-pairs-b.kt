@file:Suppress("unused", "ClassName")

package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.AUD
import dev.itbasis.kochange.core.currency.BCH
import dev.itbasis.kochange.core.currency.BTC
import dev.itbasis.kochange.core.currency.CAD
import dev.itbasis.kochange.core.currency.ETH
import dev.itbasis.kochange.core.currency.EUR
import dev.itbasis.kochange.core.currency.GBP
import dev.itbasis.kochange.core.currency.JPY
import dev.itbasis.kochange.core.currency.LTC
import dev.itbasis.kochange.core.currency.RUB
import dev.itbasis.kochange.core.currency.RUR
import dev.itbasis.kochange.core.currency.TRY
import dev.itbasis.kochange.core.currency.UAH
import dev.itbasis.kochange.core.currency.USD
import dev.itbasis.kochange.core.currency.USDC
import dev.itbasis.kochange.core.currency.USDT
import dev.itbasis.kochange.core.currency.XRP

public object BTC_LTC : SealedCurrencyPair(base = BTC, counter = LTC)
public object BTC_EUR : SealedCurrencyPair(base = BTC, counter = EUR)
public object BTC_GBP : SealedCurrencyPair(base = BTC, counter = GBP)
public object BTC_USD : SealedCurrencyPair(base = BTC, counter = USD)
public object BTC_USDT : SealedCurrencyPair(base = BTC, counter = USDT)
public object BTC_UAH : SealedCurrencyPair(base = BTC, counter = UAH)
public object BTC_JPY : SealedCurrencyPair(base = BTC, counter = JPY)
public object BTC_AUD : SealedCurrencyPair(base = BTC, counter = AUD)
public object BTC_CAD : SealedCurrencyPair(base = BTC, counter = CAD)
public object BTC_RUB : SealedCurrencyPair(base = BTC, counter = RUB)
public object BTC_RUR : SealedCurrencyPair(base = BTC, counter = RUR)
public object BTC_XRP : SealedCurrencyPair(base = BTC, counter = XRP)
public object BTC_TRY : SealedCurrencyPair(base = BTC, counter = TRY)

public object BCH_AUD : SealedCurrencyPair(base = BCH, counter = AUD)
public object BCH_CAD : SealedCurrencyPair(base = BCH, counter = CAD)
public object BCH_GBP : SealedCurrencyPair(base = BCH, counter = GBP)
public object BCH_EUR : SealedCurrencyPair(base = BCH, counter = EUR)
public object BCH_ETH : SealedCurrencyPair(base = BCH, counter = ETH)
public object BCH_BTC : SealedCurrencyPair(base = BCH, counter = BTC)
public object BCH_USD : SealedCurrencyPair(base = BCH, counter = USD)
public object BCH_USDC : SealedCurrencyPair(base = BCH, counter = USDC)
public object BCH_USDT : SealedCurrencyPair(base = BCH, counter = USDT)
public object BCH_UAH : SealedCurrencyPair(base = BCH, counter = UAH)
