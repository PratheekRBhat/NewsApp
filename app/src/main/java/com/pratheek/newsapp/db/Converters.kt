package com.pratheek.newsapp.db

import androidx.room.TypeConverter
import com.pratheek.newsapp.responses.Source

//Type converters are used to convert non-primitive data types to primitive data types as Room cannot handle them by itself.
class Converters {
    @TypeConverter
    fun fromSource(source: Source) : String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String) : Source {
        return Source(name, name)
    }
}