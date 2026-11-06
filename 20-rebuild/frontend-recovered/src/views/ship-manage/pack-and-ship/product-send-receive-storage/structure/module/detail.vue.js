import { ref as g } from "vue";
import { watch as X } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as w } from "vue";
import { withCtx as o } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as u } from "vue";
import { unref as l } from "vue";
import { withDirectives as x } from "vue";
import { createElementVNode as p } from "vue";
import { withKeys as Z } from "vue";
import { createCommentVNode as ee } from "vue";
import { isRef as te } from "vue";
import { ElTag as ae } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElPagination as ne } from "element-plus";
import { vLoading as ie } from "element-plus";
import { d as re } from "../../../../../../modules/product-receive-send-storage-7de51d86.js";
import { u as se, J as ue, o as pe, D as b, z as de, p as S, q as ce, ng as me, bo as y, ba as ge } from "../../../../../../shared/runtime.js";
const fe = { class: "head-container" }, _e = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 }, detailQuery: { type: Object, default: () => {
} }, workshopId: { type: Number }, productType: { type: Number }, weightStatus: { type: Number }, dateTime: { type: [String, Array, Number] } }, emits: ["update:modelValue", "success"], setup(c, { emit: I }) {
  const Q = I, r = g({ monomerId: void 0, areaId: void 0, serialNumber: void 0 }), i = c, { visible: m, handleClose: z } = se({ emit: Q, props: i }), { handleSizeChange: M, handleCurrentChange: E, total: G, setTotalPage: R, queryPage: v } = ue({ fetchHook: d });
  X(m, (s) => {
    s && d();
  });
  const T = g([]), W = g([]), j = g(), N = g(false), { maxHeight: P } = pe({ mainBox: ".type-detail", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, m), q = g([["mete", ["to-fixed", b.COM_WT__KG]], ["inboundMete", ["to-fixed", b.COM_WT__KG]], ["outboundMete", ["to-fixed", b.COM_WT__KG]], ["stockMete", ["to-fixed", b.COM_WT__KG]], ["beginningMete", ["to-fixed", b.COM_WT__KG]]]);
  function D(s) {
    return ge(s, { props: ["inboundQuantity", "inboundMete", "outboundQuantity", "outboundMete", "quantity", "mete", "stockMete", "stockQuantity", "beginningQuantity", "beginningMete"] });
  }
  function O(s) {
    W.value = s || [];
  }
  async function d() {
    let s = [];
    N.value = true;
    try {
      console.log(i.detailQuery, "props");
      const { content: n = [], totalElements: h } = await re({ ...i.detailQuery, ...v, workshopId: i.workshopId, productType: i.productType, ...r.value });
      s = n, R(h);
    } catch (n) {
      console.log("明细", n);
    } finally {
      T.value = s, N.value = false;
    }
  }
  function B() {
    r.value = {}, d();
  }
  return (s, n) => {
    const h = ae, K = f("print-table"), A = f("common-select"), H = oe, C = f("common-button"), a = le, V = f("table-cell-tag"), U = f("common-table"), F = ne, L = f("common-drawer"), $ = Y("permission"), J = ie;
    return _(), w(L, { ref_key: "drawerRef", ref: j, title: "详情", "close-on-click-modal": false, modelValue: l(m), "onUpdate:modelValue": n[3] || (n[3] = (t) => te(m) ? m.value = t : null), direction: "rtl", "before-close": l(z), "custom-class": "type-detail", size: "90%" }, { titleAfter: o(() => [e(h, { size: "large" }, { default: o(() => [k(u(`项目：${l(de)(c.detailInfo.project)}`), 1)]), _: 1 }), e(h, { size: "large" }, { default: o(() => [k(u(`查询日期：${c.dateTime ? l(S)(c.dateTime[0], "{y}-{m}-{d}") + " ~ " + l(S)(c.dateTime[1], "{y}-{m}-{d}") : "-"}`), 1)]), _: 1 })]), titleRight: o(() => [x(e(K, { "api-key": "productSendReceiveStorageDetail", params: { ...i.detailQuery, ...r.value, workshopId: i.workshopId, productType: i.productType, weightStatus: i.weightStatus }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[$, c.permission.detailPrint]])]), content: o(() => [p("div", fe, [e(l(ce), { ref: "monomerSelectRef", modelValue: r.value.monomerId, "onUpdate:modelValue": n[0] || (n[0] = (t) => r.value.monomerId = t), "project-id": i.detailInfo.project.id, mainProductType: l(me).STRUCTURE.V, default: false, clearable: "", class: "filter-item", onChange: d, onGetAreaInfo: O }, null, 8, ["modelValue", "project-id", "mainProductType"]), e(A, { modelValue: r.value.areaId, "onUpdate:modelValue": n[1] || (n[1] = (t) => r.value.areaId = t), options: W.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: d }, null, 8, ["modelValue", "options"]), e(H, { modelValue: r.value.serialNumber, "onUpdate:modelValue": n[2] || (n[2] = (t) => r.value.serialNumber = t), modelModifiers: { trim: true }, size: "default", placeholder: "编号搜索", style: { width: "200px", "margin-left": "3px" }, class: "filter-item", clearable: "", onKeyup: Z(d, ["enter"]) }, null, 8, ["modelValue"]), e(C, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: d, style: { "margin-left": "10px" } }, { default: o(() => n[4] || (n[4] = [k(" 搜索 ")])), _: 1, __: [4] }), e(C, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: B }, { default: o(() => n[5] || (n[5] = [k(" 重置 ")])), _: 1, __: [5] })]), l(m) ? x((_(), w(U, { key: 0, data: T.value, "data-format": q.value, "show-summary": "", "summary-method": D, "max-height": l(P) }, { default: o(() => [e(a, { label: "序号", type: "index", align: "center", width: "60" }), e(a, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [t.boolAllPartSendDirectly ? (_(), w(V, { key: 0, name: "檩条直发", color: "#f56c6c" })) : (_(), w(V, { key: 1, show: !!t.typeName, name: t.typeName, color: t.typeName === "构件" ? "#67C23A" : "#409EFF" }, null, 8, ["show", "name", "color"])), p("span", null, u(t.monomerName ? t.monomerName : "-"), 1)]), _: 1 }), e(a, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": "" }), e(a, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), e(a, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), e(a, { key: "length", prop: "length", label: "长度(mm)", align: "center", "show-overflow-tooltip": "" }), e(a, { label: "清单数(件/kg)", align: "center" }, { default: o(() => [e(a, { key: "quantity", prop: "quantity", label: "清单数", align: "center", "show-overflow-tooltip": "" }), e(a, { key: "totalNetWeight", prop: "totalNetWeight", label: "总重", align: "center", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [p("span", null, u(i.weightStatus === l(y).NET.V ? t.totalNetWeight : t.totalGrossWeight), 1)]), _: 1 })]), _: 1 }), e(a, { label: "期初库存(件/kg)", align: "center" }, { default: o(() => [e(a, { key: "beginningQuantity", prop: "beginningQuantity", label: "库存数", align: "center", "show-overflow-tooltip": "" }), e(a, { key: "beginningNetWeight", prop: "beginningNetWeight", label: "总重", align: "center", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [p("span", null, u(i.weightStatus === l(y).NET.V ? t.beginningNetWeight : t.beginningGrossWeight), 1)]), _: 1 })]), _: 1 }), e(a, { label: "入库(件/kg)", align: "center" }, { default: o(() => [e(a, { key: "inboundQuantity", prop: "inboundQuantity", label: "入库数", align: "center", "show-overflow-tooltip": "" }), e(a, { key: "inboundNetWeight", prop: "inboundNetWeight", label: "总重", align: "center", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [p("span", null, u(i.weightStatus === l(y).NET.V ? t.inboundNetWeight : t.inboundGrossWeight), 1)]), _: 1 })]), _: 1 }), e(a, { label: "出库(件/kg)", align: "center" }, { default: o(() => [e(a, { key: "outboundQuantity", prop: "outboundQuantity", label: "出库数", align: "center", "show-overflow-tooltip": "" }), e(a, { key: "outboundNetWeight", prop: "outboundNetWeight", label: "总重", align: "center", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [p("span", null, u(i.weightStatus === l(y).NET.V ? t.outboundNetWeight : t.outboundGrossWeight), 1)]), _: 1 })]), _: 1 }), e(a, { label: "期末库存(件/kg)", align: "center" }, { default: o(() => [e(a, { key: "stockQuantity", prop: "stockQuantity", label: "库存数", align: "center", "show-overflow-tooltip": "" }), e(a, { key: "stockNetWeight", prop: "stockNetWeight", label: "总重", align: "center", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [p("span", null, u(i.weightStatus === l(y).NET.V ? t.stockNetWeight : t.stockGrossWeight), 1)]), _: 1 })]), _: 1 }), e(a, { label: "打包(件/kg)", align: "center" }, { default: o(() => [e(a, { key: "packageQuantity", prop: "packageQuantity", label: "打包数", align: "center", "show-overflow-tooltip": "" }), e(a, { key: "packageNetWeight", prop: "packageNetWeight", label: "总重", align: "center", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [p("span", null, u(i.weightStatus === l(y).NET.V ? t.packageNetWeight : t.packageGrossWeight), 1)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[J, N.value]]) : ee("", true), e(F, { total: l(G), "current-page": l(v).pageNumber, "page-size": l(v).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(M), onCurrentChange: l(E) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  _e as default
};
