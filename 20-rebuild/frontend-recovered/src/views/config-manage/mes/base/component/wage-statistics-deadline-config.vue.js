import { inject as q } from "vue";
import { ref as u } from "vue";
import { computed as p } from "vue";
import { onMounted as L } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as c } from "vue";
import { createBlock as d } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as v } from "vue";
import { createTextVNode as j } from "vue";
import { unref as F } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as z } from "vue";
import { Fragment as K } from "vue";
import { renderList as M } from "vue";
import { withKeys as O } from "vue";
import { withModifiers as Q } from "vue";
import { ElNotification as R } from "element-plus";
import { ElOption as U } from "element-plus";
import { ElSelect as W } from "element-plus";
import { ElFormItem as I } from "element-plus";
import { ElForm as T } from "element-plus";
import { ElCard as $ } from "element-plus";
import { vLoading as A } from "element-plus";
import { P as G, Q as H } from "../../../../../modules/base-6bc46ddf.js";
import { d as J, V as X } from "../../../../../shared/runtime.js";
const Y = { class: "clearfix" }, se = { __name: "wage-statistics-deadline-config", setup(Z) {
  const _ = q("permission"), i = u({ wageStatisticsDeadline: void 0, wageDisplayPrecision: void 0 }), a = u(i.value), n = u(false), r = u(false), w = p(() => (console.log(a.value, i.value), J(a.value, i.value))), y = p(() => n.value || r.value);
  L(() => {
    D();
  });
  const b = { wageStatisticsDeadline: [{ required: true, message: "工价统计截止日", trigger: "change" }], wageDisplayPrecision: [{ required: true, message: "请输入工价金额显示小数精度", trigger: "change" }] };
  async function D() {
    n.value = true;
    try {
      const { wageStatisticsDeadline: t, wageDisplayPrecision: e } = await G();
      a.value = { wageStatisticsDeadline: t, wageDisplayPrecision: e }, i.value = { wageStatisticsDeadline: t, wageDisplayPrecision: e };
    } catch (t) {
      console.log("工价配置", t);
    } finally {
      n.value = false;
    }
  }
  async function S() {
    r.value = true;
    try {
      await H(a.value), R({ title: "工价配置成功", type: "success", duration: 2500 }), i.value = X(a.value);
    } catch (t) {
      console.log("工价配置", t);
    } finally {
      r.value = false;
    }
  }
  return (t, e) => {
    const V = g("common-tip-button"), h = U, E = W, m = I, x = g("common-input-number"), P = T, C = $, k = N("permission"), B = A;
    return c(), d(C, { shadow: "always" }, { header: l(() => [f("div", Y, [e[4] || (e[4] = f("span", { class: "card-title" }, "工价配置", -1)), v((c(), d(V, { loading: r.value, disabled: w.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: S }, { default: l(() => e[3] || (e[3] = [j(" 保存 ")])), _: 1, __: [3] }, 8, ["loading", "disabled"])), [[k, F(_).wageStatisticsDeadlineConfigEdit]])])]), default: l(() => [v((c(), d(P, { model: a.value, rules: b, disabled: y.value, "label-width": "200px" }, { default: l(() => [o(m, { label: "工价统计截止日（每月）：", prop: "wageStatisticsDeadline" }, { default: l(() => [o(E, { modelValue: a.value.wageStatisticsDeadline, "onUpdate:modelValue": e[0] || (e[0] = (s) => a.value.wageStatisticsDeadline = s), placeholder: "请选择日期", style: { width: "140px" }, clearable: true }, { default: l(() => [(c(), z(K, null, M(31, (s) => o(h, { key: s, label: `${s}号`, value: s }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), o(m, { label: "工价金额显示小数精度：", prop: "wageDisplayPrecision" }, { default: l(() => [o(x, { modelValue: a.value.wageDisplayPrecision, "onUpdate:modelValue": e[1] || (e[1] = (s) => a.value.wageDisplayPrecision = s), "controls-position": "right", precision: 0, min: 0, style: { width: "140px" }, onKeydown: e[2] || (e[2] = O(Q(() => {
    }, ["prevent"]), ["enter"])) }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[B, n.value]])]), _: 1 });
  };
} };
export {
  se as default
};
