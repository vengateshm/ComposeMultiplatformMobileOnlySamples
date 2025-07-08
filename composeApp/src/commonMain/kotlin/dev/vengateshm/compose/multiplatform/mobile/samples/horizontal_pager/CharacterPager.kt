package dev.vengateshm.compose.multiplatform.mobile.samples.horizontal_pager

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vengateshm.compose.multiplatform.mobile.samples.color_picker.colorList
import org.jetbrains.compose.resources.painterResource

@Composable
fun CharacterApp(modifier: Modifier = Modifier) {
    val characters = remember { characters }
    CharacterPager(characters)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterPager(characters: List<Character>) {
    val pagerState = rememberPagerState { characters.size }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            pageSize = PageSize.Fixed(pageSize = 250.dp),
            contentPadding = PaddingValues(horizontal = 90.dp),
            state = pagerState
        ) { index ->
            CharacterCard(characters[index], pagerState.currentPage == index)
        }
    }
}

@Composable
fun CharacterCard(
    character: Character,
    isSelected: Boolean
) {

    /*val imageXOffset = remember { androidx.compose.animation.core.Animatable(-20f) }
    val imageAlpha = remember { androidx.compose.animation.core.Animatable(0.5f) }

    LaunchedEffect(isSelected) {
        launch {
            imageXOffset.animateTo(
                targetValue = if (isSelected) 20f else -20f,
                animationSpec = tween(durationMillis = 1000)
            )
        }
        launch {
            imageAlpha.animateTo(
                targetValue = if (isSelected) 1f else 0.5f,
                animationSpec = tween(durationMillis = 1000)
            )
        }
    }*/

    val updateTransition = updateTransition(targetState = isSelected)
    val imageXOffset by updateTransition.animateFloat(
        transitionSpec = { tween(durationMillis = 1000) },
        label = "xOffset",
        targetValueByState = {
            if (isSelected) 20f else -20f
        }
    )
    val imageAlpha by updateTransition.animateFloat(
        transitionSpec = { tween(durationMillis = 1000) },
        label = "alpha",
        targetValueByState = {
            if (isSelected) 1f else 0.5f
        }
    )

    Box(
        modifier = Modifier.size(width = 250.dp, height = 300.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Card(
            modifier = Modifier.padding(end = 40.dp).fillMaxSize(),
            colors = CardDefaults.cardColors(containerColor = character.bgColor),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ) {
                AnimatedVisibility(
                    visible = isSelected,
                    enter = slideInVertically(),
                    exit = slideOutVertically()
                ) {
                    Text(
                        text = character.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
                AnimatedVisibility(
                    visible = isSelected,
                    enter = slideInVertically { it },
                    exit = slideOutVertically { it }
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 35.dp)
                            .graphicsLayer {
                                rotationZ = 270f
                            },
                        text = character.species.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }
        }
        Image(
            alpha = imageAlpha,
            painter = painterResource(character.photo),
            contentDescription = null,
            modifier = Modifier.size(230.dp)
                .offset(x = imageXOffset.dp)
        )
    }
}