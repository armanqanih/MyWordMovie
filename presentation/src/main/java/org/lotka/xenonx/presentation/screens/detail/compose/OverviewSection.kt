package org.lotka.xenonx.presentation.screens.detail.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium


@Composable
fun OverviewSection(
    overview: String?,
    tagline: String?
) {
    Column {
        Text(
            modifier = Modifier.padding(horizontal = 22.dp),
            text = tagline ?: ("In a world where loyalty is tested,\" +\n" +
                    "                    \" and alliances are broken, \" +\n" +
                    "                    \"former elite soldier Alex Grayson \" +\n" +
                    "                    \"is forced out of hiding when a secret \" +\n" +
                    "                    \"government agency frames him for a crime he didn’t commit.\" +\n" +
                    "                    \" With the clock ticking and enemies on all sides, \" +\n" +
                    "                    \"Alex embarks on a deadly mission to clear his name \" +\n" +
                    "                    \"and stop a shadowy organization from unleashing chaos \" +\n" +
                    "                    \"across the globe."),
            fontSize = 17.sp,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colors.onBackground,        )

        Spacer(modifier = Modifier.height(SpaceMedium))


        Text(
            modifier = Modifier.padding(horizontal = 22.dp),
            text = overview?:"",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground,
            lineHeight = 16.sp
        )

    }
}