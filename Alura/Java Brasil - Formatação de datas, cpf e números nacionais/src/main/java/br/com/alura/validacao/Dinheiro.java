package br.com.alura.validacao;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.convert.ExchangeRateType;

public class Dinheiro {
	public static void main(String[] args) {
		
		CurrencyUnit real = Monetary.getCurrency("BRL");
		CurrencyUnit dolar = Monetary.getCurrency("USD");
		MonetaryAmount valorParcela = Money.of(75, real);
		System.out.println(valorParcela);
		
		System.out.println("Total : " + valorParcela.multiply(10));
		
		
		/*
		 * Cálculos de imposto e conversão
		 */
		
		MonetaryAmount valorProduto = FastMoney.of(90, dolar);
		MonetaryAmount valorImposto = FastMoney.of(30, real);
		
		ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.ECB);
		CurrencyConversion conversaoAtual = provider.getCurrencyConversion(dolar);
		
		MonetaryAmount valorImpostoDolar = conversaoAtual.apply(valorImposto);
		MonetaryAmount valorFinalProdutoDolar = valorProduto.add(valorImpostoDolar);
		
		System.out.println(valorFinalProdutoDolar);
		
		
	}
}
