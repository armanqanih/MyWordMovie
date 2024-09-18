package org.lotka.xenonx.domain.response

import org.lotka.xenonx.domain.models.Cast


data class CastResponse(

    val id: Int,

    val castResult: List<Cast>
)
