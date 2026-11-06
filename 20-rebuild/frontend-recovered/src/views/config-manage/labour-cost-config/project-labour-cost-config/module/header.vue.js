import { resolveComponent as i } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as p } from "vue";
import { withDirectives as m } from "vue";
import { vShow as _ } from "vue";
import { unref as e } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as a } from "vue";
import { withKeys as y } from "vue";
import { ElInput as V } from "element-plus";
import { _ as b, eA as r, B as N, C as v, E } from "../../../../../shared/runtime.js";
const h = { class: "head-container" }, x = { __name: "header", props: { orderIds: { type: Array, default: () => [] } }, setup(M) {
  const l = { statisticsMode: r.JETBRAKING.V, projectNumberOrName: "" }, { crud: n, query: t } = N(l);
  return (B, o) => {
    const d = i("component-radio-button"), c = V;
    return u(), p("div", h, [m(f("div", null, [a(d, { class: "filter-item", modelValue: e(t).statisticsMode, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(t).statisticsMode = s), type: "enum", disabledVal: [e(r).REALTIME.V], options: e(r).ENUM }, null, 8, ["modelValue", "disabledVal", "options"]), a(c, { modelValue: e(t).projectNumberOrName, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(t).projectNumberOrName = s), placeholder: "输入项目名或编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: y(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(v))], 512), [[_, e(n).searchToggle]]), a(e(E), { addText: "创建项目工价" })]);
  };
} }, w = b(x, [["__scopeId", "data-v-e6e9b6c5"]]);
export {
  w as default
};
