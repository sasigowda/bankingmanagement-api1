package com.bankingmanagement.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BankTO {
    private int bankCode;
    private String bankName;
    private String bankAddress;
}
