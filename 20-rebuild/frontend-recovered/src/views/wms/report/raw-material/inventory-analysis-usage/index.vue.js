import { ref as f } from "vue";
import { resolveComponent as v } from "vue";
import { withDirectives as T } from "vue";
import { unref as n } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as e } from "vue";
import { createBlock as O } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as c } from "vue";
import { createTextVNode as x } from "vue";
import { ElTableColumn as V } from "element-plus";
import { vLoading as L } from "element-plus";
import { g as P, a as A } from "../../../../../modules/inventory-analysis-usage-4b0f952d.js";
import { _ as B, x as E, BK as H, z as q, o as W, br as C, cP as F, xY as h, P as K } from "../../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import G from "./module/detail.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "./module/balance-mode.vue.js";
import "./module/manual-balance.vue.js";
import "../../../../../modules/reset-query-5216307c.js";
import "./module/label-card/index.vue.js";
const Y = { class: "app-container", "element-loading-text": "正在加载数据..." }, $ = { __name: "index", setup(J) {
  const M = { batchAdd: false, add: false, edit: false, del: false, download: false }, m = f({}), b = f(), u = f(false), y = f(), w = f(), { crud: r, columns: X, CRUD: I } = E({ label: "库存使用分析", sort: [""], invisibleColumns: ["classifySerialNumber"], requiredQuery: [], permission: { ...H }, optShow: { ...M }, hasPagination: true, crudApi: { get: P, detail: A } }, w);
  I.HOOK.handleRefresh = async (s, { data: o }) => {
    var t;
    await ((t = y.value) == null ? void 0 : t.handleGetSteelCount()), o.content = o.content.map((l, g) => {
      var p, a, d, S;
      return l.searialNumber = g + 1, l.warehouseNames = (p = l.warehouseNameList) == null ? void 0 : p.join(","), l.colorNames = (a = l.colorList) == null ? void 0 : a.join(","), l.projectInfoNames = (d = l.projectInfoList) == null ? void 0 : d.map((D) => q(D)).join(","), l.brandNames = (S = l.brandList) == null ? void 0 : S.join(","), l;
    });
  };
  const { maxHeight: R } = W({ paginate: true, extraHeight: 10 });
  function _({ row: s, column: o, rowIndex: t, columnIndex: l }) {
    if (o.property && o.property.indexOf("beginStageTotal") !== -1) return { backgroundColor: "#f5ffef" };
    if (o.property && o.property.indexOf("inboundStageTotal") !== -1) return { backgroundColor: "#fff9e9" };
    if (o.property && o.property.indexOf("outboundStageTotal") !== -1) return { backgroundColor: "#fbf1eb" };
    if (o.property && o.property.indexOf("endStageTotal") !== -1) return { backgroundColor: "#e5eaf4" };
  }
  function Q(s) {
    m.value = s, u.value = true;
  }
  function j(s) {
    b.value = s, u.value = true;
  }
  return (s, o) => {
    const t = V, l = v("vxe-tooltip"), g = v("common-table"), p = L;
    return T((k(), U("div", Y, [e(n(z), { ref_key: "headerRef", ref: y, onShowDetail: j }, null, 512), T((k(), O(g, { key: `return_to_party_a_${n(r).query.basicClass}`, ref_key: "tableRef", ref: w, "cell-style": _, data: n(r).data, "default-expand-all": false, "header-cell-style": _, "max-height": n(R), "highlight-current-row": "", "row-key": "id", onRowClick: Q, onSortChange: n(r).handleSortChange }, { default: i(() => [e(t, { key: "searialNumber", align: "center", fixed: "left", label: "序号", prop: "searialNumber", width: "70" }, { default: i(({ row: a }) => [e(C, { show: !!a.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), N("span", null, c(a.searialNumber), 1)]), _: 1 }), e(t, { key: "classifySerialNumber", align: "center", fixed: "left", label: "物料编号", prop: "classifySerialNumber", "show-overflow": "", width: "110px" }), e(t, { key: "materialSnNew", align: "center", fixed: "left", label: "材料编码", prop: "materialSnNew", "show-overflow": "", width: "125" }), e(t, { key: "basicClass", align: "center", fixed: "left", label: "分类", prop: "basicClass", width: "100px" }, { default: i(({ row: a }) => [x(c(n(F).VL[a.basicClass]), 1)]), _: 1 }), e(t, { key: "classifyName", align: "center", fixed: "left", label: "名称", prop: "classifyName", "show-overflow": "", width: "200" }, { default: i(({ row: a }) => {
      var d;
      return [e(C, { color: (d = n(h).V[a == null ? void 0 : a.materialIsWhole]) == null ? void 0 : d.COLOR, name: n(h).VL[a == null ? void 0 : a.materialIsWhole], offset: 15, show: (a == null ? void 0 : a.materialIsWhole) === n(h).ODDMENT.V }, null, 8, ["color", "name", "show"]), e(l, { content: a.classifyParentFullName, "enter-delay": 200, "model-value": !a.classifyParentFullName }, { default: i(() => [N("span", null, c(a.classifyName), 1)]), _: 2 }, 1032, ["content", "model-value"])];
    }), _: 1 }), e(t, { key: "specificationNames", align: "left", fixed: "left", label: "规格", "min-width": "200", prop: "specificationNames", "show-overflow-tooltip": "" }, { default: i(({ row: a }) => [x(c(a.specificationNames), 1)]), _: 1 }), e(t, { key: "colorNames", align: "center", label: "颜色", prop: "colorNames", "show-overflow-tooltip": "", width: "100" }), e(t, { key: "brandNames", align: "center", label: "品牌", prop: "brandNames", "show-overflow-tooltip": "", width: "100" }), e(t, { key: "heatNoAndBatchNoNames", align: "center", label: "炉批号", prop: "heatNoAndBatchNoNames", "show-overflow-tooltip": "", width: "100" }), e(t, { key: "measureUnit", align: "center", label: "计量单位", "min-width": "100", prop: "measureUnit" }), e(t, { key: "accountingUnit", align: "center", label: "核算单位", "min-width": "100", prop: "accountingUnit" }), e(t, { key: "projectInfoNames", label: "项目", "min-width": "150", prop: "projectInfoNames", "show-overflow-tooltip": "" }), e(t, { key: "warehouseNames", label: "仓库", "min-width": "220", prop: "warehouseNames", "show-overflow-tooltip": "" }), e(t, { key: "beginStageTotal", align: "center", label: "期初数据", prop: "beginStageTotal" }, { default: i(() => [e(t, { key: "beginStageTotalQuantity", align: "right", label: "数量", "min-width": "100", prop: "beginStageTotalQuantity", "show-overflow-tooltip": "" }), e(t, { key: "beginStageTotalMete", align: "right", label: "核算量", "min-width": "100", prop: "beginStageTotalMete", "show-overflow-tooltip": "" })]), _: 1 }), e(t, { key: "inboundStageTotal", align: "center", label: "入库数据", prop: "inboundStageTotal" }, { default: i(() => [e(t, { key: "inboundStageTotalQuantity", align: "right", label: "数量", "min-width": "100", prop: "inboundStageTotalQuantity", "show-overflow-tooltip": "" }), e(t, { key: "inboundStageTotalMete", align: "right", label: "核算量", "min-width": "100", prop: "inboundStageTotalMete", "show-overflow-tooltip": "" })]), _: 1 }), e(t, { key: "transferStageTotal", align: "center", label: "调拨数据", prop: "transferStageTotal" }, { default: i(() => [e(t, { key: "transferStageTotalQuantity", align: "right", label: "数量", "min-width": "100", prop: "transferStageTotalQuantity", "show-overflow-tooltip": "" }), e(t, { key: "transferStageTotalMete", align: "right", label: "核算量", "min-width": "100", prop: "transferStageTotalMete", "show-overflow-tooltip": "" })]), _: 1 }), e(t, { key: "outboundStageTotal", align: "center", label: "出库数据", prop: "outboundStageTotal" }, { default: i(() => [e(t, { key: "outboundStageTotalQuantity", align: "right", label: "数量", "min-width": "100", prop: "outboundStageTotalQuantity", "show-overflow-tooltip": "" }), e(t, { key: "outboundStageTotalMete", align: "right", label: "核算量", "min-width": "100", prop: "outboundStageTotalMete", "show-overflow-tooltip": "" })]), _: 1 }), e(t, { key: "endStageTotal", align: "center", label: "期末数据", prop: "endStageTotal" }, { default: i(() => [e(t, { key: "endStageTotalQuantity", align: "right", label: "数量", "min-width": "100", prop: "endStageTotalQuantity", "show-overflow-tooltip": "" }), e(t, { key: "endStageTotalMete", align: "right", label: "核算量", "min-width": "100", prop: "endStageTotalMete", "show-overflow-tooltip": "" })]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "onSortChange"])), [[p, n(r).loading]]), e(K), e(n(G), { visible: u.value, "onUpdate:visible": o[0] || (o[0] = (a) => u.value = a), date: n(r).query.createTime, formType: b.value, "material-info": m.value }, null, 8, ["visible", "date", "formType", "material-info"])])), [[p, n(r).loading]]);
  };
} }, pe = B($, [["__scopeId", "data-v-54c91736"]]);
export {
  pe as default
};
