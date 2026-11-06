import { ref as l } from "vue";
import { watchEffect as B } from "vue";
import { watch as v } from "vue";
import { withDirectives as F } from "vue";
import { openBlock as x } from "vue";
import { createBlock as E } from "vue";
import { withCtx as w } from "vue";
import { createElementVNode as i } from "vue";
import { createElementBlock as L } from "vue";
import { Fragment as M } from "vue";
import { normalizeStyle as k } from "vue";
import { createCommentVNode as A } from "vue";
import { createVNode as b } from "vue";
import { toDisplayString as V } from "vue";
import { ElTooltip as P } from "element-plus";
import { ElTree as R } from "element-plus";
import { vLoading as W } from "element-plus";
import { _ as $, z as q, a as O } from "../../../../../shared/runtime.js";
const G = { style: { padding: "3px 5px", "border-radius": "3px", width: "100%", position: "relative" }, class: "tree-custom-content" }, H = { style: { display: "flex", "align-items": "center", width: "100%" } }, J = { __name: "project-to-area-tree", props: { filterText: { type: String }, loading: { type: Boolean, default: false }, treeData: { type: Array, default: () => [] }, month: { type: String }, workshopId: { type: Number } }, emits: ["nesting-task-click"], setup(h, { emit: N }) {
  const C = N, r = h, a = l(), d = l([]), m = l([]), _ = l([]), c = l([]), p = l(true);
  B(() => {
    _.value = T(r.treeData);
  });
  function T(e) {
    const s = [];
    m.value = [];
    for (let t = 0; t < e.length; t++) s.push({ id: e[t].id, isLast: t === e.length - 1, rowKey: "project_" + e[t].id, parentIds: [], label: q({ serialNumber: e[t].serialNumber, name: e[t].name, shortName: e[t].shortName }, { showProjectFullName: false, showSerialNumber: true }, false), children: [], isLeaf: false, fontSize: 16, disabled: false, type: "项目", icon: "project" });
    return s;
  }
  async function j(e, s) {
    var n;
    const t = a.value.getCheckedKeys();
    t.length > 1 ? (await a.value.setCheckedKeys([e.rowKey]), c.value = (n = e.rowKey) == null ? void 0 : n.split("_")[1]) : (c.value = t.map((u) => u.split("_")[1]), await a.value.setCheckedKeys(t)), C("nesting-task-click", c.value);
  }
  v(() => r.filterText, (e) => {
    d.value = [], a.value.filter(e);
  }), v([() => r.month, () => r.workshopId], async (e) => {
    await a.value.setCheckedKeys([]);
  });
  function K(e, s, t) {
    if (!e) return true;
    if (s.label.includes(e) || S(s.parentIds)) return d.value.push(s.id), true;
  }
  function S(e) {
    let s = false;
    for (let t = 0; t < e.length; t++) d.value.includes(e[t]) && (s = true);
    return s;
  }
  function I(e) {
    e.target.parentNode.offsetWidth > e.target.offsetWidth ? p.value = true : p.value = false;
  }
  return (e, s) => {
    const t = O, n = P, u = R, D = W;
    return F((x(), E(u, { ref_key: "treeMenuRef", ref: a, data: _.value, props: { children: "children", label: "label" }, "filter-node-method": K, style: { height: "100%" }, indent: 20, "show-checkbox": "", "expand-on-click-node": "", "node-key": "rowKey", "auto-expand-parent": false, "default-expanded-keys": m.value, onCheckChange: j }, { default: w(({ node: f, data: o }) => {
      var y, g;
      return [i("div", G, [o.rowKey.indexOf("project") === -1 ? (x(), L(M, { key: 0 }, [s[1] || (s[1] = i("div", { style: { position: "absolute", width: "10px", "border-bottom": "1px dashed #dcdfe6", height: "1px", top: "50%", left: "-10px" } }, null, -1)), i("div", { style: k([{ position: "absolute", width: "1px", "border-right": "1px dashed #dcdfe6", left: "-10px" }, { height: o.isLast ? "calc(50% - 2px)" : (y = o.children) != null && y.length && f.expanded ? `${1 + ((g = o.children) == null ? void 0 : g.length)}00%` : "100%" }]) }, null, 4)], 64)) : A("", true), i("div", H, [b(t, { style: { "margin-right": "5px" }, "icon-class": o.icon }, null, 8, ["icon-class"]), b(n, { effect: "dark", content: f.label || "", placement: "top-start", disabled: p.value }, { default: w(() => [i("div", { style: { width: "275px", overflow: "hidden", "text-overflow": "ellipsis" }, onMouseover: s[0] || (s[0] = (z) => I(z)) }, [i("span", { style: k(`font-size:${o.fontSize}px;font-weight: bold;}`) }, V(f.label), 5)], 32)]), _: 2 }, 1032, ["content", "disabled"])])])];
    }), _: 1 }, 8, ["data", "default-expanded-keys"])), [[D, h.loading]]);
  };
} }, Y = $(J, [["__scopeId", "data-v-93d07d37"]]);
export {
  Y as default
};
