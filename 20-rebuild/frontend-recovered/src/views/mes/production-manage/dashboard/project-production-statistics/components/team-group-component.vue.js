import { inject as K } from "vue";
import { computed as q } from "vue";
import { ref as m } from "vue";
import { watch as A } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as F } from "vue";
import { createElementBlock as X } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as t } from "vue";
import { unref as n } from "vue";
import { withKeys as N } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as V } from "vue";
import { withDirectives as Y } from "vue";
import { normalizeStyle as Z } from "vue";
import { ElDatePicker as ee } from "element-plus";
import { ElInput as te } from "element-plus";
import { ElTag as oe } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElPagination as le } from "element-plus";
import { bo as ne, J as re, G as E, pQ as w, b as se, x as ie, I as pe, pM as P, pR as ue, E as me, pO as ce } from "../../../../../../shared/runtime.js";
import de from "./common-components/workshop-cascader.vue.js";
import fe from "./common-components/process-select.vue.js";
import { d as ge, e as ve } from "../../../../../../modules/project-production-statistics-850038ba.js";
const he = { id: "container" }, ye = { class: "table-container" }, Ie = { __name: "team-group-component", props: { maxHeight: { type: [Number, String], default: 500 } }, setup(S) {
  const i = K("commonQuery"), p = q(() => i.weightType === ne.NET.V), s = m({}), b = m(false), C = () => ({ productType: P.CONSTRUCT.V, workshopId: "", productionLineId: "", boolCompany: "", serialNumber: "", specification: "", teamId: "", processId: "", dateTimeList: [] }), o = m(C()), { handleSizeChange: z, handleCurrentChange: U, total: j, setTotalPage: L, queryPage: c } = re({ fetchHook: d });
  async function d() {
    if (!E(w.getTeamGroup)) return;
    const f = { ...i, ...o.value, ...c };
    b.value = true;
    try {
      const e = await ge(f);
      _.value = e.content || [], L(e.totalElements);
    } finally {
      b.value = false;
    }
  }
  const v = async () => {
    if (!E(w.getTeamGroup)) return;
    const f = { ...i, ...o.value, ...c }, e = await ve(f);
    s.value = e;
  }, r = () => {
    d(), v();
  }, Q = () => {
    o.value = C(), d(), v();
  };
  A(i, async () => {
    se(i.projectId) || (d(), v());
  }, { immediate: true });
  const _ = m([]), T = m(null), R = { add: false, edit: false, del: false, download: false }, { curd: G, columns: D } = ie({ title: "审批管理", invisibleColumns: ["contractNumber", "writtenByName", "voucherNumber", "submitDate"], optShow: { ...R } }, T);
  return console.log(G, D), (f, e) => {
    const W = ee, I = g("common-select"), x = te, k = g("common-button"), $ = oe, O = g("print-table"), l = ae, B = g("common-table"), M = le, H = J("permission");
    return F(), X("div", he, [h("div", null, [t(W, { modelValue: o.value.dateTimeList, "onUpdate:modelValue": e[0] || (e[0] = (a) => o.value.dateTimeList = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "220px" }, clearable: true, shortcuts: n(pe), "value-format": "x", onChange: r }, null, 8, ["modelValue", "shortcuts"]), t(I, { modelValue: o.value.productType, "onUpdate:modelValue": e[1] || (e[1] = (a) => o.value.productType = a), options: n(P).ENUM, type: "enum", class: "filter-item", clearable: false, style: { width: "180px", "margin-left": "10px" }, placeholder: "请选择产品类型", onChange: r }, null, 8, ["modelValue", "options"]), t(de, { "is-team-id": true, "product-type": o.value.productType, workshopId: o.value.workshopId, "onUpdate:workshopId": e[2] || (e[2] = (a) => o.value.workshopId = a), teamId: o.value.teamId, "onUpdate:teamId": e[3] || (e[3] = (a) => o.value.teamId = a), productionLineId: o.value.productionLineId, "onUpdate:productionLineId": e[4] || (e[4] = (a) => o.value.productionLineId = a), style: { "margin-left": "10px" }, onChange: r }, null, 8, ["product-type", "workshopId", "teamId", "productionLineId"]), t(fe, { style: { width: "180px", "margin-left": "10px" }, "process-id": o.value.processId, "onUpdate:processId": e[5] || (e[5] = (a) => o.value.processId = a), "product-type": o.value.productType, onChange: r }, null, 8, ["process-id", "product-type"]), t(I, { modelValue: o.value.boolCompany, "onUpdate:modelValue": e[6] || (e[6] = (a) => o.value.boolCompany = a), options: n(ue).ENUM, type: "enum", class: "filter-item", clearable: "", style: { width: "180px", "margin-left": "10px" }, placeholder: "请选择状态", onChange: r }, null, 8, ["modelValue", "options"]), t(x, { modelValue: o.value.specification, "onUpdate:modelValue": e[7] || (e[7] = (a) => o.value.specification = a), size: "default", placeholder: "输入产品规格搜索", style: { width: "180px", margin: "0 10px" }, class: "filter-item", clearable: "", onKeyup: N(r, ["enter"]) }, null, 8, ["modelValue"]), t(x, { modelValue: o.value.serialNumber, "onUpdate:modelValue": e[8] || (e[8] = (a) => o.value.serialNumber = a), size: "default", placeholder: "输入编号搜索", style: { width: "180px", margin: "0 10px" }, class: "filter-item", clearable: "", onKeyup: N(r, ["enter"]) }, null, 8, ["modelValue"]), t(k, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: r }, { default: u(() => e[9] || (e[9] = [y("搜索")])), _: 1, __: [9] }), t(k, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: Q }, { default: u(() => e[10] || (e[10] = [y(" 重置 ")])), _: 1, __: [10] })]), t(n(me), { "show-refresh": false, "show-search": false, "show-grid": false }, { viewLeft: u(() => [t($, { size: "large", class: "filter-item", style: { "margin-right": "10px" } }, { default: u(() => [y(V(`任务量: ${s.value.totalTaskQuantity || 0} / ${p.value ? "净 " + (s.value.totalNetWeight || 0) : "毛 " + (s.value.totalGrossWeight || 0)} 吨
          | 已完成: ${s.value.totalCompleteQuantity || 0} / ${p.value ? "净 " + (s.value.totalCompleteNetWeight || 0) : "毛 " + (s.value.totalCompleteGrossWeight || 0)} 吨`), 1)]), _: 1 }), Y(t(O, { params: { ...n(i), ...o.value }, "api-key": "mesProjectTeamGroup", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"]), [[H, n(w).printTeamGroup]])]), _: 1 }), h("div", ye, [t(B, { ref_key: "tableRef", ref: T, data: _.value, stripe: false, style: { width: "100%" }, "max-height": S.maxHeight }, { default: u(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { label: "车间", align: "center", prop: "workShopName", "show-overflow-tooltip": true }), t(l, { label: "工序", align: "center", prop: "processName", "show-overflow-tooltip": true }), t(l, { label: "班组", align: "center", prop: "teamUserName", "show-overflow-tooltip": true }), t(l, { label: "编号", align: "center", prop: "serialNumber", "show-overflow-tooltip": true }), t(l, { label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": true }), t(l, { label: "长度", align: "center", prop: "length", "show-overflow-tooltip": true }), t(l, { label: "材质", align: "center", prop: "material", "show-overflow-tooltip": true }), t(l, { label: "数量", align: "center", prop: "taskQuantity", "show-overflow-tooltip": true }), t(l, { label: `单重(${p.value ? "净重" : "毛重"})`, align: "center", prop: p.value ? "netWeight" : "grossWeight", "show-overflow-tooltip": true }, null, 8, ["label", "prop"]), t(l, { label: `总重(${p.value ? "净重" : "毛重"})`, align: "center", prop: p.value ? "totalNetWeight" : "totalGrossWeight", "show-overflow-tooltip": true }, null, 8, ["label", "prop"]), t(l, { label: "完成数", align: "center", prop: "completeQuantity", "show-overflow-tooltip": true }, { default: u(({ row: a }) => [h("span", { style: Z({ color: a.taskCompanyStatusEnum === n(ce).COMPLETED.V ? "#00751f" : "#ff0f1a" }) }, V(a.completeQuantity), 5)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), t(M, { total: n(j), "current-page": n(c).pageNumber, "page-size": n(c).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(z), onCurrentChange: n(U) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])]);
  };
} };
export {
  Ie as default
};
