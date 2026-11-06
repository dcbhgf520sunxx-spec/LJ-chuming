import v from "moment";
import { ref as I } from "vue";
import { computed as w } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as U } from "vue";
import { withCtx as b } from "vue";
import { createTextVNode as D } from "vue";
import { ElCascader as S } from "element-plus";
import { ElDatePicker as N } from "element-plus";
import { d as j, g as L } from "../../../../../modules/daily-production-statistics-18379024.js";
import { _ as O, nD as f, B as P, fv as B, C as Q, L as Y } from "../../../../../shared/runtime.js";
const H = { class: "head-container flex" }, M = { __name: "header", setup($) {
  const _ = { meteUnitEnum: f.NET_WEIGHT.V, dateTime: v().valueOf(), projectId: void 0, workshopId: void 0, productionLineId: void 0, processId: void 0 }, c = I(), h = w(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true })), g = async (t) => {
    const { content: n } = await L({ projectId: t });
    if (n) {
      const l = JSON.parse(JSON.stringify(n));
      l.map((s) => {
        s.children = s.projectProductionLineDTOS || [], s.children.map((d) => {
          d.children = d.projectTeamDTOS || [], d.children.map((u) => {
            u.name = u.userName || "";
          });
        });
      }), c.value = l;
    }
  };
  function y(t) {
    t ? (o.workshopId = t[0] || void 0, o.productionLineId = t[1] || void 0, o.teamId = t[2] || void 0) : (o.workshopId = void 0, o.productionLineId = void 0, o.teamId = void 0), r.toQuery();
  }
  const { crud: r, query: o } = P(_);
  function V(t) {
    g(t), r.toQuery();
  }
  return (t, n) => {
    var m;
    const l = C("common-radio-button"), s = S, d = N, u = k("permission");
    return p(), x("div", H, [E("div", null, [i(l, { modelValue: e(o).meteUnitEnum, "onUpdate:modelValue": n[0] || (n[0] = (a) => e(o).meteUnitEnum = a), options: e(f).ENUM, type: "enum", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), i(e(B), { modelValue: e(o).projectId, "onUpdate:modelValue": n[1] || (n[1] = (a) => e(o).projectId = a), class: "filter-item", style: { width: "300px" }, filterable: "", clearable: "", placeholder: "可选择项目搜索", onChange: V }, null, 8, ["modelValue"]), i(s, { class: "filter-item", modelValue: t.workshopProductionLine, "onUpdate:modelValue": n[2] || (n[2] = (a) => t.workshopProductionLine = a), options: c.value, props: h.value, filterable: "", clearable: "", "show-all-levels": "", placeholder: "请选择车间/生产线", onChange: y, style: { width: "250px" } }, null, 8, ["modelValue", "options", "props"]), i(d, { style: { width: "140px" }, modelValue: e(o).dateTime, "onUpdate:modelValue": n[3] || (n[3] = (a) => e(o).dateTime = a), type: "date", size: "default", class: "filter-item", format: "YYYY-MM-DD", "value-format": "x", clearable: false, placeholder: "请选择日期", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), i(e(Q))]), T((p(), U(e(Y), { size: "default", params: { ...e(o) }, fn: e(j) }, { default: b(() => n[4] || (n[4] = [D(" 导出 ")])), _: 1, __: [4] }, 8, ["params", "fn"])), [[u, (m = e(r).permission) == null ? void 0 : m.export]])]);
  };
} }, W = O(M, [["__scopeId", "data-v-19e6c7f3"]]);
export {
  W as default
};
