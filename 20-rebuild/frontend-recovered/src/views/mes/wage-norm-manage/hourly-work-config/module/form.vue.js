import { ref as U } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as s } from "vue";
import { createBlock as i } from "vue";
import { withCtx as l } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as _ } from "vue";
import { createElementBlock as h } from "vue";
import { Fragment as v } from "vue";
import { renderList as N } from "vue";
import { toDisplayString as T } from "vue";
import { createCommentVNode as w } from "vue";
import { ElInput as F } from "element-plus";
import { ElFormItem as L } from "element-plus";
import { ElRadio as A } from "element-plus";
import { ElRadioGroup as B } from "element-plus";
import { ElInputNumber as q } from "element-plus";
import { ElForm as z } from "element-plus";
import { sd as m, ao as I } from "../../../../../shared/runtime.js";
const P = { __name: "form", setup(O) {
  const p = U(), f = { name: void 0, type: m.HOURLY_RATE.V, price: void 0 }, { crud: r, form: o } = I(f, p), g = { name: [{ required: true, message: "请输入点工类型", trigger: "blur" }], type: [{ required: true, message: "请选择类型", trigger: "change" }], price: [{ required: true, message: "请输入单价", trigger: "change" }] };
  function b(d) {
    d === m.APPROVAL_ENTRY.V && (o.price = null);
  }
  return (d, a) => {
    const y = c("common-button"), V = F, u = L, E = A, R = B, k = q, C = z, x = c("common-dialog");
    return s(), i(x, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, title: e(r).status.title, width: "550px" }, { titleRight: l(() => [n(y, { loading: e(r).status.cu === 2, type: "primary", size: "default", onClick: e(r).submitCU }, { default: l(() => a[3] || (a[3] = [_("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: l(() => [n(C, { ref_key: "formRef", ref: p, model: e(o), rules: g, size: "default", "label-width": "170px" }, { default: l(() => [n(u, { label: "点工类型：", prop: "name" }, { default: l(() => [n(V, { modelValue: e(o).name, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(o).name = t), clearable: "", placeholder: "输入点工类型", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), n(u, { label: "类型：", prop: "type" }, { default: l(() => [n(R, { modelValue: e(o).type, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(o).type = t), onChange: b }, { default: l(() => [(s(true), h(v, null, N(e(m).ENUM, (t) => (s(), i(E, { key: t.V, value: t.V }, { default: l(() => [_(T(t.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), e(o).type === e(m).HOURLY_RATE.V ? (s(), i(u, { key: 0, label: "工时单价（元/小时）：", prop: "price" }, { default: l(() => [n(k, { modelValue: e(o).price, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(o).price = t), placeholder: "录入金额", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })) : w("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  P as default
};
