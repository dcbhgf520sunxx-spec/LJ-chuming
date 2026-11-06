import { resolveDirective as m } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as t } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withKeys as p } from "vue";
import { withDirectives as _ } from "vue";
import { createBlock as f } from "vue";
import { withCtx as v } from "vue";
import { createTextVNode as x } from "vue";
import { ElInput as y } from "element-plus";
import { d as b } from "../../../../../../modules/personal-production-statistics-348e794f.js";
import { B as N, C as V, nE as h, L as w } from "../../../../../../shared/runtime.js";
const B = { class: "flex-rbc" }, g = { __name: "header", setup(E) {
  const i = { serialNumber: void 0 }, { crud: l, query: a } = N(i);
  return (k, s) => {
    const n = y, d = m("permission");
    return r(), c("div", null, [t("div", B, [t("div", null, [o(n, { modelValue: e(a).serialNumber, "onUpdate:modelValue": s[0] || (s[0] = (u) => e(a).serialNumber = u), modelModifiers: { trim: true }, placeholder: "输入构件编号、名称、规格搜索", class: "filter-item", style: { width: "280px" }, size: "default", clearable: "", onKeyup: p(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(V))]), _((r(), f(e(w), { fn: e(b), params: e(a), "response-header-result": "" }, { default: v(() => s[1] || (s[1] = [x(" 导出产量明细表 ")])), _: 1, __: [1] }, 8, ["fn", "params"])), [[d, e(h).detailExport]])])]);
  };
} };
export {
  g as default
};
