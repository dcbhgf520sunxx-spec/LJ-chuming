import { ref as b } from "vue";
import { computed as g } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as y } from "vue";
import { createBlock as x } from "vue";
import { withCtx as d } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as V } from "vue";
import { ElInput as k } from "element-plus";
import { ElFormItem as w } from "element-plus";
import { ElForm as C } from "element-plus";
import { ao as T } from "../../../../../shared/runtime.js";
const F = { __name: "form", setup(h) {
  const s = b(), m = { id: void 0, processId: void 0, leaderId: void 0, workshopId: void 0, organizationType: void 0, unit: "小时" }, { crud: r, form: l } = T(m, s);
  g(() => r.status.edit >= 1);
  const p = { oddJobType: [{ required: true, message: "请输入零工类型", trigger: "blur" }], price: [{ required: true, message: "请输入单价", trigger: "blur" }] };
  return (I, o) => {
    const f = u("common-button"), a = k, i = w, c = C, _ = u("common-dialog");
    return y(), x(_, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, title: e(r).status.title, width: "550px" }, { titleRight: d(() => [t(f, { loading: e(r).status.cu === 2, type: "primary", size: "default", onClick: e(r).submitCU }, { default: d(() => o[3] || (o[3] = [V("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: d(() => [t(c, { ref_key: "formRef", ref: s, model: e(l), rules: p, size: "default", "label-width": "100px" }, { default: d(() => [t(i, { label: "零工类型", prop: "oddJobType" }, { default: d(() => [t(a, { modelValue: e(l).oddJobType, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(l).oddJobType = n), modelModifiers: { trim: true }, maxlength: "20", type: "text", placeholder: "输入零工类型", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(i, { label: "计算单位", prop: "trim" }, { default: d(() => [t(a, { modelValue: e(l).unit, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(l).unit = n), modelModifiers: { trim: true }, disabled: "", type: "text", placeholder: "请输入计算单位", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(i, { label: "单价（元）", prop: "price" }, { default: d(() => [t(a, { modelValue: e(l).price, "onUpdate:modelValue": o[2] || (o[2] = (n) => e(l).price = n), modelModifiers: { number: true }, type: "number", placeholder: "请输入单价", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  F as default
};
