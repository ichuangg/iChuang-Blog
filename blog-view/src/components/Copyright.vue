<template>
  <!--版权信息-->
    <div style="text-align: center">
      <el-divider></el-divider>
      <strong>发表时间：{{ blog.createTime }}</strong>
      <el-divider direction="vertical"></el-divider>
      <strong>最后修改：{{ blog.updateTime }}</strong>
      <el-divider direction="vertical"></el-divider>
      <span><router-link style="text-decoration-line: none;" to="/about">联系作者</router-link></span>
      <br>
      <span style="color: lightcoral"
      >本站内容可自由转载、引用，并且允许商业性使用。但需署名作者且注明文章出处。</span>
      <el-divider></el-divider>
    </div>
</template>

<script>
export default {
  name: "Copyright"
}
</script>

<style scoped>

</style>