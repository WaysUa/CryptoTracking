package com.main.core

interface EventHandler<T> {
    fun obtainEvent(event: T)
}