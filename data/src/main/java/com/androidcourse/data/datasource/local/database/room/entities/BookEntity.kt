package com.androidcourse.data.datasource.local.database.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey @ColumnInfo(name = "book_id")
    val book: String = "0",
    val name: String = ""
)
