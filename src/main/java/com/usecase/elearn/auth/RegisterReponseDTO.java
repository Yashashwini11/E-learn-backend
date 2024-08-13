package com.usecase.elearn.auth;

import com.usecase.elearn.enums.Role;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReponseDTO {
    private String name;
    private String email;
    private Role role;

}
