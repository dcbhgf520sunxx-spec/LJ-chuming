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
    return c(), h(s, { ref: "tableRef", data: t.list, "show-summary": false, "summary-method": i, "data-format": r.value, "max-height": t.maxHeight, "highlight-current-row": "", "row-key": "id" }, { default: n(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), e(o, { prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), e(o, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), e(o, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), e(o, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140px" }), e(o, { prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), e(o, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), e(o, { prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), e(o, { label: "总重(kg)", align: "center", "show-overflow-tooltip": "" }, { default: n(({ row: { sourceRow: l } }) => [u("span", null, w(f(x)(l.quantity * l.netWeight, 2)), 1)]), _: 1 }), e(o, { prop: "pricingMethod", label: "计价方式", align: "center", "show-overflow-tooltip": "" }), e(_, { showAmountExcludingVAT: false, showInputVAT: false }), e(o, { prop: "destination", label: "目的地", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"]);
  };
} };
export {
  k as default
};
