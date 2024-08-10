package com.bankingmanagement.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Getter
@Setter
@Document(collection = "bank")
public class Bank {
    @Id
    private String id;
    @Field("bankCode")
    private int bankCode;

    private String bankName;
    private String bankAddress;


}
