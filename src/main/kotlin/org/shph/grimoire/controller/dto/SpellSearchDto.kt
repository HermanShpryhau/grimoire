package org.shph.grimoire.controller.dto

data class SpellSearchDto(
    val name: String? = null,
    val level: Int? = null,
    val characterClass: String? = null,
    val school: String? = null
)
