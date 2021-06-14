<template>
  <div>
    <el-row>
      <div class="select">
        <el-button type="success">自定数据测试</el-button>
      </div>
    </el-row>
    <el-form :model="Sheet" ref="Sheet" label-width="100px" class="demo-ruleForm">
      <el-form-item
        label="日"
        prop="days"
        :rules="[
      { required: true, message: '日期不能为空'},
      { type: 'number', message: '日期必须为数字值'}
    ]"
      >
        <el-input type="days" v-model.number="Sheet.days" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item
        label="月"
        prop="months"
        :rules="[
      { required: true, message: '日期不能为空'},
      { type: 'number', message: '日期必须为数字值'}
    ]"
      >
        <el-input type="months" v-model.number="Sheet.months" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item
        label="年"
        prop="years"
        :rules="[
      { required: true, message: '日期不能为空'},
      { type: 'number', message: '日期必须为数字值'}
    ]"
      >
        <el-input type="years" v-model.number="Sheet.years" autocomplete="off"></el-input>
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
        @click="show()"
      >
        <p type="result" v-model="Sheet.result" autocomplete="off" style="margin-top: 0px">{{Sheet.result|unit}}</p>
      </el-form-item>
    </el-form>


    <el-row>
      <div style="float: left">
        <el-select v-model="value" placeholder="请选择">
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
          prop="day"
          label="日"
          width="180">
        </el-table-column>
        <el-table-column
          prop="month"
          label="月"
          width="180">
        </el-table-column>
        <el-table-column
          prop="year"
          label="年"
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
  name: "hw8",
  data() {
    return {

      sheet: [{
        day:'',
        month:'',
        year:'',
        expect:'',
        result:'',
      }],
      Sheet:{
        days: '',
        months: '',
        years: '',
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
    show(){

    },
    test2(){
      axios({
        url:'http://localhost:8090/hw8',
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
      const result = await axios.get('http://localhost:8090/returnWeek',
        {
          params:{
            days:this.Sheet.days,
            months:this.Sheet.months,
            years:this.Sheet.years,
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
  },
  filters: {
    unit:function(arg){

        let res=arg
      if(res!=''&&typeof (res)!='string'){
        if(res==1){
          res='一'
        }
        else if(res==2){
          res='二'
        }
        else if(res==3){
          res='三'
        }
        else if(res==4){
          res='四'
        }
        else if(res==5){
          res='五'
        }
        else if(res==6){
          res='六'
        }
        else if(res==7){
          res='天'
        }
        return '结果: '+'星期'+res
      }
      else{
        return '结果: '+res
      }
    }
  }
}
</script>

<style scoped>

</style>
