import { ref as u } from "vue";
import { watch as F } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as x } from "vue";
import { createBlock as C } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as $ } from "vue";
import { unref as n } from "vue";
import { withDirectives as V } from "vue";
import { createElementVNode as Y } from "vue";
import { createCommentVNode as Z } from "vue";
import { isRef as ee } from "vue";
import { ElTag as te } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElPagination as le } from "element-plus";
import { vLoading as ne } from "element-plus";
import { d as ie } from "../../../../../modules/product-receive-send-storage-07e30ee6.js";
import { bw as v, u as re, J as se, o as ue, D as c, z as de, q as me, ba as pe } from "../../../../../shared/runtime.js";
const ce = { class: "header-div", style: { display: "flex" } }, be = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 }, detailQuery: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(f, { emit: M }) {
  const I = M, a = u({ monomerId: void 0, areaId: void 0, serialNumber: void 0, productType: v.BOX.V }), p = f, { visible: d, handleClose: N } = re({ emit: I, props: p }), { handleSizeChange: z, handleCurrentChange: T, total: S, setTotalPage: Q, queryPage: g } = se({ fetchHook: s });
  F(d, (i) => {
    i && s();
  });
  const h = u([]), w = u([]), O = u(), y = u(false), { maxHeight: B } = ue({ mainBox: ".type-detail", extraBox: [".el-drawer__header", ".header-div"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, d), j = u([["mete", ["to-fixed", c.COM_WT__KG]], ["inboundMete", ["to-fixed", c.COM_WT__KG]], ["outboundMete", ["to-fixed", c.COM_WT__KG]], ["stockMete", ["to-fixed", c.COM_WT__KG]]]), q = u([v.BOX]);
  function P(i) {
    return pe(i, { props: ["inboundQuantity", "inboundMete", "outboundQuantity", "outboundMete", "quantity", "mete", "stockMete", "stockQuantity"] });
  }
  function R(i) {
    w.value = i || [];
  }
  function D() {
    a.value.monomerId = void 0, a.value.areaId = void 0, a.value.productType = v.BOX.V, a.value.serialNumber = void 0, s();
  }
  async function s() {
    let i = [];
    y.value = true;
    try {
      const { content: t = [], totalElements: b } = await ie({ ...p.detailQuery, ...g, ...a.value });
      i = t, Q(b);
    } catch (t) {
      console.log("明细", t);
    } finally {
      h.value = i, y.value = false;
    }
  }
  return (i, t) => {
    const b = te, E = m("print-table"), H = m("common-radio-button"), G = m("common-select"), U = oe, k = m("common-button"), o = ae, K = m("common-table"), W = le, A = m("common-drawer"), L = J("permission"), X = ne;
    return x(), C(A, { ref_key: "drawerRef", ref: O, title: "详情", "close-on-click-modal": false, modelValue: n(d), "onUpdate:modelValue": t[4] || (t[4] = (r) => ee(d) ? d.value = r : null), direction: "rtl", "before-close": n(N), "custom-class": "type-detail", size: "90%" }, { titleAfter: l(() => [e(b, { size: "large" }, { default: l(() => [_($(`项目：${n(de)(f.detailInfo.project)}`), 1)]), _: 1 })]), titleRight: l(() => [V(e(E, { "api-key": "bridgeProductSendReceiveStorageDetail", params: { ...p.detailQuery, ...a.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[L, f.permission.detailPrint]])]), content: l(() => [Y("div", ce, [e(H, { modelValue: a.value.productType, "onUpdate:modelValue": t[0] || (t[0] = (r) => a.value.productType = r), options: q.value, type: "enum", class: "filter-item", style: { "margin-bottom": "10px" }, onChange: s }, null, 8, ["modelValue", "options"]), e(n(me), { ref: "monomerSelectRef", modelValue: a.value.monomerId, "onUpdate:modelValue": t[1] || (t[1] = (r) => a.value.monomerId = r), "project-id": p.detailInfo.project.id, default: false, clearable: "", class: "filter-item", style: { "margin-left": "3px" }, onChange: s, onGetAreaInfo: R }, null, 8, ["modelValue", "project-id"]), e(G, { modelValue: a.value.areaId, "onUpdate:modelValue": t[2] || (t[2] = (r) => a.value.areaId = r), options: w.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: s }, null, 8, ["modelValue", "options"]), e(U, { modelValue: a.value.serialNumber, "onUpdate:modelValue": t[3] || (t[3] = (r) => a.value.serialNumber = r), modelModifiers: { trim: true }, size: "default", placeholder: "编号搜索", style: { width: "200px", "margin-bottom": "10px", "margin-left": "3px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), e(k, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: s, style: { "margin-left": "10px", width: "73px", height: "29px" } }, { default: l(() => t[5] || (t[5] = [_(" 搜索 ")])), _: 1, __: [5] }), e(k, { class: "filter-item", size: "default", type: "warning", style: { width: "73px", height: "29px" }, icon: "el-icon-refresh-left", onClick: D }, { default: l(() => t[6] || (t[6] = [_("重置")])), _: 1, __: [6] })]), n(d) ? V((x(), C(K, { key: 0, data: h.value, "data-format": j.value, "show-summary": "", "summary-method": P, "max-height": n(B) }, { default: l(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "length", prop: "length", label: "长度(mm)", align: "center", "show-overflow-tooltip": "" }), e(o, { label: "清单数(件/kg)", align: "center" }, { default: l(() => [e(o, { key: "quantity", prop: "quantity", label: "清单数", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "mete", prop: "mete", label: "重量", align: "center", "show-overflow-tooltip": "" })]), _: 1 }), e(o, { label: "入库(件/kg)", align: "center" }, { default: l(() => [e(o, { key: "inboundQuantity", prop: "inboundQuantity", label: "入库数", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "inboundMete", prop: "inboundMete", label: "重量", align: "center", "show-overflow-tooltip": "" })]), _: 1 }), e(o, { label: "出库(件/kg)", align: "center" }, { default: l(() => [e(o, { key: "outboundQuantity", prop: "outboundQuantity", label: "出库数", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "outboundMete", prop: "outboundMete", label: "重量", align: "center", "show-overflow-tooltip": "" })]), _: 1 }), e(o, { label: "库存(件/kg)", align: "center" }, { default: l(() => [e(o, { key: "stockQuantity", prop: "stockQuantity", label: "库存数", align: "center", "show-overflow-tooltip": "" }), e(o, { key: "stockMete", prop: "stockMete", label: "重量", align: "center", "show-overflow-tooltip": "" })]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[X, y.value]]) : Z("", true), e(W, { total: n(S), "current-page": n(g).pageNumber, "page-size": n(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(z), onCurrentChange: n(T) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  be as default
};
