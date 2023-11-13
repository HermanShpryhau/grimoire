package org.shph.grimoire.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.util.UUID

@Document(indexName = "spells")
class Spell(
        @Id
        val id: UUID,

        @Field(type = FieldType.Text)
        val name: String,

        @Field(type = FieldType.Text)
        val description: String,

        @Field(type = FieldType.Text)
        val castTime: String,

        @Field(type = FieldType.Integer)
        val level: Int,

        @Field(type = FieldType.Text)
        val school: String,

        @Field(type = FieldType.Text)
        val distance: String,

        @Field(type = FieldType.Text)
        val components: List<String>,

        @Field(type = FieldType.Text)
        val duration: String,

        @Field(type = FieldType.Text)
        val classes: List<String>,

        @Field(type = FieldType.Text)
        val archetypes: List<String>,

        @Field(type = FieldType.Text)
        val source: String,

        @Field(type = FieldType.Boolean)
        val ritual: Boolean
)