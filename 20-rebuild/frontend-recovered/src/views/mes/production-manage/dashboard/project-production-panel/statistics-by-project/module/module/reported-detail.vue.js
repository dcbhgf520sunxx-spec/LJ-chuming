import { openBlock as l } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as o } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as i } from "vue";
import { Fragment as p } from "vue";
import { ElTableColumn as c } from "element-plus";
import { _ as m } from "../../../../../../../../shared/runtime.js";
const s = {};
function d(w, u) {
  const e = c;
  return l(), r(p, null, [o(e, { key: "productionLineName", prop: "productionLineName", "show-overflow-tooltip": true, label: "生产线名称", align: "center", "min-width": "140" }), o(e, { key: "teamUserName", prop: "teamUserName", "show-overflow-tooltip": true, label: "班组长名称", align: "center", "min-width": "140" }), o(e, { key: "createUserName", prop: "createUserName", "show-overflow-tooltip": true, label: "上报人", align: "center", "min-width": "140" }), o(e, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "上报时间", align: "center", "min-width": "140" }), o(e, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", "min-width": "140" }), o(e, { key: "boolCompleted", prop: "boolCompleted", "show-overflow-tooltip": true, label: "状态", align: "center", "min-width": "140" }, { default: a(({ row: t }) => [n("span", null, i(t.boolCompleted ? "已上报" : "未上报"), 1)]), _: 1 })], 64);
}
const _ = m(s, [["render", d]]);
export {
  _ as default
};
