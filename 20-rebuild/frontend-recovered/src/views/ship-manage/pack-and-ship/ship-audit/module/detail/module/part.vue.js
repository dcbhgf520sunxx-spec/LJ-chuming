import { resolveComponent as c } from "vue";
import { openBlock as f } from "vue";
import { createBlock as h } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as r } from "vue";
import { createTextVNode as n } from "vue";
import { unref as a } from "vue";
import { ElTableColumn as b } from "element-plus";
import { t as g, bs as i, D as m } from "../../../../../../../shared/runtime.js";
const P = { __name: "part", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 } }, setup(s) {
  const { decimalPrecision: _ } = g();
  return (x, p) => {
    const t = b, d = c("table-cell-tag"), w = c("common-table");
    return f(), h(w, { data: s.list, "max-height": s.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: l(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "serialNumber", label: "编号" }, { default: l(({ row: o }) => [e(d, { show: o.boolAllPartSendDirectly, name: "檩条直发", color: "#f56c6c" }, null, 8, ["show"]), u("span", null, r(o.serialNumber), 1)]), _: 1 }), e(t, { "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "120" }), e(t, { prop: "showQuantity", label: "数量", align: "center" }), e(t, { "show-overflow-tooltip": true, label: "计量单位", align: "center" }, { default: l(() => p[0] || (p[0] = [u("span", null, "件", -1)])), _: 1, __: [0] }), e(t, { "show-overflow-tooltip": true, prop: "unit", label: "核算单位", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "totalLength", label: `总长
(m)`, align: "center" }, { default: l((o) => [n(r(a(i)(o.row.totalLength, a(m).MES_ARTIFACT_L__M)), 1)]), _: 1 }), e(t, { "show-overflow-tooltip": true, prop: "totalMete", label: `总重
（t）`, align: "center" }, { default: l((o) => [n(r(a(i)(o.row.totalMete, a(m).COM_WT__T)), 1)]), _: 1 }), e(t, { "show-overflow-tooltip": true, prop: "unitPrice", label: `单价
（元）`, align: "center" }, { default: l((o) => [n(r(a(i)(o.row.unitPrice, a(_).shipment)), 1)]), _: 1 }), e(t, { "show-overflow-tooltip": true, prop: "totalPrice", label: `总价
（元）`, align: "center" }, { default: l((o) => [n(r(a(i)(o.row.totalPrice, 3)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  P as default
};
