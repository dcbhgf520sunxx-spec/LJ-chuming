import { pc as r, B as l, E as u } from "../../../../../../../shared/runtime.js";
import { resolveComponent as d } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
const f = { style: { display: "flex", "align-items": "center" } }, g = { __name: "header", setup(y) {
  const a = { factoryOrConstructionSite: r.FACTORY.V }, { crud: s, query: o } = l(a);
  return (_, t) => {
    const c = d("common-radio-button");
    return m(), p("div", f, [n(e(u), { showGrid: false, showSearch: false, showRefresh: false, addBatchText: "新增一级分类" }), n(c, { modelValue: e(o).factoryOrConstructionSite, "onUpdate:modelValue": t[0] || (t[0] = (i) => e(o).factoryOrConstructionSite = i), options: e(r).ENUM, type: "enum", size: "default", style: { "margin-right": "10px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"])]);
  };
} };
export {
  g as default
};
