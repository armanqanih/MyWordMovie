package org.lotka.xenonx.domain.response

import org.lotka.xenonx.domain.models.Genre


data class GenreResponse(
    val genres: List<Genre>
)