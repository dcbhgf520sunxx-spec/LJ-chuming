import { inject as F } from "vue";
import { computed as X } from "vue";
import { ref as c } from "vue";
import { watch as Y } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as e } from "vue";
import { unref as l } from "vue";
import { withKeys as E } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as I } from "vue";
import { withDirectives as S } from "vue";
import { normalizeStyle as ee } from "vue";
import { ElDatePicker as te } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElTag as ae } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElPagination as ne } from "element-plus";
import { vLoading as re } from "element-plus";
import { bo as se, J as ie, G as z, pQ as w, b as pe, x as ue, I as ce, pM as L, pR as me, E as de, pO as fe } from "../../../../../../shared/runtime.js";
import ge from "./common-components/workshop-cascader.vue.js";
import { b as he, c as ve } from "../../../../../../modules/project-production-statistics-850038ba.js";
const ye = { id: "container" }, we = { class: "table-container" }, xe = { __name: "production-component", props: { maxHeight: { type: [Number, String], default: 500 } }, setup(U) {
  const i = F("commonQuery"), p = X(() => i.weightType === se.NET.V), r = c({}), h = c(false), b = () => ({ productType: L.CONSTRUCT.V, workshopId: "", productionLineId: "", boolCompany: "", serialNumber: "", specification: "", dateTimeList: [] }), o = c(b()), { handleSizeChange: j, handleCurrentChange: Q, total: R, setTotalPage: D, queryPage: m } = ie({ fetchHook: d });
  async function d() {
    if (!z(w.getProduciton)) return;
    const f = { ...i, ...o.value, ...m };
    h.value = true;
    try {
      const t = await he(f);
      _.value = t.content || [], D(t.totalElements);
    } finally {
      h.value = false;
    }
  }
  const v = async () => {
    if (!z(w.getProduciton)) return;
    const f = { ...i, ...o.value, ...m }, t = await ve(f);
    r.value = t;
  }, s = () => {
    d(), v();
  }, W = () => {
    o.value = b(), d(), v();
  };
  Y(i, async () => {
    pe(i.projectId) || (d(), v());
  }, { immediate: true });
  const _ = c([]), C = c(null), O = { add: false, edit: false, del: false, download: false }, { curd: $, columns: B } = ue({ title: "审批管理", invisibleColumns: ["contractNumber", "writtenByName", "voucherNumber", "submitDate"], optShow: { ...O } }, C);
  return console.log($, B), (f, t) => {
    const M = te, T = g("common-select"), x = oe, k = g("common-button"), G = ae, H = g("print-table"), n = le, K = g("common-table"), q = ne, A = Z("permission"), J = re;
    return N(), P("div", ye, [V("div", null, [e(M, { modelValue: o.value.dateTimeList, "onUpdate:modelValue": t[0] || (t[0] = (a) => o.value.dateTimeList = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "220px" }, clearable: true, shortcuts: l(ce), "value-format": "x", onChange: s }, null, 8, ["modelValue", "shortcuts"]), e(T, { modelValue: o.value.productType, "onUpdate:modelValue": t[1] || (t[1] = (a) => o.value.productType = a), options: l(L).ENUM, type: "enum", class: "filter-item", clearable: false, style: { width: "200px", "margin-left": "10px" }, placeholder: "请选择产品类型", onChange: s }, null, 8, ["modelValue", "options"]), e(ge, { "product-type": o.value.productType, workshopId: o.value.workshopId, "onUpdate:workshopId": t[2] || (t[2] = (a) => o.value.workshopId = a), style: { "margin-left": "10px" }, productionLineId: o.value.productionLineId, "onUpdate:productionLineId": t[3] || (t[3] = (a) => o.value.productionLineId = a), onChange: s }, null, 8, ["product-type", "workshopId", "productionLineId"]), e(T, { modelValue: o.value.boolCompany, "onUpdate:modelValue": t[4] || (t[4] = (a) => o.value.boolCompany = a), options: l(me).ENUM, type: "enum", class: "filter-item", clearable: "", style: { width: "200px", "margin-left": "10px" }, placeholder: "请选择状态", onChange: s }, null, 8, ["modelValue", "options"]), e(x, { modelValue: o.value.specification, "onUpdate:modelValue": t[5] || (t[5] = (a) => o.value.specification = a), size: "default", placeholder: "输入产品规格搜索", style: { width: "200px", margin: "0 10px" }, class: "filter-item", clearable: "", onKeyup: E(s, ["enter"]) }, null, 8, ["modelValue"]), e(x, { modelValue: o.value.serialNumber, "onUpdate:modelValue": t[6] || (t[6] = (a) => o.value.serialNumber = a), size: "default", placeholder: "输入编号搜索", style: { width: "200px", margin: "0 10px" }, class: "filter-item", clearable: "", onKeyup: E(s, ["enter"]) }, null, 8, ["modelValue"]), e(k, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: s }, { default: u(() => t[7] || (t[7] = [y("搜索")])), _: 1, __: [7] }), e(k, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: W }, { default: u(() => t[8] || (t[8] = [y(" 重置 ")])), _: 1, __: [8] })]), e(l(de), { "show-refresh": false, "show-search": false, "show-grid": false }, { viewLeft: u(() => [e(G, { size: "large", class: "filter-item", style: { "margin-right": "10px" } }, { default: u(() => [y(I(`任务量: ${r.value.totalTaskQuantity || 0} / ${p.value ? "净 " + (r.value.totalNetWeight || 0) : "毛 " + (r.value.totalGrossWeight || 0)} 吨
          | 已完成: ${r.value.totalCompleteQuantity || 0} / ${p.value ? "净 " + (r.value.totalCompleteNetWeight || 0) : "毛 " + (r.value.totalCompleteGrossWeight || 0)} 吨`), 1)]), _: 1 }), S(e(H, { params: { ...l(i), ...o.value }, "api-key": "mesProjectProduction", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"]), [[A, l(w).printProduciton]])]), _: 1 }), S((N(), P("div", we, [e(K, { ref_key: "tableRef", ref: C, data: _.value, stripe: false, style: { width: "100%" }, "max-height": U.maxHeight }, { default: u(() => [e(n, { label: "序号", type: "index", align: "center", width: "60" }), e(n, { label: "单体", align: "center", prop: "monomerName", "show-overflow-tooltip": true }), e(n, { label: "区域", align: "center", prop: "areaName", "show-overflow-tooltip": true }), e(n, { label: "编号", align: "center", prop: "serialNumber", "show-overflow-tooltip": true }), e(n, { label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": true }), e(n, { label: "长度", align: "center", prop: "length", "show-overflow-tooltip": true }), e(n, { label: "材质", align: "center", prop: "material", "show-overflow-tooltip": true }), e(n, { label: "数量", align: "center", prop: "taskQuantity", "show-overflow-tooltip": true }), e(n, { label: `单重(${p.value ? "净重" : "毛重"})`, align: "center", prop: p.value ? "netWeight" : "grossWeight", "show-overflow-tooltip": true }, null, 8, ["label", "prop"]), e(n, { label: `总重(${p.value ? "净重" : "毛重"})`, align: "center", prop: p.value ? "totalNetWeight" : "totalGrossWeight", "show-overflow-tooltip": true }, null, 8, ["label", "prop"]), e(n, { label: "完成数", align: "center", prop: "completeQuantity", "show-overflow-tooltip": true }, { default: u(({ row: a }) => [V("span", { style: ee({ color: a.taskCompanyStatusEnum === l(fe).COMPLETED.V ? "#00751f" : "#ff0f1a" }) }, I(a.completeQuantity), 5)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), e(q, { total: l(R), "current-page": l(m).pageNumber, "page-size": l(m).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(j), onCurrentChange: l(Q) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])), [[J, h.value]])]);
  };
} };
export {
  xe as default
};
