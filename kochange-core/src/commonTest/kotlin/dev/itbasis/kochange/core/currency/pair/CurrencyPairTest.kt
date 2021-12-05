package dev.itbasis.kochange.core.currency.pair

import dev.itbasis.kochange.core.currency.BTC
import dev.itbasis.kochange.core.currency.ETH
import dev.itbasis.kochange.core.currency.EUR
import dev.itbasis.kochange.core.currency.LINK
import dev.itbasis.kochange.core.currency.LTC
import dev.itbasis.kochange.core.currency.USD
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs

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

		describe("toString") {
			it("default separator") {
				withData(
					ADA_BTC to "ADA/BTC",
					BTC_LTC to "BTC/LTC"
				) { (currencyPair, expect) ->
					currencyPair.toString().shouldBe(expect)
				}
			}
			it("custom separator") {
				@Suppress("SpellCheckingInspection")
				withData(
					Triple(ADA_BTC, "/", "ADA/BTC"),
					Triple(ADA_BTC, ":", "ADA:BTC"),
					Triple(ADA_BTC, "", "ADABTC")
				) { (currencyPair, separator, expect) ->
					currencyPair.toString(separator = separator).shouldBe(expect)
				}
			}
		}
		describe("get pair from currencies") {
			it("for element") {
				withData(
					Triple(BTC, LTC, BTC_LTC),
					Triple(BTC, USD, BTC_USD)
				) { (base, counter, expect) ->
					CurrencyPair.getInstanceNotCreate(base = base, counter = counter).shouldBeSameInstanceAs(expect)
				}
			}
			it("for string") {
				withData(
					"BTC:LTC" to BTC_LTC,
					"BTC:USD" to BTC_USD,
					"BTC/LTC" to BTC_LTC,
					"BTC/USD" to BTC_USD
				) { (value, expect) ->
					CurrencyPair.getInstanceNotCreate(value).shouldBeSameInstanceAs(expect)
				}
			}
			it("fail for string") {
				withData(
					"BTC:LTC:DASH" to "The value passed in is not a pair",
					"BTC:LT1" to "Unknown currency: LT1",
					"BT1:LTC" to "Unknown currency: BT1",
				) { (value, expect) ->
					shouldThrowExactly<IllegalArgumentException> {
						CurrencyPair.getInstanceNotCreate(value)
					}.message shouldBe expect
				}
			}
		}
	}
}
