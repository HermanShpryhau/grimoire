package org.shph.grimoire.controller.dto.assembler

import org.shph.grimoire.controller.dto.SpellResponseDto
import org.shph.grimoire.entity.Spell
import org.springframework.stereotype.Component

@Component
class SpellResponseDtoAssembler: ResponseDtoAssembler<Spell, SpellResponseDto> {
    override fun convert(entity: Spell): SpellResponseDto {
        return SpellResponseDto(
            entity.id,
            entity.name,
            entity.description,
            entity.castTime,
            entity.level,
            entity.school,
            entity.distance,
            entity.components.joinToString(", "),
            entity.duration,
            entity.classes.joinToString(", "),
            entity.archetypes.joinToString(", "),
            entity.source,
            entity.ritual
        )
    }
}