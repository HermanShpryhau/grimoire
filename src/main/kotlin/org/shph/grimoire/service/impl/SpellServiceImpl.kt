package org.shph.grimoire.service.impl

import org.elasticsearch.common.unit.Fuzziness
import org.elasticsearch.index.query.BoolQueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.shph.grimoire.controller.dto.SpellSearchDto
import org.shph.grimoire.entity.Spell
import org.shph.grimoire.repository.SpellRepository
import org.shph.grimoire.service.SpellService
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
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
        var queryBuilder = NativeSearchQueryBuilder()

        if (searchDto.name?.isNotEmpty() == true) {
            queryBuilder = queryBuilder.withQuery(
                QueryBuilders.multiMatchQuery(searchDto.name)
                .field("name", 10f)
                .field("description")
                .fuzziness(Fuzziness.AUTO)
            )
        }

        if (searchDto.characterClass?.isNotEmpty() == true) {
            queryBuilder = queryBuilder.withQuery(
                BoolQueryBuilder().must(QueryBuilders.termQuery("classes", searchDto.characterClass)))
        }

        if (searchDto.school?.isNotEmpty() == true) {
            queryBuilder = queryBuilder.withQuery(
                BoolQueryBuilder().must(QueryBuilders.termQuery("school", searchDto.school)))
        }

        if (searchDto.level != null && searchDto.level != -1) {
            queryBuilder = queryBuilder.withQuery(
                BoolQueryBuilder().must(QueryBuilders.termQuery("level", searchDto.level)))
        }

        val query = queryBuilder.build()
        val searchHits = elasticsearchOperations.search(query, Spell::class.java)
        return searchHits.map { it.content }.toList()
    }
}