import { ref as d } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as h } from "vue";
import { createBlock as v } from "vue";
import { withCtx as s } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createTextVNode as x } from "vue";
import { ElFormItem as C } from "element-plus";
import { ElForm as I } from "element-plus";
import { l as c, ao as w } from "../../../../../shared/runtime.js";
function L(t) {
  return c({ url: "api/system/contract-project-statistics-config-link/page", method: "get", params: t });
}
function S(t) {
  return c({ url: "api/system/contract-project-statistics-config-link", method: "put", data: t });
}
function U(t) {
  return c({ url: "api/system/contract-project-statistics-config-link/delete-config", method: "delete", params: t });
}
function P(t) {
  return c({ url: "api/system/contract-project-statistics-config-link/unassociated-project-list", method: "get", params: t });
}
function V(t) {
  return c({ url: "/api/system/contract-project-statistics-config-link/save-config", method: "post", params: t });
}
const D = { get: L, add: V }, z = { __name: "form", setup(t) {
  const m = d(), u = d(), p = { projectId: void 0 }, { crud: o, form: l } = w(p, m), f = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }] };
  return (async () => {
    try {
      const { content: r } = await P();
      u.value = r;
    } catch (r) {
      console.log(r);
    }
  })(), (r, n) => {
    const _ = i("common-button"), g = i("common-select"), j = C, b = I, y = i("common-dialog");
    return h(), v(y, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(o).cancelCU, visible: e(o).status.cu > 0, title: e(o).status.title, width: "550px" }, { titleRight: s(() => [a(_, { loading: e(o).status.cu === 2, type: "primary", size: "default", onClick: e(o).submitCU }, { default: s(() => n[1] || (n[1] = [x("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), default: s(() => [a(b, { ref_key: "formRef", ref: m, model: e(l), rules: f, size: "default", "label-width": "100px" }, { default: s(() => [a(j, { label: "项目", prop: "projectId" }, { default: s(() => [a(g, { dataStructure: { key: "id", label: "name", value: "id" }, modelValue: e(l).projectId, "onUpdate:modelValue": n[0] || (n[0] = (k) => e(l).projectId = k), filterable: "", options: u.value, placeholder: "请选择项目", style: { width: "270px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, E = Object.freeze(Object.defineProperty({ __proto__: null, default: z }, Symbol.toStringTag, { value: "Module" }));
export {
  z as _,
  D as c,
  U as d,
  E as f,
  S as p
};
