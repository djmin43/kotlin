package org.example.dev.dongjoon

import java.time.Instant
import java.time.LocalDate
import java.util.UUID

data class Cat(
    val id: UUID,
    val createdAt: Instant,
    val name: String,
    val dateOfBirth: LocalDate,
    val breed: String,
    val colour: String
)

data class CatData(
    val name: String,
    val dateOfBirth: LocalDate,
    val breed: String,
    val colour: String
)