import { ref as b } from "vue";
import { onMounted as j } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as P } from "vue";
import { withDirectives as v } from "vue";
import { vShow as C } from "vue";
import { unref as e } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as l } from "vue";
import { withKeys as f } from "vue";
import { withCtx as E } from "vue";
import { renderSlot as S } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElInput as D } from "element-plus";
import { l as u, B as O, lF as T, I as w, C as Q, E as B } from "../../../../../shared/runtime.js";
function K(n) {
  return u({ module: "crm", url: "tech/entrust/list", method: "get", params: n });
}
function x(n) {
  return u({ module: "crm", url: "tech/entrust/filterable/project/list", method: "get", params: n });
}
function z(n) {
  return u({ module: "crm", url: "tech/entrust/remain/projet/list", method: "get", params: n });
}
function W(n) {
  return u({ module: "crm", url: "tech/entrust/save", method: "post", data: n });
}
function k(n) {
  return u({ module: "crm", url: "tech/entrust/delete", method: "post", data: n });
}
const A = { get: K, add: W, del: k }, H = { class: "head-container" }, M = { __name: "header", props: { permission: { type: Object, default: () => {
} } }, setup(n) {
  const m = b([]), h = { crmSettlementBusinessTypeEnum: void 0, crmProjectInformationWarehousingId: void 0, createUserName: void 0, userName: void 0, date: [], startDate: void 0, endDate: void 0 }, { query: t, CRUD: y, crud: s } = O(h);
  function g() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), s.toQuery();
  }
  j(() => {
    i();
  });
  async function i() {
    var d;
    try {
      const o = await x();
      m.value = o || [], (d = m.value) == null || d.forEach((r) => {
        r.id = r.crmProjectInformationWarehousingId, r.name = r.crmProjectInformationWarehousingSerialNumber + " " + r.crmProjectInformationWarehousingName;
      });
    } catch (o) {
      console.log(o, "获取项目列表失败");
    }
  }
  return y.HOOK.afterToQuery = () => {
    i();
  }, (d, o) => {
    const r = p("common-radio-button"), _ = U, V = p("common-select-v2"), c = D;
    return I(), P("div", H, [v(N("div", null, [l(r, { modelValue: e(t).crmSettlementBusinessTypeEnum, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).crmSettlementBusinessTypeEnum = a), options: e(T).ENUM, showOptionAll: "", type: "enum", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(_, { class: "filter-item", "value-format": "x", type: "daterange", shortcuts: e(w), "start-placeholder": "委托指定开始日期", "end-placeholder": "委托指定结束日期", modelValue: e(t).date, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).date = a), onChange: g }, null, 8, ["shortcuts", "modelValue"]), l(V, { modelValue: e(t).crmProjectInformationWarehousingId, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).crmProjectInformationWarehousingId = a), "data-structure": { key: "id", label: "name", value: "id" }, options: m.value, class: "filter-item", clearable: "", filterable: "", type: "other", size: "default", style: { width: "260px" }, placeholder: "请选择项目", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(c, { modelValue: e(t).userName, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).userName = a), class: "filter-item", style: { width: "220px" }, clearable: "", placeholder: "指定负责人搜索", onKeyup: f(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(c, { modelValue: e(t).createUserName, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).createUserName = a), class: "filter-item", clearable: "", style: { width: "220px" }, placeholder: "委托指定人搜索", onKeyup: f(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(Q))], 512), [[C, e(s).searchToggle]]), l(e(B), null, { optLeft: E(() => [S(d.$slots, "addBtn")]), _: 3 })]);
  };
} }, F = Object.freeze(Object.defineProperty({ __proto__: null, default: M }, Symbol.toStringTag, { value: "Module" }));
export {
  M as _,
  A as c,
  z as g,
  F as h
};
