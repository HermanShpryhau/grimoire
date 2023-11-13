package org.shph.grimoire.controller

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
        model.addAttribute("spellSearchDto", SpellSearchDto())
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
        val spells = spellService.search(spellSearchDto)
        val spellDtos = spellResponseDtoAssembler.convert(spells)
        model.addAttribute("spells", spellDtos)
        return "spells/spellsSearchResult"
    }

    /**
     * For DEBUG purposes only
     */
    @GetMapping("/generate")
    fun generate(model: Model): String {
        spellRepository.deleteAll()

        val fireBolt = Spell(
            UUID.randomUUID(),
            "Огненный наряд",
            "1к10 урон огнем",
            0,
            "Воплощение",
            "120 фт.",
            listOf("В", "С", "М"),
            "1 ход",
            listOf("Волшебник", "Чародей"),
            listOf("Волшебник", "Чародей"),
            "PHB"
        )
        spellRepository.save(fireBolt)


        val fireBall = Spell(
            UUID.randomUUID(),
            "Огненный шар",
            "8к6 урон огнем в рудиусе 20 фт.",
            3,
            "Воплощение",
            "120 фт.",
            listOf("В", "С", "М"),
            "1 ход",
            listOf("Волшебник", "Чародей"),
            listOf("Волшебник", "Чародей"),
            "PHB"
        )
        spellRepository.save(fireBall)


        val rayOfFrost = Spell(
            UUID.randomUUID(),
            "Луч холода",
            "1к8 урон холода",
            0,
            "Воплощение",
            "120 фт.",
            listOf("В", "С", "М"),
            "1 ход",
            listOf("Волшебник", "Чародей", "Колдун"),
            listOf("Волшебник", "Чародей", "Колдун"),
            "PHB"
        )
        spellRepository.save(rayOfFrost)

        val coneOfCold = Spell(
            UUID.randomUUID(),
            "Конус холода",
            "4к10 урон холода",
            4,
            "Воплощение",
            "120 фт.",
            listOf("В", "С", "М"),
            "1 ход",
            listOf("Бард"),
            listOf("Волшебник", "Чародей", "Колдун"),
            "PHB"
        )
        spellRepository.save(coneOfCold)

        val spells = spellService.findAll()
        val spellDtos = spellResponseDtoAssembler.convert(spells)
        model.addAttribute("spells", spellDtos)
        model.addAttribute("spellSearchDto", SpellSearchDto())

        return "spells/spellsList"
    }
}