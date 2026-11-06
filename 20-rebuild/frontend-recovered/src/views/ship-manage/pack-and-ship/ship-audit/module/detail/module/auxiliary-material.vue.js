import { resolveComponent as c } from "vue";
import { openBlock as u } from "vue";
import { createBlock as f } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as w } from "vue";
import { toDisplayString as l } from "vue";
import { createTextVNode as n } from "vue";
import { unref as p } from "vue";
import { ElTableColumn as h } from "element-plus";
import { t as d, bs as s } from "../../../../../../../shared/runtime.js";
const y = { __name: "auxiliary-material", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 } }, setup(r) {
  return d(), (b, _) => {
    const e = h, m = c("common-table");
    return u(), f(m, { data: r.list, "show-empty:symbol": false, "max-height": r.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: a(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }, { default: a(({ row: o }) => {
      var i;
      return [w("span", null, l(o.monomer ? (i = o.monomer) == null ? void 0 : i.name : "-"), 1)];
    }), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "name", label: "名称" }), t(e, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), t(e, { "show-overflow-tooltip": true, prop: "measureUnit", label: "计量单位", align: "center" }), t(e, { prop: "showQuantity", label: "数量", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "accountingUnit", label: "核算单位", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "shipMete", label: "核算量", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "unitPrice", label: "单价(元)" }, { default: a((o) => [n(l(p(s)(o.row.unitPrice, 4)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "totalPrice", label: "总价(元)" }, { default: a((o) => [n(l(p(s)(o.row.totalPrice, 4)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  y as default
};
