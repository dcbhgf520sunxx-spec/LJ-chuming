import { ref as v } from "vue";
import { inject as M } from "vue";
import { computed as ne } from "vue";
import { watch as se } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as l } from "vue";
import { withCtx as n } from "vue";
import { unref as t } from "vue";
import { createTextVNode as y } from "vue";
import { createCommentVNode as c } from "vue";
import { createBlock as _ } from "vue";
import { createElementVNode as P } from "vue";
import { withKeys as re } from "vue";
import { Fragment as K } from "vue";
import { withModifiers as ue } from "vue";
import { ElCol as ie } from "element-plus";
import { ElRow as de } from "element-plus";
import { ElDatePicker as pe } from "element-plus";
import { ElInput as me } from "element-plus";
import { ElButton as ce } from "element-plus";
import A from "../components/panel-echarts.vue.js";
import { _ as fe, pK as h, pM as b, i as Q, bZ as O, pL as Ie, G as F, pI as $, L as ve } from "../../../../../../../../shared/runtime.js";
import H from "../components/workshop-cascader.vue.js";
import ye from "./production-status.vue.js";
import { e as ke, f as Ce, h as Ne } from "../../../../../../../../modules/project-production-panel-fb6946a2.js";
import { a as Te } from "../../../../../../../../modules/project-production-statistics-850038ba.js";
import "../../../../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../../../../modules/index-18acf776.js";
const ge = { class: "form-panel-header" }, Ve = { key: 0, class: "head-container" }, he = { key: 0, class: "head-container" }, be = { class: "head-container flex" }, we = { __name: "form-header", setup(Se, { expose: q }) {
  const E = v(false), k = () => {
    w();
  }, C = M("projectId"), { query: o, defaultQuery: B, renderTable: f } = M("tableRelated"), g = v([]), G = v([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), Y = [h.UNFINISHED_ARTIFACT.V, h.PARTIAL_COMPLETION_ARTIFACT.V, h.UNFINISHED_ASSEMBLE.V, h.PARTIAL_CONPLETION_ASSEMBLE.V], N = ne(() => Y.includes(o.value.productKanBanEnum)), u = v({}), L = async () => {
    const { classId: p, serialNumber: e, productKanBanEnum: m, ...r } = o.value, I = await Ce(r);
    u.value = I;
  }, j = v([]), w = async () => {
    if (!F($.getFormList)) return;
    i.value && (o.value.classId = "");
    const { classId: p, serialNumber: e, productKanBanEnum: m, ...r } = o.value, { content: I = [] } = await Ne({ ...r, productType: b.CONSTRUCT.V });
    j.value = I;
  }, Z = () => f(), J = () => {
    o.value = B(), f();
  };
  function R() {
    L(), w(), f(), g.value = [], N.value && S();
  }
  function U() {
    o.value = B(), L(), w(), f(), g.value = [], N.value && S();
  }
  const D = v(b.CONSTRUCT.V), x = (p) => {
    D.value = p, E.value = true;
  }, i = v(false);
  function W() {
    i.value = !i.value, U();
  }
  async function S() {
    try {
      const p = { projectId: C.value, monomerId: o.monomerId, areaIdList: o.areaIdList, productType: o.productType }, { content: e = [] } = await Te(p);
      g.value = e;
    } catch (p) {
      console.log(p);
    }
  }
  function X() {
    N.value && S();
  }
  return se(() => C.value, () => {
    L(), w(), f(), g.value = [], N.value && S();
  }, { immediate: true }), q({ searchToggle: i }), (p, e) => {
    const m = z("common-select"), r = z("common-button"), I = ie, ee = de, te = pe, ae = me, oe = ce;
    return d(), V("div", ge, [i.value ? (d(), V("div", Ve, [l(t(O), { monomerId: t(o).monomerId, "onUpdate:monomerId": e[1] || (e[1] = (a) => t(o).monomerId = a), areaId: t(o).areaIds, "onUpdate:areaId": e[2] || (e[2] = (a) => t(o).areaIds = a), clearable: true, areaClearable: true, "project-id": t(C), onMonomerChange: k, onAreaChange: k }, { right: n(({ batchList: a }) => [l(m, { modelValue: t(o).areaBatchIds, "onUpdate:modelValue": e[0] || (e[0] = (s) => t(o).areaBatchIds = s), options: a, size: "default", multiple: "", collapseTags: "", dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", noDataText: t(Q)(t(C)) ? "暂无数据" : "未选择项目", class: "filter-item", placeholder: "请选择批次", style: { width: "200px" }, onChange: k }, null, 8, ["modelValue", "options", "noDataText"])]), _: 1 }, 8, ["monomerId", "areaId", "project-id"]), l(H, { workshopId: t(o).workShopId, "onUpdate:workshopId": e[3] || (e[3] = (a) => t(o).workShopId = a), productionLineId: t(o).productionLineId, "onUpdate:productionLineId": e[4] || (e[4] = (a) => t(o).productionLineId = a) }, null, 8, ["workshopId", "productionLineId"]), l(r, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: R }, { default: n(() => e[21] || (e[21] = [y("搜索")])), _: 1, __: [21] }), l(r, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: U }, { default: n(() => e[22] || (e[22] = [y(" 重置 ")])), _: 1, __: [22] })])) : c("", true), i.value ? (d(), _(ee, { key: 1, gutter: 18, style: { "margin-bottom": "20px" } }, { default: n(() => [l(I, { span: 8 }, { default: n(() => {
      var a, s, T;
      return [l(A, { onClick: e[5] || (e[5] = (le) => x(t(b).ACCESSORY.V)), "echart-id": "one", totalNum: ((a = u.value) == null ? void 0 : a.partTaskQuantity) || 0, finshNum: ((s = u.value) == null ? void 0 : s.partCompanyQuantity) || 0, heedTaskNum: ((T = u.value) == null ? void 0 : T.partNeedTaskQuantity) || 0, color: "#ffb729", name: "零件总任务" }, null, 8, ["totalNum", "finshNum", "heedTaskNum"])];
    }), _: 1 }), l(I, { span: 8 }, { default: n(() => {
      var a, s;
      return [l(A, { onClick: e[6] || (e[6] = (T) => x(t(b).PARTS.V)), "echart-id": "two", totalNum: ((a = u.value) == null ? void 0 : a.assembleTaskQuantity) || 0, finshNum: ((s = u.value) == null ? void 0 : s.assembleCompanyQuantity) || 0, color: "#004af4", name: "部件总任务" }, null, 8, ["totalNum", "finshNum"])];
    }), _: 1 }), l(I, { span: 8 }, { default: n(() => {
      var a, s, T;
      return [l(A, { onClick: e[7] || (e[7] = (le) => x(t(b).CONSTRUCT.V)), "echart-id": "three", totalNum: ((a = u.value) == null ? void 0 : a.artifactTaskQuantity) || 0, finshNum: ((s = u.value) == null ? void 0 : s.artifactCompanyQuantity) || 0, heedTaskNum: ((T = u.value) == null ? void 0 : T.artifactNoTaskQuantity) || 0, color: "#009f56", name: "构件总任务" }, null, 8, ["totalNum", "finshNum", "heedTaskNum"])];
    }), _: 1 })]), _: 1 })) : c("", true), P("div", null, [i.value ? c("", true) : (d(), V("div", he, [l(t(O), { monomerId: t(o).monomerId, "onUpdate:monomerId": e[9] || (e[9] = (a) => t(o).monomerId = a), areaId: t(o).areaIds, "onUpdate:areaId": e[10] || (e[10] = (a) => t(o).areaIds = a), clearable: true, areaClearable: true, "project-id": t(C), onMonomerChange: k, onAreaChange: k }, { right: n(({ batchList: a }) => [l(m, { modelValue: t(o).areaBatchIds, "onUpdate:modelValue": e[8] || (e[8] = (s) => t(o).areaBatchIds = s), options: a, size: "default", multiple: "", collapseTags: "", dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", noDataText: t(Q)(t(C)) ? "暂无数据" : "未选择项目", class: "filter-item", placeholder: "请选择批次", style: { width: "180px" }, onChange: k }, null, 8, ["modelValue", "options", "noDataText"])]), _: 1 }, 8, ["monomerId", "areaId", "project-id"]), l(H, { workshopId: t(o).workShopId, "onUpdate:workshopId": e[11] || (e[11] = (a) => t(o).workShopId = a), productionLineId: t(o).productionLineId, "onUpdate:productionLineId": e[12] || (e[12] = (a) => t(o).productionLineId = a) }, null, 8, ["workshopId", "productionLineId"])]))]), P("div", be, [P("div", null, [l(te, { modelValue: t(o).dateTimeList, "onUpdate:modelValue": e[13] || (e[13] = (a) => t(o).dateTimeList = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", "default-time": G.value, "value-format": "x", style: { width: "240px" }, onChange: t(f) }, null, 8, ["modelValue", "default-time", "onChange"]), l(m, { modelValue: t(o).classId, "onUpdate:modelValue": e[14] || (e[14] = (a) => t(o).classId = a), options: j.value, "data-structure": { key: "id", label: "classificationName", value: "id" }, class: "filter-item", clearable: true, style: { width: "200px" }, placeholder: "请选择类型" }, null, 8, ["modelValue", "options"]), l(m, { modelValue: t(o).productKanBanEnum, "onUpdate:modelValue": e[15] || (e[15] = (a) => t(o).productKanBanEnum = a), options: t(h).ENUM, class: "filter-item", clearable: true, style: { width: "200px" }, type: "enum", placeholder: "请选择状态", onChange: X }, null, 8, ["modelValue", "options"]), N.value ? (d(), _(m, { key: 0, modelValue: t(o).processId, "onUpdate:modelValue": e[16] || (e[16] = (a) => t(o).processId = a), options: g.value, "data-structure": { key: "id", label: "processName", value: "id" }, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "请选择工序" }, null, 8, ["modelValue", "options"])) : c("", true), N.value ? (d(), _(m, { key: 1, modelValue: t(o).processStatus, "onUpdate:modelValue": e[17] || (e[17] = (a) => t(o).processStatus = a), options: t(Ie).ENUM, type: "enum", class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "请选择工序状态" }, null, 8, ["modelValue", "options"])) : c("", true), l(ae, { onKeyup: re(t(f), ["enter"]), modelValue: t(o).serialNumber, "onUpdate:modelValue": e[18] || (e[18] = (a) => t(o).serialNumber = a), size: "default", placeholder: "输入编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["onKeyup", "modelValue"]), i.value ? (d(), V(K, { key: 2 }, [l(r, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: Z }, { default: n(() => e[23] || (e[23] = [y("搜索")])), _: 1, __: [23] }), l(r, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: J }, { default: n(() => e[24] || (e[24] = [y(" 重置 ")])), _: 1, __: [24] })], 64)) : c("", true), i.value ? c("", true) : (d(), V(K, { key: 3 }, [l(r, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: R }, { default: n(() => e[25] || (e[25] = [y("搜索")])), _: 1, __: [25] }), l(r, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: U }, { default: n(() => e[26] || (e[26] = [y(" 重置 ")])), _: 1, __: [26] })], 64))]), P("div", null, [t(F)(t($).download) ? (d(), _(t(ve), { key: 0, params: t(o), fn: t(ke), "response-header-result": "" }, { default: n(() => e[27] || (e[27] = [y(" 生产跟踪下载 ")])), _: 1, __: [27] }, 8, ["params", "fn"])) : c("", true), l(oe, { size: "default", plain: "", type: "info", icon: "el-icon-search", onClick: e[19] || (e[19] = ue((a) => W(), ["stop"])) })])]), l(ye, { visible: E.value, "onUpdate:visible": e[20] || (e[20] = (a) => E.value = a), "product-type": D.value }, null, 8, ["visible", "product-type"])]);
  };
} }, Re = fe(we, [["__scopeId", "data-v-57f242da"]]);
export {
  Re as default
};
