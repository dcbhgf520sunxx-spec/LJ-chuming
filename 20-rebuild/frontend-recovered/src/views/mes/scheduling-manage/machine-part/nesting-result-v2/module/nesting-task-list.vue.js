import { ref as s } from "vue";
import w from "moment";
import { inject as fe } from "vue";
import { watch as W } from "vue";
import { nextTick } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as K } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as c } from "vue";
import { unref as I } from "vue";
import { withKeys as he } from "vue";
import { withCtx as j } from "vue";
import { createTextVNode as E } from "vue";
import { withModifiers as M } from "vue";
import { withDirectives as me } from "vue";
import { createBlock as ve } from "vue";
import { Fragment as G } from "vue";
import { normalizeStyle as U } from "vue";
import { createCommentVNode as Y } from "vue";
import { toDisplayString as A } from "vue";
import { ElInput as ge } from "element-plus";
import { ElDatePicker as _e } from "element-plus";
import { ElTag as ye } from "element-plus";
import { ElTree as ke } from "element-plus";
import { vLoading as be } from "element-plus";
import { _ as xe, qz as X, o as we, rp as Se, G as Ie, ra as je, rq as Ve, a as Z, rr as ee, ri as Ce } from "../../../../../../shared/runtime.js";
import Le from "./nesting-detail.vue.js";
const Ne = { class: "head-container" }, De = { class: "flex-rbc" }, ze = { class: "flex-rbc" }, Te = { style: { padding: "3px 5px", "border-radius": "3px", width: "100%", position: "relative" }, class: "tree-custom-content" }, Ke = { style: { width: "100%", overflow: "hidden", "text-overflow": "ellipsis" } }, Ee = { key: 0, style: { float: "right" } }, Me = { __name: "nesting-task-list", props: { heightStyle: { type: String, default: "" } }, emits: ["nesting-task-click"], setup(Ue, { expose: te, emit: le }) {
  const q = le, g = s([w().subtract(30, "days").valueOf(), w().valueOf()]), _ = s(w().valueOf()), y = s(w().subtract(30, "days").valueOf()), V = s(), C = s(), v = s(X.NOT_ISSUED.V), L = s(false);
  let O = 0;
  const $ = fe("crud"), k = s(false), b = s([]), P = s([]), f = s(), B = s(), R = s([]), D = s([]), F = s([]);
  W([() => g.value], () => {
    $.data = [], $.query.projectId = void 0;
  });
  const { maxHeight: se } = we({ paginate: false });
  p(), ae();
  async function ae() {
    try {
      const e = await Se();
      F.value = e;
    } catch (e) {
      console.log(e, "获取车间列表");
    }
  }
  async function p() {
    if (!Ie(je.get)) return;
    q("nesting-task-click", { node: [], cutState: v.value });
    const e = ++O;
    try {
      k.value = true, b.value = [];
      const keyword = V.value?.trim() || "";
      const t = await Ve({ startDate: y.value, endDate: _.value, workshopIdList: C.value, cutSendStatus: v.value });
      if (e !== O) return;
      P.value = oe(t);
      await nextTick();
      if (e === O) {
        D.value = [];
        f.value?.filter(keyword);
      }
    } catch (t) {
      console.log("获取排产项目列表树失败", t);
    } finally {
      e === O && (k.value = false);
    }
  }
  function oe(e) {
    const t = [];
    for (let l = 0; l < e.length; l++) {
      const n = e[l].children, h = [];
      for (let a = 0; a < n.length; a++) {
        const m = "monomer_" + n[a].id;
        b.value.push(m);
        const d = n[a].children, x = [];
        for (let i = 0; i < d.length; i++) {
          const o = "tasks_" + d[i].id;
          x.push({ id: d[i].id, isLast: i === d.length - 1, rowKey: "tasks_" + d[i].id, parentIds: [e[l].id, n[a].id], label: d[i].jobName, isLeaf: true, disabled: false, fontSize: 14, type: "", icon: "document", jobId: d[i].jobId, workshopId: e[l].workshopId, partSchedulingStatus: d[i].partSchedulingStatus }), b.value.push(o);
        }
        h.push({ id: n[a].id, isLast: a === n.length - 1, rowKey: m, parentIds: [e[l].id], label: n[a].jobName, isLeaf: false, disabled: true, fontSize: 14, type: "", children: x, icon: "config-2", jobId: n[a].jobId });
      }
      t.push({ id: e[l].id, isLast: l === e.length - 1, rowKey: "project_" + e[l].id, parentIds: [], label: e[l].jobName, children: h, isLeaf: false, fontSize: 14, disabled: true, type: "项目", icon: "project", jobId: e[l].jobId });
    }
    return t;
  }
  async function ne(e) {
    R.value = await Ce({ jobId: e.jobId }), L.value = true;
  }
  function ie(e, t) {
    var l, n, h, a, m;
    console.log(e, t, "data, nodedata"), e.isLeaf && (t.checked ? (a = f.value) == null || a.setChecked(t, false) : e.jobId === B.value ? (l = f.value) == null || l.setChecked(t, true) : (B.value = e.jobId, (n = f.value) == null || n.setCheckedNodes([]), (h = f.value) == null || h.setChecked(t, true)), q("nesting-task-click", { node: (m = f.value) == null ? void 0 : m.getCheckedNodes(true), cutSendStatus: v.value }));
  }
  function re(e, t, l) {
    if (!e) return true;
    if (t.label.includes(e) || de(t.parentIds)) return D.value.push(t.id), true;
  }
  function de(e) {
    let t = false;
    for (let l = 0; l < e.length; l++) D.value.includes(e[l]) && (t = true);
    return t;
  }
  function ue(e) {
    e && e.length > 1 ? (y.value = e[0], _.value = e[1]) : (y.value = void 0, _.value = void 0), p();
  }
  function ce() {
    p();
  }
  function pe() {
    V.value = "", C.value = [], g.value = [], y.value = void 0, _.value = void 0, p();
  }
  return te({ refresh: p }), (e, t) => {
    const l = T("common-select"), n = T("common-radio-button"), h = ge, a = T("common-button"), m = _e, d = ye, x = ke, i = be;
    return S(), K(G, null, [u("div", Ne, [u("div", De, [c(l, { class: "filter-item", modelValue: C.value, "onUpdate:modelValue": t[0] || (t[0] = (o) => C.value = o), options: F.value, "data-structure": { key: "workshopId", label: "workshopName", value: "workshopId" }, placeholder: "全部车间", clearable: "", multiple: "", "collapse-tags": "", filterable: "", style: { flex: "1" }, onChange: p }, null, 8, ["modelValue", "options"]), c(n, { class: "filter-item", modelValue: v.value, "onUpdate:modelValue": t[1] || (t[1] = (o) => v.value = o), options: I(X).ENUM, type: "enum", size: "default", onChange: p }, null, 8, ["modelValue", "options"])]), u("div", ze, [c(h, { modelValue: V.value, "onUpdate:modelValue": t[2] || (t[2] = (o) => V.value = o), placeholder: "项目搜索", class: "filter-item", style: { flex: "1" }, size: "default", clearable: "", onKeyup: he(p, ["enter"]) }, null, 8, ["modelValue"]), u("div", null, [c(a, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: M(ce, ["stop"]) }, { default: j(() => t[5] || (t[5] = [E(" 搜索 ")])), _: 1, __: [5] }), c(a, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: M(pe, ["stop"]) }, { default: j(() => t[6] || (t[6] = [E(" 重置 ")])), _: 1, __: [6] })])]), c(m, { modelValue: g.value, "onUpdate:modelValue": t[3] || (t[3] = (o) => g.value = o), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "100%" }, class: "filter-item", onChange: ue }, null, 8, ["modelValue"])]), u("div", { style: U(`height:${I(se)}px`) }, [me((S(), ve(x, { ref_key: "treeMenuRef", ref: f, data: P.value, props: { children: "children", label: "label" }, "filter-node-method": re, style: { height: "100%" }, indent: 20, "expand-on-click-node": "", "node-key": "rowKey", "auto-expand-parent": false, "check-on-click-leaf": false, "default-expanded-keys": b.value, onNodeClick: ie }, { default: j(({ node: o, data: r }) => {
      var H, J, Q;
      return [u("div", Te, [r.rowKey.indexOf("project") === -1 ? (S(), K(G, { key: 0 }, [t[7] || (t[7] = u("div", { style: { position: "absolute", width: "10px", "border-bottom": "1px dashed #dcdfe6", height: "1px", top: "50%", left: "-10px" } }, null, -1)), u("div", { style: U([{ position: "absolute", width: "1px", "border-right": "1px dashed #dcdfe6", left: "-10px" }, { height: r.isLast ? "calc(50% - 2px)" : (H = r.children) != null && H.length && o.expanded ? `${1 + ((J = r.children) == null ? void 0 : J.length)}00%` : "100%" }]) }, null, 4)], 64)) : Y("", true), u("div", Ke, [c(Z, { style: { "margin-right": "5px" }, "icon-class": r.icon }, null, 8, ["icon-class"]), u("span", { style: U(`font-size:${r.fontSize}px;${r.isLeaf ? "" : "font-weight: bold;"};`) }, A(o.label), 5), r.isLeaf ? (S(), K("span", Ee, [c(Z, { "icon-class": "eye-open", style: { flex: "none", color: "#2c2c2c", "margin-right": "5px" }, onClick: M((z) => ne(r), ["stop"]) }, null, 8, ["onClick"]), c(d, { type: (Q = I(ee).V[r.partSchedulingStatus]) == null ? void 0 : Q.T, size: "small" }, { default: j(() => {
        var z;
        return [E(A((z = I(ee).V[r.partSchedulingStatus]) == null ? void 0 : z.L), 1)];
      }), _: 2 }, 1032, ["type"])])) : Y("", true)])])];
    }), _: 1 }, 8, ["data", "default-expanded-keys"])), [[i, k.value]])], 4), c(Le, { visible: L.value, "onUpdate:visible": t[4] || (t[4] = (o) => L.value = o), detailList: R.value }, null, 8, ["visible", "detailList"])], 64);
  };
} }, Be = xe(Me, [["__scopeId", "data-v-6ded4210"]]);
export {
  Be as default
};
