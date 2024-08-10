package com.bankingmanagement.controller;

import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.model.BankTO;
import com.bankingmanagement.model.BankUpdateRequest;
import com.bankingmanagement.service.BankService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/api/v1/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    // http://127.0.0.1:9090/api/v1/banks  GET

    @GetMapping
    public ResponseEntity<List<BankTO>> findAll() throws BankDetailsNotFoundException{
        log.info("Inside the BankController.findAll");
        List<BankTO> bankTOList = bankService.findAll();
        log.info("End of BankController.findAll");
        return new ResponseEntity<>(bankTOList, HttpStatus.OK);
    }

    // http://127.0.0.1:9090/api/v1/banks/1  GET    @PathVariable
    // http://127.0.0.1:9090/api/v1/banks/id?id=1  GET   @RequestParam
    @GetMapping("/{id}")
    public ResponseEntity<BankTO> findById(@PathVariable("id") String id) throws BankDetailsNotFoundException {
        log.info("Inside the BankController.findById, id:{}", id);
        BankTO bankTO = bankService.findById(id);
        log.info("Bank details:{}", bankTO);
        return  new ResponseEntity<>(bankTO, HttpStatus.OK);
    }

}
