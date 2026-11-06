import { ref as E } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as m } from "vue";
import { createBlock as k } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as P } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as f } from "vue";
import { createElementBlock as U } from "vue";
import { Fragment as z } from "vue";
import { ElFormItem as N } from "element-plus";
import { ElForm as R } from "element-plus";
import { ao as A, aT as u } from "../../../../../../shared/runtime.js";
const q = { key: 0 }, v = { key: 0 }, I = { __name: "form", setup(B) {
  const b = E(), y = { id: void 0 }, { crud: i, CRUD: x, form: t } = A(y, b), V = (a, o, d) => {
    if (o % 5 !== 0 || o === 0) {
      d(new Error("厚度只能是5的倍数"));
      return;
    }
    d();
  }, h = { measureUnit: [{ required: true, message: "请选择计量方式", trigger: "change" }], thickness: [{ required: true, message: "请填写标准涂装厚度", trigger: "blur" }, { validator: V, trigger: "blur" }], unitPrice: [{ required: true, message: "请填写标准单价", trigger: "blur" }], outThickness: [{ required: true, message: "请填写超标准设定", trigger: "blur" }, { validator: V, trigger: "blur" }], outUnitPrice: [{ required: true, message: "请填写超准单价", trigger: "blur" }] };
  return x.HOOK.beforeSubmit = async (a) => {
    t.measureUnit !== u.AREA.V && (a.form.thickness = void 0, a.form.outThickness = void 0, a.form.outUnitPrice = void 0);
  }, (a, o) => {
    const d = c("common-button"), r = N, C = c("common-select"), p = c("common-input-number"), T = R, w = c("common-dialog");
    return m(), k(w, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(i).cancelCU, visible: e(i).status.cu > 0, title: e(i).status.title, width: "500px" }, { titleRight: n(() => [l(d, { loading: e(i).status.cu === 2, type: "primary", size: "default", onClick: e(i).submitCU }, { default: n(() => o[5] || (o[5] = [P("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: n(() => [l(T, { ref_key: "formRef", ref: b, model: e(t), rules: h, size: "default", "label-width": "130px" }, { default: n(() => [l(r, { label: "油漆类别" }, { default: n(() => [_("span", null, g(e(t).name), 1)]), _: 1 }), l(r, { label: "计量方式", prop: "measureUnit" }, { default: n(() => [l(C, { modelValue: e(t).measureUnit, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(t).measureUnit = s), options: e(u).ENUM, type: "enum", class: "input-underline", size: "default", placeholder: "请选择计量方式", style: { width: "200px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), e(t).measureUnit & e(u).AREA.V ? (m(), k(r, { key: 0, label: "标准涂装厚度", prop: "thickness" }, { default: n(() => [l(p, { modelValue: e(t).thickness, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(t).thickness = s), min: 0, class: "input-underline", max: 9999999, controls: false, step: 5, size: "default", placeholder: "标准涂装厚度", style: { width: "165px" } }, null, 8, ["modelValue"]), o[6] || (o[6] = _("span", null, "um", -1))]), _: 1, __: [6] })) : f("", true), l(r, { label: "标准单价", prop: "unitPrice" }, { default: n(() => [l(p, { modelValue: e(t).unitPrice, "onUpdate:modelValue": o[2] || (o[2] = (s) => e(t).unitPrice = s), min: 0, max: 9999999, controls: false, class: "input-underline", step: 1, size: "default", placeholder: "标准单价", style: { width: "165px" } }, null, 8, ["modelValue"]), e(t).measureUnit ? (m(), U("span", q, "元/" + g(e(u).V[e(t).measureUnit].C_UNIT), 1)) : f("", true)]), _: 1 }), e(t).measureUnit & e(u).AREA.V ? (m(), U(z, { key: 1 }, [l(r, { label: "超标准设定", prop: "outThickness" }, { default: n(() => [l(p, { modelValue: e(t).outThickness, "onUpdate:modelValue": o[3] || (o[3] = (s) => e(t).outThickness = s), min: 0, max: 9999999, controls: false, class: "input-underline", step: 5, size: "default", placeholder: "超标准设定", style: { width: "165px" } }, null, 8, ["modelValue"]), o[7] || (o[7] = _("span", null, "um", -1))]), _: 1, __: [7] }), l(r, { label: "超标单价", prop: "outUnitPrice" }, { default: n(() => [l(p, { modelValue: e(t).outUnitPrice, "onUpdate:modelValue": o[4] || (o[4] = (s) => e(t).outUnitPrice = s), class: "input-underline", min: 0, max: 9999999, controls: false, step: 1, size: "default", placeholder: "超标单价", style: { width: "165px" } }, null, 8, ["modelValue"]), e(t).measureUnit ? (m(), U("span", v, "元/" + g(e(u).V[e(t).measureUnit].C_UNIT), 1)) : f("", true)]), _: 1 })], 64)) : f("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  I as default
};
