import { resolveComponent as u } from "vue";
import { openBlock as w } from "vue";
import { createBlock as d } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as n } from "vue";
import { toDisplayString as r } from "vue";
import { unref as l } from "vue";
import { createElementVNode as _ } from "vue";
import { ElTableColumn as h } from "element-plus";
import { t as f, bs as i, D as p } from "../../../../../../../shared/runtime.js";
const E = { __name: "enclosure", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 }, measureUnit: { type: String, default: "m" } }, setup(s) {
  const { decimalPrecision: c } = f();
  return (b, g) => {
    const t = h, m = u("common-table");
    return w(), d(m, { data: s.list, "max-height": s.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: a(() => [o(t, { label: "序号", type: "index", align: "center", width: "60" }), o(t, { "show-overflow-tooltip": true, prop: "name", label: "名称" }), o(t, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), o(t, { "show-overflow-tooltip": true, prop: "thickness", label: `厚度
(mm)`, align: "center" }, { default: a((e) => [n(r(l(i)(e.row.thickness, l(p).MES_ENCLOSURE_T__MM)), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": true, prop: "width", label: `有效宽度
(mm)`, align: "center" }, { default: a((e) => [n(r(l(i)(e.row.width, l(p).MES_ENCLOSURE_W__MM)), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": true, prop: "length", label: `长度
(mm)`, align: "center" }, { default: a((e) => [n(r(l(i)(e.row.length, l(p).MES_ENCLOSURE_L__MM)), 1)]), _: 1 }), o(t, { prop: "showQuantity", label: "数量", align: "center" }), o(t, { "show-overflow-tooltip": true, prop: "totalMete", label: `总量
(${s.measureUnit})`, align: "center", width: "100px" }, { default: a((e) => [_("span", null, r(e.row.totalMete), 1)]), _: 1 }, 8, ["label"]), o(t, { "show-overflow-tooltip": true, prop: "unitPrice", label: `单价
（元）`, align: "center" }, { default: a((e) => [n(r(l(i)(e.row.unitPrice, l(c).mes)), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": true, prop: "totalPrice", label: `总价
（元）`, align: "center" }, { default: a((e) => [n(r(l(i)(e.row.totalPrice, l(c).mes)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  E as default
};
