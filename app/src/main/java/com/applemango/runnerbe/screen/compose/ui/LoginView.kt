package com.applemango.runnerbe.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.applemango.runnerbe.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.applemango.runnerbe.model.viewmodel.SplashViewModel

@Composable
fun LoginView(
    navController: NavController,
    viewModel: SplashViewModel = viewModel()
) {
    val isTokenCheck = viewModel.isTokenLogin.observeAsState()
    var isLoginViewVisible = isTokenCheck.value ?: true
    viewModel.isTokenCheck()
    isTokenCheck.value?.let { isLoginViewVisible = it }
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.black_background))
            .fillMaxSize()
    ) {
        LogoAndTextView(
            Modifier.fillMaxWidth().align(Alignment.Center).padding(bottom = 165.dp)
        )
        if(!isLoginViewVisible) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)
            ) {
                KakaoLoginView(
                    Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    navController
                )
                Spacer(modifier = Modifier.height(16.dp))
                NaverLoginView(
                    Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    navController
                )
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Composable
fun LogoAndTextView(modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo_runnerbe),
            contentDescription = "logo"
        )
        Text(
            stringResource(id = R.string.runner_be),
            color = colorResource(id = R.color.primary),
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun KakaoLoginView(modifier: Modifier, navController: NavController) {
    Button(
        onClick = { /* 여기에 카카오 로그인 기능 첨부 */ },
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.kakao_yellow)),
        modifier = modifier
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_kakao_logo),
                contentDescription = "kakao logo",
                modifier = Modifier.align(Alignment.TopStart)
            )
            Text(
                text = stringResource(id = R.string.login_kakao),
                color = colorResource(id = R.color.black_19),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun NaverLoginView(modifier: Modifier, navController: NavController) {
    Button(
        onClick = { /* 여기에 카카오 로그인 기능 첨부 */ },
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.naver_green)),
        modifier = modifier
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_naver_logo),
                contentDescription = "naver logo",
                modifier = Modifier.align(Alignment.TopStart)
            )
            Text(
                text = stringResource(id = R.string.login_naver),
                color = colorResource(id = R.color.white),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun LogoPreView() {
    LoginView(rememberNavController())
}