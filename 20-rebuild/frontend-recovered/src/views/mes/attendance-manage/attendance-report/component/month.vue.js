import { openBlock as r } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as o } from "vue";
import { Fragment as t } from "vue";
import { ElTableColumn as a } from "element-plus";
import { _ as n } from "../../../../../shared/runtime.js";
const p = {};
function c(s, i) {
  const e = a;
  return r(), l(t, null, [o(e, { prop: "userName", "show-overflow-tooltip": true, label: "姓名", align: "center" }), o(e, { prop: "idCard", "show-overflow-tooltip": true, label: "身份证号", align: "center" }), o(e, { prop: "supplierName", "show-overflow-tooltip": true, label: "单位", align: "center" }), o(e, { prop: "clockNumber", "show-overflow-tooltip": true, label: "打卡天数", align: "center" }), o(e, { prop: "workHours", "show-overflow-tooltip": true, label: "标准工作时长", align: "center" }), o(e, { prop: "absenceNumber", "show-overflow-tooltip": true, label: "缺勤天数", align: "center" }), o(e, { prop: "absenceHours", "show-overflow-tooltip": true, label: "缺勤时长", align: "center" })], 64);
}
const w = n(p, [["render", c]]);
export {
  w as default
};
