package org.shph.grimoire.repository

import org.shph.grimoire.entity.Monster
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface MonsterRepository: CrudRepository<Monster, UUID>