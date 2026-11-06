import { computed as k } from "vue";
import { provide as le } from "vue";
import { ref as c } from "vue";
import { watch as se } from "vue";
import { resolveComponent as T } from "vue";
import { withDirectives as de } from "vue";
import { unref as d } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as n } from "vue";
import { createBlock as m } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as P } from "vue";
import { createTextVNode as D } from "vue";
import { normalizeStyle as ue } from "vue";
import { Fragment as N } from "vue";
import { renderList as I } from "vue";
import { createCommentVNode as u } from "vue";
import { ElPopover as ce } from "element-plus";
import { vLoading as fe } from "element-plus";
import { _ as me, jY as pe, yW as ge, t as he, x as be, Ce as w, Cf as ye, Cg as _e, o as ve, h4 as W, pB as xe, G as L, cS as C, Ch as V, cP as Te, k5 as Pe, bV as B, D as Ce, a as Ae } from "../../../../../shared/runtime.js";
import ke from "./module/header.vue.js";
import Ne from "./module/detail.vue.js";
import "../../../../../modules/enum-deb64dab.js";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/reset-query-5216307c.js";
import "./module/form.vue.js";
const Se = { class: "app-container", "element-loading-text": "正在加载数据..." }, Ee = { class: "spec-box" }, Ue = { key: 0 }, we = { key: 1 }, Ve = { class: "icon expand-click-8 pointer" }, Oe = { style: { "margin-top": "20px" } }, qe = { style: { "font-weight": "bold" } }, Re = { key: 0 }, je = { __name: "index", setup(De) {
  pe();
  const H = k(() => ge());
  le("closingTimeConfig", H);
  const M = c({ resizable: true }), $ = c({ isCurrent: true, isHover: true }), F = c({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), { decimalPrecision: G } = he(), z = { batchAdd: false, add: false, edit: false, del: false, download: false }, h = ({ cellValue: t }) => t || "-", b = ({ cellValue: t }) => t ? B(t, G.value.wms) : "-", y = ({ cellValue: t }) => t || t === 0 ? B(t, Ce.YUAN) : "-", Y = ({ cellValue: t }) => t ? t == null ? void 0 : t.shortName : "-", O = c({}), q = c(), A = c(false), S = c(), K = c(), { crud: a, columns: E, CRUD: J } = be({ title: "收发存报表", sort: ["id.desc"], invisibleColumns: ["classifySerialNumber"], permission: { ...w }, optShow: { ...z }, hasPagination: false, crudApi: { get: ye, detail: _e } }, K);
  J.HOOK.handleRefresh = (t, { data: o }) => {
    o.content = o.content.map((e, i) => (e.searialNumber = i + 1, e));
  };
  const { maxHeight: Q } = ve({ paginate: true }), X = k(() => {
    var t;
    return ((t = S.value) == null ? void 0 : t.weightedType) === W.WHOLE.V ? !a.query.projectId && a.query.projectWarehouseType && a.query.projectWarehouseType !== xe.PUBLIC.V && E.value.visible("project") : E.value.visible("project");
  }), g = k(() => {
    var t;
    return ((t = S.value) == null ? void 0 : t.weightedType) === W.WHOLE.V ? !(a.query.projectId || a.query.projectWarehouseType) && L(w.showAmount) : L(w.showAmount);
  }), _ = k(() => a.query.unitType === C.ACCOUNTING.V);
  se([() => a.data, () => a.query.unitType], ([t, o]) => {
    t && t.length > 0 && (o = t.forEach((e) => {
      let i;
      switch (o) {
        case V.MEASURE.V:
          e.measureUnit ? i = C.MEASURE.V : i = C.ACCOUNTING.V;
          break;
        case V.ACCOUNTING.V:
          i = C.ACCOUNTING.V;
          break;
        case V.OUTBOUND.V:
          i = e.outboundUnitType;
          break;
      }
      e.beginPeriod || (e.beginPeriod = {}), e.endPeriod || (e.endPeriod = {}), e.inbound || (e.inbound = {}), e.outbound || (e.outbound = {}), e.transfer || (e.transfer = {}), i === C.MEASURE.V ? (e.currentUnit = e.measureUnit, e.beginPeriod.number = e.beginPeriod.quantity, e.endPeriod.number = e.endPeriod.quantity, e.inbound.number = e.inbound.quantity, e.outbound.number = e.outbound.quantity, e.transfer.number = e.transfer.quantity) : (e.currentUnit = e.accountingUnit, e.beginPeriod.number = e.beginPeriod.mete, e.endPeriod.number = e.endPeriod.mete, e.inbound.number = e.inbound.mete, e.outbound.number = e.outbound.mete, e.transfer.number = e.transfer.mete);
    }));
  }, { immediate: true, deep: true });
  function Z({ row: t, $rowIndex: o, column: e, $columnIndex: i }) {
    if (e.property && e.property.indexOf("beginPeriod") !== -1) return { "background-color": "#f5ffef" };
    if (e.property && e.property.indexOf("inbound") !== -1) return { "background-color": "#fff9e9" };
    if (e.property && e.property.indexOf("outbound") !== -1) return { "background-color": "#fbf1eb" };
    if (e.property && e.property.indexOf("endPeriod") !== -1) return { "background-color": "#e5eaf4" };
  }
  function ee({ row: t, column: o }) {
    if (o.property && o.property.indexOf("beginPeriod") !== -1) return "col-green";
    if (o.property && o.property.indexOf("inbound") !== -1) return "col-yellow";
    if (o.property && o.property.indexOf("outbound") !== -1) return "col-red";
    if (o.property && o.property.indexOf("endPeriod") !== -1) return "col-blue";
  }
  function te({ row: t }) {
    O.value = t, A.value = true;
  }
  function ie(t) {
    q.value = t, A.value = true;
  }
  return (t, o) => {
    const e = T("table-cell-tag"), i = T("vxe-column"), R = T("vxe-tooltip"), ne = Ae, re = ce, v = T("vxe-colgroup"), oe = T("vxe-table"), ae = fe;
    return de((l(), f("div", Se, [n(d(ke), { ref_key: "headerRef", ref: S, onShowDetail: ie }, null, 512), (l(), m(oe, { key: `return_to_party_a_${d(a).query.basicClass}`, "cell-class-name": ee, "column-config": M.value, data: d(a).data, "empty-text": d(a).emptyText, "header-cell-style": Z, height: d(Q), "row-config": $.value, "scroll-y": F.value, border: "", class: "myTable-style", "show-overflow": "tooltip", stripe: "", onCellClick: te }, { default: s(() => [n(i, { align: "center", field: "searialNumber", fixed: "left", title: "序号", width: "70" }, { default: s(({ row: r }) => [n(e, { show: !!r.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), p("span", null, P(r.searialNumber), 1)]), _: 1 }), n(i, { align: "center", field: "classifySerialNumber", fixed: "left", "show-overflow": "", title: "物料编号", width: "110px" }), n(i, { field: "materialSnNew", fixed: "left", "show-overflow": "", title: "材料编码", width: "125" }), n(i, { align: "center", field: "basicClass", fixed: "left", title: "分类", width: "100px" }, { default: s(({ row: r }) => [D(P(d(Te).VL[r.basicClass]), 1)]), _: 1 }), n(i, { align: "center", field: "classifyName", fixed: "left", "show-overflow": "", title: "名称", width: "200" }, { default: s(({ row: r }) => [n(e, { show: !!r.boolOddmentByHalfOut, color: "#e6a23c", name: "半出余料" }, null, 8, ["show"]), n(R, { content: r.classifyParentFullName, "enter-delay": 200, "model-value": !r.classifyParentFullName }, { default: s(() => [p("span", null, P(r.classifyName), 1)]), _: 2 }, 1032, ["content", "model-value"])]), _: 1 }), n(i, { align: "left", field: "specification", fixed: "left", "min-width": "200", title: "规格" }, { default: s(({ row: r }) => [p("div", Ee, [n(R, { content: r.specTip, placement: "top" }, { default: s(() => {
      var x;
      return [p("span", { style: ue({ "padding-right": r.multipleSpec ? "20px" : 0 }), class: "spec-info ellipsis-text" }, [(x = r.formatSpecArr) != null && x.length ? (l(true), f(N, { key: 0 }, I(r.formatSpecArr, (U, j) => (l(), f(N, { key: j }, [D(P(U) + " ", 1), j < r.formatSpecArr.length - 1 ? (l(), f("span", Ue, "  、  ")) : u("", true)], 64))), 128)) : (l(), f("span", we, "-"))], 4)];
    }), _: 2 }, 1032, ["content"]), r.multipleSpec ? (l(), m(re, { key: 0, title: `${r.classifyName}（${r.specTip}）【${r.sourceFormatSpecArr.length}种】`, width: 500, placement: "top", trigger: "click" }, { reference: s(() => [p("span", Ve, [n(ne, { "icon-class": "more", style: { flex: "none", color: "#2c2c2c" } })])]), default: s(() => [p("div", Oe, [(l(true), f(N, null, I(r.sourceFormatSpecArr, (x, U) => (l(), f(N, { key: x }, [p("span", qe, P(x), 1), U < r.sourceFormatSpecArr.length - 1 ? (l(), f("span", Re, "   /   ")) : u("", true)], 64))), 128))])]), _: 2 }, 1032, ["title"])) : u("", true)])]), _: 1 }), n(Pe, { "basic-class": d(a).query.basicClass, columns: d(E), "is-vxe": true, fixed: "left" }, null, 8, ["basic-class", "columns"]), n(i, { align: "center", field: "currentUnit", fixed: "left", title: "单位", width: "70" }), X.value ? (l(), m(i, { key: 0, formatter: Y, align: "left", field: "project", "min-width": "120", title: "项目" })) : u("", true), n(v, { align: "center", field: "beginPeriod", title: "期初数据" }, { default: s(() => [n(i, { formatter: h, align: "right", field: "beginPeriod.number", title: "数量", width: "100" }), g.value && _.value ? (l(), m(i, { key: 0, formatter: b, align: "right", field: "beginPeriod.unitPriceExcludingVAT", title: "单价(不含税)", width: "120" })) : u("", true), n(i, { formatter: y, align: "right", field: "beginPeriod.amountExcludingVAT", title: "金额(不含税)", width: "120" })]), _: 1 }), n(v, { align: "center", field: "transfer", title: "调拨数据" }, { default: s(() => [n(i, { formatter: h, align: "right", field: "transfer.number", title: "数量", width: "100" }), g.value && _.value ? (l(), m(i, { key: 0, formatter: b, align: "right", field: "transfer.unitPriceExcludingVAT", title: "单价(不含税)", width: "120" })) : u("", true), n(i, { formatter: y, align: "right", field: "transfer.amountExcludingVAT", title: "金额(不含税)", width: "120" })]), _: 1 }), n(v, { align: "center", field: "inbound", title: "入库数据" }, { default: s(() => [n(i, { formatter: h, align: "right", field: "inbound.number", title: "数量", width: "100" }), g.value && _.value ? (l(), m(i, { key: 0, formatter: b, align: "right", field: "inbound.unitPriceExcludingVAT", title: "单价(不含税)", width: "120" })) : u("", true), n(i, { formatter: y, align: "right", field: "inbound.amountExcludingVAT", title: "金额(不含税)", width: "120" })]), _: 1 }), n(v, { align: "center", field: "outbound", title: "出库数据" }, { default: s(() => [n(i, { formatter: h, align: "right", field: "outbound.number", title: "数量", width: "100" }), g.value && _.value ? (l(), m(i, { key: 0, formatter: b, align: "right", field: "outbound.unitPriceExcludingVAT", title: "单价(不含税)", width: "120" })) : u("", true), n(i, { formatter: y, align: "right", field: "outbound.amountExcludingVAT", title: "金额(不含税)", width: "120" })]), _: 1 }), n(v, { align: "center", field: "endPeriod", title: "期末数据" }, { default: s(() => [n(i, { formatter: h, align: "right", field: "endPeriod.number", title: "数量", width: "100" }), g.value && _.value ? (l(), m(i, { key: 0, formatter: b, align: "right", field: "endPeriod.unitPriceExcludingVAT", title: "单价(不含税)", width: "120" })) : u("", true), n(i, { formatter: y, align: "right", field: "endPeriod.amountExcludingVAT", title: "金额(不含税)", width: "120" })]), _: 1 })]), _: 1 }, 8, ["column-config", "data", "empty-text", "height", "row-config", "scroll-y"])), n(d(Ne), { visible: A.value, "onUpdate:visible": o[0] || (o[0] = (r) => A.value = r), date: d(a).query.createTime, formType: q.value, "material-info": O.value, showAmount: g.value, dateTimeList: d(a).query.dateTimeList, wmsClosingTimeId: d(a).query.wmsClosingTimeId }, null, 8, ["visible", "date", "formType", "material-info", "showAmount", "dateTimeList", "wmsClosingTimeId"])])), [[ae, d(a).loading]]);
  };
} }, Ye = me(je, [["__scopeId", "data-v-d96d75d7"]]);
export {
  Ye as default
};
