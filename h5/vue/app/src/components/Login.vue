<template>
  <div class="login">
    <el-row>
      <el-col :span="6" :offset="8">
        <el-input v-model="username" placeholder="邮箱"></el-input>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="8">
        <el-input v-model="password" placeholder="密码" show-password></el-input>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      username: '',
      password: ''
    }
  }
}
</script>

<style scoped>

</style>
