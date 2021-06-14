<template>
  <el-container style="height: 100%;">
    <el-header style="padding-left: 0px; padding-right: 0px;">
      <!-- 导航栏 -->
      <Header></Header>
    </el-header>
    <el-container>
      <!--      边栏-->
      <el-aside style="line-height: 200px;" >
        <Aside></Aside>
      </el-aside>
      <el-main>
        <!-- 路由跳转 -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
import Header from "../components/Header.vue";
import Aside from "../components/Aside.vue";
export default {
  name: "Main",
  components: {
    Header,
    Aside,
  }
};
</script>

<style scoped>

</style>
