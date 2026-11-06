import { ref as a } from "vue";
import { reactive as he } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as ve } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as m } from "vue";
import { unref as T } from "vue";
import { toDisplayString as L } from "vue";
import { withDirectives as ge } from "vue";
import { createBlock as P } from "vue";
import { withCtx as V } from "vue";
import { normalizeStyle as D } from "vue";
import { createCommentVNode as K } from "vue";
import { Fragment as ye } from "vue";
import H from "moment";
import { ElTableColumn as _e } from "element-plus";
import { ElPopover as ke } from "element-plus";
import { ElTree as xe } from "element-plus";
import { vLoading as je } from "element-plus";
import { u as we } from "../../../../../modules/base-6bc46ddf.js";
import { _ as Ie, qx as W, o as be, q as Ce, a as $, G, qA as Z, qY as Ne, oW as E, i as Se, b as Le, qZ as Ve, q_ as Ee, bV as Ae, z as Me } from "../../../../../shared/runtime.js";
import Oe from "../../common/project-header-time.vue.js";
const Re = { class: "head-container" }, Te = { style: { display: "flex", "justify-content": "space-between", "margin-bottom": "10px" } }, Pe = { style: { display: "flex", "justify-content": "space-between", "margin-top": "10px" } }, De = { class: "count-item" }, qe = { style: { "font-size": "14px", "font-weight": "700" } }, ze = { class: "count-item" }, Be = { style: { "font-size": "14px", "font-weight": "700" } }, Ye = { class: "count-item" }, Ue = { style: { "font-size": "14px", "font-weight": "700" } }, Fe = { style: { width: "100%", overflow: "hidden", "text-overflow": "ellipsis" } }, Ke = { __name: "project-list", props: { workShopList: { type: Array, default: () => [] } }, emits: ["project-click", "send-status"], setup(J, { expose: X, emit: Q }) {
  const x = Q, h = a([]), q = a(false), p = a(), s = a(void 0), I = a([]), A = a(false), z = a([]), ee = a([]), te = a(), B = a();
  let M = "";
  const y = a(void 0), b = a(), j = a(), w = a(), u = a(W.NOT_ISSUED.V), c = he({ projectCount: 0, quantity: 0, weight: 0 }), Y = a();
  ue();
  const { maxHeight: oe } = be({ paginate: false });
  function ae(e) {
    x("send-status", e), y.value = void 0, N(), U();
  }
  const C = a([]);
  function ne(e) {
    C.value = e || [];
  }
  function le(e) {
    N(), e ? (_(), U()) : (s.value = void 0, h.value = [], I.value = [], c.projectCount = 0, c.quantity = 0, c.weight = 0, x("project-click", { projectId: void 0, taskOrderIds: [], sendNestingStatus: u.value }, [s.value]));
  }
  function se() {
    N(), _();
  }
  function ie(e) {
    j.value = void 0, w.value = void 0, C.value = [], _();
  }
  function re(e) {
    w.value = void 0, _(), e || (C.value = []);
  }
  async function ue() {
    try {
      const e = await we();
      te.value = e;
    } catch (e) {
      console.log("获取车间、产线、生产组的配置层级失败", e);
    }
  }
  async function U(e) {
    var t, o, d, i;
    if (G(Z.get)) try {
      h.value = [], I.value = [], s.value = void 0, q.value = true;
      const { content: f } = await Ne({ workshopIds: y.value, steelPlateTypeEnum: [E.PRIMARY_MEMBER.V, E.SECONDARY_MEMBER.V], sendStatus: u.value });
      if (h.value = f.map((r) => {
        const k = H(r, "YYYY-MM").valueOf(), g = r.split("-");
        return { timeStamp: k, year: g[0], month: g[1] };
      }), e && Se(e.monthList) && ((t = h.value) != null && t.length)) for (let r = 0; r < e.monthList.length; r++) {
        const k = e.monthList[r];
        ((o = h.value) == null ? void 0 : o.findIndex((g) => g.timeStamp === k)) !== -1 && (s.value = k);
      }
      if (Le(s.value) && ((d = h.value) != null && d.length)) {
        const r = H().startOf("month").valueOf();
        ((i = h.value) == null ? void 0 : i.findIndex((g) => g.timeStamp === r)) !== -1 ? s.value = r : s.value = h.value[0].timeStamp;
      }
      await _(e), await N();
    } catch (f) {
      console.log("获取排程信息时间错误", f);
    } finally {
      q.value = false;
    }
  }
  async function N() {
    try {
      const e = await Ve({ sendNestingStatus: u.value, yearMonthArray: [s.value], workshopId: y.value });
      Y.value = e || [];
    } catch (e) {
      console.log(e);
    }
  }
  async function _(e) {
    if (G(Z.get)) {
      x("project-click", { projectId: void 0, taskOrderIds: [], sendNestingStatus: u.value }, [s.value]);
      try {
        A.value = true;
        const t = await Ee({ yearMonthArray: [s.value], workshopId: y.value, projectId: b.value, monomerId: j.value, areaId: w.value, sendNestingStatus: u.value, steelPlateTypeEnum: [E.PRIMARY_MEMBER.V, E.SECONDARY_MEMBER.V] });
        I.value = ce(t), t.length ? (c.projectCount = t[0].projectCount, c.quantity = t[0].schedulingQuantity, c.weight = Ae(t[0].schedulingWeight / 1e3)) : (c.projectCount = 0, c.quantity = 0, c.weight = 0);
      } catch (t) {
        console.log("获取排程信息，项目树错误", t);
      } finally {
        A.value = false;
      }
    }
  }
  function ce(e) {
    const t = [];
    for (let o = 0; o < e.length; o++) {
      const d = [];
      e[o].taskOrderDTOList.forEach((i, f) => {
        d.push({ id: i.taskOrderId, projectId: e[o].project.id, isLast: f === e[o].taskOrderDTOList.length - 1, rowKey: "workshop_" + i.taskOrderId, label: i.orderNumber, name: i.orderNumber, monomerAndAreaList: i.monomerAndAreaList, monomerAndAreaIds: i.monomerAndAreaIds, isLeaf: true, fontSize: 14, type: "", icon: "" });
      }), t.push({ id: e[o].project.id, isLast: o === e.length - 1, rowKey: "project_" + e[o].project.id, parentIds: [], label: Me({ serialNumber: e[o].project.serialNumber, name: e[o].project.name, shortName: e[o].project.shortName }, { showProjectFullName: false, showSerialNumber: true }, false), children: d, isLeaf: false, fontSize: 14, type: "项目", icon: "home", disabled: true });
    }
    return t;
  }
  function de(e, t, o) {
    if (!e) return true;
    if (t.label.includes(e) || pe(t.parentIds)) return z.value.push(t.id), true;
  }
  function pe(e) {
    let t = false;
    for (let o = 0; o < e.length; o++) z.value.includes(e[o]) && (t = true);
    return t;
  }
  function fe(e, t) {
    var f;
    ((f = t == null ? void 0 : t.checkedKeys) == null ? void 0 : f.length) > 0 && (e.projectId === M ? O(t, true) : (p.value.setCheckedNodes([]), p.value.setChecked(e, true), O(e, true)), M = e.projectId);
    const o = p.value.getCheckedNodes(), d = [], i = M;
    o.forEach((r) => {
      r.isLeaf && d.push(r.id);
    }), x("project-click", { projectId: i, taskOrderIds: d, sendNestingStatus: u.value }, [s.value]);
  }
  function me(e, t) {
    u.value && e.isLeaf && (t.checked ? p.value.setChecked(t, false) : (e.id === B.value || (B.value = e.id, p.value.setCheckedNodes([])), p.value.setChecked(t, true)), x("project-click", { taskOrderIds: [e.id], sendNestingStatus: u.value }, [s.value], p.value.getCheckedNodes(true)));
  }
  function O(e, t) {
    e.children && e.children.length > 0 && e.children.forEach((o) => {
      p.value.setChecked(o, t), O(o, t);
    });
  }
  return X({ fetchProject: _, workShopId: y }), (e, t) => {
    const o = R("common-radio-button"), d = R("common-select"), i = _e, f = R("common-table"), r = ke, k = xe, g = je;
    return S(), ve(ye, null, [l("div", Re, [l("div", Te, [m(o, { modelValue: u.value, "onUpdate:modelValue": t[0] || (t[0] = (n) => u.value = n), options: T(W).ENUM, type: "enum", size: "default", onChange: ae }, null, 8, ["modelValue", "options"]), m(d, { modelValue: y.value, "onUpdate:modelValue": t[1] || (t[1] = (n) => y.value = n), options: J.workShopList, "data-structure": { key: "id", label: "name", value: "id" }, style: { flex: "1" }, placeholder: "全部车间", clearable: "", "collapse-tags": "", "collapse-tags-tooltip": "", filterable: "", multiple: "", onChange: le }, null, 8, ["modelValue", "options"])]), m(Oe, { modelValue: s.value, "onUpdate:modelValue": t[2] || (t[2] = (n) => s.value = n), data: h.value, onChange: se, "empty-text": "暂无零件排产信息" }, null, 8, ["modelValue", "data"]), l("div", Pe, [l("div", De, [l("span", qe, L(c.projectCount), 1), t[6] || (t[6] = l("span", { class: "text item" }, "项目数", -1))]), l("div", ze, [l("span", Be, L(c.quantity), 1), t[7] || (t[7] = l("span", { class: "text item" }, "数量（件）", -1))]), l("div", Ye, [l("span", Ue, L(c.weight), 1), t[8] || (t[8] = l("span", { style: { "font-size": "12px" } }, "重量（吨）", -1))])]), m(d, { modelValue: b.value, "onUpdate:modelValue": t[3] || (t[3] = (n) => b.value = n), options: Y.value, "data-structure": { key: "id", label: "shortName", value: "id" }, style: { width: "100%", "margin-top": "10px" }, class: "filter-item", placeholder: "全部项目", clearable: "", onChange: ie }, null, 8, ["modelValue", "options"]), m(T(Ce), { ref: "monomerRef", modelValue: j.value, "onUpdate:modelValue": t[4] || (t[4] = (n) => j.value = n), "project-id": b.value, default: false, clearable: "", placeholder: "可选择单体", style: { width: "175px", "margin-right": "10px" }, onGetAreaInfo: ne, onChange: re }, null, 8, ["modelValue", "project-id"]), m(d, { modelValue: w.value, "onUpdate:modelValue": t[5] || (t[5] = (n) => w.value = n), options: C.value, dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", placeholder: "请选择区域", noDataText: j.value ? "暂无数据" : "未选择单体", style: { width: "175px" }, onChange: _ }, null, 8, ["modelValue", "options", "noDataText"])]), l("div", { style: D(`height:${T(oe)}px`) }, [ge((S(), P(k, { ref_key: "treeMenuRef", ref: p, data: I.value, props: { children: "children", label: "label" }, "filter-node-method": de, style: { height: "100%", "padding-left": "5px" }, indent: 20, "expand-on-click-node": "", "node-key": "rowKey", "show-checkbox": !u.value, "auto-expand-parent": false, "check-on-click-leaf": false, "default-expanded-keys": ee.value, onNodeClick: me, onCheck: fe }, { default: V(({ node: n, data: v }) => {
      var F;
      return [l("div", { style: D([{ padding: "3px", "border-radius": "3px", width: "100%", position: "relative" }, { background: n.checked && u.value && n.isLeaf ? "#ffe48d" : "" }]) }, [l("div", Fe, [v.icon ? (S(), P($, { key: 0, style: { "margin-right": "5px" }, "icon-class": v.icon }, null, 8, ["icon-class"])) : K("", true), l("span", { style: D(`font-size:${v.fontSize}px;${n.isLeaf ? "" : "font-weight: bold;"}`) }, L(n.label), 5), ((F = v == null ? void 0 : v.monomerAndAreaList) == null ? void 0 : F.length) > 0 ? (S(), P(r, { key: 1, width: 300, placement: "right", trigger: "hover" }, { reference: V(() => [m($, { "icon-class": "eye-open", style: { float: "right", color: "#2c2c2c", "margin-right": "5px" } })]), default: V(() => [m(f, { ref: "tableRef", data: v == null ? void 0 : v.monomerAndAreaList, style: { width: "100%" } }, { default: V(() => [m(i, { prop: "monomerName", label: "单体", align: "center" }), m(i, { prop: "areaName", label: "区域", align: "center" })]), _: 2 }, 1032, ["data"])]), _: 2 }, 1024)) : K("", true)])], 4)];
    }), _: 1 }, 8, ["data", "show-checkbox", "default-expanded-keys"])), [[g, A.value]])], 4)], 64);
  };
} }, Je = Ie(Ke, [["__scopeId", "data-v-1ff654f0"]]);
export {
  Je as default
};
