import { ref as V } from "vue";
import m from "moment";
import { inject as E } from "vue";
import { computed as C } from "vue";
import { watch as j } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as n } from "vue";
import { withCtx as p } from "vue";
import { withDirectives as L } from "vue";
import { createElementVNode as d } from "vue";
import { unref as e } from "vue";
import { createTextVNode as b } from "vue";
import { vShow as k } from "vue";
import { ElDatePicker as A } from "element-plus";
import { h as O } from "../../../../../../modules/common-913d415d.js";
import { _ as S, m as U, B, K as c, F as N, kz as f, fv as D, kD as Q, C as R, L as z, E as q } from "../../../../../../shared/runtime.js";
const P = { class: "head-container" }, $ = { class: "searchToggle" }, G = { class: "audit-time" }, H = { class: "button-list" }, M = { __name: "header", setup(X) {
  const { contractSaleTypeEnumArr: _ } = U("contractSaleTypeEnumArr"), u = V({}), h = { type: void 0, status: void 0, projectId: { value: void 0, resetAble: false }, dateTimeList: [], startTime: m().startOf("month").valueOf(), endTime: m().valueOf() }, { crud: s, query: t } = B(h), v = E("projectId"), r = C(() => {
    var l, a;
    return ((l = u.value) == null ? void 0 : l.projectType) === c.BRIDGE.V ? [N.BOX] : ((a = u.value) == null ? void 0 : a.projectType) === c.ENCLOSURE.V ? [f.ENCLOSURE, f.AUXILIARY_MATERIAL] : _.value;
  });
  function y(l) {
    u.value = l, s.toQuery();
  }
  function g() {
    t.date && t.date.length > 1 ? (t.startTime = t.date[0], t.endTime = t.date[1]) : (t.startTime = void 0, t.endTime = void 0), s.toQuery();
  }
  return j(r, (l) => {
    r.value.length && (t.type = r.value[0].V);
  }, { immediate: true, deep: true }), (l, a) => {
    const T = A, i = x("common-radio-button");
    return w(), I("div", P, [n(e(q), null, { optLeft: p(() => [L(d("div", $, [n(e(D), { modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(t).projectId = o), class: "filter-item", style: { width: "300px" }, "default-id": e(v), clearable: "", placeholder: "可选择项目搜索", onProjectChange: y }, null, 8, ["modelValue", "default-id"]), d("div", G, [a[4] || (a[4] = d("span", null, "审核时间：", -1)), n(T, { modelValue: e(t).dateTimeList, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(t).dateTimeList = o), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: g }, null, 8, ["modelValue"])]), n(i, { modelValue: e(t).type, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(t).type = o), options: r.value, type: "enumSL", size: "default", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(i, { modelValue: e(t).status, "onUpdate:modelValue": a[3] || (a[3] = (o) => e(t).status = o), options: e(Q).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), d("div", H, [n(e(R)), n(z, { fn: e(O), "response-header-result": "", params: e(s).query, class: "filter-item" }, { default: p(() => a[5] || (a[5] = [b(" 导出 ")])), _: 1, __: [5] }, 8, ["fn", "params"])])], 512), [[k, e(s).searchToggle]])]), _: 1 })]);
  };
} }, J = S(M, [["__scopeId", "data-v-8196ab8c"]]);
export {
  J as default
};
