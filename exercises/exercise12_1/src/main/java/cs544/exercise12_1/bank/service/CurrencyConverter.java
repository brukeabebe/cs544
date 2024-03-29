package cs544.exercise12_1.bank.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("currencyConvertor")
public class CurrencyConverter implements ICurrencyConverter{
    public double euroToDollars (double amount){
		System.out.println("CurrencyConverter: converting "+amount+" dollars to euros");
        return 1.57 * amount;
    }
    
    public double dollarsToEuros (double amount){
        return 0.637 * amount;
    }
}
