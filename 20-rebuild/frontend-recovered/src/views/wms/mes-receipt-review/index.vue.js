import { ref as r } from "vue";
import { provide as E } from "vue";
import { useStore as te } from "vuex";
import { watch as ae } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as p } from "vue";
import { unref as t } from "vue";
import { withDirectives as oe } from "vue";
import { createBlock as s } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as le } from "vue";
import { toDisplayString as U } from "vue";
import { createTextVNode as se } from "vue";
import { Fragment as j } from "vue";
import { ElTableColumn as ie } from "element-plus";
import { ElTag as ne } from "element-plus";
import { vLoading as re } from "element-plus";
import { _ as ue, Bf as ce, bl as pe, Bg as me, x as de, Bh as b, o as fe, am as M, j_ as be, rJ as R, c as _e, jN as B, i as O, Bi as g, Bj as k, G as w, P as he, a as ye } from "../../../shared/runtime.js";
import { c as ve } from "../../../modules/mes-receipt-review-377f871a.js";
import ge from "./module/header.vue.js";
import ke from "./module/review.vue.js";
import we from "./module/detail.vue.js";
import Te from "./module/auto-detail.vue.js";
import "./module/print-table/index.vue.js";
import "./module/handle-detail-table.vue.js";
import "./module/outbound-detail.vue.js";
import "./module/outbound-handle-table.vue.js";
import "./module/outbound-handling-form/index.vue.js";
import "./module/outbound-handling-form/module/steel-plate.vue.js";
import "./module/outbound-handling-form/components/common-form-item.vue.js";
import "./module/outbound-handling-form/components/produce-form.vue.js";
import "./module/outbound-handling-form/components/common-material-info.vue.js";
import "./module/outbound-handling-form/module/section-steel.vue.js";
import "./module/submit-review.vue.js";
import "./module/receipt-list.vue.js";
const Ce = { class: "app-container" }, Ve = { key: 1 }, xe = { __name: "index", setup(Se) {
  const L = { batchAdd: false, add: false, edit: false, del: false, download: false }, c = r({});
  E("mainCurrentRow", c);
  const { workshopNameV3: H } = ce();
  E("workshopNameV3", H);
  const _ = r(false), I = r([]), A = r(), T = r("detail"), C = r(false), V = r(false), P = te(), W = r([["project", "parse-project"], ["projectsFullName", "parse-project", { source: "projects" }], ["basicClass", ["parse-enum", pe, { bit: true, split: " | " }]], ["schedulingDataSource", ["parse-enum", me]], ["createTime", "parse-time"]]), { crud: d, CRUD: $, columns: u } = de({ title: "物料领用", sort: [], permission: { ...b }, optShow: { ...L }, crudApi: { ...ve }, invisibleColumns: [] }, A), { maxHeight: z } = fe({ paginate: true }), x = r({}), h = r([]);
  E("handlingData", h), ae(() => P.state.approval_list.approvalNum, async (l) => {
    d.refresh();
  });
  function F(l, n) {
    let e;
    return O(x.value) && (e = x.value.materialType), l.boolAuto === g.NOT_AUTO.V && l.transactStatus !== k.HANDLED.V && (e ? l.materialType === e : true);
  }
  function K(l) {
    x.value = l[0], h.value = l;
  }
  function q(l, n) {
    c.value = l, h.value = [l], _.value = true, T.value = n;
  }
  function G() {
    _.value = true, c.value = h.value[0], T.value = "review";
  }
  function J(l) {
    c.value = l, C.value = true;
  }
  function Q(l) {
    c.value = l, V.value = true;
  }
  return $.HOOK.handleRefresh = async (l, n) => {
    n.data = { ...n.data, content: n.data.content.map((e) => {
      var y;
      e = { ...e };
      e.projectId = (y = e.project) == null ? void 0 : y.id, (e.materialType === "型材" || e.materialType === "钢板") && (e.basicClass = e.materialType === "型材" ? M.SECTION_STEEL.V : M.STEEL_PLATE.V, e.basicClass & be.STEEL.V && (e.measureUnit = R[e.basicClass].measure.unit, e.measurePrecision = R[e.basicClass].measure.precision, e.accountingUnit = B.weight.unit, e.accountingPrecision = B.weight.precision, e.pickingMete = _e(e.pickingMete, "kg", B.weight.unit, B.weight.precision), e.outboundMete = _e(e.outboundMete, "g", B.weight.unit, B.weight.precision), e.mesWorkshopId = e.mesWorkshop.id));
      return e;
    }) };
  }, (l, n) => {
    const e = ie, y = N("table-cell-tag"), X = ne, Y = ye, S = N("common-button"), Z = N("common-table"), ee = re;
    return o(), v("div", Ce, [p(t(ge), { onToHandle: G }), oe((o(), s(Z, { ref_key: "tableRef", ref: A, data: t(d).data, "data-format": W.value, "empty-text": t(d).emptyText, "max-height": t(z), "default-expand-all": false, "expand-row-keys": I.value, "row-key": "id", class: "hidden-table-check-all", onSelectionChange: K, onSortChange: t(d).handleSortChange }, { default: f(() => [p(e, { type: "selection", width: "55", align: "center", selectable: F }), p(e, { label: "序号", type: "index", align: "center", width: "60" }, { default: f(({ row: { sourceRow: a }, $index: m }) => {
      var D;
      return [t(O)(a.boolAuto) ? (o(), s(y, { key: 0, name: t(g).VL[a.boolAuto], color: (D = t(g).V[a.boolAuto]) == null ? void 0 : D.COLOR }, null, 8, ["name", "color"])) : i("", true), le("span", null, U(m + 1), 1)];
    }), _: 1 }), t(u).visible("project") ? (o(), s(e, { "show-overflow-tooltip": "", key: "project", prop: "project", label: "项目", "min-width": "170" })) : i("", true), t(u).visible("mesWorkshop.name") ? (o(), s(e, { "show-overflow-tooltip": "", key: "mesWorkshop.name", prop: "mesWorkshop.name", label: "车间", width: "100" })) : i("", true), t(u).visible("applicant.name") ? (o(), s(e, { key: "applicant.name", "show-overflow-tooltip": true, prop: "applicant.name", label: "申请人", align: "center", width: "80" })) : i("", true), t(u).visible("taskOrderNumber") ? (o(), s(e, { "show-overflow-tooltip": "", key: "taskOrderNumber", prop: "taskOrderNumber", label: "工单号", "min-width": "150" })) : i("", true), t(u).visible("materialType") ? (o(), s(e, { key: "materialType", "show-overflow-tooltip": true, prop: "materialType", label: "物料种类", "min-width": "100" })) : i("", true), t(u).visible("accountingUnit") ? (o(), s(e, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "80px" })) : i("", true), t(u).visible("pickingMete") ? (o(), s(e, { key: "pickingMete", prop: "pickingMete", label: "领料量", align: "right", "min-width": "100px" })) : i("", true), t(u).visible("outboundMete") ? (o(), s(e, { key: "outboundMete", prop: "outboundMete", label: "已出库", align: "right", "min-width": "100px" })) : i("", true), t(u).visible("transactStatus") ? (o(), s(e, { key: "transactStatus", prop: "transactStatus", label: "状态", width: "80" }, { default: f(({ row: { sourceRow: a } }) => {
      var m;
      return [a.transactStatus ? (o(), s(X, { key: 0, type: (m = t(k).V[a.transactStatus]) == null ? void 0 : m.T }, { default: f(() => [se(U(t(k).VL[a.transactStatus]), 1)]), _: 2 }, 1032, ["type"])) : (o(), v("span", Ve, "-"))];
    }), _: 1 })) : i("", true), t(w)([...t(b).detail]) ? (o(), s(e, { key: 9, label: "操作", width: "120px", align: "left", fixed: "right" }, { default: f(({ row: { sourceRow: a } }) => [a.boolAuto === t(g).NOT_AUTO.V && a.basicClass ? (o(), v(j, { key: 0 }, [a.transactStatus !== t(k).HANDLED.V && t(w)(t(b).add) ? (o(), s(S, { key: 0, type: "primary", size: "default", onClick: (m) => q(a, "review"), disabled: !a.boolOut }, { default: f(() => [p(Y, { "icon-class": "wms-outbound" })]), _: 2 }, 1032, ["onClick", "disabled"])) : i("", true), t(w)(t(b).detail) ? (o(), s(S, { key: 1, onClick: (m) => J(a, "detail"), icon: "el-icon-view", size: "default", type: "info" }, null, 8, ["onClick"])) : i("", true)], 64)) : (o(), v(j, { key: 1 }, [t(w)(t(b).detail) ? (o(), s(S, { key: 0, onClick: (m) => Q(a), icon: "el-icon-view", size: "default", type: "info" }, null, 8, ["onClick"])) : i("", true)], 64))]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "expand-row-keys", "onSortChange"])), [[ee, t(d).loading]]), p(t(he)), p(ke, { modelValue: _.value, "onUpdate:modelValue": n[0] || (n[0] = (a) => _.value = a), data: c.value, onRefresh: t(d).refresh, showType: T.value }, null, 8, ["modelValue", "data", "onRefresh", "showType"]), p(we, { modelValue: C.value, "onUpdate:modelValue": n[1] || (n[1] = (a) => C.value = a), data: c.value }, null, 8, ["modelValue", "data"]), p(Te, { modelValue: V.value, "onUpdate:modelValue": n[2] || (n[2] = (a) => V.value = a), data: c.value }, null, 8, ["modelValue", "data"])]);
  };
} }, qe = ue(xe, [["__scopeId", "data-v-f2fd047a"]]);
export {
  qe as default
};
