import { ref as a } from "vue";
import x from "moment";
import { inject as fe } from "vue";
import { watch as H } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as z } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as d } from "vue";
import { unref as K } from "vue";
import { withKeys as he } from "vue";
import { withCtx as S } from "vue";
import { createTextVNode as E } from "vue";
import { withModifiers as P } from "vue";
import { withDirectives as me } from "vue";
import { createBlock as ve } from "vue";
import { Fragment as J } from "vue";
import { normalizeStyle as M } from "vue";
import { createCommentVNode as Y } from "vue";
import { toDisplayString as A } from "vue";
import { ElDatePicker as ge } from "element-plus";
import { ElInput as ye } from "element-plus";
import { ElTag as ke } from "element-plus";
import { ElTree as _e } from "element-plus";
import { vLoading as be } from "element-plus";
import { _ as we, qy as X, rp as xe, G as Ie, ra as Se, rw as je, a as Z, rr as ee, ri as Ve } from "../../../../../../shared/runtime.js";
import Ce from "./nesting-detail.vue.js";
const Le = { class: "head-container" }, Ne = { style: { padding: "3px 5px", "border-radius": "3px", width: "100%", position: "relative" }, class: "tree-custom-content" }, De = { style: { width: "100%", overflow: "hidden", "text-overflow": "ellipsis" } }, Te = { key: 0, style: { float: "right" } }, ze = { __name: "nesting-task-list", props: { maxHeight: { type: [Number, String], default: void 0 }, heightStyle: { type: String, default: "" } }, emits: ["nesting-task-click"], setup(te, { expose: le, emit: ae }) {
  const U = ae, g = a([x().subtract(30, "days").valueOf(), x().valueOf()]), y = a(x().valueOf()), k = a(x().subtract(30, "days").valueOf()), j = a(), V = a(), v = a(X.IN_NESTING.V), C = a(false);
  let q = 0;
  const O = fe("crud"), _ = a(false), b = a([]), B = a([]), p = a(), R = a(), $ = a([]), L = a(""), N = a([]), F = a([]);
  H([() => g.value], () => {
    O.data = [], O.query.projectId = void 0;
  }), c(), se();
  async function se() {
    try {
      const e = await xe();
      F.value = e;
    } catch (e) {
      console.log(e, "获取车间列表");
    }
  }
  async function c() {
    if (!Ie(Se.get)) return;
    U("nesting-task-click", { node: [], cutState: v.value });
    const e = Date.now();
    q = e;
    try {
      L.value = "", _.value = true, b.value = [];
      const t = await je({ startDate: k.value, endDate: y.value, workShopId: V.value, name: j.value, cutStatus: v.value });
      B.value = oe(t), _.value = false;
    } catch (t) {
      console.log("获取排产项目列表树失败", t);
    } finally {
      e === q && (_.value = false);
    }
  }
  function oe(e) {
    const t = [];
    for (let l = 0; l < e.length; l++) {
      const n = e[l].children, f = [];
      for (let s = 0; s < n.length; s++) {
        const h = "monomer_" + n[s].id;
        b.value.push(h);
        const u = n[s].children, w = [];
        for (let i = 0; i < u.length; i++) {
          const o = "tasks_" + u[i].id;
          w.push({ id: u[i].id, isLast: i === u.length - 1, rowKey: "tasks_" + u[i].id, parentIds: [e[l].id, n[s].id], label: u[i].jobName, isLeaf: true, disabled: false, fontSize: 14, type: "", icon: "document", jobId: u[i].jobId, workshopId: e[l].workshopId, partSchedulingStatus: u[i].partSchedulingStatus }), b.value.push(o);
        }
        f.push({ id: n[s].id, isLast: s === n.length - 1, rowKey: h, parentIds: [e[l].id], label: n[s].jobName, isLeaf: false, disabled: true, fontSize: 14, type: "", children: w, icon: "config-2", jobId: n[s].jobId });
      }
      t.push({ id: e[l].id, isLast: l === e.length - 1, rowKey: "project_" + e[l].id, parentIds: [], label: e[l].jobName, children: f, isLeaf: false, fontSize: 14, disabled: true, type: "项目", icon: "project", jobId: e[l].jobId });
    }
    return t;
  }
  async function ne(e) {
    $.value = await Ve({ jobId: e.jobId }), C.value = true;
  }
  function ie(e, t) {
    var l, n, f, s, h;
    console.log(e, t, "data, nodedata"), e.isLeaf && (t.checked ? (s = p.value) == null || s.setChecked(t, false) : e.jobId === R.value ? (l = p.value) == null || l.setChecked(t, true) : (R.value = e.jobId, (n = p.value) == null || n.setCheckedNodes([]), (f = p.value) == null || f.setChecked(t, true)), U("nesting-task-click", { node: (h = p.value) == null ? void 0 : h.getCheckedNodes(true), cutState: v.value }));
  }
  H(L, (e) => {
    N.value = [], p.value.filter(e);
  });
  function re(e, t, l) {
    if (!e) return true;
    if (t.label.includes(e) || ue(t.parentIds)) return N.value.push(t.id), true;
  }
  function ue(e) {
    let t = false;
    for (let l = 0; l < e.length; l++) N.value.includes(e[l]) && (t = true);
    return t;
  }
  function de(e) {
    e && e.length > 1 ? (k.value = e[0], y.value = e[1]) : (k.value = void 0, y.value = void 0), c();
  }
  function ce() {
    c();
  }
  function pe() {
    L.value = "", g.value = [], k.value = void 0, y.value = void 0, c();
  }
  return le({ refresh: c }), (e, t) => {
    const l = T("common-radio-button"), n = ge, f = ye, s = T("common-button"), h = T("common-select"), u = ke, w = _e, i = be;
    return I(), z(J, null, [m("div", Le, [d(l, { modelValue: v.value, "onUpdate:modelValue": t[0] || (t[0] = (o) => v.value = o), options: K(X).ENUM, type: "enum", size: "default", onChange: c, style: { "margin-bottom": "10px" } }, null, 8, ["modelValue", "options"]), d(n, { modelValue: g.value, "onUpdate:modelValue": t[1] || (t[1] = (o) => g.value = o), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "100%" }, class: "filter-item", onChange: de }, null, 8, ["modelValue"]), d(f, { modelValue: j.value, "onUpdate:modelValue": t[2] || (t[2] = (o) => j.value = o), placeholder: "关键字搜索", class: "filter-item", style: { width: "150px" }, size: "default", clearable: "", onKeyup: he(c, ["enter"]) }, null, 8, ["modelValue"]), d(s, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: P(ce, ["stop"]) }, { default: S(() => t[5] || (t[5] = [E("搜索")])), _: 1, __: [5] }), d(s, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: P(pe, ["stop"]) }, { default: S(() => t[6] || (t[6] = [E(" 重置 ")])), _: 1, __: [6] }), d(h, { modelValue: V.value, "onUpdate:modelValue": t[3] || (t[3] = (o) => V.value = o), options: F.value, "data-structure": { key: "workshopId", label: "workshopName", value: "workshopId" }, style: { width: "100%" }, placeholder: "全部车间", clearable: "", multiple: "", "collapse-tags": "", filterable: "", onChange: c }, null, 8, ["modelValue", "options"])]), m("div", { style: M(te.heightStyle) }, [me((I(), ve(w, { ref_key: "treeMenuRef", ref: p, data: B.value, props: { children: "children", label: "label" }, "filter-node-method": re, style: { height: "100%" }, indent: 20, "expand-on-click-node": "", "node-key": "rowKey", "auto-expand-parent": false, "check-on-click-leaf": false, "default-expanded-keys": b.value, onNodeClick: ie }, { default: S(({ node: o, data: r }) => {
      var G, Q, W;
      return [m("div", Ne, [r.rowKey.indexOf("project") === -1 ? (I(), z(J, { key: 0 }, [t[7] || (t[7] = m("div", { style: { position: "absolute", width: "10px", "border-bottom": "1px dashed #dcdfe6", height: "1px", top: "50%", left: "-10px" } }, null, -1)), m("div", { style: M([{ position: "absolute", width: "1px", "border-right": "1px dashed #dcdfe6", left: "-10px" }, { height: r.isLast ? "calc(50% - 2px)" : (G = r.children) != null && G.length && o.expanded ? `${1 + ((Q = r.children) == null ? void 0 : Q.length)}00%` : "100%" }]) }, null, 4)], 64)) : Y("", true), m("div", De, [d(Z, { style: { "margin-right": "5px" }, "icon-class": r.icon }, null, 8, ["icon-class"]), m("span", { style: M(`font-size:${r.fontSize}px;${r.isLeaf ? "" : "font-weight: bold;"};`) }, A(o.label), 5), r.isLeaf ? (I(), z("span", Te, [d(Z, { "icon-class": "eye-open", style: { flex: "none", color: "#2c2c2c", "margin-right": "5px" }, onClick: P((D) => ne(r), ["stop"]) }, null, 8, ["onClick"]), d(u, { type: (W = K(ee).V[r.partSchedulingStatus]) == null ? void 0 : W.T, size: "small" }, { default: S(() => {
        var D;
        return [E(A((D = K(ee).V[r.partSchedulingStatus]) == null ? void 0 : D.L), 1)];
      }), _: 2 }, 1032, ["type"])])) : Y("", true)])])];
    }), _: 1 }, 8, ["data", "default-expanded-keys"])), [[i, _.value]])], 4), d(Ce, { visible: C.value, "onUpdate:visible": t[4] || (t[4] = (o) => C.value = o), detailList: $.value }, null, 8, ["visible", "detailList"])], 64);
  };
} }, Ue = we(ze, [["__scopeId", "data-v-0f323aea"]]);
export {
  Ue as default
};
