@file:Suppress("unused")

package dev.itbasis.kochange.core.currency

public object VET : SealedCurrency(name = "Hub Culture's Vet", alternatives = listOf("VEN"))
public object VEN : SealedCurrency(name = "Hub Culture's Ven", alternatives = listOf("VET"))
