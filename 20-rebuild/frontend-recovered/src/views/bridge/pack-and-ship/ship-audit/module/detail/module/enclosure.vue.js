import { resolveComponent as m } from "vue";
import { openBlock as d } from "vue";
import { createBlock as w } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as n } from "vue";
import { toDisplayString as r } from "vue";
import { unref as l } from "vue";
import { createElementVNode as h } from "vue";
import { ElTableColumn as f } from "element-plus";
import { t as g, bs as i, D as c } from "../../../../../../../shared/runtime.js";
const y = { __name: "enclosure", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 }, measureUnit: { type: String, default: "m" } }, setup(s) {
  const { decimalPrecision: p } = g();
  return (_, b) => {
    const e = f, u = m("common-table");
    return d(), w(u, { data: s.list, "max-height": s.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: a(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "name", label: "名称" }), t(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(e, { "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "120" }), t(e, { "show-overflow-tooltip": true, prop: "netWeight", label: `单重
（kg）`, align: "center" }, { default: a((o) => [n(r(l(i)(o.row.netWeight, l(c).COM_WT__KG)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "length", label: `长度
(mm)`, align: "center" }, { default: a((o) => [n(r(l(i)(o.row.length, l(c).MES_ENCLOSURE_L__MM)), 1)]), _: 1 }), t(e, { prop: "showQuantity", label: "数量", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "totalMete", label: `总量
(${s.measureUnit})`, align: "center", width: "100px" }, { default: a((o) => [h("span", null, r(o.row.totalMete), 1)]), _: 1 }, 8, ["label"]), t(e, { "show-overflow-tooltip": true, prop: "unitPrice", label: `单价
（元）`, align: "center" }, { default: a((o) => [n(r(l(i)(o.row.unitPrice, l(p).bridge)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "totalPrice", label: `总价
（元）`, align: "center" }, { default: a((o) => [n(r(l(i)(o.row.totalPrice, l(p).bridge)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  y as default
};
