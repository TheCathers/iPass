<template>
  <div class="table-classic-wrapper">

    <!-- 查询栏 -->
    <el-form
      ref="searchForm"
      :inline="true"
      :model="listQuery"
      class="search-form"
    >
      <el-form-item label="卡号">
        <el-input v-model="searchObj.cardNumber" placeholder="卡号"/>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="searchObj.state" placeholder="状态">
          <el-option :value="0" label="未使用"/>
          <el-option :value="1" label="使用中"/>
          <el-option :value="2" label="已注销"/>
        </el-select>
      </el-form-item>
      <el-form-item label="领用人">
        <el-input v-model="searchObj.userId" placeholder="领用人"/>
      </el-form-item>
      <el-form-item label="持卡人">
        <el-input v-model="searchObj.receiveId" placeholder="持卡人"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="fetchData()">查询</el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作栏 -->
    <div class="control-btns">
      <el-button type="primary" @click="dialogShow()">卡片入库</el-button>
      <el-button type="primary">导入数据</el-button>
      <el-button type="primary">导出数据</el-button>
    </div>
    <el-table
      :data="listQuery"
      style="width: 100%;margin-top: 20px;"
      element-loading-text="数据加载中"
      border
      fit
      highlight-current-row>
      <el-table-column
        label="序号"
        align="center"
        width="120">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column
        prop="cardNumber"
        label="卡号">
      </el-table-column>
      <el-table-column label="状态">
        <template slot-scope="scope">
          {{ scope.row.state===0?'未使用':'使用中' }}
        </template>
      </el-table-column>
      <el-table-column
        prop="userId"
        label="持卡人">
      </el-table-column>
      <el-table-column
        prop="receiveId"
        label="领用人">
      </el-table-column>
      <el-table-column
        label="操作"
        align="center">
        <template slot-scope="scope">

          <el-button
            type="danger"
            size="mini"
            icon="el-icon-delete"
            @click="removeDataById(scope.row.cardId)">注销</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog
      title="卡片批量入库"
      :visible.sync="formVisible"
      width="30%"
      class="dialog-form"
      :before-close="handleClose"
    >
      <el-form
        ref="dialogForm"
        :model="newCardInfo"
      >
        <el-form-item label="前缀：" prop="perfix">
          <el-input v-model="newCardInfo.perfix" />
        </el-form-item>
        <el-form-item label="开始卡号：" prop="from" >
          <el-input v-model="newCardInfo.from" type="number" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')"/>
        </el-form-item>
        <el-form-item label="截止卡号：" prop="to" >
          <el-input v-model="newCardInfo.to" type="number" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')"/>
        </el-form-item>

        <div class="footer-item">
          <el-button @click="cancelForm">取 消</el-button>
          <el-button type="primary" :disabled="isSubmit" @click="addNewCard()">确 定</el-button>
        </div>
      </el-form>
    </el-dialog>

    <!--分页组件-->
    <el-pagination
      :current-page="page"
      :page-size="limit"
      :total="total"
      style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper"
      @current-change="fetchData"
    />
  </div>
</template>
<script>
  import cardInfo from '@/api/cardInfo'
  import {Message} from "element-ui";
  export default {
    data() {
      // 定义数据
      return {
        listLoading: true, // 是否显示loading信息
        listQuery: null, // 数据列表
        total: 0, // 总记录数
        page: 1, // 页码
        limit: 10, // 每页记录数
        searchObj: {}, // 查询条件

        newCardInfo: {
        },
        formVisible: false // 弹窗可见性
      }
    },
    created() {
      // 当页面加载时获取数据
      this.fetchData()
    },
    methods: {
      fetchData(page = 1) {
        // 调用api层获取数据库中的数据
        this.page = page
        this.listLoading = true
        cardInfo.getPageList(this.page, this.limit, this.searchObj)
          .then((response) => {
            // debugger 设置断点调试
            if (response.success === true) {
              this.listQuery = response.data.rows
              this.total = response.data.total
            }
            this.listLoading = false
          })
      },
      resetData() {
        this.searchObj = {}
        this.fetchData()
      },
      dialogShow() {
        this.formVisible = true
      },
      addNewCard() {
        // console.log(this.newCardInfo.from)
        cardInfo.addNewCard(this.newCardInfo.perfix,this.newCardInfo.from,this.newCardInfo.to)
          .then((response)=>{
            if (response.success===true){
              Message({
                type: 'success',
                message: response.message
              })
              this.formVisible = false
            }
          })
      },
      removeDataById (id){
        cardInfo.removeDataById(id)
          .then((response)=>{
            Message({
              type: 'success',
              message: response.message
            })
            this.fetchData()
          })
      },
      handleClose() {
        this.formVisible = false
      },
      cancelForm() {
        this.formVisible = false
        this.newCardInfo = {}
      }
    }
  }
</script>
