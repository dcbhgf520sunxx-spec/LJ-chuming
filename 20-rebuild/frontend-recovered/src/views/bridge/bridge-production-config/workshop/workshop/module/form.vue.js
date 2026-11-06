import { ref as g } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as x } from "vue";
import { createBlock as y } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as k } from "vue";
import { ElInput as V } from "element-plus";
import { ElFormItem as w } from "element-plus";
import { ElInputNumber as v } from "element-plus";
import { ElForm as C } from "element-plus";
import { _ as F, ao as I } from "../../../../../../shared/runtime.js";
const R = { __name: "form", setup(U) {
  const n = g(), i = { id: void 0, factoryId: void 0, name: "", sort: 1, remark: "" }, { crud: a, form: l } = I(i, n), p = { sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }], name: [{ required: true, message: "请填写车间名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "blur" }] };
  return (h, o) => {
    const _ = u("common-button"), d = V, m = w, c = v, f = C, b = u("common-dialog");
    return x(), y(b, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: e(a).status.cu > 0, title: e(a).status.title, width: "500px" }, { titleRight: r(() => [t(_, { loading: e(a).status.cu === 2, type: "primary", size: "default", onClick: e(a).submitCU }, { default: r(() => o[3] || (o[3] = [k("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: r(() => [t(f, { ref_key: "formRef", ref: n, model: e(l), rules: p, size: "default", "label-width": "90px" }, { default: r(() => [t(m, { label: "车间名称", prop: "name" }, { default: r(() => [t(d, { modelValue: e(l).name, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(l).name = s), modelModifiers: { trim: true }, type: "text", placeholder: "请填写名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "排序", prop: "sort" }, { default: r(() => [t(c, { modelValue: e(l).sort, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(l).sort = s), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "备注", prop: "remark" }, { default: r(() => [t(d, { modelValue: e(l).remark, "onUpdate:modelValue": o[2] || (o[2] = (s) => e(l).remark = s), type: "textarea", autosize: { minRows: 4, maxRows: 6 }, placeholder: "请填写备注", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, B = F(R, [["__scopeId", "data-v-7da884c7"]]);
export {
  B as default
};
