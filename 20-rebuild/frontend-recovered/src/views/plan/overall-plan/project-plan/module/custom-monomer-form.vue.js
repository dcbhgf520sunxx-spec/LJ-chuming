import { ref as R } from "vue";
import { reactive as h } from "vue";
import { computed as B } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as C } from "vue";
import { createBlock as F } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as z } from "vue";
import { withKeys as E } from "vue";
import { unref as b } from "vue";
import { isRef as I } from "vue";
import { ElInput as N } from "element-plus";
import { ElFormItem as U } from "element-plus";
import { ElForm as j } from "element-plus";
import { u as K, i as q } from "../../../../../shared/runtime.js";
const T = { __name: "custom-monomer-form", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => ({}) } }, emits: ["update:visible", "add", "edit"], setup(g, { emit: k }) {
  const m = k, n = g, s = R(), e = h({ id: void 0, name: void 0, remark: void 0 }), { visible: r, handleClose: d } = K({ emit: m, props: n, field: "visible", showHook: V }), v = { name: [{ required: true, message: "请输入单体名称", trigger: "blur" }, { max: 64, message: "单体名称最多64个字符", trigger: "blur" }] }, i = B(() => q(n.info));
  function V() {
    i.value && (e.name = n.info.name, e.remark = n.info.remark);
  }
  function u() {
    s.value.validate((f) => {
      f && (i.value ? m("edit", e) : m("add", e), console.log("form", e), d(), s.value.resetFields());
    });
  }
  return (f, o) => {
    const x = _("common-button"), p = N, c = U, w = j, y = _("common-dialog");
    return C(), F(y, { "append-to-body": "", "close-on-click-modal": false, title: i.value ? "编辑单体" : "创建单体", modelValue: b(r), "onUpdate:modelValue": o[2] || (o[2] = (a) => I(r) ? r.value = a : null), width: "400px", "before-close": b(d) }, { titleRight: l(() => [t(x, { type: "primary", onClick: u, size: "mini" }, { default: l(() => o[3] || (o[3] = [z(" 确认 ")])), _: 1, __: [3] })]), default: l(() => [t(w, { ref_key: "formRef", ref: s, model: e, rules: v, size: "small", "label-width": "80px" }, { default: l(() => [t(c, { label: "单体名称", prop: "name" }, { default: l(() => [t(p, { modelValue: e.name, "onUpdate:modelValue": o[0] || (o[0] = (a) => e.name = a), modelModifiers: { trim: true }, placeholder: "请输入单体名称", onKeyup: E(u, ["enter"]) }, null, 8, ["modelValue"])]), _: 1 }), t(c, { label: "备注", prop: "remark" }, { default: l(() => [t(p, { modelValue: e.remark, "onUpdate:modelValue": o[1] || (o[1] = (a) => e.remark = a), type: "textarea", maxlength: 200, "show-word-limit": "", autosize: { minRows: 4, maxRows: 6 }, placeholder: "请填写备注" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  T as default
};
