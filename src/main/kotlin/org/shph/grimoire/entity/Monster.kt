package org.shph.grimoire.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.util.*

@Document(indexName = "monsters")
class Monster(
        @Id
        val id: UUID,

        @Field(type = FieldType.Text)
        val name: String,

        @Field(type = FieldType.Text)
        val size: String,

        @Field(type = FieldType.Text)
        val type: String,

        @Field(type = FieldType.Text)
        val alignment: String,

        @Field(type = FieldType.Integer)
        val armourClass: Int,

        @Field(type = FieldType.Integer)
        val hitPoints: Int,

        @Field(type = FieldType.Text)
        val hitDice: String,

        @Field(type = FieldType.Text)
        val speed: String,

        @Field(type = FieldType.Integer)
        val strength: Int,

        @Field(type = FieldType.Integer)
        val dexterity: Int,

        @Field(type = FieldType.Integer)
        val constitution: Int,

        @Field(type = FieldType.Integer)
        val intelligence: Int,

        @Field(type = FieldType.Integer)
        val wisdom: Int,

        @Field(type = FieldType.Integer)
        val charisma: Int,

        @Field(type = FieldType.Text)
        val skills: List<String>,

        @Field(type = FieldType.Text)
        val senses: List<String>,

        @Field(type = FieldType.Integer)
        val proficiencyBonus: Int,

        @Field(type = FieldType.Integer)
        val challengeRating: Int,

        @Field(type = FieldType.Text)
        val actions: String,

        @Field(type = FieldType.Text)
        val description: String,

        @Field(type = FieldType.Text)
        val source: String,
)