import { ref as k } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as x } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { createTextVNode as c } from "vue";
import { ElInput as h } from "element-plus";
import { ElFormItem as U } from "element-plus";
import { ElForm as V } from "element-plus";
import { ao as v } from "../../../../../../shared/runtime.js";
const w = { style: { float: "right" } }, R = { class: "form" }, F = { __name: "form", setup(T) {
  const r = k(), u = { materialType: "", name: "" }, { crud: o, form: a, CRUD: d } = v(u, r), f = { materialType: [{ required: true, message: "请选择下料类别", trigger: "blur" }], name: [{ required: true, message: "请输入下料方式", trigger: "blur" }, { max: 8, message: "不能超过8个字符", trigger: "blur" }] };
  return (z, t) => {
    const n = m("common-button"), _ = h, p = U, g = V, b = m("common-dialog");
    return x(), y(b, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(o).cancelCU, visible: e(o).status.cu > 0, title: e(o).status.title, "show-close": false, "custom-class": "mes-cutting-config", width: "30%", top: "10vh" }, { titleRight: l(() => [i("span", w, [s(n, { loading: e(o).status.cu === e(d).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(o).submitCU }, { default: l(() => t[1] || (t[1] = [c(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), s(n, { size: "default", onClick: e(o).cancelCU }, { default: l(() => t[2] || (t[2] = [c("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: l(() => [i("div", R, [s(g, { ref_key: "formRef", ref: r, model: e(a), rules: f, size: "default", "label-width": "100px", class: "demo-form" }, { default: l(() => [s(p, { prop: "name", label: "下料方式：" }, { default: l(() => [s(_, { modelValue: e(a).name, "onUpdate:modelValue": t[0] || (t[0] = (C) => e(a).name = C), maxlength: 8, class: "filter-item", placeholder: "输入下料方式", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  F as default
};
