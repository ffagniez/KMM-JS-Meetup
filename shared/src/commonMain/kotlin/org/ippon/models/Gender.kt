package org.ippon.models

enum class Gender(val value: String) {
    MALE("Male"),
    FEMALE("Female"),
    GENDERLESS("Genderless"),
    UNKNOWN("unknown");

    companion object {
        fun safeValueOf(value: String): Gender =
            values().find { it.value == value } ?: UNKNOWN
    }

}