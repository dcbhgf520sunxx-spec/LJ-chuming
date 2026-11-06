import { ref as f } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as C } from "vue";
import { createBlock as h } from "vue";
import { withCtx as s } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as k } from "vue";
import { ElFormItem as w } from "element-plus";
import { ElInput as E } from "element-plus";
import { ElForm as L } from "element-plus";
import { l as i, _ as U, aT as z, ao as F, eg as M } from "../../../../../../shared/runtime.js";
function N(o) {
  return i({ module: "system", url: "system/coating-config/list", method: "get", params: o });
}
function S(o) {
  return i({ module: "system", url: "system/coating-config", method: "post", data: o });
}
function j(o) {
  return i({ module: "system", url: "system/coating-config", method: "put", data: o });
}
function q(o) {
  return i({ module: "system", url: `system/coating-config/${o}`, method: "delete" });
}
function G(o) {
  return i({ url: "/api/system/coating-config/update-status", method: "put", params: o });
}
function A() {
  return i({ url: "/api/system/artifact-classification/list", method: "get" });
}
const H = { get: N, add: S, edit: j, del: q };
const B = { __name: "form", props: { measurementManner: { type: Number } }, setup(o) {
  const d = f(), p = f(), _ = { id: void 0, processId: void 0, selectId: void 0, leaderId: void 0, organizationType: void 0, measurementManner: z.WEIGHT.V }, { crud: l, form: a } = F(_, d), g = { artifactClassificationIdList: [{ required: true, message: "请选择构件类型", trigger: "click" }], paintType: [{ required: true, message: "请选择油漆类型", trigger: "click" }], price: [{ required: true, message: "请输入单价", trigger: "blur" }] };
  async function y() {
    try {
      const { content: c } = await A();
      p.value = c.map((t) => ({ name: t.classification, id: t.id }));
    } catch (c) {
      console.log(c);
    }
  }
  return y(), (c, t) => {
    const b = u("common-button"), T = u("common-select"), m = w, V = u("common-radio"), I = E, v = L, x = u("common-dialog");
    return C(), h(x, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(l).cancelCU, visible: e(l).status.cu > 0, title: e(l).status.title, width: "550px" }, { titleRight: s(() => [n(b, { loading: e(l).status.cu === 2, type: "primary", size: "default", onClick: e(l).submitCU }, { default: s(() => t[3] || (t[3] = [k("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: s(() => [n(v, { ref_key: "formRef", ref: d, model: e(a), rules: g, size: "default", "label-width": "100px" }, { default: s(() => [n(m, { label: "构件类型", prop: "artifactClassificationIdList" }, { default: s(() => [n(T, { dataStructure: { key: "id", label: "name", value: "id" }, modelValue: e(a).artifactClassificationIdList, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(a).artifactClassificationIdList = r), multiple: true, options: p.value, placeholder: "请选择类型", style: { width: "270px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue", "options"])]), _: 1 }), n(m, { label: "油漆类型: ", prop: "paintType" }, { default: s(() => [n(V, { modelValue: e(a).paintType, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(a).paintType = r), options: e(M).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), n(m, { label: "单价（元/吨）", prop: "price" }, { default: s(() => [n(I, { modelValue: e(a).price, "onUpdate:modelValue": t[2] || (t[2] = (r) => e(a).price = r), modelModifiers: { number: true }, type: "number", placeholder: "请输入超标单价", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, R = U(B, [["__scopeId", "data-v-dca3acf4"]]), P = Object.freeze(Object.defineProperty({ __proto__: null, default: R }, Symbol.toStringTag, { value: "Module" }));
export {
  H as c,
  G as e,
  P as f,
  R as m
};
