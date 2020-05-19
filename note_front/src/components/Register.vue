<template>
  <div>
    <el-form ref="form" :model="registerForm" label-width="80px">
      <el-form-item >
        <el-input  placeholder="请输入用户名" v-model="registerForm.username"></el-input>
      </el-form-item>
        <el-form-item>
            <el-input placeholder="请输入密码" v-model="registerForm.password" show-password></el-input>
        </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
    export default {
        name: "Register",
        data(){
            return {
                registerForm:{
                    username: '',
                    password: '',
                }
            }
        },
        methods:{
            onSubmit(){
              this.axios.post("/register",{
                username: this.registerForm.username,
                password: this.registerForm.password,
              })
              .then(function (response){
                console.log(response)
              })
              .catch(function(error){
                console.log(this.axios.post)
                console.log(error)
              })
            }
        }
    }


</script>