import { ref as g } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as x } from "vue";
import { createBlock as y } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as V } from "vue";
import { ElInput as k } from "element-plus";
import { ElFormItem as w } from "element-plus";
import { ElInputNumber as v } from "element-plus";
import { ElForm as C } from "element-plus";
import { _ as F, ao as U } from "../../../../shared/runtime.js";
const E = { __name: "form", setup(I) {
  const s = g(), i = { id: void 0, name: void 0, remark: void 0, sort: 1 }, { crud: n, form: l } = U(i, s), p = { name: [{ required: true, message: "请填写名称", trigger: "blur" }], sort: [{ required: true, message: "请填写序号", trigger: "blur", type: "number" }] };
  return (z, o) => {
    const _ = d("common-button"), u = k, m = w, f = v, c = C, b = d("common-dialog");
    return x(), y(b, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "600px" }, { titleRight: r(() => [t(_, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: r(() => o[3] || (o[3] = [V("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: r(() => [t(c, { ref_key: "formRef", ref: s, model: e(l), rules: p, size: "default", "label-width": "80px", inline: true }, { default: r(() => [t(m, { label: "角色名称", prop: "name" }, { default: r(() => [t(u, { modelValue: e(l).name, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(l).name = a), style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "描述信息", prop: "remark" }, { default: r(() => [t(u, { modelValue: e(l).remark, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(l).remark = a), style: { width: "450px" }, rows: "5", type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "排序", prop: "sort" }, { default: r(() => [t(f, { modelValue: e(l).sort, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(l).sort = a), modelModifiers: { number: true }, min: 0, max: 999999, "controls-position": "right", style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, R = F(E, [["__scopeId", "data-v-f27c3f8a"]]);
export {
  R as default
};
