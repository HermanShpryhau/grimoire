package org.shph.grimoire.service

import org.shph.grimoire.controller.dto.SpellSearchDto
import org.shph.grimoire.entity.Spell

interface SpellService {

    fun findAll(): List<Spell>

    fun search(searchDto: SpellSearchDto): List<Spell>

}