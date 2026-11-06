import { ref as m } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as c } from "vue";
import { createBlock as h } from "vue";
import { withCtx as n } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as w } from "vue";
import { unref as f } from "vue";
import { ElTableColumn as d } from "element-plus";
import { fE as g, aT as b, iX as x, vb as _, ba as v } from "../../../../../../../shared/runtime.js";
const k = { __name: "manufactured", props: { list: { type: Array, default: () => [] }, maxHeight: { type: Number } }, setup(t) {
  const r = m([["destination", ["parse-enum", g]], ["pricingMethod", ["parse-enum", b]]]);
  function i(a) {
    return v(a, { props: ["amount", "mete"], toThousandFields: ["amount", "mete"] });
  }
  return (a, y) => {
    const o = d, s = p("common-table");
    return c(), h(s, { ref: "tableRef", data: t.list, "data-format": r.value, "max-height": t.maxHeight, "show-summary": false, "summary-method": i, "highlight-current-row": "", "row-key": "id" }, { default: n(() => [e(o, { align: "center", label: "序号", type: "index", width: "60" }), e(o, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), e(o, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), e(o, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), e(o, { align: "center", label: "编号", "min-width": "100px", prop: "serialNumber", "show-overflow-tooltip": "" }), e(o, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), e(o, { align: "center", label: "长度（mm）", "min-width": "100px", prop: "length", "show-overflow-tooltip": "" }), e(o, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), e(o, { align: "center", label: "数量", prop: "quantity", "show-overflow-tooltip": "" }), e(o, { align: "center", label: "总重(kg)", "show-overflow-tooltip": "" }, { default: n(({ row: { sourceRow: l } }) => [u("span", null, w(f(x)(l.quantity * l.netWeight, 2)), 1)]), _: 1 }), e(o, { align: "center", label: "计价方式", prop: "pricingMethod", "show-overflow-tooltip": "" }), e(_, { showAmountExcludingVAT: false, showInputVAT: false }), e(o, { align: "center", label: "目的地", prop: "destination", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"]);
  };
} };
export {
  k as default
};
