package org.ippon.models

enum class Status(val value: String) {
    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("Unknown");

    companion object {
        fun safeValueOf(value: String): Status =
            values().find { it.value == value } ?: UNKNOWN
    }
} 