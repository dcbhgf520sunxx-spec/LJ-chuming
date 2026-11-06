import { ref as y } from "vue";
import { watchEffect as V } from "vue";
import { watch as $ } from "vue";
import { withDirectives as P } from "vue";
import { openBlock as L } from "vue";
import { createBlock as R } from "vue";
import { withCtx as N } from "vue";
import { createElementVNode as u } from "vue";
import { createElementBlock as W } from "vue";
import { Fragment as q } from "vue";
import { normalizeStyle as T } from "vue";
import { createCommentVNode as H } from "vue";
import { createVNode as B } from "vue";
import { toDisplayString as O } from "vue";
import { ElTooltip as G } from "element-plus";
import { ElTree as J } from "element-plus";
import { vLoading as Q } from "element-plus";
import { _ as U, z as X, a as Y } from "../../../../shared/runtime.js";
const Z = { style: { padding: "3px 5px", "border-radius": "3px", width: "100%", position: "relative" }, class: "tree-custom-content" }, ee = { style: { display: "flex", "align-items": "center", width: "100%" } }, te = { __name: "project-to-area-tree", props: { filterText: { type: String }, loading: { type: Boolean, default: false }, treeData: { type: Array, default: () => [] } }, emits: ["nesting-task-click"], setup(b, { emit: D }) {
  const C = D, x = b, _ = y(), g = y([]), h = y([]), I = y([]), w = y(true);
  V(() => {
    I.value = z(x.treeData);
  });
  function z(e) {
    var l, d, n, c;
    const s = [];
    h.value = [];
    for (let t = 0; t < e.length; t++) {
      const a = e[t].children, m = [];
      for (let r = 0; r < a.length; r++) {
        const o = a[r].children, k = [];
        for (let i = 0; i < o.length; i++) {
          const p = o[i].areaBatchList, j = [], S = "area_" + o[i].id;
          for (let f = 0; f < (p == null ? void 0 : p.length); f++) {
            const K = "batch_" + p[f].id;
            j.push({ id: p[f].id, isLast: f === p.length - 1, rowKey: K, label: p[f].name, name: p[f].name, parentIds: [o[i].id, a[r].id, e[t].id], projectId: e[t].id, monomerId: a[r].id, factoryId: (l = o[i].factory) == null ? void 0 : l.id, workshopId: (d = o[i].workshop) == null ? void 0 : d.id, endDate: p[f].endDate, isLeaf: true, disabled: false, fontSize: 14, type: "", icon: "module-scm" }), h.value.push(K);
          }
          k.push({ id: o[i].id, isLast: i === o.length - 1, rowKey: S, label: o[i].name, name: o[i].name, parentIds: [a[r].id, e[t].id], projectId: e[t].id, monomerId: a[r].id, factoryId: (n = o[i].factory) == null ? void 0 : n.id, workshopId: (c = o[i].workshop) == null ? void 0 : c.id, endDate: o[i].endDate, isLeaf: true, disabled: false, fontSize: 14, type: "", icon: "config-2", children: j }), h.value.push(S);
        }
        const v = "monomer_" + a[r].id;
        m.push({ id: a[r].id, isLast: r === a.length - 1, rowKey: v, parentIds: [e[t].id], label: a[r].name, children: k, isLeaf: false, disabled: false, fontSize: 14, type: "单体", icon: "document" }), h.value.push(v);
      }
      s.push({ id: e[t].id, isLast: t === e.length - 1, rowKey: "project_" + e[t].id, parentIds: [], label: X({ serialNumber: e[t].serialNumber, name: e[t].name, shortName: e[t].shortName }, { showProjectFullName: false, showSerialNumber: true }, false), children: m, isLeaf: false, fontSize: 14, disabled: false, type: "项目", icon: "project" });
    }
    return s;
  }
  function A(e, s) {
    const l = [..._.value.getCheckedKeys(), ..._.value.getHalfCheckedKeys()], d = { projectIds: /* @__PURE__ */ new Set(), monomerIds: /* @__PURE__ */ new Set(), areaIds: /* @__PURE__ */ new Set(), areaBatchIds: /* @__PURE__ */ new Set() };
    l.forEach((n) => {
      const c = n.split("_")[1];
      switch (true) {
        case n.includes("project"):
          d.projectIds.add(c);
          break;
        case n.includes("monomer"):
          d.monomerIds.add(c);
          break;
        case n.includes("area"):
          d.areaIds.add(c);
          break;
        case n.includes("batch"):
          d.areaBatchIds.add(c);
          break;
      }
    }), C("nesting-task-click", { areaBatchIds: Array.from(d.areaBatchIds), areaIds: Array.from(d.areaIds), monomerIds: Array.from(d.monomerIds), projectIds: Array.from(d.projectIds) });
  }
  $(() => x.filterText, (e) => {
    g.value = [], _.value.filter(e);
  });
  function E(e, s, l) {
    if (!e) return true;
    if (s.label.includes(e) || F(s.parentIds)) return g.value.push(s.id), true;
  }
  function F(e) {
    let s = false;
    for (let l = 0; l < e.length; l++) g.value.includes(e[l]) && (s = true);
    return s;
  }
  function M(e) {
    e.target.parentNode.offsetWidth > e.target.offsetWidth ? w.value = true : w.value = false;
  }
  return (e, s) => {
    const l = Y, d = G, n = J, c = Q;
    return P((L(), R(n, { ref_key: "treeMenuRef", ref: _, data: I.value, props: { children: "children", label: "label" }, "filter-node-method": E, style: { height: "100%", padding: "0 10px" }, indent: 20, "show-checkbox": "", "expand-on-click-node": "", "check-strictly": false, "node-key": "rowKey", "auto-expand-parent": false, "default-expanded-keys": h.value, onCheckChange: A }, { default: N(({ node: t, data: a }) => {
      var m, r;
      return [u("div", Z, [a.rowKey.indexOf("project") === -1 ? (L(), W(q, { key: 0 }, [s[1] || (s[1] = u("div", { style: { position: "absolute", width: "10px", "border-bottom": "1px dashed #dcdfe6", height: "1px", top: "50%", left: "-10px" } }, null, -1)), u("div", { style: T([{ position: "absolute", width: "1px", "border-right": "1px dashed #dcdfe6", left: "-10px" }, { height: a.isLast ? "calc(50% - 2px)" : (m = a.children) != null && m.length && t.expanded ? `${1 + ((r = a.children) == null ? void 0 : r.length)}00%` : "100%" }]) }, null, 4)], 64)) : H("", true), u("div", ee, [B(l, { style: { "margin-right": "5px" }, "icon-class": a.icon }, null, 8, ["icon-class"]), B(d, { effect: "dark", content: t.label || "", placement: "top-start", disabled: w.value }, { default: N(() => [u("div", { style: { width: "275px", overflow: "hidden", "text-overflow": "ellipsis" }, onMouseover: s[0] || (s[0] = (o) => M(o)) }, [u("span", { style: T(`font-size:${a.fontSize}px;${t.isLeaf ? "" : "font-weight: bold;"}`) }, O(t.label), 5)], 32)]), _: 2 }, 1032, ["content", "disabled"])])])];
    }), _: 1 }, 8, ["data", "default-expanded-keys"])), [[c, b.loading]]);
  };
} }, re = U(te, [["__scopeId", "data-v-a05ef600"]]);
export {
  re as default
};
