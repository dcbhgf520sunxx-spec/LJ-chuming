import { ref as c } from "vue";
import { watch as J } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as C } from "vue";
import { createBlock as T } from "vue";
import { withCtx as a } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as u } from "vue";
import { unref as n } from "vue";
import { withDirectives as W } from "vue";
import { createElementVNode as p } from "vue";
import { withKeys as Y } from "vue";
import { createCommentVNode as Z } from "vue";
import { isRef as ee } from "vue";
import { ElTag as te } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElPagination as le } from "element-plus";
import { vLoading as ne } from "element-plus";
import { d as ie } from "../../../../../../modules/box-product-receive-send-storage-9ef20b12.js";
import { u as re, J as se, o as ue, D as b, z as de, p as pe, q as me, bo as y, ba as ce } from "../../../../../../shared/runtime.js";
const ge = { class: "header-div" }, he = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 }, detailQuery: { type: Object, default: () => {
} }, workshopId: { type: Number }, productType: { type: Number }, weightStatus: { type: Number }, dateTime: { type: [String, Array, Number] } }, emits: ["update:modelValue", "success"], setup(f, { emit: V }) {
  const S = V, r = c({ monomerId: void 0, areaId: void 0, serialNumber: void 0 }), i = f, { visible: m, handleClose: I } = re({ emit: S, props: i }), { handleSizeChange: z, handleCurrentChange: M, total: Q, setTotalPage: E, queryPage: w } = se({ fetchHook: d });
  J(m, (s) => {
    s && d();
  });
  const k = c([]), N = c([]), G = c(), v = c(false), { maxHeight: j } = ue({ mainBox: ".type-detail", extraBox: [".el-drawer__header", ".header-div"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, m), q = c([["mete", ["to-fixed", b.COM_WT__KG]], ["inboundMete", ["to-fixed", b.COM_WT__KG]], ["outboundMete", ["to-fixed", b.COM_WT__KG]], ["stockMete", ["to-fixed", b.COM_WT__KG]], ["beginningMete", ["to-fixed", b.COM_WT__KG]]]);
  function O(s) {
    return ce(s, { props: ["inboundQuantity", "inboundMete", "outboundQuantity", "outboundMete", "quantity", "mete", "stockMete", "stockQuantity", "beginningQuantity", "beginningMete"] });
  }
  function R(s) {
    N.value = s || [];
  }
  async function d() {
    let s = [];
    v.value = true;
    try {
      console.log(i.detailQuery, "props");
      const { content: l = [], totalElements: h } = await ie({ ...i.detailQuery, ...w, workshopId: i.workshopId, productType: i.productType, ...r.value });
      s = l, E(h);
    } catch (l) {
      console.log("明细", l);
    } finally {
      k.value = s, v.value = false;
    }
  }
  function B() {
    r.value = {}, d();
  }
  return (s, l) => {
    const h = te, D = g("print-table"), K = g("common-select"), P = oe, x = g("common-button"), o = ae, H = g("table-cell-tag"), A = g("common-table"), F = le, U = g("common-drawer"), L = X("permission"), $ = ne;
    return C(), T(U, { ref_key: "drawerRef", ref: G, title: "详情", "close-on-click-modal": false, modelValue: n(m), "onUpdate:modelValue": l[3] || (l[3] = (t) => ee(m) ? m.value = t : null), direction: "rtl", "before-close": n(I), "custom-class": "type-detail", size: "90%" }, { titleAfter: a(() => [e(h, { size: "large" }, { default: a(() => [_(u(`项目：${n(de)(f.detailInfo.project)}`), 1)]), _: 1 }), e(h, { size: "large" }, { default: a(() => [_(u(`查询日期：${f.dateTime ? n(pe)(f.dateTime, "{y}-{m}") : "-"}`), 1)]), _: 1 })]), titleRight: a(() => [W(e(D, { "api-key": "boxProductSendReceiveStorageDetail", params: { ...i.detailQuery, ...r.value, workshopId: i.workshopId, productType: i.productType }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[L, f.permission.detailPrint]])]), content: a(() => [p("div", ge, [e(n(me), { ref: "monomerSelectRef", modelValue: r.value.monomerId, "onUpdate:modelValue": l[0] || (l[0] = (t) => r.value.monomerId = t), "project-id": i.detailInfo.project.id, default: false, clearable: "", class: "filter-item", onChange: d, onGetAreaInfo: R }, null, 8, ["modelValue", "project-id"]), e(K, { modelValue: r.value.areaId, "onUpdate:modelValue": l[1] || (l[1] = (t) => r.value.areaId = t), options: N.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: d }, null, 8, ["modelValue", "options"]), e(P, { modelValue: r.value.serialNumber, "onUpdate:modelValue": l[2] || (l[2] = (t) => r.value.serialNumber = t), modelModifiers: { trim: true }, size: "default", placeholder: "编号搜索", style: { width: "200px", "margin-bottom": "10px", "margin-left": "3px" }, class: "filter-item", clearable: "", onKeyup: Y(d, ["enter"]) }, null, 8, ["modelValue"]), e(x, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: d, style: { "margin-left": "10px" } }, { default: a(() => l[4] || (l[4] = [_(" 搜索 ")])), _: 1, __: [4] }), e(x, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: B }, { default: a(() => l[5] || (l[5] = [_(" 重置 ")])), _: 1, __: [5] })]), n(m) ? W((C(), T(A, { key: 0, data: k.value, "data-format": q.value, "show-summary": "", "summary-method": O, "max-height": n(j) }, { default: a(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": "" }, { default: a(({ row: t }) => [e(H, { show: !!t.typeName, name: t.typeName, color: t.typeName === "构件" ? "#67C23A" : "#409EFF" }, null, 8, ["show", "name", "color"]), p("span", null, u(t.monomerName ? t.monomerName : "-"), 1)]), _: 1 }), e(o, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "length", prop: "length", label: "长度(mm)", align: "center", "show-overflow-tooltip": "" }), e(o, { label: "清单数(件/kg)", align: "center" }, { default: a(() => [e(o, { key: "quantity", prop: "quantity", label: "清单数", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "totalNetWeight", prop: "totalNetWeight", label: "总净重", align: "center", "show-overflow-tooltip": "" }, { default: a(({ row: t }) => [p("span", null, u(i.weightStatus === n(y).NET.V ? t.totalNetWeight : t.totalGrossWeight), 1)]), _: 1 })]), _: 1 }), e(o, { label: "期初库存(件/kg)", align: "center" }, { default: a(() => [e(o, { key: "beginningQuantity", prop: "beginningQuantity", label: "库存数", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "beginningNetWeight", prop: "beginningNetWeight", label: "总净重", align: "center", "show-overflow-tooltip": "" }, { default: a(({ row: t }) => [p("span", null, u(i.weightStatus === n(y).NET.V ? t.beginningNetWeight : t.beginningGrossWeight), 1)]), _: 1 })]), _: 1 }), e(o, { label: "入库(件/kg)", align: "center" }, { default: a(() => [e(o, { key: "inboundQuantity", prop: "inboundQuantity", label: "入库数", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "inboundNetWeight", prop: "inboundNetWeight", label: "总净重", align: "center", "show-overflow-tooltip": "" }, { default: a(({ row: t }) => [p("span", null, u(i.weightStatus === n(y).NET.V ? t.inboundNetWeight : t.inboundGrossWeight), 1)]), _: 1 })]), _: 1 }), e(o, { label: "出库(件/kg)", align: "center" }, { default: a(() => [e(o, { key: "outboundQuantity", prop: "outboundQuantity", label: "出库数", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "outboundNetWeight", prop: "outboundNetWeight", label: "总净重", align: "center", "show-overflow-tooltip": "" }, { default: a(({ row: t }) => [p("span", null, u(i.weightStatus === n(y).NET.V ? t.outboundNetWeight : t.outboundGrossWeight), 1)]), _: 1 })]), _: 1 }), e(o, { label: "期末库存(件/kg)", align: "center" }, { default: a(() => [e(o, { key: "stockQuantity", prop: "stockQuantity", label: "库存数", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "stockNetWeight", prop: "stockNetWeight", label: "总净重", align: "center", "show-overflow-tooltip": "" }, { default: a(({ row: t }) => [p("span", null, u(i.weightStatus === n(y).NET.V ? t.stockNetWeight : t.stockGrossWeight), 1)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[$, v.value]]) : Z("", true), e(F, { total: n(Q), "current-page": n(w).pageNumber, "page-size": n(w).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(z), onCurrentChange: n(M) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  he as default
};
