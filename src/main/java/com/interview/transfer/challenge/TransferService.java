package com.interview.transfer.challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * "This endpoint is receiving hundreds of concurrent requests.
 * Occasionally we're seeing incorrect balances and duplicate
 * transfers. Review the implementation, identify the problems,
 * and propose a production-ready design."
 */
@Service
@RequiredArgsConstructor
public class TransferService {

  private final AccountRepository accountRepository;
  private final TransferRepository transferRepository;

  @Transactional
  public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
    Account from = accountRepository.findById(fromAccountId)
        .orElseThrow();
    Account to = accountRepository.findById(toAccountId)
        .orElseThrow();

    if (from.getBalance().compareTo(amount) < 0) {
      throw new InsufficientBalanceException();
    }

    from.setBalance(from.getBalance().subtract(amount));
    to.setBalance(to.getBalance().add(amount));

    accountRepository.save(from);
    accountRepository.save(to);

    transferRepository.save(
        new Transfer(fromAccountId, toAccountId, amount)
    );
  }
}
