import { resolveComponent as w } from "vue";
import { openBlock as d } from "vue";
import { createBlock as f } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as _ } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as n } from "vue";
import { unref as l } from "vue";
import { ElTableColumn as h } from "element-plus";
import { t as b, bs as i, D as c } from "../../../../../../../shared/runtime.js";
const y = { __name: "box", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 } }, setup(s) {
  const { decimalPrecision: u } = b();
  return (g, p) => {
    const e = h, m = w("common-table");
    return d(), f(m, { data: s.list, "max-height": s.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: a(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "name", label: "名称" }), t(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(e, { "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "120" }), t(e, { prop: "showQuantity", label: "数量", align: "center" }), t(e, { "show-overflow-tooltip": true, label: "计量单位", align: "center" }, { default: a(() => p[0] || (p[0] = [_("span", null, "件", -1)])), _: 1, __: [0] }), t(e, { "show-overflow-tooltip": true, prop: "unit", label: "核算单位", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "totalLength", label: `总长
(m)`, align: "center" }, { default: a((o) => [r(n(l(i)(o.row.totalLength, l(c).MES_ARTIFACT_L__M)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "totalMete", label: `总重
（t）`, align: "center" }, { default: a((o) => [r(n(l(i)(o.row.totalMete, l(c).COM_WT__T)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "unitPrice", label: `单价
（元）`, align: "center" }, { default: a((o) => [r(n(l(i)(o.row.unitPrice, l(u).shipment)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "totalPrice", label: `总价
（元）`, align: "center" }, { default: a((o) => [r(n(l(i)(o.row.totalPrice, 3)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  y as default
};
