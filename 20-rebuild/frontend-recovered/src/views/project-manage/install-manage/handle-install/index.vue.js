import { ref as g } from "vue";
import { watch as q } from "vue";
import { reactive as te } from "vue";
import { resolveComponent as oe } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as w } from "vue";
import { unref as t } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as ae } from "vue";
import { createBlock as h } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as le } from "vue";
import { createCommentVNode as B } from "vue";
import { createTextVNode as ne } from "vue";
import { ElTableColumn as re } from "element-plus";
import { InfoFilled as ie } from "@element-plus/icons-vue";
import { ElIcon as se } from "element-plus";
import { ElTooltip as pe } from "element-plus";
import { ElInputNumber as ue } from "element-plus";
import { ElPagination as de } from "element-plus";
import { ElTag as me } from "element-plus";
import { vLoading as ce } from "element-plus";
import { c as ge } from "./detail-confirm.vue.js";
import { _ as ye, m as be, a3 as F, x as fe, o as _e, bN as O, tY as we } from "../../../../shared/runtime.js";
import { k as he } from "../../../../modules/project-19a12d6b.js";
import { u as ve } from "../../../../modules/use-drawing-8a7ba23b.js";
import Ne from "./header.vue.js";
import { b as Ie } from "../../../../modules/bim-preview-drawer-7ca7893b.js";
import { a as Te } from "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const xe = { class: "app-container" }, ke = { key: 0 }, Se = { style: { display: "inline-block" } }, Qe = ["onDblclick"], Ae = { key: 1 }, Ce = { __name: "index", setup(Ve) {
  const { globalProjectId: N, globalProject: y } = be(["globalProjectId", "globalProject"]), { showDrawing: _, drawingRow: l, drawingPreview: H } = ve({ pidField: "productId", typeField: "productType" }), L = { add: false, edit: false, del: false, download: false }, M = g([]), b = g(false), f = g(false), I = g();
  q([() => b.value, () => f.value], ([n, a]) => {
    !n && !a && (_.value = false), console.log(n, a, _.value, "show");
  }), q(() => _.value, (n) => {
    var a, e, s, p;
    n && ((a = l.value) != null && a.productType && ((e = l.value) == null ? void 0 : e.productType) & F.ARTIFACT.V && (b.value = true), (s = l.value) != null && s.productType && !(((p = l.value) == null ? void 0 : p.productType) & F.ARTIFACT.V) && (f.value = true));
  });
  const { crud: r, CRUD: T } = fe({ title: "安装填报", sort: [], permission: { ...he }, optShow: { ...L }, crudApi: { ...ge }, requiredQuery: ["projectId", "productType"], hasPagination: false }, I), { maxHeight: $ } = _e({ paginate: true, extraHeight: 40 }), i = te({ pageNumber: 1, pageSize: 100 }), x = g(0);
  function K(n) {
    i.pageNumber = 1, i.pageSize = n, r.toQuery();
  }
  function G(n) {
    i.pageNumber = n, r.toQuery();
  }
  return T.HOOK.beforeRefresh = () => (r.query.pageNumber = i.pageNumber, r.query.pageSize = i.pageSize, r.query.projectId = y.value.businessType === O.INSTALLATION.V ? N.value : void 0, !!r.query.projectId), T.HOOK.handleRefresh = (n, { data: a }) => {
    a.content.forEach((e) => {
      var s, p;
      e.areaId = (s = e.area) == null ? void 0 : s.id, e.monomerId = (p = e.monomer) == null ? void 0 : p.id, e.installAbleNum = e.receivingQuantity ? e.receivingQuantity - (e.installQuantity || 0) - (e.unAuditQuantity || 0) : 0;
    }), x.value = a.totalElements;
  }, (n, a) => {
    var k, S, Q, A, C, V, D, E, P, j, R, z;
    const e = re, s = ie, p = se, Y = pe, J = ue, W = oe("common-table"), X = de, Z = me, ee = ce;
    return c(), w("div", xe, [((k = t(y)) == null ? void 0 : k.businessType) === t(O).INSTALLATION.V ? (c(), w("div", ke, [o(t(Ne), { projectId: t(N), globalProject: t(y) }, null, 8, ["projectId", "globalProject"]), ae((c(), h(W, { ref_key: "tableRef", ref: I, data: t(r).data, "data-format": M.value, "empty-text": t(r).emptyText, "max-height": t($), style: { width: "100%", "margin-top": "10px" }, stripe: false }, { default: d(() => {
      var m;
      return [o(e, { label: "序号", type: "index", align: "center", width: "60" }), o(e, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "" }), o(e, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "" }), o(e, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), o(e, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" }, { header: d(() => [o(Y, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: d(() => [v("div", Se, [a[2] || (a[2] = v("span", null, "编号", -1)), o(p, null, { default: d(() => [o(s)]), _: 1 })])]), _: 1 })]), default: d((u) => [v("span", { style: { cursor: "pointer" }, onDblclick: (U) => t(H)(u.row) }, le(u.row.serialNumber), 41, Qe)]), _: 1 }), o(e, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "120" }), o(e, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", "show-overflow-tooltip": "" }), o(e, { key: "quantity", prop: "quantity", label: "清单数", align: "center", "show-overflow-tooltip": "" }), o(e, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", "show-overflow-tooltip": "" }), o(e, { key: "mete", prop: "mete", label: "清单量", align: "center", "show-overflow-tooltip": "" }), o(e, { key: "receivingQuantity", prop: "receivingQuantity", label: "收货量", align: "center", "show-overflow-tooltip": "" }), o(e, { key: "installQuantity", prop: "installQuantity", label: "已安装量", align: "center", "show-overflow-tooltip": "" }), o(e, { key: "unAuditQuantity", prop: "unAuditQuantity", label: "待审核量", align: "center", "show-overflow-tooltip": "" }), ((m = t(y)) == null ? void 0 : m.installReportMethod) === t(we).PC.V ? (c(), h(e, { key: "reportQuantity", prop: "reportQuantity", label: "本次安装填报", align: "center" }, { default: d((u) => [u.row.installAbleNum > 0 ? (c(), h(J, { key: 0, modelValue: u.row.sourceRow.reportQuantity, "onUpdate:modelValue": (U) => u.row.sourceRow.reportQuantity = U, modelModifiers: { number: true }, min: 0, max: u.row.installAbleNum, step: 1, precision: 0, placeholder: "请填写", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])) : B("", true)]), _: 1 })) : B("", true)];
    }), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[ee, t(r).loading]]), o(X, { total: x.value, "current-page": i.pageNumber, "page-size": i.pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: K, onCurrentChange: G }, null, 8, ["total", "current-page", "page-size"]), o(t(Ie), { visible: b.value, "onUpdate:visible": a[0] || (a[0] = (m) => b.value = m), "bool-bim": (S = t(l)) == null ? void 0 : S.boolBim, drawingSN: (Q = t(l)) == null ? void 0 : Q.drawingSN, "monomer-id": (A = t(l)) == null ? void 0 : A.monomerId, "serial-number": (C = t(l)) == null ? void 0 : C.serialNumber, productId: (V = t(l)) == null ? void 0 : V.productId, productType: (D = t(l)) == null ? void 0 : D.productType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "serial-number", "productId", "productType"]), o(t(Te), { modelValue: f.value, "onUpdate:modelValue": a[1] || (a[1] = (m) => f.value = m), drawingSN: (E = t(l)) == null ? void 0 : E.drawingSN, "bool-bim": (P = t(l)) == null ? void 0 : P.boolBim, "serial-number": (j = t(l)) == null ? void 0 : j.serialNumber, productId: (R = t(l)) == null ? void 0 : R.productId, productType: (z = t(l)) == null ? void 0 : z.productType }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType"])])) : (c(), w("div", Ae, [o(Z, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: d(() => a[3] || (a[3] = [ne(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [3] })]))]);
  };
} }, $e = ye(Ce, [["__scopeId", "data-v-93181d0a"]]);
export {
  $e as default
};
