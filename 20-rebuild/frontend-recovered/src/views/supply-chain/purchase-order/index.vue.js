import { ref as j } from "vue";
import { useStore as K } from "vuex";
import { computed as D } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withDirectives as Q } from "vue";
import { createBlock as r } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as h } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { InfoFilled as G } from "@element-plus/icons-vue";
import { ElIcon as J } from "element-plus";
import { ElTooltip as Z } from "element-plus";
import { ElSwitch as z } from "element-plus";
import { ElTag as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { uv as ee, bD as te, D as ae, x as oe, vL as M, vM as le, ho as re, o as se, jO as y, vN as ie, bv as ne, am as pe, j_ as O, jJ as ue, jZ as me, aR as de, i as V, br as P, iF as x, G as ce, an as he, P as be, lh as ye } from "../../../shared/runtime.js";
import { u as fe } from "../../../modules/use-crud-enabled-change-d83074a3.js";
import _e from "./module/header.vue.js";
import Se from "./module/form/index.vue.js";
import "./module/form/has-detail-form.vue.js";
import "./module/components/requisition-list/index.vue.js";
import "./module/components/requisition-list/module/requisition-order.vue.js";
import "./module/components/requisition-list/module/steel/index.vue.js";
import "./module/components/requisition-list/module/steel/module/steel-plate-table.vue.js";
import "./module/components/requisition-list/module/steel/module/section-steel-table.vue.js";
import "./module/components/requisition-list/module/steel/module/steel-coil-table.vue.js";
import "./module/components/requisition-list/module/auxiliary-material/index.vue.js";
import "./module/components/requisition-list/module/manufactured/index.vue.js";
import "./module/components/manuf-list.vue.js";
import "./module/components/application/steel/index.vue.js";
import "./module/components/application/steel/module/steel-plate-table.vue.js";
import "./module/components/application/steel/module/section-steel-table.vue.js";
import "./module/components/application/steel/module/steel-coil-table.vue.js";
import "./module/components/application/auxiliary-material/index.vue.js";
import "./module/components/application/other/index.vue.js";
import "./module/components/application/manufactured/index.vue.js";
import "./module/form/raw-material.vue.js";
const we = { class: "app-container" }, Ne = { key: 0 }, Te = { key: 1 }, xe = { style: { display: "inline-block" } }, Ge = { __name: "index", setup(Ee) {
  const L = { add: false, edit: false, del: false, download: false }, k = j(), E = j([]), C = K(), U = D(() => [...ee, ["invoiceType", ["parse-enum", te]], ["amount", ["to-thousand", ae.YUAN]], ["requisitionsSNStr", "empty-text"], ["remark", "empty-text"], ["auxMaterialNames", "split"], ["otherMaterialNames", "split"]]), { CRUD: _, crud: b, columns: i } = oe({ title: "采购合同", sort: ["id.desc"], invisibleColumns: ["branchCompany.name", "invoiceType", "userUpdateTime"], permission: { ...M }, optShow: { ...L }, crudApi: { ...le }, requiredQuery: [], formStore: true, queryable: false, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER" }, k), { loaded: v, rawMatClsKV: I } = re(F), { maxHeight: R } = se({ paginate: true }), { handleEnabledChange: A } = fe({ CRUD: _, crud: b, editEnabled: ie }, { enabledField: "purchaseStatus", enumObj: y, t: "UNFINISHED", f: "FINISHED" }), H = D(() => !v.value || b.loading);
  _.HOOK.handleRefresh = (q, { data: l }) => {
    l.content = l.content.map((e) => {
      var S, w, N;
      const f = ne.getBits(pe.ENUM, e.basicClass, "L");
      return e.typeText = e.materialType ? e.materialType & O.MATERIAL.V ? f.join(" | ") : O.VL[e.materialType] + " - " + f.join(" | ") : ue.VL[e.purchaseType] + " - " + f.join(" | "), e.branchCompanyId = e.branchCompany ? e.branchCompany.id : void 0, e.requisitionsSNStr = e.applyPurchaseSN ? e.applyPurchaseSN.join("　、　") : "", e.projects = (S = e.project) != null && S.id ? [e.project] : e.projects, e.projectIds = e.projects ? e.projects.map((d) => d.id) : (w = e.project) != null && w.id ? [(N = e.project) == null ? void 0 : N.id] : [], e.boolPartyA = e.supplyType === me.PARTY_A.V, e.supplierId = e.supplier ? e.supplier.id : void 0, e.auxMaterialIds && (e.auxMaterialNames = e.auxMaterialIds.map((d) => {
        const c = I.value[d];
        return c ? c.name : "-";
      })), e.otherMaterialIds && (e.otherMaterialNames = e.otherMaterialIds.map((d) => {
        const c = I.value[d];
        return c ? c.name : "-";
      })), e;
    });
  }, _.HOOK.afterSubmit = () => {
    C.dispatch("config/fetchPurchaseOrder");
  }, _.HOOK.afterDelete = () => {
    C.dispatch("config/fetchPurchaseOrder");
  };
  function F() {
    v.value && (b.queryable = true, b.toQuery());
  }
  return (q, l) => {
    const e = Y, f = G, S = J, w = Z, N = z, d = W, c = $("common-table"), B = X;
    return o(), g("div", we, [n(t(_e)), Q((o(), r(c, { ref_key: "tableRef", ref: k, data: t(b).data, "data-format": U.value, "max-height": t(R), "default-expand-all": false, "expand-row-keys": E.value, "row-key": "serialNumber" }, { default: u(() => [n(de, { data: t(b).data, "expand-row-keys": E.value, "onUpdate:expandRowKeys": l[0] || (l[0] = (a) => E.value = a), "row-key": "serialNumber" }, { default: u(({ row: a }) => [t(V)(a.auxMaterialIds) ? (o(), g("p", Ne, [l[1] || (l[1] = h(" 辅材明细：")), p("span", null, m(a.auxMaterialNames), 1)])) : s("", true), t(V)(a.otherMaterialIds) ? (o(), g("p", Te, [l[2] || (l[2] = h(" 其它明细：")), p("span", null, m(a.otherMaterialNames), 1)])) : s("", true), p("p", null, [l[3] || (l[3] = h(" 关联项目：")), p("span", null, m(a.projectsFullName), 1)]), p("p", null, [l[4] || (l[4] = h(" 关联申购单：")), p("span", null, m(a.requisitionsSNStr), 1)]), p("p", null, [l[5] || (l[5] = h(" 备注：")), p("span", null, m(a.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), n(e, { label: "序号", type: "index", align: "center", width: "60" }, { default: u(({ row: a, $index: T }) => [n(P, { show: a.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), p("span", null, m(T + 1), 1)]), _: 1 }), t(i).visible("branchCompany.name") ? (o(), r(e, { key: "branchCompany.name", "show-overflow-tooltip": true, prop: "branchCompany.name", label: "签订主体", "min-width": "170px" })) : s("", true), t(i).visible("createTime") ? (o(), r(e, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "编制日期", align: "center", width: "130" }, { default: u(({ row: a }) => [a.settlementStatus == t(x).SETTLED.V ? (o(), r(P, { key: 0, name: t(x).SETTLED.L, color: t(x).SETTLED.COLOR }, null, 8, ["name", "color"])) : s("", true), h(" " + m(a.createTime), 1)]), _: 1 })) : s("", true), t(i).visible("serialNumber") ? (o(), r(e, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", label: "采购合同编号", "min-width": "160px" })) : s("", true), t(i).visible("typeText") ? (o(), r(e, { key: "typeText", "show-overflow-tooltip": true, prop: "typeText", label: "物料种类", "min-width": "170px" })) : s("", true), t(i).visible("projects") ? (o(), r(e, { "show-overflow-tooltip": "", key: "projects", prop: "projects", label: "关联项目", "min-width": "170" })) : s("", true), t(i).visible("supplier.name") ? (o(), r(e, { key: "supplier.name", "show-overflow-tooltip": true, prop: "supplier.name", label: "供应商", "min-width": "150" })) : s("", true), t(i).visible("mete") ? (o(), r(e, { key: "mete", "show-overflow-tooltip": true, prop: "mete", label: "合同量", align: "center", width: "110" }, { default: u(({ row: a }) => [p("span", null, m(a.mete ? `${a.mete || ""} ${a.meteUnit || ""}` : ""), 1)]), _: 1 })) : s("", true), t(i).visible("amount") ? (o(), r(e, { key: "amount", "show-overflow-tooltip": true, prop: "amount", label: "合同额（元）", align: "center", width: "110" })) : s("", true), t(i).visible("invoiceType") ? (o(), r(e, { key: "invoiceType", "show-overflow-tooltip": true, prop: "invoiceType", label: "票据类型", align: "center", "min-width": "130" })) : s("", true), t(i).visible("purchaseStatus") ? (o(), r(e, { key: "purchaseStatus", label: "采购状态", prop: "purchaseStatus", align: "center", width: "90px" }, { header: u(() => [n(w, { class: "item", effect: "light", content: `采购执行完毕后，该采购合同不可在入库办理处选择。

            已结算的采购合同不可再打开采购状态。`, placement: "top" }, { default: u(() => [p("div", xe, [l[6] || (l[6] = p("span", null, "采购状态", -1)), n(S, null, { default: u(() => [n(f)]), _: 1 })])]), _: 1 })]), default: u(({ row: a }) => [t(ce)(t(M).editPurchaseStatus) ? (o(), r(N, { key: 0, modelValue: a.purchaseStatus, "onUpdate:modelValue": (T) => a.purchaseStatus = T, disabled: a.enabledLoading || a.status === t(x).SETTLED.V && a.purchaseStatus === t(y).FINISHED.V, "active-color": "#13ce66", "active-value": t(y).UNFINISHED.V, "inactive-value": t(y).FINISHED.V, onChange: (T) => t(A)(a, "serialNumber") }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])) : (o(), r(d, { key: 1, type: a.purchaseStatus }, { default: u(() => [h(m(t(y).VL[a.purchaseStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })) : s("", true), t(i).visible("applicantName") ? (o(), r(e, { key: "applicantName", "show-overflow-tooltip": true, prop: "applicantName", label: "创建人", align: "center", width: "90" })) : s("", true), t(i).visible("lastOperatorName") ? (o(), r(e, { key: "lastOperatorName", "show-overflow-tooltip": true, prop: "lastOperatorName", label: "最后操作人", align: "center", width: "90" })) : s("", true), t(i).visible("userUpdateTime") ? (o(), r(e, { key: "userUpdateTime", "show-overflow-tooltip": true, prop: "userUpdateTime", label: "编辑时间", align: "center", width: "100" })) : s("", true), n(e, { label: "操作", width: "180px", align: "center", fixed: "right" }, { default: u(({ row: a }) => [n(he, { "disabled-edit": a.purchaseStatus == t(y).FINISHED.V, data: a, "show-detail": "" }, null, 8, ["disabled-edit", "data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[B, H.value]]), n(t(be)), n(Se), n(ye)]);
  };
} };
export {
  Ge as default
};
