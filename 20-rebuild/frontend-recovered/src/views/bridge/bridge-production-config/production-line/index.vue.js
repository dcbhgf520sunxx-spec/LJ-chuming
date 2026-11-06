import { provide as G } from "vue";
import { ref as c } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as i } from "vue";
import { withCtx as o } from "vue";
import { unref as t } from "vue";
import { createElementVNode as f } from "vue";
import { createBlock as u } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as N } from "vue";
import { createCommentVNode as p } from "vue";
import { withDirectives as O } from "vue";
import { ElCol as U } from "element-plus";
import { ElTag as j } from "element-plus";
import { ElTooltip as q } from "element-plus";
import { ElCard as F } from "element-plus";
import { ElRow as J } from "element-plus";
import { o as K, aP as d, aO as C, aD as w, G as I } from "../../../../shared/runtime.js";
import Q from "./line/index.vue.js";
import W from "./group/index.vue.js";
import X from "./team/index.vue.js";
import Y from "./inspection/index.vue.js";
import "./line/module/form.vue.js";
import "../../../../modules/factory-select-b8d0a4ac.js";
import "./line/module/header.vue.js";
import "../../../../modules/production-line-group-45284ce2.js";
import "./group/module/form.vue.js";
const Z = { class: "app-container" }, ee = { style: { display: "flex", "align-items": "center", "justify-content": "space-between" } }, te = { style: { display: "flex", "align-items": "center" } }, oe = { style: { display: "flex", "align-items": "center", "justify-content": "space-between" } }, ae = { style: { display: "flex", "align-items": "center" } }, ve = { __name: "index", setup(ne) {
  const { maxHeight: A } = K({ wrapperBox: [".app-container", "#production-line-content"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  G("maxHeight", A);
  const V = c(), m = c(d.TEAM.V), v = c(), g = c(), n = c({}), e = c({});
  function M(l) {
    l && (n.value = l, e.value = {}, n.value.productType & w.MACHINE_PART.V && (m.value = d.TEAM.V));
  }
  function P(l) {
    l && (e.value = l);
  }
  function R(l) {
    e.value.teamIds = l;
  }
  function $(l) {
    e.value.inspectionTeamIds = l;
  }
  return (l, a) => {
    const x = U, k = j, T = q, y = E("common-button"), h = F, z = E("common-radio-button"), B = J, H = S("permission");
    return r(), L("div", Z, [i(B, { gutter: 10, id: "production-line-content" }, { default: o(() => [i(x, { xs: 24, sm: 24, md: 24, lg: 12, xl: 12, style: { "margin-bottom": "10px" } }, { default: o(() => [i(t(Q), { onClickLine: M })]), _: 1 }), i(x, { xs: 12, sm: 12, md: 12, lg: 6, xl: 6 }, { default: o(() => [i(h, { class: "box-card team-card" }, { header: o(() => {
      var s;
      return [f("div", ee, [f("span", te, [a[3] || (a[3] = f("span", null, "生产组列表", -1)), n.value.factoryName && n.value.name ? (r(), u(T, { key: 0, class: "item", content: `${n.value.factoryName} - ${n.value.name}`, placement: "top" }, { default: o(() => [i(k, { size: "large", style: { "margin-left": "10px", "max-width": "180px", overflow: "hidden", "text-overflow": "ellipsis" } }, { default: o(() => [_(N(`${n.value.factoryName} - ${n.value.name}`), 1)]), _: 1 })]), _: 1 }, 8, ["content"])) : p("", true)]), O((r(), u(y, { size: "default", style: { float: "right", padding: "6px 10px", "margin-bottom": "0px" }, type: "primary", icon: "el-icon-edit", onClick: (s = V.value) == null ? void 0 : s.toAdd }, { default: o(() => a[4] || (a[4] = [_(" 新增 ")])), _: 1, __: [4] }, 8, ["onClick"])), [[H, t(C).add]])])];
    }), default: o(() => [i(t(W), { ref_key: "groupRef", ref: V, line: n.value, onClickGroup: P }, null, 8, ["line"])]), _: 1 })]), _: 1 }), i(x, { xs: 12, sm: 12, md: 12, lg: 6, xl: 6 }, { default: o(() => [i(h, { class: "box-card team-card" }, { header: o(() => {
      var s, b;
      return [f("div", oe, [f("span", ae, [i(z, { modelValue: m.value, "onUpdate:modelValue": a[0] || (a[0] = (D) => m.value = D), disabled: !e.value.name, size: "default", type: "enum", unshowVal: n.value.productType & t(w).MACHINE_PART.V ? [t(d).INSPECTION.V] : [], options: t(d).ENUM }, null, 8, ["modelValue", "disabled", "unshowVal", "options"]), e.value.name ? (r(), u(T, { key: 0, class: "item", content: `${e.value.name}`, placement: "top" }, { default: o(() => [e.value.name ? (r(), u(k, { key: 0, size: "large", style: { "margin-left": "10px", "max-width": "150px", overflow: "hidden", "text-overflow": "ellipsis" } }, { default: o(() => [_(N(`${e.value.name}`), 1)]), _: 1 })) : p("", true)]), _: 1 }, 8, ["content"])) : p("", true)]), m.value === t(d).TEAM.V && v.value && t(I)(t(C).edit) && e.value.id ? (r(), u(y, { key: 0, size: "default", style: { float: "right", padding: "6px 10px", "margin-bottom": "0px" }, type: "primary", icon: "el-icon-edit", onClick: (s = v.value) == null ? void 0 : s.toAdd }, { default: o(() => a[5] || (a[5] = [_(" 编辑 ")])), _: 1, __: [5] }, 8, ["onClick"])) : p("", true), m.value === t(d).INSPECTION.V && g.value && t(I)(t(C).edit) && e.value.id ? (r(), u(y, { key: 1, size: "default", style: { float: "right", padding: "6px 10px", "margin-bottom": "0px" }, type: "primary", icon: "el-icon-edit", onClick: (b = g.value) == null ? void 0 : b.toAdd }, { default: o(() => a[6] || (a[6] = [_(" 编辑 ")])), _: 1, __: [6] }, 8, ["onClick"])) : p("", true)])];
    }), default: o(() => [m.value === t(d).TEAM.V ? (r(), u(t(X), { key: 0, modelValue: e.value.teamIds, "onUpdate:modelValue": a[1] || (a[1] = (s) => e.value.teamIds = s), ref_key: "teamRef", ref: v, line: n.value, group: e.value, onChange: R }, null, 8, ["modelValue", "line", "group"])) : p("", true), m.value === t(d).INSPECTION.V ? (r(), u(t(Y), { key: 1, modelValue: e.value.inspectionTeamIds, "onUpdate:modelValue": a[2] || (a[2] = (s) => e.value.inspectionTeamIds = s), ref_key: "inspectionRef", ref: g, line: n.value, group: e.value, onChange: $ }, null, 8, ["modelValue", "line", "group"])) : p("", true)]), _: 1 })]), _: 1 })]), _: 1 })]);
  };
} };
export {
  ve as default
};
