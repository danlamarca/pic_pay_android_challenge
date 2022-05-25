package com.picpay.desafio.provider.model

data class CacheElement(val id: String,
                        val name: String,
                        val type: cacheType
){

    companion object{
        enum class cacheType{
            CONTACTSCACHE
        }
    }

    fun getCacheElementFullId(): String{
        return id + '_' +  name + '_' +  type.name
    }
}