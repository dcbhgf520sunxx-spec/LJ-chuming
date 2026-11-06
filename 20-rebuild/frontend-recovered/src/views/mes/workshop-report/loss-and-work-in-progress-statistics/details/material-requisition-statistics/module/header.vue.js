import { ref as g } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as T } from "vue";
import { withDirectives as N } from "vue";
import { vShow as P } from "vue";
import { unref as e } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as o } from "vue";
import { createBlock as M } from "vue";
import { createCommentVNode as D } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as c } from "vue";
import { ElDatePicker as L } from "element-plus";
import { ElInput as U } from "element-plus";
import { ElTag as z } from "element-plus";
import { l as p, sj as h, B as I, aV as Q, sl as B, C as O, L as j, E as q } from "../../../../../../../shared/runtime.js";
function W(n) {
  return p({ url: "/api/mes/loss/progress/statistics/wastage/costSummary/picking/detail", method: "get", params: n });
}
function $(n) {
  return p({ url: "/api/mes/loss/progress/statistics/wastage/costSummary/picking/detail/download", method: "get", responseType: "blob", params: n });
}
function A(n) {
  return p({ url: "/api/mes/loss/progress/statistics/wastage/costSummary/picking/summary", method: "get", params: n });
}
const R = { get: W }, H = { __name: "header", setup(n) {
  const V = { lossWorkProgressStatisticsEnum: h.ALL.V, dateTimeList: [], workShopId: void 0, basicClass: void 0, classifyName: void 0 }, k = g([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), { crud: r, query: s, CRUD: w } = I(V), l = g();
  async function b() {
    try {
      const u = await A(s);
      l.value = u;
    } catch (u) {
      console.log(u);
    }
  }
  return w.HOOK.beforeToQuery = () => {
    b();
  }, (u, a) => {
    const v = y("common-radio-button"), C = L, S = y("common-select"), E = U, d = z;
    return _(), T("div", null, [N(x("div", null, [o(v, { modelValue: e(s).lossWorkProgressStatisticsEnum, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(s).lossWorkProgressStatisticsEnum = t), options: e(h).ENUM, type: "enum", size: "small", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), u.isInProductionType ? D("", true) : (_(), M(C, { key: 0, modelValue: e(s).dateTimeList, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(s).dateTimeList = t), "default-time": k.value, class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(r).toQuery }, null, 8, ["modelValue", "default-time", "onChange"])), o(e(Q), { modelValue: e(s).workShopId, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(s).workShopId = t), placeholder: "领用车间", class: "filter-item", style: { width: "240px" }, clearable: "", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), o(S, { modelValue: e(s).basicClass, "onUpdate:modelValue": a[3] || (a[3] = (t) => e(s).basicClass = t), options: e(B).ENUM, type: "enum", size: "small", class: "filter-item", placeholder: "材料类型", style: { width: "240px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(E, { modelValue: e(s).classifyName, "onUpdate:modelValue": a[4] || (a[4] = (t) => e(s).classifyName = t), class: "filter-item", clearable: "", placeholder: "物料种类", size: "small", style: { width: "240px" } }, null, 8, ["modelValue"]), o(e(O))], 512), [[P, e(r).searchToggle]]), o(e(q), null, { optLeft: i(() => [o(e(j), { fn: e($), params: e(r).query, "response-header-result": "" }, { default: i(() => a[5] || (a[5] = [m(" 领料记录下载 ")])), _: 1, __: [5] }, 8, ["fn", "params"])]), viewLeft: i(() => [o(d, { size: "medium", type: "primary", class: "filter-item" }, { default: i(() => {
      var t;
      return [m("出库量合计：" + c(((t = l.value) == null ? void 0 : t.outboundMete) ?? "-") + "吨", 1)];
    }), _: 1 }), o(d, { size: "medium", type: "primary", class: "filter-item" }, { default: i(() => {
      var t;
      return [m("退库量合计：" + c(((t = l.value) == null ? void 0 : t.returnMete) ?? "-") + "吨", 1)];
    }), _: 1 }), o(d, { size: "medium", type: "primary", class: "filter-item" }, { default: i(() => {
      var t, f;
      return [m(" 实际出库量：" + c(((t = l.value) == null ? void 0 : t.outboundMete) != null && ((f = l.value) == null ? void 0 : f.returnMete) != null ? (Number(l.value.outboundMete) - Number(l.value.returnMete)).toFixed(5) : "-") + "吨 ", 1)];
    }), _: 1 })]), _: 1 })]);
  };
} }, G = Object.freeze(Object.defineProperty({ __proto__: null, default: H }, Symbol.toStringTag, { value: "Module" }));
export {
  H as _,
  R as c,
  G as h
};
