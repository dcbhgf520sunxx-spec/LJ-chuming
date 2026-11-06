import { ref as u } from "vue";
import { inject as We } from "vue";
import { computed as fe } from "vue";
import { watch as B } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as Pe } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as b } from "vue";
import { withCtx as r } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as y } from "vue";
import { withDirectives as M } from "vue";
import { createTextVNode as E } from "vue";
import { vShow as Be } from "vue";
import { unref as m } from "vue";
import { createElementBlock as ve } from "vue";
import { Fragment as $e } from "vue";
import { renderList as Fe } from "vue";
import { normalizeStyle as ge } from "vue";
import { createCommentVNode as Q } from "vue";
import { withKeys as qe } from "vue";
import { withModifiers as he } from "vue";
import { isRef as Ge } from "vue";
import { ElMessage as te } from "element-plus";
import { ElTag as Ye } from "element-plus";
import { ElProgress as Ke } from "element-plus";
import { ElInput as Je } from "element-plus";
import { ElTooltip as Xe } from "element-plus";
import { ElTableColumn as Ze } from "element-plus";
import { vLoading as et } from "element-plus";
import { i as tt, j as at, r as lt, k as nt, l as st, m as it, n as ot, o as ut } from "../../../../../modules/artifact-f1b0ca44.js";
import { _ as rt, u as dt, qt as V, qu as ye, o as ct, qs as H, bW as _e, es as mt, aU as ae } from "../../../../../shared/runtime.js";
import pt from "./edit-form.vue.js";
import ft from "./batch-edit-form.vue.js";
import vt from "./del-form.vue.js";
import gt from "./batch-del-form.vue.js";
import ht from "./assemble-scheduling-form.vue.js";
import yt from "../../common/group-header.vue.js";
import "../../../../../modules/use-scheduling-line-f234c58c.js";
import "../../../../../modules/common-a5dc7899.js";
import "./handle-surplus-assemble-dialog.vue.js";
const _t = { class: "wrap" }, bt = { class: "wrap-left" }, It = { class: "wrap-left-item" }, wt = { style: { flex: "1", "overflow-y": "auto", height: "750px" } }, Tt = { style: { display: "flex", "justify-content": "space-between", "align-items": "center" } }, Vt = { style: { "font-size": "12px", color: "#000" } }, Ct = { style: { color: "#000" } }, Et = { class: "wrap-right" }, Nt = { class: "head-container" }, kt = { style: { display: "flex", "align-items": "center" } }, Lt = { class: "filter-item" }, Dt = { style: { float: "right", "margin-right": "5px" } }, xt = { __name: "preview-summary-detail", props: { visible: { type: Boolean, default: false }, otherQuery: { type: Object, default: () => {
} }, monomerDetail: { type: Object, default: () => {
} }, projectId: String }, emits: ["update:visible", "refresh"], setup(le, { emit: be }) {
  const ne = u(), $ = u(), se = u(), g = u([]), F = be, I = le, p = { SCHEDULING: { K: "SCHEDULING", L: "排产模式", V: 1 }, EDIT: { K: "EDIT", L: "编辑模式", V: 2 } }, f = u(p.SCHEDULING.V), { visible: j, handleClose: Ie } = dt({ emit: F, props: I, field: "visible", showHook: Le, closeHook: xe });
  async function O() {
    t.value.structureClassId = void 0, t.value.artName = void 0;
    const a = t.value.productionLineType === V.TYPE.V ? it : ot, { content: e } = await a({ ...Ce.value });
    g.value = e.map((s) => (s.hasAngle = s.artifactType === mt.SMALL.V, s)), Ne();
  }
  const we = We("areaIdObj"), Te = u([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), Ve = fe(() => {
    var a, e;
    return ((e = (a = I.otherQuery) == null ? void 0 : a.areaIdList) == null ? void 0 : e.map((s) => we.value[s].name).join("、")) || "";
  }), w = u([]), q = u(false), x = u({}), U = u({}), t = u({ productionLineType: V.TYPE.V, areaType: ye.HOMEMADE.V }), ie = u(false), oe = u([]), ue = u(false), W = u([]), re = u(), G = u(), Ce = fe(() => ({ areaIdList: I.otherQuery.areaIdList })), { maxHeight: Ee } = ct({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: false, clientHRepMainH: true }, ne);
  B([() => t.value.productionLineType], () => {
    t.value.productionLineType === V.TYPE.V ? t.value.artName = void 0 : t.value.structureClassId = void 0, O(), z();
  }, { deep: true }), B([() => t.value.structureClassId, () => t.value.artName], () => {
    z(), L();
  }, { deep: true }), B([() => t.value.productionLineId], (a) => {
    a && L();
  }, { deep: true }), B(() => j.value, () => {
    j.value && O();
  }, { deep: true });
  async function z() {
    var e, s;
    const a = I.otherQuery.areaIdList;
    try {
      const { content: l } = await tt({ areaIdList: a, structureClassId: t.value.structureClassId, artName: t.value.artName });
      W.value = l || [], l != null && l.length && (t.value.productionLineId = (s = (e = l[0]) == null ? void 0 : e.productionLine) == null ? void 0 : s.id);
    } catch (l) {
      console.log("获取生产组信息失败", l);
    }
  }
  async function Y() {
    const a = I.otherQuery.areaIdList;
    if (t.value.productionLineTypeEnum = void 0, oe.value = [], ue.value = false, w.value = [], x.value = {}, U.value = {}, !!(a != null && a.length)) try {
      const { content: e } = await ut({ areaIdList: a });
      for (const s in ae.ENUM) e.indexOf(ae[s].V) === -1 && oe.value.push(ae[s].V);
    } catch {
      console.log("获取产线类型失败");
    } finally {
      ue.value = true;
    }
  }
  function Ne() {
    var a, e, s, l, o, v, C;
    (!((a = g.value) != null && a.length) || t.value.structureClassId && ((e = g.value) != null && e.length) && g.value.findIndex((T) => T.structureClassId === t.value.structureClassId) === -1) && (t.value.structureClassId = void 0), (!((s = g.value) != null && s.length) || t.value.artName && ((l = g.value) != null && l.length) && g.value.findIndex((T) => T.name === t.value.artName) === -1) && (t.value.artName = void 0), (o = g.value) != null && o.length && (t.value.productionLineType === V.TYPE.V ? t.value.structureClassId = f.value === p.EDIT.V ? (v = g.value[0]) == null ? void 0 : v.structureClassId : void 0 : t.value.artName = f.value === p.EDIT.V ? (C = g.value[0]) == null ? void 0 : C.name : void 0), L();
  }
  function ke() {
    var a, e, s;
    (a = $.value) == null || a.clearSelection(), t.value.productionLineType === V.TYPE.V ? t.value.structureClassId = f.value === p.EDIT.V ? (e = g.value[0]) == null ? void 0 : e.structureClassId : void 0 : t.value.artName = f.value === p.EDIT.V ? (s = g.value[0]) == null ? void 0 : s.name : void 0;
  }
  function Le() {
    var a;
    z(), De(), Y(), (a = $.value) == null || a.clearSelection(), de();
  }
  async function De() {
    try {
      const { teamScheduledInfo: a, totalScheduledWeight: e } = await at({ projectId: I.projectId });
      re.value = a, G.value = e;
    } catch (a) {
      console.log(a);
    }
  }
  function xe() {
    ie.value && F("refresh");
  }
  function de() {
    var a, e, s, l;
    t.value.serialNumber = void 0, t.value.productionLineId = (e = (a = W.value[0]) == null ? void 0 : a.productionLine) == null ? void 0 : e.id, t.value.productionLineType === V.TYPE.V ? t.value.structureClassId = f.value === p.EDIT.V ? (s = g.value[0]) == null ? void 0 : s.structureClassId : void 0 : t.value.artName = f.value === p.EDIT.V ? (l = g.value[0]) == null ? void 0 : l.name : void 0, L();
  }
  async function L() {
    var a, e;
    w.value = [], x.value = {}, U.value = {};
    try {
      q.value = true, U.value = await lt({ ...I.otherQuery, ...t.value }) || {};
      const l = t.value.productionLineType === V.TYPE.V ? await nt({ ...I.otherQuery, ...t.value }) : await st({ ...I.otherQuery, ...t.value }) || [];
      let o = 0, v = 0, C = 0, T = 0;
      for (let c = 0; c < l.length; c++) {
        const h = (a = l[c].productionLine) == null ? void 0 : a.id;
        c === 0 && (v++, C += l[c].schedulingQuantity, T += l[c].schedulingTotalNetWeight), c > 0 && (h === ((e = l[c - 1].productionLine) == null ? void 0 : e.id) ? (v++, C += l[c].schedulingQuantity, T += l[c].schedulingTotalNetWeight, l[o].rowspan = 0) : (l[o].rowspan = v, l[o].mergeQuantity = C, l[o].mergeWeight = T.toFixed(2), v = 1, C = l[c].schedulingQuantity, T = l[c].schedulingTotalNetWeight, o = c)), c === l.length - 1 && (l[o].rowspan = v, l[o].mergeQuantity = C, l[o].mergeWeight = T.toFixed(2)), l[c].mergeIndex = o, l[c].needSchedulingQuantity = l[c].schedulingQuantity, l[c].groupCheck = false, l[c].isIndeterminateCheck = false, x.value[h] || (x.value[h] = []), x.value[h].push(l[c].id);
      }
      w.value = l;
    } catch (s) {
      console.log("获取构件排产预览记录失败", s);
    } finally {
      q.value = false;
    }
  }
  function Se(a, e) {
    var s, l, o, v;
    return f.value === p.EDIT.V && (s = N.value) != null && s.length ? ((l = a.productionLine) == null ? void 0 : l.id) === ((v = (o = N.value[0]) == null ? void 0 : o.productionLine) == null ? void 0 : v.id) : true;
  }
  const P = u({}), N = u([]);
  function Qe(a) {
    if (a.length) for (const e in x.value) {
      const s = Number(e), l = Array.from(new Set(x.value[e])).length, o = a.filter((v) => v.productionLine.id === s);
      if (o.length) {
        const v = o[0].mergeIndex;
        w.value[v].isIndeterminateCheck = o.length > 0 && o.length < l, w.value[v].groupCheck = o.length > 0 && o.length === l;
      }
    }
    else for (let e = 0; e < w.value.length; e++) {
      const s = w.value[e];
      s.isIndeterminateCheck = false, s.groupCheck = false;
    }
    N.value = a;
  }
  const K = u(false), J = u(false);
  function Ue(a) {
    P.value = Object.assign({}, a), K.value = true;
  }
  function Me() {
    var a;
    if (!((a = N.value) != null && a.length)) {
      te.warning("请至少选择一条数据");
      return;
    }
    J.value = true;
  }
  const X = u(false), Z = u(false);
  function ce() {
    Y(), z(), O(), ie.value = true;
  }
  function me() {
    L(), O();
  }
  function je(a) {
    P.value = Object.assign({}, a), X.value = true;
  }
  function ze() {
    var a;
    if (!((a = N.value) != null && a.length)) {
      te.warning("请至少选择一条数据");
      return;
    }
    Z.value = true;
  }
  const ee = u(false);
  function Ae() {
    var a;
    if (f.value === p.EDIT.V && !((a = N.value) != null && a.length)) {
      te.warning("请至少选择一条数据");
      return;
    }
    ee.value = true;
  }
  function pe() {
    Y(), z(), F("refresh");
  }
  return (a, e) => {
    const s = Ye, l = R("common-button"), o = Ke, v = R("common-select"), C = Je, T = R("common-radio-button"), c = Xe, h = Ze, Re = R("common-table"), He = R("common-drawer"), A = Pe("permission"), Oe = et;
    return _(), b(He, { ref_key: "drawerRef", ref: ne, modelValue: m(j), "onUpdate:modelValue": e[12] || (e[12] = (S) => Ge(j) ? j.value = S : null), "before-close": m(Ie), title: "构件排产预览", direction: "rtl", size: "100%" }, { titleAfter: r(() => [i(s, { size: "default" }, { default: r(() => {
      var S, n, k, D;
      return [e[13] || (e[13] = d("span", null, "当前单体：", -1)), d("span", null, y(I.monomerDetail ? (n = (S = I.monomerDetail) == null ? void 0 : S.monomer) == null ? void 0 : n.name : (D = (k = w.value[0]) == null ? void 0 : k.monomer) == null ? void 0 : D.name), 1)];
    }), _: 1, __: [13] }), i(s, { size: "default" }, { default: r(() => [e[14] || (e[14] = d("span", null, "当前区域：", -1)), d("span", null, y(Ve.value), 1)]), _: 1, __: [14] })]), titleRight: r(() => [M((_(), b(l, { disabled: w.value.length < 1, size: "default", type: "success", onClick: Ae }, { default: r(() => e[15] || (e[15] = [E(" 下一步【部件排产】 ")])), _: 1, __: [15] }, 8, ["disabled"])), [[Be, f.value === p.SCHEDULING.V], [A, m(H).assembleGet]])]), content: r(() => {
      var S;
      return [d("div", _t, [d("div", bt, [d("div", It, "已排总量（吨）：" + y((S = G.value) == null ? void 0 : S.toFixed(2)), 1), d("div", wt, [(_(true), ve($e, null, Fe(re.value, (n, k) => (_(), ve("div", { key: k, class: "wrap-left-list" }, [d("div", Tt, [d("span", null, y(`${n.shopName || "-"} > ${n.lineName || "-"}`), 1), d("span", Vt, y(n.scheduledQuantity) + "件", 1)]), i(o, { percentage: n.scheduledWeight / G.value * 100, "stroke-width": 15, "text-inside": true, status: "dashboard" }, { default: r(() => {
        var D;
        return [d("span", Ct, y((D = n.scheduledWeight) == null ? void 0 : D.toFixed(2)) + "吨", 1)];
      }), _: 2 }, 1032, ["percentage"])]))), 128))])]), d("div", Et, [d("div", Nt, [i(yt, { modelValue: t.value.productionLineId, "onUpdate:modelValue": e[0] || (e[0] = (n) => t.value.productionLineId = n), data: W.value, onTaskIssueSuccess: pe }, null, 8, ["modelValue", "data"]), d("div", kt, [i(v, { modelValue: t.value.productionLineType, "onUpdate:modelValue": e[1] || (e[1] = (n) => t.value.productionLineType = n), options: m(V).ENUM, size: "default", type: "enum", class: "filter-item", style: { width: "80px" }, unshowOptions: [m(V).NAME.K], onChange: L }, null, 8, ["modelValue", "options", "unshowOptions"]), i(v, { modelValue: t.value.areaType, "onUpdate:modelValue": e[2] || (e[2] = (n) => t.value.areaType = n), options: m(ye).ENUM, type: "enum", size: "default", placeholder: "自制或外协", class: "filter-item", style: { width: "80px" } }, null, 8, ["modelValue", "options"]), g.value.length && t.value.productionLineType === m(V).TYPE.V ? (_(), b(m(_e), { key: 0, ref_key: "tagTabsRef", ref: se, modelValue: t.value.structureClassId, "onUpdate:modelValue": e[3] || (e[3] = (n) => t.value.structureClassId = n), data: g.value, hit: f.value === p.EDIT.V, style: ge(["width:calc(100% - 150px)", { display: "inline-block" }]), unselectable: f.value !== p.EDIT.V, class: "filter-item", itemKey: "structureClassId" }, { default: r(({ item: n }) => [d("span", null, y(n.name) + "：", 1), d("span", null, y(n.quantity) + "件", 1)]), _: 1 }, 8, ["modelValue", "data", "hit", "unselectable"])) : Q("", true), g.value.length && t.value.productionLineType === m(V).NAME.V ? (_(), b(m(_e), { key: 1, ref_key: "tagTabsRef", ref: se, modelValue: t.value.artName, "onUpdate:modelValue": e[4] || (e[4] = (n) => t.value.artName = n), data: g.value, hit: f.value === p.EDIT.V, style: ge(["width:calc(100% - 150px)", { display: "inline-block" }]), unselectable: f.value !== p.EDIT.V, class: "filter-item", itemKey: "name" }, { default: r(({ item: n }) => [d("span", null, y(n.name) + "：", 1), d("span", null, y(n.quantity) + "件", 1)]), _: 1 }, 8, ["modelValue", "data", "hit", "unselectable"])) : Q("", true)]), i(C, { modelValue: t.value.serialNumber, "onUpdate:modelValue": e[5] || (e[5] = (n) => t.value.serialNumber = n), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: qe(L, ["enter"]) }, null, 8, ["modelValue"]), i(l, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: he(L, ["stop"]) }, { default: r(() => e[16] || (e[16] = [E("搜索")])), _: 1, __: [16] }), i(l, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: he(de, ["stop"]) }, { default: r(() => e[17] || (e[17] = [E(" 重置 ")])), _: 1, __: [17] }), i(T, { modelValue: f.value, "onUpdate:modelValue": e[6] || (e[6] = (n) => f.value = n), size: "default", options: p, class: "filter-item", type: "enum", onChange: ke }, null, 8, ["modelValue"]), d("span", Lt, [i(s, { size: "large", effect: "plain", style: { "margin-left": "5px" } }, { default: r(() => [E(" 数量(件)：" + y(U.value.quantity || 0), 1)]), _: 1 }), i(s, { size: "large", effect: "plain", style: { "margin-left": "5px" } }, { default: r(() => {
        var n;
        return [E(" 重量(kg)：" + y(((n = U.value.totalNetWeight) == null ? void 0 : n.toFixed(2)) || 0), 1)];
      }), _: 1 })]), f.value === p.EDIT.V ? M((_(), b(l, { key: 0, size: "default", style: { float: "right" }, type: "danger", onClick: ze }, { default: r(() => e[18] || (e[18] = [E(" 批量删除 ")])), _: 1, __: [18] })), [[A, m(H).recordDel]]) : Q("", true), i(c, { disabled: !!t.value.structureClassId && !!t.value.artName, class: "item", content: "请选择构件类型", effect: "light", placement: "left" }, { default: r(() => [d("span", Dt, [f.value === p.EDIT.V ? M((_(), b(l, { key: 0, size: "default", type: "primary", onClick: Me }, { default: r(() => e[19] || (e[19] = [E(" 批量重新分配 ")])), _: 1, __: [19] })), [[A, m(H).recordEdit]]) : Q("", true)])]), _: 1 }, 8, ["disabled"])]), M((_(), b(Re, { ref_key: "recordTableRef", ref: $, data: w.value, "data-format": Te.value, "max-height": m(Ee), stripe: false, "row-key": "id", style: { width: "100%" }, onSelectionChange: Qe }, { default: r(() => [f.value === p.EDIT.V ? (_(), b(h, { key: 0, selectable: Se, align: "center", class: "selection", type: "selection", width: "55" })) : Q("", true), i(h, { align: "center", label: "序号", type: "index", width: "60" }), i(h, { "show-overflow-tooltip": true, align: "center", label: "单体/区域", prop: "monomer", width: "200px" }, { default: r(({ row: n }) => [d("span", null, y(`${n.monomer.name} / ${n.area.name}`), 1)]), _: 1 }), i(h, { "show-overflow-tooltip": true, align: "center", label: "类型", "min-width": "100", prop: "structureClass" }, { default: r(({ row: n }) => {
        var k;
        return [(k = n.structureClass) != null && k.name ? (_(), b(s, { key: 0 }, { default: r(() => {
          var D;
          return [E(y((D = n.structureClass) == null ? void 0 : D.name), 1)];
        }), _: 2 }, 1024)) : Q("", true)];
      }), _: 1 }), i(h, { "show-overflow-tooltip": true, align: "center", label: "编号", "min-width": "100", prop: "serialNumber" }, { default: r(({ row: n }) => [d("span", null, y(n.serialNumber), 1)]), _: 1 }), i(h, { "show-overflow-tooltip": true, align: "center", label: "构件名称", "min-width": "100", prop: "name" }), i(h, { "show-overflow-tooltip": true, align: "center", label: "规格", "min-width": "120", prop: "specification" }), i(h, { "show-overflow-tooltip": true, align: "center", label: "长度（mm）", "min-width": "90", prop: "length" }), i(h, { "show-overflow-tooltip": true, align: "center", label: "数量", "min-width": "90", prop: "schedulingQuantity" }), i(h, { "show-overflow-tooltip": true, align: "center", label: "总重（kg）", "min-width": "90", prop: "schedulingTotalNetWeight" }), i(h, { "show-overflow-tooltip": true, align: "center", label: "完成日期", "min-width": "90", prop: "askCompleteTime" }), f.value === p.EDIT.V ? (_(), b(h, { key: 1, align: "center", label: "操作", width: "200" }, { default: r(({ row: n }) => [M((_(), b(l, { size: "default", type: "primary", onClick: (k) => Ue(n) }, { default: r(() => e[20] || (e[20] = [E("重新分配")])), _: 2, __: [20] }, 1032, ["onClick"])), [[A, m(H).recordEdit]]), M((_(), b(l, { size: "default", type: "danger", onClick: (k) => je(n) }, { default: r(() => e[21] || (e[21] = [E("删除任务")])), _: 2, __: [21] }, 1032, ["onClick"])), [[A, m(H).recordDel]])]), _: 1 })) : Q("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[Oe, q.value]]), i(m(pt), { visible: K.value, "onUpdate:visible": e[7] || (e[7] = (n) => K.value = n), artName: t.value.artName, itemInfo: P.value, selections: N.value, structureClassId: t.value.structureClassId, onRefresh: me }, null, 8, ["visible", "artName", "itemInfo", "selections", "structureClassId"]), i(m(ft), { visible: J.value, "onUpdate:visible": e[8] || (e[8] = (n) => J.value = n), artName: t.value.artName, selections: N.value, structureClassId: t.value.structureClassId, onRefresh: me }, null, 8, ["visible", "artName", "selections", "structureClassId"]), i(m(vt), { visible: X.value, "onUpdate:visible": e[9] || (e[9] = (n) => X.value = n), itemInfo: P.value, onDelSuccess: ce }, null, 8, ["visible", "itemInfo"]), i(m(gt), { visible: Z.value, "onUpdate:visible": e[10] || (e[10] = (n) => Z.value = n), selections: N.value, onDelSuccess: ce }, null, 8, ["visible", "selections"]), i(m(ht), { visible: ee.value, "onUpdate:visible": e[11] || (e[11] = (n) => ee.value = n), "artifact-list": w.value, groupData: W.value, projectId: le.projectId, minAskCompleteTime: U.value.minAskCompleteTime, onTaskIssueSuccess: pe }, null, 8, ["visible", "artifact-list", "groupData", "projectId", "minAskCompleteTime"])])])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, $t = rt(xt, [["__scopeId", "data-v-8f505914"]]);
export {
  $t as default
};
