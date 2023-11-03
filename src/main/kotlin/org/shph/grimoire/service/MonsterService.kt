package org.shph.grimoire.service

import org.shph.grimoire.entity.Monster
import org.shph.grimoire.repository.MonsterRepository
import org.springframework.stereotype.Service

@Service
class MonsterService(
        val monsterRepository: MonsterRepository
) {
    fun findAll(): List<Monster> {
        return monsterRepository.findAll().toList()
    }
}