import { inject as j } from "vue";
import { ref as c } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as v } from "vue";
import { createBlock as I } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as u } from "vue";
import { unref as n } from "vue";
import { ElRadioGroup as N } from "element-plus";
import { createElementBlock as T } from "vue";
import { createCommentVNode as w } from "vue";
import { isRef as C } from "vue";
import { ElRadio as R } from "element-plus";
import { u as E } from "../../../../../shared/runtime.js";
import { _ as U } from "../../../../../modules/index-828ab502.js";
const L = { key: 0, style: { "margin-top": "15px" } }, S = { __name: "index", props: { visible: { type: Boolean, default: false }, packLoading: { type: Boolean, default: false }, packType: { type: Number, default: void 0 } }, emits: ["update:visible", "handlePack"], setup(d, { expose: _, emit: V }) {
  const m = V, b = d, k = j("projectId"), a = c(true), s = c(), { visible: i, handleClose: p } = E({ emit: m, props: b, field: "visible" });
  function g() {
    a.value = true, s.value = void 0, p();
  }
  function y() {
    m("handlePack", { isNew: a.value, selectBagId: s.value });
  }
  return _({ handleSuccess: g }), (P, e) => {
    const x = f("common-button"), r = R, B = f("common-dialog");
    return v(), I(B, { title: "选择新增类型", modelValue: n(i), "onUpdate:modelValue": e[2] || (e[2] = (l) => C(i) ? i.value = l : null), "before-close": n(p), width: "450px" }, { titleRight: o(() => [t(x, { loading: d.packLoading, type: "primary", size: "default", onClick: y }, { default: o(() => e[3] || (e[3] = [u("确 定")])), _: 1, __: [3] }, 8, ["loading"])]), default: o(() => [t(n(N), { modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => a.value = l) }, { default: o(() => [t(r, { value: true }, { default: o(() => e[4] || (e[4] = [u("生成新包单")])), _: 1, __: [4] }), t(r, { value: false }, { default: o(() => e[5] || (e[5] = [u("使用原有包单")])), _: 1, __: [5] })]), _: 1 }, 8, ["modelValue"]), a.value ? w("", true) : (v(), T("div", L, [t(n(U), { modelValue: s.value, "onUpdate:modelValue": e[1] || (e[1] = (l) => s.value = l), "project-id": n(k), packType: d.packType, style: { width: "100%" } }, null, 8, ["modelValue", "project-id", "packType"])]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  S as default
};
