package org.lotka.xenonx.data.remote.response


import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.data.remote.Dto.models.CastDto

data class CastResponseDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("cast")
    val castResult: List<CastDto>
)
