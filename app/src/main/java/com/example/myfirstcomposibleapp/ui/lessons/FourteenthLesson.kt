package com.example.myfirstcomposibleapp.ui.lessons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposibleapp.R
import com.example.myfirstcomposibleapp.ui.model.ImageWithText
import com.example.myfirstcomposibleapp.ui.model.StoryHighLight

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 15/08/2022.
 */
@Composable
fun MyFourteenthLesson() {
    PhilippProfileInstagram()
}

@Composable
private fun PhilippProfileInstagram() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "philipplancker_offical", Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection(image = painterResource(id = R.drawable.philipp_photo), isExistComment = true)
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection()
        Spacer(modifier = Modifier.height(25.dp))
        HighLightSection(
            highLights = listOf(
                StoryHighLight(painterResource(id = R.drawable.image_youtube), "YouTube"),
                StoryHighLight(painterResource(id = R.drawable.image_qa), "Q&A"),
                StoryHighLight(painterResource(id = R.drawable.image_discord), "Discord"),
                StoryHighLight(painterResource(id = R.drawable.image_telegram), "Telegram")
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageWithText(image = painterResource(id = R.drawable.ic_grid), "Posts"),
                ImageWithText(image = painterResource(id = R.drawable.ic_movio), "Reels"),
                ImageWithText(image = painterResource(id = R.drawable.ic_tv), "IGTV"),
                ImageWithText(image = painterResource(id = R.drawable.ic_profile), "Profile")
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> {
                PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.philipp_photo),
                        painterResource(id = R.drawable.image_youtube),
                        painterResource(id = R.drawable.image_telegram),
                        painterResource(id = R.drawable.image_discord),
                        painterResource(id = R.drawable.image_qa)
                    )
                )
            }
            1 -> {
                PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.ice)
                    )
                )
            }
        }
    }
}

@Composable
private fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back", tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .clickable {

                }
        )
        Text(text = name, overflow = TextOverflow.Ellipsis, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back", tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .clickable {

                }
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = "Back", tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
                .clickable {

                }
        )

    }
}

@Composable
private fun ProfileSection(
    image: Painter = painterResource(id = R.drawable.philipp_photo),
    postsCount: String = "601",
    followerCount: String = "99.3K",
    followsCount: String = "72",
    isExistComment: Boolean = false,
    displayName: String = "Programming Mentor",
    description: String = "10 years of coding experiences\n" +
            "Want me to make your app? Send me an email!\n" +
            "Subscribe to my YouTebe channel!",
    url: String = "https://youtube.com/c/PhilippLanker",
    followedBy: List<String> = listOf("codinginflow", "miakhalifa"),
    otherCount: Int = 17,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            RoundedImage(
                image = image, modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StateSection(postCount = postsCount, followersCount = followerCount, followsCount = followsCount, Modifier.weight(7f))
        }
        if (isExistComment) {
            ProfileDescription(displayName = displayName, description = description, url = url, followedBy = followedBy, otherCount = otherCount)
        }
    }
}

@Composable
private fun RoundedImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = "Profile Image",
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape), contentScale = ContentScale.Crop
    )
}

@Composable
private fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)
                    append("Followed by ")
                    followedBy.forEachIndexed { index, item ->
                        pushStyle(boldStyle)
                        append(item)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
private fun StateSection(postCount: String, followersCount: String, followsCount: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround, modifier = modifier
    ) {
        ProfileStat(numberText = postCount, text = "Posts")
        ProfileStat(numberText = followersCount, text = "Followers")
        ProfileStat(numberText = followsCount, text = "Following")
    }
}

@Composable
private fun ProfileStat(numberText: String, text: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text
        )
    }
}

@Composable
private fun ButtonSection(modifier: Modifier = Modifier) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier.fillMaxWidth()) {
        ActionButton(
            text = "Following", icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )
    }
}

@Composable
private fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
private fun HighLightSection(
    modifier: Modifier = Modifier,
    highLights: List<StoryHighLight>
) {
    LazyRow(modifier = modifier) {
        items(highLights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundedImage(image = highLights[it].image, Modifier.size(70.dp))
                Text(text = highLights[it].text, overflow = TextOverflow.Ellipsis, textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
private fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTab by remember {
        mutableStateOf(0)
    }
    val inActiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTab,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(selected = selectedTab == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inActiveColor, onClick = {
                    selectedTab = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image, contentDescription = item.text,
                    tint = if (selectedTab == index) Color.Black else inActiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = modifier.scale(1.01f)) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp, color = Color.White)
            )
        }
    }
}