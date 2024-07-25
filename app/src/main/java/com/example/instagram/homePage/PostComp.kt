package com.example.instagram.homePage


import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.R
import com.example.instagram.ui.theme.activeDotColor
import com.example.instagram.ui.theme.blueColorLighter
import com.example.instagram.ui.theme.deActiveDotColor
import com.example.instagram.ui.theme.mainBlueColor
import com.example.instagram.ui.theme.officialColor
import com.example.instagram.ui.theme.pageCountBGCColor
import com.example.instagram.ui.theme.pageCountFontColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue


@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PostsComp(model: InstagramMainVM) {


    // model.testAnimation()
    val pullToRefreshState = rememberPullToRefreshState(positionalThreshold = 50.dp)


    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp
    LaunchedEffect(Unit) {
        model.GetFeedFunctionallity()
    }

    Box {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .offset(y = (pullToRefreshState.verticalOffset / 2).dp)
                .nestedScroll(pullToRefreshState.nestedScrollConnection),
            //   .background(Color.Red)

        ) {


            item {
                StorysComp(model)
            }

            item {

                Column(Modifier.fillMaxWidth()) {
                    AnimatedVisibility(model.startUpload.value) {
                        Column {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .clickable { }
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(30.dp)
                                            .background(Color.LightGray)
                                    )

                                    Spacer(modifier = Modifier.width(10.dp))

                                    Text(
                                        text = "Posting",
                                        fontWeight = FontWeight(600),
                                        fontSize = 14.sp,
                                        maxLines = 1,
                                        textAlign = TextAlign.Center,
                                        color = MaterialTheme.colorScheme.onTertiary,
                                    )
                                }

                                Icon(
                                    modifier = Modifier.size(12.dp),
                                    tint = MaterialTheme.colorScheme.surfaceTint,
                                    painter = painterResource(id = R.drawable.arrowdown),
                                    contentDescription = "upload post icon"
                                )
                            }
                            LinearProgressIndicator(
                                progress = model.percentUpload.value,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(3.dp),
                                strokeCap = StrokeCap.Butt,
                                color = mainBlueColor,
                                backgroundColor = blueColorLighter,
                            )
                        }

                    }
                    AnimatedVisibility(visible = model.uploaded.value) {

                        var targetValue by remember {
                            mutableStateOf(26)
                        }
                        val clickAnimation by animateIntAsState(
                            targetValue = targetValue,
                            animationSpec = tween(durationMillis = 200)
                        )
                        val coroutineScope = rememberCoroutineScope()

                        var targetValue2 by remember {
                            mutableStateOf(26)
                        }
                        val clickAnimation2 by animateIntAsState(
                            targetValue = targetValue2,
                            animationSpec = tween(durationMillis = 200)
                        )
                        val coroutineScope2 = rememberCoroutineScope()


                        val liked = remember {
                            mutableStateOf(model.uploadedPost["like"] as Boolean)
                        }
                        val likeCounts = remember {
                            mutableStateOf(model.uploadedPost["likeCount"] as Int)
                        }
                        val saved = remember {
                            mutableStateOf(model.uploadedPost.get("save") as Boolean)
                        }



                        Column(Modifier.fillMaxWidth()) {
                            //Text(text = "${model.CalculateTime(post.get("created_at") as String)}")
                            //profile info Row
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(35.dp)
                                            .clip(RoundedCornerShape(100))
                                            .background(Color.LightGray)
                                            .clickable { }
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Column {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                text = "${model.uploadedPost["name"] as String}",
                                                fontWeight = FontWeight(600),
                                                fontSize = 15.sp,
                                                maxLines = 1,
                                                textAlign = TextAlign.Center,
                                                color = MaterialTheme.colorScheme.tertiary,
                                                overflow = TextOverflow.Ellipsis

                                            )
                                            if (model.uploadedPost["official"] as Boolean) {
                                                Spacer(modifier = Modifier.width(4.dp))
                                                Icon(
                                                    modifier = Modifier.size(12.dp),
                                                    tint = officialColor,
                                                    painter = painterResource(id = R.drawable.official_icon),
                                                    contentDescription = "official icon"
                                                )
                                            }


                                        }
                                        if (model.uploadedPost["place"] as String != "") {
                                            Text(
                                                text = "${model.uploadedPost["place"] as String}",
                                                fontWeight = FontWeight(400),
                                                fontSize = 12.sp,
                                                maxLines = 1,
                                                textAlign = TextAlign.Center,
                                                color = MaterialTheme.colorScheme.surfaceTint,
                                                overflow = TextOverflow.Ellipsis

                                            )
                                        }


                                    }
                                }

                                IconButton(onClick = {}
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.more_icon),
                                        modifier = Modifier.size(16.dp),
                                        contentDescription = "moreIcon",
                                        tint = MaterialTheme.colorScheme.surfaceTint
                                    )
                                }

                            }
                            //post Content
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(screenWidth.dp)
                                    .background(Color.LightGray)
                            ) {

                                Box(
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                    ) {
                                        AsyncImage(
                                            modifier = Modifier.fillMaxSize(),
                                            model = model.uploadedPost["content"] as String,
                                            contentDescription = "Image of post",
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }


                            }

                            //bottom of post
                            Column(Modifier.fillMaxWidth()) {
                                //row 1
                                Box(
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(top = 5.dp)
                                )
                                {

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.align(Alignment.CenterStart)
                                    ) {
                                        IconButton(onClick = {

                                            coroutineScope.launch {
                                                targetValue = 24
                                                delay(100)
                                                targetValue = 26

                                            }
                                            liked.value = !liked.value
                                            if (liked.value == true) {
                                                likeCounts.value += 1
                                            } else {
                                                likeCounts.value -= 1
                                            }

                                            model.LikeFunctionallity(model.uploadedPost["id"] as String)
                                        }
                                        ) {
                                            Icon(
                                                painter = painterResource(if (liked.value) R.drawable.fillheart_icon else R.drawable.like),
                                                modifier = Modifier.size(clickAnimation.dp),
                                                contentDescription = "postIcon",
                                                tint = if (liked.value) Color.Red else MaterialTheme.colorScheme.surfaceTint
                                            )
                                        }
                                        IconButton(onClick = {}
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.comment),
                                                modifier = Modifier.size(26.dp),
                                                contentDescription = "postIcon",
                                                tint = MaterialTheme.colorScheme.surfaceTint
                                            )
                                        }
                                        IconButton(onClick = {}
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.messanger),
                                                modifier = Modifier.size(26.dp),
                                                contentDescription = "postIcon",
                                                tint = MaterialTheme.colorScheme.surfaceTint
                                            )
                                        }
                                    }


                                    Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                                        IconButton(onClick = {
                                            coroutineScope2.launch {
                                                targetValue2 = 24
                                                delay(100)
                                                targetValue2 = 26

                                            }
                                            saved.value = !saved.value
                                        }
                                        ) {
                                            Icon(
                                                painter = painterResource(if (saved.value) R.drawable.savefill else R.drawable.save),
                                                modifier = Modifier.size(clickAnimation2.dp),
                                                contentDescription = "postIcon",
                                                tint = MaterialTheme.colorScheme.surfaceTint
                                            )
                                        }
                                    }


                                }

                                //row 2
                                if (likeCounts.value != 0) {
                                    Row(
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(start = 15.dp, end = 15.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    )
                                    {
                                        Text(
                                            text = "${likeCounts.value} likes",
                                            fontWeight = FontWeight(500),
                                            fontSize = 15.sp,
                                            maxLines = 1,
                                            textAlign = TextAlign.Center,
                                            color = MaterialTheme.colorScheme.tertiary,
                                        )


                                    }
                                }


                                //row 3
                                if (model.uploadedPost["text"] as String != "") {
                                    Row(
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                start = 15.dp,
                                                end = 15.dp,
                                                top = 5.dp,
                                                bottom = 5.dp
                                            ),
                                        verticalAlignment = Alignment.CenterVertically
                                    )
                                    {

                                        Text(
                                            text = buildAnnotatedString {
                                                withStyle(
                                                    style = SpanStyle(
                                                        fontWeight = FontWeight(500),
                                                        fontSize = 15.sp,
                                                        color = MaterialTheme.colorScheme.tertiary,
                                                    )
                                                )
                                                {
                                                    append("${model.uploadedPost["name"]} ")
                                                }

                                                withStyle(
                                                    style = SpanStyle(
                                                        fontWeight = FontWeight(400),
                                                        fontSize = 15.sp,
                                                        color = MaterialTheme.colorScheme.tertiary,
                                                    )
                                                )
                                                {
                                                    append("${model.uploadedPost["text"]}")
                                                }
                                            },

                                            )


                                    }

                                }


                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                )
                                {
                                    Text(
                                        text = "${model.CalculateTime(model.uploadedPost.get("created_at") as String)}",
                                        fontWeight = FontWeight(400),
                                        fontSize = 11.sp,
                                        maxLines = 1,
                                        textAlign = TextAlign.Center,
                                        color = MaterialTheme.colorScheme.tertiary,
                                    )


                                }


                            }
                        }

                    }

                }

            }

            items(model.PostsMapList.value) { post ->
                var targetValue by remember {
                    mutableStateOf(26)
                }
                val clickAnimation by animateIntAsState(
                    targetValue = targetValue,
                    animationSpec = tween(durationMillis = 200)
                )
                val coroutineScope = rememberCoroutineScope()

                var targetValue2 by remember {
                    mutableStateOf(26)
                }
                val clickAnimation2 by animateIntAsState(
                    targetValue = targetValue2,
                    animationSpec = tween(durationMillis = 200)
                )
                val coroutineScope2 = rememberCoroutineScope()


                val liked = remember {
                    mutableStateOf(post.get("like") as Boolean)
                }
                val likeCounts = remember {
                    mutableStateOf(post["likeCount"] as Int)
                }
                val saved = remember {
                    mutableStateOf(post.get("save") as Boolean)
                }



                Column(Modifier.fillMaxWidth()) {
                    //Text(text = "${model.CalculateTime(post.get("created_at") as String)}")
                    //profile info Row
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(35.dp)
                                    .clip(RoundedCornerShape(100))
                                    .background(Color.LightGray)
                                    .clickable { }
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "${post["name"] as String}",
                                        fontWeight = FontWeight(600),
                                        fontSize = 15.sp,
                                        maxLines = 1,
                                        textAlign = TextAlign.Center,
                                        color = MaterialTheme.colorScheme.tertiary,
                                        overflow = TextOverflow.Ellipsis

                                    )
                                    if (post["official"] as Boolean) {
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Icon(
                                            modifier = Modifier.size(12.dp),
                                            tint = officialColor,
                                            painter = painterResource(id = R.drawable.official_icon),
                                            contentDescription = "official icon"
                                        )
                                    }


                                }
                                if (post["place"] as String != "") {
                                    Text(
                                        text = "${post["place"] as String}",
                                        fontWeight = FontWeight(400),
                                        fontSize = 12.sp,
                                        maxLines = 1,
                                        textAlign = TextAlign.Center,
                                        color = MaterialTheme.colorScheme.surfaceTint,
                                        overflow = TextOverflow.Ellipsis

                                    )
                                }


                            }
                        }

                        IconButton(onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.more_icon),
                                modifier = Modifier.size(16.dp),
                                contentDescription = "moreIcon",
                                tint = MaterialTheme.colorScheme.surfaceTint
                            )
                        }

                    }
                    //post Content
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(screenWidth.dp)
                            .background(Color.LightGray)
                    ) {

                        Box(
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                AsyncImage(
                                    modifier = Modifier.fillMaxSize(),
                                    model = post["content"] as String,
                                    contentDescription = "Image of post",
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }


                    }

                    //bottom of post
                    Column(Modifier.fillMaxWidth()) {
                        //row 1
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp)
                        )
                        {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.align(Alignment.CenterStart)
                            ) {
                                IconButton(onClick = {

                                    coroutineScope.launch {
                                        targetValue = 24
                                        delay(100)
                                        targetValue = 26

                                    }
                                    liked.value = !liked.value
                                    if (liked.value == true) {
                                        likeCounts.value += 1
                                    } else {
                                        likeCounts.value -= 1
                                    }

                                    model.LikeFunctionallity(post["id"] as String)
                                }
                                ) {
                                    Icon(
                                        painter = painterResource(if (liked.value) R.drawable.fillheart_icon else R.drawable.like),
                                        modifier = Modifier.size(clickAnimation.dp),
                                        contentDescription = "postIcon",
                                        tint = if (liked.value) Color.Red else MaterialTheme.colorScheme.surfaceTint
                                    )
                                }
                                IconButton(onClick = {}
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.comment),
                                        modifier = Modifier.size(26.dp),
                                        contentDescription = "postIcon",
                                        tint = MaterialTheme.colorScheme.surfaceTint
                                    )
                                }
                                IconButton(onClick = {}
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.messanger),
                                        modifier = Modifier.size(26.dp),
                                        contentDescription = "postIcon",
                                        tint = MaterialTheme.colorScheme.surfaceTint
                                    )
                                }
                            }


                            Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                                IconButton(onClick = {
                                    coroutineScope2.launch {
                                        targetValue2 = 24
                                        delay(100)
                                        targetValue2 = 26

                                    }
                                    saved.value = !saved.value
                                }
                                ) {
                                    Icon(
                                        painter = painterResource(if (saved.value) R.drawable.savefill else R.drawable.save),
                                        modifier = Modifier.size(clickAnimation2.dp),
                                        contentDescription = "postIcon",
                                        tint = MaterialTheme.colorScheme.surfaceTint
                                    )
                                }
                            }


                        }

                        //row 2
                        if (likeCounts.value != 0) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(start = 15.dp, end = 15.dp),
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Text(
                                    text = "${likeCounts.value} likes",
                                    fontWeight = FontWeight(500),
                                    fontSize = 15.sp,
                                    maxLines = 1,
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.tertiary,
                                )


                            }
                        }

                        var expanded by remember {
                            mutableStateOf(false)
                        }

                        //row 3
                        if (post["text"] as String != "") {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),

                                )
                            {

                                ExpandableText(text = "${post["text"]}", name = "${post["name"]}")


                            }

                        }


                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Text(
                                text = "${model.CalculateTime(post.get("created_at") as String)}",
                                fontWeight = FontWeight(400),
                                fontSize = 11.sp,
                                maxLines = 1,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.tertiary,
                            )


                        }


                    }
                }

            }
        }

        //test purposes
        Column {
            Text(text = "--->>>${pullToRefreshState.verticalOffset}")
            Text(text = "--->>>${pullToRefreshState.progress}")
            Text(text = "--->>>${pullToRefreshState.positionalThreshold}")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            PullToRefreshContainer(
                state = pullToRefreshState,
                indicator = {
                        state ->
                        Crossfade(
                            targetState = state.isRefreshing,
                            animationSpec = tween(durationMillis = 500)
                        ) { refreshing ->
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                if (refreshing) {
                                    CircularProgressIndicator(
                                        strokeWidth = 5.dp,
                                        color = Color.Black,
                                        modifier = Modifier.size(20.dp),
                                    )
                                } else {
                                    Box(modifier = Modifier.size(10.dp).background(Color.Red))
                                }
                            }
                        }

                }
            )
        }
        if (pullToRefreshState.isRefreshing) {
            LaunchedEffect(true) {
                Log.d("refresh", "PostsComp: refreshing ")
                delay(1000)
                pullToRefreshState.endRefresh()
            }
        }
    }
}


