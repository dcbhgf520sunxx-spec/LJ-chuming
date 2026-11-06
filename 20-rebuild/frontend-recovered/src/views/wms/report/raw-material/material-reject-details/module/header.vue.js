import { ref as v } from "vue";
import { inject as W } from "vue";
import { resolveComponent as K } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as w } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { withCtx as r } from "vue";
import { withKeys as y } from "vue";
import { createElementVNode as T } from "vue";
import { createCommentVNode as i } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as u } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as p } from "vue";
import { ElDatePicker as q } from "element-plus";
import { ElInput as B } from "element-plus";
import { ElTag as z } from "element-plus";
import { e as O } from "../../../../../../modules/reject-03b2f373.js";
import { jY as R, B as P, sQ as $, bl as A, bE as F, bF as _, gF as H, y3 as X, I as Y, ya as G, C as J, L as Z, j_ as C, bV as h, E as ee } from "../../../../../../shared/runtime.js";
import { _ as te } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import { r as se } from "../../../../../../modules/reset-query-5216307c.js";
const ae = { class: "head-container" }, le = { key: 0 }, oe = { class: "flex gap-2" }, pe = { __name: "header", props: { DetailsCount: { type: Object } }, setup(x) {
  const { reportCfg: b } = R(), m = x, j = v([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), E = { inboundTime: [], rejectTime: [], basicClass: void 0, projectId: void 0, projectWarehouseType: void 0, purchaseSN: void 0, inboundSN: void 0, rejectSN: void 0, supplierId: void 0, operatorName: void 0, workshopIds: [] }, I = W("permission"), { crud: l, query: t } = P(E), { baseUnit: S } = $(t.basicClass);
  async function k(N) {
    await se(t), l.toQuery(), l.data = [], l.setColumns();
  }
  return (N, a) => {
    const U = K("common-radio-button"), Q = q, c = B, f = z, D = L("permission");
    return n(), w("div", ae, [e(l).searchToggle ? (n(), w("div", le, [o(G, { "basic-class": e(t).basicClass, query: e(t), "show-material-is-whole": false, "show-warehouse": false, "to-query": e(l).toQuery, multiple: "" }, { afterProjectWarehouseType: r(() => [o(U, { modelValue: e(t).basicClass, "onUpdate:modelValue": a[0] || (a[0] = (s) => e(t).basicClass = s), options: e(A).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: k }, null, 8, ["modelValue", "options"]), o(F, { modelValue: e(t).supplierId, "onUpdate:modelValue": a[1] || (a[1] = (s) => e(t).supplierId = s), basicClass: e(t).basicClass, type: e(_).RAW_MATERIAL.V | e(_).OTHER.V, class: "filter-item", clearable: "", mode: "cross", placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "basicClass", "type", "onChange"])]), beforeWarehouse: r(() => [o(H, { modelValue: e(t).workshopIds, "onUpdate:modelValue": a[2] || (a[2] = (s) => e(t).workshopIds = s), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), o(X, { modelValue: e(t).warehouseId, "onUpdate:modelValue": a[3] || (a[3] = (s) => e(t).warehouseId = s), "basic-class": e(t).basicClass, "workshop-id": e(t).workshopIds, class: "filter-item", clearable: "", placeholder: "存储位置", "show-all": "", onChange: e(l).toQuery }, null, 8, ["modelValue", "basic-class", "workshop-id", "onChange"])]), secondLineFirstItem: r(() => [o(e(te), { projectId: e(t).projectId, "onUpdate:projectId": a[4] || (a[4] = (s) => e(t).projectId = s), projectWarehouseType: e(t).projectWarehouseType, "onUpdate:projectWarehouseType": a[5] || (a[5] = (s) => e(t).projectWarehouseType = s), class: "filter-item", onChange: e(l).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), o(Q, { modelValue: e(t).rejectTime, "onUpdate:modelValue": a[6] || (a[6] = (s) => e(t).rejectTime = s), "default-time": j.value, shortcuts: e(Y), class: "filter-item", "end-placeholder": "退货时间", "range-separator": ":", size: "default", "start-placeholder": "退货时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o(c, { modelValue: e(t).purchaseSN, "onUpdate:modelValue": a[7] || (a[7] = (s) => e(t).purchaseSN = s), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "采购合同编号", size: "default", style: { width: "160px" }, onKeyup: y(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(c, { modelValue: e(t).inboundSN, "onUpdate:modelValue": a[8] || (a[8] = (s) => e(t).inboundSN = s), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "入库单号", size: "default", style: { width: "160px" }, onKeyup: y(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(c, { modelValue: e(t).rejectSN, "onUpdate:modelValue": a[9] || (a[9] = (s) => e(t).rejectSN = s), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "退货单号", size: "default", style: { width: "160px" }, onKeyup: y(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(c, { modelValue: e(t).operatorName, "onUpdate:modelValue": a[10] || (a[10] = (s) => e(t).operatorName = s), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/编辑人/审核人", size: "default", style: { width: "160px" }, onKeyup: y(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a[11] || (a[11] = T("br", null, null, -1))]), _: 1 }, 8, ["basic-class", "query", "to-query"]), o(e(J))])) : i("", true), o(e(ee), null, { optLeft: r(() => [M((n(), u(Z, { fn: e(O), params: e(t), "response-header-result": "" }, { default: r(() => a[12] || (a[12] = [d(" 下载退货明细（根据查询条件） ")])), _: 1, __: [12] }, 8, ["fn", "params"])), [[D, e(I).get]])]), viewLeft: r(() => [T("div", oe, [e(t).basicClass & e(C).STEEL.V ? (n(), u(f, { key: 0, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "primary" }, { default: r(() => {
      var s;
      return [d(" 数量汇总：" + p(e(h)(((s = m.DetailsCount) == null ? void 0 : s.quantityCount) || 0)), 1)];
    }), _: 1 })) : i("", true), e(t).basicClass & e(C).STEEL.V ? (n(), u(f, { key: 1, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "success" }, { default: r(() => {
      var s, g, V;
      return [d(" 核算量汇总：" + p(e(h)(((s = m.DetailsCount) == null ? void 0 : s.meteCount) || 0)) + " " + p(((g = e(t)) == null ? void 0 : g.basicClass) & e(C).STEEL.V ? e(S)[(V = e(t)) == null ? void 0 : V.basicClass].weight.unit : ""), 1)];
    }), _: 1 })) : i("", true), e(b).amountShow ? (n(), u(f, { key: 2, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "info" }, { default: r(() => {
      var s;
      return [d(" 含税金额汇总：" + p(e(h)(((s = m.DetailsCount) == null ? void 0 : s.amountCount) || 0)) + " 元 ", 1)];
    }), _: 1 })) : i("", true), e(b).amountExcludingTAXShow ? (n(), u(f, { key: 3, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "warning" }, { default: r(() => {
      var s;
      return [d(" 不含税金额汇总：" + p(e(h)(((s = m.DetailsCount) == null ? void 0 : s.amountExcludingVatCount) || 0)) + " 元 ", 1)];
    }), _: 1 })) : i("", true)])]), _: 1 })]);
  };
} };
export {
  pe as default
};
