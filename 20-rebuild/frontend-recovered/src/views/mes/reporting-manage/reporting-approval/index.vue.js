import { ref as m } from "vue";
import { watch as W } from "vue";
import { resolveComponent as ie } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withDirectives as le } from "vue";
import { createBlock as se } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as u } from "vue";
import { createTextVNode as pe } from "vue";
import { ElMessageBox as K } from "element-plus";
import { ElNotification as Q } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { InfoFilled as de } from "@element-plus/icons-vue";
import { ElIcon as me } from "element-plus";
import { ElTooltip as ce } from "element-plus";
import { vLoading as fe } from "element-plus";
import { c as we, m as be, r as ye, e as ge } from "./module/header.vue.js";
import { _ as ve, o as _e, x as he, qd as ke, a3 as z, p as G, p6 as Te, bV as xe, P as Ne } from "../../../../shared/runtime.js";
import { u as Ce } from "../../../../modules/use-drawing-8a7ba23b.js";
import Ie from "./wage-adjustment/index.vue.js";
import Re from "./module/wage-composition.vue.js";
import je from "./module/parts-summary-list.vue.js";
import { b as Ae } from "../../../../modules/bim-preview-drawer-7ca7893b.js";
import { a as Se } from "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/index-c07af747.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
import "../../../../modules/wage-adjustment-585903f7.js";
import "./wage-adjustment/module/header.vue.js";
import "../../../../modules/index-7da9f094.js";
import "../../../../modules/use-users-4d979987.js";
import "./wage-modification/index.vue.js";
import "./wage-modification/module/header.vue.js";
import "./wage-modification/module/initiate-approval.vue.js";
import "../../../../modules/use-production-team-d8043fd6.js";
import "./wage-adjustment/module/detail.vue.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const De = { class: "app-container" }, Ee = { class: "head-container" }, Ve = { style: { display: "inline-block" } }, Be = ["onClick"], Pe = ["onDblclick"], Le = ["onClick"], qe = { key: 1 }, Ue = { __name: "index", setup(He) {
  const { maxHeight: J } = _e({ paginate: true }), V = m(), R = m(), j = m(false), A = m(false), S = m(false), D = m(false), E = m(false), h = m(false), k = m(false), T = m(), { crud: d, CRUD: X } = he({ title: "报工管理", permission: { ...ke }, crudApi: { ...we }, sort: [], hasPagination: true }, V), { showDrawing: B, drawingRow: l, drawingPreview: Y } = Ce({ pidField: "productId", typeField: "productTypeEnum" });
  W([() => h.value, () => k.value], ([a, r]) => {
    !a && !r && (B.value = false);
  }), W(() => B.value, (a) => {
    var r, o, f, c;
    a && ((r = l.value) != null && r.productType && ((o = l.value) == null ? void 0 : o.productType) & z.ARTIFACT.V && (h.value = true), (f = l.value) != null && f.productType && !(((c = l.value) == null ? void 0 : c.productType) & z.ARTIFACT.V) && (k.value = true));
  });
  function Z(a, r) {
    return !!a.quotaConfigNumber;
  }
  function ee() {
    j.value = true;
  }
  X.HOOK.handleRefresh = async (a, { data: r }) => {
    r.content = r.content.map((o, f) => {
      var c, x, N, C, b, y, g, v;
      return o.workshopId = ((c = o.workshop) == null ? void 0 : c.id) || void 0, o.projectId = ((x = o.project) == null ? void 0 : x.id) || void 0, o.teamId = ((N = o.team) == null ? void 0 : N.id) || void 0, o.productId = ((C = o.product) == null ? void 0 : C.id) || void 0, o.serialNumber = ((b = o.product) == null ? void 0 : b.serialNumber) || void 0, o.processId = ((y = o.process) == null ? void 0 : y.id) || void 0, o.monomerId = ((g = o.monomer) == null ? void 0 : g.id) || void 0, o.productSerialNumber = ((v = o.product) == null ? void 0 : v.serialNumber) || void 0, o.numbers = o.drawingNumbers, o.rowKey = f + "" + Math.random(), o;
    });
  };
  function oe() {
    K.confirm("一旦审核通过，将无法修改，是否确认？", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      var a;
      D.value = true, await ye(d.selections.map((r) => r.subList).flat()), Q({ title: "审核通过成功！", type: "success" }), d.refresh(), (a = R.value) == null || a.getSummaryData();
    }).catch((a) => {
      console.log(a);
    }).finally(() => {
      D.value = false;
    });
  }
  function te() {
    K.confirm("一旦剔除，将无法找回，是否确认", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      var a;
      E.value = true, await ge(d.selections.map((r) => r.subList).flat()), Q({ title: "剔除成功！", type: "success" }), d.refresh(), (a = R.value) == null || a.getSummaryData();
    }).catch((a) => {
      console.log(a);
    }).finally(() => {
      E.value = false;
    });
  }
  function re(a) {
    A.value = true, T.value = a;
  }
  function ne(a) {
    S.value = true, T.value = a;
  }
  function ae() {
    d.refresh();
  }
  return (a, r) => {
    var b, y, g, v, P, L, q, U, H, M, F, O, $;
    const o = ue, f = de, c = me, x = ce, N = ie("common-table"), C = fe;
    return w(), _("div", De, [p("div", Ee, [n(t(be), { ref_key: "headerRef", ref: R, adjustLoading: D.value, eliminateLoading: E.value, onToAdjust: oe, onWageAdjust: ee, onToEliminate: te }, null, 8, ["adjustLoading", "eliminateLoading"])]), le((w(), se(N, { ref_key: "tableRef", ref: V, data: t(d).data, "empty-text": t(d).emptyText, "max-height": t(J), style: { width: "100%" }, "row-key": "rowKey", "show-empty-symbol": false, "return-source-data": "", onSelectionChange: t(d).selectionChangeHandler }, { default: s(() => [n(o, { type: "selection", width: "40", align: "center", "class-name": "production-affirm-table-column-style", fixed: "left", selectable: Z }), n(o, { label: "序号", type: "index", align: "center", width: "60" }), n(o, { key: "reportTime", prop: "reportTime", "show-overflow-tooltip": "", label: "报工日期", align: "center", width: "280px" }, { default: s((e) => [p("span", null, u(e.row.minReportTime ? t(G)(e.row.minReportTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1), r[6] || (r[6] = pe(" ~ ")), p("span", null, u(e.row.maxReportTime ? t(G)(e.row.maxReportTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), n(o, { key: "workshop", prop: "workshop", "show-overflow-tooltip": "", label: "车间", align: "center" }, { default: s((e) => {
      var i;
      return [p("span", null, u(((i = e.row.workshop) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 }), n(o, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "项目", align: "center", width: "180px" }, { default: s((e) => {
      var i, I;
      return [p("span", null, u(((i = e.row.project) == null ? void 0 : i.serialNumber) || "-") + " - " + u(((I = e.row.project) == null ? void 0 : I.shortName) || "-"), 1)];
    }), _: 1 }), n(o, { key: "taskOrderNumber", prop: "taskOrderNumber", "show-overflow-tooltip": "", label: "任务工单号", align: "center", "min-width": "140" }, { default: s((e) => [p("span", null, u(e.row.taskOrderNumber || "-"), 1)]), _: 1 }), n(o, { key: "team", prop: "team", "show-overflow-tooltip": "", label: "班组", align: "center" }, { default: s((e) => {
      var i;
      return [p("span", null, u(((i = e.row.team) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 }), n(o, { key: "process", prop: "process", "show-overflow-tooltip": "", label: "工序", align: "center" }, { default: s((e) => {
      var i;
      return [p("span", null, u(((i = e.row.process) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 }), n(o, { key: "product", prop: "product", "show-overflow-tooltip": "", label: "编号", align: "center" }, { header: s(() => [n(x, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: s(() => [p("div", Ve, [r[7] || (r[7] = p("span", null, "编号", -1)), n(c, null, { default: s(() => [n(f)]), _: 1 })])]), _: 1 })]), default: s((e) => {
      var i;
      return [t(d).query.productTypeEnum === t(Te).MACHINE_PART.V ? (w(), _("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (I) => ne(e.row) }, " 一批 ", 8, Be)) : (w(), _("span", { key: 1, style: { cursor: "pointer", color: "#409eff" }, onDblclick: (I) => t(Y)(e.row) }, u(((i = e.row.product) == null ? void 0 : i.serialNumber) || "-"), 41, Pe))];
    }), _: 1 }), n(o, { key: "product", prop: "product", "show-overflow-tooltip": "", label: "规格", align: "center", width: "180px" }, { default: s((e) => {
      var i;
      return [p("span", null, u(((i = e.row.product) == null ? void 0 : i.specification) || "-"), 1)];
    }), _: 1 }), n(o, { key: "unit", prop: "unit", "show-overflow-tooltip": "", label: "单位", align: "center" }, { default: s((e) => [p("span", null, u(e.row.unit || "-"), 1)]), _: 1 }), n(o, { key: "accountingQuantity", prop: "accountingQuantity", "show-overflow-tooltip": "", label: "核算量", align: "center" }, { default: s((e) => [p("span", null, u(e.row.accountingQuantity ?? "-"), 1)]), _: 1 }), n(o, { key: "quotaConfigNumber", prop: "quotaConfigNumber", "show-overflow-tooltip": "", label: "执行定额", align: "center" }, { default: s((e) => [p("span", null, u(e.row.quotaConfigNumber || "-"), 1)]), _: 1 }), n(o, { key: "price", prop: "price", "show-overflow-tooltip": "", label: "单价（元）", align: "center" }, { default: s((e) => [e.row.price || e.row.price === 0 ? (w(), _("span", { key: 0, class: "price-style", onClick: (i) => re(e.row) }, u(t(xe)(e.row.price, 2)), 9, Le)) : (w(), _("span", qe, "-"))]), _: 1 }), n(o, { key: "totalPrice", prop: "totalPrice", "show-overflow-tooltip": "", label: "总价（元）", align: "center" }, { default: s((e) => [p("span", null, u(e.row.totalPrice ?? "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[C, t(d).loading]]), n(t(Ne)), n(t(Ie), { visible: j.value, "onUpdate:visible": r[0] || (r[0] = (e) => j.value = e), onRefresh: r[1] || (r[1] = (e) => ae()) }, null, 8, ["visible"]), n(t(Re), { visible: A.value, "onUpdate:visible": r[2] || (r[2] = (e) => A.value = e), currentRow: T.value }, null, 8, ["visible", "currentRow"]), n(t(je), { visible: S.value, "onUpdate:visible": r[3] || (r[3] = (e) => S.value = e), currentRow: T.value }, null, 8, ["visible", "currentRow"]), n(t(Ae), { visible: h.value, "onUpdate:visible": r[4] || (r[4] = (e) => h.value = e), "bool-bim": (b = t(l)) == null ? void 0 : b.boolBim, drawingSN: (y = t(l)) == null ? void 0 : y.drawingSN, "monomer-id": (g = t(l)) == null ? void 0 : g.monomerId, "serial-number": (v = t(l)) == null ? void 0 : v.serialNumber, productId: (P = t(l)) == null ? void 0 : P.productId, productType: (L = t(l)) == null ? void 0 : L.productType, projectType: (q = t(l)) == null ? void 0 : q.projectType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "serial-number", "productId", "productType", "projectType"]), n(t(Se), { modelValue: k.value, "onUpdate:modelValue": r[5] || (r[5] = (e) => k.value = e), drawingSN: (U = t(l)) == null ? void 0 : U.drawingSN, "bool-bim": (H = t(l)) == null ? void 0 : H.boolBim, "serial-number": (M = t(l)) == null ? void 0 : M.serialNumber, productId: (F = t(l)) == null ? void 0 : F.productId, productType: (O = t(l)) == null ? void 0 : O.productType, "monomer-id": ($ = t(l)) == null ? void 0 : $.monomerId }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType", "monomer-id"])]);
  };
} }, go = ve(Ue, [["__scopeId", "data-v-68dbc972"]]);
export {
  go as default
};
