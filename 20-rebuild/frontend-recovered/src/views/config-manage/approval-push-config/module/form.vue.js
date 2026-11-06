import { ref as x } from "vue";
import { resolveComponent as s } from "vue";
import { openBlock as E } from "vue";
import { createBlock as U } from "vue";
import { withCtx as p } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as K } from "vue";
import { ElFormItem as S } from "element-plus";
import { ElInput as w } from "element-plus";
import { ElForm as k } from "element-plus";
import { _ as v, cB as c, ao as q, cA as _ } from "../../../../shared/runtime.js";
const F = { __name: "form", setup(R) {
  const m = x(), f = { id: void 0, appType: void 0, appKey: "", appSecret: "", status: c.TRUE.V, robotCode: "" }, { crud: r, CRUD: u, form: l } = q(f, m), b = { status: [{ required: true, message: "请选择状态", trigger: "change" }], appType: [{ required: true, message: "请选择appType", trigger: "change" }], appKey: [{ required: true, message: "请填写appKey", trigger: "blur" }], appSecret: [{ required: true, message: "请填写appSecret", trigger: "blur" }], robotCode: [{ required: true, message: "请填写机器人code", trigger: "blur" }] };
  return u.HOOK.beforeSubmit = (i) => {
  }, u.HOOK.beforeToEdit = (i) => {
  }, (i, o) => {
    const y = s("common-button"), g = s("common-radio"), d = S, V = s("common-select"), n = w, C = k, T = s("common-dialog");
    return E(), U(T, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, title: e(r).status.title, width: "600px" }, { titleRight: p(() => [t(y, { loading: e(r).status.cu === 2, type: "primary", size: "default", onClick: e(r).submitCU }, { default: p(() => o[5] || (o[5] = [K("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: p(() => [t(C, { ref_key: "formRef", ref: m, model: e(l), rules: b, size: "default", "label-width": "110px", inline: true }, { default: p(() => [t(d, { label: "状态", prop: "status" }, { default: p(() => [t(g, { modelValue: e(l).status, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(l).status = a), options: e(c).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(d, { label: "appType", prop: "appType" }, { default: p(() => [t(V, { modelValue: e(l).appType, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(l).appType = a), options: e(_).ENUM, type: "enum", placeholder: "请选择appType", style: { width: "400px" }, disabledVal: [e(_).WECHAT.V], size: "default", class: "filter-item" }, null, 8, ["modelValue", "options", "disabledVal"])]), _: 1 }), t(d, { label: "appKey", prop: "appKey" }, { default: p(() => [t(n, { modelValue: e(l).appKey, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(l).appKey = a), modelModifiers: { trim: true }, style: { width: "400px" }, placeholder: "请填写appKey" }, null, 8, ["modelValue"])]), _: 1 }), t(d, { label: "appSecret", prop: "appSecret" }, { default: p(() => [t(n, { modelValue: e(l).appSecret, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(l).appSecret = a), modelModifiers: { trim: true }, style: { width: "400px" }, placeholder: "请填写appSecret" }, null, 8, ["modelValue"])]), _: 1 }), t(d, { label: "robotCode", prop: "robotCode" }, { default: p(() => [t(n, { modelValue: e(l).robotCode, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(l).robotCode = a), style: { width: "400px" }, placeholder: "请填写机器人code" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, M = v(F, [["__scopeId", "data-v-5bedf621"]]);
export {
  M as default
};
