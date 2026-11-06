import { ref as m } from "vue";
import p from "moment";
import { computed as D } from "vue";
import { onMounted as C } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as L } from "vue";
import { createElementBlock as M } from "vue";
import { createVNode as n } from "vue";
import { unref as o } from "vue";
import { createElementVNode as P } from "vue";
import { ElCascader as A } from "element-plus";
import { ElDatePicker as S } from "element-plus";
import { l as c, q0 as r, B as Y, er as E } from "../../../../../shared/runtime.js";
function O(i) {
  return c({ url: "/api/mes/building/production-wage-manage/yield-confirm/unaudited-workshop-process-team-list", method: "get", params: i });
}
function U() {
  return c({ url: "/api/mes/building/process/artifact-process-list", method: "get" });
}
function I() {
  return c({ url: "/api/mes/building/process/assemble-process-list", method: "get" });
}
const x = { get: O }, Q = { class: "head-container" }, z = { __name: "header", setup(i) {
  const d = m([]), h = { selectedDate: p().valueOf(), yearMonthDaySelect: r.TODAY.V, workshopId: void 0 }, u = m(), { crud: l, query: a } = Y(h);
  async function y() {
    try {
      const t = await U(), e = await I();
      u.value = [...t, ...e];
    } catch (t) {
      console.log(t);
    }
  }
  y();
  const g = D(() => ({ value: "id", label: "name", children: "children", emitPath: false }));
  C(() => _());
  async function _() {
    try {
      const { content: t } = await E({});
      t.forEach((e) => {
        e.children = e.workshopList;
      }), console.log(t), d.value = t;
    } catch {
      console.log("请求工厂-车间-生产线的层级接口失败");
    }
  }
  function b(t) {
    t === r.TODAY.V && (a.selectedDate = p().valueOf()), l.toQuery();
  }
  return (t, e) => {
    const V = A, v = f("common-radio-button"), w = S, k = f("common-select");
    return L(), M("div", Q, [n(V, { options: d.value, modelValue: o(a).workshopId, "onUpdate:modelValue": e[0] || (e[0] = (s) => o(a).workshopId = s), props: g.value, separator: " > ", "show-all-levels": "", clearable: "", size: "default", class: "filter-item", style: { width: "100%" }, placeholder: "全部车间", onChange: o(l).toQuery }, null, 8, ["options", "modelValue", "props", "onChange"]), P("div", null, [n(v, { modelValue: o(a).yearMonthDaySelect, "onUpdate:modelValue": e[1] || (e[1] = (s) => o(a).yearMonthDaySelect = s), style: { width: "100%" }, options: o(r).ENUM, class: "filter-item", type: "enum", onChange: b }, null, 8, ["modelValue", "options"]), n(w, { style: { width: "100%" }, modelValue: o(a).selectedDate, "onUpdate:modelValue": e[2] || (e[2] = (s) => o(a).selectedDate = s), type: "date", size: "default", class: "filter-item", format: "YYYY-MM-DD", "value-format": "x", clearable: false, placeholder: "请选择日期", onChange: o(l).toQuery }, null, 8, ["modelValue", "onChange"])]), n(k, { modelValue: o(a).processId, "onUpdate:modelValue": e[3] || (e[3] = (s) => o(a).processId = s), options: u.value, clearable: "", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", placeholder: "工序筛选", class: "filter-item", style: { width: "100%" }, onChange: o(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])]);
  };
} }, N = Object.freeze(Object.defineProperty({ __proto__: null, default: z }, Symbol.toStringTag, { value: "Module" }));
export {
  z as _,
  x as c,
  N as h
};
