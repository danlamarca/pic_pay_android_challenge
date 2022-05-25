package com.picpay.desafio.service.singleton

import android.content.Context
import android.util.Log
import com.anupcowkur.reservoir.Reservoir
import com.picpay.desafio.provider.model.CacheElement
import com.picpay.desafio.provider.model.ResponseUser

class Cache(private val context: Context) {

    private var cacheTime: Long = 0

    init {
        try {
            Reservoir.init(context, 1000048) //in bytes
        } catch (e: Exception) {
            Log.e("I/O Error", "Error while saving CacheElement " + e.message)
        }

        cacheTime = (1000 * 60 * 5).toLong()// every 5 minutes resets the cash
    }

    fun getSavedFilesInDisc(type: CacheElement.Companion.cacheType): ResponseUser? {
        try {
            if (needUpdate(
                    CacheElement.Companion.cacheType.CONTACTSCACHE, //implementado aqui a verificacao para os dados do tipo contato
                    type.name
                )
            ) {
                return null
            }
            return Reservoir.get(type.name, ResponseUser::class.java)//retornando dados casheados em disco
        } catch (e: Exception) {
            Log.e("I/O Error", "Error while saving CacheElement " + e.message)
            return null
        }
    }

    fun saveFilesInDisc(type: CacheElement.Companion.cacheType, users: ResponseUser) {
        try {
            Reservoir.put(type.name, users)//salvando em disco o cash de usuarios para ser usado a cada 5min
            saveCacheTime(
                CacheElement.Companion.cacheType.CONTACTSCACHE, //implementado aqui a verificacao para os dados do tipo contato
                System.currentTimeMillis()
            )
        } catch (e: Exception) {
            Log.e("I/O Error", "Error while saving CacheElement " + e.message)
        }
    }

    private fun saveCacheTime(type: CacheElement.Companion.cacheType, time: Long) {
        try {
            context.getSharedPreferences("Cache", 0).edit()
                .putLong(type.name, time).apply()

        } catch (e: Exception) {

        }
    }

    private fun getCacheTime(type: CacheElement.Companion.cacheType): Long {
        return try {
            context.getSharedPreferences("Cache", 0)
                .getLong(type.name, 0)
        } catch (e: Exception) {
            0
        }

    }

    private fun needUpdate(type: CacheElement.Companion.cacheType, suffix: String): Boolean {
        return needUpdate(getCacheTime(type))
    }

    private fun needUpdate(time: Long): Boolean {
        return System.currentTimeMillis() - time > cacheTime
    }
}