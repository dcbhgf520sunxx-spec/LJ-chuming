import { openBlock as a } from "vue";
import { createElementBlock as l } from "vue";
import { withDirectives as D } from "vue";
import { vShow as j } from "vue";
import { unref as t } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as n } from "vue";
import { withCtx as d } from "vue";
import { createBlock as h } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as o } from "vue";
import { ElInput as P } from "element-plus";
import { ElTag as k } from "element-plus";
import { B as v, C as V, p as i, c7 as w, E as x } from "../../../../../shared/runtime.js";
const B = { key: 0 }, C = { key: 1 }, E = { key: 2 }, q = { __name: "header", props: { globalProject: { type: Object, default: () => {
} } }, setup(e) {
  const u = { name: void 0 }, { crud: m, query: s } = v(u), g = e;
  return (_, c) => {
    const f = P, b = k;
    return a(), l("div", null, [D(p("div", null, [n(f, { modelValue: t(s).name, "onUpdate:modelValue": c[0] || (c[0] = (y) => t(s).name = y), placeholder: "输入单体名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), n(t(V))], 512), [[j, t(m).searchToggle]]), n(t(x), null, { viewLeft: d(() => [g.globalProject.startDate ? (a(), h(b, { key: 0, type: "info", effect: "plain", style: { "margin-right": "5px" } }, { default: d(() => [e.globalProject.startDate ? (a(), l("span", B, "开工日期:" + r(t(i)(e.globalProject.startDate, "{y}-{m}-{d}")), 1)) : o("", true), e.globalProject.endDate ? (a(), l("span", C, " | 完成日期:" + r(t(i)(e.globalProject.endDate, "{y}-{m}-{d}")), 1)) : o("", true), e.globalProject.startDate && e.globalProject.endDate ? (a(), l("span", E, " | 工期:" + r(t(w)(e.globalProject.startDate, e.globalProject.endDate)) + "天", 1)) : o("", true)]), _: 1 })) : o("", true)]), _: 1 })]);
  };
} };
export {
  q as default
};
