package org.lotka.xenonx.domain.response

import org.lotka.xenonx.domain.models.Movies


data class MovieResponse(

    val page: Int,

     val results: List<Movies>,

    val totalPages: Int,

    val totalResults: Int
)
