import { ref as w } from "vue";
import { computed as ve } from "vue";
import { onMounted as ye } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as Ce } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as M } from "vue";
import { unref as e } from "vue";
import { createVNode as i } from "vue";
import { withCtx as a } from "vue";
import { createBlock as u } from "vue";
import { createCommentVNode as O } from "vue";
import { withDirectives as f } from "vue";
import { createTextVNode as p } from "vue";
import { isRef as g } from "vue";
import { ElBadge as Se } from "element-plus";
import { vI as v, z0 as _e, pB as ge, bZ as he, ya as Ie, C as Te, G as ke, E as Ve, a as ze } from "../../../../../shared/runtime.js";
import { e as we, f as Ee, d as Oe } from "../../../../../modules/material-inventory-71cd4559.js";
import { u as Le } from "../../../../../modules/use-header-info-748a27c2.js";
import { u as Pe } from "../../../../../modules/use-get-not-printed-material-4179d261.js";
import je from "../../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import Re from "../../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import Ue from "../../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import Be from "../../../material-freeze/freeze-batch-handling-form/index.vue.js";
import Me from "../../../material-label-print/index.vue.js";
import Ne from "./convert-confirm-list/index.vue.js";
import Ae from "../../../material-moving-inventory/raw-material/components/moving-inventory-batch-handling-form/index.vue.js";
import "../../../../../modules/review-a53b87d8.js";
import "../../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../../../../modules/workshop-select-210dd661.js";
import "../../../../../modules/transfer-handling-96ed23ad.js";
import "../../../../../modules/freeze-handling-a93ff3c0.js";
import "../../../material-label-print/material-mode/index.vue.js";
import "../../../material-label-print/material-mode/module/header.vue.js";
import "../../../../../modules/use-print-d47bc68b.js";
import "../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../../modules/popover-confirm-35927771.js";
import "../../../material-label-print/receipt-mode/index.vue.js";
import "../../../../../modules/receipt-mode-c54e9044.js";
import "../../../material-label-print/receipt-mode/module/detail.vue.js";
import "../../../material-label-print/receipt-mode/module/header.vue.js";
import "./convert-confirm-list/module/header.vue.js";
import "./convert-confirm-list/module/review.vue.js";
import "../../../../../modules/review-confirm-button-aa3600ad.js";
import "../../../../../modules/application-0ee072a2.js";
const xe = { class: "head-container" }, De = { key: 0 }, _t = { __name: "header", props: { tableSelections: { type: Array, default: () => [] } }, emits: ["clearTableSelection", "getSelections", "handleClearSelection"], setup(N, { expose: A, emit: x }) {
  const { CRUD: D, crud: r, query: o, permission: c, currentUserOutboundListRef: $, batchOutboundHandlingVisible: h, batchTransferHandlingVisible: I, batchMovingInventoryHandlingVisible: T, batchFreezeHandlingVisible: k, updateListNumber: L, toOutboundRecord: q, toBatchOutbound: Q, toBatchFreeze: F, handleBatchOutbound: H, toBatchTransfer: W, toBatchMovingInventory: G, handleTransferOutbound: J, handleMovingInventoryOutbound: K, handleFreezeOutbound: Z, openFreezeRecords: X } = Le({ defaultBasicClass: v.STEEL_PLATE.V }), V = w(false), y = w(false), C = w(0), { notPrintedMaterialNumber: P, refresh: j } = Pe(), S = N, l = x, R = ve(() => P.value ? P.value.totalMaterial : 0);
  ye(async () => {
  });
  function Y() {
    l("getSelections"), Q();
  }
  function ee() {
    l("getSelections"), W();
  }
  function te() {
    l("getSelections"), G();
  }
  function oe() {
    l("getSelections"), F();
  }
  function ne() {
    l("clearTableSelection"), l("handleClearSelection");
  }
  function ie() {
    l("clearTableSelection"), l("handleClearSelection"), H();
  }
  function le() {
    l("clearTableSelection"), l("handleClearSelection"), J();
  }
  function ae() {
    l("clearTableSelection"), l("handleClearSelection"), Z();
  }
  async function se(b) {
    switch (b) {
      case v.STEEL_PLATE.V:
        r.crudApi.get = Oe;
        break;
      case v.SECTION_STEEL.V:
        r.crudApi.get = Ee;
        break;
      case v.STEEL_COIL.V:
        r.crudApi.get = we;
        break;
    }
    await r.resetQuery(), r.data = [], r.setColumns();
  }
  function re() {
    l("clearTableSelection"), l("handleClearSelection");
  }
  function ue() {
    r.refresh(), j();
  }
  function ce() {
    l("clearTableSelection"), l("handleClearSelection"), K();
  }
  function de() {
    V.value = true;
  }
  function me() {
    y.value = true;
  }
  D.HOOK.afterRefresh = async (b) => {
    b.query.basicClass === v.STEEL_COIL.V && z();
  };
  async function z() {
    C.value = 0;
    try {
      C.value = await _e() || 0;
    } catch (b) {
      console.log("未审核数量", b);
    }
  }
  function fe() {
    z(), L();
  }
  function pe() {
    z(), r.toQuery();
  }
  return A({ updateListNumber: L, headerRefreshNum: fe }), (b, t) => {
    const be = E("common-radio-button"), _ = ze, d = E("common-button"), U = Se, B = E("common-drawer"), m = Ce("permission");
    return s(), M("div", xe, [e(r).searchToggle ? (s(), M("div", De, [i(Ie, { "basic-class": e(o).basicClass, query: e(o), "to-query": e(r).toQuery, multiple: "", "show-project-Warehouse-type": "", onSearchQuery: ne }, { afterProjectWarehouseType: a(() => [e(o).projectWarehouseType === e(ge).PROJECT.V ? (s(), u(e(he), { key: 0, areaId: e(o).areaId, "onUpdate:areaId": t[0] || (t[0] = (n) => e(o).areaId = n), monomerId: e(o).monomerId, "onUpdate:monomerId": t[1] || (t[1] = (n) => e(o).monomerId = n), areaDisabled: !e(o).projectId, filterArea: false, monomerDisabled: !e(o).projectId, "project-id": e(o).projectId, areaClearable: "", clearable: "", onChange: t[2] || (t[2] = (n) => e(r).toQuery()) }, null, 8, ["areaId", "monomerId", "areaDisabled", "monomerDisabled", "project-id"])) : O("", true), i(be, { modelValue: e(o).basicClass, "onUpdate:modelValue": t[3] || (t[3] = (n) => e(o).basicClass = n), options: e(v).ENUM, class: "filter-item", size: "default", type: "enum", onChange: se }, null, 8, ["modelValue", "options"])]), _: 1 }, 8, ["basic-class", "query", "to-query"]), i(e(Te), { onResetClick: re })])) : O("", true), i(e(Ve), null, { optLeft: a(() => [f((s(), u(d, { class: "filter-item", size: "default", type: "primary", onClick: Y }, { default: a(() => [i(_, { "icon-class": "wms-outbound" }), t[10] || (t[10] = p(" 批量出库 "))]), _: 1, __: [10] })), [[m, e(c).outbound]]), f((s(), u(d, { class: "filter-item", size: "default", type: "warning", onClick: ee }, { default: a(() => [i(_, { "icon-class": "wms-transfer" }), t[11] || (t[11] = p(" 批量调拨 "))]), _: 1, __: [11] })), [[m, e(c).transfer]]), f((s(), u(d, { class: "filter-item", size: "default", type: "info", onClick: oe }, { default: a(() => [i(_, { "icon-class": "wms-freeze" }), t[12] || (t[12] = p(" 批量冻结 "))]), _: 1, __: [12] })), [[m, e(c).freeze]]), f((s(), u(d, { class: "filter-item", size: "default", type: "danger", onClick: te }, { default: a(() => [i(_, { "icon-class": "wms-movingInventory" }), t[13] || (t[13] = p(" 批量移库 "))]), _: 1, __: [13] })), [[m, e(c).movingInventory]])]), viewLeft: a(() => [f((s(), u(U, { hidden: C.value <= 0, value: C.value, style: { "z-index": "2" } }, { default: a(() => [i(d, { class: "filter-item", size: "default", type: "warning", onClick: me }, { default: a(() => t[14] || (t[14] = [p("条板转换清单 ")])), _: 1, __: [14] })]), _: 1 }, 8, ["hidden", "value"])), [[m, e(c).convertListBtn]]), f((s(), u(U, { hidden: R.value <= 0, value: R.value, style: { "z-index": "1" } }, { default: a(() => [i(d, { class: "filter-item", icon: "el-icon-printer", size: "default", type: "primary", onClick: de }, { default: a(() => t[15] || (t[15] = [p(" 标签打印 ")])), _: 1, __: [15] })]), _: 1 }, 8, ["hidden", "value"])), [[m, e(c).labelPrint]]), e(ke)(e(c).outbound) ? (s(), u(je, { key: 0, ref_key: "currentUserOutboundListRef", ref: $, onRefresh: ue }, null, 512)) : O("", true), f((s(), u(d, { class: "filter-item", icon: "el-icon-clock", size: "default", type: "info", onClick: e(q) }, { default: a(() => t[16] || (t[16] = [p("出库记录 ")])), _: 1, __: [16] }, 8, ["onClick"])), [[m, e(c).outboundRecord]]), f((s(), u(d, { class: "filter-item", icon: "el-icon-lock", size: "default", type: "info", onClick: e(X) }, { default: a(() => t[17] || (t[17] = [p(" 冻结记录 ")])), _: 1, __: [17] }, 8, ["onClick"])), [[m, e(c).freezeRecord]])]), _: 1 }), i(Re, { visible: e(h), "onUpdate:visible": t[4] || (t[4] = (n) => g(h) ? h.value = n : null), "basic-class": e(o).basicClass, "material-list": S.tableSelections, "project-id": e(o).projectId, "project-warehouse-type": e(o).projectWarehouseType, onSuccess: ie }, null, 8, ["visible", "basic-class", "material-list", "project-id", "project-warehouse-type"]), i(Ue, { visible: e(I), "onUpdate:visible": t[5] || (t[5] = (n) => g(I) ? I.value = n : null), "basic-class": e(o).basicClass, "material-list": S.tableSelections, onSuccess: le }, null, 8, ["visible", "basic-class", "material-list"]), i(Be, { visible: e(k), "onUpdate:visible": t[6] || (t[6] = (n) => g(k) ? k.value = n : null), "basic-class": e(o).basicClass, "material-list": S.tableSelections, onSuccess: ae }, null, 8, ["visible", "basic-class", "material-list"]), i(Ae, { visible: e(T), "onUpdate:visible": t[7] || (t[7] = (n) => g(T) ? T.value = n : null), "basic-class": e(o).basicClass, "material-list": S.tableSelections, onSuccess: ce }, null, 8, ["visible", "basic-class", "material-list"]), i(B, { modelValue: V.value, "onUpdate:modelValue": t[8] || (t[8] = (n) => V.value = n), size: "90%", title: "标签打印" }, { content: a(() => [i(Me, { onPrintedSuccess: e(j) }, null, 8, ["onPrintedSuccess"])]), _: 1 }, 8, ["modelValue"]), i(B, { modelValue: y.value, "onUpdate:modelValue": t[9] || (t[9] = (n) => y.value = n), size: "95%", title: "条板转换列表" }, { content: a(() => [i(Ne, { showType: "coilPlate", visible: y.value, onSuccess: pe }, null, 8, ["visible"])]), _: 1 }, 8, ["modelValue"])]);
  };
} };
export {
  _t as default
};
