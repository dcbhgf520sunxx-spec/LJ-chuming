import { ref as y } from "vue";
import { resolveComponent as s } from "vue";
import { openBlock as V } from "vue";
import { createBlock as x } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { ElFormItem as g } from "element-plus";
import { ElInput as N } from "element-plus";
import { ElForm as k } from "element-plus";
import { pc as d, ao as w } from "../../../../../../../shared/runtime.js";
const O = { __name: "editFrom", setup(F) {
  const i = y(), c = { name: void 0, serialNumber: void 0, factoryOrConstructionSite: d.FACTORY.V }, { crud: a, form: l } = w(c, i);
  return (U, o) => {
    const p = s("common-button"), f = s("common-select"), r = g, u = N, _ = k, b = s("common-dialog");
    return V(), x(b, { "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: e(a).status.cu > 0, title: e(a).status.title, width: "500px" }, { titleRight: n(() => [t(p, { loading: e(a).status.cu === 2, type: "primary", size: "default", onClick: e(a).submitCU }, { default: n(() => o[3] || (o[3] = [C("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: n(() => [t(_, { ref_key: "formRef", ref: i, model: e(l), size: "default", "label-width": "100px" }, { default: n(() => [t(r, { label: "分类", prop: "factoryOrConstructionSite" }, { default: n(() => [t(f, { type: "enum", modelValue: e(l).factoryOrConstructionSite, "onUpdate:modelValue": o[0] || (o[0] = (m) => e(l).factoryOrConstructionSite = m), options: e(d).ENUM, clearable: "", placeholder: "请选择", style: { width: "270px" }, class: "filter-item" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(r, { label: "一级分类", prop: "name" }, { default: n(() => [t(u, { modelValue: e(l).name, "onUpdate:modelValue": o[1] || (o[1] = (m) => e(l).name = m), placeholder: "请输入", maxlength: "20", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(r, { label: "代码", prop: "serialNumber" }, { default: n(() => [t(u, { modelValue: e(l).serialNumber, "onUpdate:modelValue": o[2] || (o[2] = (m) => e(l).serialNumber = m), placeholder: "请输入", maxlength: "20", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  O as default
};
