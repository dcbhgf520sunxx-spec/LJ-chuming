import { ref as E } from "vue";
import { inject as he } from "vue";
import { watch as we } from "vue";
import { resolveComponent as se } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as le } from "vue";
import { vShow as ie } from "vue";
import { createElementVNode as c } from "vue";
import { normalizeStyle as ge } from "vue";
import { unref as e } from "vue";
import { Fragment as pe } from "vue";
import { renderList as ue } from "vue";
import { createVNode as o } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as v } from "vue";
import { createBlock as q } from "vue";
import { ElTag as ve } from "element-plus";
import { BellFilled as ke } from "@element-plus/icons-vue";
import { ElIcon as Te } from "element-plus";
import { ElTableColumn as be } from "element-plus";
import { ElProgress as Ie } from "element-plus";
import { ElPagination as xe } from "element-plus";
import { p as Le, s as Ee, a as Ce, _ as Ve } from "../production-line-detail/index.vue.js";
import { _ as qe, a3 as p, J as Ae, aU as W, o as Ne, cg as D, bo as M, D as A, G as Se } from "../../../../../../shared/runtime.js";
const Oe = { class: "app-container" }, Pe = { class: "my-code" }, Re = { key: 0, class: "head-container" }, De = { style: { "margin-left": "8px", "font-size": "14px" } }, Fe = { class: "tc-primary" }, We = { key: 0, class: "head-container" }, Me = { style: { "margin-left": "8px", "font-size": "14px" } }, je = { class: "tc-primary" }, ze = { key: 0, style: { "margin-bottom": "20px" } }, Ke = { key: 0, class: "head-container" }, Qe = { style: { "margin-left": "8px", "font-size": "14px" } }, Ge = { key: 0, style: { color: "red" } }, Be = { key: 1 }, He = { __name: "index", props: { processList: { type: Object, default: () => {
} }, weightStatus: { type: Number }, query: { type: Object }, permission: { type: Object, default: () => {
} } }, setup(C) {
  const j = { [p.ARTIFACT.K]: "success", [p.ASSEMBLE.K]: "warning", [p.MACHINE_PART.K]: "" }, s = C, z = E(), H = E({}), d = E([]), K = E([]), Q = E(false), N = E(), S = E(), L = he("productType");
  we(() => s.processList, (f) => {
    f && (L.value === p.ARTIFACT.V ? (N.value = void 0, S.value = void 0, Y()) : (N.value = void 0, S.value = void 0, fe()));
  }, { deep: true });
  const { handleSizeChange: ce, handleCurrentChange: de, total: ye, setTotalPage: me, queryPage: G } = Ae({ fetchHook: Y });
  async function Y() {
    var f, g, y, T, k, O, r, P;
    if (d.value = [], !!((f = s.processList) != null && f.taskOrderId)) try {
      const m = await Le({ topTaskOrderId: s.processList.taskOrderId, workshopId: N.value, productionLineId: S.value, projectId: (g = s.query) == null ? void 0 : g.projectId, monomerId: (y = s.query) == null ? void 0 : y.monomerId, areaId: (T = s.query) == null ? void 0 : T.areaId });
      if (((k = s.processList) == null ? void 0 : k.productionLineTypeEnum) === W.INTELLECT.V) {
        const { content: B = [], totalElements: F } = await Ee({ topTaskOrderId: s.processList.taskOrderId, workshopId: N.value, productionLineId: S.value, projectId: (O = s.query) == null ? void 0 : O.projectId, monomerId: (r = s.query) == null ? void 0 : r.monomerId, areaId: (P = s.query) == null ? void 0 : P.areaId, ...G });
        d.value = B || [], me(F);
      } else d.value = m == null ? void 0 : m.artifactList;
      K.value = (m == null ? void 0 : m.assembleList) || [], console.log(K.value, "assembleProcessDataassembleProcessDataassembleProcessData");
    } catch (m) {
      console.log("获取构件部件工序进度", m);
    }
  }
  async function fe() {
    var f, g, y, T;
    if (d.value = [], !!((f = s.processList) != null && f.taskOrderId)) try {
      const k = await Ce({ productType: L.value, topTaskOrderId: s.processList.taskOrderId, workshopId: N.value, productionLineId: S.value, projectId: (g = s.query) == null ? void 0 : g.projectId, monomerId: (y = s.query) == null ? void 0 : y.monomerId, areaId: (T = s.query) == null ? void 0 : T.areaId });
      d.value = k || [];
    } catch (k) {
      console.log("获取零件工序进度", k);
    }
  }
  const { maxHeight: _e } = Ne({ extraBox: [".head-container"], paginate: true });
  function U(f) {
    Se(s.permission.processDetail) && (Q.value = true, H.value = f, console.log(f, "row1"));
  }
  return (f, g) => {
    var F, $, J, X, Z, ee, te, oe, ae, re;
    const y = ve, T = ke, k = Te, O = se("table-cell-tag"), r = be, P = Ie, m = se("common-table"), B = xe;
    return u(), w("div", Oe, [le(c("div", Pe, "*点击左侧表格行查看详情", 512), [[ie, !((F = s.processList) != null && F.taskOrderId)]]), le(c("div", null, [g[1] || (g[1] = c("div", { class: "head-container" }, null, -1)), c("div", { style: ge(`height: ${e(_e) + 40}px; overflow-y: auto`) }, [(u(true), w(pe, null, ue(K.value, (a) => {
      var b, I, x, R;
      return u(), w("div", { style: { "margin-bottom": "20px" }, key: a }, [e(L) === e(p).ARTIFACT.V && ((b = a[0]) == null ? void 0 : b.productType) === e(p).ASSEMBLE.V ? (u(), w("div", Re, [o(y, { effect: "dark", type: j[e(p).VK[(I = a[0]) == null ? void 0 : I.productType]] }, { default: l(() => {
        var n;
        return [V(i(e(p).VL[(n = a[0]) == null ? void 0 : n.productType]), 1)];
      }), _: 2 }, 1032, ["type"]), o(y, { style: { "margin-left": "8px" }, effect: "plain" }, { default: l(() => {
        var n, t, _, h;
        return [V(i((t = (n = a[0]) == null ? void 0 : n.workShop) == null ? void 0 : t.name) + ">" + i((h = (_ = a[0]) == null ? void 0 : _.productionLine) == null ? void 0 : h.name), 1)];
      }), _: 2 }, 1024), c("span", De, "工单号：" + i((x = a[0]) == null ? void 0 : x.orderNumber), 1)])) : v("", true), e(L) === e(p).ARTIFACT.V && ((R = a[0]) == null ? void 0 : R.productType) === e(p).ASSEMBLE.V ? (u(), q(m, { key: 1, ref_for: true, ref_key: "tableRef", ref: z, data: a, "empty-text": "暂无数据", "highlight-current-row": "", style: { width: "100%", cursor: "pointer" }, onRowClick: U }, { default: l(() => [o(r, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "工序" }, { default: l((n) => [n.row.status === e(D).DELAY.V ? (u(), q(k, { key: 0, size: 20, style: { top: "5px", color: "red" } }, { default: l(() => [o(T)]), _: 1 })) : v("", true), o(O, { show: n.row.id === -1, color: "#e64242", name: "特殊" }, null, 8, ["show"]), c("span", null, i(n.row.name), 1)]), _: 1 }), o(r, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "进度", width: "160px" }, { default: l((n) => [o(P, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: (n.row.completeQuantity / n.row.quantity * 100).toFixed(2), status: "success" }, null, 8, ["percentage"])]), _: 1 }), o(r, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "任务（件/kg）" }, { default: l((n) => {
        var t;
        return [c("span", null, i(C.weightStatus === e(M).NET.V ? n.row.quantity + "/" + ((t = n.row.totalNetWeight) == null ? void 0 : t.toFixed(e(A).COM_WT__KG)) : n.row.quantity + "/-"), 1)];
      }), _: 1 }), o(r, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成（件/kg）" }, { default: l((n) => {
        var t;
        return [c("span", Fe, i(C.weightStatus === e(M).NET.V ? n.row.completeQuantity + "/" + ((t = n.row.completeNetWeight) == null ? void 0 : t.toFixed(e(A).COM_WT__KG)) : n.row.completeQuantity + "/-"), 1)];
      }), _: 1 })]), _: 2 }, 1032, ["data"])) : v("", true)]);
    }), 128)), (u(true), w(pe, null, ue(d.value, (a) => {
      var b, I, x, R, n;
      return u(), w("div", { style: { "margin-bottom": "20px" }, key: a }, [((b = a[0]) == null ? void 0 : b.productType) === e(p).ARTIFACT.V ? (u(), w("div", We, [o(y, { effect: "dark", type: j[e(p).VK[(I = a[0]) == null ? void 0 : I.productType]] }, { default: l(() => {
        var t;
        return [V(i(e(p).VL[(t = a[0]) == null ? void 0 : t.productType]), 1)];
      }), _: 2 }, 1032, ["type"]), o(y, { style: { "margin-left": "8px" }, effect: "plain" }, { default: l(() => {
        var t, _, h, ne;
        return [V(i((_ = (t = a[0]) == null ? void 0 : t.workShop) == null ? void 0 : _.name) + ">" + i((ne = (h = a[0]) == null ? void 0 : h.productionLine) == null ? void 0 : ne.name), 1)];
      }), _: 2 }, 1024), c("span", Me, "工单号：" + i((x = a[0]) == null ? void 0 : x.orderNumber), 1)])) : v("", true), e(L) === e(p).ARTIFACT.V && ((R = a[0]) == null ? void 0 : R.productType) === e(p).ARTIFACT.V || e(L) === e(p).MACHINE_PART.V && ((n = a[0]) == null ? void 0 : n.productType) === e(p).MACHINE_PART.V ? (u(), q(m, { key: 1, ref_for: true, ref_key: "tableRef", ref: z, data: a, "empty-text": "暂无数据", "highlight-current-row": "", style: { width: "100%", cursor: "pointer" }, onRowClick: U }, { default: l(() => [o(r, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "工序" }, { default: l((t) => [t.row.status === e(D).DELAY.V ? (u(), q(k, { key: 0, size: 20, style: { top: "5px", color: "red" } }, { default: l(() => [o(T)]), _: 1 })) : v("", true), o(O, { show: t.row.id === -1, color: "#e64242", name: "特殊" }, null, 8, ["show"]), c("span", null, i(t.row.name), 1)]), _: 1 }), e(L) === e(p).MACHINE_PART.V ? (u(), q(r, { align: "center", key: "productType", prop: "productType", "show-overflow-tooltip": true, label: "生产方式" }, { default: l(({ row: t }) => [c("span", null, i(t.partProdModeName || "-"), 1)]), _: 1 })) : v("", true), o(r, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "进度", width: "160px" }, { default: l((t) => [o(P, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: (t.row.completeQuantity / t.row.quantity * 100).toFixed(2), status: "success" }, null, 8, ["percentage"])]), _: 1 }), o(r, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "任务（件/kg）" }, { default: l((t) => {
        var _, h;
        return [c("span", null, i(C.weightStatus === e(M).NET.V ? t.row.quantity + "/" + ((_ = t.row.totalNetWeight) == null ? void 0 : _.toFixed(e(A).COM_WT__KG)) : t.row.quantity + "/" + ((h = t.row.totalGrossWeight) == null ? void 0 : h.toFixed(e(A).COM_WT__KG))), 1)];
      }), _: 1 }), o(r, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成（件/kg）" }, { default: l((t) => {
        var _, h;
        return [c("span", je, i(C.weightStatus === e(M).NET.V ? t.row.completeQuantity + "/" + ((_ = t.row.completeNetWeight) == null ? void 0 : _.toFixed(e(A).COM_WT__KG)) : t.row.completeQuantity + "/" + ((h = t.row.completeGrossWeight) == null ? void 0 : h.toFixed(e(A).COM_WT__KG))), 1)];
      }), _: 1 })]), _: 2 }, 1032, ["data"])) : v("", true)]);
    }), 128)), (($ = s.processList) == null ? void 0 : $.productionLineTypeEnum) === e(W).INTELLECT.V ? (u(), w("div", ze, [((X = (J = d.value[0]) == null ? void 0 : J.productionLine) == null ? void 0 : X.productionLineTypeEnum) === e(W).INTELLECT.V ? (u(), w("div", Ke, [o(y, { effect: "dark", type: j[e(p).VK[(Z = d.value[0]) == null ? void 0 : Z.productType]] }, { default: l(() => {
      var a;
      return [V(i(e(p).VL[(a = d.value[0]) == null ? void 0 : a.productType]), 1)];
    }), _: 1 }, 8, ["type"]), o(y, { style: { "margin-left": "8px" }, effect: "plain" }, { default: l(() => {
      var a, b, I, x;
      return [V(i((b = (a = d.value[0]) == null ? void 0 : a.workShop) == null ? void 0 : b.name) + ">" + i((x = (I = d.value[0]) == null ? void 0 : I.productionLine) == null ? void 0 : x.name), 1)];
    }), _: 1 }), c("span", Qe, "工单号：" + i((te = (ee = d.value[0]) == null ? void 0 : ee.order) == null ? void 0 : te.name), 1)])) : v("", true), o(m, { ref_key: "tableRef", ref: z, data: d.value, "empty-text": "暂无数据", maxHeight: "480", "highlight-current-row": "", style: { width: "100%", cursor: "pointer" } }, { default: l(() => [o(r, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), o(r, { align: "center", key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", width: "140px" }), o(r, { align: "center", key: "area.name", prop: "area.name", "show-overflow-tooltip": true, label: "区域", width: "140px" }), o(r, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" }), o(r, { align: "center", key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", width: "140px" }), o(r, { "header-align": "center", key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", width: "140px" }), o(r, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量" }), o(r, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成数" }), o(r, { align: "center", key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单净重" }), o(r, { align: "center", key: "grossWeight", prop: "grossWeight", "show-overflow-tooltip": true, label: "单毛重" }), s.processList.productionLineTypeEnum === e(W).TRADITION.V ? (u(), q(r, { align: "center", key: "status", prop: "status", "show-overflow-tooltip": true, label: "状态", fixed: "right" }, { default: l(({ row: a }) => [a.status === e(D).DELAY.V ? (u(), w("span", Ge, i(e(D).VL[a.status]), 1)) : (u(), w("span", Be, i(e(D).VL[a.status]), 1))]), _: 1 })) : v("", true)]), _: 1 }, 8, ["data"]), o(B, { total: e(ye), "current-page": e(G).pageNumber, "page-size": e(G).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: e(ce), onCurrentChange: e(de) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])) : v("", true)], 4)], 512), [[ie, (oe = s.processList) == null ? void 0 : oe.taskOrderId]]), o(Ve, { "project-id": (re = (ae = C.processList) == null ? void 0 : ae.project) == null ? void 0 : re.id, visible: Q.value, "onUpdate:visible": g[0] || (g[0] = (a) => Q.value = a), "detail-data": H.value, query: s.query }, null, 8, ["project-id", "visible", "detail-data", "query"])]);
  };
} }, Xe = qe(He, [["__scopeId", "data-v-fbed7784"]]);
export {
  Xe as default
};
