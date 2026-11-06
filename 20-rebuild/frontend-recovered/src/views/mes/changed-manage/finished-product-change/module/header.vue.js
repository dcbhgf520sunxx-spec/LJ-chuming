import o from "moment";
import { resolveComponent as v } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { withKeys as T } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as i } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as V } from "vue";
import { ElDatePicker as j } from "element-plus";
import { ElInput as k } from "element-plus";
import { l as f, B as Q, I as N, ng as S, bZ as x, nh as P, L as U } from "../../../../../shared/runtime.js";
import { u as E } from "../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
function B(d) {
  return f({ url: "api/plan/artifact/change/warehousing", method: "get", params: d });
}
function R(d) {
  return f({ url: "/api/plan/artifact/change/warehousing/download", method: "get", responseType: "blob", params: d });
}
const G = { get: B }, K = { class: "head-container" }, z = { style: { display: "flex", "justify-content": "space-between" } }, M = { __name: "header", setup(d) {
  const _ = { date: [o().startOf("month").valueOf(), o().valueOf()], startDate: o().startOf("month").valueOf(), endDate: o().valueOf(), monomerId: void 0, projectId: void 0, areaId: void 0, serialNumber: void 0 }, { crud: r, query: e } = Q(_);
  E(r);
  const h = (s) => {
    s && s.length > 1 ? (e.startDate = s[0], e.endDate = s[1]) : (e.startDate = "", e.endDate = ""), r.toQuery();
  }, y = () => {
    r.toQuery();
  }, g = () => {
    e.monomerId = void 0, e.areaId = void 0, e.serialNumber = void 0, e.startDate = o().startOf("month").valueOf(), e.endDate = o().valueOf(), e.date = [o().startOf("month").valueOf(), o().valueOf()], r.toQuery();
  };
  return (s, a) => {
    const I = j, b = k, m = v("common-button"), O = C("permission");
    return c(), D("div", K, [p("div", z, [p("div", null, [l(I, { class: "filter-item", type: "daterange", "range-separator": "-", "start-placeholder": "开始时间", "end-placeholder": "结束时间", modelValue: t(e).date, "onUpdate:modelValue": a[0] || (a[0] = (n) => t(e).date = n), "value-format": "x", "unlink-panels": "", shortcuts: t(N), onChange: h }, null, 8, ["modelValue", "shortcuts"]), l(t(x), { monomerId: t(e).monomerId, "onUpdate:monomerId": a[1] || (a[1] = (n) => t(e).monomerId = n), areaId: t(e).areaId, "onUpdate:areaId": a[2] || (a[2] = (n) => t(e).areaId = n), onChange: t(r).toQuery, productType: t(S).STRUCTURE.V, "project-id": t(e).projectId, clearable: "" }, null, 8, ["monomerId", "areaId", "onChange", "productType", "project-id"]), l(b, { class: "filter-item", style: { width: "200px" }, modelValue: t(e).serialNumber, "onUpdate:modelValue": a[3] || (a[3] = (n) => t(e).serialNumber = n), onKeyup: T(t(r).toQuery, ["enter"]), placeholder: "请输入搜索编号", clearable: "" }, null, 8, ["modelValue", "onKeyup"]), l(m, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: y }, { default: u(() => a[4] || (a[4] = [i("搜索")])), _: 1, __: [4] }), l(m, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: g }, { default: u(() => a[5] || (a[5] = [i("重置")])), _: 1, __: [5] })]), w((c(), V(U, { class: "filter-item", fn: t(R), params: t(e) }, { default: u(() => a[6] || (a[6] = [i("下载成品变更清单")])), _: 1, __: [6] }, 8, ["fn", "params"])), [[O, t(P).download]])])]);
  };
} }, L = Object.freeze(Object.defineProperty({ __proto__: null, default: M }, Symbol.toStringTag, { value: "Module" }));
export {
  M as _,
  G as c,
  L as h
};
