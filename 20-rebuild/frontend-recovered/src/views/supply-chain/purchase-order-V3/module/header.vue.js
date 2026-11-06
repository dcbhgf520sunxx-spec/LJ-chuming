import { ref as g } from "vue";
import w from "moment";
import { inject as K } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as N } from "vue";
import { unref as e } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as t } from "vue";
import { withDirectives as _ } from "vue";
import { createBlock as y } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as b } from "vue";
import { withKeys as P } from "vue";
import { withModifiers as U } from "vue";
import { createTextVNode as x } from "vue";
import { ElDatePicker as $ } from "element-plus";
import { ElCol as q } from "element-plus";
import { ElRow as F } from "element-plus";
import { ElInput as Y } from "element-plus";
import { ElBadge as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { _ as W, B as X, I as Z, G as A, uP as ee, jS as le, jO as te, iF as oe, fE as ae, jP as ne, iH as se, bE as ue, C as re, t0 as de, t5 as ie, E as me, uS as pe } from "../../../../shared/runtime.js";
import ce from "./components/storage-list.vue.js";
import { P as i } from "../../../../modules/index-5b9e6004.js";
import fe from "../../components/audit-records.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const ye = { class: "head-container" }, ve = { key: 0 }, Ve = { __name: "header", props: { TStotal: { type: Number, default: 0 }, APPtotal: { type: Number, default: 0 }, subTotal: { type: Number, default: 0 }, rejTotal: { type: Number, default: 0 } }, setup(j, { expose: I }) {
  const Q = g([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), m = j, k = { createTime: [w().startOf("year").valueOf(), w().valueOf()], orderSupplyType: void 0, materialType: void 0, purchaseType: void 0, settlementStatus: void 0, purchaseStatus: void 0, projectId: void 0, serialNumber: void 0, branchCompanyId: void 0, supplierId: void 0, operatorName: void 0, boolAnnual: void 0, level: void 0, dataStatus: void 0 }, O = K("permission"), { crud: n, query: a } = X(k), v = g(false), u = g({});
  async function C() {
    let V = {};
    try {
      const l = await pe({ createTime: a.createTime });
      l.contractAmount && (l.contractAmount = Number((l.contractAmount / 1e4).toFixed(4))), V = l || {};
    } catch (l) {
      console.log("获取项目数量", l);
    } finally {
      u.value = V;
    }
  }
  function h() {
    n.refresh(), C();
  }
  return I({ fetchSummary: C }), (V, l) => {
    const M = $, r = q, z = F, p = c("common-radio-button"), R = c("common-select"), T = Y, B = c("project-cascader"), S = c("common-button"), D = G, H = J, E = L("permission");
    return d(), N("div", ye, [e(n).searchToggle ? (d(), N("div", ve, [l[15] || (l[15] = f("div", null, null, -1)), t(M, { modelValue: e(a).createTime, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(a).createTime = o), "default-time": Q.value, shortcuts: e(Z), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "small", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: h }, null, 8, ["modelValue", "default-time", "shortcuts"]), l[16] || (l[16] = f("br", null, null, -1)), e(A)(e(n).permission.get) ? _((d(), y(z, { key: 0, gutter: 20, class: "panel-group" }, { default: s(() => [t(r, { span: 4, class: "card-panel-col" }, { default: s(() => [t(e(i), { "end-val": u.value.annualPurchaseQuantity || 0, precision: 0, name: "采购订单（数量）", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), t(r, { span: 4, class: "card-panel-col" }, { default: s(() => [t(e(i), { "end-val": u.value.contractAmount || 0, precision: 4, name: "采购合同额（万元）", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), t(r, { span: 4, class: "card-panel-col" }, { default: s(() => [t(e(i), { "end-val": u.value.processingOrder || 0, precision: 0, name: "执行中（数量）", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), t(r, { span: 4, class: "card-panel-col" }, { default: s(() => [t(e(i), { "end-val": u.value.settlementOrder || 0, precision: 0, name: "已结算（数量）", "num-color": "#67c23a", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), t(r, { span: 4, class: "card-panel-col" }, { default: s(() => [t(e(i), { "end-val": u.value.notSettlementOrder || 0, precision: 0, name: "未结算（数量）", "num-color": "#f56c6c", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), t(r, { span: 4, class: "card-panel-col" }, { default: s(() => [t(e(i), { "end-val": u.value.newThisMonth || 0, precision: 0, name: "本月新增（数量）", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[H, e(n).loading]]) : b("", true), l[17] || (l[17] = f("br", null, null, -1)), t(p, { modelValue: e(a).dataStatus, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(a).dataStatus = o), options: e(ee).ENUM, class: "filter-item", "show-option-all": "", size: "small", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(p, { modelValue: e(a).boolAnnual, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(a).boolAnnual = o), options: e(le).ENUM, class: "filter-item", "show-option-all": "", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(p, { modelValue: e(a).purchaseStatus, "onUpdate:modelValue": l[3] || (l[3] = (o) => e(a).purchaseStatus = o), options: e(te).ENUM, class: "filter-item", "show-option-all": "", size: "small", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(p, { modelValue: e(a).settlementStatus, "onUpdate:modelValue": l[4] || (l[4] = (o) => e(a).settlementStatus = o), options: e(oe).ENUM, class: "filter-item", "show-option-all": "", size: "small", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(p, { modelValue: e(a).level, "onUpdate:modelValue": l[5] || (l[5] = (o) => e(a).level = o), options: e(ae).ENUM, class: "filter-item", "show-option-all": "", size: "small", type: "enumSL", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l[18] || (l[18] = f("br", null, null, -1)), t(R, { modelValue: e(a).materialType, "onUpdate:modelValue": l[6] || (l[6] = (o) => e(a).materialType = o), options: e(ne).ENUM, class: "filter-item", placeholder: "请选择材料类型", size: "small", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(T, { modelValue: e(a).serialNumber, "onUpdate:modelValue": l[7] || (l[7] = (o) => e(a).serialNumber = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按采购合同编号搜索", size: "small", style: { width: "200px" }, onKeyup: P(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(B, { modelValue: e(a).projectId, "onUpdate:modelValue": l[8] || (l[8] = (o) => e(a).projectId = o), class: "filter-item", clearable: "", placeholder: "所属项目", style: { width: "250px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), t(se, { modelValue: e(a).branchCompanyId, "onUpdate:modelValue": l[9] || (l[9] = (o) => e(a).branchCompanyId = o), class: "filter-item", placeholder: "合同签订主体", style: { width: "250px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), t(ue, { modelValue: e(a).supplierId, "onUpdate:modelValue": l[10] || (l[10] = (o) => e(a).supplierId = o), type: e(a).purchaseType, class: "filter-item", clearable: "", placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "type", "onChange"]), t(T, { modelValue: e(a).operatorName, "onUpdate:modelValue": l[11] || (l[11] = (o) => e(a).operatorName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按操作人搜索", size: "small", style: { width: "200px" }, onKeyup: P(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(re))])) : b("", true), t(e(me), null, { optLeft: s(() => [_((d(), y(S, { class: "filter-item", icon: "el-icon-plus", size: "default", type: "primary", onClick: U(e(n).toAdd, ["stop"]) }, { default: s(() => l[19] || (l[19] = [x(" 采购订单 ")])), _: 1, __: [19] }, 8, ["onClick"])), [[E, e(n).permission.add]]), e(A)(e(n).permission.scmTemporaryStoragePM.get) ? (d(), y(D, { key: 0, hidden: !m.TStotal, value: m.TStotal, class: "item" }, { default: s(() => [_((d(), y(S, { class: "filter-item", size: "default", type: "warning", onClick: l[12] || (l[12] = U((o) => v.value = true, ["stop"])) }, { default: s(() => l[20] || (l[20] = [x(" 暂存列表 ")])), _: 1, __: [20] })), [[E, e(O).temporary]])]), _: 1 }, 8, ["hidden", "value"])) : b("", true)]), viewLeft: s(() => [t(fe, { APPtotal: m.APPtotal, "component-name-list": e(de).PURCHASE_ORDER_V2.V, "module-type": e(ie).SUPPLY_CHAIN.V, "rej-total": m.rejTotal, subTotal: m.subTotal, onHandleSuccess: l[13] || (l[13] = (o) => e(n).toQuery()) }, null, 8, ["APPtotal", "component-name-list", "module-type", "rej-total", "subTotal"])]), _: 1 }), t(ce, { modelValue: v.value, "onUpdate:modelValue": l[14] || (l[14] = (o) => v.value = o), onSuccess: h }, null, 8, ["modelValue"])]);
  };
} }, Se = W(Ve, [["__scopeId", "data-v-563be116"]]);
export {
  Se as default
};
