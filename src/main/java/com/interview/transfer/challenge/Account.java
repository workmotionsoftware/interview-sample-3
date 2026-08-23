package com.interview.transfer.challenge;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {

  @Id
  private Long id;

  private BigDecimal balance;

  public Account(Long id, BigDecimal balance) {
    this.id = id;
    this.balance = balance;
  }
}
