<<<<<<<< HEAD:backend/src/main/java/com/brainfood/models/BodyInfo.java
package com.brainfood.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;
========
package com.brainfood.backend.models;
>>>>>>>> 48bf27863a2486d300402f525820a56e9208b3a3:backend/src/main/java/com/brainfood/backend/models/BodyInfo.java

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<<< HEAD:backend/src/main/java/com/brainfood/models/BodyInfo.java
========
import java.util.Date;

>>>>>>>> 48bf27863a2486d300402f525820a56e9208b3a3:backend/src/main/java/com/brainfood/backend/models/BodyInfo.java
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BodyInfo {

    private float height;

    private float weight;

    private Date birthdate;

}
