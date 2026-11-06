import { ref as P } from "vue";
import { watch as Z } from "vue";
import { nextTick as k } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as m } from "vue";
import { unref as s } from "vue";
import { createElementVNode as h } from "vue";
import { Fragment as I } from "vue";
import { renderList as ee } from "vue";
import { createBlock as u } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as g } from "vue";
import { withDirectives as te } from "vue";
import { createVNode as R } from "vue";
import { createCommentVNode as D } from "vue";
import { normalizeClass as ae } from "vue";
import { ElTag as oe } from "element-plus";
import { ElTableColumn as se } from "element-plus";
import { ElProgress as re } from "element-plus";
import { vLoading as le } from "element-plus";
import { c as ne } from "../../../../modules/plan-progress-eaf89ead.js";
import { s as ie } from "../../../../modules/subcontract-plan-b05fc818.js";
import { _ as pe, m as de, x as ue, o as ce, bN as N, c7 as p, kM as c, D as f, mw as me, i as B, G } from "../../../../shared/runtime.js";
import { N as L } from "../../../../modules/project-19a12d6b.js";
import ye from "./module/subcontract-detail.vue.js";
const De = { class: "app-container" }, fe = { key: 0 }, _e = { style: { "margin-bottom": "20px" } }, he = { key: 1 }, ge = { __name: "index", setup(Te) {
  const { globalProjectId: _, globalProject: T } = de(["globalProjectId", "globalProject"]), H = { add: false, edit: false, del: false, download: false }, M = P(), V = P(false), w = P([]), j = P({}), { crud: n, columns: b, CRUD: v } = ue({ title: "进度状态", sort: ["id.desc"], permission: { ...L }, optShow: { ...H }, crudApi: { ...ne }, hasPagination: false }, M), { maxHeight: W } = ce({ wrapperBox: ".subcontract-progress", paginate: true, extraHeight: 120 });
  Z(() => _.value, (o) => {
    o && (n.query.projectId = _.value, J(), n.toQuery());
  }, { immediate: true, deep: true });
  function $({ row: o, rowIndex: l }) {
    return o.showType === 1 ? "" : "abnormal-row";
  }
  function z({ row: o, rowIndex: l }) {
    return o.showType === 1 ? "" : "abnormal-row";
  }
  function Q(o) {
    n.query.supplierId = o.supplierId;
  }
  async function J() {
    if (!_.value && T.value.businessType !== N.INSTALLATION.V) return false;
    try {
      const { content: o = [] } = await ie({ projectId: _.value });
      w.value = o, n.query.supplierId = w.value.length ? w.value[0].supplierId : void 0;
    } catch (o) {
      console.log("获取分包账号失败", o);
    }
  }
  function X(o) {
    var l, d;
    console.log(o, "row"), j.value = { projectId: _.value, supplierId: n.query.supplierId, supplierName: n.query.supplierId ? (d = (l = w.value) == null ? void 0 : l.find((t) => t.supplierId === n.query.supplierId)) == null ? void 0 : d.supplierName : void 0, monomerId: o.showType === 1 ? o.id : o.monomerId, areaId: o.showType === 2 ? o.areaId : void 0 }, V.value = true;
  }
  v.HOOK.beforeRefresh = () => (n.query.projectId = T.value.businessType === N.INSTALLATION.V ? _.value : void 0, !!n.query.projectId), v.HOOK.handleRefresh = (o, l) => {
    var E;
    let d = 1;
    const t = (/* @__PURE__ */ new Date()).getTime();
    l.data.content = (E = l.data) == null ? void 0 : E.map((i) => {
      var S;
      return i.monomerName = i.name, i.areaName = "全部", i.showType = 1, i.showIndex = d++, i.manageAreaList && i.manageAreaList.length > 0 && ((S = i.manageAreaList) == null || S.map((e, A) => (e.areaId = e.id, e.id = i.id + " " + e.id, e.areaName = e.name, e.showType = 2, e.showIndex = i.showIndex + "." + (A + 1), e.deepTotalDays = e.deepenStartDate && e.deepenEndDate ? p(e.deepenStartDate, e.deepenEndDate) : 0, e.deepActualDays = e.deepenStartDate && e.deepenEndDate && e.deepenStartDate <= t && e.deepenEndDate <= t ? p(e.deepenStartDate, e.deepenEndDate) : e.deepenStartDate && e.deepenEndDate && e.deepenStartDate <= t && e.deepenEndDate > t ? p(e.deepenStartDate, t) : 0, e.deepVal = { totalDays: e.deepTotalDays, actualDays: e.deepActualDays, dayRate: e.deepTotalDays ? Number((e.deepActualDays / e.deepTotalDays * 100).toFixed(1)) : 0, dayColor: "#1890ff", mete: e.budgetVolume, completedMete: e.deepenMete || 0, meteRate: e.deepenMete && e.budgetVolume ? Number((e.deepenMete / e.budgetVolume * 100).toFixed(1)) : 0, meteColor: "#1890ff", decimal: e.projectPlanProductCategory === c.ARTIFACT.V ? f.COM_WT__KG : f.MES_ENCLOSURE_L__M, unit: e.projectPlanProductCategory === c.ARTIFACT.V ? "t" : "m²" }, e.processTotalDays = e.processStartDate && e.processEndDate ? p(e.processStartDate, e.processEndDate) : 0, e.processActualDays = e.processStartDate && e.processEndDate && e.processStartDate <= t && e.processEndDate <= t ? p(e.processStartDate, e.processEndDate) : e.processStartDate && e.processEndDate && e.processStartDate <= t && e.processEndDate > t ? p(e.processStartDate, t) : 0, e.processVal = { totalDays: e.processTotalDays, actualDays: e.processActualDays, dayRate: e.processTotalDays ? Number((e.processActualDays / e.processTotalDays * 100).toFixed(1)) : 0, dayColor: "#1890ff", mete: e.deepenMete, completedMete: e.produceMete || 0, meteRate: e.produceMete && e.deepenMete ? Number((e.produceMete / e.deepenMete * 100).toFixed(1)) : 0, meteColor: "#1890ff", decimal: e.projectPlanProductCategory === c.ARTIFACT.V ? f.COM_WT__KG : f.MES_ENCLOSURE_L__M, unit: e.projectPlanProductCategory === c.ARTIFACT.V ? "t" : "m²" }, e.shipTotalDays = e.shippedStartDate && e.shippedEndDate ? p(e.shippedStartDate, e.shippedEndDate) : 0, e.shipActualDays = e.shippedStartDate && e.shippedEndDate && e.shippedStartDate <= t && e.shippedEndDate <= t ? p(e.shippedStartDate, e.shippedEndDate) : e.shippedStartDate && e.shippedEndDate && e.shippedStartDate <= t && e.shippedEndDate > t ? p(e.shippedStartDate, t) : 0, e.shipVal = { totalDays: e.shipTotalDays, actualDays: e.shipActualDays, dayRate: e.shipTotalDays ? Number((e.shipActualDays / e.shipTotalDays * 100).toFixed(1)) : 0, dayColor: "#1890ff", mete: e.deepenMete, completedMete: e.shippingMete || 0, meteRate: e.shippingMete && e.deepenMete ? Number((e.shippingMete / e.deepenMete * 100).toFixed(1)) : 0, meteColor: "#1890ff", decimal: e.projectPlanProductCategory === c.ARTIFACT.V ? f.COM_WT__KG : f.MES_ENCLOSURE_L__M, unit: e.projectPlanProductCategory === c.ARTIFACT.V ? "t" : "m²" }, e.installTotalDays = e.installStartDate && e.installEndDate ? p(e.installStartDate, e.installEndDate) : 0, e.installActualDays = e.installStartDate && e.installEndDate && e.installStartDate <= t && e.installEndDate <= t ? p(e.installStartDate, e.installEndDate) : e.installStartDate && e.installEndDate && e.installStartDate <= t && e.installEndDate > t ? p(e.installStartDate, t) : 0, e.installVal = { totalDays: e.installTotalDays, actualDays: e.installActualDays, dayRate: e.installTotalDays ? Number((e.installActualDays / e.installTotalDays * 100).toFixed(1)) : 0, dayColor: "#1890ff", mete: e.deepenMete, completedMete: e.installMete || 0, meteRate: e.installMete && e.deepenMete ? Number((e.installMete / e.deepenMete * 100).toFixed(1)) : 0, meteColor: "#1890ff", decimal: e.projectPlanProductCategory === c.ARTIFACT.V ? f.COM_WT__KG : f.MES_ENCLOSURE_L__M, unit: e.projectPlanProductCategory === c.ARTIFACT.V ? "t" : "m²" }, e))), i;
    });
  }, v.HOOK.afterRefresh = async (o) => {
    k(() => {
      var l, d;
      (d = (l = o.data) == null ? void 0 : l.filter((t) => t.showType === 1)) == null || d.forEach((t) => {
        M.value.toggleRowExpansion(t, true);
      });
    });
  };
  function Y(o) {
    return o == null ? void 0 : o.id;
  }
  return (o, l) => {
    var A;
    const d = oe, t = se, E = re, i = U("common-button"), S = U("common-table"), e = le;
    return r(), m("div", De, [((A = s(T)) == null ? void 0 : A.businessType) === s(N).INSTALLATION.V ? (r(), m("div", fe, [h("div", _e, [(r(true), m(I, null, ee(w.value, (a) => (r(), u(d, { key: a.supplierId, type: s(n).query.supplierId === a.supplierId ? "success" : "primary", effect: s(n).query.supplierId === a.supplierId ? "light" : "plain", style: { "margin-right": "10px", cursor: "pointer" }, size: "large", onClick: (x) => Q(a) }, { default: y(() => [C(g(a.supplierName), 1)]), _: 2 }, 1032, ["type", "effect", "onClick"]))), 128))]), te((r(), u(S, { ref_key: "tableRef", ref: M, data: s(n).data, "empty-text": s(n).emptyText, "max-height": s(W), stripe: false, showEmptySymbol: false, "return-source-data": "", "tree-props": { children: "manageAreaList" }, "row-key": (a) => Y(a), "cell-class-name": z, "row-class-name": $, style: { width: "100%" } }, { default: y(() => [R(t, { prop: "index", label: "序号", align: "center", width: "100" }, { default: y((a) => [h("span", null, g(a.row.showIndex), 1)]), _: 1 }), s(b).visible("monomerName") ? (r(), u(t, { align: "center", key: "monomerName", prop: "monomerName", "show-overflow-tooltip": true, label: "单体" })) : D("", true), s(b).visible("projectPlanProductCategory") ? (r(), u(t, { align: "center", key: "projectPlanProductCategory", prop: "projectPlanProductCategory", "show-overflow-tooltip": true, label: "项目内容", width: "90" }, { default: y((a) => [h("span", null, g(a.row.projectPlanProductCategory ? s(c).VL[a.row.projectPlanProductCategory] : "-"), 1)]), _: 1 })) : D("", true), s(b).visible("areaName") ? (r(), u(t, { align: "center", key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "单元", "min-width": "150" })) : D("", true), s(b).visible("produceArr") ? (r(), u(t, { align: "center", key: "produceArr", prop: "produceArr", "show-overflow-tooltip": true, label: "生产方式", width: "70" }, { default: y((a) => [h("span", null, g(s(me).VL[a.row.productionWay]), 1)]), _: 1 })) : D("", true), s(b).visible("installProgress") && s(T).businessType === s(N).INSTALLATION.V ? (r(), u(t, { key: "installProgress", prop: "installProgress", "show-overflow-tooltip": true, label: "安装进度", "min-width": "220" }, { default: y((a) => {
      var x, O, F, q, K;
      return [s(B)(a.row.deepVal) ? (r(), m(I, { key: 0 }, [a.row.showType === 1 ? (r(), m(I, { key: 0 }, [C("-")], 64)) : (r(), m(I, { key: 1 }, [h("div", null, [C(g(`计划用时${((x = a.row.installVal) == null ? void 0 : x.totalDays) || "-"}天|`), 1), h("span", { class: ae(((O = a.row.installVal) == null ? void 0 : O.totalDays) < ((F = a.row.installVal) == null ? void 0 : F.actualDays) ? "red-color" : "green-color") }, g(`已用时${((q = a.row.installVal) == null ? void 0 : q.actualDays) || "-"}天`), 3)]), s(B)(a.row.installVal) ? (r(), u(E, { key: 0, "text-inside": true, "stroke-width": 26, percentage: (K = a.row.installVal) == null ? void 0 : K.dayRate, status: "warning" }, null, 8, ["percentage"])) : D("", true)], 64))], 64)) : (r(), m(I, { key: 1 }, [C("-")], 64))];
    }), _: 1 })) : D("", true), s(G)([...s(L).detail]) ? (r(), u(t, { key: 5, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: y((a) => [s(G)(s(L).detail) ? (r(), u(i, { key: 0, size: "default", icon: "el-icon-view", type: "primary", onClick: (x) => X(a.row) }, null, 8, ["onClick"])) : D("", true)]), _: 1 })) : D("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "row-key"])), [[e, s(n).loading]])])) : (r(), m("div", he, [R(d, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: y(() => l[1] || (l[1] = [C(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [1] })])), R(s(ye), { modelValue: V.value, "onUpdate:modelValue": l[0] || (l[0] = (a) => V.value = a), detailInfo: j.value, globalProject: s(T) }, null, 8, ["modelValue", "detailInfo", "globalProject"])]);
  };
} }, xe = pe(ge, [["__scopeId", "data-v-9337f99d"]]);
export {
  xe as default
};
