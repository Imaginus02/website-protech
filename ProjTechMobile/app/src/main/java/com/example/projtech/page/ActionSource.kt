package com.example.projtech.page

import com.example.projtech.database.dto.ActionDto

object ActionSource {
    val ACTIONS: List<ActionDto> = listOf(
        ActionDto(1,"Led Red", "Allume la led rouge pendant 2 secondes", 1, 1L),
        ActionDto(2,"Led Blue","Allume la led bleu pendant 2 secondes", 2, 1L),
        ActionDto(3, "Led Green", "Allume la led verte pendant 3 secondes", 3, 1L)
    )
}