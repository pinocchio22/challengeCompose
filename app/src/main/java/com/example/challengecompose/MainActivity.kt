package com.example.challengecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challengecompose.ui.theme.ChallengeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Button(onClick = {}) {
               Text(text = "로그인")
           }
            Text(text = "One Market")
        }
    }
}

@Composable
fun MyButton(onClick: () -> Unit,
             modifier: Modifier = Modifier,
             colors: Color = MaterialTheme.colors.primary,
             text: String = "") {
    Button(onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
    ) {
        Text(text)
    }
}

@Composable
fun Greeting(name: String) {

    var title by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopCenter)
            ) {
            Text(text = "Search",
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = title,
                onValueChange = { title = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "이메일") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "비밀번호") }
            )
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
        ) {

            MyButton(onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = Color.Cyan,
                text = "건너뛰기"
            )
            MyButton(onClick = {},
                modifier = Modifier.fillMaxWidth(),
                text = "등록하기"
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ChallengeComposeTheme {
//        Greeting("Android")
//        a()
    }
}

@Composable
fun a() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "twg.official",
        modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Text(
                text = "[19차 리오더] 페이크 레더 숏 테일러 자켓 블랙(1 color)",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .then(
                        Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )
            )
            Icon(imageVector = Icons.Default.Favorite,
                contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        Row() {
            Text(text = "정상가", modifier = Modifier.padding(horizontal = 16.dp))
            Text(text = "99,800원")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Divider()

        Text(text = "상품설명", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    Box(Modifier.fillMaxSize()) {
        if (query.isEmpty()) {
            SearchHint()
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
        ) {
            TextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun SearchHint() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = "검색 아이콘"
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = "검색어를 입력해주세요",
        )
    }
}

@Preview
@Composable
fun PreviewSearchBar() {
    ChallengeComposeTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 24.dp)
        ) {
            var title by remember { mutableStateOf("") }
            SearchBar(query = title, onQueryChange = { title = it })
        }
    }
}