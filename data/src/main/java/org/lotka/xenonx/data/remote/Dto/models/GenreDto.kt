package org.lotka.xenonx.data.remote.Dto.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import org.lotka.xenonx.domain.models.Genre


@Parcelize
data class GenreDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String
): Parcelable

fun GenreDto.toGenre(): Genre {
    return Genre(
        id = id,
        name = name
    )

}