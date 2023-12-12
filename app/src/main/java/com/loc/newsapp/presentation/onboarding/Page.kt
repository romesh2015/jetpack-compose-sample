package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,

    )

var pages = listOf(
    Page(
        title = "Job Brief",
        description = "We are looking for a QA Tester to assess software quality through manual and automated testing. You will be responsible for finding and reporting bugs and glitches.\n",
        image = R.drawable.sample1
    ),
    Page(
        title = "Responsibilities",
        description = "Review and analyze system specifications\n" +
                "Collaborate with QA Engineers to develop effective strategies and test plans\n" +
                "Execute test cases (manual or automated) and analyze results",
        image = R.drawable.sample2
    ),
    Page(
        title = "Requirements and skills",
        description = "Proven experience as a Quality Assurance Tester or similar role\n" +
                "Experience in project management and QA methodology\n" +
                "Familiarity with Agile frameworks and regression testing is a plus",
        image = R.drawable.sample3
    )
)
