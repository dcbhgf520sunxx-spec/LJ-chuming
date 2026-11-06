import { provide as P } from "vue";
import { ref as c } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as l } from "vue";
import { withCtx as o } from "vue";
import { unref as t } from "vue";
import { createElementVNode as C } from "vue";
import { createBlock as r } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as B } from "vue";
import { createCommentVNode as m } from "vue";
import { ElCol as H } from "element-plus";
import { ElTag as R } from "element-plus";
import { ElTooltip as $ } from "element-plus";
import { ElCard as S } from "element-plus";
import { ElRow as z } from "element-plus";
import { o as L, aP as a, G as k, dN as E, a3 as O } from "../../../../../shared/runtime.js";
import j from "./line/index.vue.js";
import D from "./team/index.vue.js";
import G from "./inspection/index.vue.js";
import "./line/module/header.vue.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "./line/module/form.vue.js";
import "../../../../../modules/production-line-team-8367d2ea.js";
const U = { class: "app-container" }, q = { style: { display: "flex", "align-items": "center", "justify-content": "space-between" } }, F = { style: { display: "flex", "align-items": "center" } }, ae = { __name: "index", setup(J) {
  const { maxHeight: V } = L({ wrapperBox: [".app-container", "#production-line-content"], extraBox: [".head-container", ".el-card__header"], minHeight: 300, paginate: true, extraHeight: 55 });
  P("maxHeight", V);
  const n = c(a.TEAM.V), u = c(), d = c(), e = c({});
  function h(p) {
    p && (e.value = p, e.value.productType & O.MACHINE_PART.V && (n.value = a.TEAM.V));
  }
  return (p, i) => {
    const f = H, N = g("common-radio-button"), T = R, b = $, x = g("common-button"), w = S, M = z;
    return s(), I("div", U, [l(M, { gutter: 10, id: "production-line-content" }, { default: o(() => [l(f, { xs: 24, sm: 24, md: 24, lg: 14, xl: 14, style: { "margin-bottom": "10px" } }, { default: o(() => [l(t(j), { onClickLine: h })]), _: 1 }), l(f, { xs: 12, sm: 12, md: 12, lg: 10, xl: 10 }, { default: o(() => [l(w, { class: "box-card team-card" }, { header: o(() => {
      var v, y;
      return [C("div", q, [C("span", F, [l(N, { modelValue: n.value, "onUpdate:modelValue": i[0] || (i[0] = (A) => n.value = A), disabled: !e.value.name, size: "default", type: "enum", unshowVal: [t(a).INSPECTION.V], options: t(a).ENUM }, null, 8, ["modelValue", "disabled", "unshowVal", "options"]), e.value.factoryName && e.value.name ? (s(), r(b, { key: 0, class: "item", content: `${e.value.factoryName} - ${e.value.name}`, placement: "top" }, { default: o(() => [l(T, { size: "large", style: { "margin-left": "10px", "max-width": "300px", overflow: "hidden", "text-overflow": "ellipsis" } }, { default: o(() => [_(B(`${e.value.factoryName} - ${e.value.name}`), 1)]), _: 1 })]), _: 1 }, 8, ["content"])) : m("", true)]), n.value === t(a).TEAM.V && u.value && t(k)(t(E).edit) && e.value.id ? (s(), r(x, { key: 0, size: "default", style: { float: "right", padding: "6px 10px", "margin-bottom": "0px" }, type: "primary", icon: "el-icon-edit", onClick: (v = u.value) == null ? void 0 : v.toAdd }, { default: o(() => i[1] || (i[1] = [_(" 编辑 ")])), _: 1, __: [1] }, 8, ["onClick"])) : m("", true), n.value === t(a).INSPECTION.V && d.value && t(k)(t(E).edit) && e.value.id ? (s(), r(x, { key: 1, size: "default", style: { float: "right", padding: "6px 10px", "margin-bottom": "0px" }, type: "primary", icon: "el-icon-edit", onClick: (y = d.value) == null ? void 0 : y.toAdd }, { default: o(() => i[2] || (i[2] = [_(" 编辑 ")])), _: 1, __: [2] }, 8, ["onClick"])) : m("", true)])];
    }), default: o(() => [n.value === t(a).TEAM.V ? (s(), r(t(D), { key: 0, ref_key: "teamRef", ref: u, line: e.value }, null, 8, ["line"])) : m("", true), n.value === t(a).INSPECTION.V ? (s(), r(t(G), { key: 1, ref_key: "inspectionRef", ref: d, line: e.value }, null, 8, ["line"])) : m("", true)]), _: 1 })]), _: 1 })]), _: 1 })]);
  };
} };
export {
  ae as default
};
