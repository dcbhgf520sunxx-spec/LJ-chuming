import { resolveComponent as d } from "vue";
import { openBlock as f } from "vue";
import { createBlock as h } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as r } from "vue";
import { createTextVNode as p } from "vue";
import { unref as n } from "vue";
import { ElTableColumn as b } from "element-plus";
import { t as w, bs as c } from "../../../../../../../shared/runtime.js";
const v = { __name: "auxiliary-material", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 } }, setup(i) {
  const { decimalPrecision: s } = w();
  return (_, g) => {
    const e = b, u = d("common-table");
    return f(), h(u, { data: i.list, "max-height": i.maxHeight, "show-empty-symbol": false, "empty-text": "暂无数据", style: { width: "100%" } }, { default: l(() => [a(e, { label: "序号", type: "index", align: "center", width: "60" }), a(e, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }, { default: l(({ row: t }) => {
      var o;
      return [m("span", null, r(t.monomer ? (o = t.monomer) == null ? void 0 : o.name : "-"), 1)];
    }), _: 1 }), a(e, { "show-overflow-tooltip": true, prop: "area.name", label: "区域" }, { default: l(({ row: t }) => {
      var o;
      return [m("span", null, r(t.area ? (o = t.area) == null ? void 0 : o.name : "-"), 1)];
    }), _: 1 }), a(e, { "show-overflow-tooltip": true, prop: "name", label: "名称" }), a(e, { prop: "measureUnit", label: "单位", align: "center" }), a(e, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), a(e, { prop: "shipQuantity", label: "数量", align: "center" }), a(e, { "show-overflow-tooltip": true, prop: "unitPrice", label: `单价
（元）`, align: "center" }, { default: l((t) => [p(r(n(c)(t.row.unitPrice, n(s).mes)), 1)]), _: 1 }), a(e, { "show-overflow-tooltip": true, prop: "totalPrice", label: `总价
（元）`, align: "center" }, { default: l((t) => [p(r(n(c)(t.row.totalPrice, n(s).mes)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  v as default
};
