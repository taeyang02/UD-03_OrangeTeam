<template>
  <div id="app">
    <el-button type="text" @click="dialogKPIVisible = true">open a KPI nested Dialog</el-button>
    <el-button type="text" @click="dialogStaffVisible = true">open a Staff nested Dialog</el-button>
    <el-button type="text" @click="dialogBSCVisible = true">open a BSC nested Dialog</el-button>
    <el-dialog title="Chỉnh sửa quy tắc" :visible.sync="dialogKPIVisible"
               center width="60%" :before-close="handleClose" :show-close="false">
      <h6>1. KPI cá nhân hàng tháng</h6>
      <el-table :data="gridData" border :row-class-name="valiKPI" >
        <el-table-column label="STT" width="50">
          <template v-slot="scope">
            <p>{{scope.$index + 1}}</p>
          </template>
        </el-table-column>
        <el-table-column label="Điểm chặn dưới" width="140">
          <template v-slot="scope">
            <input :id="scope.row.lowerInterceptPoint" type="text" v-model="scope.row.lowerInterceptPoint"
                   style="width: 100%; border: none; text-align: center">
          </template>
        </el-table-column>
        <el-table-column property="condition" label="Điều kiện" width="100"></el-table-column>
        <el-table-column property="upperInterceptPoint" label="Điểm chặn trên" width="140">
          <template v-slot="scope">
            <input :id="scope.row.upperInterceptPoint" type="text" v-model="scope.row.upperInterceptPoint"
                   style="width: 100%; border: none; text-align: center">
          </template>
        </el-table-column>
        <el-table-column property="vPoint" label="Điểm V-point" width="120">
          <template v-slot="scope">
            <input :id="scope.row.vPoint" type="text" v-model="scope.row.vPoint"
                   style="width: 100%; border: none; text-align: center">
          </template>
        </el-table-column>
        <el-table-column property="note" label="Chú thích" ></el-table-column>
      </el-table>
      <div class="mt-4 d-flex justify-content-center">
        <el-button type="primary" round @click="updateKPI">Xác nhận</el-button>
        <el-button style="width: 6.5rem" type="info" round @click="dialogKPIVisible= false">Huỷ</el-button>
      </div>
    </el-dialog>

    <el-dialog title="Chỉnh sửa quy tắc" :visible.sync="dialogBSCVisible"
               center width="60%" :before-close="handleClose" :show-close="false">
      <h6>3. BSC bộ phận</h6>
      <el-table :data="gridData" border :row-class-name="valiKPI" >
        <el-table-column label="STT" width="50">
          <template v-slot="scope">
            <p>{{scope.$index + 1}}</p>
          </template>
        </el-table-column>
        <el-table-column label="Điểm chặn dưới" width="140">
          <template v-slot="scope">
            <input :id="scope.row.lowerInterceptPoint" type="text" v-model="scope.row.lowerInterceptPoint"
                   style="width: 100%; border: none; text-align: center">
          </template>
        </el-table-column>
        <el-table-column property="condition" label="Điều kiện" width="100"></el-table-column>
        <el-table-column property="upperInterceptPoint" label="Điểm chặn trên" width="140">
          <template v-slot="scope">
            <input :id="scope.row.upperInterceptPoint" type="text" v-model="scope.row.upperInterceptPoint"
                   style="width: 100%; border: none; text-align: center">
          </template>
        </el-table-column>
        <el-table-column property="vPoint" label="Điểm V-point" width="120">
          <template v-slot="scope">
            <input :id="scope.row.vPoint" type="text" v-model="scope.row.vPoint"
                   style="width: 100%; border: none; text-align: center">
          </template>
        </el-table-column>
        <el-table-column property="note" label="Chú thích" ></el-table-column>
      </el-table>
      <div class="mt-4 d-flex justify-content-center">
        <el-button type="primary" round @click="updateKPI">Xác nhận</el-button>
        <el-button style="width: 6.5rem" type="info" round @click="dialogBSCVisible= false">Huỷ</el-button>
      </div>
    </el-dialog>

    <el-dialog title="Chỉnh sửa quy tắc" :visible.sync="dialogStaffVisible"
               center width="60%" :before-close="handleClose" :show-close="false">
      <h6>2. Nhân viên xuất sắc, bộ phận xuất sắc</h6>
      <el-table :data="staffData" border :row-class-name="valiStaff">
        <el-table-column label="STT" width="50">
          <template v-slot="scope">
            <p>{{scope.$index + 1}}</p>
          </template>
        </el-table-column>
        <el-table-column property="detail" label="Chi tiết"></el-table-column>
        <el-table-column property="vPoint" label="Điểm V-point" width="120">
          <template v-slot="scope">
            <input :id="scope.row.vPoint" type="text" v-model="scope.row.vPoint"
                   style="width: 100%; border: none; text-align: center">
          </template>
        </el-table-column>
      </el-table>
      <div class="mt-4 d-flex justify-content-center">
        <el-button type="primary" round @click="updateKPI">Xác nhận</el-button>
        <el-button style="width: 6.5rem" type="info" round @click="dialogStaffVisible= false">Huỷ</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

