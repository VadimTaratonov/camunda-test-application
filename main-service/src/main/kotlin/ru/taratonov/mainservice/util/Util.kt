package ru.taratonov.mainservice.util

fun notNull():Nothing {
    throw NullPointerException("should not ber null")
}