package org.shph.grimoire.controller.dto

data class SpellSearchDto(
    val name: String?,
    val level: Int?,
    val characterClass: String?,
    val school: String?
)
