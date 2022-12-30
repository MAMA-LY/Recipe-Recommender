package com.brainfood.backend.models;

import lombok.*;

import java.util.Date;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    private String username;

    private String email;

    private float height;

    private float weight;

    private Date birthdate;

    private String gender;
}