export default {
  name: 'App',
  data() {
    return {
      gridData: [{
        lowerInterceptPoint: 130,
        upperInterceptPoint: 1300,
        vPoint: 35,
        condition: '<= X <',
        backgroundClass: "success-row",
        get note() {
          return 'Số điểm đạt được.'
        }
      }, {
        lowerInterceptPoint: 95,
        upperInterceptPoint: 130,
        vPoint: 1,
        condition: '< X <',
        backgroundClass: "success-row",
        get note() {
          return `${this.vPoint} điểm/1%.`
        }
      }, {
        lowerInterceptPoint: 95,
        upperInterceptPoint: 95,
        vPoint: 0,
        condition: '= X =',
        backgroundClass: "success-row",
        get note() {
          return `Số điểm đạt được.`
        }
      }, {
        lowerInterceptPoint: 70,
        upperInterceptPoint: 95,
        vPoint: -1,
        condition: '<= X <',
        get note(){
          return  `${this.vPoint} điểm/1%.`
        }
      },
        {
          lowerInterceptPoint: 0,
          upperInterceptPoint: 70,
          vPoint: -25,
          condition: '<= X <',
          backgroundClass: "success-row",
          get note(){
            return `Số điểm đạt được.`
          }
        }],
      staffData: [
        {
          detail: 'Nhân viên xuất sắc tháng',
          vPoint: 10
        },
        {
          detail: 'Nhân viên được đề cử giải NVXS quý',
          vPoint: 10
        },
        {
          detail: 'Nhân viên xuất sắc quý các hạng mục',
          vPoint: 10
        },
        {
          detail: 'Nhân viên xuất sắc quý',
          vPoint: 10
        },
        {
          detail: 'Nhân viên được đề cử giải Ngôi sao năm',
          vPoint: 10
        },
        {
          detail: 'Ngôi sao năm của các hạng mục',
          vPoint: 10
        },
        {
          detail: 'Ngôi sao năm của công ty',
          vPoint: 10
        },
        {
          detail: 'Bộ phận xuất sắc tháng',
          vPoint: 10
        },
        {
          detail: 'Bộ phận xuất sắc năm',
          vPoint: 10
        }
      ],
      dialogKPIVisible: false,
      dialogStaffVisible: false,
      dialogBSCVisible: false,
    };
  },
  methods: {
    updateKPI() {
      console.log(this.gridData)
    },
    valiKPI({row}) {
      const numberRegex = /^\s*[+-]?(\d+|\d*\.\d+|\d+\.\d*)([Ee][+-]?\d+)?\s*$/
      if(!numberRegex.test(row.lowerInterceptPoint)) {
        return 'warning-row'
      }else if (!numberRegex.test(row.vPoint)) {
        return 'warning-row'
      }else if (!numberRegex.test(row.upperInterceptPoint)) {
        return 'warning-row'
      }else {
        return ''
      }
    },
    valiStaff({row}) {
      const numberRegex = /^\s*[+-]?(\d+|\d*\.\d+|\d+\.\d*)([Ee][+-]?\d+)?\s*$/
      if (!numberRegex.test(row.vPoint)) {
        return 'warning-row'
      }else {
        return ''
      }
    },
    handleClose() {

    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;

  color: #2c3e50;
  margin-top: 60px;
}
.el-table .cell {
  text-align: center;
}

.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>
