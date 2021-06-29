<template>
  <div>
    <el-row>
      <div class="select">
        <el-button type="success">自定数据测试</el-button>
      </div>
    </el-row>
    <el-form :model="Sheet" ref="Sheet" label-width="100px" class="demo-ruleForm">
      <el-form-item
        label="本月分钟数"
        prop="minutes"
        :rules="[
      { required: true, message: '分钟数不能为空'},
      { type: 'number', message: '分钟数必须为数字值'}
    ]"
      >
        <el-input type="minutes" v-model.number="Sheet.minutes" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item
        label="未缴费次数"
        prop="times"
        :rules="[
      { required: true, message: '次数不能为空'},
      { type: 'number', message: '次数必须为数字值'}
    ]"
      >
        <el-input type="times" v-model.number="Sheet.times" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <div style="float: left">
          <el-button type="primary" @click="test1('Sheet')">提交</el-button>
<!--          <router-view v-if="isRouterAlive"></router-view>-->
          <el-button @click="resetForm('Sheet')">重置</el-button>
        </div>

<!--        <el-card shadow="never" style="width: 210px;height: 40px;">-->
<!--          <p style="margin-top: -20px" v-model="Sheet.result">-->
<!--            结果：{{Sheet.result}}-->
<!--          </p>-->
<!--        </el-card>-->
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
        prop="minutes"
        label="分钟"
        width="180">
      </el-table-column>
      <el-table-column
        prop="times"
        label="次数"
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
  name: "hw6",
  data() {
    return {
      // sheet:{},
      sheet: [{
        minutes:'',
        times:'',
        expect:'',
        result:'',
      }],
      Sheet:{
        minutes: '',
        times: '',
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
        },
        {
          value:'3',
          label:'决策表法'
        },
  ],
      value: ''
    }
  },
  methods:{
    // test3(){
    //   axios({
    //     url:'http://localhost:8090/hw6?num=1',
    //     method:'post',
    //   }).then(res => {
    //     // console.log(res.data)
    //     // this.options.value
    //     this.sheet=res.data
    //     // console.log(this.sheet)
    //   })
    // },
    test2(){
        axios({
          url:'http://localhost:8090/hw6',
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
    // async test2(){
    //
    //   const result = await axios.post('http://localhost:8090/hw6',
    //     {
    //         num: '1'
    //     },
    //     { withCredentials: true }
    //   );
    //
    //   if(result.status == 200) {
    //     console.log(result.data[0])
    //     this.sheet = result.data
    //   }
    // },
    async test1(){
      const result = await axios.get('http://localhost:8090/telecomCharge',
        {
          params:{
            minutes:this.Sheet.minutes,
            times:this.Sheet.times,
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
      const res=arg
      if(typeof (res)!='string'){
        if(res!=''){
          return '结果: '+res+'元'
        }
      }
      else {
        return '结果: '+res
      }
    }
  }
}
</script>

<style scoped>

</style>
