import { inject as z } from "vue";
import { ref as f } from "vue";
import { reactive as y } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as c } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as s } from "vue";
import { unref as r } from "vue";
import { ElRadioGroup as P } from "element-plus";
import { createCommentVNode as k } from "vue";
import { createElementBlock as L } from "vue";
import { isRef as q } from "vue";
import { ElRadio as D } from "element-plus";
import { ElInput as G } from "element-plus";
import { ElFormItem as S } from "element-plus";
import { ElForm as $ } from "element-plus";
import { u as A } from "../../../../../../shared/runtime.js";
import { _ as H } from "../../../../../../modules/index-828ab502.js";
const J = { key: 1, style: { "margin-top": "15px" } }, Q = { __name: "index", props: { visible: { type: Boolean, default: false }, packLoading: { type: Boolean, default: false }, packType: { type: Number, default: void 0 }, typeVal: { type: Number } }, emits: ["update:visible", "handlePack"], setup(i, { expose: N, emit: x }) {
  const d = x, w = i, B = z("projectId"), a = f(2), v = f(), u = f(), n = y({ serialNumber: "" }), { visible: m, handleClose: b } = A({ emit: d, props: w, field: "visible" }), I = y({ serialNumber: [{ required: true, message: "请输入包单", trigger: "blur" }, { min: 2, max: 10, message: "长度为2~10个字符", trigger: "blur" }] });
  function j() {
    a.value = true, u.value = void 0, b();
  }
  async function E() {
    a.value === 1 ? await v.value.validate((g, e) => {
      g ? d("handlePack", { isNew: a.value, selectBagId: u.value, ...n }) : console.log("error submit!", e);
    }) : d("handlePack", { isNew: a.value, selectBagId: u.value, ...n });
  }
  return N({ handleSuccess: j }), (g, e) => {
    const R = V("common-button"), p = D, T = G, C = S, F = $, U = V("common-dialog");
    return c(), _(U, { title: "选择新增类型", modelValue: r(m), "onUpdate:modelValue": e[3] || (e[3] = (t) => q(m) ? m.value = t : null), "before-close": r(b), width: "550px" }, { titleRight: l(() => [o(R, { loading: i.packLoading, type: "primary", size: "default", onClick: E }, { default: l(() => e[4] || (e[4] = [s("确 定")])), _: 1, __: [4] }, 8, ["loading"])]), default: l(() => [o(r(P), { modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => a.value = t) }, { default: l(() => [e[8] || (e[8] = s(" `")), o(p, { value: 2 }, { default: l(() => e[5] || (e[5] = [s("自动生成新包单")])), _: 1, __: [5] }), e[9] || (e[9] = s(" `")), o(p, { value: 1 }, { default: l(() => e[6] || (e[6] = [s("手动输入新包单")])), _: 1, __: [6] }), e[10] || (e[10] = s(" `")), o(p, { value: 0 }, { default: l(() => e[7] || (e[7] = [s("使用原有包单")])), _: 1, __: [7] })]), _: 1, __: [8, 9, 10] }, 8, ["modelValue"]), a.value === 1 ? (c(), _(F, { key: 0, ref_key: "ruleFormRef", ref: v, style: { "max-width": "300px", "margin-top": "10px" }, model: n, rules: I, "label-width": "auto", size: "default" }, { default: l(() => [o(C, { label: "包单", prop: "serialNumber" }, { default: l(() => [o(T, { modelValue: n.serialNumber, "onUpdate:modelValue": e[1] || (e[1] = (t) => n.serialNumber = t), placeholder: "请输入", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"])) : k("", true), a.value ? k("", true) : (c(), L("div", J, [o(r(H), { modelValue: u.value, "onUpdate:modelValue": e[2] || (e[2] = (t) => u.value = t), "project-id": r(B), packType: i.packType, typeVal: i.typeVal, style: { width: "100%" } }, null, 8, ["modelValue", "project-id", "packType", "typeVal"])]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Q as default
};
