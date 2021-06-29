<template>
  <div>
    <el-row>
      <div class="select">
        <el-button type="success">自定数据测试</el-button>
      </div>
    </el-row>
    <el-form :model="Sheet" ref="Sheet" label-width="100px" class="demo-ruleForm">
      <el-form-item
        label="第一条边"
        prop="a"
        :rules="[
      { required: true, message: '长度不能为空'},
      { type: 'number', message: '长度必须为数字值'}
    ]"
      >
        <el-input type="a" v-model.number="Sheet.a" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item
        label="第二条边"
        prop="b"
        :rules="[
      { required: true, message: '长度不能为空'},
      { type: 'number', message: '长度必须为数字值'}
    ]"
      >
        <el-input type="b" v-model.number="Sheet.b" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item
        label="第三条边"
        prop="c"
        :rules="[
      { required: true, message: '长度不能为空'},
      { type: 'number', message: '长度必须为数字值'}
    ]"
      >
        <el-input type="c" v-model.number="Sheet.c" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <div style="float: left">
          <el-button type="primary" @click="test1('Sheet')">提交</el-button>
          <!--          <router-view v-if="isRouterAlive"></router-view>-->
          <el-button @click="resetForm('Sheet')">重置</el-button>
        </div>
      </el-form-item>
      <el-form-item

        prop="result"
      >
        <p type="result" v-model="Sheet.result" autocomplete="off" style="margin-top: 0px">{{Sheet.result|unit}}</p>
      </el-form-item>
    </el-form>


    <el-row>
      <div style="float: left">
        <el-select v-model="value" placeholder="请选择" @change="selectChanged()">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </div>
      <div class="select">
        <el-button type="success" v-model="value" @click="test2()">测试</el-button>
      </div>
      <el-table
        :data="sheet"
        style="width: 100%">
        <el-table-column
          prop="a"
          label="第一条边"
          width="180">
        </el-table-column>
        <el-table-column
          prop="b"
          label="第二条边"
          width="180">
        </el-table-column>
        <el-table-column
          prop="c"
          label="第三条边"
          width="180">
        </el-table-column>
        <el-table-column
          prop="expect"
          label="预期值">
        </el-table-column>
        <el-table-column
          prop="result"
          label="实际值">
        </el-table-column>
      </el-table>

    </el-row>

  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "hw1",
  data() {
    return {
      sheet: [{
        a:'',
        b:'',
        c:'',
        expect:'',
        result:'',
      }],
      Sheet:{
        a: '',
        b: '',
        c: '',
        result: '',
      },
      isRouterAlive: true,
      options:[{
        value:'1',
        label:'一般边界值法'
      },
        {
          value:'2',
          label:'弱一般等价类法'
        }
      ],
      value: ''
    }
  },
  methods:{

    test2(){
      axios({
        url:'http://localhost:8090/hw1',
        method:'post',
        params:{
          num: this.value
        }
      }).then(res => {
        console.log(res.data)
        // this.options.value
        this.sheet=res.data
      })
    },
    async test1(){
      const result = await axios.get('http://localhost:8090/returnType',
        {
          params:{
            a:this.Sheet.a,
            b:this.Sheet.b,
            c:this.Sheet.c,
          }
        }
      );

      if(result.status == 200){
        console.log(result)
        // this.sheet=result.data
        this.Sheet.result=result.data
      }
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    selectChanged(){
      console.log(this.value)
    },
  },
  filters: {
    unit:function (arg) {
      return '结果: '+arg
    }
  }
}
</script>

<style scoped>

</style>
