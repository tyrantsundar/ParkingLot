package com.parkinglot.util.payment;

import com.parkinglot.entities.PaymentMode;

public class PaymentStrategyFactory {

    public static PaymentStrategy getPaymentStrategy(PaymentMode mode, String value){
        switch (mode){
            case CC -> {return new CreditCardPayment(value);}
            case DC -> {return new DebitCardPayment(value);}
            case UPI -> {return new UPIPayment(value);}
            case CASH -> {return new CashPayment();}
        }
        return null;
    }

}