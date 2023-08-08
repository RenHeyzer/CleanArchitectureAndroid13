package com.ren.cleanarchitectureandroid13.utils.mapper

interface Mapper<F, T> {
    fun toModel(value: F): T
    fun fromModel(value: T): F
}