package com.bankingmanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankUpdateRequest {

    private String id;

    private int bankCode;

    private String bankName;

    private String bankAddress;
}
