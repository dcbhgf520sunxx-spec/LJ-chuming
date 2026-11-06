import { cJ as J, gF as K, r9 as X, ya as Y, C as Z, L as ee, zI as se, cP as te, G as le, E as oe, a as ie } from "../../../../../../../shared/runtime.js";
import { u as ae } from "../../../../../../../modules/use-header-info-847d35a5.js";
import ne from "../../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import re from "../../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import ce from "../../../../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import ue from "../../../../../material-freeze/freeze-batch-handling-form/index.vue.js";
import de from "../../../../../material-moving-inventory/raw-material/components/moving-inventory-batch-handling-form/index.vue.js";
import { resolveComponent as me } from "vue";
import { resolveDirective as fe } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as g } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { withCtx as a } from "vue";
import { createCommentVNode as w } from "vue";
import { withDirectives as f } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as u } from "vue";
import { isRef as h } from "vue";
import "../../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../../material-outbound/raw-material/components/current-user-outbound-list/module/manuf-list.vue.js";
import "../../../../../../../modules/review-a53b87d8.js";
import "../../manufactured/manufactured-essential-information/index.vue.js";
import "../../manufactured/manufactured-essential-information/module/enclosure.vue.js";
import "../../manufactured/manufactured-essential-information/module/structure.vue.js";
import "../../../../../../../modules/transfer-handling-96ed23ad.js";
import "../../../../../../../modules/material-inventory-71cd4559.js";
import "../../../../../../../modules/freeze-handling-a93ff3c0.js";
import "../../../../../../../modules/application-0ee072a2.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const pe = { class: "head-container" }, be = { key: 0 }, Le = { __name: "header", props: { tableSelections: { type: Array, default: () => [] } }, emits: ["clearTableSelection", "getSelections", "handleClearSelection"], setup(k, { expose: I, emit: T }) {
  const b = k, t = T, { crud: p, query: l, permission: r, currentUserOutboundListRef: V, batchOutboundHandlingVisible: v, batchTransferHandlingVisible: C, batchFreezeHandlingVisible: _, batchMovingInventoryHandlingVisible: S, updateListNumber: z, toOutboundRecord: O, toBatchOutbound: R, toBatchFreeze: B, handleBatchOutbound: j, toBatchTransfer: x, toBatchMovingInventory: $, handleTransferOutbound: A, handleFreezeOutbound: L, handleMovingInventoryOutbound: M, openFreezeRecords: U } = ae({ defaultBasicClass: J.MATERIAL.V, defaultBoolPartyA: false });
  function E() {
    t("getSelections"), R();
  }
  function F() {
    t("getSelections"), x();
  }
  function q() {
    t("getSelections"), B();
  }
  function Q() {
    t("getSelections"), $();
  }
  function P() {
    t("clearTableSelection"), t("handleClearSelection");
  }
  function H() {
    t("clearTableSelection"), t("handleClearSelection"), j();
  }
  function N() {
    t("clearTableSelection"), t("handleClearSelection"), A();
  }
  function D() {
    t("clearTableSelection"), t("handleClearSelection"), L();
  }
  function W() {
    t("clearTableSelection"), t("handleClearSelection"), M();
  }
  function G() {
    t("clearTableSelection"), t("handleClearSelection");
  }
  return I({ updateListNumber: z }), (ye, s) => {
    const y = ie, d = me("common-button"), m = fe("permission");
    return n(), g("div", pe, [e(p).searchToggle ? (n(), g("div", be, [o(Y, { "basic-class": e(l).basicClass, query: e(l), "show-warehouse": false, "to-query": e(p).toQuery, showTypeOptionAll: "", multiple: "", "show-project-Warehouse-type": "", onSearchQuery: P }, { firstItem: a(() => [o(K, { modelValue: e(l).workshopIds, "onUpdate:modelValue": s[0] || (s[0] = (i) => e(l).workshopIds = i), class: "filter-item", clearable: "", multiple: "", placeholder: "仓库", style: { width: "200px" }, onChange: e(p).toQuery }, null, 8, ["modelValue", "onChange"]), o(X, { modelValue: e(l).warehouseIds, "onUpdate:modelValue": s[1] || (s[1] = (i) => e(l).warehouseIds = i), basicClass: e(l).basicClass, "workshop-id": e(l).workshopIds, class: "filter-item", clearable: "", multiple: "", placeholder: "存储位置", style: { width: "200px" }, onChange: e(p).toQuery }, null, 8, ["modelValue", "basicClass", "workshop-id", "onChange"])]), afterProjectWarehouseType: a(() => s[6] || (s[6] = [])), _: 1 }, 8, ["basic-class", "query", "to-query"]), o(e(Z), { onResetClick: G })])) : w("", true), o(e(oe), null, { optLeft: a(() => [f((n(), c(d, { class: "filter-item", size: "default", type: "primary", onClick: E }, { default: a(() => [o(y, { "icon-class": "wms-outbound" }), s[7] || (s[7] = u(" 批量出库 "))]), _: 1, __: [7] })), [[m, e(r).outbound]]), f((n(), c(d, { class: "filter-item", size: "default", type: "warning", onClick: F }, { default: a(() => [o(y, { "icon-class": "wms-transfer" }), s[8] || (s[8] = u(" 批量调拨 "))]), _: 1, __: [8] })), [[m, e(r).transfer]]), f((n(), c(d, { class: "filter-item", size: "default", type: "info", onClick: q }, { default: a(() => [o(y, { "icon-class": "wms-freeze" }), s[9] || (s[9] = u(" 批量冻结 "))]), _: 1, __: [9] })), [[m, e(r).freeze]]), f((n(), c(d, { class: "filter-item", size: "default", type: "danger", onClick: Q }, { default: a(() => [o(y, { "icon-class": "wms-movingInventory" }), s[10] || (s[10] = u(" 批量移库 "))]), _: 1, __: [10] })), [[m, e(r).movingInventory]])]), viewLeft: a(() => [o(ee, { fn: e(se), params: { basicClass: e(te).MATERIAL.V, boolPartyA: false, specification: e(l).specification }, "response-header-result": true, class: "filter-item", icon: "", type: "warning" }, { default: a(() => s[11] || (s[11] = [u(" 自购物料库存导出 ")])), _: 1, __: [11] }, 8, ["fn", "params"]), e(le)(e(r).outbound) ? (n(), c(ne, { key: 0, ref_key: "currentUserOutboundListRef", ref: V, onRefresh: e(p).toQuery }, null, 8, ["onRefresh"])) : w("", true), f((n(), c(d, { class: "filter-item", icon: "el-icon-clock", size: "default", type: "info", onClick: e(O) }, { default: a(() => s[12] || (s[12] = [u(" 出库记录 ")])), _: 1, __: [12] }, 8, ["onClick"])), [[m, e(r).outboundRecord]]), f((n(), c(d, { class: "filter-item", icon: "el-icon-lock", size: "default", type: "info", onClick: e(U) }, { default: a(() => s[13] || (s[13] = [u(" 冻结记录 ")])), _: 1, __: [13] }, 8, ["onClick"])), [[m, e(r).freezeRecord]])]), _: 1 }), o(re, { visible: e(v), "onUpdate:visible": s[2] || (s[2] = (i) => h(v) ? v.value = i : null), "basic-class": e(l).basicClass, "material-list": b.tableSelections, "project-id": e(l).projectId, "project-warehouse-type": e(l).projectWarehouseType, onSuccess: H }, null, 8, ["visible", "basic-class", "material-list", "project-id", "project-warehouse-type"]), o(ce, { visible: e(C), "onUpdate:visible": s[3] || (s[3] = (i) => h(C) ? C.value = i : null), "basic-class": e(l).basicClass, "material-list": b.tableSelections, onSuccess: N }, null, 8, ["visible", "basic-class", "material-list"]), o(ue, { visible: e(_), "onUpdate:visible": s[4] || (s[4] = (i) => h(_) ? _.value = i : null), "basic-class": e(l).basicClass, "material-list": b.tableSelections, onSuccess: D }, null, 8, ["visible", "basic-class", "material-list"]), o(de, { visible: e(S), "onUpdate:visible": s[5] || (s[5] = (i) => h(S) ? S.value = i : null), "basic-class": e(l).basicClass, "material-list": b.tableSelections, onSuccess: W }, null, 8, ["visible", "basic-class", "material-list"])]);
  };
} };
export {
  Le as default
};
