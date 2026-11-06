import { ref as g } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as V } from "vue";
import { createBlock as k } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as w } from "vue";
import { ElFormItem as x } from "element-plus";
import { ElInput as y } from "element-plus";
import { ElInputNumber as h } from "element-plus";
import { ElForm as I } from "element-plus";
import { ao as C } from "../../../../../shared/runtime.js";
import { _ as U } from "../../../../../modules/index-c07af747.js";
const B = { __name: "form", setup(z) {
  const a = g(), u = { id: void 0 }, { crud: s, form: l } = C(u, a), d = { workshopId: [{ required: true, message: "请选择所属车间", trigger: "change" }], name: [{ required: true, message: "请填写或选择仓库名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }] };
  return (E, o) => {
    const p = i("common-button"), n = x, _ = y, c = h, f = I, b = i("common-dialog");
    return V(), k(b, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(s).cancelCU, visible: e(s).status.cu > 0, title: e(s).status.title, width: "470px" }, { titleRight: r(() => [t(p, { loading: e(s).status.cu === 2, type: "primary", size: "mini", onClick: e(s).submitCU }, { default: r(() => o[3] || (o[3] = [w("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: r(() => [t(f, { ref_key: "formRef", ref: a, model: e(l), rules: d, size: "small", "label-width": "90px" }, { default: r(() => [t(n, { label: "所属车间", prop: "workshopId" }, { default: r(() => [t(e(U), { modelValue: e(l).workshopId, "onUpdate:modelValue": o[0] || (o[0] = (m) => e(l).workshopId = m), clearable: "", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), t(n, { label: "仓库名称", prop: "name" }, { default: r(() => [t(_, { modelValue: e(l).name, "onUpdate:modelValue": o[1] || (o[1] = (m) => e(l).name = m), modelModifiers: { trim: true }, placeholder: "仓库名称", size: "small", style: { width: "100%" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 }), t(n, { label: "排序", prop: "sort" }, { default: r(() => [t(c, { modelValue: e(l).sort, "onUpdate:modelValue": o[2] || (o[2] = (m) => e(l).sort = m), modelModifiers: { number: true }, max: 99999, min: 1, step: 1, "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  B as default
};
