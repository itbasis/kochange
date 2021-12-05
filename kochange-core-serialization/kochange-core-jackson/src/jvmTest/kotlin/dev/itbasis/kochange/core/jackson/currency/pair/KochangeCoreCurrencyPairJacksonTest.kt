package dev.itbasis.kochange.core.jackson.currency.pair

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import dev.itbasis.kochange.core.currency.pair.ADA_BTC
import dev.itbasis.kochange.core.currency.pair.BTC_LTC
import dev.itbasis.kochange.core.currency.pair.CurrencyPair
import dev.itbasis.kochange.core.jackson.registerKochangeModule
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs

@Suppress("BlockingMethodInNonBlockingContext")
internal class KochangeCoreCurrencyPairJacksonTest : DescribeSpec(
	{
		val objectMapper = jacksonObjectMapper().registerKochangeModule()

		describe("to json") {
			it("simple element - default separator") {
				withData(
					ADA_BTC to "ADA/BTC",
					BTC_LTC to "BTC/LTC"
				) { (currencyPair, expect) ->
					// language=JSON
					val expectJsonString = """"$expect""""
					objectMapper.writeValueAsString(currencyPair) shouldBe expectJsonString
				}
			}
			it("list") {
				it("default separator") {
					val list = listOf(ADA_BTC, BTC_LTC)
					// language=JSON
					val expect = """["ADA/BTC","BTC/LTC"]"""

					objectMapper.writeValueAsString(list) shouldBe expect
				}
				it("default separator") {
					val list = listOf(ADA_BTC, BTC_LTC)
					// language=JSON
					val expect = """["ADA/BTC","BTC/LTC"]"""

					objectMapper.writeValueAsString(list) shouldBe expect
				}
				it("default separator (unsorted)") {
					val list = listOf(BTC_LTC, ADA_BTC)
					// language=JSON
					val expect = """["BTC/LTC","ADA/BTC"]"""

					objectMapper.writeValueAsString(list) shouldBe expect
				}
			}
		}

		describe("parse json") {
			it("simple element") {
				withData(
					"ADA/BTC" to ADA_BTC,
					"BTC/LTC" to BTC_LTC,
					"ADA:BTC" to ADA_BTC,
					"BTC:LTC" to BTC_LTC
				) { (json, expect) ->
					// language=JSON
					val fixedJsonAsString = """"$json""""
					objectMapper.readValue<CurrencyPair>(fixedJsonAsString).shouldBeSameInstanceAs(expect)
				}
			}
		}
	}
)
