import { ref as d } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as C } from "vue";
import { createBlock as N } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as g } from "vue";
import { ElFormItem as E } from "element-plus";
import { ElInput as U } from "element-plus";
import { ElForm as w } from "element-plus";
import { pc as c, ao as O, y as f } from "../../../../../../../shared/runtime.js";
const h = { __name: "editFrom", setup(k) {
  const u = d(), _ = { name: void 0, serialNumber: void 0, factoryOrConstructionSite: c.FACTORY.V }, { crud: m, form: l } = O(_, u), b = d([f.SECURITY, f.ENVIRONMENT]);
  return (F, o) => {
    const y = r("common-button"), i = r("common-select"), s = E, p = U, V = w, x = r("common-dialog");
    return C(), N(x, { "close-on-click-modal": false, "before-close": e(m).cancelCU, visible: e(m).status.cu > 0, title: e(m).status.title, width: "500px" }, { titleRight: a(() => [t(y, { loading: e(m).status.cu === 2, type: "primary", size: "default", onClick: e(m).submitCU }, { default: a(() => o[4] || (o[4] = [g("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: a(() => [t(V, { ref_key: "formRef", ref: u, model: e(l), size: "default", "label-width": "100px" }, { default: a(() => [t(s, { label: "分类", prop: "factoryOrConstructionSite" }, { default: a(() => [t(i, { type: "enum", modelValue: e(l).factoryOrConstructionSite, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(l).factoryOrConstructionSite = n), options: e(c).ENUM, clearable: "", placeholder: "请选择", style: { width: "270px" }, class: "filter-item" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(s, { label: "类型", prop: "type" }, { default: a(() => [t(i, { type: "enum", modelValue: e(l).type, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(l).type = n), options: b.value, clearable: "", placeholder: "请选择类型", style: { width: "270px" }, class: "filter-item" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(s, { label: "一级分类", prop: "name" }, { default: a(() => [t(p, { modelValue: e(l).name, "onUpdate:modelValue": o[2] || (o[2] = (n) => e(l).name = n), placeholder: "请输入", maxlength: "20", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(s, { label: "代码", prop: "serialNumber" }, { default: a(() => [t(p, { modelValue: e(l).serialNumber, "onUpdate:modelValue": o[3] || (o[3] = (n) => e(l).serialNumber = n), placeholder: "请输入", maxlength: "20", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  h as default
};
