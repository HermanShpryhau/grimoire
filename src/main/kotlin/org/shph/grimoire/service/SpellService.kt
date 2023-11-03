package org.shph.grimoire.service

import org.shph.grimoire.entity.Spell
import org.shph.grimoire.repository.SpellRepository
import org.springframework.stereotype.Service

@Service
class SpellService(
        val spellRepository: SpellRepository
) {
    fun findAll(): List<Spell> {
        return spellRepository.findAll().toList()
    }
}