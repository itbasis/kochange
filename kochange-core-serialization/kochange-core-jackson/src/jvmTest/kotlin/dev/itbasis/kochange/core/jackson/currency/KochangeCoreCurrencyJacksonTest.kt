package dev.itbasis.kochange.core.jackson.currency

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import dev.itbasis.kochange.core.currency.ADA
import dev.itbasis.kochange.core.currency.BTC
import dev.itbasis.kochange.core.currency.Currency
import dev.itbasis.kochange.core.jackson.registerKochangeModule
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs

@Suppress("BlockingMethodInNonBlockingContext")
internal class KochangeCoreCurrencyJacksonTest : DescribeSpec(
	{
		val objectMapper = jacksonObjectMapper().registerKochangeModule()

		describe("to json") {
			it("simple element") {
				withData(
					ADA to "ADA",
					BTC to "BTC"
				) { (currency, expect) ->
					// language=JSON
					val expectJsonString = """"$expect""""
					objectMapper.writeValueAsString(currency) shouldBe expectJsonString
				}
			}
			it("list") {
				val list = listOf(ADA, BTC)
				// language=JSON
				val expect = """["ADA","BTC"]"""

				objectMapper.writeValueAsString(list) shouldBe expect
			}
		}

		describe("parse json") {
			it("simple element") {
				withData(
					"ADA" to ADA,
					"BTC" to BTC
				) { (json, expect) ->
					// language=JSON
					val fixedJsonAsString = """"$json""""
					objectMapper.readValue<Currency>(fixedJsonAsString).shouldBeSameInstanceAs(expect)
				}
			}
			it("list") {
				val expect = listOf(ADA, BTC)
				// language=JSON
				val json = """["ADA","BTC"]"""

				objectMapper.readValue<List<Currency>>(json).shouldContainExactly(expect)
			}
			it("unknown currency") {
				// language=JSON
				val json = """"BY""""
				shouldThrowExactly<JsonParseException> {
					objectMapper.readValue<Currency>(json)
				}.message shouldBe "unknown currency\n at [Source: (String)\"\"BY\"\"; line: 1, column: 5]"
			}
			it("unknown currency in list") {
				// language=JSON
				val json = """["ADA","BY"]"""
				shouldThrowExactly<NullPointerException> {
					objectMapper.readValue<Currency>(json)
				}
			}
		}
	}
)
