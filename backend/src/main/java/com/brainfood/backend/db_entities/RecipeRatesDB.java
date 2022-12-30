package com.brainfood.backend.db_entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "\"RecipeRates\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeRatesDB {
    @EmbeddedId
    public RecipeRatesCK compositeKey;

    public float rate;
}
