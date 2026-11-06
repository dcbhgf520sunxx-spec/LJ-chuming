import { bl as Z, pB as G, bZ as K, ya as X, C as Y, E as ee, a as te } from "../../../../../shared/runtime.js";
import { u as oe } from "../../../../../modules/use-header-info-748a27c2.js";
import ne from "../../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import se from "../../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import le from "../../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import ae from "../../../material-freeze/freeze-batch-handling-form/index.vue.js";
import ie from "../../../material-moving-inventory/raw-material/components/moving-inventory-batch-handling-form/index.vue.js";
import { resolveComponent as re } from "vue";
import { resolveDirective as ce } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as g } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { withCtx as i } from "vue";
import { createBlock as u } from "vue";
import { createCommentVNode as I } from "vue";
import { withDirectives as d } from "vue";
import { createTextVNode as f } from "vue";
import { isRef as y } from "vue";
import "../../../../../modules/review-a53b87d8.js";
import "../../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../../../../modules/material-inventory-71cd4559.js";
import "../../../../../modules/workshop-select-210dd661.js";
import "../../../../../modules/transfer-handling-96ed23ad.js";
import "../../../../../modules/freeze-handling-a93ff3c0.js";
import "../../../../../modules/application-0ee072a2.js";
const ue = { class: "head-container" }, de = { key: 0 }, Oe = { __name: "header", props: { tableSelections: { type: Array, default: () => [] } }, emits: ["clearTableSelection", "getSelections", "handleClearSelection"], setup(T, { expose: k, emit: j }) {
  const b = T, o = j, { crud: p, query: n, permission: r, currentUserOutboundListRef: z, batchOutboundHandlingVisible: S, batchTransferHandlingVisible: _, batchFreezeHandlingVisible: C, batchMovingInventoryHandlingVisible: h, updateListNumber: O, toOutboundRecord: R, toBatchOutbound: w, toBatchFreeze: B, handleBatchOutbound: V, toBatchTransfer: M, toBatchMovingInventory: U, handleTransferOutbound: D, handleFreezeOutbound: $, handleMovingInventoryOutbound: q, openFreezeRecords: x } = oe({ defaultBasicClass: Z.MATERIAL.V });
  function E() {
    o("getSelections"), w();
  }
  function F() {
    o("getSelections"), M();
  }
  function L() {
    o("getSelections"), U();
  }
  function A() {
    o("getSelections"), B();
  }
  function Q() {
    o("clearTableSelection"), o("handleClearSelection");
  }
  function W() {
    o("clearTableSelection"), o("handleClearSelection"), V();
  }
  function H() {
    o("clearTableSelection"), o("handleClearSelection"), D();
  }
  function N() {
    o("clearTableSelection"), o("handleClearSelection"), $();
  }
  function P() {
    o("clearTableSelection"), o("handleClearSelection"), q();
  }
  function J() {
    o("clearTableSelection"), o("handleClearSelection");
  }
  return k({ updateListNumber: O }), (me, t) => {
    const v = te, m = re("common-button"), c = ce("permission");
    return a(), g("div", ue, [e(p).searchToggle ? (a(), g("div", de, [s(X, { "basic-class": e(n).basicClass, query: e(n), "to-query": e(p).toQuery, multiple: "", "show-project-Warehouse-type": "", onSearchQuery: Q }, { afterProjectWarehouseType: i(() => [e(n).projectWarehouseType === e(G).PROJECT.V ? (a(), u(e(K), { key: 0, areaId: e(n).areaId, "onUpdate:areaId": t[0] || (t[0] = (l) => e(n).areaId = l), monomerId: e(n).monomerId, "onUpdate:monomerId": t[1] || (t[1] = (l) => e(n).monomerId = l), areaDisabled: !e(n).projectId, filterArea: false, monomerDisabled: !e(n).projectId, "project-id": e(n).projectId, areaClearable: "", clearable: "", onChange: e(p).toQuery }, null, 8, ["areaId", "monomerId", "areaDisabled", "monomerDisabled", "project-id", "onChange"])) : I("", true)]), _: 1 }, 8, ["basic-class", "query", "to-query"]), s(e(Y), { onResetClick: J })])) : I("", true), s(e(ee), null, { optLeft: i(() => [d((a(), u(m, { class: "filter-item", size: "default", type: "primary", onClick: E }, { default: i(() => [s(v, { "icon-class": "wms-outbound" }), t[6] || (t[6] = f(" 批量出库 "))]), _: 1, __: [6] })), [[c, e(r).outbound]]), d((a(), u(m, { class: "filter-item", size: "default", type: "warning", onClick: F }, { default: i(() => [s(v, { "icon-class": "wms-transfer" }), t[7] || (t[7] = f(" 批量调拨 "))]), _: 1, __: [7] })), [[c, e(r).transfer]]), d((a(), u(m, { class: "filter-item", size: "default", type: "danger", onClick: L }, { default: i(() => [s(v, { "icon-class": "wms-movingInventory" }), t[8] || (t[8] = f(" 批量移库 "))]), _: 1, __: [8] })), [[c, e(r).movingInventory]]), d((a(), u(m, { class: "filter-item", size: "default", type: "info", onClick: A }, { default: i(() => [s(v, { "icon-class": "wms-freeze" }), t[9] || (t[9] = f(" 批量冻结 "))]), _: 1, __: [9] })), [[c, e(r).freeze]])]), viewLeft: i(() => [d(s(ne, { ref_key: "currentUserOutboundListRef", ref: z, onRefresh: e(p).toQuery }, null, 8, ["onRefresh"]), [[c, e(r).outbound]]), d((a(), u(m, { class: "filter-item", icon: "el-icon-clock", size: "default", type: "info", onClick: e(R) }, { default: i(() => t[10] || (t[10] = [f("出库记录 ")])), _: 1, __: [10] }, 8, ["onClick"])), [[c, e(r).outboundRecord]]), d((a(), u(m, { class: "filter-item", icon: "el-icon-lock", size: "default", type: "info", onClick: e(x) }, { default: i(() => t[11] || (t[11] = [f(" 冻结记录 ")])), _: 1, __: [11] }, 8, ["onClick"])), [[c, e(r).freezeRecord]])]), _: 1 }), s(se, { visible: e(S), "onUpdate:visible": t[2] || (t[2] = (l) => y(S) ? S.value = l : null), "basic-class": e(n).basicClass, "material-list": b.tableSelections, "project-id": e(n).projectId, "project-warehouse-type": e(n).projectWarehouseType, onSuccess: W }, null, 8, ["visible", "basic-class", "material-list", "project-id", "project-warehouse-type"]), s(le, { visible: e(_), "onUpdate:visible": t[3] || (t[3] = (l) => y(_) ? _.value = l : null), "basic-class": e(n).basicClass, "material-list": b.tableSelections, onSuccess: H }, null, 8, ["visible", "basic-class", "material-list"]), s(ie, { visible: e(h), "onUpdate:visible": t[4] || (t[4] = (l) => y(h) ? h.value = l : null), "basic-class": e(n).basicClass, "material-list": b.tableSelections, onSuccess: P }, null, 8, ["visible", "basic-class", "material-list"]), s(ae, { visible: e(C), "onUpdate:visible": t[5] || (t[5] = (l) => y(C) ? C.value = l : null), "basic-class": e(n).basicClass, "material-list": b.tableSelections, onSuccess: N }, null, 8, ["visible", "basic-class", "material-list"])]);
  };
} };
export {
  Oe as default
};
