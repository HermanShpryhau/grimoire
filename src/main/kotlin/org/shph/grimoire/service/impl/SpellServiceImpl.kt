package org.shph.grimoire.service.impl

import org.shph.grimoire.controller.dto.SpellSearchDto
import org.shph.grimoire.entity.Spell
import org.shph.grimoire.repository.SpellRepository
import org.shph.grimoire.service.SpellService
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.SearchHit
import org.springframework.data.elasticsearch.core.query.Criteria
import org.springframework.data.elasticsearch.core.query.CriteriaQuery
import org.springframework.stereotype.Service

@Service
class SpellServiceImpl(
    val spellRepository: SpellRepository,
    val elasticsearchOperations: ElasticsearchOperations
) : SpellService {
    override fun findAll(): List<Spell> {
        return spellRepository.findAll().toList()
    }

    override fun search(searchDto: SpellSearchDto): List<Spell> {
        var criteria = Criteria()
        if (searchDto.name?.isNotEmpty() == true) {
            criteria = criteria.and(Criteria("name").contains(searchDto.name).boost(100.0f)
                .or("description").contains(searchDto.name))
        }

        if (searchDto.characterClass?.isNotEmpty() == true) {
            criteria = criteria.and(Criteria("classes").contains(searchDto.characterClass))
        }

        if (searchDto.school?.isNotEmpty() == true) {
            criteria = criteria.and(Criteria("school").`is`(searchDto.school))
        }

        if (searchDto.level != null && searchDto.level != -1){
            criteria = criteria.and(Criteria("level").`is`(searchDto.level.toString()))
        }

        val query = CriteriaQuery(criteria)
        val searchHits = elasticsearchOperations.search(query, Spell::class.java)

        return searchHits.map { it.content }.toList()
    }
}