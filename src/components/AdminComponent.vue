<template>
<h1>Admin</h1>
  <div>{{info}}}</div>

</template>

<script>
import axios from "axios"
export default {
  name: "AdminComponent",
  data(){
    return {
      info: []
    }
  },

  created() {
    axios.get("http://localhost:8000/admin", {method: "GET", cors: "no-cors"})
    .then(response => {console.log(response.data); this.info = response.data});
  }

}
</script>

<style scoped>

</style>