<!--<template>-->
<!--  <div class="table-classic-wrapper">-->
<!--    <el-card shadow="always">-->
<!--      &lt;!&ndash; 操作栏 &ndash;&gt;-->
<!--      <div class="control-btns">-->
<!--        <el-button type="primary" @click="handleImport">导入数据</el-button>-->
<!--        <el-button type="primary" @click="exportVisible = true">-->
<!--          导出数据-->
<!--        </el-button>-->
<!--        <el-button type="danger" @click="batchDelete">批量删除</el-button>-->
<!--      </div>-->
<!--      &lt;!&ndash; 查询栏 &ndash;&gt;-->
<!--      <el-form-->
<!--        ref="searchForm"-->
<!--        :inline="true"-->
<!--        :model="listQuery"-->
<!--        label-width="90px"-->
<!--        class="search-form"-->
<!--      >-->
<!--        <el-form-item label="卡号">-->
<!--          <el-input v-model="listQuery.id" placeholder="卡号"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="状态">-->
<!--          <el-select v-model="listQuery.married" placeholder="状态">-->
<!--            <el-option :value="0" label="未使用"/>-->
<!--            <el-option :value="1" label="使用中"/>-->
<!--            <el-option :value="2" label="已注销"/>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="领用人">-->
<!--          <el-input v-model="listQuery.phone" placeholder="领用人"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="持卡人">-->
<!--          <el-input v-model="listQuery.phone" placeholder="持卡人"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-button type="primary" @click="onSubmit">查询</el-button>-->
<!--        </el-form-item>-->
<!--      </el-form>-->
<!--      &lt;!&ndash; 表格栏 &ndash;&gt;-->
<!--      <el-table-->
<!--        ref="multipleTable"-->
<!--        v-loading="listLoading"-->
<!--        :data="tableData"-->
<!--        tooltip-effect="dark"-->
<!--        style="width: 100%"-->
<!--        size="medium"-->
<!--        @selection-change="handleSelectionChange"-->
<!--      >-->
<!--        <el-table-column type="selection" width="60"/>-->
<!--        <el-table-column-->
<!--          prop="id"-->
<!--          label="序号"-->
<!--          align="center"-->
<!--          width="120"-->
<!--          sortable-->
<!--        />-->
<!--        <el-table-column prop="cardNumber" label="卡号" align="center">-->
<!--        </el-table-column>-->
<!--        <el-table-column prop="state" label="状态" align="center">-->
<!--        </el-table-column>-->
<!--        <el-table-column prop="receiveId" label="领用人" align="center"/>-->
<!--        <el-table-column prop="userId" label="持卡人" align="center"/>-->

<!--        <el-table-column label="操作" align="center" width="200">-->
<!--          <template slot-scope="scope">-->
<!--            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"-->
<!--            >编辑-->
<!--            </el-button-->
<!--            >-->
<!--            <el-button-->
<!--              size="mini"-->
<!--              type="danger"-->
<!--              @click="handleDelete(scope.$index, scope.row)"-->
<!--            >删除-->
<!--            </el-button-->
<!--            >-->
<!--          </template>-->
<!--        </el-table-column>-->
<!--      </el-table>-->
<!--      &lt;!&ndash; 分页栏 &ndash;&gt;-->
<!--      <Pagination-->
<!--        :total="total"-->
<!--        :page.sync="listQuery.currentPage"-->
<!--        :limit.sync="listQuery.pageSize"-->
<!--        @pagination="fetchData"-->
<!--      />-->
<!--      &lt;!&ndash; 新增/编辑 弹出栏-->
<!--      <el-dialog-->
<!--        title="编辑"-->
<!--        :visible.sync="formVisible"-->
<!--        width="40%"-->
<!--        class="dialog-form"-->
<!--        :before-close="handleClose"-->
<!--      >-->
<!--        <el-form-->
<!--          ref="dialogForm"-->
<!--          :model="dialogForm"-->
<!--          :rules="formRules"-->
<!--          label-width="100px"-->
<!--        >-->
<!--          <el-form-item label="姓名：" prop="name">-->
<!--            <el-input v-model="dialogForm.name" />-->
<!--          </el-form-item>-->
<!--          <el-form-item label="手机：" prop="phone">-->
<!--            <el-input v-model="dialogForm.phone" />-->
<!--          </el-form-item>-->
<!--          <el-form-item label="婚姻状况：" prop="married">-->
<!--            <el-select v-model="dialogForm.married">-->
<!--              <el-option :value="0" label="单身" />-->
<!--              <el-option :value="1" label="未婚" />-->
<!--              <el-option :value="2" label="已婚" />-->
<!--              <el-option :value="3" label="离异" />-->
<!--            </el-select>-->
<!--          </el-form-item>-->
<!--          <el-form-item label="爱好：" prop="hobby">-->
<!--            <el-checkbox-group v-model="dialogForm.hobby">-->
<!--              <el-checkbox label="羽毛球" name="hobby" />-->
<!--              <el-checkbox label="乒乓球" name="hobby" />-->
<!--              <el-checkbox label="篮球" name="hobby" />-->
<!--              <el-checkbox label="排球" name="hobby" />-->
<!--              <el-checkbox label="网球" name="hobby" />-->
<!--              <el-checkbox label="旱冰" name="hobby" />-->
<!--              <el-checkbox label="滑雪" name="hobby" />-->
<!--              <el-checkbox label="跳高" name="hobby" />-->
<!--              <el-checkbox label="冲浪" name="hobby" />-->
<!--            </el-checkbox-group>-->
<!--          </el-form-item>-->
<!--          <div class="footer-item">-->
<!--            <el-button @click="cancleForm">取 消</el-button>-->
<!--            <el-button-->
<!--              type="primary"-->
<!--              :disabled="isSubmit"-->
<!--              @click="submitForm('dialogForm')"-->
<!--              >确 定</el-button-->
<!--            >-->
<!--          </div>-->
<!--        </el-form>-->
<!--      </el-dialog> &ndash;&gt;-->
<!--    </el-card>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--  import cardInfo from "@/api/cardInfo";-->

