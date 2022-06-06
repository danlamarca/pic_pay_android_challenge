package com.picpay.desafio.android

import com.picpay.desafio.android.data.model.UserDataModel

import junit.framework.Assert.assertEquals
import org.junit.Test

class SortTest {//testa a reordenacao dos contatos da agenda

    private fun sortTest(correctNamesOrder: List<String>) {
        val list = mutableListOf<UserDataModel>()
        for (element in correctNamesOrder) {
            list.add(
                UserDataModel("", "", 0, "")
                    .apply { this.username = element })
        }

        for (i in 0..10) {
            list.shuffle()
            val sortedList = list.sortedBy { it.comparator() }

            for (j in sortedList.indices) {
                assertEquals(correctNamesOrder[j], sortedList[j].username)
            }
        }
    }

    @Test
    fun SimpleOrderedListtest() {
        val correctNamesOrder = listOf(
            "ARSENAL",
            "CELLERA",
            "LONKOOM",
            "TAIFF",
            "ZANPHY"
        )

        sortTest(correctNamesOrder)
    }
}