package org.shph.grimoire.controller.dto

import java.util.*

data class SpellResponseDto(
    val id: UUID,
    val name: String,
    val description: String,
    val castTime: String,
    val level: Int,
    val school: String,
    val distance: String,
    val components: String,
    val duration: String,
    val classes: String,
    val archetypes: String,
    val source: String,
    val ritual: Boolean
) : ResponseDto
