import { computed as y } from "vue";
import { ref as i } from "vue";
import b from "moment";
import { provide as W } from "vue";
import { watch as U } from "vue";
import { resolveComponent as Z } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as ee } from "vue";
import { createVNode as e } from "vue";
import { unref as a } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as S } from "vue";
import { withCtx as t } from "vue";
import { createCommentVNode as ae } from "vue";
import { resolveDynamicComponent as le } from "vue";
import { ElDatePicker as te } from "element-plus";
import { ElCol as oe } from "element-plus";
import { ElRow as ne } from "element-plus";
import { vLoading as se } from "element-plus";
import { c as re, s as ue } from "../../../../modules/shipment-tracking-bae05d4c.js";
import { _ as ie, t as ce, kM as d, jv as h, m as me, I, G as N, ab as B, kL as de, D as O } from "../../../../shared/runtime.js";
import { Q as j } from "../../../../modules/contract-9b18cc88.js";
import pe from "./box/index.vue.js";
import ve from "./structure/index.vue.js";
import fe from "./enclosure/index.vue.js";
import _e from "./auxiliary-material/index.vue.js";
import ye from "./straightener/index.vue.js";
import { P as s } from "../../../../modules/index-5b9e6004.js";
import he from "./audit.vue.js";
import "./box/module/header.vue.js";
import "./structure/module/header.vue.js";
import "./enclosure/module/header.vue.js";
import "./auxiliary-material/module/header.vue.js";
import "./straightener/module/header.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/manufactures-sales-return-578c5329.js";
import "../../../../modules/ship-manage-3066b2ed.js";
const Ee = { class: "app-container" }, ge = { class: "head-container common-container" }, we = { key: 0 }, xe = { key: 0 }, Ve = { __name: "index", setup(Te) {
  var P;
  const { decimalPrecision: E } = ce(), X = y(() => {
    switch (u.value) {
      case h.BOX.V:
        return pe;
      case d.ENCLOSURE.V:
        return fe;
      case d.AUXILIARY.V:
        return _e;
      case d.STRAIGHTENER.V:
        return ye;
      default:
        return ve;
    }
  }), { globalProject: $, installTypeEnumArr: g, hasBridgeMenu: Q } = me(["globalProject", "installTypeEnumArr", "hasBridgeMenu"]), u = i(), p = i(), v = i(false), l = i({}), w = i(), L = i(false), D = i(), z = i("view"), x = (P = I[1]) == null ? void 0 : P.value(), f = i([b(x[0]).valueOf(), b(x[1]).valueOf()]), G = i([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), V = y(() => {
    var o;
    return p.value ? ((o = $.value) == null ? void 0 : o.productCategory) === h.BOX.V ? [h.BOX] : (console.log(g.value), g.value) : Q.value ? [...g.value, h.BOX] : g.value;
  }), H = y(() => u.value === h.BOX.V), _ = y(() => u.value === d.AUXILIARY.V && d.STRAIGHTENER.V === u.value), T = y(() => ({ startDate: f.value[0], endDate: f.value[1], projectId: p.value, productType: u.value, handleMethod: w.value }));
  W("commonParams", T), U(T, () => {
    K();
  }, { immediate: true, deep: true }), U(p, (o) => {
    V.value.length && V.value.every((M) => M.V !== u.value) && (u.value = V.value[0].V);
  }, { immediate: true });
  function Y(o) {
    return o > /* @__PURE__ */ new Date();
  }
  function q() {
    f.value = [b(x[0]).valueOf(), b(x[1]).valueOf()];
  }
  async function K() {
    if (l.value = {}, !!N(j.summary)) try {
      v.value = true, H.value ? l.value = await re(T.value) || {} : l.value = await ue(T.value) || {};
    } catch (o) {
      console.log(o);
    } finally {
      v.value = false;
    }
  }
  function F(o, r, M) {
    o.boolExistReturn && (o.id = o.linkId, D.value = o, L.value = true);
  }
  return (o, r) => {
    const M = Z("project-radio-button"), J = te, n = oe, R = ne, k = se;
    return m(), A("div", Ee, [ee("div", ge, [e(M, { modelValue: p.value, "onUpdate:modelValue": r[0] || (r[0] = (c) => p.value = c), class: "filter-item", size: "default" }, null, 8, ["modelValue"]), e(B, { modelValue: u.value, "onUpdate:modelValue": r[1] || (r[1] = (c) => u.value = c), options: V.value, class: "filter-item", default: "", size: "default", type: "enum" }, null, 8, ["modelValue", "options"]), e(J, { modelValue: f.value, "onUpdate:modelValue": r[2] || (r[2] = (c) => f.value = c), clearable: false, "default-time": G.value, "disabled-date": Y, shortcuts: a(I), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "230px" }, type: "daterange", "value-format": "x" }, null, 8, ["modelValue", "default-time", "shortcuts"]), e(B, { modelValue: w.value, "onUpdate:modelValue": r[3] || (r[3] = (c) => w.value = c), options: a(de).ENUM, "show-option-all": true, class: "filter-item", size: "default", type: "enum" }, null, 8, ["modelValue", "options"]), a(N)(a(j).summary) ? (m(), A("div", we, [u.value === a(d).ENCLOSURE.V ? (m(), A("div", xe, [C((m(), S(R, { gutter: 10, class: "panel-group", style: { "margin-bottom": "10px" } }, { default: t(() => [e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { "end-val": l.value.shipLength || 0, name: "累计发运长度(米)", precision: a(O).MES_ENCLOSURE_L__M, "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 }), e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { "end-val": l.value.shipArea || 0, name: "累计发运面积(平方米)", precision: a(O).MES_ENCLOSURE_L__M, "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 }), e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { "end-val": l.value.shipAmount || 0, precision: a(E).contract, name: "累计发运额(元)", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })), [[k, v.value]]), C((m(), S(R, { gutter: 10, class: "panel-group" }, { default: t(() => [e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { name: "累计车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": l.value.cargoQuantity || 0, "show-empty": _.value }, null, 8, ["end-val", "show-empty"])]), _: 1 }), e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { "end-val": l.value.shipLengthTime || 0, name: "筛选日期发运长度(米)", precision: a(O).MES_ENCLOSURE_L__M, "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 }), e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { "end-val": l.value.shipAreaTime || 0, name: "筛选日期发运面积(平方米)", precision: a(O).MES_ENCLOSURE_L__M, "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 }), e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { "end-val": l.value.shipAmountTime || 0, precision: a(E).contract, name: "筛选日期发运额(元)", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })), [[k, v.value]])])) : C((m(), S(R, { key: 1, gutter: 10, class: "panel-group" }, { default: t(() => [e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { "end-val": l.value.shipMet || 0, name: "累计发运量(吨)", precision: 2, "show-empty": _.value, "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "show-empty"])]), _: 1 }), e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { "end-val": l.value.shipAmount || 0, precision: a(E).contract, name: "累计发运额(元)", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 }), e(n, { class: "card-panel-col", style: { flex: "5" } }, { default: t(() => [e(a(s), { name: "平均车次/船次吨位(吨)", "text-color": "#626262", "num-color": "#1890ff", "end-val": l.value.shipMetAvg || 0, precision: 2, "show-empty": _.value }, null, 8, ["end-val", "show-empty"])]), _: 1 }), e(n, { class: "card-panel-col", style: { flex: "3" } }, { default: t(() => [e(a(s), { name: "累计车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": l.value.cargoQuantity || 0, "show-empty": _.value }, null, 8, ["end-val", "show-empty"])]), _: 1 }), e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { "end-val": l.value.shipMetTime || 0, name: "筛选日期发运量(吨)", precision: 2, "show-empty": _.value, "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "show-empty"])]), _: 1 }), e(n, { class: "card-panel-col" }, { default: t(() => [e(a(s), { "end-val": l.value.shipAmountTime || 0, precision: a(E).contract, name: "筛选日期发运额(元)", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })), [[k, v.value]])])) : ae("", true)]), (m(), S(le(X.value), { handleMethod: w.value, "row-click": F, "row-style": { cursor: "pointer" }, onResetQuery: q }, null, 40, ["handleMethod"])), e(he, { visible: L.value, "onUpdate:visible": r[4] || (r[4] = (c) => L.value = c), "audit-type": z.value, "row-data": { ...D.value, productType: u.value } }, null, 8, ["visible", "audit-type", "row-data"])]);
  };
} }, ze = ie(Ve, [["__scopeId", "data-v-b331805e"]]);
export {
  ze as default
};
