<template>
  <div class="bg-gray-100 min-h-screen flex">
    <!-- Sidebar -->
    <aside class="w-64 bg-custom-bg shadow-md h-screen">
      <div class="p-4">
        <h2 class="text-2xl font-semibold text-white">System Monitor</h2>
      </div>
      <nav class="mt-4">
        <a href="#" class="block py-2 px-4 text-white hover:bg-gray-200">
          <img :src="require('@/assets/house-fill.svg')" class="w-6 h-6 inline-block mr-1" alt="Dashboard Icon" />
          Dashboard
        </a>
        <a href="#" class="block py-2 px-4 text-white hover:bg-gray-200">
          CPU
        </a>
        <a href="#" class="block py-2 px-4 text-white hover:bg-gray-200">
          RAM
        </a>
        <a href="#" class="block py-2 px-4 text-white hover:bg-gray-200">
          Storage
        </a>
        <a href="#" class="block py-2 px-4 text-white hover:bg-gray-200">
          GPU
        </a>
      </nav>
    </aside>

    <!-- Main Content -->
    <div class="flex-1 p-8">
      <h1 class="text-3x1 font-bold mb-8">Dashboard Overview</h1>
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
        <!-- CPU Card -->
        <div class="bg-white rounded-lg shadow-md p-6">
          <h2 class="text-xl font-semibold mb-4">CPU</h2>
          <p>Temperature: {{ cpuTemp }}°C</p>
          <p>Speed: {{ cpuSpeed }} GHz</p>
          <p>Usage: {{ cpuUsage }}%</p>
        </div>
        <!-- RAM Card -->
        <div class="bg-white rounded-lg shadow-md p-6">
          <h2 class="text-xl font-semibold mb-4">RAM</h2>
          <p>Speed: {{ ramSpeed }} MHz</p>
          <p>Usage: {{ ramUsage }}%</p>
        </div>
        <!-- Storage Card -->
        <div class="bg-white rounded-lg shadow-md p-6">
          <h2 class="text-xl font-semibold mb-4">Storage</h2>
          <p>Capacity: {{ storageCapacity }} GB</p>
          <p>Usage: {{ storageUsage }}%</p>
        </div>
        <!-- GPU Card -->
        <div class="bg-white rounded-lg shadow-md p-6">
          <h2 class="text-xl font-semibold mb-4">GPU</h2>
          <p>Speed: {{ gpuSpeed }} MHz</p>
          <p>Usage: {{ gpuUsage }}%</p>
        </div>
        </div>

      <div class="mt-8">
        <div class="bg-white rounded-lg shadow-md p-6">
          <h3 class="text-xl font-semibold mb-4">System Health Overview</h3>
          <div class="flex items-center justify-between">
            <div>
              <p class="text-gray-600">Overall Status</p>
              <p class="text-2xl font-bold text-green-500">Good</p>
            </div>
            <div>
              <p class="text-gray-600">Last Check</p>
              <p class="text-lg">{{ lastCheckTime }}</p>
            </div>
            <div>
              <p class="text-gray-600">Uptime</p>
              <p class="text-lg">{{ systemUptime }}</p>
            </div>
          </div>
        </div>
      </div>
      <div class="bg-white mt-8 rounded-lg" style="width: 50%; height: 500px;">
      <LineChart />
      </div>


    </div>
  </div>

 


</template>

<script>
import LineChart from './LineChart.vue';

export default {
  name: 'SystemMonitorDashboard',
  components: {
   LineChart
  },
  data() {
    return {
      cpuTemp: 0,
      cpuSpeed: 0,
      cpuUsage: 0,
      ramSpeed: 0,
      ramUsage: 0,
      storageCapacity: 0,
      storageUsage: 0,
      gpuSpeed: 0,
      gpuUsage: 0,
    }
  },
  mounted() {
    this.fetchData()
    setInterval(this.fetchData, 5000)
  },
  methods: {
    fetchData() {
      // Mock data - replace with actual API calls
      this.cpuTemp = Math.floor(Math.random() * 30) + 40
      this.cpuSpeed = (Math.random() * 2 + 2).toFixed(2)
      this.cpuUsage = Math.floor(Math.random() * 100)
      this.ramSpeed = Math.floor(Math.random() * 1000) + 2000
      this.ramUsage = Math.floor(Math.random() * 100)
      this.storageCapacity = 1000
      this.storageUsage = Math.floor(Math.random() * 100)
      this.gpuSpeed = Math.floor(Math.random() * 500) + 1000
      this.gpuUsage = Math.floor(Math.random() * 100)
    }
  }
}
</script>