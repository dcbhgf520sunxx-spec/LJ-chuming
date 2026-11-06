import { ref as m } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as c } from "vue";
import { createBlock as u } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as U } from "vue";
import { ElInput as S } from "element-plus";
import { ElFormItem as F } from "element-plus";
import { Search as z } from "@element-plus/icons-vue";
import { ElIcon as B } from "element-plus";
import { ElPopover as N } from "element-plus";
import { ElInputNumber as R } from "element-plus";
import { ElForm as q } from "element-plus";
import { ao as j, a as G } from "../../../../shared/runtime.js";
import { I as M } from "../../../../modules/index-e65bb365.js";
const H = { __name: "form", setup(P) {
  const d = m(), b = m(), i = m(false), g = { id: void 0, name: void 0, icon: void 0, sort: void 0 }, { crud: a, form: l } = j(g, d), x = { name: [{ required: true, message: "请填写名称", trigger: "blur" }, { min: 1, max: 10, message: "请填写1-10个字符", trigger: "blur" }], icon: [{ required: true, message: "请选择图标", trigger: "change" }] };
  function y(p) {
    l.icon = p, i.value = false;
  }
  return (p, n) => {
    const v = f("common-button"), _ = S, r = F, V = G, k = z, h = B, w = N, E = R, I = q, C = f("common-dialog");
    return c(), u(C, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: e(a).status.cu > 0, title: e(a).status.title, width: "600px" }, { titleRight: o(() => [t(v, { loading: e(a).status.cu === 2, type: "primary", size: "default", onClick: e(a).submitCU }, { default: o(() => n[4] || (n[4] = [U("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: o(() => [t(I, { ref_key: "formRef", ref: d, model: e(l), rules: x, size: "default", "label-width": "80px" }, { default: o(() => [t(r, { label: "类型名称", prop: "name" }, { default: o(() => [t(_, { modelValue: e(l).name, "onUpdate:modelValue": n[0] || (n[0] = (s) => e(l).name = s), style: { width: "450px" }, placeholder: "类型名称" }, null, 8, ["modelValue"])]), _: 1 }), t(r, { label: "类型图标", prop: "icon" }, { default: o(() => [t(w, { placement: "bottom-start", width: "450", trigger: "click", visible: i.value, "onUpdate:visible": n[2] || (n[2] = (s) => i.value = s) }, { reference: o(() => [t(_, { modelValue: e(l).icon, "onUpdate:modelValue": n[1] || (n[1] = (s) => e(l).icon = s), style: { width: "450px" }, placeholder: "点击选择图标", readonly: "" }, { prefix: o(() => [e(l).icon ? (c(), u(V, { key: 0, "icon-class": e(l).icon, class: "el-input__icon", style: { height: "32px", width: "16px" } }, null, 8, ["icon-class"])) : (c(), u(h, { key: 1, class: "el-input__icon" }, { default: o(() => [t(k)]), _: 1 }))]), _: 1 }, 8, ["modelValue"])]), default: o(() => [t(M, { ref_key: "iconSelect", ref: b, onSelected: y, style: { width: "424px" } }, null, 512)]), _: 1 }, 8, ["visible"])]), _: 1 }), t(r, { label: "类型排序", prop: "sort" }, { default: o(() => [t(E, { modelValue: e(l).sort, "onUpdate:modelValue": n[3] || (n[3] = (s) => e(l).sort = s), modelModifiers: { number: true }, min: 0, max: 999, "controls-position": "right", style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  H as default
};
