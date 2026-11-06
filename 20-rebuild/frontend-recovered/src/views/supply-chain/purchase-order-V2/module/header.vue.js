import { _ as W, B as X, I as Z, uP as ee, jS as te, jO as oe, iF as le, fE as k, aV as ne, uR as ae, cE as se, fv as ie, iH as ue, bE as re, C as de, G as me, t5 as pe, t0 as ce, E as fe, uS as ye, a as ve, j0 as I } from "../../../../shared/runtime.js";
import { ref as y } from "vue";
import { computed as ge } from "vue";
import Q from "moment";
import { inject as Ve } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as _e } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as D } from "vue";
import { unref as e } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as n } from "vue";
import { createBlock as r } from "vue";
import { createCommentVNode as S } from "vue";
import { withKeys as O } from "vue";
import { withCtx as d } from "vue";
import { withDirectives as v } from "vue";
import { withModifiers as R } from "vue";
import { createTextVNode as b } from "vue";
import { resolveDynamicComponent as he } from "vue";
import { defineAsyncComponent as z } from "vue";
import { ElDatePicker as Ce } from "element-plus";
import { ElInput as be } from "element-plus";
import { ElBadge as we } from "element-plus";
import Se from "./components/storage-list.vue.js";
import { P as g } from "../../../../modules/index-5b9e6004.js";
import Ee from "../../components/audit-records.vue.js";
import Te from "./components/amount-search.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const Pe = { class: "head-container" }, xe = { key: 0 }, Ue = { class: "panel-group flex-rsc" }, Ae = { style: { width: "20%", "padding-right": "10px" } }, Ne = { style: { width: "20%", "padding-right": "10px" } }, ke = { style: { width: "20%", "padding-right": "10px" } }, Ie = { style: { width: "20%", "padding-right": "10px" } }, Qe = { style: { width: "20%" } }, De = { __name: "header", props: { TStotal: { type: Number, default: 0 }, APPtotal: { type: Number, default: 0 }, subTotal: { type: Number, default: 0 }, rejTotal: { type: Number, default: 0 } }, setup(M, { expose: j }) {
  const $ = y([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), E = y(null), L = { paySettleRef: z(() => I(() => import("./payment-settlement/payment-settlement.vue.js"), ["static/js/payment-settlement-aad4fc95.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/js/payment-settlement-a7865af1.js", "static/js/index-c31ef5ad.js", "static/js/index-70e7196a.js", "static/css/payment-settlement-a7bda6b1.css", "static/css/el-radio-group-3b9ac3ad.css"])), invoiceEntryRef: z(() => I(() => import("./invoice-entry/index.vue.js"), ["static/js/index-f478ebf5.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-621a498e.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/invoice-entry-d59b5377.js", "static/js/payment-settlement-a7865af1.js", "static/js/hook-467b8301.js", "static/js/second-table-2bea9b32.js", "static/js/useTableTotal-3d22365a.js", "static/css/second-table-ef9e55de.css", "static/js/invoice-info-df16e446.js", "static/js/invoice-entry-d5222a89.js", "static/css/index-159374b3.css"])) }, B = ge(() => L[E.value]), V = y(null), T = (u) => {
    E.value = u, V.value && (V.value.visible = true);
  }, H = (u) => {
    u && (V.value.visible = true);
  }, c = M, K = { createTime: [Q().startOf("year").valueOf(), Q().valueOf()], orderSupplyType: void 0, basicClass: void 0, purchaseType: void 0, settlementStatus: void 0, purchaseStatus: void 0, projectId: void 0, serialNumber: void 0, branchCompanyId: void 0, supplierId: void 0, operatorName: void 0, boolAnnual: void 0, level: void 0, workshopId: void 0, orderPlace: void 0, dataStatus: void 0, purchaseAmount: [] }, _ = Ve("permission"), { crud: a, query: l } = X(K), w = y(false), m = y({});
  async function P() {
    let u = {};
    try {
      const t = await ye({ createTime: l.createTime });
      t.contractAmount && (t.contractAmount = Number((t.contractAmount / 1e4).toFixed(4))), u = t || {};
    } catch (t) {
      console.log("获取项目数量", t);
    } finally {
      m.value = u;
    }
  }
  function x() {
    a.refresh(), P();
  }
  function q() {
  }
  return j({ fetchSummary: P }), (u, t) => {
    const F = Ce, p = C("common-radio-button"), Y = C("common-select"), U = be, h = C("common-button"), A = ve, G = we, J = C("print-table"), f = _e("permission");
    return i(), D("div", Pe, [e(a).searchToggle ? (i(), D("div", xe, [t[19] || (t[19] = s("div", null, null, -1)), n(F, { modelValue: e(l).createTime, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(l).createTime = o), "default-time": $.value, shortcuts: e(Z), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: x }, null, 8, ["modelValue", "default-time", "shortcuts"]), t[20] || (t[20] = s("br", null, null, -1)), s("div", Ue, [s("div", Ae, [n(e(g), { "end-val": m.value.annualPurchaseQuantity || 0, precision: 0, name: "采购订单（数量）", "text-color": "#626262" }, null, 8, ["end-val"])]), s("div", Ne, [n(e(g), { "end-val": m.value.processingOrder || 0, precision: 0, name: "执行中（数量）", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])]), s("div", ke, [n(e(g), { "end-val": m.value.settlementOrder || 0, precision: 0, name: "已结算（数量）", "num-color": "#67c23a", "text-color": "#626262" }, null, 8, ["end-val"])]), s("div", Ie, [n(e(g), { "end-val": m.value.notSettlementOrder || 0, precision: 0, name: "未结算（数量）", "num-color": "#f56c6c", "text-color": "#626262" }, null, 8, ["end-val"])]), s("div", Qe, [n(e(g), { "end-val": m.value.newThisMonth || 0, precision: 0, name: "本月新增（数量）", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])])]), t[21] || (t[21] = s("br", null, null, -1)), n(p, { modelValue: e(l).dataStatus, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(l).dataStatus = o), options: e(ee).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(p, { modelValue: e(l).boolAnnual, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(l).boolAnnual = o), options: e(te).ENUM, class: "filter-item", "show-option-all": "", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(p, { modelValue: e(l).purchaseStatus, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(l).purchaseStatus = o), options: e(oe).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(p, { modelValue: e(l).settlementStatus, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(l).settlementStatus = o), options: e(le).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(p, { modelValue: e(l).orderPlace, "onUpdate:modelValue": t[5] || (t[5] = (o) => e(l).orderPlace = o), options: e(k).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(l).level === e(k).FACTORY.V ? (i(), r(ne, { key: 0, modelValue: e(l).workshopId, "onUpdate:modelValue": t[6] || (t[6] = (o) => e(l).workshopId = o), placeholder: "关联车间", class: "filter-item", clearable: "", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"])) : S("", true), n(p, { modelValue: e(l).boolDetail, "onUpdate:modelValue": t[7] || (t[7] = (o) => e(l).boolDetail = o), options: e(ae).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t[22] || (t[22] = s("br", null, null, -1)), n(Y, { modelValue: e(l).basicClass, "onUpdate:modelValue": t[8] || (t[8] = (o) => e(l).basicClass = o), options: e(se).ENUM, class: "filter-item", placeholder: "请选择材料类型", clearable: "", size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(U, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[9] || (t[9] = (o) => e(l).serialNumber = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按采购合同编号搜索", size: "default", style: { width: "200px" }, onKeyup: O(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(ie), { modelValue: e(l).projectId, "onUpdate:modelValue": t[10] || (t[10] = (o) => e(l).projectId = o), class: "filter-item", clearable: "", isAll: "", placeholder: "所属项目", style: { width: "250px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(ue, { modelValue: e(l).branchCompanyId, "onUpdate:modelValue": t[11] || (t[11] = (o) => e(l).branchCompanyId = o), class: "filter-item", placeholder: "采购单位", clearable: "", style: { width: "250px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(re, { modelValue: e(l).supplierId, "onUpdate:modelValue": t[12] || (t[12] = (o) => e(l).supplierId = o), type: e(l).purchaseType, class: "filter-item", clearable: "", placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "type", "onChange"]), n(Te, { class: "filter-item", query: e(l), onChange: e(a).toQuery }, null, 8, ["query", "onChange"]), n(U, { modelValue: e(l).operatorName, "onUpdate:modelValue": t[13] || (t[13] = (o) => e(l).operatorName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按操作人搜索", size: "default", style: { width: "200px" }, onKeyup: O(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(de))])) : S("", true), n(e(fe), null, { optLeft: d(() => {
      var o;
      return [v((i(), r(h, { class: "filter-item", icon: "el-icon-plus", size: "default", type: "primary", onClick: R(e(a).toAdd, ["stop"]) }, { default: d(() => t[23] || (t[23] = [b(" 采购订单 ")])), _: 1, __: [23] }, 8, ["onClick"])), [[f, e(a).permission.add]]), v((i(), r(h, { class: "filter-item", size: "default", type: "success", onClick: t[14] || (t[14] = (N) => T("paySettleRef")) }, { default: d(() => [n(A, { "icon-class": "contract-collection", style: { "margin-right": "5px" } }), t[24] || (t[24] = b(" 付款申请 "))]), _: 1, __: [24] })), [[f, e(_).pay_application]]), v((i(), r(h, { class: "filter-item", size: "default", type: "warning", onClick: t[15] || (t[15] = (N) => T("invoiceEntryRef")) }, { default: d(() => [n(A, { "icon-class": "contract-invoice", style: { "margin-right": "5px" } }), t[25] || (t[25] = b(" 发票入账 "))]), _: 1, __: [25] })), [[f, e(_).invoice_entry]]), e(me)(e(a).permission.scmTemporaryStoragePM.get) ? (i(), r(G, { key: 0, hidden: !c.TStotal, value: c.TStotal, class: "item", style: { "z-index": "10" } }, { default: d(() => [v((i(), r(h, { class: "filter-item", size: "default", type: "warning", onClick: t[16] || (t[16] = R((N) => w.value = true, ["stop"])) }, { default: d(() => t[26] || (t[26] = [b(" 暂存列表 ")])), _: 1, __: [26] })), [[f, e(_).temporary]])]), _: 1 }, 8, ["hidden", "value"])) : S("", true), v(n(J, { params: e(a).query, "api-key": "scmPurchaseDetail", class: "filter-item", size: "mini", type: "warning", onSuccess: e(a).selectAllChange }, null, 8, ["params", "onSuccess"]), [[f, (o = e(_)) == null ? void 0 : o.print]])];
    }), viewLeft: d(() => [n(Ee, { "module-type": e(pe).SUPPLY_CHAIN.V, "component-name-list": e(ce).PURCHASE_ORDER_V2.V, APPtotal: c.APPtotal, "rej-total": c.rejTotal, subTotal: c.subTotal, onOpenAPLists: q, onHandleSuccess: t[17] || (t[17] = (o) => e(a).toQuery()) }, null, 8, ["module-type", "component-name-list", "APPtotal", "rej-total", "subTotal"])]), _: 1 }), n(Se, { modelValue: w.value, "onUpdate:modelValue": t[18] || (t[18] = (o) => w.value = o), onSuccess: x }, null, 8, ["modelValue"]), (i(), r(he(B.value), { ref_key: "currentComponentRef", ref: V, onComponentMounted: H }, null, 544))]);
  };
} }, Be = W(De, [["__scopeId", "data-v-41e9ae6e"]]);
export {
  Be as default
};
