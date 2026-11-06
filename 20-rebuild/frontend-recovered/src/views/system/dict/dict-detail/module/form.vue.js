import { ref as g } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as x } from "vue";
import { createBlock as y } from "vue";
import { withCtx as t } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as V } from "vue";
import { ElInput as k } from "element-plus";
import { ElFormItem as C } from "element-plus";
import { ElInputNumber as h } from "element-plus";
import { ElForm as w } from "element-plus";
import { ao as z } from "../../../../../shared/runtime.js";
const B = { __name: "form", setup(E) {
  const s = g(), i = { id: void 0, label: void 0, sort: void 0, name: "" }, { crud: a, form: n } = z(i, s), d = { label: [{ required: true, message: "请输入字典标签", trigger: "blur" }], sort: [{ required: true, message: "请输入排序", trigger: "blur", type: "number" }] };
  return (F, o) => {
    const p = u("common-button"), c = k, m = C, f = h, _ = w, b = u("common-dialog");
    return x(), y(b, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: e(a).status.cu > 0, title: e(a).status.title, width: "500px" }, { titleRight: t(() => [l(p, { loading: e(a).status.cu === 2, type: "primary", size: "default", onClick: e(a).submitCU }, { default: t(() => o[2] || (o[2] = [V("确认")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), default: t(() => [l(_, { ref_key: "formRef", ref: s, model: e(n), rules: d, size: "default", "label-width": "90px" }, { default: t(() => [l(m, { label: "字典标签", prop: "label" }, { default: t(() => [l(c, { modelValue: e(n).label, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(n).label = r), placeholder: "输入字典标签", class: "filter-item", style: { width: "350px" }, maxlength: 20, size: "default", clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), l(m, { label: "排序", prop: "sort" }, { default: t(() => [l(f, { class: "align-left", modelValue: e(n).sort, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(n).sort = r), placeholder: "请填写", type: "text", "controls-position": "right", style: { width: "350px" }, min: 0 }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  B as default
};
