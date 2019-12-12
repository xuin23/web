<template>
  <div class="login">
    <el-container>
      <el-main style="margin: 200px 0">
        <el-row>
          <el-col :span="4" :offset="10">
            <el-form ref="form" :model="form" label-width="80px">
              <el-form-item>
                <el-input v-model="form.username" placeholder="邮箱"></el-input>
              </el-form-item>
              <el-form-item>
                <el-input v-model="form.password" placeholder="密码" show-password></el-input>
              </el-form-item>
              <el-form-item>
                <el-input v-model="form.securityCode" placeholder="验证码"/>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
                <el-button type="primary" @click="getSecurityCode" v-bind:disabled="buttonDisable">获取验证码</el-button>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
    <el-dialog title="提示" :visible.sync="centerDialogVisible" width="30%" center>
      <span>{{ msg }}</span>
      <span slot="footer" class="dialog-footer">
      <el-button @click="centerDialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="centerDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      form: {
        username: '',
        password: '',
        securityCode: ''
      },
      buttonDisable: false,
      centerDialogVisible: false,
      msg: ''
    }
  },
  methods: {
    onSubmit () {
      let data = new FormData()
      data.append('username', this.form.username)
      data.append('password', this.form.password)
      data.append('securityCode', this.form.securityCode)
      this.$http.post('/operator/login/operatorLogin', data).then((response) => {
        console.log(response)
        let res = response.data
        console.log(res)
        if (res.code === 200) {
          this.msg = res.object
          this.centerDialogVisible = true
        } else {
          this.msg = res.message
          this.centerDialogVisible = true
        }
      }).catch((error) => {
        console.log(error)
      })
    },
    getSecurityCode () {
      let data = new FormData()
      this.buttonDisable = true
      data.append('username', this.form.username)
      this.$http.post('/operator/login/loginSecurityCode', data).then((response) => {
        let res = response.data
        console.log(res)
        let _this = this
        if (res.code === 200) {
          setTimeout(function () {
            _this.buttonDisable = false
          }, 1000 * 6)
        }
      }).catch((error) => {
        console.log(error)
      })
    }
  }
}
</script>

<style scoped>

</style>
