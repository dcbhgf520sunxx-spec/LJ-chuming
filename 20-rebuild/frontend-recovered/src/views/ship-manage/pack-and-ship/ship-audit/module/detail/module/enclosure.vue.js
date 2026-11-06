import { resolveComponent as d } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as f } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as n } from "vue";
import { toDisplayString as r } from "vue";
import { unref as l } from "vue";
import { ElTableColumn as h } from "element-plus";
import { t as b, c as g, D as c, bs as i } from "../../../../../../../shared/runtime.js";
const C = { __name: "enclosure", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 }, measureUnit: { type: String, default: "m" } }, setup(s) {
  const { decimalPrecision: m } = b();
  return (x, p) => {
    const e = h, w = d("common-table");
    return _(), f(w, { data: s.list, "max-height": s.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: a(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "name", label: "名称" }), t(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(e, { "show-overflow-tooltip": true, prop: "plate", label: "板型" }), t(e, { prop: "showQuantity", label: "数量", align: "center" }), t(e, { "show-overflow-tooltip": true, label: "计量单位", align: "center" }, { default: a(() => p[0] || (p[0] = [u("span", null, "件", -1)])), _: 1, __: [0] }), t(e, { "show-overflow-tooltip": true, prop: "unit", label: "核算单位", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "totalLength", label: `总长
(m)`, align: "center" }, { default: a((o) => [n(r(l(g)(o.row.totalLength, "mm", "m", l(c).MES_ENCLOSURE_L__M)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "totalArea", label: `总面积
(㎡)`, align: "center", width: "100px" }, { default: a((o) => [u("span", null, r(l(i)(o.row.totalArea, l(c).COM_ENCLOSURE_AREA__M2)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "unitPrice", label: `单价
（元）`, align: "center" }, { default: a((o) => [n(r(l(i)(o.row.unitPrice, l(m).shipment)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "totalPrice", label: `总价
（元）`, align: "center" }, { default: a((o) => [n(r(l(i)(o.row.totalPrice, 3)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  C as default
};
