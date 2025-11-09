package com.ohgiraffers.section02.userexception.exception;
// Exception (상속)-> NegativeException (상속) -> PriceNegEct, NotEnoughMoneyEct
public class NegativeException extends Exception {
    public NegativeException(String message) {
        super(message);
    }
}
