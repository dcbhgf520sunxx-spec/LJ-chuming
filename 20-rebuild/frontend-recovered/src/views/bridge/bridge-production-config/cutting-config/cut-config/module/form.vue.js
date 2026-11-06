import { ref as b } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as x } from "vue";
import { createBlock as V } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as k } from "vue";
import { ElInput as h } from "element-plus";
import { ElFormItem as y } from "element-plus";
import { ElForm as w } from "element-plus";
import { ao as C } from "../../../../../../shared/runtime.js";
const q = { __name: "form", setup(U) {
  const i = b(), d = { id: void 0, name: void 0 }, { crud: s, form: l } = C(d, i), p = { name: [{ required: true, message: "请填写切割方式", trigger: "blur" }, { max: 8, message: "不能超过8个字符", trigger: "blur" }], cuttingHolesJoint: [{ required: true, message: "请填写切孔联割", trigger: "blur" }], thickness: [{ required: true, message: "请填写支持板厚", trigger: "blur" }] };
  return (F, o) => {
    const c = r("common-button"), f = h, a = y, u = r("common-input-number"), _ = w, g = r("common-dialog");
    return x(), V(g, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(s).cancelCU, visible: e(s).status.cu > 0, title: e(s).status.title, width: "530px" }, { titleRight: n(() => [t(c, { loading: e(s).status.cu === 2, type: "primary", size: "default", onClick: e(s).submitCU }, { default: n(() => o[3] || (o[3] = [k("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: n(() => [t(_, { ref_key: "formRef", ref: i, model: e(l), rules: p, size: "default", "label-width": "135px" }, { default: n(() => [t(a, { label: "切割方式", prop: "name" }, { default: n(() => [t(f, { modelValue: e(l).name, "onUpdate:modelValue": o[0] || (o[0] = (m) => e(l).name = m), maxlength: 8, placeholder: "请填写切割方式", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "支持板厚(mm) ≤", prop: "thickness" }, { default: n(() => [t(u, { modelValue: e(l).thickness, "onUpdate:modelValue": o[1] || (o[1] = (m) => e(l).thickness = m), step: 1, min: 0, max: 999999999, precision: 0, placeholder: "请填写支持板厚", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "切孔联割(φ) ≥", prop: "cuttingHolesJoint" }, { default: n(() => [t(u, { modelValue: e(l).cuttingHolesJoint, "onUpdate:modelValue": o[2] || (o[2] = (m) => e(l).cuttingHolesJoint = m), step: 1, min: 0, max: 999999999, precision: 0, placeholder: "请填写切孔联割", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  q as default
};
