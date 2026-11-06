import { ref as h } from "vue";
import { computed as D } from "vue";
import { inject as me } from "vue";
import { watch as Q } from "vue";
import { watchEffect as fe } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as ve } from "vue";
import { openBlock as i } from "vue";
import { createBlock as u } from "vue";
import { withCtx as g } from "vue";
import { unref as r } from "vue";
import { createCommentVNode as k } from "vue";
import { createElementVNode as U } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as H } from "vue";
import { withDirectives as K } from "vue";
import { normalizeStyle as ye } from "vue";
import { toDisplayString as he } from "vue";
import { isRef as we } from "vue";
import { h as ge } from "vue";
import { ElCheckbox as be } from "element-plus";
import { ElInput as ke } from "element-plus";
import { ElTableColumn as _e } from "element-plus";
import { ElPagination as Ie } from "element-plus";
import { vLoading as Ce } from "element-plus";
import { _ as Ne, pM as C, bv as Ve, u as Pe, J as Ee, o as xe, G as Te, pI as q, pN as Se, pO as Be, bZ as Le, i as Ue } from "../../../../../../../../shared/runtime.js";
import je from "../components/workshop-cascader.vue.js";
import { h as ze, j as Ae, k as Me } from "../../../../../../../../modules/project-production-panel-fb6946a2.js";
import "../../../../../../../../modules/project-production-statistics-850038ba.js";
const Oe = { class: "head-container" }, Re = { style: { display: "flex", "align-items": "center", "justify-content": "flex-end" } }, j = "taskQuantity", z = "completeQuantity", De = { __name: "production-status", props: { visible: { type: Boolean, default: false }, productType: { type: Number, default: C.CONSTRUCT.V } }, emits: ["update:visible"], setup(A, { emit: $ }) {
  const M = h(), G = $, c = A, v = D(() => c.productType === C.ACCESSORY.V), _ = me("projectId"), N = () => ({ areaIds: [], monomerId: "", processId: "", classId: "", areaBatchIds: [], productClassificationEnum: "", productKanBanCompanyEnum: "", productType: c.productType, productionLineId: void 0, projectId: _, serialNumber: "", workShopId: void 0, boolNotlssued: false }), e = h(N()), V = () => {
    I(), S();
  }, J = () => {
    V();
  };
  function Y(n) {
    I(), n && (e.value.workShopId = void 0, e.value.productionLineId = void 0);
  }
  Q([() => e.value.workShopId, () => e.value.productionLineId], () => {
    I(), S();
  }), fe(async () => {
    _ && (e.value.projectId = _);
  });
  const Z = D(() => {
    var n;
    return ((n = Ve.toArr(C).find((o) => o.V === c.productType)) == null ? void 0 : n.L) || "";
  }), { visible: P, handleClose: F } = Pe({ emit: G, props: c, field: "visible", showHook: le, closeHook: te }), { handleSizeChange: W, handleCurrentChange: X, total: ee, setTotalPage: oe, queryPage: E } = Ee({ fetchHook: b });
  function te() {
    e.value = N(), x.value = [], T.value = [];
  }
  const { maxHeight: ae } = xe({ paginate: true, extraBox: [".el-drawer__header", ".head-container"], extraHeight: 100, wrapperBox: [".el-drawer__body"], navbar: false }, M);
  Q(() => c.visible, (n) => {
    n && (e.value.productKanBanCompanyEnum = "", e.value.productClassificationEnum = "", e.value.productType = c.productType, b());
  }, { immediate: true });
  function le() {
    e.value.productType = c.productType, I(), S();
  }
  const x = h([]), I = async () => {
    e.value.classId = "";
    const { classId: n, serialNumber: o, processId: y, productClassificationEnum: p, productKanBanCompanyEnum: m, ...s } = e.value, { content: d = [] } = await ze({ ...s });
    x.value = d;
  }, T = h([]), S = async () => {
    if (e.value.processId = "", !v.value) return;
    const { classId: n, serialNumber: o, processId: y, productClassificationEnum: p, productKanBanCompanyEnum: m, ...s } = e.value, { content: d = [] } = await Ae({ ...s });
    T.value = d;
  }, B = h(false), O = h([]);
  async function b() {
    if (Te(q.detailTask)) try {
      B.value = true;
      const { content: n = [], totalElements: o = 0 } = await Me({ ...e.value, ...E });
      O.value = n, oe(o);
    } catch (n) {
      console.log("获取产品生产状态", n);
    } finally {
      B.value = false;
    }
  }
  const ne = () => b(), re = () => {
    e.value = N(), b();
  }, R = () => {
    b();
  }, se = (n) => {
    const { columns: o, data: y } = n, p = [];
    return o.forEach((m, s) => {
      if (s === 1) {
        p[s] = ge("div", null, "合计");
        return;
      }
      if (![j, z].includes(m.property)) {
        p[s] = "";
        return;
      }
      const d = y.map((f) => Number(f[m.property]));
      if (d.every((f) => Number.isNaN(f))) {
        p[s] = "";
        return;
      }
      p[s] = `${d.reduce((f, l) => {
        const L = Number(l);
        return Number.isNaN(L) ? f : f + l;
      }, 0)}`;
    }), p;
  };
  return (n, o) => {
    const y = w("common-radio-button"), p = be, m = w("common-select"), s = ke, d = w("common-button"), f = w("print-table"), l = _e, L = w("common-table"), ie = Ie, ue = w("common-drawer"), pe = ve("permission"), de = Ce;
    return i(), u(ue, { ref_key: "drawerRef", ref: M, "destroy-on-close": false, title: `${Z.value}生产状态明细`, modelValue: r(P), "onUpdate:modelValue": o[11] || (o[11] = (t) => we(P) ? P.value = t : null), direction: "rtl", "before-close": r(F), size: "100%" }, { content: g(() => [v.value ? (i(), u(y, { key: 0, style: { "margin-bottom": "10px" }, modelValue: e.value.productClassificationEnum, "onUpdate:modelValue": o[0] || (o[0] = (t) => e.value.productClassificationEnum = t), "show-option-all": true, options: r(Se).ENUM, type: "enum", size: "default", class: "filter-item", onChange: R }, null, 8, ["modelValue", "options"])) : (i(), u(y, { key: 1, style: { "margin-bottom": "10px" }, modelValue: e.value.productKanBanCompanyEnum, "onUpdate:modelValue": o[1] || (o[1] = (t) => e.value.productKanBanCompanyEnum = t), "show-option-all": true, options: r(Be).ENUM, type: "enum", size: "default", class: "filter-item", onChange: R }, null, 8, ["modelValue", "options"])), A.productType === r(C).CONSTRUCT.V ? (i(), u(p, { key: 2, modelValue: e.value.boolNotlssued, "onUpdate:modelValue": o[2] || (o[2] = (t) => e.value.boolNotlssued = t), label: "只看未排产", class: "filter-checkbox", size: "large", onChange: Y }, null, 8, ["modelValue"])) : k("", true), U("div", Oe, [a(r(Le), { monomerId: e.value.monomerId, "onUpdate:monomerId": o[4] || (o[4] = (t) => e.value.monomerId = t), areaId: e.value.areaIds, "onUpdate:areaId": o[5] || (o[5] = (t) => e.value.areaIds = t), clearable: "", areaClearable: "", "project-id": r(_), onMonomerChange: V, onAreaChange: J }, { right: g(({ planAreaBatch: t }) => [a(m, { modelValue: e.value.areaBatchIds, "onUpdate:modelValue": o[3] || (o[3] = (ce) => e.value.areaBatchIds = ce), options: t, size: "default", multiple: "", collapseTags: "", dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", noDataText: r(Ue)(e.value.areaIds) ? "暂无数据" : "未选择区域", class: "filter-item", placeholder: "请选择批次", style: { width: "200px" }, onChange: V }, null, 8, ["modelValue", "options", "noDataText"])]), _: 1 }, 8, ["monomerId", "areaId", "project-id"]), a(je, { workshopId: e.value.workShopId, "onUpdate:workshopId": o[6] || (o[6] = (t) => e.value.workShopId = t), productionLineId: e.value.productionLineId, "onUpdate:productionLineId": o[7] || (o[7] = (t) => e.value.productionLineId = t), "product-type": c.productType }, null, 8, ["workshopId", "productionLineId", "product-type"]), v.value ? (i(), u(m, { key: 0, modelValue: e.value.processId, "onUpdate:modelValue": o[8] || (o[8] = (t) => e.value.processId = t), options: T.value, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "请选择下料方式" }, null, 8, ["modelValue", "options"])) : k("", true), v.value ? k("", true) : (i(), u(m, { key: 1, modelValue: e.value.classId, "onUpdate:modelValue": o[9] || (o[9] = (t) => e.value.classId = t), options: x.value, "data-structure": { key: "id", label: "classificationName", value: "id" }, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "请选择类型" }, null, 8, ["modelValue", "options"])), a(s, { modelValue: e.value.serialNumber, "onUpdate:modelValue": o[10] || (o[10] = (t) => e.value.serialNumber = t), size: "default", placeholder: "输入编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), a(d, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: ne }, { default: g(() => o[12] || (o[12] = [H("搜索")])), _: 1, __: [12] }), a(d, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: re }, { default: g(() => o[13] || (o[13] = [H(" 重置 ")])), _: 1, __: [13] })]), U("div", Re, [K(a(f, { params: { ...e.value }, "api-key": v.value ? "mesProductionAccessoryPanel" : "mesProductionPanel", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params", "api-key"]), [[pe, r(q).printTask]])]), K((i(), u(L, { data: O.value, "max-height": r(ae), style: { width: "100%", "margin-top": "10px" }, "summary-method": se, "show-summary": "" }, { default: g(() => [a(l, { label: "序号", type: "index", align: "center", width: "60" }), a(l, { key: "name", prop: "name", "show-overflow-tooltip": true, align: "center", label: "产品名称", "min-width": "140" }), a(l, { key: "workShopName", prop: "workShop.name", "show-overflow-tooltip": true, label: "车间名称", align: "center", "min-width": "140" }), a(l, { key: "productionLineName", prop: "productionLine.name", "show-overflow-tooltip": true, label: "生产线名称", align: "center", "min-width": "140" }), a(l, { key: "monomerName", align: "center", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "140" }), a(l, { key: "areaName", align: "center", prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "140" }), v.value ? k("", true) : (i(), u(l, { key: "classificationName", prop: "classificationName", "show-overflow-tooltip": true, align: "center", label: "类型", "min-width": "140" })), a(l, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "编号", "min-width": "140" }), a(l, { key: "specification", prop: "specification", "show-overflow-tooltip": true, align: "center", label: "规格", "min-width": "140" }), v.value ? (i(), u(l, { key: "processName", prop: "processName", "show-overflow-tooltip": true, align: "center", label: "下料方式", "min-width": "140" })) : k("", true), a(l, { key: "length", align: "center", prop: "length", "show-overflow-tooltip": true, label: "长度", "min-width": "140" }), a(l, { key: "material", align: "center", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "140" }), (i(), u(l, { key: j, align: "center", prop: j, "show-overflow-tooltip": true, label: "任务数量", "min-width": "140" })), (i(), u(l, { key: z, align: "center", prop: z, "show-overflow-tooltip": true, label: "已生产", "min-width": "140" }, { default: g(({ row: t }) => [U("span", { style: ye({ color: t.completeQuantity === 0 ? "#ff0f1a" : t.completeQuantity >= t.taskQuantity ? "#00751f" : "#ffc5a5" }) }, he(t.completeQuantity), 5)]), _: 1 }))]), _: 1 }, 8, ["data", "max-height"])), [[de, B.value]]), a(ie, { total: r(ee), "current-page": r(E).pageNumber, "page-size": r(E).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(W), onCurrentChange: r(X) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Ge = Ne(De, [["__scopeId", "data-v-f151e10d"]]);
export {
  Ge as default
};
