import { ref as x } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as V } from "vue";
import { createBlock as k } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as v } from "vue";
import { ElFormItem as w } from "element-plus";
import { ElInputNumber as U } from "element-plus";
import { ElForm as h } from "element-plus";
import { ao as A } from "../../../../../shared/runtime.js";
const R = { __name: "form", props: { menuArr: { type: Array, default: () => [] }, disabledId: { type: Array, default: () => [] } }, setup(m) {
  const i = m, u = x(), c = { menuId: void 0, scale: void 0 }, { CRUD: p, crud: n, form: o } = A(c, u), f = { menuId: [{ required: true, message: "请选择模块", trigger: "change" }], scale: [{ required: true, message: "请输入小数精度", trigger: "change" }] };
  return p.HOOK.beforeSubmit = () => {
    o.list = [{ menuId: o.menuId, scale: o.scale }];
  }, (B, t) => {
    const _ = d("common-button"), b = d("common-select"), s = w, g = U, y = h, I = d("common-dialog");
    return V(), k(I, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "520px" }, { titleRight: l(() => [a(_, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: l(() => t[2] || (t[2] = [C("确认")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), default: l(() => [a(y, { ref_key: "formRef", ref: u, model: e(o), rules: f, size: "default", "label-width": "140px" }, { default: l(() => [a(s, { label: "模块", prop: "menuId" }, { default: l(() => [a(b, { modelValue: e(o).menuId, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(o).menuId = r), options: i.menuArr, "disabled-val": m.disabledId, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, placeholder: "模块", style: { width: "200px" } }, null, 8, ["modelValue", "options", "disabled-val"])]), _: 1 }), a(s, { label: "小数类型" }, { default: l(() => t[3] || (t[3] = [v("span", null, "单价", -1)])), _: 1, __: [3] }), a(s, { label: "小数精度", prop: "scale" }, { default: l(() => [a(g, { modelValue: e(o).scale, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(o).scale = r), modelModifiers: { number: true }, min: 3, max: 7, precision: 0, step: 1, placeholder: "小数精度", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  R as default
};
