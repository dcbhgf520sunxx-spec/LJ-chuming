import { cJ as G, pB as K, gF as X, r9 as Y, fv as Z, ya as ee, C as se, L as le, zI as te, cP as ae, G as oe, E as ie, a as ne } from "../../../../../../../shared/runtime.js";
import { u as re } from "../../../../../../../modules/use-header-info-d26b03b1.js";
import ce from "../../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import ue from "../../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import de from "../../../../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import me from "../../../../../material-freeze/freeze-batch-handling-form/index.vue.js";
import fe from "../../../../../material-moving-inventory/raw-material/components/moving-inventory-batch-handling-form/index.vue.js";
import { resolveComponent as pe } from "vue";
import { resolveDirective as be } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as g } from "vue";
import { unref as e } from "vue";
import { createVNode as a } from "vue";
import { withCtx as i } from "vue";
import { createCommentVNode as w } from "vue";
import { withDirectives as p } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as u } from "vue";
import { isRef as h } from "vue";
import "../../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../../../../../../modules/transfer-handling-96ed23ad.js";
import "../../../../../../../modules/material-inventory-71cd4559.js";
import "../../../../../../../modules/freeze-handling-a93ff3c0.js";
import "../../../../../../../modules/application-0ee072a2.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const ye = { class: "head-container" }, he = { key: 0 }, xe = { __name: "header", props: { tableSelections: { type: Array, default: () => [] } }, emits: ["clearTableSelection", "getSelections", "handleClearSelection"], setup(k, { expose: I, emit: V }) {
  const b = k, t = V, { crud: d, query: l, permission: r, currentUserOutboundListRef: T, batchOutboundHandlingVisible: v, batchTransferHandlingVisible: C, batchFreezeHandlingVisible: _, batchMovingInventoryHandlingVisible: S, updateListNumber: z, toOutboundRecord: R, toBatchOutbound: O, toBatchFreeze: j, handleBatchOutbound: B, toBatchTransfer: x, toBatchMovingInventory: $, handleTransferOutbound: E, handleFreezeOutbound: U, handleMovingInventoryOutbound: A, openFreezeRecords: L } = re({ defaultBasicClass: G.MATERIAL.V, defaultBoolPartyA: true, defaultProjectWarehouseType: K.PROJECT.V });
  function M() {
    t("getSelections"), O();
  }
  function F() {
    t("getSelections"), x();
  }
  function Q() {
    t("getSelections"), j();
  }
  function q() {
    t("getSelections"), $();
  }
  function P() {
    t("clearTableSelection"), t("handleClearSelection");
  }
  function H() {
    t("clearTableSelection"), t("handleClearSelection"), B();
  }
  function N() {
    t("clearTableSelection"), t("handleClearSelection"), E();
  }
  function W() {
    t("clearTableSelection"), t("handleClearSelection"), U();
  }
  function D() {
    t("clearTableSelection"), t("handleClearSelection"), A();
  }
  function J() {
    t("clearTableSelection"), t("handleClearSelection");
  }
  return I({ updateListNumber: z }), (ve, s) => {
    const y = ne, m = pe("common-button"), f = be("permission");
    return n(), g("div", ye, [e(d).searchToggle ? (n(), g("div", he, [a(ee, { "basic-class": e(l).basicClass, query: e(l), "show-warehouse": false, "to-query": e(d).toQuery, multiple: "", onSearchQuery: P }, { firstItem: i(() => [a(X, { modelValue: e(l).workshopIds, "onUpdate:modelValue": s[0] || (s[0] = (o) => e(l).workshopIds = o), class: "filter-item", clearable: "", multiple: "", placeholder: "仓库", style: { width: "200px" }, onChange: e(d).toQuery }, null, 8, ["modelValue", "onChange"]), a(Y, { modelValue: e(l).warehouseIds, "onUpdate:modelValue": s[1] || (s[1] = (o) => e(l).warehouseIds = o), basicClass: e(l).basicClass, "workshop-id": e(l).workshopIds, class: "filter-item", clearable: "", multiple: "", placeholder: "存储位置", style: { width: "200px" }, onChange: e(d).toQuery }, null, 8, ["modelValue", "basicClass", "workshop-id", "onChange"])]), afterWarehouse: i(() => [a(Z, { modelValue: e(l).projectId, "onUpdate:modelValue": s[2] || (s[2] = (o) => e(l).projectId = o), class: "filter-item", clearable: "", isAll: "", placeholder: "项目", style: { width: "200px" }, onChange: e(d).toQuery }, null, 8, ["modelValue", "onChange"])]), _: 1 }, 8, ["basic-class", "query", "to-query"]), a(e(se), { onResetClick: J })])) : w("", true), a(e(ie), null, { optLeft: i(() => [p((n(), c(m, { class: "filter-item", size: "default", type: "primary", onClick: M }, { default: i(() => [a(y, { "icon-class": "wms-outbound" }), s[7] || (s[7] = u(" 批量出库 "))]), _: 1, __: [7] })), [[f, e(r).outbound]]), p((n(), c(m, { class: "filter-item", size: "default", type: "warning", onClick: F }, { default: i(() => [a(y, { "icon-class": "wms-transfer" }), s[8] || (s[8] = u(" 批量调拨 "))]), _: 1, __: [8] })), [[f, e(r).transfer]]), p((n(), c(m, { class: "filter-item", size: "default", type: "info", onClick: Q }, { default: i(() => [a(y, { "icon-class": "wms-freeze" }), s[9] || (s[9] = u(" 批量冻结 "))]), _: 1, __: [9] })), [[f, e(r).freeze]]), p((n(), c(m, { class: "filter-item", size: "default", type: "danger", onClick: q }, { default: i(() => [a(y, { "icon-class": "wms-movingInventory" }), s[10] || (s[10] = u(" 批量移库 "))]), _: 1, __: [10] })), [[f, e(r).movingInventory]])]), viewLeft: i(() => [a(le, { fn: e(te), params: { basicClass: e(ae).MATERIAL.V, boolPartyA: true, specification: e(l).specification }, "response-header-result": true, class: "filter-item", icon: "", type: "warning" }, { default: i(() => s[11] || (s[11] = [u(" 甲供物料库存导出 ")])), _: 1, __: [11] }, 8, ["fn", "params"]), e(oe)(e(r).outbound) ? (n(), c(ce, { key: 0, ref_key: "currentUserOutboundListRef", ref: T, onRefresh: e(d).toQuery }, null, 8, ["onRefresh"])) : w("", true), p((n(), c(m, { class: "filter-item", icon: "el-icon-clock", size: "default", type: "info", onClick: e(R) }, { default: i(() => s[12] || (s[12] = [u(" 出库记录 ")])), _: 1, __: [12] }, 8, ["onClick"])), [[f, e(r).outboundRecord]]), p((n(), c(m, { class: "filter-item", icon: "el-icon-lock", size: "default", type: "info", onClick: e(L) }, { default: i(() => s[13] || (s[13] = [u(" 冻结记录 ")])), _: 1, __: [13] }, 8, ["onClick"])), [[f, e(r).freezeRecord]])]), _: 1 }), a(ue, { visible: e(v), "onUpdate:visible": s[3] || (s[3] = (o) => h(v) ? v.value = o : null), "basic-class": e(l).basicClass, "material-list": b.tableSelections, "project-id": e(l).projectId, "project-warehouse-type": e(l).projectWarehouseType, onSuccess: H }, null, 8, ["visible", "basic-class", "material-list", "project-id", "project-warehouse-type"]), a(de, { visible: e(C), "onUpdate:visible": s[4] || (s[4] = (o) => h(C) ? C.value = o : null), "basic-class": e(l).basicClass, "material-list": b.tableSelections, onSuccess: N }, null, 8, ["visible", "basic-class", "material-list"]), a(me, { visible: e(_), "onUpdate:visible": s[5] || (s[5] = (o) => h(_) ? _.value = o : null), "basic-class": e(l).basicClass, "material-list": b.tableSelections, onSuccess: W }, null, 8, ["visible", "basic-class", "material-list"]), a(fe, { visible: e(S), "onUpdate:visible": s[6] || (s[6] = (o) => h(S) ? S.value = o : null), "basic-class": e(l).basicClass, "material-list": b.tableSelections, onSuccess: D }, null, 8, ["visible", "basic-class", "material-list"])]);
  };
} };
export {
  xe as default
};
