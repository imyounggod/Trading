package com.devcraft.trading.domain.util

sealed class Action(val action:String){
    object PlusValue: Action("add_value")
    object MinusValue: Action("add_value")
}
