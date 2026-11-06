import { ref as b } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as g } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createTextVNode as k } from "vue";
import { ElInput as y } from "element-plus";
import { ElFormItem as C } from "element-plus";
import { ElForm as w } from "element-plus";
import { ao as V } from "../../../../../shared/runtime.js";
const B = { __name: "form", setup(h) {
  const n = { name: "" }, s = b(), { crud: o, form: r } = V(n, s), i = { name: [{ required: true, message: "请填写国标", trigger: "blur" }, { max: 20, message: "不能超过20个字符", trigger: "blur" }] };
  return (F, l) => {
    const u = m("common-button"), c = y, d = C, f = w, p = m("common-dialog");
    return g(), x(p, { "append-to-body": "", "close-on-click-modal": false, visible: e(o).status.cu > 0, "before-close": e(o).cancelCU, title: e(o).status.title, "show-close": true, width: "400px" }, { titleRight: t(() => [a(u, { loading: e(o).status.cu === 2, size: "default", type: "primary", onClick: e(o).submitCU }, { default: t(() => l[1] || (l[1] = [k("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), default: t(() => [a(f, { ref_key: "formRef", ref: s, model: e(r), rules: i, size: "default", "label-width": "55px" }, { default: t(() => [a(d, { label: "国标", prop: "name" }, { default: t(() => [a(c, { modelValue: e(r).name, "onUpdate:modelValue": l[0] || (l[0] = (_) => e(r).name = _), modelModifiers: { trim: true }, type: "text", placeholder: "", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "before-close", "title"]);
  };
} };
export {
  B as default
};
