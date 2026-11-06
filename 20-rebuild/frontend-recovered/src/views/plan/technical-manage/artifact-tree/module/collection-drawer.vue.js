import { ref as s } from "vue";
import { watch as k } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as H } from "vue";
import { createBlock as L } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as a } from "vue";
import { createTextVNode as l } from "vue";
import { unref as r } from "vue";
import { ElRadio as R } from "element-plus";
import { ElRadioGroup as h } from "element-plus";
import { ElCard as z } from "element-plus";
import { _ as E, u as N, o as T, dp as D } from "../../../../../shared/runtime.js";
const M = { class: "header-container" }, j = { class: "left" }, q = { class: "right" }, A = { __name: "collection-drawer", props: { modelValue: { type: Boolean }, collectList: { type: Array, required: true } }, emits: ["update:modelValue", "updateList"], setup(b, { emit: w }) {
  const i = b, d = w, { visible: x, handleClose: _ } = N({ emit: d, props: i }), c = s(), u = s(), n = s([]);
  T({ mainBox: ".collection-container", extraBox: [".el-drawer__header", ".header-container"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, c);
  function g() {
    n.value = [], d("updateList", n.value);
  }
  return k(() => i.collectList, (p) => {
    n.value = p;
  }, { deep: true }), (p, e) => {
    const m = R, y = h, f = v("common-button"), V = z, C = v("common-drawer");
    return H(), L(C, { ref_key: "drawerRef", ref: c, "before-close": r(_), visible: r(x), "with-header": false, "custom-class": "collection-container", size: "100%" }, { content: o(() => [t(V, null, { default: o(() => [t(D, { "header-title": "变更清单" }), a("div", M, [a("div", j, [e[3] || (e[3] = a("span", null, "请选择变更事项", -1)), t(y, { modelValue: u.value, "onUpdate:modelValue": e[0] || (e[0] = (B) => u.value = B) }, { default: o(() => [t(m, { value: "1" }, { default: o(() => e[1] || (e[1] = [l("删除构件")])), _: 1, __: [1] }), t(m, { value: "2" }, { default: o(() => e[2] || (e[2] = [l("设计变更")])), _: 1, __: [2] })]), _: 1 }, 8, ["modelValue"])]), a("div", q, [t(f, { size: "default", type: "warning", onClick: r(_) }, { default: o(() => e[4] || (e[4] = [l("上一步")])), _: 1, __: [4] }, 8, ["onClick"]), t(f, { size: "default", type: "danger", onClick: g }, { default: o(() => e[5] || (e[5] = [l("清空")])), _: 1, __: [5] })])])]), _: 1 })]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, U = E(A, [["__scopeId", "data-v-b2a2b6ea"]]);
export {
  U as default
};
