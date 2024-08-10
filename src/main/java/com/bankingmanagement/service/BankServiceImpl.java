package com.bankingmanagement.service;

import com.bankingmanagement.entity.Bank;
import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankTO;
import com.bankingmanagement.repository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BankServiceImpl implements  BankService{

    @Autowired
    private BankRepository bankRepository;

    /**
     * Find all the banks
     * @return
     * @throws BankDetailsNotFoundException
     */
    @Override
    public List<BankTO> findAll() throws BankDetailsNotFoundException {
        log.info("Inside the BankServiceImpl.findAll");
        List<Bank> bankList = bankRepository.findAll();

        if(CollectionUtils.isEmpty(bankList)){
            log.error("Bank details not found");
            throw new BankDetailsNotFoundException("Bank details not found");
        }

        List<BankTO> bankTOS = bankList.stream().map(bank -> {
            BankTO bankTO = new BankTO();
            bankTO.setBankCode(bank.getBankCode());
            bankTO.setBankName(bank.getBankName());
            bankTO.setBankAddress(bank.getBankAddress());
            return bankTO;
        }).collect(Collectors.toList());
        log.info("End of BankServiceImpl.findAll");
        return bankTOS;
    }


    /**
     * Find the bank details by id
     * @return
     * @throws BankDetailsNotFoundException
     */
    @Override
    public BankTO findById(String id) throws BankDetailsNotFoundException {
        log.info("Inside the BankServiceImpl.findById, id:{}", id);
        Optional<Bank> bankOptional = bankRepository.findById(id);

        if(bankOptional.isEmpty()){
            log.error("Bank details not found");
            throw new BankDetailsNotFoundException("Bank details not found");
        }

        Bank bank = bankOptional.get();
        BankTO bankTO = new BankTO();
        bankTO.setBankCode(bank.getBankCode());
        bankTO.setBankName(bank.getBankName());
        bankTO.setBankAddress(bank.getBankAddress());

        log.info("End of BankServiceImpl.findAll");
        return bankTO;
    }
}
