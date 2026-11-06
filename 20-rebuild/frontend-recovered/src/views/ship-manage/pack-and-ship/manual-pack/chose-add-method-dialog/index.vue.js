import { inject as z } from "vue";
import { ref as f } from "vue";
import { reactive as g } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as c } from "vue";
import { createBlock as V } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as i } from "vue";
import { unref as n } from "vue";
import { ElRadioGroup as P } from "element-plus";
import { createCommentVNode as k } from "vue";
import { createElementBlock as L } from "vue";
import { isRef as q } from "vue";
import { ElRadio as D } from "element-plus";
import { ElInput as G } from "element-plus";
import { ElFormItem as S } from "element-plus";
import { ElForm as $ } from "element-plus";
import { u as A } from "../../../../../shared/runtime.js";
import { _ as H } from "../../../../../modules/index-828ab502.js";
const J = { key: 1, style: { "margin-top": "15px" } }, Q = { __name: "index", props: { visible: { type: Boolean, default: false }, packLoading: { type: Boolean, default: false }, packType: { type: Number, default: void 0 }, typeVal: { type: Number } }, emits: ["update:visible", "handlePack"], setup(r, { expose: N, emit: x }) {
  const d = x, w = r, B = z("projectId"), a = f(2), v = f(), s = f(), u = g({ serialNumber: "" }), { visible: m, handleClose: b } = A({ emit: d, props: w, field: "visible" }), I = g({ serialNumber: [{ required: true, message: "请输入包单", trigger: "blur" }, { min: 2, max: 10, message: "长度为2~10个字符", trigger: "blur" }] });
  function j() {
    a.value = true, s.value = void 0, b();
  }
  async function E() {
    a.value === 1 ? await v.value.validate((_, e) => {
      _ ? d("handlePack", { isNew: a.value, selectBagId: s.value, ...u }) : console.log("error submit!", e);
    }) : d("handlePack", { isNew: a.value, selectBagId: s.value, ...u });
  }
  return N({ handleSuccess: j }), (_, e) => {
    const R = y("common-button"), p = D, T = G, C = S, F = $, U = y("common-dialog");
    return c(), V(U, { title: "选择新增类型", modelValue: n(m), "onUpdate:modelValue": e[3] || (e[3] = (t) => q(m) ? m.value = t : null), "before-close": n(b), width: "550px" }, { titleRight: l(() => [o(R, { loading: r.packLoading, type: "primary", size: "default", onClick: E }, { default: l(() => e[4] || (e[4] = [i("确 定")])), _: 1, __: [4] }, 8, ["loading"])]), default: l(() => [o(n(P), { modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => a.value = t) }, { default: l(() => [o(p, { value: 2 }, { default: l(() => e[5] || (e[5] = [i("自动生成新包单")])), _: 1, __: [5] }), o(p, { value: 1 }, { default: l(() => e[6] || (e[6] = [i("手动输入新包单")])), _: 1, __: [6] }), o(p, { value: 0 }, { default: l(() => e[7] || (e[7] = [i("使用原有包单")])), _: 1, __: [7] })]), _: 1 }, 8, ["modelValue"]), a.value === 1 ? (c(), V(F, { key: 0, ref_key: "ruleFormRef", ref: v, style: { "max-width": "300px", "margin-top": "10px" }, model: u, rules: I, "label-width": "auto", size: "default" }, { default: l(() => [o(C, { label: "包单", prop: "serialNumber" }, { default: l(() => [o(T, { modelValue: u.serialNumber, "onUpdate:modelValue": e[1] || (e[1] = (t) => u.serialNumber = t), placeholder: "请输入", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"])) : k("", true), a.value ? k("", true) : (c(), L("div", J, [o(n(H), { modelValue: s.value, "onUpdate:modelValue": e[2] || (e[2] = (t) => s.value = t), "project-id": n(B), packType: r.packType, typeVal: r.typeVal, style: { width: "100%" } }, null, 8, ["modelValue", "project-id", "packType", "typeVal"])]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Q as default
};
