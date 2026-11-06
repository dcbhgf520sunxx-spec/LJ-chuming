import { ref as X } from "vue";
import { watch as Y } from "vue";
import { nextTick as Z } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as u } from "vue";
import { unref as r } from "vue";
import { withDirectives as ee } from "vue";
import { createBlock as n } from "vue";
import { withCtx as C } from "vue";
import { createVNode as q } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as c } from "vue";
import { Fragment as R } from "vue";
import { createTextVNode as S } from "vue";
import { normalizeClass as L } from "vue";
import { ElTableColumn as te } from "element-plus";
import { ElProgress as ae } from "element-plus";
import { ElTag as re } from "element-plus";
import { vLoading as le } from "element-plus";
import { c as se } from "../../../../modules/plan-progress-eaf89ead.js";
import { _ as oe, m as ne, x as ie, o as de, bN as O, c7 as m, kM as A, D as v, mw as pe, i as M } from "../../../../shared/runtime.js";
import { H as ue } from "../../../../modules/project-19a12d6b.js";
const ce = { class: "app-container" }, me = { key: 0 }, ye = { key: 0 }, De = { key: 1 }, we = { __name: "index", setup(he) {
  const { globalProjectId: K, globalProject: j } = ne(["globalProjectId", "globalProject"]), G = { add: false, edit: false, del: false, download: false }, H = X(), { crud: I, columns: N, CRUD: B } = ie({ title: "进度状态", sort: ["id.desc"], permission: { ...ue }, optShow: { ...G }, requiredQuery: ["projectId"], crudApi: { ...se }, hasPagination: false }, H), { maxHeight: W } = de({ wrapperBox: ".project-progress", paginate: true, extraHeight: 40 });
  Y(() => K.value, (d) => {
    d && (I.query.projectId = K.value, I.toQuery());
  }, { immediate: true, deep: true });
  function z({ row: d, rowIndex: P }) {
    return d.showType === 1 ? "" : "abnormal-row";
  }
  function Q({ row: d, rowIndex: P }) {
    return d.showType === 1 ? "" : "abnormal-row";
  }
  B.HOOK.beforeRefresh = () => (I.query.projectId = j.value.businessType === O.INSTALLATION.V ? K.value : void 0, !!I.query.projectId), B.HOOK.handleRefresh = (d, P) => {
    var F;
    let o = 1;
    const a = (/* @__PURE__ */ new Date()).getTime();
    P.data.content = (F = P.data) == null ? void 0 : F.map((p) => {
      var $;
      return p.monomerName = p.name, p.areaName = "全部", p.showType = 1, p.showIndex = o++, p.manageAreaList && p.manageAreaList.length > 0 && (($ = p.manageAreaList) == null || $.map((e, t) => (e.id = p.id + " " + e.id, e.areaName = e.name, e.showType = 2, e.showIndex = p.showIndex + "." + (t + 1), e.deepTotalDays = e.deepenStartDate && e.deepenEndDate ? m(e.deepenStartDate, e.deepenEndDate) : 0, e.deepActualDays = e.deepenStartDate && e.deepenEndDate && e.deepenStartDate <= a && e.deepenEndDate <= a ? m(e.deepenStartDate, e.deepenEndDate) : e.deepenStartDate && e.deepenEndDate && e.deepenStartDate <= a && e.deepenEndDate > a ? m(e.deepenStartDate, a) : 0, e.deepVal = { totalDays: e.deepTotalDays, actualDays: e.deepActualDays, dayRate: e.deepTotalDays ? Number((e.deepActualDays / e.deepTotalDays * 100).toFixed(1)) : 0, dayColor: "#1890ff", mete: e.budgetVolume, completedMete: e.deepenMete || 0, meteRate: e.deepenMete && e.budgetVolume ? Number((e.deepenMete / e.budgetVolume * 100).toFixed(1)) : 0, meteColor: "#1890ff", decimal: e.projectPlanProductCategory === A.ARTIFACT.V ? v.COM_WT__KG : v.MES_ENCLOSURE_L__M, unit: e.projectPlanProductCategory === A.ARTIFACT.V ? "t" : "m²" }, e.processTotalDays = e.processStartDate && e.processEndDate ? m(e.processStartDate, e.processEndDate) : 0, e.processActualDays = e.processStartDate && e.processEndDate && e.processStartDate <= a && e.processEndDate <= a ? m(e.processStartDate, e.processEndDate) : e.processStartDate && e.processEndDate && e.processStartDate <= a && e.processEndDate > a ? m(e.processStartDate, a) : 0, e.processVal = { totalDays: e.processTotalDays, actualDays: e.processActualDays, dayRate: e.processTotalDays ? Number((e.processActualDays / e.processTotalDays * 100).toFixed(1)) : 0, dayColor: "#1890ff", mete: e.deepenMete, completedMete: e.produceMete || 0, meteRate: e.produceMete && e.deepenMete ? Number((e.produceMete / e.deepenMete * 100).toFixed(1)) : 0, meteColor: "#1890ff", decimal: e.projectPlanProductCategory === A.ARTIFACT.V ? v.COM_WT__KG : v.MES_ENCLOSURE_L__M, unit: e.projectPlanProductCategory === A.ARTIFACT.V ? "t" : "m²" }, e.shipTotalDays = e.shippedStartDate && e.shippedEndDate ? m(e.shippedStartDate, e.shippedEndDate) : 0, e.shipActualDays = e.shippedStartDate && e.shippedEndDate && e.shippedStartDate <= a && e.shippedEndDate <= a ? m(e.shippedStartDate, e.shippedEndDate) : e.shippedStartDate && e.shippedEndDate && e.shippedStartDate <= a && e.shippedEndDate > a ? m(e.shippedStartDate, a) : 0, e.shipVal = { totalDays: e.shipTotalDays, actualDays: e.shipActualDays, dayRate: e.shipTotalDays ? Number((e.shipActualDays / e.shipTotalDays * 100).toFixed(1)) : 0, dayColor: "#1890ff", mete: e.deepenMete, completedMete: e.shippingMete || 0, meteRate: e.shippingMete && e.deepenMete ? Number((e.shippingMete / e.deepenMete * 100).toFixed(1)) : 0, meteColor: "#1890ff", decimal: e.projectPlanProductCategory === A.ARTIFACT.V ? v.COM_WT__KG : v.MES_ENCLOSURE_L__M, unit: e.projectPlanProductCategory === A.ARTIFACT.V ? "t" : "m²" }, e.installTotalDays = e.installStartDate && e.installEndDate ? m(e.installStartDate, e.installEndDate) : 0, e.installActualDays = e.installStartDate && e.installEndDate && e.installStartDate <= a && e.installEndDate <= a ? m(e.installStartDate, e.installEndDate) : e.installStartDate && e.installEndDate && e.installStartDate <= a && e.installEndDate > a ? m(e.installStartDate, a) : 0, e.installVal = { totalDays: e.installTotalDays, actualDays: e.installActualDays, dayRate: e.installTotalDays ? Number((e.installActualDays / e.installTotalDays * 100).toFixed(1)) : 0, dayColor: "#1890ff", mete: e.deepenMete, completedMete: e.installMete || 0, meteRate: e.installMete && e.deepenMete ? Number((e.installMete / e.deepenMete * 100).toFixed(1)) : 0, meteColor: "#1890ff", decimal: e.projectPlanProductCategory === A.ARTIFACT.V ? v.COM_WT__KG : v.MES_ENCLOSURE_L__M, unit: e.projectPlanProductCategory === A.ARTIFACT.V ? "t" : "m²" }, e))), p;
    });
  }, B.HOOK.afterRefresh = async (d) => {
    Z(() => {
      var P, o;
      (o = (P = d.data) == null ? void 0 : P.filter((a) => a.showType === 1)) == null || o.forEach((a) => {
        H.value.toggleRowExpansion(a, true);
      });
    });
  };
  function J(d) {
    return d == null ? void 0 : d.id;
  }
  return (d, P) => {
    var e;
    const o = te, a = ae, F = k("common-table"), p = re, $ = le;
    return l(), u("div", ce, [((e = r(j)) == null ? void 0 : e.businessType) === r(O).INSTALLATION.V ? (l(), u("div", me, [ee((l(), n(F, { ref_key: "tableRef", ref: H, data: r(I).data, "empty-text": r(I).emptyText, "max-height": r(W), stripe: false, showEmptySymbol: false, "return-source-data": "", "tree-props": { children: "manageAreaList" }, "row-key": (t) => J(t), "cell-class-name": Q, "row-class-name": z, style: { width: "100%" } }, { default: C(() => [q(o, { prop: "index", label: "序号", align: "center", width: "55" }, { default: C((t) => [t.row.showType === 1 ? (l(), u("span", ye, s(t.row.showIndex), 1)) : i("", true)]), _: 1 }), r(N).visible("monomerName") ? (l(), n(o, { align: "center", key: "monomerName", prop: "monomerName", "show-overflow-tooltip": true, label: "单体" })) : i("", true), r(N).visible("projectPlanProductCategory") ? (l(), n(o, { align: "center", key: "projectPlanProductCategory", prop: "projectPlanProductCategory", "show-overflow-tooltip": true, label: "项目内容", width: "90" }, { default: C((t) => [c("span", null, s(t.row.projectPlanProductCategory ? r(A).VL[t.row.projectPlanProductCategory] : "-"), 1)]), _: 1 })) : i("", true), r(N).visible("areaName") ? (l(), n(o, { align: "center", key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "单元", "min-width": "150" })) : i("", true), r(N).visible("produceArr") ? (l(), n(o, { align: "center", key: "produceArr", prop: "produceArr", "show-overflow-tooltip": true, label: "生产方式", width: "70" }, { default: C((t) => [c("span", null, s(r(pe).VL[t.row.productionWay]), 1)]), _: 1 })) : i("", true), r(N).visible("deepProgress") ? (l(), n(o, { key: "deepProgress", prop: "deepProgress", "show-overflow-tooltip": true, label: "深化计划", "min-width": "220" }, { default: C((t) => {
      var y, D, w, h, g, _, V, f, T, x, b, E;
      return [r(M)(t.row.deepVal) ? (l(), u(R, { key: 0 }, [c("div", null, [S(s(`计划用时${((y = t.row.deepVal) == null ? void 0 : y.totalDays) || "-"}天|`), 1), c("span", { class: L(((D = t.row.deepVal) == null ? void 0 : D.totalDays) < ((w = t.row.deepVal) == null ? void 0 : w.actualDays) ? "red-color" : "green-color"), style: { "margin-right": "3px" } }, s(`已用时${((h = t.row.deepVal) == null ? void 0 : h.actualDays) || "-"}天`), 3), S(s(`总量${((_ = (g = t.row.deepVal) == null ? void 0 : g.mete) == null ? void 0 : _.toFixed(t.row.deepVal.decimal)) || "-"}${((V = t.row.deepVal) == null ? void 0 : V.unit) || ""}|已完成${((x = (f = t.row.deepVal) == null ? void 0 : f.completedMete) == null ? void 0 : x.toFixed((T = t.row.deepVal) == null ? void 0 : T.decimal)) || "-"}${((b = t.row.deepVal) == null ? void 0 : b.unit) || ""}`), 1)]), r(M)(t.row.deepVal) ? (l(), n(a, { key: 0, "text-inside": true, "stroke-width": 26, percentage: (E = t.row.deepVal) == null ? void 0 : E.meteRate, status: "success" }, null, 8, ["percentage"])) : i("", true)], 64)) : (l(), u(R, { key: 1 }, [S("-")], 64))];
    }), _: 1 })) : i("", true), r(N).visible("processProgress") ? (l(), n(o, { key: "processProgress", prop: "processProgress", "show-overflow-tooltip": true, label: "加工计划", "min-width": "220" }, { default: C((t) => {
      var y, D, w, h, g, _, V, f, T, x, b, E;
      return [r(M)(t.row.deepVal) ? (l(), u(R, { key: 0 }, [c("div", null, [S(s(`计划用时${((y = t.row.processVal) == null ? void 0 : y.totalDays) || "-"}天|`), 1), c("span", { class: L(((D = t.row.processVal) == null ? void 0 : D.totalDays) < ((w = t.row.processVal) == null ? void 0 : w.actualDays) ? "red-color" : "green-color"), style: { "margin-right": "3px" } }, s(`已用时${((h = t.row.processVal) == null ? void 0 : h.actualDays) || "-"}天`), 3), S(s(`总量${((_ = (g = t.row.processVal) == null ? void 0 : g.mete) == null ? void 0 : _.toFixed(t.row.processVal.decimal)) || "-"}${((V = t.row.processVal) == null ? void 0 : V.unit) || ""}|已完成${((x = (f = t.row.processVal) == null ? void 0 : f.completedMete) == null ? void 0 : x.toFixed((T = t.row.processVal) == null ? void 0 : T.decimal)) || "-"}${((b = t.row.processVal) == null ? void 0 : b.unit) || ""}`), 1)]), r(M)(t.row.processVal) ? (l(), n(a, { key: 0, "text-inside": true, "stroke-width": 26, percentage: (E = t.row.processVal) == null ? void 0 : E.meteRate, status: "success" }, null, 8, ["percentage"])) : i("", true)], 64)) : (l(), u(R, { key: 1 }, [S("-")], 64))];
    }), _: 1 })) : i("", true), r(N).visible("deliveryProgress") && r(j).businessType === r(O).INSTALLATION.V ? (l(), n(o, { key: "deliveryProgress", prop: "deliveryProgress", "show-overflow-tooltip": true, label: "发运计划", "min-width": "220" }, { default: C((t) => {
      var y, D, w, h, g, _, V, f, T, x, b, E, U;
      return [r(M)(t.row.shipVal) ? (l(), u(R, { key: 0 }, [c("div", null, [c("span", null, s(`计划用时${((y = t.row.shipVal) == null ? void 0 : y.totalDays) || "-"}天 | `), 1), c("span", { class: L((D = t.row.shipVal) != null && D.actualDays && ((w = t.row.shipVal) != null && w.totalDays) && t.row.shipVal.actualDays > t.row.shipVal.totalDays ? "red-color" : "green-color") }, s(`已用时${(h = t.row.shipVal) == null ? void 0 : h.actualDays}天`), 3)]), r(M)(t.row.shipVal) ? (l(), n(a, { key: 0, "text-inside": true, "stroke-width": 26, percentage: (g = t.row.shipVal) == null ? void 0 : g.dayRate, status: "warning" }, null, 8, ["percentage"])) : i("", true), c("div", null, s(`总量${((V = (_ = t.row.shipVal) == null ? void 0 : _.mete) == null ? void 0 : V.toFixed(t.row.shipVal.decimal)) || "-"}${((f = t.row.shipVal) == null ? void 0 : f.unit) || ""}|已完成${((b = (T = t.row.shipVal) == null ? void 0 : T.completedMete) == null ? void 0 : b.toFixed((x = t.row.shipVal) == null ? void 0 : x.decimal)) || "-"}${((E = t.row.shipVal) == null ? void 0 : E.unit) || ""}`), 1), r(M)(t.row.shipVal) ? (l(), n(a, { key: 1, "text-inside": true, "stroke-width": 26, percentage: (U = t.row.shipVal) == null ? void 0 : U.meteRate, status: "success" }, null, 8, ["percentage"])) : i("", true)], 64)) : (l(), u(R, { key: 1 }, [S("-")], 64))];
    }), _: 1 })) : i("", true), r(N).visible("installProgress") && r(j).businessType === r(O).INSTALLATION.V ? (l(), n(o, { key: "installProgress", prop: "installProgress", "show-overflow-tooltip": true, label: "安装计划", "min-width": "220" }, { default: C((t) => {
      var y, D, w, h, g, _, V, f, T, x, b, E;
      return [r(M)(t.row.deepVal) ? (l(), u(R, { key: 0 }, [c("div", null, [S(s(`计划用时${((y = t.row.installVal) == null ? void 0 : y.totalDays) || "-"}天|`), 1), c("span", { class: L(((D = t.row.installVal) == null ? void 0 : D.totalDays) < ((w = t.row.installVal) == null ? void 0 : w.actualDays) ? "red-color" : "green-color"), style: { "margin-right": "3px" } }, s(`已用时${((h = t.row.installVal) == null ? void 0 : h.actualDays) || "-"}天`), 3), S(s(`总量${((_ = (g = t.row.installVal) == null ? void 0 : g.mete) == null ? void 0 : _.toFixed(t.row.installVal.decimal)) || "-"}${((V = t.row.installVal) == null ? void 0 : V.unit) || ""}|已完成${((x = (f = t.row.installVal) == null ? void 0 : f.completedMete) == null ? void 0 : x.toFixed((T = t.row.installVal) == null ? void 0 : T.decimal)) || "-"}${((b = t.row.installVal) == null ? void 0 : b.unit) || ""}`), 1)]), r(M)(t.row.installVal) ? (l(), n(a, { key: 0, "text-inside": true, "stroke-width": 26, percentage: (E = t.row.installVal) == null ? void 0 : E.meteRate, status: "success" }, null, 8, ["percentage"])) : i("", true)], 64)) : (l(), u(R, { key: 1 }, [S("-")], 64))];
    }), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "row-key"])), [[$, r(I).loading]])])) : (l(), u("div", De, [q(p, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: C(() => P[0] || (P[0] = [S(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [0] })]))]);
  };
} }, xe = oe(we, [["__scopeId", "data-v-4143a8d4"]]);
export {
  xe as default
};
