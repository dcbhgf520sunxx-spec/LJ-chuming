import { ref as k } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as x } from "vue";
import { createBlock as T } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as E } from "vue";
import { ElFormItem as h } from "element-plus";
import { ElInput as R } from "element-plus";
import { ElForm as C } from "element-plus";
import { _ as v, cB as f, ao as w, dY as F } from "../../../../shared/runtime.js";
const q = { __name: "form", setup(B) {
  const u = k(), c = { id: void 0, name: "", status: f.TRUE.V, hookUrl: void 0, notificationType: [] }, { crud: m, CRUD: d, form: o } = w(c, u), _ = { name: [{ required: true, message: "请填写名称", trigger: "blur" }], status: [{ required: true, message: "请选择状态", trigger: "change" }], hookUrl: [{ required: true, message: "请填写URL路径", trigger: "blur" }], notificationType: [{ required: true, message: "请选择业务流程类型", trigger: "blur" }] };
  return d.HOOK.beforeSubmit = (a) => {
    a.status.add ? a.form = [o] : a.form = o;
  }, d.HOOK.beforeToEdit = (a) => {
    o.name = a.form.name, o.hookUrl = a.form.hookUrl, o.status = a.form.status, o.notificationType = a.form.notificationType;
  }, (a, t) => {
    const g = i("common-button"), b = i("common-radio"), r = h, p = R, y = i("common-select"), U = C, V = i("common-dialog");
    return x(), T(V, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(m).cancelCU, visible: e(m).status.cu > 0, title: e(m).status.title, width: "600px" }, { titleRight: n(() => [l(g, { loading: e(m).status.cu === 2, type: "primary", size: "default", onClick: e(m).submitCU }, { default: n(() => t[4] || (t[4] = [E("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: n(() => [l(U, { ref_key: "formRef", ref: u, model: e(o), rules: _, size: "default", "label-width": "80px", inline: true }, { default: n(() => [l(r, { label: "状态", prop: "status" }, { default: n(() => [l(b, { modelValue: e(o).status, "onUpdate:modelValue": t[0] || (t[0] = (s) => e(o).status = s), options: e(f).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { label: "名称", prop: "name" }, { default: n(() => [l(p, { modelValue: e(o).name, "onUpdate:modelValue": t[1] || (t[1] = (s) => e(o).name = s), modelModifiers: { trim: true }, style: { width: "450px" }, placeholder: "名称" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "URL路径", prop: "hookUrl" }, { default: n(() => [l(p, { modelValue: e(o).hookUrl, "onUpdate:modelValue": t[2] || (t[2] = (s) => e(o).hookUrl = s), style: { width: "450px" }, placeholder: "URL路径" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "业务流程", prop: "notificationType" }, { default: n(() => [l(y, { modelValue: e(o).notificationType, "onUpdate:modelValue": t[3] || (t[3] = (s) => e(o).notificationType = s), options: e(F).ENUM, type: "enum", clearable: "", multiple: "", "collapse-tags": "", "max-collapse-tags": 3, placeholder: "业务流程", class: "filter-item", style: { width: "450px" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, z = v(q, [["__scopeId", "data-v-e1e5681c"]]);
export {
  z as default
};
