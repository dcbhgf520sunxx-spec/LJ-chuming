import { ref as c } from "vue";
import { watch as h } from "vue";
import { nextTick as w } from "vue";
import { computed as z } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as F } from "vue";
import { createBlock as k } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as B } from "vue";
import { createVNode as l } from "vue";
import { unref as u } from "vue";
import { isRef as O } from "vue";
import { ElFormItem as R } from "element-plus";
import { ElInput as E } from "element-plus";
import { ElForm as I } from "element-plus";
import { l as i, _ as P, u as C, tP as U } from "../../../../../shared/runtime.js";
import q from "./upload-btn/index.vue.js";
function M(o) {
  return i({ module: "project", url: "construction-data", method: "get", params: o });
}
function A(o) {
  return i({ module: "project", url: "construction-data", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: o });
}
function J(o) {
  return i({ module: "project", url: "construction-data", method: "delete", data: o });
}
const $ = { add: A, get: M, del: J };
const D = { __name: "upload-form", props: { globalProject: { type: Object, default: () => {
} }, modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(o, { emit: y }) {
  const p = o, e = c(JSON.parse(JSON.stringify({ projectType: void 0, fileName: void 0 }))), s = c(), b = c(), v = { constructionStageType: { required: true, message: "请选择阶段", trigger: "change" }, fileName: { required: true, message: "请输入文件命名", trigger: "blur" } }, m = y, { visible: r, handleClose: f } = C({ emit: m, props: p });
  h(() => r.value, (_) => {
    _ && (e.value.fileName = void 0, e.value.constructionStageType = void 0, s.value && w(() => {
      s.value.clearValidate();
    }));
  }, { deep: true, immediate: true });
  const j = z(() => ({ projectId: p.globalProject.id, constructionStageType: e.value.constructionStageType, fileName: e.value.fileName }));
  function V() {
    m("success"), f();
  }
  return (_, t) => {
    const S = g("common-select"), d = R, x = E, N = I, T = g("common-dialog");
    return F(), k(T, { "append-to-body": "", "close-on-click-modal": false, "before-close": u(f), modelValue: u(r), "onUpdate:modelValue": t[2] || (t[2] = (n) => O(r) ? r.value = n : null), title: "文件上传", width: "550px" }, { titleAfter: a(() => t[3] || (t[3] = [B("span", { style: { color: "red", "font-size": "12px" } }, "*导入文件类型仅支持zip,pdf,jpg,jpeg,png格式", -1)])), default: a(() => [l(N, { ref_key: "formRef", ref: s, model: e.value, rules: v, size: "default", "label-width": "150px" }, { default: a(() => [l(d, { label: "选择阶段", prop: "constructionStageType" }, { default: a(() => [l(S, { modelValue: e.value.constructionStageType, "onUpdate:modelValue": t[0] || (t[0] = (n) => e.value.constructionStageType = n), options: u(U).ENUM, type: "enum", size: "default", placeholder: "选择阶段", style: { width: "260px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), l(d, { label: "文件名" }, { default: a(() => [l(x, { modelValue: e.value.fileName, "onUpdate:modelValue": t[1] || (t[1] = (n) => e.value.fileName = n), modelModifiers: { trim: true }, placeholder: "文件名", maxlength: 20, style: { width: "260px" } }, null, 8, ["modelValue"])]), _: 1 }), l(d, { label: "上传" }, { default: a(() => [l(u(q), { ref_key: "uploadRef", ref: b, "upload-fun": u($).add, data: j.value, "btn-name": "文件上传", "btn-type": "warning", "btn-size": "mini", icon: "el-icon-upload", accept: ".zip,.pdf,.jpg,.jpeg,.png", class: "filter-item", onSuccess: V, tip: ".zip,.pdf,.jpg,.jpeg,.png", disabled: !e.value.constructionStageType, limit: 1 }, null, 8, ["upload-fun", "data", "disabled"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, G = P(D, [["__scopeId", "data-v-ad848ecb"]]), W = Object.freeze(Object.defineProperty({ __proto__: null, default: G }, Symbol.toStringTag, { value: "Module" }));
export {
  W as a,
  $ as c,
  G as u
};
