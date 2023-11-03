package org.shph.grimoire.repository

import org.shph.grimoire.entity.MagicItem
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface MagicItemRepository: CrudRepository<MagicItem, UUID>