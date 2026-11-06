import { resolveComponent as c } from "vue";
import { openBlock as o } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { createVNode as e } from "vue";
import { createCommentVNode as r } from "vue";
import { unref as d } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as h } from "vue";
import { ElTableColumn as b } from "element-plus";
import { jG as g, k5 as w, jH as x, vb as y, fE as _, jX as T, bR as N, ba as C, jN as E } from "../../../../../../../shared/runtime.js";
const v = { __name: "raw-material", props: { list: { type: Array, default: () => [] }, maxHeight: { type: Number }, materialType: { type: Number }, boolUseRequisitions: { type: Boolean, default: false }, level: { type: [String, Number], default: void 0 } }, setup(a) {
  const i = [...T, ["weightMeasurementMode", ["parse-enum", N]]];
  function m(n) {
    return C(n, { props: ["amount", ["mete", E.weight.precision]], toThousandFields: ["amount", "mete"] });
  }
  return (n, S) => {
    const t = b, u = c("common-table");
    return o(), l(u, { ref: "tableRef", data: a.list, "data-format": i, "default-expand-all": false, "max-height": a.maxHeight, "show-summary": false, "summary-method": m, "highlight-current-row": "", "row-key": "id" }, { default: s(() => [e(t, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), a.boolUseRequisitions ? (o(), l(t, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : r("", true), e(g, { "show-index": false, fixed: "left", "spec-merge": "" }), e(w, { fixed: "left" }), e(x), e(y, { showAmountExcludingVAT: false, showInputVAT: false }), a.level === d(_).FACTORY.V ? (o(), l(t, { key: 1, align: "center", label: "项目", "min-width": "200px", prop: "projectFullName", "show-overflow-tooltip": "" })) : r("", true), e(t, { align: "center", label: "所属工厂", "min-width": "100px", prop: "factoryDTO", "show-overflow-tooltip": "" }, { default: s(({ row: f }) => [p(h(f.factoryDTO.name), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  v as default
};
