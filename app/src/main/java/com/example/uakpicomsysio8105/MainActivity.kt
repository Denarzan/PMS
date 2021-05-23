package com.example.uakpicomsysio8105

import android.os.Bundle
import android.view.View
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.intrusoft.scatter.PieChart
import com.jjoe64.graphview.GraphView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_graphic))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val coordinate = CoordinateND(1, 1, -1, Direction.LENGTH)
        val coordinate1 = CoordinateND(1, 1, 1, Direction.LENGTH)

        println(coordinate.getDegreesSecondsMinutesDirection())
        println(coordinate.getDegreesSecondsMinutesDirectionDouble())
        println(coordinate.averageCoordinate(coordinate1))
        println(coordinate.averageCoordinateTwoParameters(coordinate, coordinate1))
    }
    fun onChangeChartClick(view: View) {
        val graph = findViewById<GraphView>(R.id.graph)
        val pieChart = findViewById<PieChart>(R.id.pie_chart)

        if (graph.visibility == View.GONE) {
            graph.visibility = View.VISIBLE
            pieChart.visibility = View.GONE
        } else {
            graph.visibility = View.GONE
            pieChart.visibility = View.VISIBLE
        }
    }
}