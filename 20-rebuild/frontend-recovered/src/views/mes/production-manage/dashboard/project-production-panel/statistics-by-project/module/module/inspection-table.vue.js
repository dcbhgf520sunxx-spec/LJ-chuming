import { openBlock as l } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as o } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as i } from "vue";
import { Fragment as c } from "vue";
import { ElTableColumn as p } from "element-plus";
import { _ as s } from "../../../../../../../../shared/runtime.js";
const m = {};
function d(u, w) {
  const e = p;
  return l(), a(c, null, [o(e, { key: "productionLineName", prop: "productionLineName", "show-overflow-tooltip": true, label: "生产线名称", align: "center", "min-width": "140" }), o(e, { key: "createUserName", prop: "createUserName", "show-overflow-tooltip": true, label: "质检人", align: "center", "min-width": "140" }), o(e, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "质检时间", align: "center", "min-width": "140" }), o(e, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", "min-width": "140" }), o(e, { key: "boolCompleted", prop: "boolCompleted", "show-overflow-tooltip": true, label: "状态", align: "center", "min-width": "140" }, { default: r(({ row: t }) => [n("span", null, i(t.boolCompleted ? "已质检" : "未质检"), 1)]), _: 1 })], 64);
}
const b = s(m, [["render", d]]);
export {
  b as default
};
