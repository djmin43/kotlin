package org.example.dev.dongjoon

import java.time.Clock
import java.util.UUID

class CatService(private val clock: Clock) {

    private val cats = mutableListOf<Cat>()

    fun getCat(id: UUID): Cat? {
        return cats.find { it.id == id }
    }

    fun listCats(): List<Cat> {
        return cats.toList()
    }

    fun deleteCat(id: UUID): Cat? {
        val cat = cats.find { it.id == id }
        if (!cats.remove(cat)) return null
        return cat
    }

    fun createCat(data: CatData): Cat {
        val cat = Cat(
            id = UUID.randomUUID(),
            createdAt = clock.instant(),
            name = data.name,
            colour = data.colour,
            breed = data.breed,
            dateOfBirth = data.dateOfBirth,
        )

        cats += cat
        return cat
    }

}