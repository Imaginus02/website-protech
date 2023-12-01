package com.example.projtech.page

import com.example.projtech.model.ActionDTO

object ActionSource {
    val ACTIONS: List<ActionDTO> = listOf(
        ActionDTO(1,"Led Red", "Allume la led rouge pendant 2 secondes"),
        ActionDTO(2,"Led Blue","Allume la led bleu pendant 2 secondes"),
        ActionDTO(3, "Led Green", "Allume la led verte pendant 3 secondes")
    )
}