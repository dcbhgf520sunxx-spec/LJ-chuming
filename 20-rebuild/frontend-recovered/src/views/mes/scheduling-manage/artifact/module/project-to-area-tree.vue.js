import { ref as i } from "vue";
import $ from "moment";
import { onMounted as re } from "vue";
import { watch as de } from "vue";
import { resolveComponent as q } from "vue";
import { resolveDirective as ce } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as b } from "vue";
import { withDirectives as E } from "vue";
import { unref as S } from "vue";
import { createBlock as U } from "vue";
import { withCtx as L } from "vue";
import { createTextVNode as ue } from "vue";
import { toDisplayString as T } from "vue";
import { Fragment as G } from "vue";
import { normalizeStyle as V } from "vue";
import { createCommentVNode as pe } from "vue";
import { nextTick as fe } from "vue";
import { ElTooltip as he } from "element-plus";
import { ElTree as me } from "element-plus";
import { vLoading as ve } from "element-plus";
import { _ as ge, t as ye, qs as H, b as _e, bV as ke, G as we, z as xe, a as Ie } from "../../../../../shared/runtime.js";
import { p as be, q as Se, t as Te, u as Ne } from "../../../../../modules/artifact-f1b0ca44.js";
import je from "../../common/project-header-time.vue.js";
const Ce = { class: "head-container" }, ze = { style: { display: "flex", "justify-content": "space-between" } }, De = { class: "count-item" }, Le = { style: { "font-size": "14px", "font-weight": "700" } }, Ve = { class: "count-item" }, Ke = { style: { "font-size": "14px", "font-weight": "700" } }, Me = { class: "count-item" }, Pe = { style: { "font-size": "14px", "font-weight": "700" } }, We = { style: { padding: "3px 5px", "border-radius": "3px", width: "100%", position: "relative" }, class: "tree-custom-content" }, Oe = { style: { display: "flex", "align-items": "center", width: "100%" } }, Re = { __name: "project-to-area-tree", props: { heightStyle: { type: String, default: "" } }, emits: ["area-click", "getWorkShopId", "getProjectId", "isReal"], setup(J, { emit: Q }) {
  const c = Q, f = i(), K = i(false), { decimalPrecision: X } = ye(), M = $().startOf("month").valueOf(), P = i([]), h = i(), Z = i(), N = i([]), W = i([]), j = i(false), _ = i([]), O = i([]), m = i(), k = i({});
  let R = "";
  const C = i(true);
  re(() => {
    te();
  });
  const ee = () => {
    K.value = true, c("getWorkShopId", m.value), fe(() => {
      c("isReal", K.value);
    });
  };
  async function te() {
    try {
      const { content: e } = await be();
      O.value = e;
    } catch (e) {
      console.log(e, "获取车间列表");
    }
  }
  async function oe(e) {
    if (we(H.get)) {
      c("getWorkShopId", e), c("area-click", []);
      try {
        const { content: t } = await Se({ workshopId: e }), o = [];
        P.value = t.map((v) => {
          const u = $(v, "YYYY/MM");
          return o.push(u.valueOf()), { year: u.year(), month: u.month() + 1, timeStamp: u.valueOf() };
        }), o != null && o.length && (h.value = o.includes(M) ? M : o[o.length - 1], D({ dateTime: h.value, workshopId: e }), B(e));
      } catch (t) {
        console.log("获取排程信息时间错误", t);
      }
    }
  }
  async function B(e) {
    try {
      j.value = true, _.value = [];
      const { content: t } = await Te({ dateTime: h.value, workshopId: e });
      W.value = await se(t), D({ workshopId: e, dateTime: h.value }), c("area-click", []);
    } catch (t) {
      console.log("获取排程信息，项目树错误", t);
    } finally {
      j.value = false;
    }
  }
  function se(e) {
    var o, v, u, w;
    const t = [];
    for (let l = 0; l < e.length; l++) {
      let g = "", y = "";
      const s = e[l].monomerSchedulingDetailDO, p = [];
      for (let r = 0; r < s.length; r++) {
        const a = s[r].areaSchedulingDetailDO, x = [];
        for (let d = 0; d < a.length; d++) {
          const Y = "area_" + a[d].id;
          g = (o = a[d].factory) == null ? void 0 : o.id, y = (v = a[d].workshop) == null ? void 0 : v.id, x.push({ id: a[d].id, isLast: d === a.length - 1, rowKey: Y, label: a[d].name, name: a[d].name, parentIds: [s[r].id, e[l].id], monomerId: s[r].id, factoryId: (u = a[d].factory) == null ? void 0 : u.id, workshopId: (w = a[d].workshop) == null ? void 0 : w.id, endDate: a[d].endDate, isLeaf: true, disabled: false, fontSize: 14, type: "", icon: "config-2" }), _.value.push(Y);
        }
        const F = "monomer_" + s[r].id;
        p.push({ id: s[r].id, isLast: r === s.length - 1, rowKey: F, parentIds: [e[l].id], label: s[r].name, children: x, isLeaf: false, disabled: false, factoryId: g, workshopId: y, fontSize: 15, type: "单体", icon: "document" }), _.value.push(F);
      }
      t.push({ id: e[l].id, isLast: l === e.length - 1, rowKey: "project_" + e[l].id, parentIds: [], label: xe({ serialNumber: e[l].serialNumber, name: e[l].name, shortName: e[l].shortName }, { showProjectFullName: false, showSerialNumber: true }, false), children: p, isLeaf: false, fontSize: 14, disabled: false, factoryId: g, workshopId: y, type: "项目", icon: "project" });
    }
    return t;
  }
  function ne(e, t) {
    t.checkedKeys.length > 0 && (e.parentIds.length > 0 && e.parentIds[e.parentIds.length - 1] === R ? (z(t, true), c("getProjectId", e.parentIds[e.parentIds.length - 1])) : (f.value.setCheckedNodes([]), f.value.setChecked(e, true), z(e, true), c("getProjectId", e.id)), R = e.parentIds[e.parentIds.length - 1], D({ dateTime: h.value, factoryId: e.factoryId, workshopId: e.workshopId })), c("area-click", f.value.getCheckedNodes(true));
  }
  function z(e, t) {
    e.children && e.children.length > 0 && e.children.forEach((o) => {
      f.value.setChecked(o, t), z(o, t);
    });
  }
  de(Z, (e) => {
    N.value = [], f.value.filter(e);
  });
  function ae(e, t, o) {
    if (!e) return true;
    if (t.label.includes(e) || le(t.parentIds)) return N.value.push(t.id), true;
  }
  function le(e) {
    let t = false;
    for (let o = 0; o < e.length; o++) N.value.includes(e[o]) && (t = true);
    return t;
  }
  function ie(e) {
    e.target.parentNode.offsetWidth > e.target.offsetWidth ? C.value = true : C.value = false;
  }
  async function D({ dateTime: e, factoryId: t, workshopId: o }) {
    k.value = await Ne({ dateTime: e, factoryId: t, workshopId: o });
  }
  return (e, t) => {
    const o = q("common-select"), v = q("common-button"), u = Ie, w = he, l = me, g = ce("permission"), y = ve;
    return I(), A(G, null, [n("div", Ce, [b(o, { modelValue: m.value, "onUpdate:modelValue": t[0] || (t[0] = (s) => m.value = s), options: O.value, "data-structure": { key: "id", label: "name", value: "id" }, onChange: t[1] || (t[1] = (s) => oe(m.value)) }, null, 8, ["modelValue", "options"]), E((I(), U(v, { type: "primary", size: "default", style: { "margin-left": "10px" }, onClick: ee }, { default: L(() => t[5] || (t[5] = [ue(" 车间实时信息")])), _: 1, __: [5] })), [[g, S(H).save]]), b(je, { style: { "margin-top": "10px", "margin-bottom": "10px" }, modelValue: h.value, "onUpdate:modelValue": t[2] || (t[2] = (s) => h.value = s), data: P.value, onChange: t[3] || (t[3] = (s) => B(m.value)), "empty-text": S(_e)(m.value) ? "请先选择车间" : "暂无构件排产信息" }, null, 8, ["modelValue", "data", "empty-text"]), n("div", ze, [n("div", De, [n("span", Le, T(k.value.projectCount || 0), 1), t[6] || (t[6] = n("span", { class: "text item" }, "项目数", -1))]), n("div", Ve, [n("span", Ke, T(k.value.quantity || 0), 1), t[7] || (t[7] = n("span", { class: "text item" }, "数量（件）", -1))]), n("div", Me, [n("span", Pe, T(S(ke)(k.value.totalWeight, S(X).mes) || 0), 1), t[8] || (t[8] = n("span", { style: { "font-size": "12px" } }, "重量（吨）", -1))])])]), n("div", { style: V(J.heightStyle) }, [E((I(), U(l, { ref_key: "treeMenuRef", ref: f, data: W.value, "show-checkbox": "", props: { children: "children", label: "label" }, "filter-node-method": ae, style: { height: "100%" }, indent: 20, "expand-on-click-node": "", "check-on-click-node": "", "node-key": "rowKey", "auto-expand-parent": false, "default-expanded-keys": _.value, onCheck: ne }, { default: L(({ node: s, data: p }) => {
      var r, a;
      return [n("div", We, [p.rowKey.indexOf("project") === -1 ? (I(), A(G, { key: 0 }, [t[9] || (t[9] = n("div", { style: { position: "absolute", width: "10px", "border-bottom": "1px dashed #dcdfe6", height: "1px", top: "50%", left: "-10px" } }, null, -1)), n("div", { style: V([{ position: "absolute", width: "1px", "border-right": "1px dashed #dcdfe6", left: "-10px" }, { height: p.isLast ? "calc(50% - 2px)" : (r = p.children) != null && r.length && s.expanded ? `${1 + ((a = p.children) == null ? void 0 : a.length)}00%` : "100%" }]) }, null, 4)], 64)) : pe("", true), n("div", Oe, [b(u, { style: { "margin-right": "5px" }, "icon-class": p.icon }, null, 8, ["icon-class"]), b(w, { effect: "dark", content: s.label || "", placement: "top-start", disabled: C.value }, { default: L(() => [n("div", { style: { width: "275px", overflow: "hidden", "text-overflow": "ellipsis" }, onMouseover: t[4] || (t[4] = (x) => ie(x)) }, [n("span", { style: V(`font-size:${p.fontSize}px;${s.isLeaf ? "" : "font-weight: bold;"}`) }, T(s.label), 5)], 32)]), _: 2 }, 1032, ["content", "disabled"])])])];
    }), _: 1 }, 8, ["data", "default-expanded-keys"])), [[y, j.value]])], 4)], 64);
  };
} }, Ae = ge(Re, [["__scopeId", "data-v-1d9845f9"]]);
export {
  Ae as default
};
