import g from "moment";
import { inject as h } from "vue";
import { ref as E } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as d } from "vue";
import { withDirectives as I } from "vue";
import { vShow as $ } from "vue";
import { unref as t } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as k } from "vue";
import { createBlock as C } from "vue";
import { createCommentVNode as R } from "vue";
import { Fragment as L } from "vue";
import { ElDatePicker as P } from "element-plus";
import { Loading as z } from "@element-plus/icons-vue";
import { ElIcon as A } from "element-plus";
import { ElTag as H } from "element-plus";
import { g as q } from "../../../../../modules/report-1b32adbc.js";
import { B as G, G as K, o8 as W, I as F, C as Y, E as J } from "../../../../../shared/runtime.js";
import { _ as X } from "../../../../../modules/factory-select-b8d0a4ac.js";
const Z = { key: 0 }, ee = { key: 0 }, te = { key: 0 }, oe = { key: 0 }, ne = { key: 0 }, ue = { __name: "header", emits: ["showDetail"], setup(ae, { emit: w }) {
  const N = { date: [g().startOf("month").valueOf(), g().valueOf()], startDate: g().startOf("month").valueOf(), endDate: g().valueOf(), projectId: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false }, factoryId: void 0 }, { crud: p, query: o, CRUD: U } = G(N), M = w, f = h("reportTypeEnum"), D = h("permission");
  function c(u) {
    M("showDetail", u);
  }
  function S() {
    o.date && o.date.length > 1 ? (o.startDate = o.date[0], o.endDate = o.date[1]) : (o.startDate = void 0, o.endDate = void 0), p.toQuery();
  }
  const r = E(false), i = E({});
  U.HOOK.beforeToQuery = () => {
    B();
  };
  async function B() {
    if (!(!K(D.get) || !o.productType)) {
      r.value = true, i.value = {};
      try {
        const { beginMete: u = 0, inboundMete: e = 0, outboundMete: V = 0, endMete: b = 0 } = await q(o);
        i.value = { beginMete: u, inboundMete: e, outboundMete: V, endMete: b };
      } catch (u) {
        console.log("获取汇总数据", u);
      } finally {
        r.value = false;
      }
    }
  }
  return (u, e) => {
    const V = O("project-radio-button"), b = O("component-radio-button"), j = P, x = O("print-table"), y = z, _ = A, v = H, T = Q("permission");
    return l(), d(L, null, [I(m("div", null, [n(V, { size: "default", modelValue: t(o).projectId, "onUpdate:modelValue": e[0] || (e[0] = (a) => t(o).projectId = a), class: "filter-item", onChange: t(p).toQuery }, null, 8, ["modelValue", "onChange"]), n(b, { modelValue: t(o).productType, "onUpdate:modelValue": e[1] || (e[1] = (a) => t(o).productType = a), options: t(W).ENUM, showOptionAll: "", type: "enum", class: "filter-item", onChange: t(p).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(j, { modelValue: t(o).date, "onUpdate:modelValue": e[2] || (e[2] = (a) => t(o).date = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "300px" }, clearable: false, shortcuts: t(F), "value-format": "x", onChange: S }, null, 8, ["modelValue", "shortcuts"]), n(X, { modelValue: t(o).factoryId, "onUpdate:modelValue": e[3] || (e[3] = (a) => t(o).factoryId = a), clearable: "", class: "filter-item", style: { width: "250px" }, onChange: t(p).toQuery }, null, 8, ["modelValue", "onChange"]), n(t(Y))], 512), [[$, t(p).searchToggle]]), n(t(J), null, { optLeft: s(() => [I(n(x, { "api-key": "mesWarehouseStateReport", params: { ...t(o) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[T, t(D).print]])]), viewLeft: s(() => [t(o).productType ? I((l(), d("span", Z, [n(v, { effect: "plain", style: { cursor: "pointer" }, class: "filter-item", onClick: e[4] || (e[4] = (a) => c(t(f).BEGIN.V)) }, { default: s(() => [e[8] || (e[8] = m("span", null, "期初库存：", -1)), r.value ? (l(), C(_, { key: 1 }, { default: s(() => [n(y)]), _: 1 })) : (l(), d("span", ee, k(i.value.beginMete), 1))]), _: 1, __: [8] }), n(v, { effect: "plain", style: { cursor: "pointer" }, class: "filter-item", onClick: e[5] || (e[5] = (a) => c(t(f).INBOUND.V)) }, { default: s(() => [e[9] || (e[9] = m("span", null, "入库量：", -1)), r.value ? (l(), C(_, { key: 1 }, { default: s(() => [n(y)]), _: 1 })) : (l(), d("span", te, k(i.value.inboundMete), 1))]), _: 1, __: [9] }), n(v, { effect: "plain", style: { cursor: "pointer" }, class: "filter-item", onClick: e[6] || (e[6] = (a) => c(t(f).OUTBOUND.V)) }, { default: s(() => [e[10] || (e[10] = m("span", null, "出库量：", -1)), r.value ? (l(), C(_, { key: 1 }, { default: s(() => [n(y)]), _: 1 })) : (l(), d("span", oe, k(i.value.outboundMete), 1))]), _: 1, __: [10] }), n(v, { effect: "plain", style: { cursor: "pointer" }, class: "filter-item", type: "success", onClick: e[7] || (e[7] = (a) => c(t(f).END.V)) }, { default: s(() => [e[11] || (e[11] = m("span", null, "期末库存：", -1)), r.value ? (l(), C(_, { key: 1 }, { default: s(() => [n(y)]), _: 1 })) : (l(), d("span", ne, k(i.value.endMete), 1))]), _: 1, __: [11] })])), [[T, t(D).get]]) : R("", true)]), _: 1 })], 64);
  };
} };
export {
  ue as default
};
