import { ref as y } from "vue";
import { watch as ee } from "vue";
import { computed as F } from "vue";
import { provide as we } from "vue";
import { resolveComponent as te } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as ge } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as i } from "vue";
import { unref as n } from "vue";
import { withDirectives as oe } from "vue";
import { vShow as _e } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as S } from "vue";
import { toDisplayString as s } from "vue";
import { ElTableColumn as be } from "element-plus";
import { InfoFilled as he } from "@element-plus/icons-vue";
import { ElIcon as ve } from "element-plus";
import { ElTooltip as Te } from "element-plus";
import { vLoading as Ie } from "element-plus";
import { c as ne, g as Ee } from "../../../../modules/reporting-approval-2b65eecd.js";
import { P as ke } from "../../../../modules/base-6bc46ddf.js";
import { _ as Ce, x as Re, o as Ne, a3 as b, qc as ae, i as xe, e8 as De, bV as re, P as Se, ba as Ae, D as Ve } from "../../../../shared/runtime.js";
import Pe from "./module/header.vue.js";
import je from "./module/detail.vue.js";
import Oe from "./reporting-list/index.vue.js";
import Be from "./wage-adjustment/index.vue.js";
import { u as Qe } from "../../../../modules/use-drawing-8a7ba23b.js";
import { b as Le } from "../../../../modules/bim-preview-drawer-7ca7893b.js";
import { a as Me } from "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "./white-list-config/index.vue.js";
import "./white-list-config/module/form.vue.js";
import "../../../../modules/stud-set-1d850c87.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
import "../../../../modules/use-production-team-d8043fd6.js";
import "./batch-review/index.vue.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
import "../../../../modules/index-c07af747.js";
import "./reporting-list/module/header.vue.js";
import "./reporting-list/module/project-header-time.vue.js";
import "../../../../modules/wage-adjustment-585903f7.js";
import "./wage-adjustment/module/header.vue.js";
import "../../../../modules/project-select-94bb5bbd.js";
import "../../../../modules/index-7da9f094.js";
import "../../../../modules/use-users-4d979987.js";
import "./wage-modification/index.vue.js";
import "./wage-modification/module/header.vue.js";
import "./wage-modification/module/initiate-approval.vue.js";
const Ue = { class: "app-container" }, Fe = { class: "wrap" }, He = { class: "wrap-left" }, Ke = { class: "wrap-right" }, We = { class: "head-container" }, $e = { style: { display: "inline-block" } }, ze = ["onDblclick"], qe = { __name: "index", setup(Ge) {
  const H = y(null), w = y(), K = y(), L = y(false), h = y(null), A = y(false), V = y(false), M = y(false), P = y(2), { crud: d, columns: Je, CRUD: W } = Re({ title: "工价审核", requiredQuery: ["workshopId"], sort: [], crudApi: { ...ne }, queryOnPresenterCreated: false, hasPagination: true }, H), { maxHeight: ie } = Ne({ paginate: true }), { showDrawing: $, drawingRow: u, drawingPreview: le } = Qe({ pidField: "productId", typeField: "productTypeEnum" });
  ee([() => A.value, () => V.value], ([t, o]) => {
    !t && !o && ($.value = false);
  }), ee(() => $.value, (t) => {
    var o, e, m, f;
    t && ((o = u.value) != null && o.productType && ((e = u.value) == null ? void 0 : e.productType) & b.ARTIFACT.V && (A.value = true), (m = u.value) != null && m.productType && !(((f = u.value) == null ? void 0 : f.productType) & b.ARTIFACT.V) && (V.value = true));
  });
  function ue(t, o) {
    return !!t.price;
  }
  W.HOOK.beforeToQuery = async (t) => {
    var o;
    t.crudApi.get = ((o = h.value) == null ? void 0 : o.viewType) === ae.REAL_TIME_WORK_REPORTING.V ? ne.get : Ee, fe();
  }, W.HOOK.handleRefresh = (t, o) => {
    o.data.content = o.data.content.map((e) => {
      var m, f, j, O, B, Q, v, T, I, E, k, C, R, N, x, D;
      return e.areaId = ((m = e.area) == null ? void 0 : m.id) || void 0, e.monomerId = ((f = e.monomer) == null ? void 0 : f.id) || void 0, e.processId = ((j = e.process) == null ? void 0 : j.id) || void 0, e.productClassId = ((O = e.product) == null ? void 0 : O.classId) || void 0, e.productId = ((B = e.product) == null ? void 0 : B.id) || void 0, e.serialNumber = ((Q = e.product) == null ? void 0 : Q.serialNumber) || void 0, e.teamId = ((v = e.team) == null ? void 0 : v.id) || void 0, e.workshopId = ((T = e.workshop) == null ? void 0 : T.id) || void 0, e.productType = ((I = e.product) == null ? void 0 : I.productTypeEnum) || void 0, e.productTypeEnum = ((E = e.product) == null ? void 0 : E.productTypeEnum) || void 0, e.projectId = ((k = e.project) == null ? void 0 : k.id) || void 0, e.productClassificationEnum = ((C = e.product) == null ? void 0 : C.productClassificationEnum) || void 0, e.teamOrganizationType = xe((R = e.team) == null ? void 0 : R.organizationType) ? (N = e.team) == null ? void 0 : N.organizationType : void 0, e.dictionaryId = ((x = e.dict) == null ? void 0 : x.id) || void 0, e.reportPersonId = ((D = e.reportPerson) == null ? void 0 : D.id) || void 0, e.conditionList = JSON.parse(e.quotaMatchingCondition) || [], e;
    });
  };
  const pe = F(() => {
    var t, o;
    return ((t = w.value) == null ? void 0 : t.productTypeEnum) === b.ARTIFACT.V || ((o = w.value) == null ? void 0 : o.productTypeEnum) === b.ASSEMBLE.V;
  }), z = F(() => {
    var t;
    return ((t = w.value) == null ? void 0 : t.productTypeEnum) === b.MACHINE_PART.V;
  }), de = F(() => {
    var t;
    return ((t = w.value) == null ? void 0 : t.productTypeEnum) === b.ENCLOSURE.V;
  });
  function se() {
    M.value = true;
  }
  function ce(t, o) {
    var e, m, f;
    w.value = t, d.query.date = (o == null ? void 0 : o.date) || void 0, d.query.yearMonth = (o == null ? void 0 : o.yearMonth) || void 0, d.query.processId = ((e = t == null ? void 0 : t.process) == null ? void 0 : e.id) || void 0, d.query.productTypeEnum = (t == null ? void 0 : t.productTypeEnum) || void 0, d.query.teamId = ((m = t == null ? void 0 : t.team) == null ? void 0 : m.id) || void 0, d.query.workshopId = ((f = t == null ? void 0 : t.workshop) == null ? void 0 : f.id) || void 0, t ? d.toQuery() : d.data = [];
  }
  function me(t) {
    K.value = t, L.value = true;
  }
  async function fe() {
    try {
      const t = await ke();
      P.value = (t == null ? void 0 : t.wageDisplayPrecision) ?? void 0;
    } catch (t) {
      console.log(t);
    }
  }
  function ye(t) {
    return Ae(t, { props: ["reportQuantity", ["measurementQuantity", 5], ["amount", Ve.YUAN]], toThousandFields: ["amount"] });
  }
  return we("wageDisplayPrecision", P), (t, o) => {
    var v, T, I, E, k, C, R, N, x, D, q, G, J, Y, X, Z;
    const e = be, m = he, f = ve, j = Te, O = te("common-button"), B = te("common-table"), Q = Ie;
    return g(), ge("div", Ue, [l("div", Fe, [l("div", He, [i(n(Oe), { ref_key: "reportingListRef", ref: h, onCurrentChange: ce }, null, 512)]), l("div", Ke, [l("div", We, [i(n(Pe), { currentRow: w.value, viewType: (v = h.value) == null ? void 0 : v.viewType, onWageAdjust: se }, null, 8, ["currentRow", "viewType"])]), oe(l("div", null, [oe((g(), _(B, { ref_key: "tableRef", ref: H, class: "production-affirm-table-style", data: n(d).data, "empty-text": n(d).emptyText, "max-height": n(ie), "return-source-data": "", showEmptySymbol: false, "row-key": "produceTeamReportIds", onSelectionChange: n(d).selectionChangeHandler, "show-summary": "", "summary-method": ye, style: { width: "100%" } }, { default: p(() => {
      var c;
      return [((c = h.value) == null ? void 0 : c.viewType) === n(ae).REAL_TIME_WORK_REPORTING.V ? (g(), _(e, { key: 0, type: "selection", width: "50", align: "center", fixed: "left", selectable: ue })) : S("", true), i(e, { prop: "index", label: "序号", align: "center", width: "50", type: "index", fixed: "left" }), i(e, { label: "项目", prop: "project", key: "project", "show-overflow-tooltip": "", align: "center", "min-width": "120px" }, { default: p((a) => {
        var r, U;
        return [l("span", null, s((r = a.row.project) == null ? void 0 : r.serialNumber) + " - " + s((U = a.row.project) == null ? void 0 : U.shortName), 1)];
      }), _: 1 }), i(e, { label: "批次", prop: "areaBatch", key: "areaBatch", "show-overflow-tooltip": "", align: "center", "min-width": "100px" }, { default: p((a) => {
        var r;
        return [l("span", null, s(((r = a.row.areaBatch) == null ? void 0 : r.name) || "-"), 1)];
      }), _: 1 }), pe.value ? (g(), _(e, { label: "编号", prop: "productSerialNumber", key: "productSerialNumber", "show-overflow-tooltip": "", align: "center" }, { header: p(() => [i(j, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: p(() => [l("div", $e, [o[5] || (o[5] = l("span", null, "编号", -1)), i(f, null, { default: p(() => [i(m)]), _: 1 })])]), _: 1 })]), default: p((a) => {
        var r;
        return [l("span", { style: { cursor: "pointer", color: "#409eff" }, onDblclick: (U) => n(le)(a.row) }, s(((r = a.row.product) == null ? void 0 : r.serialNumber) || "-"), 41, ze)];
      }), _: 1 })) : S("", true), de.value ? (g(), _(e, { label: "围护类型", prop: "dict", key: "dict", "show-overflow-tooltip": "", align: "center" }, { default: p((a) => {
        var r;
        return [l("span", null, s(((r = a.row.dict) == null ? void 0 : r.label) || "-"), 1)];
      }), _: 1 })) : S("", true), z.value ? (g(), _(e, { label: "类型", prop: "productClassificationEnum", key: "productClassificationEnum", "show-overflow-tooltip": "", align: "center" }, { default: p((a) => {
        var r;
        return [l("span", null, s(n(De).VL[(r = a.row.product) == null ? void 0 : r.productClassificationEnum] || "-"), 1)];
      }), _: 1 })) : S("", true), z.value ? (g(), _(e, { label: "规格", prop: "productSpecification", key: "productSpecification", "show-overflow-tooltip": "", align: "center" }, { default: p((a) => {
        var r;
        return [l("span", null, s(((r = a.row.product) == null ? void 0 : r.specification) || "-"), 1)];
      }), _: 1 })) : S("", true), i(e, { label: "工序", prop: "process", key: "process", "show-overflow-tooltip": "", align: "center", width: "120" }, { default: p((a) => {
        var r;
        return [l("span", null, s(((r = a.row.process) == null ? void 0 : r.name) || "-"), 1)];
      }), _: 1 }), i(e, { label: "报工数量", prop: "reportQuantity", key: "reportQuantity", "show-overflow-tooltip": "", align: "center", width: "80" }, { default: p((a) => [l("span", null, s(a.row.reportQuantity ?? "-"), 1)]), _: 1 }), i(e, { label: "计量单位", prop: "measureUnit", key: "measureUnit", "show-overflow-tooltip": "", align: "center", width: "80" }), i(e, { label: "核算量", prop: "measurementQuantity", key: "measurementQuantity", "show-overflow-tooltip": "", align: "center", width: "120" }, { default: p((a) => [l("span", null, s(a.row.measurementQuantity ?? "-"), 1)]), _: 1 }), i(e, { label: "单价（元）", prop: "price", key: "price", "show-overflow-tooltip": "", align: "center", width: "100" }, { default: p((a) => [l("span", null, s(n(re)(a.row.price, P.value) ?? "-"), 1)]), _: 1 }), i(e, { label: "金额（元）", prop: "amount", key: "amount", "show-overflow-tooltip": "", align: "center", width: "100" }, { default: p((a) => [l("span", null, s(n(re)(a.row.amount, P.value) ?? "-"), 1)]), _: 1 }), i(e, { label: "操作", align: "center", fixed: "right", width: "80" }, { default: p((a) => [i(O, { size: "default", icon: "el-icon-view", type: "primary", onClick: (r) => me(a.row) }, null, 8, ["onClick"])]), _: 1 })];
    }), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[Q, n(d).loading]]), i(n(Se)), i(n(je), { modelValue: L.value, "onUpdate:modelValue": o[0] || (o[0] = (c) => L.value = c), currentRow: w.value, currentDetail: K.value, viewType: (T = h.value) == null ? void 0 : T.viewType, onSuccess: n(d).refresh }, null, 8, ["modelValue", "currentRow", "currentDetail", "viewType", "onSuccess"])], 512), [[_e, (I = w.value) == null ? void 0 : I.rowKey]])])]), i(n(Le), { visible: A.value, "onUpdate:visible": o[1] || (o[1] = (c) => A.value = c), "bool-bim": (E = n(u)) == null ? void 0 : E.boolBim, drawingSN: (k = n(u)) == null ? void 0 : k.drawingSN, "monomer-id": (C = n(u)) == null ? void 0 : C.monomerId, "serial-number": (R = n(u)) == null ? void 0 : R.serialNumber, productId: (N = n(u)) == null ? void 0 : N.productId, productType: (x = n(u)) == null ? void 0 : x.productType, projectType: (D = n(u)) == null ? void 0 : D.projectType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "serial-number", "productId", "productType", "projectType"]), i(n(Me), { modelValue: V.value, "onUpdate:modelValue": o[2] || (o[2] = (c) => V.value = c), drawingSN: (q = n(u)) == null ? void 0 : q.drawingSN, "bool-bim": (G = n(u)) == null ? void 0 : G.boolBim, "serial-number": (J = n(u)) == null ? void 0 : J.serialNumber, productId: (Y = n(u)) == null ? void 0 : Y.productId, productType: (X = n(u)) == null ? void 0 : X.productType, "monomer-id": (Z = n(u)) == null ? void 0 : Z.monomerId }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType", "monomer-id"]), i(n(Be), { visible: M.value, "onUpdate:visible": o[3] || (o[3] = (c) => M.value = c), onRefresh: o[4] || (o[4] = (c) => n(d).toQuery()) }, null, 8, ["visible"])]);
  };
} }, Vt = Ce(qe, [["__scopeId", "data-v-1db93698"]]);
export {
  Vt as default
};
