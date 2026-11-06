import { inject as I } from "vue";
import { ref as _ } from "vue";
import { computed as N } from "vue";
import { onMounted as D } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as S } from "vue";
import { withDirectives as u } from "vue";
import { vShow as k } from "vue";
import { unref as t } from "vue";
import { createElementVNode as B } from "vue";
import { createVNode as s } from "vue";
import { withKeys as Q } from "vue";
import { withCtx as a } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as d } from "vue";
import { ElDatePicker as z } from "element-plus";
import { ElInput as L } from "element-plus";
import { B as O, C as U, L as V, wY as K, E as P, wX as $ } from "../../../../../../shared/runtime.js";
import { g as j, a as M } from "../../../../../../modules/supplier-evaluation-config-2fb6916b.js";
const T = { class: "head-container" }, J = { __name: "header", emits: ["open-evaluate"], setup(F, { emit: Y }) {
  const C = Y, q = { evaluateYear: String((/* @__PURE__ */ new Date()).getFullYear()), classifyId: void 0, supplierName: void 0, scoreRating: void 0 }, { crud: o } = O(q), m = I("permission"), f = _([]), y = _([]), A = N(() => ({ evaluateYear: o.query.evaluateYear || void 0, classifyId: o.query.classifyId || void 0, supplierName: o.query.supplierName || void 0, scoreRating: o.query.scoreRating || void 0 }));
  D(() => {
    h();
  });
  async function h() {
    try {
      const [e, r] = await Promise.allSettled([j(), M()]);
      e.status === "fulfilled" && (f.value = g(e.value)), r.status === "fulfilled" && (y.value = g(r.value).map((l) => ({ id: l.name || l.id, name: l.name || "" })));
    } catch (e) {
      console.log("供应商评价管理-查询选项读取", e);
    }
  }
  function x(e = {}) {
    return $(e.evaluateId);
  }
  function g(e) {
    var r;
    return Array.isArray(e) ? e : Array.isArray(e == null ? void 0 : e.content) ? e.content : Array.isArray((r = e == null ? void 0 : e.data) == null ? void 0 : r.content) ? e.data.content : Array.isArray(e == null ? void 0 : e.records) ? e.records : Array.isArray(e == null ? void 0 : e.list) ? e.list : Array.isArray(e == null ? void 0 : e.data) ? e.data : [];
  }
  return (e, r) => {
    const l = z, v = w("common-select"), R = L, b = w("common-button"), p = E("permission");
    return i(), S("div", T, [u(B("div", null, [s(l, { modelValue: t(o).query.evaluateYear, "onUpdate:modelValue": r[0] || (r[0] = (n) => t(o).query.evaluateYear = n), class: "filter-item", format: "YYYY", placeholder: "选择年份", size: "default", style: { width: "120px" }, type: "year", "value-format": "YYYY", onChange: t(o).toQuery }, null, 8, ["modelValue", "onChange"]), s(v, { modelValue: t(o).query.classifyId, "onUpdate:modelValue": r[1] || (r[1] = (n) => t(o).query.classifyId = n), options: f.value, class: "filter-item", clearable: "", placeholder: "评价分类选择", style: { width: "220px" }, onChange: t(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(R, { modelValue: t(o).query.supplierName, "onUpdate:modelValue": r[2] || (r[2] = (n) => t(o).query.supplierName = n), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按供应商名称/简称搜索", size: "default", style: { width: "220px" }, onKeyup: Q(t(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(v, { modelValue: t(o).query.scoreRating, "onUpdate:modelValue": r[3] || (r[3] = (n) => t(o).query.scoreRating = n), options: y.value, class: "filter-item", clearable: "", placeholder: "评级选择", style: { width: "220px" }, onChange: t(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(t(U))], 512), [[k, t(o).searchToggle]]), s(t(P), { "show-grid": false }, { optLeft: a(() => [u((i(), c(b, { class: "filter-item", size: "default", type: "success", onClick: r[4] || (r[4] = (n) => C("open-evaluate")) }, { default: a(() => r[5] || (r[5] = [d(" 评价 ")])), _: 1, __: [5] })), [[p, t(m).add]])]), viewLeft: a(() => {
      var n;
      return [u((i(), c(V, { fn: t(K), params: A.value, class: "filter-item" }, { default: a(() => r[6] || (r[6] = [d(" 供应商评价汇总记录下载 ")])), _: 1, __: [6] }, 8, ["fn", "params"])), [[p, t(m).download]]), u((i(), c(V, { disabled: t(o).selections.length !== 1, fn: x, params: { evaluateId: (n = t(o).selections[0]) == null ? void 0 : n.id }, class: "filter-item" }, { default: a(() => r[7] || (r[7] = [d(" 供应商评价记录详情下载 ")])), _: 1, __: [7] }, 8, ["disabled", "params"])), [[p, t(m).exportDetail]])];
    }), _: 1 })]);
  };
} };
export {
  J as default
};
