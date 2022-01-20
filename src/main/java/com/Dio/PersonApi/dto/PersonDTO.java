package com.Dio.PersonApi.DTO;

import com.Dio.PersonApi.Entity.Phone;
import com.Dio.PersonApi.dto.CPF;
import com.Dio.PersonApi.dto.NotEmpty;
import com.Dio.PersonApi.dto.Size;
import com.Dio.PersonApi.dto.Valid;

import java.util.List;

public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<Phone> phone;
}