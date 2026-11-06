import s from "moment";
import { ref as k } from "vue";
import { resolveComponent as r } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as I } from "vue";
import { withDirectives as p } from "vue";
import { vShow as O } from "vue";
import { unref as e } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as l } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as U } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as w } from "vue";
import { Fragment as x } from "vue";
import { ElDatePicker as A } from "element-plus";
import { r$ as f, dM as i, B as Q, I as R, C as j, E as B } from "../../../../../../shared/runtime.js";
import { _ as P } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import S from "./summary-detail.vue.js";
import "../../../../../../modules/piecework-system-3800a6fe.js";
import "../../../../../../modules/index-3b2628f3.js";
import "../../../../../../modules/index-490fd9d7.js";
const G = { __name: "header", setup($) {
  const C = { date: [s().subtract(1, "month").valueOf(), s().valueOf()], startDate: s().subtract(1, "month").valueOf(), endDate: s().valueOf(), productType: f.ONCE.V, componentType: i.ARTIFACT.V }, u = k(false);
  function T(m) {
    m === i.ARTIFACT.V ? t.productType = f.ONCE.V : t.productType = m, n.toQuery();
  }
  const { crud: n, query: t } = Q(C);
  function v() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), n.toQuery();
  }
  return (m, o) => {
    const g = r("project-radio-button"), y = r("common-radio-button"), b = A, D = r("print-table"), h = r("common-button"), V = E("permission");
    return d(), I(x, null, [p(N("div", null, [l(g, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).projectId = a), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), l(y, { modelValue: e(t).componentType, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).componentType = a), options: e(i).ENUM, type: "enum", class: "filter-item", onChange: T }, null, 8, ["modelValue", "options"]), e(t).componentType === e(i).ARTIFACT.V ? (d(), _(y, { key: 0, modelValue: e(t).productType, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).productType = a), options: e(f).ENUM, type: "enum", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : U("", true), l(b, { modelValue: e(t).date, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).date = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: false, shortcuts: e(R), "value-format": "x", onChange: v }, null, 8, ["modelValue", "shortcuts"]), l(e(P), { modelValue: e(t).factoryId, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).factoryId = a), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), l(e(j))], 512), [[O, e(n).searchToggle]]), l(e(B), null, { optLeft: c(() => [p(l(D, { "api-key": "mesPiecework", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[V, e(n).permission.print]])]), viewLeft: c(() => {
      var a;
      return [p((d(), _(h, { size: "default", onClick: o[5] || (o[5] = (z) => u.value = true), type: "success" }, { default: c(() => o[7] || (o[7] = [w("汇总查看")])), _: 1, __: [7] })), [[V, (a = e(n).permission) == null ? void 0 : a.summaryDetail]])];
    }), _: 1 }), l(e(S), { visible: u.value, "onUpdate:visible": o[6] || (o[6] = (a) => u.value = a) }, null, 8, ["visible"])], 64);
  };
} };
export {
  G as default
};
