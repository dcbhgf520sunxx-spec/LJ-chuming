import { ref as i } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as u } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as d } from "vue";
import { unref as v } from "vue";
import { createBlock as n } from "vue";
import { createCommentVNode as _ } from "vue";
import { nextTick as B } from "vue";
import { ElRadioButton as N } from "element-plus";
import { ElRadioGroup as U } from "element-plus";
import { ElButton as E } from "element-plus";
import Q from "./management.vue.js";
import C from "./assurance.vue.js";
import D from "./dialog.vue.js";
import { X as w } from "../../../../../../../modules/contract-9b18cc88.js";
import { _ as z, G } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/index-1f7d934b.js";
import "../../../../../../../modules/data-039b7fd9.js";
const L = { class: "header" }, M = { class: "select" }, P = { __name: "index", setup(R) {
  const t = i("management"), s = i(false), y = () => {
    B(() => {
      s.value = true;
    });
  };
  let l = null;
  const m = (p) => {
    l = p;
  }, x = () => {
    g(), l && l();
  }, c = i();
  function g() {
    c.value = Math.random();
  }
  return (p, e) => {
    const f = N, k = U, b = E;
    return o(), T("div", L, [V("div", M, [u(k, { modelValue: t.value, "onUpdate:modelValue": e[0] || (e[0] = (r) => t.value = r), class: "box-container", size: "default" }, { default: a(() => [u(f, { value: "management" }, { default: a(() => e[2] || (e[2] = [d("管理费")])), _: 1, __: [2] }), u(f, { value: "assurance" }, { default: a(() => e[3] || (e[3] = [d("保证金")])), _: 1, __: [3] })]), _: 1 }, 8, ["modelValue"]), v(G)(v(w).edit_amount) ? (o(), n(b, { key: 0, icon: "el-icon-plus", size: "default", type: "warning", onClick: y }, { default: a(() => e[4] || (e[4] = [d("修改 ")])), _: 1, __: [4] })) : _("", true)]), t.value === "management" ? (o(), n(Q, { key: 0, onSetToQuery: m })) : _("", true), t.value === "assurance" ? (o(), n(C, { key: 1, onSetToQuery: m })) : _("", true), (o(), n(D, { key: c.value, visible: s.value, "onUpdate:visible": e[1] || (e[1] = (r) => s.value = r), onUpdateList: x }, null, 8, ["visible"]))]);
  };
} }, H = z(P, [["__scopeId", "data-v-f69cd1ef"]]);
export {
  H as default
};
