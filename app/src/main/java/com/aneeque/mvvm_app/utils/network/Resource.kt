package com.aneeque.mvvm_app.utils

data class Resource<out Any>(val status: Status, val data: Any?, val message: String?) {
    companion object {
        fun <Any> success(data: Any): Resource<Any> = Resource(Status.SUCCESS, data, null)

        fun <Any> error(data: Any?, message: String): Resource<Any> = Resource(Status.ERROR, data, message)

        fun <Any> loading(data: Any?): Resource<Any> = Resource(Status.LOADING, data, null)
    }
}