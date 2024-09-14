package org.lotka.xenonx.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall

@Composable
fun StandardTextMore(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(SpaceMedium))
            .clickable { onClick() }
            .padding(2.dp)
        ,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
        ) {
        Text(
            text = "more",
            color =MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1,

            )
        Spacer(modifier = Modifier.height(Constants.SpaceSmall))
        Icon(
            modifier = Modifier.size(Constants.IconSizeSmall)
          ,
            imageVector = Icons.Default.ArrowForwardIos,
            contentDescription = "more",
            tint = MaterialTheme.colors.onBackground
            )
    }

}

@Composable
fun StandardHeaderText(
    modifier: Modifier=Modifier,
    showIcon:Boolean=false,
    colorIcon: Color = MaterialTheme.colors.onBackground,
    iconImage : ImageVector?=null,
    text: String
){
    Row (modifier = modifier){
        Text(
            text = text,
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6,

            )
        Spacer(modifier = Modifier.width(SpaceSmall))
        if (showIcon){
            iconImage?.let {
                Icon(imageVector = iconImage,
                    contentDescription ="icon",
                    tint = colorIcon
                    )
            }

            }
        }
    }

