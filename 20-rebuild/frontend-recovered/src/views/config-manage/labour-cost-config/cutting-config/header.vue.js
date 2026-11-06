import { ref as n } from "vue";
import { inject as f } from "vue";
import { provide as h } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as a } from "vue";
import { withCtx as t } from "vue";
import { createBlock as l } from "vue";
import { createTextVNode as m } from "vue";
import { createCommentVNode as u } from "vue";
import { withDirectives as z } from "vue";
import { unref as v } from "vue";
import { createElementVNode as b } from "vue";
import { nextTick as k } from "vue";
import { ElButton as P } from "element-plus";
import { ElCol as U } from "element-plus";
import { ElRadioButton as q } from "element-plus";
import { ElRadioGroup as G } from "element-plus";
import { ElRow as H } from "element-plus";
import I from "./create/index.vue.js";
import L from "./create/batch/index.vue.js";
import { _ as M, ej as S } from "../../../../shared/runtime.js";
import "./create/calculation/index.vue.js";
import "../../../../modules/cutting-config-59e818a6.js";
import "./create/reverse-thrust/index.vue.js";
import "../../../../modules/project-cutting-config-562d5e35.js";
const $ = { class: "header-container" }, A = { __name: "header", setup(F, { expose: y }) {
  const o = n(2), r = n(null), c = n(null), i = n(false), x = f("parentData"), C = f("projectData"), { tableRef: D } = x;
  h("headerData", { radio: o });
  const R = () => {
    r.value.visible = true;
  }, V = () => {
    i.value = true, k(() => {
      c.value.visible = true;
    });
  }, g = () => {
    i.value = false, k(() => {
      D.value.getSparePartsConfigList();
    });
  };
  return y({ radio: o, createRef: r }), (J, e) => {
    const _ = P, p = U, d = q, j = G, B = H, E = N("permission");
    return s(), T("div", $, [a(B, { type: "flex", justify: "space-between" }, { default: t(() => [a(p, { span: 3, class: "btn-container" }, { default: t(() => [o.value === 1 ? (s(), l(_, { key: 0, icon: "el-icon-plus", type: "primary", size: "default", onClick: V }, { default: t(() => e[1] || (e[1] = [m("批量创建 ")])), _: 1, __: [1] })) : u("", true), z((s(), l(_, { icon: "el-icon-plus", type: "primary", size: "default", onClick: R }, { default: t(() => e[2] || (e[2] = [m("创建")])), _: 1, __: [2] })), [[E, v(S).add]])]), _: 1 }), a(p, { span: 3 }, { default: t(() => [v(C) ? u("", true) : (s(), l(j, { key: 0, modelValue: o.value, "onUpdate:modelValue": e[0] || (e[0] = (w) => o.value = w) }, { default: t(() => [a(d, { value: 1, disabled: "" }, { default: t(() => e[3] || (e[3] = [b("span", null, " 实时计算模式 ", -1)])), _: 1 }), a(d, { value: 2 }, { default: t(() => e[4] || (e[4] = [b("span", null, "入库倒推模式", -1)])), _: 1 })]), _: 1 }, 8, ["modelValue"]))]), _: 1 })]), _: 1 }), a(I, { ref_key: "createRef", ref: r }, null, 512), i.value ? (s(), l(L, { key: 0, ref_key: "batchRef", ref: c, onClose: g }, null, 512)) : u("", true)]);
  };
} }, ae = M(A, [["__scopeId", "data-v-84438309"]]);
export {
  ae as default
};
