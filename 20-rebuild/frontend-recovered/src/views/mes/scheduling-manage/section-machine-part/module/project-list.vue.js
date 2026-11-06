import { ref as r } from "vue";
import { reactive as Q } from "vue";
import { watch as ee } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as te } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as _ } from "vue";
import { unref as N } from "vue";
import { toDisplayString as x } from "vue";
import { withDirectives as oe } from "vue";
import { createBlock as M } from "vue";
import { withCtx as se } from "vue";
import { normalizeStyle as S } from "vue";
import { createCommentVNode as ae } from "vue";
import { Fragment as ne } from "vue";
import q from "moment";
import { ElTree as le } from "element-plus";
import { vLoading as ie } from "element-plus";
import { _ as re, qx as P, G as D, rF as B, qY as ue, oW as F, i as ce, b as de, q_ as pe, bV as fe, z as he, a as me } from "../../../../../shared/runtime.js";
import { u as ve } from "../../../../../modules/base-6bc46ddf.js";
import ge from "../../common/project-header-time.vue.js";
const ye = { class: "head-container" }, ke = { style: { display: "flex", "justify-content": "space-between", "margin-bottom": "10px" } }, _e = { style: { display: "flex", "justify-content": "space-between", "margin-top": "10px" } }, xe = { class: "count-item" }, je = { style: { "font-size": "14px", "font-weight": "700" } }, we = { class: "count-item" }, be = { style: { "font-size": "14px", "font-weight": "700" } }, Ie = { class: "count-item" }, Ce = { style: { "font-size": "14px", "font-weight": "700" } }, Ne = { style: { width: "100%", overflow: "hidden", "text-overflow": "ellipsis" } }, Se = { __name: "project-list", props: { maxHeight: { type: [Number, String], default: void 0 }, workShopList: { type: Array, default: () => [] } }, emits: ["project-click", "send-status"], setup(L, { expose: U, emit: Y }) {
  const g = Y, m = r([]), V = r(false), p = r(), i = r(void 0), y = r([]), j = r(false), E = r([]), K = r([]), H = r(), O = r();
  let w = "";
  const k = r(void 0), b = r(), l = r(P.NOT_ISSUED.V), u = Q({ projectCount: 0, quantity: 0, weight: 0 });
  $(), ee(() => l.value, (t) => {
    g("send-status", t);
  });
  function R() {
    k.value = void 0, v(), T();
  }
  function W(t) {
    t ? (v(), T()) : (i.value = void 0, m.value = [], y.value = [], u.projectCount = 0, u.quantity = 0, u.weight = 0, g("project-click", { projectId: void 0, taskOrderIds: [], sendNestingStatus: l.value }, [i.value]));
  }
  async function $() {
    try {
      const t = await ve();
      H.value = t;
    } catch (t) {
      console.log("获取车间、产线、生产组的配置层级失败", t);
    }
  }
  async function T(t) {
    var e, o, c, d;
    if (D(B.get)) try {
      m.value = [], y.value = [], i.value = void 0, V.value = true;
      const { content: f } = await ue({ workshopIds: k.value, steelPlateTypeEnum: [F.SECTION_STEEL.V], sendStatus: l.value });
      if (m.value = f.map((a) => {
        const s = q(a, "YYYY-MM").valueOf(), h = a.split("-");
        return { timeStamp: s, year: h[0], month: h[1] };
      }), t && ce(t.monthList) && ((e = m.value) != null && e.length)) for (let a = 0; a < t.monthList.length; a++) {
        const s = t.monthList[a];
        ((o = m.value) == null ? void 0 : o.findIndex((h) => h.timeStamp === s)) !== -1 && (i.value = s);
      }
      if (de(i.value) && ((c = m.value) != null && c.length)) {
        const a = q().startOf("month").valueOf();
        ((d = m.value) == null ? void 0 : d.findIndex((h) => h.timeStamp === a)) !== -1 ? i.value = a : i.value = m.value[0].timeStamp;
      }
      await v(t);
    } catch (f) {
      console.log("获取排程信息时间错误", f);
    } finally {
      V.value = false;
    }
  }
  async function v(t) {
    if (D(B.get)) {
      g("project-click", { projectId: void 0, taskOrderIds: [], sendNestingStatus: l.value }, [i.value]);
      try {
        j.value = true;
        const e = await pe({ yearMonthArray: [i.value], workshopId: k.value, projectId: b.value, sendNestingStatus: l.value, steelPlateTypeEnum: [F.SECTION_STEEL.V] });
        y.value = A(e), e.length ? (u.projectCount = e[0].projectCount, u.quantity = e[0].schedulingQuantity, u.weight = fe(e[0].schedulingWeight / 1e3)) : (u.projectCount = 0, u.quantity = 0, u.weight = 0);
      } catch (e) {
        console.log("获取排程信息，项目树错误", e);
      } finally {
        j.value = false;
      }
    }
  }
  function A(t) {
    const e = [];
    for (let o = 0; o < t.length; o++) {
      const c = [];
      t[o].taskOrderDTOList.forEach((d, f) => {
        c.push({ id: d.taskOrderId, projectId: t[o].project.id, isLast: f === t[o].taskOrderDTOList.length - 1, rowKey: "workshop_" + d.taskOrderId, label: d.orderNumber, name: d.orderNumber, isLeaf: true, fontSize: 14, type: "", icon: "" });
      }), e.push({ id: t[o].project.id, isLast: o === t.length - 1, rowKey: "project_" + t[o].project.id, parentIds: [], label: he({ serialNumber: t[o].project.serialNumber, name: t[o].project.name, shortName: t[o].project.shortName }, { showProjectFullName: false, showSerialNumber: true }, false), children: c, isLeaf: false, fontSize: 14, type: "项目", icon: N(l) ? "home" : "", disabled: !!N(l) });
    }
    return e;
  }
  function G(t, e, o) {
    if (!t) return true;
    if (e.label.includes(t) || J(e.parentIds)) return E.value.push(e.id), true;
  }
  function J(t) {
    let e = false;
    for (let o = 0; o < t.length; o++) E.value.includes(t[o]) && (e = true);
    return e;
  }
  function X(t, e) {
    var f;
    if (((f = e == null ? void 0 : e.checkedKeys) == null ? void 0 : f.length) > 0) {
      const a = t.isLeaf ? t.projectId : t.id;
      a === w ? I(e, true) : (p.value.setCheckedNodes([]), p.value.setChecked(t, true), I(t, true)), w = a;
    }
    const o = p.value.getCheckedNodes(), c = [], d = w;
    o.forEach((a) => {
      a.isLeaf && c.push(a.id);
    }), g("project-click", { projectId: d, taskOrderIds: c, sendNestingStatus: l.value }, [i.value]);
  }
  function Z(t, e) {
    l.value && t.isLeaf && (e.checked ? p.value.setChecked(e, false) : (t.id === O.value || (O.value = t.id, p.value.setCheckedNodes([])), p.value.setChecked(e, true)), g("project-click", { taskOrderIds: [t.id], sendNestingStatus: l.value }, [i.value], p.value.getCheckedNodes(true)));
  }
  function I(t, e) {
    t.children && t.children.length > 0 && t.children.forEach((o) => {
      p.value.setChecked(o, e), I(o, e);
    });
  }
  return U({ fetchProject: v }), (t, e) => {
    const o = z("common-radio-button"), c = z("common-select"), d = me, f = le, a = ie;
    return C(), te(ne, null, [n("div", ye, [n("div", ke, [_(o, { modelValue: l.value, "onUpdate:modelValue": e[0] || (e[0] = (s) => l.value = s), options: N(P).ENUM, type: "enum", onChange: R }, null, 8, ["modelValue", "options"]), _(c, { modelValue: k.value, "onUpdate:modelValue": e[1] || (e[1] = (s) => k.value = s), options: L.workShopList, "data-structure": { key: "id", label: "name", value: "id" }, style: { flex: "1" }, placeholder: "全部车间", clearable: "", multiple: "", onChange: W }, null, 8, ["modelValue", "options"])]), _(ge, { modelValue: i.value, "onUpdate:modelValue": e[2] || (e[2] = (s) => i.value = s), data: m.value, onChange: v, "empty-text": "暂无零件排产信息" }, null, 8, ["modelValue", "data"]), n("div", _e, [n("div", xe, [n("span", je, x(u.projectCount), 1), e[4] || (e[4] = n("span", { class: "text item" }, "项目数", -1))]), n("div", we, [n("span", be, x(u.quantity), 1), e[5] || (e[5] = n("span", { class: "text item" }, "数量（件）", -1))]), n("div", Ie, [n("span", Ce, x(u.weight), 1), e[6] || (e[6] = n("span", { style: { "font-size": "12px" } }, "重量（吨）", -1))])]), _(c, { modelValue: b.value, "onUpdate:modelValue": e[3] || (e[3] = (s) => b.value = s), options: y.value, "data-structure": { key: "id", label: "label", value: "id" }, style: { width: "100%", "margin-top": "10px" }, placeholder: "全部项目", clearable: "", multiple: "", onChange: v }, null, 8, ["modelValue", "options"])]), n("div", { style: S(`height:${L.maxHeight}px`) }, [oe((C(), M(f, { ref_key: "treeMenuRef", ref: p, data: y.value, props: { children: "children", label: "label" }, "filter-node-method": G, style: { height: "100%", "padding-left": "5px" }, indent: 20, "expand-on-click-node": "", "node-key": "rowKey", "show-checkbox": !l.value, "auto-expand-parent": false, "default-expanded-keys": K.value, onNodeClick: Z, onCheck: X }, { default: se(({ node: s, data: h }) => [n("div", { style: S([{ padding: "3px", "border-radius": "3px", width: "100%", position: "relative" }, { background: s.checked && l.value && s.isLeaf ? "#ffe48d" : "" }]) }, [n("div", Ne, [h.icon ? (C(), M(d, { key: 0, style: { "margin-right": "5px" }, "icon-class": h.icon }, null, 8, ["icon-class"])) : ae("", true), n("span", { style: S(`font-size:${h.fontSize}px;${s.isLeaf ? "" : "font-weight: bold;"}`) }, x(s.label), 5)])], 4)]), _: 1 }, 8, ["data", "show-checkbox", "default-expanded-keys"])), [[a, j.value]])], 4)], 64);
  };
} }, ze = re(Se, [["__scopeId", "data-v-b53e9578"]]);
export {
  ze as default
};
