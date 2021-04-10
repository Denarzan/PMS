package com.example.uakpicomsysio8105.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uakpicomsysio8105.R
import com.intrusoft.scatter.ChartData
import com.intrusoft.scatter.PieChart
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class GraphicFragment : Fragment() {

    private lateinit var graph: GraphView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_graphic, container, false)
        return root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        init()
        drawGraph()
        drawPieChart()
    }


    private fun init() {
        graph = requireView().findViewById(R.id.graph)
    }

    private fun drawPieChart() {
        val pieChart = requireView().findViewById(R.id.pie_chart) as PieChart
        val data = ArrayList<ChartData>()
        data.add(ChartData("Brown 5%", 5f, Color.WHITE, Color.parseColor("#A52A2A")))
        data.add(ChartData("Blue 5%", 5f, Color.WHITE, Color.BLUE))
        data.add(ChartData("Orange 10%", 10f, Color.BLACK, Color.parseColor("#FFA500")))
        data.add(ChartData("Dark blue 80%", 80f, Color.WHITE, Color.parseColor("#00008B")))
        pieChart.setChartData(data)
    }

    private fun drawGraph() {
        val start = 2 * (-Math.PI)
        val end = 2 * Math.PI
        val maxPoints = 100
        val arrOfX: DoubleArray = funcX(start, end, maxPoints)
        val arrOfY = DoubleArray(maxPoints) { sinFun(arrOfX[it]) }
        val series = LineGraphSeries<DataPoint>()

        for (i in 0 until maxPoints)
            series.appendData(DataPoint(arrOfX[i], arrOfY[i]), false, arrOfX.size)

        graph.viewport.isXAxisBoundsManual = true
        graph.viewport.setMaxX(end)
        graph.viewport.setMinX(start)
        graph.viewport.isYAxisBoundsManual = true
        graph.viewport.setMaxY(2.0)
        graph.viewport.setMinY(-2.0)
        graph.addSeries(series)
    }

    private fun sinFun(x: Double) = Math.sin(x)

    private fun funcX(start: Double, stop: Double, num: Int) =
            DoubleArray(num) { start + it * ((stop - start) / (num - 1)) }
}