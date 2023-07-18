package com.employwise.employwisebe.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String id;
    private String name;
    private String email;
    private BigInteger phoneNumber;
    private Integer managerId;
    private String profileImage;
    private String uuid;
}
