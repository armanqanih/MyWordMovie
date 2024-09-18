package org.lotka.xenonx.domain.response

import org.lotka.xenonx.domain.models.Search


class MultiSearchResponse(

    val page: Int,

    val results: List<Search>,

    val totalPages: Int,

    val totalResults: Int
)
