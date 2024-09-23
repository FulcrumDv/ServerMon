<template>
  <div id="app">
    <SystemMonitorDashboard />
  </div>
</template>

<script>
import SystemMonitorDashboard from './components/Dashboard.vue'

export default {
  name: 'App',
  components: {
    SystemMonitorDashboard
  }
}
</script>

<style>
@import 'tailwindcss/base';
@import 'tailwindcss/components';
@import 'tailwindcss/utilities';
</style>