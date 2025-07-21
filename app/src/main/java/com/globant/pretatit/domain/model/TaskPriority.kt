package com.globant.pretatit.domain.model

// This enum now lives in the domain layer, accessible by all other layers.
enum class TaskPriority {
    NONE,
    LOW,
    MEDIUM,
    HIGH,
    URGENT;

    companion object {
        fun toListOfStrings(): List<String> {
            return entries.map { it.name }
        }

        fun getValueByName(name: String): TaskPriority {
            return entries.find { it.name.equals(name, ignoreCase = true) } ?: NONE
        }
    }
}