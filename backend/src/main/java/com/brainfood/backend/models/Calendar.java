<<<<<<<< HEAD:backend/src/main/java/com/brainfood/models/Calendar.java
package com.brainfood.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
========
package com.brainfood.backend.models;
>>>>>>>> 48bf27863a2486d300402f525820a56e9208b3a3:backend/src/main/java/com/brainfood/backend/models/Calendar.java

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<<< HEAD:backend/src/main/java/com/brainfood/models/Calendar.java
========
import java.util.List;

>>>>>>>> 48bf27863a2486d300402f525820a56e9208b3a3:backend/src/main/java/com/brainfood/backend/models/Calendar.java
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {

    private List<Ingredient> ingredients;

    private List<Recipe> recipes;

}
