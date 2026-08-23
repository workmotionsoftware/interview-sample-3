package com.interview.transfer.challenge;

public class InsufficientBalanceException extends RuntimeException {

  public InsufficientBalanceException() {
    super("Insufficient balance for transfer");
  }
}
