import { ref as T } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as u } from "vue";
import { createBlock as V } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as z } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as c } from "vue";
import { createElementBlock as g } from "vue";
import { Fragment as E } from "vue";
import { ElFormItem as P } from "element-plus";
import { ElForm as N } from "element-plus";
import { ao as q, aT as i } from "../../../../../../shared/runtime.js";
const v = { key: 0 }, B = { key: 0 }, I = { __name: "form", setup(F) {
  const U = T(), k = { id: void 0 }, { crud: a, form: l } = q(k, U), b = (x, t, m) => {
    if (t % 5 !== 0 || t === 0) {
      m(new Error("厚度只能是5的倍数"));
      return;
    }
    m();
  }, y = { measureUnit: [{ required: true, message: "请选择计量方式", trigger: "change" }], thickness: [{ required: true, message: "请填写标准涂装厚度", trigger: "blur" }, { validator: b, trigger: "blur" }], unitPrice: [{ required: true, message: "请填写标准单价", trigger: "blur" }], outThickness: [{ required: true, message: "请填写超标准设定", trigger: "blur" }, { validator: b, trigger: "blur" }], outUnitPrice: [{ required: true, message: "请填写超准单价", trigger: "blur" }] };
  return (x, t) => {
    const m = p("common-button"), r = P, h = p("common-select"), d = p("common-input-number"), w = N, C = p("common-dialog");
    return u(), V(C, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: e(a).status.cu > 0, title: e(a).status.title, width: "500px" }, { titleRight: n(() => [o(m, { loading: e(a).status.cu === 2, type: "primary", size: "default", onClick: e(a).submitCU }, { default: n(() => t[5] || (t[5] = [z("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: n(() => [o(w, { ref_key: "formRef", ref: U, model: e(l), rules: y, size: "default", "label-width": "130px" }, { default: n(() => [o(r, { label: "油漆类别" }, { default: n(() => [f("span", null, _(e(l).name), 1)]), _: 1 }), o(r, { label: "计量方式", prop: "measureUnit" }, { default: n(() => [o(h, { modelValue: e(l).measureUnit, "onUpdate:modelValue": t[0] || (t[0] = (s) => e(l).measureUnit = s), options: e(i).ENUM, type: "enum", class: "input-underline", size: "default", placeholder: "请选择计量方式", style: { width: "200px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), e(l).measureUnit & e(i).AREA.V ? (u(), V(r, { key: 0, label: "标准涂装厚度", prop: "thickness" }, { default: n(() => [o(d, { modelValue: e(l).thickness, "onUpdate:modelValue": t[1] || (t[1] = (s) => e(l).thickness = s), min: 0, class: "input-underline", max: 9999999, controls: false, step: 5, size: "default", placeholder: "标准涂装厚度", style: { width: "165px" } }, null, 8, ["modelValue"]), t[6] || (t[6] = f("span", null, "um", -1))]), _: 1, __: [6] })) : c("", true), o(r, { label: "标准单价", prop: "unitPrice" }, { default: n(() => [o(d, { modelValue: e(l).unitPrice, "onUpdate:modelValue": t[2] || (t[2] = (s) => e(l).unitPrice = s), min: 0, max: 9999999, controls: false, class: "input-underline", step: 1, size: "default", placeholder: "标准单价", style: { width: "165px" } }, null, 8, ["modelValue"]), e(l).measureUnit ? (u(), g("span", v, "元/" + _(e(i).V[e(l).measureUnit].C_UNIT), 1)) : c("", true)]), _: 1 }), e(l).measureUnit & e(i).AREA.V ? (u(), g(E, { key: 1 }, [o(r, { label: "超标准设定", prop: "outThickness" }, { default: n(() => [o(d, { modelValue: e(l).outThickness, "onUpdate:modelValue": t[3] || (t[3] = (s) => e(l).outThickness = s), min: 0, max: 9999999, controls: false, class: "input-underline", step: 5, size: "default", placeholder: "超标准设定", style: { width: "165px" } }, null, 8, ["modelValue"]), t[7] || (t[7] = f("span", null, "um", -1))]), _: 1, __: [7] }), o(r, { label: "超标单价", prop: "outUnitPrice" }, { default: n(() => [o(d, { modelValue: e(l).outUnitPrice, "onUpdate:modelValue": t[4] || (t[4] = (s) => e(l).outUnitPrice = s), class: "input-underline", min: 0, max: 9999999, controls: false, step: 1, size: "default", placeholder: "超标单价", style: { width: "165px" } }, null, 8, ["modelValue"]), e(l).measureUnit ? (u(), g("span", B, "元/" + _(e(i).V[e(l).measureUnit].C_UNIT), 1)) : c("", true)]), _: 1 })], 64)) : c("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  I as default
};
