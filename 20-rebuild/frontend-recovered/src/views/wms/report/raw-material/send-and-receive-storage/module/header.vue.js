import { inject as q } from "vue";
import { ref as I } from "vue";
import { watch as K } from "vue";
import { computed as X } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as Q } from "vue";
import { unref as e } from "vue";
import { createVNode as l } from "vue";
import { withCtx as r } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as D } from "vue";
import { createTextVNode as B } from "vue";
import { withDirectives as ee } from "vue";
import { ElDatePicker as oe } from "element-plus";
import { ElCol as se } from "element-plus";
import { ElRow as ae } from "element-plus";
import { _ as ne, Ch as te, B as le, yX as ie, yY as S, i as re, G as ue, jl as ce, pA as F, pz as de, jZ as me, r8 as pe, cJ as fe, ya as ye, C as ge, L as Te, Ci as ve, E as be, D as g } from "../../../../../../shared/runtime.js";
import { f as T } from "../../../../../../modules/enum-deb64dab.js";
import { P as v } from "../../../../../../modules/index-5b9e6004.js";
import { _ as Ce } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import { r as we } from "../../../../../../modules/reset-query-5216307c.js";
import he from "./form.vue.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
const _e = { class: "head-container" }, Ve = { key: 0 }, Ue = { __name: "header", emits: ["show-detail"], setup(Ae, { expose: $, emit: O }) {
  const b = q("closingTimeConfig"), R = O, j = q("permission"), _ = I(false), W = { wmsClosingTimeId: { value: void 0, resetAble: false }, createTime: { value: (/* @__PURE__ */ new Date()).getTime(), resetAble: false }, projectId: { value: void 0, resetAble: false }, workshopId: { value: void 0, resetAble: false }, projectWarehouseType: void 0, basicClass: { value: void 0, resetAble: false }, orderSupplyType: { value: void 0, resetAble: false }, unitType: { value: te.ACCOUNTING.V, resetAble: false }, dateTimeList: [] }, { CRUD: Y, crud: n, query: t } = le(W), { loaded: x, closeTimes: u, lastTime: z } = ie(), L = I(), m = I({});
  K([() => u.value, () => b.value], () => {
    if (b.value === S.SELF.V) if (re(u.value)) {
      const i = u.value[u.value.length - 1] || {};
      n.query.dateTimeList = [i.endTime ? Number(i.endTime) + 1 * 1e3 : (/* @__PURE__ */ new Date()).getTime(), (/* @__PURE__ */ new Date()).getTime()], n.toQuery();
    } else n.query.dateTimeList = [], n.toQuery();
  }, { immediate: true, deep: true });
  const M = X(() => ue(j.showAmount));
  function G(i) {
    return i > /* @__PURE__ */ new Date();
  }
  Y.HOOK.handleRefresh = async (i, { data: o }) => {
    const { weightedType: V, totalAmount: { beginPeriod: U = 0, transfer: C = 0, endPeriod: A = 0, inbound: c = 0, outbound: k = 0 } = {} } = o;
    L.value = V, m.value = { beginPeriod: U, transfer: C, endPeriod: A, inbound: c, outbound: k }, o.content.forEach((s) => {
      s.measureUnit = s.measure.measureUnit, s.accountingUnit = s.measure.accountingUnit, s.accountingPrecision = s.measure.accountingPrecision, s.measurePrecision = s.measure.measurePrecision;
    });
    const E = ["beginPeriod", "endPeriod", "inbound", "outbound", "transfer"], a = [];
    for (const s of o.content) {
      E.forEach((f) => {
        const P = ce(s[f], { basicClass: s.basicClass, measureUnit: s.measureUnit, accountingUnit: s.accountingUnit, accountingPrecision: s.accountingPrecision, measurePrecision: s.measurePrecision });
        a.push(P);
      }), s.multipleSpec = Array.isArray(s.specifications) && s.specifications.length > 1;
      const w = [], h = { basicClass: s.basicClass, thickness: s.thickness, width: s.width, length: s.length, color: s.color };
      if (Array.isArray(s.specifications)) for (const f of s.specifications) {
        h.specification = f;
        const P = F(h);
        w.push(P);
      }
      else {
        const f = F(h);
        w.push(f);
      }
      s.formatSpecArr = w, s.sourceFormatSpecArr = [...w], s.specTip = de({ ...h, specificationLabels: s.specificationLabels });
    }
    await Promise.all(a);
  };
  async function H(i) {
    await we(t), n.toQuery(), n.data = [], n.setColumns();
  }
  function p(i) {
    R("show-detail", i);
  }
  function J() {
    if (n.query.wmsClosingTimeId) {
      const i = u.value.find((o) => o.id === n.query.wmsClosingTimeId) || {};
      n.query.dateTimeList = [i.startTime, i.endTime];
    } else {
      const i = u.value[u.value.length - 1] || {};
      n.query.dateTimeList = [i.endTime ? Number(i.endTime) + 1 * 1e3 : (/* @__PURE__ */ new Date()).getTime(), (/* @__PURE__ */ new Date()).getTime()];
    }
    n.toQuery();
  }
  return $({ weightedType: L }), (i, o) => {
    const V = N("common-select"), U = oe, C = N("common-radio-button"), A = N("common-button"), c = se, k = ae, E = Z("permission");
    return d(), Q("div", _e, [e(n).searchToggle ? (d(), Q("div", Ve, [l(ye, { "basic-class": e(t).basicClass, query: e(t), "show-basic-class-query": false, "show-material-is-whole": false, "show-warehouse": false, "to-query": e(n).toQuery, multiple: "" }, { firstItem: r(() => [e(b) === e(S).SELF.V ? (d(), y(V, { key: 0, modelValue: e(t).wmsClosingTimeId, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).wmsClosingTimeId = a), options: e(u), dataStructure: { key: "id", label: "label", value: "id" }, clearable: "", disabled: !e(x), class: "filter-item", placeholder: "请选择关账名称", style: { width: "240px" }, onChange: J }, null, 8, ["modelValue", "options", "disabled"])) : (d(), y(U, { key: 1, modelValue: e(t).createTime, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).createTime = a), clearable: false, "default-time": i.defaultTime, "disabled-date": G, class: "filter-item", placeholder: "查询月份", "range-separator": ":", size: "default", style: { width: "135px" }, type: "month", "unlink-panels": "", "value-format": "x", onChange: e(n).toQuery }, null, 8, ["modelValue", "default-time", "onChange"]))]), afterWarehouse: r(() => [l(C, { modelValue: e(t).orderSupplyType, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).orderSupplyType = a), options: e(me).ENUM, "show-option-all": "", type: "enumSL", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(pe, { modelValue: e(t).workshopId, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).workshopId = a), class: "filter-item", placeholder: "仓库", clearable: "", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), l(e(Ce), { projectId: e(t).projectId, "onUpdate:projectId": o[4] || (o[4] = (a) => e(t).projectId = a), projectWarehouseType: e(t).projectWarehouseType, "onUpdate:projectWarehouseType": o[5] || (o[5] = (a) => e(t).projectWarehouseType = a), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), l(C, { modelValue: e(t).basicClass, "onUpdate:modelValue": o[6] || (o[6] = (a) => e(t).basicClass = a), options: e(fe).ENUM, class: "filter-item", "show-option-all": "", type: "enum", size: "default", onChange: H }, null, 8, ["modelValue", "options"])]), _: 1 }, 8, ["basic-class", "query", "to-query"]), l(e(ge))])) : D("", true), l(e(be), { "show-grid": false, "show-refresh": false, "show-search": false }, { optLeft: r(() => o[14] || (o[14] = [])), viewLeft: r(() => [e(b) === e(S).SELF.V ? (d(), y(A, { key: 0, loading: i.closingLoading, type: "primary", disabled: !e(x), onClick: o[7] || (o[7] = (a) => _.value = true) }, { default: r(() => o[15] || (o[15] = [B("手动关账")])), _: 1, __: [15] }, 8, ["loading", "disabled"])) : D("", true), ee((d(), y(Te, { fn: e(ve), params: e(t), "response-header-result": "" }, { default: r(() => o[16] || (o[16] = [B(" 下载收发存报表（根据查询条件） ")])), _: 1, __: [16] }, 8, ["fn", "params"])), [[E, e(j).get]])]), _: 1 }), M.value ? (d(), y(k, { key: 1, gutter: 20, class: "panel-group" }, { default: r(() => [l(c, { span: 5, class: "card-panel-col", onClick: o[8] || (o[8] = (a) => p(e(T).BEGIN_PERIOD.V)) }, { default: r(() => [l(e(v), { "end-val": m.value.beginPeriod || 0, precision: e(g).YUAN, name: "期初总额（本次账套）", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 }), l(c, { span: 5, class: "card-panel-col", onClick: o[9] || (o[9] = (a) => p(e(T).TRANSFER.V)) }, { default: r(() => [l(e(v), { "end-val": m.value.transfer || 0, precision: e(g).YUAN, name: "调拨总额（本次账套）", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 }), l(c, { span: 5, class: "card-panel-col", onClick: o[10] || (o[10] = (a) => p(e(T).END_PERIOD.V)) }, { default: r(() => [l(e(v), { "end-val": m.value.inbound || 0, precision: e(g).YUAN, name: "入库总额（本次账套）", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 }), l(c, { span: 5, class: "card-panel-col", onClick: o[11] || (o[11] = (a) => p(e(T).INBOUND.V)) }, { default: r(() => [l(e(v), { "end-val": m.value.outbound || 0, precision: e(g).YUAN, name: "出库总额（本次账套）", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 }), l(c, { span: 4, class: "card-panel-col", onClick: o[12] || (o[12] = (a) => p(e(T).OUTBOUND.V)) }, { default: r(() => [l(e(v), { "end-val": m.value.endPeriod || 0, precision: e(g).YUAN, name: "期末结存（本次账套）", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })) : D("", true), l(e(he), { modelValue: _.value, "onUpdate:modelValue": o[13] || (o[13] = (a) => _.value = a), onSuccess: e(n).toQuery, lastTime: e(z) }, null, 8, ["modelValue", "onSuccess", "lastTime"])]);
  };
} }, xe = ne(Ue, [["__scopeId", "data-v-c857f3b8"]]);
export {
  xe as default
};
