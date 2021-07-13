package com.example.demo.models;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
//@Entity
@Getter
@Setter
public class FDRequest implements Serializable {
    private String bankName;
    private Integer durationInYear;
    private String fdInterestRate;

    public FDRequest(String bankName, Integer durationInYear) {
        this.bankName = bankName;
        this.durationInYear = durationInYear;
    }
    
}
