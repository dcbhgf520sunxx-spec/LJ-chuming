import { resolveComponent as c } from "vue";
import { openBlock as u } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createCommentVNode as h } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as n } from "vue";
import { createElementVNode as b } from "vue";
import { unref as a } from "vue";
import { ElTableColumn as g } from "element-plus";
import { t as x, bs as i, D as w } from "../../../../../../../shared/runtime.js";
const P = { __name: "structure", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 } }, setup(s) {
  const { decimalPrecision: _ } = x();
  return (v, p) => {
    const e = g, f = c("table-cell-tag"), d = c("common-table");
    return u(), m(d, { data: s.list, "max-height": s.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: l(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "name", label: "名称" }, { default: l((o) => [o.row.warehouseType === 1 ? (u(), m(f, { key: 0, name: "回厂返修", color: "#e64242", offset: 25 })) : h("", true), r(" " + n(o.row.name || "-"), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(e, { "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "120" }), t(e, { prop: "showQuantity", label: "数量", align: "center" }), t(e, { "show-overflow-tooltip": true, label: "计量单位", align: "center" }, { default: l(() => p[0] || (p[0] = [b("span", null, "件", -1)])), _: 1, __: [0] }), t(e, { "show-overflow-tooltip": true, prop: "unit", label: "核算单位", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "totalLength", label: `总长
(m)`, align: "center" }, { default: l((o) => [r(n(a(i)(o.row.totalLength, a(w).MES_ARTIFACT_L__M)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "totalMete", label: `总重
（t）`, align: "center" }, { default: l((o) => [r(n(a(i)(o.row.totalMete, a(w).COM_WT__T)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "unitPrice", label: `单价
（元）`, align: "center" }, { default: l((o) => [r(n(a(i)(o.row.unitPrice, a(_).shipment)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "totalPrice", label: `总价
（元）`, align: "center" }, { default: l((o) => [r(n(a(i)(o.row.totalPrice, 3)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  P as default
};