<!--  export default {-->
<!--    data() {-->
<!--      // 定义数据-->
<!--      return {-->
<!--        listLoading: true, // 是否显示loading信息-->
<!--        listQuery: null, // 数据列表-->
<!--        total: 0, // 总记录数-->
<!--        page: 1, // 页码-->
<!--        limit: 10, // 每页记录数-->
<!--        searchObj: {}, // 查询条件-->
<!--      };-->
<!--    },-->
<!--    created() {-->
<!--      // 当页面加载时获取数据-->
<!--      this.fetchData();-->
<!--    },-->
<!--    methods: {-->
<!--      fetchData(page = 1) { // 调用api层获取数据库中的数据-->
<!--        console.log('加载列表')-->
<!--        this.page = page-->
<!--        this.listLoading = true-->
<!--        cardInfo.getPageList(this.page, this.limit, this.searchObj).then(response-->
<!--          => {-->
<!--          // debugger 设置断点调试-->
<!--          if (response.success === true) {-->
<!--            this.listQuery = response.data.rows-->
<!--            this.total = response.data.total-->
<!--          }-->
<!--          this.listLoading = false-->
<!--        })-->
<!--      }-->
<!--    }-->
<!--  };-->
<!--</script>-->

<!--<style lang="less">-->
<!--  .table-classic-wrapper {-->
<!--    .el-card {-->
<!--      min-height: 656px;-->
<!--    }-->

<!--    .control-btns {-->
<!--      margin-bottom: 20px;-->
<!--    }-->

<!--    .search-form {-->
<!--      padding-top: 18px;-->
<!--      margin-bottom: 15px;-->
<!--      background-color: #f7f8fb;-->
<!--    }-->

<!--    .el-table thead {-->
<!--      font-weight: 600;-->

<!--      th {-->
<!--        background-color: #f2f3f7;-->
<!--      }-->
<!--    }-->

<!--    .dialog-form {-->
<!--      .el-input {-->
<!--        width: 380px;-->
<!--      }-->

<!--      .footer-item {-->
<!--        margin-top: 50px;-->
<!--        text-align: right;-->
<!--      }-->
<!--    }-->

<!--    .upload-box,-->
<!--    .export-data {-->
<!--      width: 300px;-->
<!--      margin: 0 auto 30px;-->
<!--    }-->

<!--    .upload-box {-->
<!--      width: 156px;-->

<!--      .files-upload {-->
<!--        color: #20a0ff;-->
<!--      }-->
<!--    }-->

<!--    .hints {-->
<!--      font-size: 12px;-->
<!--      color: #aaa;-->
<!--      text-align: center;-->
<!--    }-->
<!--  }-->
<!--</style>-->
