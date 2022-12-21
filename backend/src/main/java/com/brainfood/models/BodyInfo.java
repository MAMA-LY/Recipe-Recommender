package com.brainfood.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("BodyInfo")
public class BodyInfo {

    private float height;

    private float weight;

    private Date birthdate;

}
