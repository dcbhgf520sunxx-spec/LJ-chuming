import { inject as x } from "vue";
import { ref as d } from "vue";
import { computed as _ } from "vue";
import { onMounted as M } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as m } from "vue";
import { createBlock as p } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as b } from "vue";
import { withDirectives as g } from "vue";
import { createTextVNode as s } from "vue";
import { unref as c } from "vue";
import { createVNode as t } from "vue";
import { ElRadioGroup as w } from "element-plus";
import { ElNotification as T } from "element-plus";
import { ElRadio as A } from "element-plus";
import { ElFormItem as B } from "element-plus";
import { ElForm as N } from "element-plus";
import { ElCard as j } from "element-plus";
import { vLoading as L } from "element-plus";
import { h as q, i as z } from "../../../../../modules/base-6bc46ddf.js";
import { d as F, V as U } from "../../../../../shared/runtime.js";
const G = { class: "clearfix" }, Q = { __name: "app-task-report", setup(O) {
  const h = x("permission"), n = d({ boolShowWeightInManufacture: void 0, boolShowWeightInRecord: void 0 }), o = d(n.value), i = d(false), u = d(false), S = _(() => F(o.value, n.value)), y = _(() => i.value || u.value);
  M(() => {
    I();
  });
  async function I() {
    i.value = true;
    try {
      const { boolShowWeightInManufacture: l = false, boolShowWeightInRecord: e = false } = await q();
      o.value = { boolShowWeightInManufacture: l, boolShowWeightInRecord: e }, n.value = { boolShowWeightInManufacture: l, boolShowWeightInRecord: e };
    } catch (l) {
      console.log("获取APP任务上报重量配置", l);
    } finally {
      i.value = false;
    }
  }
  async function R() {
    u.value = true;
    try {
      await z(o.value), T({ title: "APP任务上报重量配置成功", type: "success", duration: 2500 }), n.value = U(o.value);
    } catch (l) {
      console.log("设置APP任务上报重量配置", l);
    } finally {
      u.value = false;
    }
  }
  return (l, e) => {
    const V = C("common-tip-button"), r = A, v = B, W = N, E = j, P = D("permission"), k = L;
    return m(), p(E, { shadow: "always" }, { header: a(() => [b("div", G, [e[3] || (e[3] = b("span", { class: "card-title" }, "APP任务上报重量配置", -1)), g((m(), p(V, { loading: u.value, disabled: S.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: R }, { default: a(() => e[2] || (e[2] = [s(" 保存 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])), [[P, c(h).appTaskReportEdit]])])]), default: a(() => [g((m(), p(W, { model: o.value, disabled: y.value, "label-width": "100px" }, { default: a(() => [t(v, { label: "上报页面", prop: "boolShowWeightInManufacture" }, { default: a(() => [t(c(w), { modelValue: o.value.boolShowWeightInManufacture, "onUpdate:modelValue": e[0] || (e[0] = (f) => o.value.boolShowWeightInManufacture = f) }, { default: a(() => [t(r, { value: true }, { default: a(() => e[4] || (e[4] = [s("显示")])), _: 1, __: [4] }), t(r, { value: false }, { default: a(() => e[5] || (e[5] = [s("不显示")])), _: 1, __: [5] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(v, { label: "上报记录页面", prop: "boolShowWeightInRecord" }, { default: a(() => [t(c(w), { modelValue: o.value.boolShowWeightInRecord, "onUpdate:modelValue": e[1] || (e[1] = (f) => o.value.boolShowWeightInRecord = f) }, { default: a(() => [t(r, { value: true }, { default: a(() => e[6] || (e[6] = [s("显示")])), _: 1, __: [6] }), t(r, { value: false }, { default: a(() => e[7] || (e[7] = [s("不显示")])), _: 1, __: [7] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[k, i.value]])]), _: 1 });
  };
} };
export {
  Q as default
};
