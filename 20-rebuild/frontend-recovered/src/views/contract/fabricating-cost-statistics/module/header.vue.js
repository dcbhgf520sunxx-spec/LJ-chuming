import { ref as m } from "vue";
import { computed as S } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as v } from "vue";
import { ElDatePicker as R } from "element-plus";
import { ElCol as U } from "element-plus";
import { ElRow as B } from "element-plus";
import { vLoading as z } from "element-plus";
import { _ as M, jo as h, B as H, c1 as y, C as q } from "../../../../shared/runtime.js";
import { D as A, E as K } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { P as p } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const $ = { class: "head-container" }, F = { class: "flex" }, G = { __name: "header", setup(J) {
  const i = m([]), V = { year: void 0, status: void 0, boolTaxIncluded: h.YES.V, projectId: void 0 }, E = S(() => {
    var o;
    return (o = i == null ? void 0 : i.value) == null ? void 0 : o.map((s) => (s.serialNumberName = s.serialNumber + " " + s.shortName, s));
  }), r = m(), f = m(false), { crud: c, CRUD: w, query: l } = H(V), T = m([y.PROCESS, y.COMPLETE, y.SETTLED]);
  function N() {
    c.toQuery(), g();
  }
  async function g() {
    try {
      const n = await A({ status: l.status });
      i.value = n;
    } catch (n) {
      console.log(n);
    }
  }
  g();
  async function Y() {
    f.value = true;
    try {
      const n = await K(l);
      r.value = n || {};
    } catch (n) {
      console.log(n);
    } finally {
      f.value = false;
    }
  }
  return w.HOOK.beforeToQuery = () => {
    Y();
  }, (n, o) => {
    const s = R, b = _("common-radio-button"), d = U, L = B, P = _("common-select-v2"), k = _("print-table"), D = z, I = j("permission");
    return C(), O("div", $, [t(s, { modelValue: a(l).year, "onUpdate:modelValue": o[0] || (o[0] = (e) => a(l).year = e), class: "date-item filter-item", format: "YYYY", placeholder: "选择年", size: "default", style: { width: "100px !important" }, type: "year", "value-format": "YYYY", onChange: a(c).toQuery }, null, 8, ["modelValue", "onChange"]), t(b, { modelValue: a(l).status, "onUpdate:modelValue": o[1] || (o[1] = (e) => a(l).status = e), options: T.value, class: "filter-item", showOptionAll: "", type: "enum", onChange: N }, null, 8, ["modelValue", "options"]), t(b, { modelValue: a(l).boolTaxIncluded, "onUpdate:modelValue": o[2] || (o[2] = (e) => a(l).boolTaxIncluded = e), options: a(h).ENUM, class: "filter-item", type: "enumSL", onChange: a(c).toQuery }, null, 8, ["modelValue", "options", "onChange"]), x((C(), Q(L, { gutter: 20, class: "panel-group" }, { default: u(() => [t(d, { span: 6, class: "card-panel-col" }, { default: u(() => {
      var e;
      return [t(a(p), { "end-val": ((e = r.value) == null ? void 0 : e.contractRevenue) || 0, precision: 2, name: "合同收入", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])];
    }), _: 1 }), t(d, { span: 6, class: "card-panel-col" }, { default: u(() => {
      var e;
      return [t(a(p), { "end-val": ((e = r.value) == null ? void 0 : e.accumulatedCost) || 0, precision: 2, name: "累计成本", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])];
    }), _: 1 }), t(d, { span: 6, class: "card-panel-col" }, { default: u(() => {
      var e;
      return [t(a(p), { "end-val": ((e = r.value) == null ? void 0 : e.realizeProfits) || 0, precision: 2, name: "实现利润", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])];
    }), _: 1 }), t(d, { span: 6, class: "card-panel-col" }, { default: u(() => {
      var e;
      return [t(a(p), { "end-val": ((e = r.value) == null ? void 0 : e.realizeProfitsRate) * 100 || 0, precision: 2, name: "实现利润率", "num-color": "#1890ff", suffix: "%", "text-color": "#626262" }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 })), [[D, f.value]]), v("div", F, [v("div", null, [t(P, { modelValue: a(l).projectId, "onUpdate:modelValue": o[3] || (o[3] = (e) => a(l).projectId = e), "data-structure": { key: "id", label: "serialNumberName", value: "id" }, options: E.value, class: "filter-item", clearable: "", filterable: "", placeholder: "可选择项目搜索", style: { width: "340px" }, type: "other", onChange: a(c).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(a(q))]), x(t(k, { params: a(l), "api-key": "fabricatingCostStatistics", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"]), [[I, a(c).permission.print]])]), o[4] || (o[4] = v("span", { class: "tips" }, "*当前页面不包含当天数据，可通过下载获取最新数据。", -1))]);
  };
} }, te = M(G, [["__scopeId", "data-v-26c9e7b7"]]);
export {
  te as default
};
