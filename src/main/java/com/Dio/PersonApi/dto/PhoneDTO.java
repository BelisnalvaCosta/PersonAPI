package com.Dio.PersonApi.DTO;

import com.Dio.PersonApi.Enum.PhoneType;
import com.Dio.PersonApi.dto.NotEmppty;
import com.Dio.PersonApi.dto.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmppty
    @Size(min = 13, max = 14)

    private String number;
}