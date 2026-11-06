import { inject as J } from "vue";
import { ref as r } from "vue";
import { onMounted as G } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as g } from "vue";
import { unref as a } from "vue";
import { createVNode as i } from "vue";
import { withCtx as u } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as h } from "vue";
import { withDirectives as D } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as A } from "vue";
import { toDisplayString as Y } from "vue";
import { vShow as Z } from "vue";
import { Fragment as X } from "vue";
import { renderList as ee } from "vue";
import { ElLink as ae } from "element-plus";
import { e as se, b as te, c as oe, d as ne } from "../../../../../../modules/inventory-analysis-usage-4b0f952d.js";
import { _ as ie, B as le, jl as re, i as d, pA as ue, pz as ce, gF as de, jZ as me, cJ as pe, bl as Q, xY as fe, yA as ye, ap as he, ya as be, C as ge, L as Ce, G as P, BL as $, E as _e, j_ as we, p as _ } from "../../../../../../shared/runtime.js";
import { _ as Te } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import ve from "./balance-mode.vue.js";
import Se from "./manual-balance.vue.js";
import { r as Ve } from "../../../../../../modules/reset-query-5216307c.js";
import Ee from "./label-card/index.vue.js";
const Ie = { class: "head-container" }, Me = { key: 0 }, Ue = { class: "balance-mode" }, ke = { style: { display: "flex" } }, Be = { __name: "header", setup(je, { expose: O }) {
  const w = J("permission"), W = { projectId: { value: void 0, resetAble: false }, statisticsDateId: { value: void 0, resetAble: false }, workshopIds: { value: void 0, resetAble: false }, projectWarehouseType: void 0, basicClass: { value: void 0, resetAble: false }, orderSupplyType: { value: void 0, resetAble: false }, classifyIds: void 0 }, { CRUD: U, crud: o, query: t } = le(W), k = r(), q = r({}), m = r(), B = r(), T = r(false), v = r(false), p = r(), j = r();
  async function L() {
    const b = await te();
    m.value = b.map((s) => (s.label = d(s.name) ? `${s.name}(${d(s.startTime) ? _(s.startTime, "{y}-{m}-{d}") + " ~ " : ""} ${d(s.endTime) ? _(s.endTime, "{y}-{m}-{d}") : ""})` : `${d(s.startTime) ? _(s.startTime, "{y}-{m}-{d}") + " ~ " : ""} ${d(s.endTime) ? _(s.endTime, "{y}-{m}-{d}") : ""}`, s));
  }
  U.HOOK.handleRefresh = async (b, { data: s }) => {
    const { weightedType: S, totalAmount: { beginPeriod: f = 0, endPeriod: V = 0, inbound: E = 0, outbound: I = 0 } = {} } = s;
    k.value = S, q.value = { beginPeriod: f, endPeriod: V, inbound: E, outbound: I }, s.content.forEach((e) => {
      var n, c;
      e.specificationNames = (n = e.specificationList) == null ? void 0 : n.join(","), e.colorNames = (c = e.colorList) == null ? void 0 : c.join(","), e.measureUnit = e.measure.measureUnit, e.accountingUnit = e.measure.accountingUnit, e.accountingPrecision = e.measure.accountingPrecision, e.measurePrecision = e.measure.measurePrecision;
    });
    for (const e of s.content) {
      await re(e, { basicClass: e.basicClass, measureUnit: e.measureUnit, accountingUnit: e.accountingUnit, accountingPrecision: e.accountingPrecision, measurePrecision: e.measurePrecision }, { mete: ["beginStageTotalMete", "inboundStageTotalMete", "outboundStageTotalMete", "endStageTotalMete", "transferStageTotalMete"], quantity: ["beginStageTotalQuantity", "inboundStageTotalQuantity", "outboundStageTotalQuantity", "endStageTotalQuantity", "transferStageTotalQuantity"] });
      const n = [];
      let c = {};
      d(t.basicClass) ? c = { specification: e.specification, basicClass: e.basicClass, thickness: e.thickness, width: e.width, length: e.length } : c = { specification: e.specification, basicClass: e.basicClass, thickness: e.thickness, width: e.width, length: e.length, color: e.color };
      const R = ue(c);
      n.push(R), e.formatSpecArr = n, e.sourceFormatSpecArr = [...n], e.specTip = ce({ ...c, specificationLabels: e.specificationLabels });
    }
  }, U.HOOK.beforeRefresh = async () => {
    B.value === m.value && await L(), B.value = JSON.parse(JSON.stringify(m.value));
  };
  async function F(b) {
    await Ve(o.query), o.data = [], o.setColumns(), o.toQuery();
  }
  function H() {
    T.value = true;
  }
  function z() {
    v.value = true;
  }
  async function x() {
    p.value = await oe();
  }
  async function N() {
    j.value = await ne(o.query);
  }
  return G(async () => {
    await N(), await x();
  }), O({ weightedType: k, inventoryBase: p, handleGetSteelCount: N }), (b, s) => {
    const S = M("common-select"), f = M("common-radio-button"), V = M("common-button"), E = ae, I = K("permission");
    return l(), g("div", Ie, [a(o).searchToggle ? (l(), g("div", Me, [i(be, { "basic-class": a(t).basicClass, query: a(t), "show-brand": false, "show-coil-max-length": false, "show-coil-min-length": false, "show-heat-no-and-batch-no": false, "show-material": false, "show-material-is-whole": false, "show-warehouse": false, "to-query": a(o).toQuery, multiple: "" }, { firstItem: u(() => [i(S, { modelValue: a(t).statisticsDateId, "onUpdate:modelValue": s[0] || (s[0] = (e) => a(t).statisticsDateId = e), dataStructure: { key: "id", label: "label", value: "id" }, options: m.value, class: "filter-item", default: "", placeholder: "请选择", size: "default", style: { width: "300px" }, type: "other", onChange: a(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), i(de, { modelValue: a(t).workshopIds, "onUpdate:modelValue": s[1] || (s[1] = (e) => a(t).workshopIds = e), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "230px" }, onChange: a(o).toQuery }, null, 8, ["modelValue", "onChange"])]), afterWarehouse: u(() => [i(f, { modelValue: a(t).orderSupplyType, "onUpdate:modelValue": s[2] || (s[2] = (e) => a(t).orderSupplyType = e), options: a(me).ENUM, class: "filter-item", "show-option-all": "", type: "enumSL", onChange: a(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), i(f, { modelValue: a(t).basicClass, "onUpdate:modelValue": s[3] || (s[3] = (e) => a(t).basicClass = e), options: a(pe).ENUM, class: "filter-item", "show-option-all": "", type: "enum", onChange: F }, null, 8, ["modelValue", "options"]), [a(Q).STEEL_PLATE.V, a(Q).SECTION_STEEL.V].includes(a(t).basicClass) ? (l(), y(f, { key: 0, modelValue: a(t).materialIsWhole, "onUpdate:modelValue": s[4] || (s[4] = (e) => a(t).materialIsWhole = e), options: a(fe).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: a(o).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : h("", true)]), secondLineFirstItem: u(() => [i(a(Te), { projectId: a(t).projectId, "onUpdate:projectId": s[5] || (s[5] = (e) => a(t).projectId = e), projectWarehouseType: a(t).projectWarehouseType, "onUpdate:projectWarehouseType": s[6] || (s[6] = (e) => a(t).projectWarehouseType = e), class: "filter-item", onChange: a(o).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), a(t).basicClass & a(ye) ? h("", true) : (l(), y(he, { key: 0, modelValue: a(t).classifyIds, "onUpdate:modelValue": s[7] || (s[7] = (e) => a(t).classifyIds = e), "basic-class": a(t).basicClass, "check-strictly": "", class: "filter-item", clearable: "", multiple: "", placeholder: "可选择/输入科目、编号搜索", separator: " > ", "show-all-levels": "", size: "default", style: { width: "300px" }, onChange: a(o).toQuery }, null, 8, ["modelValue", "basic-class", "onChange"]))]), _: 1 }, 8, ["basic-class", "query", "to-query"]), i(a(ge))])) : h("", true), i(a(_e), { "show-grid": false, "show-refresh": false, "show-search": false }, { optLeft: u(() => [D((l(), y(Ce, { fn: a(se), params: a(t), "response-header-result": "" }, { default: u(() => s[10] || (s[10] = [C(" 下载库存使用分析（根据查询条件） ")])), _: 1, __: [10] }, 8, ["fn", "params"])), [[I, a(w).get]])]), viewLeft: u(() => {
      var e, n;
      return [a(P)(a(w).manualBalance) && ((e = p.value) == null ? void 0 : e.boolEndMonth) === a($).HAND_MOVEMENT.V ? (l(), y(V, { key: 0, class: "filter-item", type: "primary", onClick: z }, { default: u(() => s[11] || (s[11] = [C(" 手动结存 ")])), _: 1, __: [11] })) : h("", true), A("div", Ue, [C(" 当前结存模式：" + Y(a($).VL[(n = p.value) == null ? void 0 : n.boolEndMonth]) + " ", 1), a(P)(a(w).modeChange) ? (l(), y(E, { key: 0, underline: false, style: { "margin-left": "5px" }, type: "success", onClick: H }, { default: u(() => s[12] || (s[12] = [C(" 模式变更 ")])), _: 1, __: [12] })) : h("", true)])];
    }), _: 1 }), D(A("div", ke, [(l(true), g(X, null, ee(j.value, (e, n) => (l(), g("div", { key: n, style: { width: "20%", "padding-right": "10px" } }, [i(Ee, { content: e, name: n }, null, 8, ["content", "name"])]))), 128))], 512), [[Z, a(t).basicClass & a(we).STEEL.V]]), i(ve, { visible: T.value, "onUpdate:visible": s[8] || (s[8] = (e) => T.value = e), inventoryBase: p.value, onHandleInventoryBase: x }, null, 8, ["visible", "inventoryBase"]), i(Se, { visible: v.value, "onUpdate:visible": s[9] || (s[9] = (e) => v.value = e), statisticsDate: m.value, onHandleStatisticsDate: L }, null, 8, ["visible", "statisticsDate"])]);
  };
} }, Oe = ie(Be, [["__scopeId", "data-v-b661afb7"]]);
export {
  Oe as default
};
