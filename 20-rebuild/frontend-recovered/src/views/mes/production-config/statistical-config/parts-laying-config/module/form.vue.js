import { ref as c } from "vue";
import { computed as N } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as P } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as U } from "vue";
import { ElFormItem as E } from "element-plus";
import { ElForm as T } from "element-plus";
import { t as z, ao as h, av as q, aT as I } from "../../../../../../shared/runtime.js";
import { _ as Q } from "../../../../../../modules/cut-config-select-6e1b2706.js";
const D = { __name: "form", setup(k) {
  const { decimalPrecision: f } = z(), d = c(), g = { id: void 0 }, { crud: n, form: l } = h(g, d), _ = N(() => n.status.edit > 0), b = { specPrefix: [{ required: true, message: "请选择截面类型", trigger: "change" }], cutConfigId: [{ required: true, message: "请选择下料方式", trigger: "change" }], wageQuotaType: [{ required: true, message: "请选择计量方式", trigger: "change" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], numerical: [{ required: true, validator: (y, o, i) => {
    !l.minNumerical || !l.maxNumerical ? i(new Error("请填写数值")) : l.maxNumerical < l.minNumerical && i(new Error("最大数值不得小于最小数值")), i();
  }, message: "请填写数值", trigger: "blur" }] }, V = c([q.PL]);
  return (y, o) => {
    const i = u("common-button"), p = u("common-select"), s = E, m = u("common-input-number"), w = T, x = u("common-dialog");
    return P(), v(x, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "500px" }, { titleRight: r(() => [t(i, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: r(() => o[6] || (o[6] = [C("确认")])), _: 1, __: [6] }, 8, ["loading", "onClick"])]), default: r(() => [t(w, { ref_key: "formRef", ref: d, model: e(l), rules: b, size: "default", "label-width": "120px", "label-position": "right" }, { default: r(() => [t(s, { label: "截面类型", prop: "specPrefix" }, { default: r(() => [t(p, { modelValue: e(l).specPrefix, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(l).specPrefix = a), options: V.value, clearable: "", type: "enum", disabled: _.value, placeholder: "截面类型", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), t(s, { label: "下料方式", prop: "cutConfigId" }, { default: r(() => [t(Q, { placeholder: "下料方式", modelValue: e(l).cutConfigId, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(l).cutConfigId = a), clearable: "", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue"])]), _: 1 }), t(s, { label: "板厚范围", prop: "numerical" }, { default: r(() => [t(m, { modelValue: e(l).minNumerical, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(l).minNumerical = a), step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue"]), o[7] || (o[7] = U("span", null, " ~ ", -1)), t(m, { modelValue: e(l).maxNumerical, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(l).maxNumerical = a), step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue"])]), _: 1, __: [7] }), t(s, { label: "计量方式", prop: "wageQuotaType" }, { default: r(() => [t(p, { modelValue: e(l).wageQuotaType, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(l).wageQuotaType = a), options: e(I).ENUM, clearable: "", type: "enum", placeholder: "计量方式", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(s, { label: "单价", prop: "unitPrice" }, { default: r(() => [t(m, { modelValue: e(l).unitPrice, "onUpdate:modelValue": o[5] || (o[5] = (a) => e(l).unitPrice = a), step: 1, min: 0, precision: e(f).mes, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  D as default
};
