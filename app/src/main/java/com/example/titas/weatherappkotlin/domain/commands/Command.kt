package com.example.titas.weatherappkotlin.domain.commands

/**
 * Created by Titas on 7/19/2017.
 */
public interface Command<T>{
    fun execute(): T
}