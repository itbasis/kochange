@file:Suppress("unused")

package dev.itbasis.kochange.core.currency

public object XBT : SealedCurrency(baseCurrency = BTC)
public object XLT : SealedCurrency(baseCurrency = LTC)
public object XVN : SealedCurrency(baseCurrency = VEN)
public object XDG : SealedCurrency(baseCurrency = DOGE)

public object XMR : SealedCurrency(name = "Monero")
public object XRP : SealedCurrency(name = "Ripple")
public object XLM : SealedCurrency(name = "Stellar Lumen")
public object XEM : SealedCurrency(name = "NEM")
