import { ref as t } from "vue";
import { inject as w } from "vue";
import { provide as B } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as c } from "vue";
import { withCtx as o } from "vue";
import { withDirectives as u } from "vue";
import { createBlock as l } from "vue";
import { createTextVNode as d } from "vue";
import { unref as f } from "vue";
import { createCommentVNode as m } from "vue";
import { nextTick as v } from "vue";
import { ElButton as N } from "element-plus";
import { ElCol as V } from "element-plus";
import { ElRow as z } from "element-plus";
import P from "./create/index.vue.js";
import T from "./create/batch/index.vue.js";
import { _ as q, ea as b } from "../../../../shared/runtime.js";
import "./create/calculation/index.vue.js";
import "../../../../modules/project-assembly-welding-config-107f9ee1.js";
import "./create/reverse-thrust/index.vue.js";
import "../../../../modules/cutting-config-59e818a6.js";
const H = { class: "header-container" }, I = { __name: "header", setup(L, { expose: y }) {
  const s = t(1), n = t(null), i = t(null), r = t(false), k = w("parentData"), { tableRef: h } = k;
  B("headerData", { radio: s });
  const x = () => {
    n.value.visible = true;
  }, C = () => {
    r.value = true, v(() => {
      i.value.visible = true;
    });
  }, D = () => {
    r.value = false, v(() => {
      h.value.getSparePartsConfigList();
    });
  };
  return y({ radio: s, createRef: n }), (M, e) => {
    const _ = N, R = V, g = z, p = E("permission");
    return a(), j("div", H, [c(g, { type: "flex", justify: "space-between" }, { default: o(() => [c(R, { span: 3, class: "btn-container" }, { default: o(() => [s.value === 1 ? u((a(), l(_, { key: 0, icon: "el-icon-plus", type: "primary", size: "default", onClick: C }, { default: o(() => e[0] || (e[0] = [d("批量创建 ")])), _: 1, __: [0] })), [[p, f(b).add]]) : m("", true), u((a(), l(_, { icon: "el-icon-plus", type: "primary", size: "default", onClick: x }, { default: o(() => e[1] || (e[1] = [d("创建")])), _: 1, __: [1] })), [[p, f(b).add]])]), _: 1 })]), _: 1 }), c(P, { ref_key: "createRef", ref: n }, null, 512), r.value ? (a(), l(T, { key: 0, ref_key: "batchRef", ref: i, onClose: D }, null, 512)) : m("", true)]);
  };
} }, O = q(I, [["__scopeId", "data-v-3d3291ce"]]);
export {
  O as default
};
