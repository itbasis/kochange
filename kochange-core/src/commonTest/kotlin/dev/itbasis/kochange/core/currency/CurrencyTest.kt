package dev.itbasis.kochange.core.currency

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.containExactlyInAnyOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class CurrencyTest : DescribeSpec() {
	init {
		afterTest {
			Currency.resetCache()
		}

		describe("currency count") {
			it("every symbol") {
				withData(
					Pair("A", 29),
					Pair("B", 37),
					Pair("C", 26),
					Pair("D", 19),
					Pair("E", 16),
					Pair("F", 9),
					Pair("G", 14),
					Pair("H", 0),
					Pair("I", 0),
					Pair("J", 4),
					Pair("K", 2),
					Pair("L", 4),
					Pair("M", 11),
					Pair("N", 4),
					Pair("O", 5),
					Pair("P", 2),
					Pair("Q", 3),
					Pair("R", 3),
					Pair("S", 12),
					Pair("T", 2),
					Pair("U", 14),
					Pair("V", 2),
					Pair("W", 3),
					Pair("X", 8),
					Pair("Y", 3),
					Pair("Z", 3)
				) { (prefix, count) ->
					currencies.filterKeys {
						it.startsWith(prefix = prefix)
					}.keys.shouldHaveSize(count)
				}
			}
			it("total") {
				currencies.shouldHaveSize(235)
				Currency.all().shouldHaveSize(233)
			}
		}

		describe("alternative codes") {
			withData(
				Triple(BTC, XBT, listOf("XBT")),
				Triple(XBT, BTC, listOf("BTC"))
			) { (currency, equal, alternatives) ->
				currency.alternativeCodes should containExactlyInAnyOrder(alternatives)
				currency shouldBe equal
			}
		}

		describe("create new instance") {
			val nnn = Currency.getOrCreateInstance(code = "NNN", baseCurrency = XBT)
			nnn.code shouldBe "NNN"
			nnn.name shouldBe BTC.name
			nnn.alternativesAsInstances() should containExactlyInAnyOrder(BTC, XBT)
			nnn shouldBe BTC
			nnn shouldBe XBT

			val nnn1 = Currency.getOrCreateInstance(code = "NNN")
			nnn1.code shouldBe "NNN"
			nnn1.name shouldBe BTC.name
			nnn1.alternativesAsInstances() should containExactlyInAnyOrder(BTC, XBT)
			nnn1 shouldBe BTC
			nnn1 shouldBe XBT

			val nnn2 = Currency.getOrCreateInstance(code = "NNN", baseCurrency = LTC)
			nnn2.code shouldBe "NNN"
			nnn2.name shouldBe BTC.name
			nnn2.alternativesAsInstances() should containExactlyInAnyOrder(BTC, XBT)
			nnn2 shouldBe BTC
			nnn2 shouldBe XBT
		}

		describe("get instance not create") {
			it("exists") {
				data class TestData(
					val code: String,
					val expectCurrency: Currency,
					val expectName: String,
					val expectAlternatives: List<String> = emptyList()
				)
				withData(
					nameFn = { t: TestData -> "${t.code} -> ${t.expectCurrency}" },
					TestData(code = "BTC", expectCurrency = BTC, expectName = "Bitcoin", expectAlternatives = listOf("XBT")),
					TestData(code = "XBT", expectCurrency = XBT, expectName = "Bitcoin", expectAlternatives = listOf("BTC")),
					TestData(code = "AED", expectCurrency = AED, expectName = "United Arab Emirates Dirham"),
					TestData(code = "BRL", expectCurrency = BRL, expectName = "Brazilian Real", expectAlternatives = listOf("R$")),
					TestData(code = "R$", expectCurrency = BRL, expectName = "Brazilian Real", expectAlternatives = listOf("R$")),
					TestData(code = "COTI", expectCurrency = COTI, expectName = "COTI")
				) { (code, expectCurrency, expectName, expectAlternatives) ->
					val actual = Currency.getInstanceNotCreate(code = code)
					requireNotNull(actual)

					actual shouldBe expectCurrency
					actual.name shouldBe expectName
					actual.alternativeCodes should containExactlyInAnyOrder(expectAlternatives)
				}

				withData(
					Pair("BTC", BTC),
					Pair("btc", null),
					Pair("Btc", null),
					Pair("bTc", null),
					Pair("R$", BRL),
					Pair("r$", null),
					Pair("GHS", GHS),
// 				Pair("GHs", GHs),
					Pair("gHs", null)
				) { (code, currency) ->
					Currency.getInstanceNotCreate(code = code) shouldBe currency
				}
			}
			it("not exists") {
				Currency.getInstanceNotCreate(code = "not_exists") shouldBe null
			}
		}

		describe("not equals") {
			withData(
				Pair(BTC, LTC),
				Pair(XBT, LTC)
			) { (first, second) ->
				first shouldNotBe second
				first.code shouldNotBe second.code
			}
		}
	}
}
