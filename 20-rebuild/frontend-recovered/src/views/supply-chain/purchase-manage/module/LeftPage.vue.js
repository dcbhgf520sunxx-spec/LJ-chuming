import { inject as W } from "vue";
import { ref as r } from "vue";
import { computed as b } from "vue";
import { watch as S } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as n } from "vue";
import { renderSlot as X } from "vue";
import { unref as a } from "vue";
import { createBlock as T } from "vue";
import { createCommentVNode as w } from "vue";
import { withDirectives as Y } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as x } from "vue";
import { createTextVNode as Z } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { ElTag as te } from "element-plus";
import { vLoading as ae } from "element-plus";
import { _ as le, o as ne, iH as se, cE as oe, ab as D, iF as I, bV as re, eb as ue, j1 as N } from "../../../../shared/runtime.js";
import { u as ce } from "../../../../modules/useTableTotal-3d22365a.js";
import ie from "../components/SectionSelect.vue.js";
const pe = { class: "left" }, de = { class: "header" }, me = { style: { display: "flex", gap: "8px", "margin-bottom": "8px", "flex-wrap": "wrap" } }, he = { key: 0, class: "table-container" }, ve = { class: "specialText" }, ye = { __name: "LeftPage", props: ["purchaseType"], emits: ["update:purchaseType"], setup(p, { expose: H, emit: P }) {
  const k = p, U = P, { formData: s, orderId: C, itemData: q } = W("topLevel"), { requestData: L, total: V } = ce(), v = r(false), { maxHeight: j } = ne({ extraBox: [".header"], wrapperBox: ".top-container", paginate: true, extraHeight: 40 }), d = r(), A = [{ name: "采购单据维度", value: "rough" }, { name: "采购明细维度", value: "details" }], m = r("suppliers"), y = r([{ name: "供应商", value: "suppliers", component: "common-select-v2", placeholder: "请选择供应商", key: "supplierId" }, { name: "采购合同号", value: "contract", component: "el-input", placeholder: "请输入采购合同号", key: "serialNumber", style: { width: "200px", height: "32px" } }, { name: "材料类型", value: "material", component: "common-select-v2", type: "enum", dataStructure: "{ key: 'K', label: 'L', value: 'V' }", placeholder: "请选择材料类型", key: "basicClass" }, { name: "采购单位", value: "unit", component: se, placeholder: "请选择采购单位", useInternalData: true, key: "branchCompanyId" }]), g = r([]), o = async () => {
    try {
      v.value = true;
      const e = await N.get("/api/v2/supply-chain/order-payment/reconciliation/standingBook", { ...L, ...s.value });
      g.value = e.content, V.value = e.totalElements;
    } catch (e) {
      console.error("获取采购对账列表失败:getTableList", e);
    } finally {
      v.value = false;
    }
  };
  o();
  const f = r([]);
  (async () => {
    try {
      const { content: e } = await N.get("/api/scm/supplier/all/brief");
      e.length ? f.value = e : f.value = [];
    } catch (e) {
      console.error("获取供应商列表失败:getSuliperData", e);
    }
  })();
  const M = b(() => g.value.length), R = async (e) => {
    C.value = e.orderId, q.value = e;
  }, $ = b(() => {
    switch (m.value) {
      case "suppliers":
        return f.value;
      case "material":
        return oe.ENUM;
    }
    return [];
  }), _ = b(() => y.value.find((e) => e.value === m.value));
  async function F(e) {
    await o();
  }
  function K() {
    y.value.forEach((e) => {
      s.value[e.key] = void 0;
    }), o();
  }
  return S(() => k.purchaseType, (e) => {
    d.value = e, C.value = null;
  }, { immediate: true }), S(() => d.value, (e) => {
    U("update:purchaseType", e);
  }), H({ isShowRight: M, getTableList: o, purchaseType: k.purchaseType }), (e, l) => {
    const O = E("table-cell-tag"), h = ee, z = te, G = E("common-table"), J = ae;
    return u(), B("div", pe, [c("div", de, [c("div", null, [c("section", me, [n(D, { modelValue: d.value, "onUpdate:modelValue": l[0] || (l[0] = (t) => d.value = t), "data-structure": { label: "name", value: "value" }, options: A, class: "filter-item" }, null, 8, ["modelValue"]), X(e.$slots, "default", { form: a(s) }, void 0, true), p.purchaseType === "rough" ? (u(), T(D, { key: 0, modelValue: a(s).settlementStatus, "onUpdate:modelValue": l[1] || (l[1] = (t) => a(s).settlementStatus = t), options: a(I).V, showOptionAll: "", type: "enum", onChange: o }, null, 8, ["modelValue", "options"])) : w("", true)]), p.purchaseType === "rough" ? (u(), T(ie, { key: 0, "search-type": m.value, "onUpdate:searchType": l[2] || (l[2] = (t) => m.value = t), selected: a(s)[_.value.key], "onUpdate:selected": l[3] || (l[3] = (t) => a(s)[_.value.key] = t), "current-component": _.value, data: $.value, "search-type-list": y.value, onChange: F, onSearch: o, onTypeChange: K }, null, 8, ["search-type", "selected", "current-component", "data", "search-type-list"])) : w("", true)])]), p.purchaseType === "rough" ? (u(), B("div", he, [Y((u(), T(G, { ref: "tableRef", data: g.value, "highlight-current-row": true, "max-height": a(j), border: "", stripe: "", style: { cursor: "pointer" }, onRowClick: R }, { default: i(() => [n(h, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: i(({ row: t, $index: Q }) => [n(O, { show: t.standingBookIsPrint, name: "已打印", type: "printed" }, null, 8, ["show"]), c("span", null, x(Q + 1), 1)]), _: 1 }), n(h, { align: "left", label: "采购合同号", "min-width": "120", prop: "purchaseContractNumber", "show-overflow-tooltip": "" }), n(h, { align: "center", label: "入库额（元）", prop: "purchaseAmount" }, { default: i(({ row: t }) => [c("span", ve, x(a(re)(t.purchaseAmount)), 1)]), _: 1 }), n(h, { align: "center", label: "状态", prop: "settlementStatus", width: "100" }, { default: i(({ row: { settlementStatus: t } }) => [n(z, { type: t === 0 ? "danger" : "success" }, { default: i(() => [Z(x(a(I).VL[t]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[J, v.value]]), n(ue, { "request-data": a(L), total: a(V), onHandleChange: o }, null, 8, ["request-data", "total"])])) : w("", true)]);
  };
} }, we = le(ye, [["__scopeId", "data-v-37025785"]]);
export {
  we as default
};
