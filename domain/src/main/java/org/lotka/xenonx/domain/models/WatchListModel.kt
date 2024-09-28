package org.lotka.xenonx.domain.models





data class WatchListModel(
      val mediaId: Int,
    val imagePath: String?,
    val title: String,
    val releaseDate: String,
    val rating: Double,
    val addedOn: String
)
