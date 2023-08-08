package com.ren.cleanarchitectureandroid13.utils.mapper

interface MapperData<T> {

    fun toModel(): T
}