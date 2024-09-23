<template>
  <Line
    id="my-chart-id"
    :options="chartOptions"
    :data="chartData"
  />
</template>

<script>
import { Line } from 'vue-chartjs'
import { Chart as ChartJS, Title, Tooltip, Legend, PointElement, LineElement, CategoryScale, LinearScale } from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, PointElement, LineElement, CategoryScale, LinearScale)

export default {
  name: 'LineChart',
  components: { Line },
  data() {
    return {
      chartData: {
        labels: [ 'January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December' ],
        datasets: [ { label: 'Monthly Power Consumption',
        backgroundColor: 'rgb(75, 192, 192)',
        data: [40, 20, 12, 39, 10, 40, 39, 60, 40, 20, 12, 11] } ]
      },
      chartOptions: {
        responsive: true
      }
    }
  }
}
</script>