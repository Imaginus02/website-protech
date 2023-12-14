package com.example.projtech.page

import com.example.projtech.database.dto.ActionDto

object ActionSource {
    val ACTIONS: List<ActionDto> = listOf(
        ActionDto(1,"Led Red", "Allume la led rouge pendant 2 secondes"),
        ActionDto(2,"Led Blue","Allume la led bleu pendant 2 secondes"),
        ActionDto(3, "Led Green", "Allume la led verte pendant 3 secondes")
    )
}