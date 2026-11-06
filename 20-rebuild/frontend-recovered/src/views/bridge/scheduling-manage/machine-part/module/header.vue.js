import { ref as r } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as D } from "vue";
import { withDirectives as q } from "vue";
import { vShow as A } from "vue";
import { unref as n } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as m } from "vue";
import { createBlock as F } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as Z } from "vue";
import { normalizeStyle as H } from "vue";
import { createCommentVNode as P } from "vue";
import { withKeys as L } from "vue";
import { createTextVNode as N } from "vue";
import { withModifiers as O } from "vue";
import { renderSlot as b } from "vue";
import { Fragment as X } from "vue";
import { nextTick as V } from "vue";
import { ElInput as G } from "element-plus";
import { ElInputNumber as J } from "element-plus";
import { g as Y, a as Q, b as ee } from "../../../../../modules/machine-part-b1b959c2.js";
import { B as te, bW as ae, E as le, b as T, F as K } from "../../../../../shared/runtime.js";
import { S as ne } from "../../../../../modules/index-21d3d7d7.js";
const oe = { style: { display: "flex" } }, de = { __name: "header", emits: ["load"], setup(ie, { expose: B, emit: R }) {
  const U = {}, { crud: i, query: e } = te(U), $ = R, h = r(), v = r(), x = r(), w = r(), g = r(1), d = r([]), p = r([]), u = r([]);
  function z() {
    e.serialNumber = void 0, e.maxLength = void 0, e.minLength = void 0, i.toQuery();
  }
  function W() {
    i.page.hasNextPage && $("load");
  }
  async function M(a) {
    if (p.value = [], u.value = [], d.value = [], e.taskTypeEnum = void 0, e.material = void 0, e.thick = void 0, !T(e.projectIds)) try {
      const { content: t } = await Y({ monthList: e.monthList, projectIds: e.projectIds });
      d.value = (t == null ? void 0 : t.map((l) => {
        const s = {};
        return l & K.BOX.V && (s.name = "普通零件"), l & K.CELL.V && (s.name = "翼腹板"), s.value = l, s;
      })) || [], a && (a != null && a.taskTypeEnum) && (t != null && t.length) && t.indexOf(a.taskTypeEnum) !== -1 ? e.taskTypeEnum = a.taskTypeEnum : d.value.length === 1 && (e.taskTypeEnum = d.value[0].value), V(() => {
        w.value = x.value.$el.clientWidth + 15, E(a);
      });
    } catch (t) {
      console.log("获取厚度", t);
    }
  }
  async function E(a) {
    var t;
    if (!T(e.projectIds)) try {
      const { content: l } = await Q({ monthList: e.monthList, projectIds: e.projectIds, taskTypeEnum: e.taskTypeEnum });
      p.value = (l == null ? void 0 : l.map((s, k) => ({ name: s }))) || [], a && (a != null && a.material) && (l != null && l.length) && l.indexOf(a.material) !== -1 ? (e.material = a.material, V(() => {
        v.value = h.value.$el.clientWidth + 15, y(a);
      })) : (t = p.value) != null && t.length && (e.material = p.value[0].name, V(() => {
        v.value = h.value.$el.clientWidth + 15, y();
      }));
    } catch (l) {
      console.log("获取材质", l);
    }
  }
  async function y(a) {
    var t;
    if (!T(e.projectIds)) try {
      u.value = [];
      const { content: l } = await ee({ monthList: e.monthList, projectIds: e.projectIds, material: e.material, taskTypeEnum: e.taskTypeEnum });
      u.value = (l == null ? void 0 : l.map((s) => ({ name: s }))) || [], a && (a != null && a.thick) && (l != null && l.length) && l.indexOf(a.thick) !== -1 ? (e.thick = a.thick, i.toQuery()) : (t = u.value) != null && t.length && (e.thick = u.value[0].name, i.toQuery());
    } catch (l) {
      console.log("获取厚度", l);
    }
  }
  return B({ boxScale: g, refreshConditions: M }), (a, t) => {
    var _, j;
    const l = I("common-radio-button"), s = G, k = J, C = I("common-button");
    return S(), D(X, null, [q(f("div", null, [f("div", oe, [m(l, { ref_key: "typeListRef", ref: x, modelValue: n(e).taskTypeEnum, "onUpdate:modelValue": t[0] || (t[0] = (o) => n(e).taskTypeEnum = o), options: d.value, dataStructure: { key: "value", label: "name", value: "value" }, showOptionAll: ((_ = d.value) == null ? void 0 : _.length) > 1, class: "filter-item", onChange: E }, null, 8, ["modelValue", "options", "showOptionAll"]), m(l, { ref_key: "materialRef", ref: h, modelValue: n(e).material, "onUpdate:modelValue": t[1] || (t[1] = (o) => n(e).material = o), options: p.value, dataStructure: { key: "name", label: "name", value: "name" }, class: "filter-item", onChange: y }, null, 8, ["modelValue", "options"]), (j = u.value) != null && j.length ? (S(), F(n(ae), { key: 0, modelValue: n(e).thick, "onUpdate:modelValue": t[2] || (t[2] = (o) => n(e).thick = o), class: "filter-item", style: H(`width:calc(100% - ${v.value + w.value}px)`), itemKey: "name", data: u.value, onChange: n(i).toQuery }, { default: c(({ item: o }) => [f("span", null, "T = " + Z(o.name), 1)]), _: 1 }, 8, ["modelValue", "style", "data", "onChange"])) : P("", true)]), f("div", null, [m(s, { modelValue: n(e).serialNumber, "onUpdate:modelValue": t[3] || (t[3] = (o) => n(e).serialNumber = o), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: L(n(i).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), m(k, { modelValue: n(e).minLength, "onUpdate:modelValue": t[4] || (t[4] = (o) => n(e).minLength = o), modelModifiers: { number: true }, min: 0, max: n(e).maxLength || 999999999, precision: 0, controls: false, size: "default", style: { width: "130px" }, class: "filter-item", clearable: "", placeholder: "最小长度(mm)", onKeyup: L(n(i).toQuery, ["enter"]) }, null, 8, ["modelValue", "max", "onKeyup"]), t[9] || (t[9] = f("span", { class: "filter-item" }, "~", -1)), m(k, { modelValue: n(e).maxLength, "onUpdate:modelValue": t[5] || (t[5] = (o) => n(e).maxLength = o), modelModifiers: { number: true }, class: "filter-item", min: n(e).minLength || 0, precision: 0, max: 999999999, controls: false, size: "default", style: { width: "130px" }, clearable: "", placeholder: "最大长度(mm)", onKeyup: L(n(i).toQuery, ["enter"]) }, null, 8, ["modelValue", "min", "onKeyup"]), m(C, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: O(n(i).toQuery, ["stop"]) }, { default: c(() => t[7] || (t[7] = [N("搜索")])), _: 1, __: [7] }, 8, ["onClick"]), m(C, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: O(z, ["stop"]) }, { default: c(() => t[8] || (t[8] = [N(" 重置 ")])), _: 1, __: [8] }), b(a.$slots, "searchRight")])], 512), [[A, n(i).searchToggle]]), m(n(le), { "show-grid": false, "show-refresh": false }, { optLeft: c(() => [b(a.$slots, "optLeft")]), viewLeft: c(() => [b(a.$slots, "viewLeft"), m(n(ne), { class: "filter-item", value: g.value, "onUpdate:value": t[6] || (t[6] = (o) => g.value = o), intervals: 400, onZoomOut: W }, null, 8, ["value"])]), _: 3 })], 64);
  };
} };
export {
  de as default
};
