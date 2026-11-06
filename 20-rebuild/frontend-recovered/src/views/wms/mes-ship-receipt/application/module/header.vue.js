import { inject as P } from "vue";
import { ref as d } from "vue";
import { watch as _ } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as y } from "vue";
import { withDirectives as O } from "vue";
import { vShow as k } from "vue";
import { unref as e } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as r } from "vue";
import { Fragment as w } from "vue";
import { createCommentVNode as L } from "vue";
import { withCtx as I } from "vue";
import { createTextVNode as D } from "vue";
import { ElInput as x } from "element-plus";
import { B as q, T as u, kC as E, ky as z, q as B, C as Q, E as H } from "../../../../../shared/runtime.js";
import { j as G } from "../../../../../modules/mes-ship-receipt-ae6ae43f.js";
const J = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, currentGlobalProject: { type: Object, default: () => {
} } }, emits: ["toHandle"], setup(g, { emit: b }) {
  const C = b, v = { monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, projectId: { value: void 0, resetAble: false }, name: void 0, specification: void 0, remark: void 0, relationType: { value: void 0, resetAble: false }, hasInit: { value: void 0, resetAble: false }, category: void 0, enclosurePlanId: void 0, useProperty: void 0 }, { crud: o, query: t } = q(v), S = P("handlingData"), U = d(), i = d([]);
  d([]), d([]), d([]), u.PROFILED_PLATE.V, u.PRESSURE_BEARING_PLATE.V, u.TRUSS_FLOOR_PLATE.V, u.SANDWICH_BOARD.V, u.BENDING.V;
  const s = g;
  _(() => s.projectId, (l) => {
    l && (o.query.projectId = s.projectId, t.monomerId = void 0, t.areaId = void 0, t.category = void 0, t.enclosurePlanId = void 0, i.value = [], T(s.currentGlobalProject), N());
  }, { immediate: true, deep: true });
  function j(l) {
    i.value.find((a) => a.id === l), o.toQuery();
  }
  function h(l) {
    i.value = l || [];
  }
  function T(l) {
    o.toQuery();
  }
  async function N() {
    try {
      const l = await G({ projectId: o.query.projectId });
      o.query.relationType = l, o.query.hasInit = true, o.toQuery();
    } catch (l) {
      console.log("初始化获取项目有数据类型", l);
    }
  }
  return (l, a) => {
    const f = p("common-radio-button"), R = p("common-select"), m = x, A = p("common-button");
    return c(), y("div", null, [O(V("div", null, [r(f, { modelValue: e(t).relationType, "onUpdate:modelValue": a[0] || (a[0] = (n) => e(t).relationType = n), options: e(E).ENUM, type: "enum", size: "default", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(f, { modelValue: e(t).useProperty, "onUpdate:modelValue": a[1] || (a[1] = (n) => e(t).useProperty = n), options: e(z).ENUM, showOptionAll: "", class: "filter-item", size: "default", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(t).relationType === e(E).STRUCTURE.V ? (c(), y(w, { key: 0 }, [r(e(B), { ref_key: "monomerSelectRef", ref: U, modelValue: e(t).monomerId, "onUpdate:modelValue": a[2] || (a[2] = (n) => e(t).monomerId = n), "project-id": s.projectId, default: false, clearable: "", class: "filter-item", onChange: e(o).toQuery, onGetAreaInfo: h }, null, 8, ["modelValue", "project-id", "onChange"]), r(R, { modelValue: e(t).areaId, "onUpdate:modelValue": a[3] || (a[3] = (n) => e(t).areaId = n), options: i.value, type: "other", clearable: "", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: j }, null, 8, ["modelValue", "options"])], 64)) : L("", true), V("div", null, [r(m, { modelValue: e(t).name, "onUpdate:modelValue": a[4] || (a[4] = (n) => e(t).name = n), size: "default", placeholder: "名称", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(m, { modelValue: e(t).specification, "onUpdate:modelValue": a[5] || (a[5] = (n) => e(t).specification = n), size: "default", placeholder: "规格", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(m, { modelValue: e(t).remark, "onUpdate:modelValue": a[6] || (a[6] = (n) => e(t).remark = n), size: "default", placeholder: "备注", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(e(Q))])], 512), [[k, e(o).searchToggle]]), r(e(H), null, { optLeft: I(() => [r(A, { size: "default", type: "primary", disabled: e(S).length === 0, onClick: a[7] || (a[7] = (n) => C("toHandle")) }, { default: I(() => a[8] || (a[8] = [D("配套件领用办理")])), _: 1, __: [8] }, 8, ["disabled"])]), _: 1 })]);
  };
} };
export {
  J as default
};
