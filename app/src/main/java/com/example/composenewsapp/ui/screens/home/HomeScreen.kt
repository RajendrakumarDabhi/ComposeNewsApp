package com.example.composenewsapp.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.composenewsapp.R
import com.example.composenewsapp.domain.models.Article
import com.example.composenewsapp.ui.common.ArticlesList
import com.example.composenewsapp.ui.common.Space
import com.example.composenewsapp.ui.navigation.Route
import com.example.composenewsapp.ui.theme.Dimens.MediumPadding1

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(listArticle: LazyPagingItems<Article>, navigate: (String) -> Unit) {
    val title by remember {
        derivedStateOf {
            if (listArticle.itemSnapshotList.size > 10) {
                listArticle.itemSnapshotList.items.slice(IntRange(0, 9))
                    .joinToString(" \uD83d\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding(), verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo",
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding1)
        )
        Space(value = MediumPadding1)
        SearchBar(
            modifier = Modifier
                .padding(horizontal = MediumPadding1)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = {
                navigate(Route.SearchScreen.route)
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(
            text = title, modifier = Modifier
                .fillMaxWidth()
                .padding(start = MediumPadding1)
                .basicMarquee(), fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticlesList(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            articles = listArticle,
            onClick = {
                //TODO: Navigate to Details Screen

            })
    }
}
