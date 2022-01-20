package com.Dio.PersonApi.dto.Request;

import com.Dio.PersonApi.Enum.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    private PhoneType type;

    private Integer number;
}
