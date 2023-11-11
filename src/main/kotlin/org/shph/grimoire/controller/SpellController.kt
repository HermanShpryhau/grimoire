package org.shph.grimoire.controller

import org.shph.grimoire.controller.dto.SearchDto
import org.shph.grimoire.controller.dto.SpellResponseDto
import org.shph.grimoire.controller.dto.SpellSearchDto
import org.shph.grimoire.controller.dto.assembler.ResponseDtoAssembler
import org.shph.grimoire.entity.Spell
import org.shph.grimoire.repository.SpellRepository
import org.shph.grimoire.service.SpellService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
@RequestMapping("/spells")
class SpellController(
    val spellRepository: SpellRepository,
    val spellService: SpellService,
    val spellResponseDtoAssembler: ResponseDtoAssembler<Spell, SpellResponseDto>
) {
    @GetMapping
    fun index(model: Model): String {
        val spells = spellResponseDtoAssembler.convert(spellService.findAll())
        model.addAttribute("spells", spells)
        model.addAttribute("spellSearchDto", SpellSearchDto(null, null, null, null))
        return "spells/spellsList"
    }

    @GetMapping("/{id}")
    fun getSpellDetail(@PathVariable id: UUID, model: Model): String {
        //TODO: show error page 404 on no spell
        model.addAttribute("spell", spellRepository.findById(id).get())
        return "spells/spellDetail"
    }

    @PostMapping("/search")
    fun searchSpells(@ModelAttribute spellSearchDto: SpellSearchDto, model: Model): String {
        val spells = spellResponseDtoAssembler.convert(spellService.search(spellSearchDto))
        model.addAttribute("spells", spells)
        return "spells/spellsSearchResult"
    }

    /**
     * For DEBUG purposes only
     */
    @GetMapping("/new")
    fun new(): String {
        for (i in 0..9) {
            val newSpell = Spell(
                UUID.randomUUID(),
                "Заклинание $i",
                "1к10 урон огнем",
                i,
                "Воплощение",
                "120 фт.",
                listOf("В", "С", "М"),
                "1 ход",
                listOf("Волшебник", "Чародей"),
                listOf("Волшебник", "Чародей"),
                "PHB"
            )
            println(newSpell.name)
            spellRepository.save(newSpell)
        }
        return "spellsList"
    }
}