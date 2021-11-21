package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.BTC
import dev.itbasis.kochange.core.currency.ETH
import dev.itbasis.kochange.core.currency.EUR
import dev.itbasis.kochange.core.currency.LINK
import dev.itbasis.kochange.core.currency.LTC
import dev.itbasis.kochange.core.currency.USD
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe

internal class CurrencyPairTest : DescribeSpec() {
	init {
		afterTest {
			CurrencyPair.resetCache()
		}

		describe("count currency pairs") {
			it("every currency") {
				withData(
					ETH to 7,
					EUR to 4,
					LTC to 9,
					LINK to 4
				) { (currencyBase, count) ->
					currencyPairs.filterKeys {
						it.first == currencyBase
					}.shouldHaveSize(count)
				}
			}

			it("total") {
				currencyPairs.shouldHaveSize(72)
			}
		}

		describe("get pair from currencies") {
			withData(
				Triple(BTC, LTC, BTC_LTC),
				Triple(BTC, USD, BTC_USD)
			) { (base, counter, expect) ->
				CurrencyPair.getInstanceNotCreate(base = base, counter = counter) shouldBe expect
			}
		}
	}
}
