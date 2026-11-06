import { ref as L } from "vue";
import { inject as we } from "vue";
import { computed as ve } from "vue";
import { watch as ke } from "vue";
import { resolveComponent as ne } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as y } from "vue";
import { withDirectives as se } from "vue";
import { vShow as ie } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { normalizeStyle as Le } from "vue";
import { Fragment as pe } from "vue";
import { renderList as ue } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as T } from "vue";
import { toDisplayString as a } from "vue";
import { createCommentVNode as x } from "vue";
import { createBlock as B } from "vue";
import { ElTag as xe } from "element-plus";
import { ElIcon as be } from "element-plus";
import { ElTableColumn as Te } from "element-plus";
import { ElProgress as Ve } from "element-plus";
import { BellFilled as Ce } from "@element-plus/icons-vue";
import { ElPagination as Ee } from "element-plus";
import { p as Ie, s as Oe, a as Be, _ as Pe } from "../production-line-detail/index.vue.js";
import { _ as Ne, F as r, J as qe, aU as M, o as ze, aV as De, cg as I, D as P } from "../../../../../shared/runtime.js";
import { _ as Re } from "../../../../../modules/production-line-select-307387f7.js";
import "../../../../../modules/bridge-86f96a4f.js";
const Fe = { class: "app-container" }, Ke = { class: "my-code" }, Me = { class: "head-container" }, Qe = { key: 0, class: "head-container" }, Ae = { style: { "margin-left": "8px", "font-size": "14px" } }, Xe = { key: 0, class: "head-container" }, Se = { style: { "margin-left": "8px", "font-size": "14px" } }, He = { key: 0, style: { "margin-bottom": "20px" } }, je = { key: 0, class: "head-container" }, Ge = { style: { "margin-left": "8px", "font-size": "14px" } }, We = { key: 0, style: { color: "red" } }, Ue = { key: 1 }, $e = { __name: "index", props: { processList: { type: Object, default: () => {
} } }, setup(Q) {
  const N = { [r.BOX.K]: "success", [r.CELL.K]: "warning", [r.MACHINE_PART.K]: "" }, _ = Q, q = L(), A = L({}), d = L([]), X = L([]), z = L(false), h = L(), b = L(), S = L(), m = we("productType"), ce = ve(() => m.value === r.BOX.V ? m.value | r.CELL.V : m.value);
  ke(() => _.processList, (g) => {
    g && (m.value === r.BOX.V ? (h.value = void 0, b.value = void 0, R()) : (h.value = void 0, b.value = void 0, H()));
  }, { deep: true });
  const { handleSizeChange: de, handleCurrentChange: fe, total: ye, setTotalPage: _e, queryPage: D } = qe({ fetchHook: R });
  async function R() {
    var g, p;
    if (d.value = [], !!((g = _.processList) != null && g.taskOrderId)) try {
      const u = await Ie({ topTaskOrderId: _.processList.taskOrderId, workshopId: h.value, productionLineId: b.value });
      if (((p = _.processList) == null ? void 0 : p.productionLineTypeEnum) === M.INTELLECT.V) {
        const { content: F = [], totalElements: O } = await Oe({ topTaskOrderId: _.processList.taskOrderId, workshopId: h.value, productionLineId: b.value, ...D });
        d.value = F || [], _e(O);
      } else d.value = u == null ? void 0 : u.boxList;
      X.value = (u == null ? void 0 : u.elementList) || [];
    } catch (u) {
      console.log("获取分段单元件工序进度", u);
    }
  }
  async function H() {
    var g;
    if (d.value = [], !!((g = _.processList) != null && g.taskOrderId)) try {
      const p = await Be({ productType: m.value, topTaskOrderId: _.processList.taskOrderId, workshopId: h.value, productionLineId: b.value });
      d.value = p || [];
    } catch (p) {
      console.log("获取零件工序进度", p);
    }
  }
  function j() {
    m.value === r.BOX.V ? R() : H();
  }
  const { maxHeight: me } = ze({ extraBox: [".head-container"], paginate: true });
  function G(g) {
    z.value = true, A.value = g;
  }
  return (g, p) => {
    var U, $, Y, J, Z, ee, te, oe, ae, re;
    const u = xe, F = ne("BellFilled"), O = be, i = Te, W = Ve, K = ne("common-table"), ge = Ce, he = Ee;
    return c(), y("div", Fe, [se(f("div", Ke, "*点击左侧表格行查看详情", 512), [[ie, !((U = _.processList) != null && U.taskOrderId)]]), se(f("div", null, [f("div", Me, [o(e(De), { ref: "workshopInfRef", modelValue: h.value, "onUpdate:modelValue": p[0] || (p[0] = (t) => h.value = t), placeholder: "请选择车间", "factory-id": S.value, style: { width: "200px" }, class: "filter-item", clearable: "", onChange: j }, null, 8, ["modelValue", "factory-id"]), o(e(Re), { ref: "productionLineRef", class: "filter-item", modelValue: b.value, "onUpdate:modelValue": p[1] || (p[1] = (t) => b.value = t), "factory-id": S.value, "workshop-id": h.value, productType: ce.value, placeholder: "请选择生产线", style: { width: "200px" }, clearable: "", onChange: j }, null, 8, ["modelValue", "factory-id", "workshop-id", "productType"])]), f("div", { style: Le(`height: ${e(me) + 40}px; overflow-y: auto;`) }, [(c(true), y(pe, null, ue(X.value, (t) => {
      var w, v, k, V;
      return c(), y("div", { style: { "margin-bottom": "20px" }, key: t }, [e(m) === e(r).BOX.V && ((w = t[0]) == null ? void 0 : w.productType) === e(r).CELL.V ? (c(), y("div", Qe, [o(u, { effect: "dark", type: N[e(r).VK[(v = t[0]) == null ? void 0 : v.productType]] }, { default: s(() => {
        var l;
        return [T(a(e(r).VL[(l = t[0]) == null ? void 0 : l.productType]), 1)];
      }), _: 2 }, 1032, ["type"]), o(u, { style: { "margin-left": "8px" }, effect: "plain" }, { default: s(() => {
        var l, n, C, E;
        return [T(a((n = (l = t[0]) == null ? void 0 : l.productionLine) == null ? void 0 : n.name) + ">" + a((E = (C = t[0]) == null ? void 0 : C.group) == null ? void 0 : E.name), 1)];
      }), _: 2 }, 1024), f("span", Ae, "工单号：" + a((k = t[0]) == null ? void 0 : k.orderNumber), 1)])) : x("", true), e(m) === e(r).BOX.V && ((V = t[0]) == null ? void 0 : V.productType) === e(r).CELL.V ? (c(), B(K, { key: 1, ref_for: true, ref_key: "tableRef", ref: q, data: t, "empty-text": "暂无数据", "highlight-current-row": "", style: { width: "100%", cursor: "pointer" }, onRowClick: G }, { default: s(() => [o(i, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "工序" }, { default: s((l) => [l.row.status === e(I).DELAY.V ? (c(), B(O, { key: 0, size: 20, style: { top: "5px", color: "red" } }, { default: s(() => [o(F)]), _: 1 })) : x("", true), f("span", null, a(l.row.name), 1)]), _: 1 }), o(i, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "进度", width: "160px" }, { default: s((l) => [o(W, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: (l.row.completeQuantity / l.row.quantity * 100).toFixed(2), status: "success" }, null, 8, ["percentage"])]), _: 1 }), o(i, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "任务（件/kg）" }, { default: s((l) => [f("span", null, a(l.row.quantity) + "/" + a(l.row.mete.toFixed(e(P).COM_WT__KG)), 1)]), _: 1 }), o(i, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成（件/kg）" }, { default: s((l) => [f("span", null, a(l.row.completeQuantity) + "/" + a(l.row.completeMete.toFixed(e(P).COM_WT__KG)), 1)]), _: 1 })]), _: 2 }, 1032, ["data"])) : x("", true)]);
    }), 128)), (c(true), y(pe, null, ue(d.value, (t) => {
      var w, v, k, V, l;
      return c(), y("div", { style: { "margin-bottom": "20px" }, key: t }, [((w = t[0]) == null ? void 0 : w.productType) === e(r).BOX.V ? (c(), y("div", Xe, [o(u, { effect: "dark", type: N[e(r).VK[(v = t[0]) == null ? void 0 : v.productType]] }, { default: s(() => {
        var n;
        return [T(a(e(r).VL[(n = t[0]) == null ? void 0 : n.productType]), 1)];
      }), _: 2 }, 1032, ["type"]), o(u, { style: { "margin-left": "8px" }, effect: "plain" }, { default: s(() => {
        var n, C, E, le;
        return [T(a((C = (n = t[0]) == null ? void 0 : n.productionLine) == null ? void 0 : C.name) + ">" + a((le = (E = t[0]) == null ? void 0 : E.group) == null ? void 0 : le.name), 1)];
      }), _: 2 }, 1024), f("span", Se, "工单号：" + a((k = t[0]) == null ? void 0 : k.orderNumber), 1)])) : x("", true), e(m) === e(r).BOX.V && ((V = t[0]) == null ? void 0 : V.productType) === e(r).BOX.V || e(m) === e(r).MACHINE_PART.V && ((l = t[0]) == null ? void 0 : l.productType) === e(r).MACHINE_PART.V ? (c(), B(K, { key: 1, ref_for: true, ref_key: "tableRef", ref: q, data: t, "empty-text": "暂无数据", "highlight-current-row": "", style: { width: "100%", cursor: "pointer" }, onRowClick: G }, { default: s(() => [o(i, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "工序" }, { default: s((n) => [n.row.status === e(I).DELAY.V ? (c(), B(O, { key: 0, size: 20, style: { top: "5px", color: "red" } }, { default: s(() => [o(ge)]), _: 1 })) : x("", true), f("span", null, a(n.row.name), 1)]), _: 1 }), o(i, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "进度", width: "160px" }, { default: s((n) => [o(W, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: (n.row.completeQuantity / n.row.quantity * 100).toFixed(2), status: "success" }, null, 8, ["percentage"])]), _: 1 }), o(i, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "任务（件/kg）" }, { default: s((n) => [f("span", null, a(n.row.quantity) + "/" + a(n.row.mete.toFixed(e(P).COM_WT__KG)), 1)]), _: 1 }), o(i, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成（件/kg）" }, { default: s((n) => [f("span", null, a(n.row.completeQuantity) + "/" + a(n.row.completeMete.toFixed(e(P).COM_WT__KG)), 1)]), _: 1 })]), _: 2 }, 1032, ["data"])) : x("", true)]);
    }), 128)), (($ = _.processList) == null ? void 0 : $.productionLineTypeEnum) === e(M).INTELLECT.V ? (c(), y("div", He, [((J = (Y = d.value[0]) == null ? void 0 : Y.productionLine) == null ? void 0 : J.productionLineTypeEnum) === e(M).INTELLECT.V ? (c(), y("div", je, [o(u, { effect: "dark", type: N[e(r).VK[(Z = d.value[0]) == null ? void 0 : Z.productType]] }, { default: s(() => {
      var t;
      return [T(a(e(r).VL[(t = d.value[0]) == null ? void 0 : t.productType]), 1)];
    }), _: 1 }, 8, ["type"]), o(u, { style: { "margin-left": "8px" }, effect: "plain" }, { default: s(() => {
      var t, w, v, k;
      return [T(a((w = (t = d.value[0]) == null ? void 0 : t.productionLine) == null ? void 0 : w.name) + ">" + a((k = (v = d.value[0]) == null ? void 0 : v.groups) == null ? void 0 : k.name), 1)];
    }), _: 1 }), f("span", Ge, "工单号：" + a((te = (ee = d.value[0]) == null ? void 0 : ee.order) == null ? void 0 : te.name), 1)])) : x("", true), o(K, { ref_key: "tableRef", ref: q, data: d.value, "empty-text": "暂无数据", maxHeight: "400", "highlight-current-row": "", style: { width: "100%", cursor: "pointer" } }, { default: s(() => [o(i, { align: "center", key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }), o(i, { align: "center", key: "area.name", prop: "area.name", "show-overflow-tooltip": true, label: "区域" }), o(i, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" }), o(i, { align: "center", key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }), o(i, { "header-align": "center", key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", width: "140px" }), o(i, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量" }), p[3] || (p[3] = T(" /> ")), o(i, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成数" }), o(i, { align: "center", key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "单重" }), o(i, { align: "center", key: "status", prop: "status", "show-overflow-tooltip": true, label: "状态" }, { default: s(({ row: t }) => [t.status === e(I).DELAY.V ? (c(), y("span", We, a(e(I).VL[t.status]), 1)) : (c(), y("span", Ue, a(e(I).VL[t.status]), 1))]), _: 1 })]), _: 1, __: [3] }, 8, ["data"]), o(he, { total: e(ye), "current-page": e(D).pageNumber, "page-size": e(D).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: e(de), onCurrentChange: e(fe) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])) : x("", true)], 4)], 512), [[ie, (oe = _.processList) == null ? void 0 : oe.taskOrderId]]), o(Pe, { "project-id": (re = (ae = Q.processList) == null ? void 0 : ae.project) == null ? void 0 : re.id, visible: z.value, "onUpdate:visible": p[2] || (p[2] = (t) => z.value = t), "detail-data": A.value }, null, 8, ["project-id", "visible", "detail-data"])]);
  };
} }, at = Ne($e, [["__scopeId", "data-v-2f4fae99"]]);
export {
  at as default
};
