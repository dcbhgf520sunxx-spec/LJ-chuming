import { openBlock as t } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as e } from "vue";
import { withCtx as l } from "vue";
import { Fragment as n } from "vue";
import { ElTableColumn as a } from "element-plus";
import { _ as i } from "../../../../../shared/runtime.js";
const p = {};
function s(c, w) {
  const o = a;
  return t(), r(n, null, [e(o, { prop: "attendanceDate", "show-overflow-tooltip": true, label: "时间", align: "center", width: "110" }), e(o, { prop: "userName", "show-overflow-tooltip": true, label: "姓名", align: "center" }), e(o, { prop: "supplierName", "show-overflow-tooltip": true, label: "单位", align: "center" }), e(o, { "show-overflow-tooltip": true, label: "上午", align: "center" }, { default: l(() => [e(o, { prop: "morningWorkingTime", "show-overflow-tooltip": true, label: "上班卡", align: "center" }), e(o, { prop: "morningClosingTime", "show-overflow-tooltip": true, label: "下班卡", align: "center" })]), _: 1 }), e(o, { "show-overflow-tooltip": true, label: "下午", align: "center" }, { default: l(() => [e(o, { prop: "afternoonWorkingTime", "show-overflow-tooltip": true, label: "上班卡", align: "center" }), e(o, { prop: "afternoonClosingTime", "show-overflow-tooltip": true, label: "下班卡", align: "center" })]), _: 1 }), e(o, { "show-overflow-tooltip": true, label: "加班", align: "center" }, { default: l(() => [e(o, { prop: "overtimeWorkingTime", "show-overflow-tooltip": true, label: "上班卡", align: "center" }), e(o, { prop: "overtimeClosingTime", "show-overflow-tooltip": true, label: "下班卡", align: "center" })]), _: 1 }), e(o, { prop: "workHours", "show-overflow-tooltip": true, label: "标准工作时长", align: "center" }), e(o, { prop: "actualHours", "show-overflow-tooltip": true, label: "实际时长", align: "center" }), e(o, { prop: "totalHours", "show-overflow-tooltip": true, label: "合计", align: "center" })], 64);
}
const g = i(p, [["render", s]]);
export {
  g as default
};
