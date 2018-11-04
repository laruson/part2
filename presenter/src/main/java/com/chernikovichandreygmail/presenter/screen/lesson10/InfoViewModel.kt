package com.chernikovichandreygmail.presenter.screen.lesson10

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.chernikovichandreygmail.presenter.base.BaseViewModel


class InfoViewModel : BaseViewModel<InfoRouter>() {
    val man = "man"
    val manName = ObservableField<String>("Brick")
    val manSurName = ObservableField<String>("Pig")
    val manAge = ObservableInt(69)
    val manImage = "https://cs8.pikabu.ru/images/big_size_comm/2016-11_2/1478437178140817847.png"

    val woman = "woman"
    val womanName = ObservableField<String>("Sasha")
    val womanSurName = ObservableField<String>("Gray")
    val womanAge = ObservableInt(30)
    val womanImage = "https://user32265.clients-cdnnow.ru/localStorage/post/25/e8/62/06/25e86206_resizedScaled_740to555.jpg"

    val sex = staticSex

    companion object {
        var staticSex = ObservableBoolean(true)
    }


}