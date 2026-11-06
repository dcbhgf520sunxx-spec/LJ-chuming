import { ref as y } from "vue";
import { inject as v } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as C } from "vue";
import { createBlock as V } from "vue";
import { withCtx as t } from "vue";
import { createVNode as l } from "vue";
import { unref as o } from "vue";
import { createTextVNode as i } from "vue";
import { toDisplayString as m } from "vue";
import { ElFormItem as h } from "element-plus";
import { ElInput as k } from "element-plus";
import { ElForm as P } from "element-plus";
import { _ as F, ao as U } from "../../../../../shared/runtime.js";
const R = { __name: "form", setup(z) {
  const d = y(), p = { id: void 0, newSpecPrefix: void 0, newSpecSection: void 0 }, { CRUD: u, crud: r, form: e } = U(p, d), f = v("specList"), _ = { newSpecPrefix: [{ required: true, message: "请选择截面定义", trigger: "change" }], newSpecSection: [{ required: true, message: "请填写规格", trigger: "blur" }, { min: 1, max: 30, message: "长度在 1 到 30 个字符", trigger: "blur" }] };
  return u.HOOK.beforeSubmit = () => {
    e.list = [], e.list.push({ id: e.id, newSpecPrefix: e.newSpecPrefix, newSpecSection: e.newSpecSection });
  }, (B, n) => {
    const S = c("common-button"), a = h, b = c("common-select"), g = k, x = P, w = c("common-dialog");
    return C(), V(w, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(r).cancelCU, visible: o(r).status.cu > 0, title: "单件修正", width: "500px" }, { titleRight: t(() => [l(S, { loading: o(r).status.cu === 2, type: "primary", size: "default", onClick: o(r).submitCU }, { default: t(() => n[2] || (n[2] = [i("确认")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), default: t(() => [l(x, { ref_key: "formRef", ref: d, model: o(e), rules: _, size: "default", "label-width": "140px" }, { default: t(() => [l(a, { label: "编号" }, { default: t(() => [i(m(o(e).serialNumber), 1)]), _: 1 }), l(a, { label: "名称" }, { default: t(() => [i(m(o(e).name), 1)]), _: 1 }), l(a, { label: "截面定义", prop: "newSpecPrefix" }, { default: t(() => [l(b, { modelValue: o(e).newSpecPrefix, "onUpdate:modelValue": n[0] || (n[0] = (s) => o(e).newSpecPrefix = s), options: o(f), filterable: "", clearable: "", type: "other", dataStructure: { key: "id", label: "value", value: "id" }, placeholder: "定义", style: { width: "220px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), l(a, { label: "原规格" }, { default: t(() => [i(m(o(e).oldSpecification), 1)]), _: 1 }), l(a, { label: "规格", prop: "newSpecSection" }, { default: t(() => [l(g, { modelValue: o(e).newSpecSection, "onUpdate:modelValue": n[1] || (n[1] = (s) => o(e).newSpecSection = s), modelModifiers: { trim: true }, type: "text", maxlength: 30, placeholder: "例如:400*200*10*12", style: { width: "220px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, N = F(R, [["__scopeId", "data-v-92e0e848"]]);
export {
  N as default
};
