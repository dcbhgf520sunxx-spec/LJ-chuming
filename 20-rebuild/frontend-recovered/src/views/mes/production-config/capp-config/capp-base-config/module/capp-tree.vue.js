import { ref as c } from "vue";
import { computed as k } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as d } from "vue";
import { unref as u } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as E } from "vue";
import { withModifiers as I } from "vue";
import { withDirectives as L } from "vue";
import { toDisplayString as B } from "vue";
import { normalizeStyle as G } from "vue";
import { ElInput as H } from "element-plus";
import { ElTree as R } from "element-plus";
import { _ as w, oG as n, oH as z, oI as O, oJ as W, oK as j, oL as q, V as K, o as P } from "../../../../../../shared/runtime.js";
const S = { class: "capp-tree" }, $ = { class: "caap-tree__header" }, A = { class: "flex-rbc" }, J = { __name: "capp-tree", emits: ["change"], setup(Q, { emit: V }) {
  const g = V, p = c(), r = c(), a = c({ type: n.WELDING.V, name: "" }), m = c([{ id: -1, label: "基本信息", children: s(z.ENUM, "焊接工艺>基础信息>") }, { id: -2, label: "板厚温度", children: s(O.ENUM, "焊接工艺>板厚温度>") }, { id: -3, label: "技术措施", children: s(W.ENUM, "焊接工艺>技术措施>") }, { id: -4, label: "焊接材料", children: s(j.ENUM, "焊接工艺>焊接材料>") }, { id: -5, label: "工艺参数", children: s(q.ENUM, "焊接工艺>工艺参数>") }]), N = k(() => a.value.type !== n.WELDING.V ? [] : K(m.value).filter((e) => (e.children = e.children.filter((l) => l.label.includes(a.value.name)), e.children.length))), { maxHeight: x } = P({ extraBox: [".caap-tree__header"], wrapperBox: [".app-container"], clientHRepMainH: true }, p);
  setTimeout(() => {
    _(m.value[0].children[0]);
  });
  function _(t = {}) {
    var e, l;
    t.id !== ((e = r.value) == null ? void 0 : e.id) && (t != null && t.isLsat && (r.value = t), p.value.setCurrentKey((l = r.value) == null ? void 0 : l.id), g("change", r.value));
  }
  function T() {
    a.value = { type: n.WELDING.V, name: "" };
  }
  function s(t = {}, e = "") {
    return Object.values(t).map((i) => ({ id: i.V, label: i.L, isLsat: true, fullName: `${e}${i.L}` }));
  }
  return (t, e) => {
    const l = f("common-radio-button"), i = H, C = f("common-button"), M = R, U = D("ellipsis");
    return v(), h("div", S, [b("div", $, [d(l, { modelValue: a.value.type, "onUpdate:modelValue": e[0] || (e[0] = (o) => a.value.type = o), options: u(n).ENUM, disabledVal: [u(n).CUTTING.V, u(n).COATING.V], type: "enum" }, null, 8, ["modelValue", "options", "disabledVal"]), b("div", A, [d(i, { modelValue: a.value.name, "onUpdate:modelValue": e[1] || (e[1] = (o) => a.value.name = o), modelModifiers: { trim: true }, clearable: "", placeholder: "名称检索", size: "default" }, null, 8, ["modelValue"]), d(C, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: I(T, ["stop"]) }, { default: y(() => e[2] || (e[2] = [E(" 重置 ")])), _: 1, __: [2] })])]), d(M, { ref_key: "cappTreeRef", ref: p, data: N.value, "node-key": "id", "highlight-current": "", "default-expand-all": "", style: G({ height: u(x) + "px", overflowY: "auto" }), onNodeClick: _ }, { default: y(({ node: o }) => [L((v(), h("div", null, [E(B(o.label), 1)])), [[U]])]), _: 1 }, 8, ["data", "style"])]);
  };
} }, Z = w(J, [["__scopeId", "data-v-66bcf8a0"]]);
export {
  Z as default
};
