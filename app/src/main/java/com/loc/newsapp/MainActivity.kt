package com.loc.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.loc.newsapp.presentation.onboarding.component.OnBoardingScreen
import com.loc.newsapp.presentation.onboarding.ui.onboarding.OnBoardingViewModel
import com.loc.newsapp.ui.theme.NewsAppTheme
import com.loc.newsapp.usecases.AppEntryUseCases
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var usesCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()

        lifecycleScope.launch {
            usesCases.readAppEntry().collect() {
                Log.d("TAG", it.toString())
            }

        }

        setContent {
            NewsAppTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val viewModel: OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                        event = viewModel::onEvent
                        //or
                        /*event = {
                            viewModel.onEvent(it)
                        }*/
                    )
                }
            }
        }
    }
}
