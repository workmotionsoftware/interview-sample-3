package com.interview.transfer.challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/transfers")
@RequiredArgsConstructor
public class TransferController {

  private final TransferService transferService;

  @PostMapping
  public ResponseEntity<Void> transfer(@RequestBody TransferRequest request) {
    transferService.transfer(request.from(), request.to(), request.amount());
    return ResponseEntity.ok().build();
  }

  public record TransferRequest(Long from, Long to, BigDecimal amount) {
  }
}
