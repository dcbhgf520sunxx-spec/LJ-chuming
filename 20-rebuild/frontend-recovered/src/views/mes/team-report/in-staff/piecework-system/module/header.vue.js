import s from "moment";
import { ref as C } from "vue";
import { resolveComponent as r } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as D } from "vue";
import { withDirectives as u } from "vue";
import { vShow as w } from "vue";
import { unref as e } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as n } from "vue";
import { withCtx as d } from "vue";
import { createBlock as k } from "vue";
import { createTextVNode as E } from "vue";
import { Fragment as O } from "vue";
import { ElDatePicker as T } from "element-plus";
import { B as U, a3 as m, I as x, C as S, E as L } from "../../../../../../shared/runtime.js";
import { _ as N } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import R from "./summary-detail.vue.js";
import "../../../../../../modules/piecework-system-3800a6fe.js";
import "../../../../../../modules/index-3b2628f3.js";
import "../../../../../../modules/index-490fd9d7.js";
const Y = { __name: "header", setup(j) {
  const f = { date: [s().subtract(1, "month").valueOf(), s().valueOf()], startDate: s().subtract(1, "month").valueOf(), endDate: s().valueOf() }, i = C(false), { crud: l, query: t } = U(f);
  function _() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), l.toQuery();
  }
  return (B, a) => {
    const v = r("project-radio-button"), y = r("common-radio-button"), V = T, b = r("print-table"), g = r("common-button"), p = h("permission");
    return c(), D(O, null, [u(I("div", null, [n(v, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(t).projectId = o), class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), n(y, { modelValue: e(t).productType, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(t).productType = o), options: e(m).ENUM, type: "enumSL", unshowVal: [e(m).ENCLOSURE.V, e(m).AUXILIARY_MATERIAL.V], default: "", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), n(V, { modelValue: e(t).date, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(t).date = o), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: false, shortcuts: e(x), "value-format": "x", onChange: _ }, null, 8, ["modelValue", "shortcuts"]), n(e(N), { modelValue: e(t).factoryId, "onUpdate:modelValue": a[3] || (a[3] = (o) => e(t).factoryId = o), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(S))], 512), [[w, e(l).searchToggle]]), n(e(L), null, { optLeft: d(() => [u(n(b, { "api-key": "mesPiecework", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[p, e(l).permission.print]])]), viewLeft: d(() => {
      var o;
      return [u((c(), k(g, { size: "default", onClick: a[4] || (a[4] = (Q) => i.value = true), type: "success" }, { default: d(() => a[6] || (a[6] = [E("汇总查看")])), _: 1, __: [6] })), [[p, (o = e(l).permission) == null ? void 0 : o.summaryDetail]])];
    }), _: 1 }), n(e(R), { visible: i.value, "onUpdate:visible": a[5] || (a[5] = (o) => i.value = o) }, null, 8, ["visible"])], 64);
  };
} };
export {
  Y as default
};
