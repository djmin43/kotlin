package dev.dongjoon

import org.example.dev.dongjoon.Cat
import org.example.dev.dongjoon.CatData
import org.example.dev.dongjoon.CatService
import org.example.dev.dongjoon.toApi
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status
import org.http4k.format.Moshi
import org.junit.jupiter.api.Test
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import kotlin.test.assertEquals

class CatsTest {

    private val service = CatService(Clock.fixed(Instant.parse("2025-03-25T12:00:00Z"), ZoneOffset.UTC))

    private val api = service.toApi()

    @Test
    fun `list cats`() {
        val cat1 = service.createCat(
            CatData(
                name = "Toby",
                dateOfBirth = LocalDate.of(2015, 1, 1),
                breed = "Persian",
                colour = "White",
            )
        )

        val cat2 = service.createCat(
            CatData(
                name = "Eric",
                dateOfBirth = LocalDate.of(2024, 3, 4),
                breed = "Tiger",
                colour = "Black"
            )
        )


        val request = Request(Method.GET, "/v1/cats")

        val response = api(request)

        assertEquals(
            Status.OK,
            response.status
        )

        assertEquals(
            listOf(cat1, cat2),
            Moshi.asA<Array<Cat>>(response.bodyString()).toList()
        )

    }
}