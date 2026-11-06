import { ref as b } from "vue";
import { resolveComponent as s } from "vue";
import { openBlock as g } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as k } from "vue";
import { ElInput as y } from "element-plus";
import { ElFormItem as C } from "element-plus";
import { ElForm as V } from "element-plus";
import { ao as h } from "../../../../../../shared/runtime.js";
const B = { __name: "form", setup(w) {
  const m = b(), r = { id: void 0, name: void 0 }, { crud: o, form: a } = h(r, m), d = { name: [{ required: true, message: "请填写生产组名称", trigger: "blur" }] };
  return (F, l) => {
    const i = s("common-button"), u = y, c = C, f = V, p = s("common-dialog");
    return g(), x(p, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(o).cancelCU, visible: e(o).status.cu > 0, title: e(o).status.title, width: "500px" }, { titleRight: t(() => [n(i, { loading: e(o).status.cu === 2, type: "primary", size: "default", onClick: e(o).submitCU }, { default: t(() => l[1] || (l[1] = [k("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), default: t(() => [n(f, { ref_key: "formRef", ref: m, model: e(a), rules: d, size: "default", "label-width": "90px" }, { default: t(() => [n(c, { label: "生产组", prop: "name" }, { default: t(() => [n(u, { modelValue: e(a).name, "onUpdate:modelValue": l[0] || (l[0] = (_) => e(a).name = _), maxlength: "32", type: "text", placeholder: "请填写生产组名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  B as default
};
