package com.loc.newsapp.presentation.onboarding.component.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.loc.newsapp.presentation.onboarding.component.Dimens.indecatorSize
import com.loc.newsapp.ui.theme.BlueGray

@Composable
fun PageIndicator(
    modifier: Modifier,
    pageSize: Int,
    selectPage: Int,
    selectColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = BlueGray
) {
    Row (modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier.size(indecatorSize).clip(CircleShape)
                    .background(color = if (page == selectPage) selectColor else unselectedColor)
            )
        }

    }

}