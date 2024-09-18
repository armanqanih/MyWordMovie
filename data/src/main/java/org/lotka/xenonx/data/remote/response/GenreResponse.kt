package org.lotka.xenonx.data.remote.response

import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.data.remote.Dto.models.toGenre
import org.lotka.xenonx.data.remote.Dto.models.GenreDto
import org.lotka.xenonx.domain.response.GenreResponse

data class GenreResponseDto(
    @SerializedName("genres")
    val genres: List<GenreDto>
)


fun GenreResponseDto.toGenreResponse(): GenreResponse {
    return GenreResponse(
        genres = genres.map { it.toGenre() }
    )
}