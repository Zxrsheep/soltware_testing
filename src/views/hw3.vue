<template>
  <div>
    <el-row>
      <div class="select">
        <el-button type="success">自定数据测试</el-button>
      </div>
    </el-row>
    <el-form :model="Sheet" ref="Sheet" label-width="100px" class="demo-ruleForm">
      <el-form-item
        label="显示屏"
        prop="displays"
        :rules="[
      { required: true, message: '数量不能为空'},
      { type: 'number', message: '数量必须为数字值'}
    ]"
      >
        <el-input type="displays" v-model.number="Sheet.displays" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item
        label="主机"
        prop="hosts"
        :rules="[
      { required: true, message: '数量不能为空'},
      { type: 'number', message: '数量必须为数字值'}
    ]"
      >
        <el-input type="hosts" v-model.number="Sheet.hosts" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item
        label="外设"
        prop="peripherals"
        :rules="[
      { required: true, message: '数量不能为空'},
      { type: 'number', message: '数量必须为数字值'}
    ]"
      >
        <el-input type="peripherals" v-model.number="Sheet.peripherals" autocomplete="off"></el-input>
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
          prop="displays"
          label="显示屏"
          width="180">
        </el-table-column>
        <el-table-column
          prop="hosts"
          label="主机"
          width="180">
        </el-table-column>
        <el-table-column
          prop="peripherals"
          label="外设"
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
  name: "hw3",
  data() {
    return {
      sheet: [{
        displays:'',
        hosts:'',
        peripherals:'',
        expect:'',
        result:'',
      }],
      Sheet:{
        displays: '',
        hosts: '',
        peripherals: '',
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
        url:'http://localhost:8090/hw3',
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
      const result = await axios.get('http://localhost:8090/returnCommission',
        {
          params:{
            displays:this.Sheet.displays,
            hosts:this.Sheet.hosts,
            peripherals:this.Sheet.peripherals,
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
    unit:function (arg) {
      const res=arg
      if(typeof (res) != 'string'){
        if(res!=''){
          return '结果: '+res+'元'
        }
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
