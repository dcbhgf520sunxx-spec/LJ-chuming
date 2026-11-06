import { ref as y } from "vue";
import { resolveComponent as s } from "vue";
import { openBlock as V } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as h } from "vue";
import { ElInput as j } from "element-plus";
import { ElFormItem as k } from "element-plus";
import { ElForm as w } from "element-plus";
import { ao as C, K as u } from "../../../../../../shared/runtime.js";
const z = { __name: "form", setup(E) {
  const m = y(), c = { name: void 0, projectType: void 0 }, { crud: a, form: n } = C(c, m), d = { name: [{ required: true, message: "请填写类型名称", trigger: "blur" }], projectType: [{ required: true, message: "请选择项目类型", trigger: "change" }] };
  return (T, o) => {
    const i = s("common-button"), f = j, p = k, _ = s("common-select"), b = w, g = s("common-dialog");
    return V(), x(g, { "before-close": e(a).cancelCU, "close-on-click-modal": false, title: e(a).status.title, visible: e(a).status.cu > 0, "append-to-body": "", width: "550px" }, { titleRight: t(() => [l(i, { loading: e(a).status.cu === 2, size: "default", type: "primary", onClick: e(a).submitCU }, { default: t(() => o[2] || (o[2] = [h("确认 ")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), default: t(() => [l(b, { ref_key: "formRef", ref: m, model: e(n), rules: d, "label-width": "130px", size: "default" }, { default: t(() => [l(p, { label: "类型名称", prop: "name" }, { default: t(() => [l(f, { modelValue: e(n).name, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(n).name = r), class: "filter-item", clearable: "", placeholder: "请填写类型名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(p, { label: "项目类型", prop: "projectType" }, { default: t(() => [l(_, { modelValue: e(n).projectType, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(n).projectType = r), options: e(u).ENUM, dataStructure: { key: "V", label: "SL", value: "V" }, unshowOptions: [e(u).ENCLOSURE.V], clearable: "", placeholder: "请选择项目类型", size: "default", style: { width: "270px" }, type: "other" }, null, 8, ["modelValue", "options", "unshowOptions"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} };
export {
  z as default
};
