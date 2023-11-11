package org.shph.grimoire.controller.dto.assembler

import org.shph.grimoire.controller.dto.ResponseDto

interface ResponseDtoAssembler<E, D: ResponseDto> {
    fun convert(entity: E): D

    fun convert(entities: List<E>): List<D> {
        return entities.map { convert(it) }
    }
}