@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    fontStyle: FontStyle? = null,
    text: String,
    collapsedMaxLine: Int = 2,
    showMoreText: String = "... more",
    showMoreStyle: SpanStyle = SpanStyle(fontWeight = FontWeight.W500),
    showLessText: String = "",
    showLessStyle: SpanStyle = showMoreStyle,
    textAlign: TextAlign? = null,
    name: String
) {
    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableStateOf(0) }
    Box(modifier = Modifier
        .clickable(clickable) {
            isExpanded = true
            clickable = false
        }
        .then(modifier)
    ) {
        Text(
            modifier = textModifier
                .fillMaxWidth()
                .animateContentSize(),
            text = buildAnnotatedString {

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight(500),
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.tertiary,
                    )
                )
                {
                    append("$name ")
                }
                if (clickable) {
                    if (isExpanded) {
                        append(text)
                        withStyle(style = showLessStyle) { append(showLessText) }
                    } else {
                        val adjustText = text.substring(startIndex = 0, endIndex = lastCharIndex)
                            .dropLast(showMoreText.length)
                            .dropLastWhile { Character.isWhitespace(it) || it == '.' }
                        append(adjustText)
                        withStyle(style = showMoreStyle) { append(showMoreText) }
                    }
                } else {
                    append(text)
                }
            },
            maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
            fontStyle = fontStyle,
            onTextLayout = { textLayoutResult ->
                if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                    clickable = true
                    lastCharIndex = textLayoutResult.getLineEnd(collapsedMaxLine - 1)
                }
            },
            style = style,
            textAlign = textAlign
        )
    }

}
