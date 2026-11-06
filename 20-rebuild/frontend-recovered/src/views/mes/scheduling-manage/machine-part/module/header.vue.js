import { ref as x } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as U } from "vue";
import { withDirectives as K } from "vue";
import { vShow as M } from "vue";
import { unref as l } from "vue";
import { createElementVNode as r } from "vue";
import { renderSlot as y } from "vue";
import { createVNode as i } from "vue";
import { withKeys as m } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as V } from "vue";
import { withModifiers as k } from "vue";
import { Fragment as O } from "vue";
import { ElInput as z } from "element-plus";
import { ElInputNumber as I } from "element-plus";
import { B as W, qG as D, m0 as R, qL as _, E as B, qM as $, qN as H } from "../../../../../shared/runtime.js";
const P = { style: { display: "flex", "flex-wrap": "wrap", "margin-top": "10px" } }, j = { style: { "margin-top": "10px" } }, J = { __name: "header", emits: ["load", "change"], setup(F, { expose: w, emit: v }) {
  const E = { partType: void 0, taskTypeEnum: void 0, serialNumber: void 0, isRectangle: void 0, boolSendDirectly: void 0 }, { crud: n, query: t } = W(E), N = v, u = x([]), p = x([]);
  function C() {
    t.serialNumber = void 0, t.maxLength = void 0, t.minLength = void 0, t.maxWidth = void 0, t.minWidth = void 0, t.partType = void 0, t.taskTypeEnum = void 0, t.material = void 0, t.thick = void 0, t.isRectangle = void 0, n.toQuery();
  }
  async function T(o) {
    if (n.query.taskOrderIds.length) try {
      u.value = [], p.value = [];
      const e = await $({ taskOrderIds: n.query.taskOrderIds, sendNestingStatus: n.query.sendNestingStatus });
      u.value = (e == null ? void 0 : e.map((s, d) => ({ name: s, label: s }))) || [], o && (o != null && o.material) && (e != null && e.length) && e.indexOf(o.material) !== -1 && (t.material = o.material);
    } catch (e) {
      console.log("获取材质", e);
    }
  }
  async function g(o) {
    if (n.query.taskOrderIds.length) try {
      const e = await H({ taskOrderIds: n.query.taskOrderIds, sendNestingStatus: n.query.sendNestingStatus, steelPlateTypeEnum: n.query.taskTypeEnum ? n.query.taskTypeEnum : [1, 2] });
      p.value = (e == null ? void 0 : e.map((s) => ({ name: s, label: s }))) || [], o && (o != null && o.thick) && (e != null && e.length) && e.indexOf(o.thick) !== -1 && (t.thick = o.thick), N("change", u.value, p.value);
    } catch (e) {
      console.log("获取厚度", e);
    }
  }
  function q() {
    t.thick = void 0, g(), n.toQuery();
  }
  return w({ fetchTick: g, fetchMaterial: T }), (o, e) => {
    const s = h("common-radio-button"), d = h("common-select"), L = z, f = I, b = h("common-button");
    return S(), U(O, null, [K(r("div", null, [y(o.$slots, "searchRight"), r("div", P, [i(s, { modelValue: l(t).boolSendDirectly, "onUpdate:modelValue": e[0] || (e[0] = (a) => l(t).boolSendDirectly = a), options: l(D).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: l(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), i(d, { modelValue: l(t).taskTypeEnum, "onUpdate:modelValue": e[1] || (e[1] = (a) => l(t).taskTypeEnum = a), options: l(R).ENUM, placeholder: "全部类型", style: { width: "200px", "margin-right": "10px" }, type: "enum", multiple: "", clearable: "", "collapse-tags": "", onChange: q }, null, 8, ["modelValue", "options"]), i(d, { modelValue: l(t).material, "onUpdate:modelValue": e[2] || (e[2] = (a) => l(t).material = a), options: u.value, placeholder: "材质筛选", style: { width: "200px", "margin-right": "10px" }, clearable: "", dataStructure: { key: "name", label: "label", value: "name" }, onChange: l(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), i(d, { modelValue: l(t).thick, "onUpdate:modelValue": e[3] || (e[3] = (a) => l(t).thick = a), options: p.value, placeholder: "厚度筛选", multiple: "", style: { width: "200px", "margin-right": "10px" }, clearable: "", dataStructure: { key: "name", label: "label", value: "name" }, onChange: l(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), i(d, { modelValue: l(t).isRectangle, "onUpdate:modelValue": e[4] || (e[4] = (a) => l(t).isRectangle = a), options: l(_).ENUM, placeholder: "类型筛选", multiple: "", style: { width: "200px", "margin-right": "10px" }, type: "enum", clearable: "", "collapse-tags": "", onChange: l(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r("div", j, [i(L, { modelValue: l(t).serialNumber, "onUpdate:modelValue": e[5] || (e[5] = (a) => l(t).serialNumber = a), size: "default", placeholder: "输入编号搜索", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "", onKeyup: m(l(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r("span", null, [i(f, { modelValue: l(t).minWidth, "onUpdate:modelValue": e[6] || (e[6] = (a) => l(t).minWidth = a), modelModifiers: { number: true }, min: 0, max: l(t).maxWidth || 999999999, precision: 0, controls: false, size: "default", style: { width: "130px" }, class: "filter-item", clearable: "", placeholder: "最小宽度(mm)", onKeyup: m(l(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "max", "onKeyup"]), e[10] || (e[10] = r("span", { class: "filter-item" }, "~", -1)), i(f, { modelValue: l(t).maxWidth, "onUpdate:modelValue": e[7] || (e[7] = (a) => l(t).maxWidth = a), modelModifiers: { number: true }, class: "filter-item", min: l(t).minWidth || 0, precision: 0, max: 999999999, controls: false, size: "default", style: { width: "130px" }, clearable: "", placeholder: "最大宽度(mm)", onKeyup: m(l(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "min", "onKeyup"])]), r("span", null, [i(f, { modelValue: l(t).minLength, "onUpdate:modelValue": e[8] || (e[8] = (a) => l(t).minLength = a), modelModifiers: { number: true }, min: 0, max: l(t).maxLength || 999999999, precision: 0, controls: false, size: "default", style: { width: "130px" }, class: "filter-item", clearable: "", placeholder: "最小长度(mm)", onKeyup: m(l(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "max", "onKeyup"]), e[11] || (e[11] = r("span", { class: "filter-item" }, "~", -1)), i(f, { modelValue: l(t).maxLength, "onUpdate:modelValue": e[9] || (e[9] = (a) => l(t).maxLength = a), modelModifiers: { number: true }, class: "filter-item", min: l(t).minLength || 0, precision: 0, max: 999999999, controls: false, size: "default", style: { width: "130px" }, clearable: "", placeholder: "最大长度(mm)", onKeyup: m(l(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "min", "onKeyup"])]), i(b, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: k(l(n).toQuery, ["stop"]) }, { default: c(() => e[12] || (e[12] = [V("搜索")])), _: 1, __: [12] }, 8, ["onClick"]), i(b, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: k(C, ["stop"]) }, { default: c(() => e[13] || (e[13] = [V(" 重置 ")])), _: 1, __: [13] })])])], 512), [[M, l(n).searchToggle]]), i(l(B), { "show-grid": false, "show-refresh": false, showSearch: false }, { optLeft: c(() => [y(o.$slots, "optLeft")]), viewLeft: c(() => [y(o.$slots, "viewLeft")]), _: 3 })], 64);
  };
} };
export {
  J as default
};
