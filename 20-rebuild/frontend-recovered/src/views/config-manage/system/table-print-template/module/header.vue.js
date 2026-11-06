import { resolveComponent as f } from "vue";
import { resolveDirective as y } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as V } from "vue";
import { withDirectives as r } from "vue";
import { vShow as g } from "vue";
import { unref as e } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as n } from "vue";
import { withKeys as v } from "vue";
import { withCtx as i } from "vue";
import { createBlock as h } from "vue";
import { createTextVNode as w } from "vue";
import { ElInput as C } from "element-plus";
import { ElTag as E } from "element-plus";
import { aS as d, B as x, C as B, E as U } from "../../../../../shared/runtime.js";
import { _ as k } from "../../../../../modules/index-5e774f84.js";
const q = { __name: "header", setup(N) {
  const u = { name: void 0, enabled: d.TRUE.V, type: void 0 }, { crud: t, query: a } = x(u);
  return (Q, o) => {
    const m = f("common-radio-button"), p = C, c = E, _ = y("permission");
    return s(), V("div", null, [r(b("div", null, [n(m, { modelValue: e(a).enabled, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(a).enabled = l), options: e(d).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(e(k), { modelValue: e(a).type, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(a).type = l), clearable: "", filterable: "", style: { width: "300px" }, class: "filter-item", placeholder: "可搜索表格", onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), n(p, { modelValue: e(a).name, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(a).name = l), placeholder: "输入表格名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: v(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(B))], 512), [[g, e(t).searchToggle]]), n(e(U), null, { viewLeft: i(() => [r((s(), h(c, { size: "large" }, { default: i(() => o[3] || (o[3] = [w("双击表格中的“行”，可更改表格默认模板")])), _: 1, __: [3] })), [[_, e(t).permission.edit]])]), _: 1 })]);
  };
} };
export {
  q as default
};
