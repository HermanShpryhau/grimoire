package org.shph.grimoire.repository

import org.shph.grimoire.entity.Spell
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface SpellRepository: CrudRepository<Spell, UUID>