import { ref as H } from "vue";
import { watch as C } from "vue";
import { ElMessage as w } from "element-plus";
import { resolveComponent as d } from "vue";
import { openBlock as D } from "vue";
import { createBlock as U } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as t } from "vue";
import { unref as o } from "vue";
import { createTextVNode as r } from "vue";
import { ElFormItem as h } from "element-plus";
import { ElRadio as v } from "element-plus";
import { ElRadioGroup as I } from "element-plus";
import { ElForm as R } from "element-plus";
import { ao as E } from "../../../../../shared/runtime.js";
const J = { style: { float: "right" } }, B = { __name: "form", props: { deviceTypeList: Array }, setup(g) {
  const p = H(), T = { id: void 0, cutTypeId: void 0, boolDrillHole: void 0, maxThickness: void 0, minThickness: void 0 }, { crud: s, CRUD: c, form: l } = E(T, p), f = { cutTypeId: [{ required: true, message: "请选择切割方式", trigger: "blur" }], cuttingHolesJoint: [{ required: true, message: "请填写切孔直径", trigger: "blur" }], boolDrillHole: [{ required: true, message: "请选择是否板孔联割", trigger: "blur" }] };
  return C(() => l.boolDrillHole, () => {
    l.boolDrillHole !== 2 && (l.cuttingHolesJoint = void 0), f.cuttingHolesJoint[0].required = l.boolDrillHole === 2;
  }), c.HOOK.beforeSubmit = () => {
    if (s.form.name = s.form.cutTypeId, !l.minThickness || !l.maxThickness) return w.error("请填写必选项"), false;
  }, (q, e) => {
    const _ = d("common-button"), k = d("common-select"), a = h, m = v, x = I, u = d("common-input-number"), y = R, V = d("common-dialog");
    return D(), U(V, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(s).cancelCU, visible: o(s).status.cu > 0, title: o(s).status.title, "show-close": false, width: "530px" }, { titleRight: n(() => [b("span", J, [t(_, { loading: o(s).status.cu === o(c).STATUS.PROCESSING, size: "default", type: "primary", onClick: o(s).submitCU }, { default: n(() => e[5] || (e[5] = [r(" 提 交 ")])), _: 1, __: [5] }, 8, ["loading", "onClick"]), t(_, { size: "default", onClick: o(s).cancelCU }, { default: n(() => e[6] || (e[6] = [r("关 闭")])), _: 1, __: [6] }, 8, ["onClick"])])]), default: n(() => [t(y, { ref_key: "formRef", ref: p, model: o(l), rules: f, size: "default", "label-width": "135px" }, { default: n(() => [t(a, { label: "切割方式", prop: "cutTypeId" }, { default: n(() => [t(k, { modelValue: o(l).cutTypeId, "onUpdate:modelValue": e[0] || (e[0] = (i) => o(l).cutTypeId = i), options: g.deviceTypeList, type: "other", size: "default", clearable: "", placeholder: "切割方式", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(a, { prop: "boolDrillHole", label: "是否板孔联割" }, { default: n(() => [t(x, { modelValue: o(l).boolDrillHole, "onUpdate:modelValue": e[1] || (e[1] = (i) => o(l).boolDrillHole = i) }, { default: n(() => [t(m, { value: 1 }, { default: n(() => e[7] || (e[7] = [r("是")])), _: 1, __: [7] }), t(m, { value: 0 }, { default: n(() => e[8] || (e[8] = [r("否")])), _: 1, __: [8] }), t(m, { value: 2 }, { default: n(() => e[9] || (e[9] = [r("部分")])), _: 1, __: [9] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(a, { label: "支持板厚(mm)", prop: "thickness", class: "form-label-require" }, { default: n(() => [t(u, { modelValue: o(l).minThickness, "onUpdate:modelValue": e[2] || (e[2] = (i) => o(l).minThickness = i), step: 1, min: 1, max: o(l).maxThickness, "controls-position": "right", precision: 0, placeholder: "最小板厚", style: { width: "130px" } }, null, 8, ["modelValue", "max"]), e[10] || (e[10] = b("span", null, " ~ ", -1)), t(u, { modelValue: o(l).maxThickness, "onUpdate:modelValue": e[3] || (e[3] = (i) => o(l).maxThickness = i), step: 1, min: o(l).minThickness, "controls-position": "right", max: 999999999, precision: 0, placeholder: "最大板厚", style: { width: "130px" } }, null, 8, ["modelValue", "min"])]), _: 1, __: [10] }), t(a, { label: "孔直径(φ) ≥", prop: "cuttingHolesJoint" }, { default: n(() => [t(u, { modelValue: o(l).cuttingHolesJoint, "onUpdate:modelValue": e[4] || (e[4] = (i) => o(l).cuttingHolesJoint = i), step: 1, min: 0, max: 999999999, disabled: o(l).boolDrillHole !== 2, precision: 0, placeholder: "请填写孔直径", style: { width: "270px" } }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  B as default
};
