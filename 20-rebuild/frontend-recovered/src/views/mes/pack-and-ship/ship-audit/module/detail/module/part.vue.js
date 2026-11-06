import { resolveComponent as u } from "vue";
import { openBlock as m } from "vue";
import { createBlock as w } from "vue";
import { withCtx as a } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as n } from "vue";
import { unref as e } from "vue";
import { ElTableColumn as h } from "element-plus";
import { t as d, bs as i, D as p } from "../../../../../../../shared/runtime.js";
const v = { __name: "part", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 } }, setup(s) {
  const { decimalPrecision: c } = d();
  return (f, g) => {
    const o = h, _ = u("common-table");
    return m(), w(_, { data: s.list, "max-height": s.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: a(() => [l(o, { label: "序号", type: "index", align: "center", width: "60" }), l(o, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), l(o, { "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "120" }), l(o, { "show-overflow-tooltip": true, prop: "length", label: `长度
(mm)`, align: "center" }, { default: a((t) => [r(n(e(i)(t.row.length, e(p).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), l(o, { "show-overflow-tooltip": true, prop: "weight", label: `单重
（kg）`, align: "center" }, { default: a((t) => [r(n(e(i)(t.row.weight, e(p).COM_WT__KG)), 1)]), _: 1 }), l(o, { prop: "showQuantity", label: "数量", align: "center" }), l(o, { "show-overflow-tooltip": true, prop: "totalLength", label: `总长
(m)`, align: "center" }, { default: a((t) => [r(n(e(i)(t.row.totalLength, e(p).MES_ARTIFACT_L__M)), 1)]), _: 1 }), l(o, { "show-overflow-tooltip": true, prop: "totalMete", label: `总重
（t）`, align: "center" }, { default: a((t) => [r(n(e(i)(t.row.totalMete, e(p).COM_WT__T)), 1)]), _: 1 }), l(o, { "show-overflow-tooltip": true, prop: "unitPrice", label: `单价
（元）`, align: "center" }, { default: a((t) => [r(n(e(i)(t.row.unitPrice, e(c).mes)), 1)]), _: 1 }), l(o, { "show-overflow-tooltip": true, prop: "totalPrice", label: `总价
（元）`, align: "center" }, { default: a((t) => [r(n(e(i)(t.row.totalPrice, e(c).mes)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  v as default
};
