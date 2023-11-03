package org.shph.grimoire.service

import org.shph.grimoire.entity.MagicItem
import org.shph.grimoire.repository.MagicItemRepository
import org.springframework.stereotype.Service

@Service
class MagicItemService(
        val magicItemRepository: MagicItemRepository
) {
    fun findAll(): List<MagicItem> {
        return magicItemRepository.findAll().toList()
    }
}