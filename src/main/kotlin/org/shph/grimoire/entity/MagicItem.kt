package org.shph.grimoire.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.util.UUID

@Document(indexName = "magicitems")
class MagicItem(
        @Id
        val id: UUID,

        @Field(type = FieldType.Text)
        val name: String,

        @Field(type = FieldType.Text)
        val description: String,

        @Field(type = FieldType.Text)
        val rarity: String,

        @Field(type = FieldType.Boolean)
        val requiresAttunement: Boolean,

        @Field(type = FieldType.Text)
        val price: String,

        @Field(type = FieldType.Text)
        val source: String,
)