<template>
    <el-container style="height: 100%">
      <el-aside width="200px">
        <el-menu
          class="el-menu-vertical-demo"
          background-color="#D3DCE6"
          text-color="#333"
          active-text-color="#0A5AA8"
          style="height: 100%"
          :default-active="$route.path"
          router
        >
          <el-menu-item index="/hw1">
            <i class="el-icon-menu"></i>
            <span slot="title">题目一</span>
          </el-menu-item>
          <el-menu-item index="/hw2">
            <i class="el-icon-menu"></i>
            <span slot="title">题目二</span>
          </el-menu-item>
          <el-menu-item index="/hw3">
            <i class="el-icon-menu"></i>
            <span slot="title">题目三</span>
          </el-menu-item>
          <el-menu-item index="/hw4">
            <i class="el-icon-menu"></i>
            <span slot="title">题目四</span>
          </el-menu-item>
          <el-menu-item index="/hw5">
            <i class="el-icon-menu"></i>
            <span slot="title">题目五</span>
          </el-menu-item>
          <el-menu-item index="/hw6">
            <i class="el-icon-menu"></i>
            <span slot="title">题目六</span>
          </el-menu-item>
          <el-menu-item index="/hw7">
            <i class="el-icon-menu"></i>
            <span slot="title">题目七</span>
          </el-menu-item>
          <el-menu-item index="/hw8">
            <i class="el-icon-menu"></i>
            <span slot="title">题目八</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
<!--      <el-main>-->
<!--        <router-view></router-view>-->
<!--      </el-main>-->
    </el-container>
</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  background-color: #B3C0D1;
  height: 645px;
}
.el-menu-vertical-demo {
  background-color: #B3C0D1;
  margin-left: 30px;
}
.pri {
  /*row-gap: 80px;*/
  /*background-color: #B3C0D1;*/

}
.pr {
  margin-left: 30px;
}

/*.el-header, .el-footer {*/
/*  background-color: #B3C0D1;*/
/*  color: #333;*/
/*  text-align: center;*/
/*  line-height: 60px;*/
/*}*/

/*.el-aside {*/
/*  background-color: #D3DCE6;*/
/*  color: #333;*/
/*  text-align: center;*/
/*  line-height: 200px;*/
/*}*/

/*.el-main {*/
/*  background-color: #E9EEF3;*/
/*  color: #333;*/
/*  text-align: center;*/
/*  line-height: 160px;*/
/*}*/

/*body > .el-container {*/
/*  margin-bottom: 40px;*/
/*}*/

/*.el-container:nth-child(5) .el-aside,*/
/*.el-container:nth-child(6) .el-aside {*/
/*  line-height: 260px;*/
/*}*/

/*.el-container:nth-child(7) .el-aside {*/
/*  line-height: 320px;*/
/*}*/
</style>
