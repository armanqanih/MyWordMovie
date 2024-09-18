package org.lotka.xenonx.data.remote.response

import org.lotka.xenonx.domain.models.Search
import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.data.remote.Dto.models.SearchDto

class MultiSearchResponseDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<SearchDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
