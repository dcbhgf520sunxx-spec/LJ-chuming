import { ref as b } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as g } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { ElInput as k } from "element-plus";
import { ElFormItem as v } from "element-plus";
import { ElForm as C } from "element-plus";
import { _ as V, ao as h } from "../../../../../../shared/runtime.js";
const w = { __name: "form", setup(F) {
  const s = b(), r = { name: void 0 }, { crud: o, form: a } = h(r, s), _ = { name: [{ required: true, message: "请输入变更原因", trigger: "blur" }] };
  return (z, l) => {
    const c = m("common-button"), d = k, u = v, i = C, p = m("common-dialog");
    return g(), x(p, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(o).cancelCU, visible: e(o).status.cu > 0, title: e(o).status.title, width: "520px" }, { titleRight: t(() => [n(c, { loading: e(o).status.cu === 2, type: "primary", size: "default", onClick: e(o).submitCU }, { default: t(() => l[1] || (l[1] = [y("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), default: t(() => [n(i, { ref_key: "formRef", ref: s, model: e(a), rules: _, size: "default", "label-width": "140px" }, { default: t(() => [n(u, { label: "变更原因", prop: "name" }, { default: t(() => [n(d, { modelValue: e(a).name, "onUpdate:modelValue": l[0] || (l[0] = (f) => e(a).name = f), type: "text", placeholder: "请填写", style: { width: "300px" }, maxlength: "20" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, I = V(w, [["__scopeId", "data-v-962c000e"]]);
export {
  I as default
};
