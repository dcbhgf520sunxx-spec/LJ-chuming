import { ref as m } from "vue";
import { watch as I } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as x } from "vue";
import { createBlock as R } from "vue";
import { withCtx as t } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as z } from "vue";
import { unref as n } from "vue";
import { isRef as B } from "vue";
import { nextTick as C } from "vue";
import { ElFormItem as E } from "element-plus";
import { ElForm as N } from "element-plus";
import { h as U } from "../../../../../modules/cloud-cutting-assistant-43dc84e4.js";
import { u as q, qw as P } from "../../../../../shared/runtime.js";
import S from "../component/drawing-upload-btn.vue.js";
import "../../../../../modules/index-ce9deea8.js";
const H = { __name: "task-import-form", props: { visible: { type: Boolean, default: false }, orderId: { type: Number } }, emits: ["update:visible", "success"], setup(b, { emit: y }) {
  const p = y, r = b, { visible: i, handleClose: c } = q({ emit: p, props: r, field: "visible" }), f = m(), o = m({}), _ = m();
  I(() => r.visible, (u) => {
    u && (o.value.orderId = r.orderId);
  }, { immediate: true });
  function g() {
    return { cloudcutId: o.value.orderId, partType: o.value.partType };
  }
  const w = { partType: [{ required: true, message: "请选择零件类型", trigger: "change" }] };
  async function V() {
    await f.value.validate() && C(async () => {
      var e, s;
      await ((s = (e = _.value) == null ? void 0 : e.uploadRef) == null ? void 0 : s.submit());
    });
  }
  function T() {
    c(), p("success");
  }
  return (u, e) => {
    const s = d("common-button"), h = d("common-select"), v = E, k = N, F = d("common-dialog");
    return x(), R(F, { title: "文件导入", modelValue: n(i), "onUpdate:modelValue": e[2] || (e[2] = (l) => B(i) ? i.value = l : null), "close-on-click-modal": false, width: "500px", "before-close": n(c) }, { titleRight: t(() => [a(s, { size: "default", type: "primary", onClick: V }, { default: t(() => e[3] || (e[3] = [z("确认")])), _: 1, __: [3] })]), default: t(() => [a(k, { "label-width": "90px", ref_key: "formRef", ref: f, model: o.value, "label-position": "left", rules: w }, { default: t(() => [a(v, { label: "零件类型", prop: "partType" }, { default: t(() => [a(h, { modelValue: o.value.partType, "onUpdate:modelValue": e[0] || (e[0] = (l) => o.value.partType = l), options: n(P).ENUM, type: "enum", placeholder: "选择零件类型", style: { width: "100%" }, size: "large" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(v, { label: "文件导入", prop: "attachmentFile" }, { default: t(() => [a(S, { ref_key: "uploadRef", ref: _, files: o.value.attachmentFile, "onUpdate:files": e[1] || (e[1] = (l) => o.value.attachmentFile = l), accept: ".zip", data: g(), uploadFun: n(U), size: "default", "auto-upload": false, onSuccess: T }, null, 8, ["files", "data", "uploadFun"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  H as default
};
