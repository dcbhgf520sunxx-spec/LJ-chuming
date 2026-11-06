import { ref as y } from "vue";
import { computed as w } from "vue";
import { resolveComponent as s } from "vue";
import { openBlock as N } from "vue";
import { createBlock as x } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as U } from "vue";
import { ElFormItem as v } from "element-plus";
import { ElForm as E } from "element-plus";
import { ao as P, av as T, aT as z } from "../../../../../../shared/runtime.js";
import { _ as h } from "../../../../../../modules/bridge-cut-config-select-0a6713ab.js";
const F = { __name: "form", setup(q) {
  const d = y(), c = { id: void 0 }, { crud: n, form: l } = P(c, d), f = w(() => n.status.edit > 0), g = { specPrefix: [{ required: true, message: "请选择截面类型", trigger: "change" }], cutConfigId: [{ required: true, message: "请选择下料方式", trigger: "change" }], wageQuotaType: [{ required: true, message: "请选择计量方式", trigger: "change" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], numerical: [{ required: true, validator: (_, o, i) => {
    !l.minNumerical || !l.maxNumerical ? i(new Error("请填写数值")) : l.maxNumerical < l.minNumerical && i(new Error("最大数值不得小于最小数值")), i();
  }, message: "请填写数值", trigger: "blur" }] };
  return (_, o) => {
    const i = s("common-button"), p = s("common-select"), u = v, m = s("common-input-number"), b = E, V = s("common-dialog");
    return N(), x(V, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "500px" }, { titleRight: r(() => [t(i, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: r(() => o[6] || (o[6] = [C("确认")])), _: 1, __: [6] }, 8, ["loading", "onClick"])]), default: r(() => [t(b, { ref_key: "formRef", ref: d, model: e(l), rules: g, size: "default", "label-width": "120px", "label-position": "right" }, { default: r(() => [t(u, { label: "截面类型", prop: "specPrefix" }, { default: r(() => [t(p, { modelValue: e(l).specPrefix, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(l).specPrefix = a), options: e(T).ENUM, clearable: "", type: "enum", disabled: f.value, placeholder: "截面类型", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), t(u, { label: "下料方式", prop: "cutConfigId" }, { default: r(() => [t(h, { placeholder: "下料方式", modelValue: e(l).cutConfigId, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(l).cutConfigId = a), clearable: "", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue"])]), _: 1 }), t(u, { label: "板厚范围", prop: "numerical" }, { default: r(() => [t(m, { modelValue: e(l).minNumerical, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(l).minNumerical = a), step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue"]), o[7] || (o[7] = U("span", null, " ~ ", -1)), t(m, { modelValue: e(l).maxNumerical, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(l).maxNumerical = a), step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue"])]), _: 1, __: [7] }), t(u, { label: "计量方式", prop: "wageQuotaType" }, { default: r(() => [t(p, { modelValue: e(l).wageQuotaType, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(l).wageQuotaType = a), options: e(z).ENUM, clearable: "", type: "enum", placeholder: "计量方式", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(u, { label: "单价", prop: "unitPrice" }, { default: r(() => [t(m, { modelValue: e(l).unitPrice, "onUpdate:modelValue": o[5] || (o[5] = (a) => e(l).unitPrice = a), step: 1, min: 0, precision: 2, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  F as default
};
