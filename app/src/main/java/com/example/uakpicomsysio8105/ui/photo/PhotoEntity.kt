package com.example.uakpicomsysio8105.ui.photo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var image: ByteArray? = null
)