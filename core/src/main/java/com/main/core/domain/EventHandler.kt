package com.main.core.domain

interface EventHandler<T> {
    fun obtainEvent(event: T)
}