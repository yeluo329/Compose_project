package com.example.compose_project.navigation

import androidx.compose.ui.ExperimentalComposeUiApi
import coil.annotation.ExperimentalCoilApi

import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

@ExperimentalCoilApi
@ExperimentalComposeUiApi
object RootNavGraph: NavGraphSpec {

    override val route = "root"
    override val startRoute: Route
        get() = TODO("Not yet implemented")


    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()

//    override val startRoute = OnboardingNavGraph
//
//    override val nestedNavGraphs = listOf(
//        OnboardingNavGraph,
//    )
}