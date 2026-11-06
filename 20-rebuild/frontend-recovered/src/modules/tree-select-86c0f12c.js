import { ref as n } from "vue";
import { reactive as x } from "vue";
import { watch as i } from "vue";
import { nextTick as b } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as k } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as C } from "vue";
import { withCtx as N } from "vue";
import { toDisplayString as M } from "vue";
import { ElInput as V } from "element-plus";
import { ElTree as B } from "element-plus";
import { vLoading as E } from "element-plus";
import { _ as S } from "../shared/runtime.js";
const T = { style: { height: "240px", overflow: "scroll" } }, D = { style: { padding: "3px 5px", "border-radius": "3px", width: "100%" } }, I = { style: { "font-weight": "bold" } }, K = { __name: "tree-select", props: { pid: { type: Number, default: 0 }, treeMenu: { type: Array, default: () => [] }, defaultProps: { type: Object, default: () => {
} } }, emits: ["selected"], setup(c, { emit: u }) {
  const p = u, o = n(), s = n(), _ = x({ data: false }), a = c;
  i(s, (e) => {
    o.value.filter(e);
  }), i(() => a.pid, (e) => {
    b(() => {
      o.value.setCurrentKey(a.pid, true);
    });
  }, { immediate: true });
  function f(e, t) {
    return e ? (t.name || t.label || "").indexOf(e) !== -1 : true;
  }
  function m(e) {
    o.value.setCurrentKey(e.id, true), p("selected", e);
  }
  return (e, t) => {
    const h = V, v = B, y = E;
    return d(), g("div", null, [k(h, { modelValue: s.value, "onUpdate:modelValue": t[0] || (t[0] = (l) => s.value = l), modelModifiers: { trim: true }, size: "default", clearable: "", placeholder: "输入名称搜索" }, null, 8, ["modelValue"]), r("div", T, [w((d(), C(v, { ref_key: "treeMenuRef", ref: o, data: a.treeMenu, props: a.defaultProps, "filter-node-method": f, "highlight-current": "", "expand-on-click-node": false, "node-key": "id", accordion: "", onNodeClick: m }, { default: N(({ node: l }) => [r("div", D, [r("span", I, M(l.label), 1)])]), _: 1 }, 8, ["data", "props"])), [[y, _.data]])])]);
  };
} }, j = S(K, [["__scopeId", "data-v-8929b908"]]);
export {
  j as m
};
