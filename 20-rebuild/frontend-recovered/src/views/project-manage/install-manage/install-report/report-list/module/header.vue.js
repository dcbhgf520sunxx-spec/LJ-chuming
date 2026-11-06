import { ref as g } from "vue";
import { watch as h } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as Q } from "vue";
import { createElementBlock as B } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as z } from "vue";
import { unref as e } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as n } from "vue";
import { createBlock as O } from "vue";
import { withCtx as i } from "vue";
import { createCommentVNode as X } from "vue";
import { withKeys as I } from "vue";
import A from "moment";
import { ElDatePicker as Y } from "element-plus";
import { ElCol as G } from "element-plus";
import { ElRow as F } from "element-plus";
import { ElInput as H } from "element-plus";
import { vLoading as $ } from "element-plus";
import { a as J } from "../../../../../../modules/report-list-f9da4d70.js";
import { _ as W, m as Z, K as V, kM as d, F as b, B as ee, q as te, G as ae, C as ne, E as le } from "../../../../../../shared/runtime.js";
import p from "../../../../components/Panel/index.vue.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
const oe = { class: "head-container" }, re = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(c) {
  const { installTypeEnumArr: E } = Z("installTypeEnumArr"), m = c, U = { projectId: { value: void 0, resetAble: false }, date: void 0, startDate: void 0, endDate: void 0, productType: m.globalProject.projectType === V.STEEL.V ? d.ARTIFACT.V : b.BOX.V, monomerId: void 0, areaId: void 0, name: void 0, serialNumber: void 0, supplierName: void 0, areaType: void 0 }, { crud: r, query: t } = ee(U), w = { key: "id", label: "name", value: "id" }, T = g([]), u = g({}), y = g(false);
  h(() => m.projectId, (a) => {
    a && (r.query.projectId = m.projectId, r.toQuery());
  }, { immediate: true, deep: true }), h(t, (a) => {
    a && x();
  }, { immediate: true, deep: true });
  async function x() {
    if (!(!t.projectId || t.productType === d.AUXILIARY.V)) {
      y.value = true;
      try {
        const a = await J(t);
        u.value = { ...a, installRate: a.receivingQuantity && a.installQuantity ? a.installQuantity / a.receivingQuantity * 100 : 0, totalQuantity: [{ quantity: a.quantity, unit: a.measureUnit, precision: 0 }, { quantity: a.mete, unit: a.accountingUnit, precision: 2 }], totalInstall: [{ quantity: a.installQuantity, unit: a.measureUnit, precision: 0 }, { quantity: a.installMete, unit: a.accountingUnit, precision: 2 }], extraQuantity: [{ quantity: a.receivingQuantity ? a.receivingQuantity - (a.installQuantity || 0) : 0, unit: a.measureUnit, precision: 0 }, { quantity: a.receivingMete ? a.receivingMete - (a.installMete || 0) : 0, unit: a.accountingUnit, precision: 2 }] };
      } catch (a) {
        console.log("获取汇总数据", a);
      } finally {
        y.value = false;
      }
    }
  }
  function C() {
    t.date && t.date.length > 1 ? (t.startDate = A(t.date[0]).valueOf(), t.endDate = A(t.date[1]).valueOf()) : (t.startDate = void 0, t.endDate = void 0), r.toQuery();
  }
  function L(a) {
    T.value = a || [];
  }
  function R(a) {
    t.areaId = void 0, r.toQuery();
  }
  return (a, l) => {
    const k = Y, q = v("common-radio-button"), D = v("common-select"), s = G, N = F, f = H, S = v("print-table"), M = $, P = K("permission");
    return Q(), B("div", oe, [_(j("div", null, [n(k, { modelValue: e(t).date, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(t).date = o), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" }, onChange: C }, null, 8, ["modelValue"]), n(q, { modelValue: e(t).productType, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(t).productType = o), options: c.globalProject.projectType === e(V).STEEL.V ? e(E) : [e(b).BOX, e(b).AUXILIARY_MATERIAL], type: "enum", class: "filter-item", onChange: R }, null, 8, ["modelValue", "options"]), n(e(te), { ref: "monomerSelectRef", modelValue: e(t).monomerId, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(t).monomerId = o), "project-id": e(t).projectId, "main-product-type": c.globalProject.projectType === e(V).STEEL.V && e(t).productType !== e(d).AUXILIARY.V ? e(t).productType : "", default: false, clearable: "", class: "filter-item", onChange: e(r).toQuery, onGetAreaInfo: L }, null, 8, ["modelValue", "project-id", "main-product-type", "onChange"]), n(D, { modelValue: e(t).areaId, "onUpdate:modelValue": l[3] || (l[3] = (o) => e(t).areaId = o), options: T.value, type: "other", dataStructure: w, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[z, e(r).searchToggle]]), e(ae)(e(r).permission.get) && e(t).productType !== e(d).AUXILIARY.V ? _((Q(), O(N, { key: 0, gutter: 20, class: "panel-group" }, { default: i(() => [n(s, { span: 6, class: "card-panel-col" }, { default: i(() => [n(e(p), { name: "清单总量", "text-color": "#626262", "num-color": "#1890ff", "num-arr": u.value.totalQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), n(s, { span: 6, class: "card-panel-col" }, { default: i(() => [n(e(p), { name: "已安装", "text-color": "#626262", "num-color": "#1890ff", "num-arr": u.value.totalInstall, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), n(s, { span: 6, class: "card-panel-col" }, { default: i(() => [n(e(p), { name: "剩余未安装", "text-color": "#626262", "num-color": "#1890ff", "num-arr": u.value.extraQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), n(s, { span: 6, class: "card-panel-col" }, { default: i(() => [n(e(p), { name: "安装率(%)", "text-color": "#626262", "num-color": "#1890ff", "end-val": u.value.installRate || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[M, y.value]]) : X("", true), n(e(le), null, { optLeft: i(() => [j("div", null, [n(f, { modelValue: e(t).supplierName, "onUpdate:modelValue": l[4] || (l[4] = (o) => e(t).supplierName = o), modelModifiers: { trim: true }, placeholder: "供应商搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: I(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(f, { modelValue: e(t).serialNumber, "onUpdate:modelValue": l[5] || (l[5] = (o) => e(t).serialNumber = o), modelModifiers: { trim: true }, placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: I(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(f, { modelValue: e(t).name, "onUpdate:modelValue": l[6] || (l[6] = (o) => e(t).name = o), modelModifiers: { trim: true }, placeholder: "名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: I(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(ne))])]), viewLeft: i(() => [_(n(S, { "api-key": "installReportList", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[P, e(r).permission.print]])]), _: 1 })]);
  };
} }, ce = W(re, [["__scopeId", "data-v-42c557db"]]);
export {
  ce as default
};
