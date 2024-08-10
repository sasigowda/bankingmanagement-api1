package com.bankingmanagement.service;

import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.model.BankTO;
import com.bankingmanagement.model.BankUpdateRequest;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BankService {
   List<BankTO> findAll() throws BankDetailsNotFoundException;

   BankTO findById(String id) throws  BankDetailsNotFoundException;
}
