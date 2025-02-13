package com.androidcourse.data.datasource.local

import com.androidcourse.data.datasource.local.database.room.entities.BookEntity

interface RXInterface<T> : GeneralLocalDataSourceInterface<BookEntity> {
    /***
     * Saves a list of a specific type defined by T
     *  @param items:List<T> a list of T type.
     */
    fun saveAllRx(items: List<T>)
}
