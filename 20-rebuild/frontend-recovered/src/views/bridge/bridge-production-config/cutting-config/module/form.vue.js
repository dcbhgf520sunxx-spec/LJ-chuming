import { ref as x } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as k } from "vue";
import { createBlock as y } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as p } from "vue";
import { ElFormItem as N } from "element-plus";
import { ElInput as U } from "element-plus";
import { ElForm as h } from "element-plus";
import { ao as w, az as z } from "../../../../../shared/runtime.js";
const R = { style: { float: "right" } }, J = { __name: "form", setup(q) {
  const r = x(), c = { id: void 0, name: void 0, boolNestCutEnum: void 0 }, { crud: a, CRUD: f, form: l } = w(c, r), _ = { boolNestCutEnum: [{ required: true, message: "请选择下料方式", trigger: "blur" }], name: [{ required: true, message: "请填写切割方式", trigger: "blur" }, { max: 8, message: "不能超过8个字符", trigger: "blur" }], cuttingHolesJoint: [{ required: true, message: "请填写切孔联割", trigger: "blur" }], thickness: [{ required: true, message: "请填写支持板厚", trigger: "blur" }] };
  return (B, o) => {
    const i = u("common-button"), g = u("common-radio"), m = N, b = U, d = u("common-input-number"), C = h, V = u("common-dialog");
    return k(), y(V, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: e(a).status.cu > 0, title: e(a).status.title, "show-close": false, width: "530px" }, { titleRight: n(() => [E("span", R, [t(i, { loading: e(a).status.cu === e(f).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(a).submitCU }, { default: n(() => o[4] || (o[4] = [p(" 提 交 ")])), _: 1, __: [4] }, 8, ["loading", "onClick"]), t(i, { size: "default", onClick: e(a).cancelCU }, { default: n(() => o[5] || (o[5] = [p("关 闭")])), _: 1, __: [5] }, 8, ["onClick"])])]), default: n(() => [t(C, { ref_key: "formRef", ref: r, model: e(l), rules: _, size: "default", "label-width": "135px" }, { default: n(() => [t(m, { prop: "boolNestCutEnum", label: "下料方式" }, { default: n(() => [t(g, { class: "filter-item", modelValue: e(l).boolNestCutEnum, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(l).boolNestCutEnum = s), options: e(z).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(m, { label: "切割方式", prop: "name" }, { default: n(() => [t(b, { modelValue: e(l).name, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(l).name = s), maxlength: 8, placeholder: "请填写切割方式", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "支持板厚(mm) ≤", prop: "thickness" }, { default: n(() => [t(d, { modelValue: e(l).thickness, "onUpdate:modelValue": o[2] || (o[2] = (s) => e(l).thickness = s), step: 1, min: 0, max: 999999999, precision: 0, placeholder: "请填写支持板厚", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "切孔联割(φ) ≥", prop: "cuttingHolesJoint" }, { default: n(() => [t(d, { modelValue: e(l).cuttingHolesJoint, "onUpdate:modelValue": o[3] || (o[3] = (s) => e(l).cuttingHolesJoint = s), step: 1, min: 0, max: 999999999, precision: 0, placeholder: "请填写切孔联割", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  J as default
};
