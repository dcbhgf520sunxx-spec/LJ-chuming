import { ref as V } from "vue";
import { computed as v } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as C } from "vue";
import { createBlock as y } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as p } from "vue";
import { ElFormItem as w } from "element-plus";
import { ElForm as U } from "element-plus";
import { ao as E, av as N } from "../../../../../../shared/runtime.js";
const z = { style: { float: "right" } }, P = { class: "form" }, q = { __name: "form", setup(R) {
  const u = V(), f = { id: void 0 }, { crud: l, form: s, CRUD: _ } = E(f, u), b = v(() => l.status.edit > 0), k = { specPrefix: [{ required: true, message: "请选择零件规格前缀", trigger: "change" }], numThickness: [{ required: true, validator: (g, o, i) => {
    !s.minThickness || !s.maxThickness ? i(new Error("请填写板厚")) : s.maxThickness < s.minThickness && i(new Error("最大板厚不得小于最小板厚")), i();
  }, message: "请填写板厚", trigger: "blur" }] };
  return (g, o) => {
    const i = r("common-button"), h = r("common-select"), d = w, c = r("common-input-number"), T = U, x = r("common-dialog");
    return C(), y(x, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(l).cancelCU, visible: e(l).status.cu > 0, title: e(l).status.title, "show-close": false, "custom-class": "mes-cutting-config", width: "30%", top: "10vh" }, { titleRight: n(() => [m("span", z, [t(i, { loading: e(l).status.cu === e(_).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(l).submitCU }, { default: n(() => o[3] || (o[3] = [p(" 提 交 ")])), _: 1, __: [3] }, 8, ["loading", "onClick"]), t(i, { size: "default", onClick: e(l).cancelCU }, { default: n(() => o[4] || (o[4] = [p("关 闭")])), _: 1, __: [4] }, 8, ["onClick"])])]), default: n(() => [m("div", P, [t(T, { ref_key: "formRef", ref: u, model: e(s), rules: k, size: "default", "label-width": "170px", class: "demo-form" }, { default: n(() => [t(d, { label: "零件规格前缀", prop: "specPrefix" }, { default: n(() => [t(h, { modelValue: e(s).specPrefix, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(s).specPrefix = a), options: e(N).ENUM, clearable: "", type: "enum", disabled: b.value, placeholder: "零件规格前缀", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), t(d, { label: "板厚数值（毫米）", prop: "numThickness" }, { default: n(() => [t(c, { modelValue: e(s).minThickness, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(s).minThickness = a), step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小板厚(毫米)", style: { width: "45%" } }, null, 8, ["modelValue"]), o[5] || (o[5] = m("span", null, " ~ ", -1)), t(c, { modelValue: e(s).maxThickness, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(s).maxThickness = a), step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大板厚(毫米)", style: { width: "45%" } }, null, 8, ["modelValue"])]), _: 1, __: [5] })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  q as default
};
