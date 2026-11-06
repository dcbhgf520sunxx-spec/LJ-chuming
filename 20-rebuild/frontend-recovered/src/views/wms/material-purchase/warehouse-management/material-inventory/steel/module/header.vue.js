import { ref as w } from "vue";
import { computed as Te } from "vue";
import { onMounted as Ee } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as we } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as Q } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { withCtx as o } from "vue";
import { createCommentVNode as U } from "vue";
import { withDirectives as f } from "vue";
import { createBlock as m } from "vue";
import { createTextVNode as p } from "vue";
import { isRef as V } from "vue";
import { ElBadge as Ve } from "element-plus";
import { sl as b, z0 as Ie, gF as ke, r9 as Le, ya as Oe, C as Re, L as ze, zI as Pe, cP as I, G as Ae, E as Ue, jl as Be, rJ as S, c as Me, jN as Ne, a as qe } from "../../../../../../../shared/runtime.js";
import { d as je, e as xe, f as $e, c as Fe, h as He } from "../../../../../../../modules/warehouse-management-aa3a73c1.js";
import { u as Qe } from "../../../../../../../modules/use-header-info-847d35a5.js";
import { u as We } from "../../../../../../../modules/use-get-not-printed-material-4179d261.js";
import De from "../../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import Ge from "../../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import Je from "../../../../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import Ke from "../../../material-label-print/index.vue.js";
import Xe from "./convert-confirm-list/index.vue.js";
import Ye from "../../../../../comps/real-time-inventory/index.vue.js";
import Ze from "../../../../../material-freeze/freeze-batch-handling-form/index.vue.js";
import et from "../../../../../material-moving-inventory/raw-material/components/moving-inventory-batch-handling-form/index.vue.js";
import "../../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../../material-outbound/raw-material/components/current-user-outbound-list/module/manuf-list.vue.js";
import "../../../../../../../modules/review-a53b87d8.js";
import "../../manufactured/manufactured-essential-information/index.vue.js";
import "../../manufactured/manufactured-essential-information/module/enclosure.vue.js";
import "../../manufactured/manufactured-essential-information/module/structure.vue.js";
import "../../../../../../../modules/transfer-handling-96ed23ad.js";
import "../../../../../../../modules/material-inventory-71cd4559.js";
import "../../../material-label-print/material-mode/index.vue.js";
import "../../../../../../../modules/material-mode-V2-9ef0c850.js";
import "../../../material-label-print/material-mode/module/header.vue.js";
import "../../../../../../../modules/use-print-7c5ddea7.js";
import "../../../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../../../../modules/popover-confirm-35927771.js";
import "../../../material-label-print/receipt-mode/index.vue.js";
import "../../../../../../../modules/receipt-mode-V2-8c051f68.js";
import "../../../material-label-print/receipt-mode/module/detail.vue.js";
import "../../../material-label-print/receipt-mode/module/header.vue.js";
import "../../../../../../../modules/receipt-mode-c54e9044.js";
import "./convert-confirm-list/module/header.vue.js";
import "./convert-confirm-list/module/review.vue.js";
import "../../../../../../../modules/review-confirm-button-aa3600ad.js";
import "../../../../../../../modules/freeze-handling-a93ff3c0.js";
import "../../../../../../../modules/application-0ee072a2.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const tt = { class: "head-container" }, st = { key: 0 }, Ft = { __name: "header", props: { tableSelections: { type: Array, default: () => [] } }, emits: ["clearTableSelection", "getSelections", "handleClearSelection"], setup(W, { expose: D, emit: G }) {
  const { CRUD: J, crud: i, query: l, permission: d, currentUserOutboundListRef: K, batchOutboundHandlingVisible: k, batchTransferHandlingVisible: L, batchMovingInventoryHandlingVisible: O, batchFreezeHandlingVisible: R, updateListNumber: B, toOutboundRecord: X, toBatchOutbound: Y, toBatchFreeze: Z, handleBatchOutbound: ee, toBatchTransfer: te, toBatchMovingInventory: se, handleTransferOutbound: ie, handleMovingInventoryOutbound: ae, handleFreezeOutbound: le, openFreezeRecords: oe } = Qe({ defaultBasicClass: b.STEEL_PLATE.V, defaultBoolPartyA: false }), z = w(false), h = w(false), g = w(0), { notPrintedMaterialNumber: M, refresh: N } = We(), q = w(0), T = W, n = G, j = Te(() => M.value ? M.value.totalMaterial : 0);
  Ee(async () => {
  });
  function ne() {
    n("getSelections"), Y();
  }
  function re() {
    n("getSelections"), te();
  }
  function ue() {
    n("getSelections"), se();
  }
  function ce() {
    n("getSelections"), Z();
  }
  function me() {
    n("clearTableSelection"), n("handleClearSelection");
  }
  function de() {
    n("clearTableSelection"), n("handleClearSelection"), ee();
  }
  function pe() {
    n("clearTableSelection"), n("handleClearSelection"), ie();
  }
  function fe() {
    n("clearTableSelection"), n("handleClearSelection"), le();
  }
  function be() {
    P(), i.toQuery();
  }
  async function x(v) {
    switch (v) {
      case b.STEEL_PLATE.V:
        i.crudApi.get = Fe;
        break;
      case b.SECTION_STEEL.V:
        i.crudApi.get = $e;
        break;
      case b.STEEL_COIL.V:
        i.crudApi.get = xe;
        break;
      case b.OTHER_STEEL_MATERIALS.V:
        i.crudApi.get = je;
        break;
    }
    await i.resetQuery(), i.data = [], i.setColumns();
  }
  function ve() {
    n("clearTableSelection"), n("handleClearSelection");
  }
  function ye() {
    i.refresh(), N();
  }
  function Ce() {
    n("clearTableSelection"), n("handleClearSelection"), ae();
  }
  function _e() {
    z.value = true;
  }
  function Se() {
    h.value = true;
  }
  async function he() {
    var E, y, u, C, _, c, a, $, F, H;
    const t = { mete: await He(i.query) };
    await Be(t, { basicClass: i.query.basicClass, measureUnit: (y = (E = S[i.query.basicClass]) == null ? void 0 : E.measure) == null ? void 0 : y.unit, accountingUnit: (C = (u = S[i.query.basicClass]) == null ? void 0 : u.weight) == null ? void 0 : C.unit, accountingPrecision: (c = (_ = S[i.query.basicClass]) == null ? void 0 : _.weight) == null ? void 0 : c.precision, measurePrecision: ($ = (a = S[i.query.basicClass]) == null ? void 0 : a.measure) == null ? void 0 : $.precision }), q.value = Me(t.mete, (H = (F = S[i.query.basicClass]) == null ? void 0 : F.weight) == null ? void 0 : H.unit, "t", Ne.weight.precision);
  }
  J.HOOK.afterRefresh = async (v) => {
    he(), v.query.basicClass === b.STEEL_COIL.V && P();
  };
  async function P() {
    g.value = 0;
    try {
      g.value = await Ie() || 0;
    } catch (v) {
      console.log("未审核数量", v);
    }
  }
  function ge() {
    P(), B();
  }
  return D({ updateListNumber: B, headerRefreshNum: ge, handleBasicClassChange: x }), (v, t) => {
    const E = A("common-radio-button"), y = qe, u = A("common-button"), C = Ve, _ = A("common-drawer"), c = we("permission");
    return r(), Q("div", tt, [e(i).searchToggle ? (r(), Q("div", st, [s(Oe, { "basic-class": e(l).basicClass, query: e(l), "show-warehouse": false, "to-query": e(i).toQuery, multiple: "", showTypeOptionAll: "", "show-project-Warehouse-type": "", onSearchQuery: me }, { firstItem: o(() => [s(ke, { modelValue: e(l).workshopIds, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(l).workshopIds = a), class: "filter-item", clearable: "", multiple: "", placeholder: "仓库", style: { width: "200px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "onChange"]), s(Le, { modelValue: e(l).warehouseIds, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(l).warehouseIds = a), basicClass: e(l).basicClass, "workshop-id": e(l).workshopIds, class: "filter-item", clearable: "", multiple: "", placeholder: "存储位置", style: { width: "200px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "basicClass", "workshop-id", "onChange"])]), afterProjectWarehouseType: o(() => [s(E, { modelValue: e(l).basicClass, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(l).basicClass = a), options: e(b).ENUM, class: "filter-item", size: "default", type: "enum", onChange: x }, null, 8, ["modelValue", "options"])]), _: 1 }, 8, ["basic-class", "query", "to-query"]), s(e(Re), { onResetClick: ve })])) : U("", true), s(e(Ue), null, { optLeft: o(() => [f((r(), m(u, { class: "filter-item", size: "default", type: "primary", onClick: ne }, { default: o(() => [s(y, { "icon-class": "wms-outbound" }), t[9] || (t[9] = p(" 批量出库 "))]), _: 1, __: [9] })), [[c, e(d).outbound]]), f((r(), m(u, { class: "filter-item", size: "default", type: "warning", onClick: re }, { default: o(() => [s(y, { "icon-class": "wms-transfer" }), t[10] || (t[10] = p(" 批量调拨 "))]), _: 1, __: [10] })), [[c, e(d).transfer]]), f((r(), m(u, { class: "filter-item", size: "default", type: "info", onClick: ce }, { default: o(() => [s(y, { "icon-class": "wms-freeze" }), t[11] || (t[11] = p(" 批量冻结 "))]), _: 1, __: [11] })), [[c, e(d).freeze]]), f((r(), m(u, { class: "filter-item", size: "default", type: "danger", onClick: ue }, { default: o(() => [s(y, { "icon-class": "wms-movingInventory" }), t[12] || (t[12] = p(" 批量移库 "))]), _: 1, __: [12] })), [[c, e(d).movingInventory]])]), viewLeft: o(() => [s(ze, { fn: e(Pe), params: { basicClass: [e(I).STEEL_PLATE.V, e(I).SECTION_STEEL.V, e(I).STEEL_COIL.V, e(I).OTHER_STEEL_MATERIALS.V], boolPartyA: false, specification: e(l).specification }, "response-header-result": true, class: "filter-item", icon: "", type: "warning" }, { default: o(() => t[13] || (t[13] = [p(" 自购物料库存导出 ")])), _: 1, __: [13] }, 8, ["fn", "params"]), e(l).basicClass && e(l).basicClass !== e(b).OTHER_STEEL_MATERIALS.V ? (r(), m(e(Ye), { key: 0, RealtimeWeight: q.value }, null, 8, ["RealtimeWeight"])) : U("", true), f((r(), m(C, { hidden: g.value <= 0, value: g.value, style: { "z-index": "2" } }, { default: o(() => [s(u, { class: "filter-item", size: "default", type: "warning", onClick: Se }, { default: o(() => t[14] || (t[14] = [p(" 条板转换清单 ")])), _: 1, __: [14] })]), _: 1 }, 8, ["hidden", "value"])), [[c, e(d).convertListBtn]]), f((r(), m(C, { hidden: j.value <= 0, value: j.value, style: { "z-index": "1" } }, { default: o(() => [s(u, { class: "filter-item", icon: "el-icon-printer", size: "default", type: "primary", onClick: _e }, { default: o(() => t[15] || (t[15] = [p(" 标签打印 ")])), _: 1, __: [15] })]), _: 1 }, 8, ["hidden", "value"])), [[c, e(d).labelPrint]]), e(Ae)(e(d).outbound) ? (r(), m(De, { key: 1, ref_key: "currentUserOutboundListRef", ref: K, onRefresh: ye }, null, 512)) : U("", true), f((r(), m(u, { class: "filter-item", icon: "el-icon-clock", size: "default", type: "info", onClick: e(X) }, { default: o(() => t[16] || (t[16] = [p(" 出库记录 ")])), _: 1, __: [16] }, 8, ["onClick"])), [[c, e(d).outboundRecord]]), f((r(), m(u, { class: "filter-item", icon: "el-icon-lock", size: "default", type: "info", onClick: e(oe) }, { default: o(() => t[17] || (t[17] = [p(" 冻结记录 ")])), _: 1, __: [17] }, 8, ["onClick"])), [[c, e(d).freezeRecord]])]), _: 1 }), s(Ge, { visible: e(k), "onUpdate:visible": t[3] || (t[3] = (a) => V(k) ? k.value = a : null), "basic-class": e(l).basicClass, "material-list": T.tableSelections, "project-id": e(l).projectId, "project-warehouse-type": e(l).projectWarehouseType, onSuccess: de }, null, 8, ["visible", "basic-class", "material-list", "project-id", "project-warehouse-type"]), s(Je, { visible: e(L), "onUpdate:visible": t[4] || (t[4] = (a) => V(L) ? L.value = a : null), "basic-class": e(l).basicClass, "material-list": T.tableSelections, onSuccess: pe }, null, 8, ["visible", "basic-class", "material-list"]), s(Ze, { visible: e(R), "onUpdate:visible": t[5] || (t[5] = (a) => V(R) ? R.value = a : null), "basic-class": e(l).basicClass, "material-list": T.tableSelections, onSuccess: fe }, null, 8, ["visible", "basic-class", "material-list"]), s(et, { visible: e(O), "onUpdate:visible": t[6] || (t[6] = (a) => V(O) ? O.value = a : null), "basic-class": e(l).basicClass, "material-list": T.tableSelections, onSuccess: Ce }, null, 8, ["visible", "basic-class", "material-list"]), s(_, { modelValue: z.value, "onUpdate:modelValue": t[7] || (t[7] = (a) => z.value = a), size: "90%", title: "标签打印" }, { content: o(() => [s(Ke, { onPrintedSuccess: e(N) }, null, 8, ["onPrintedSuccess"])]), _: 1 }, 8, ["modelValue"]), s(_, { modelValue: h.value, "onUpdate:modelValue": t[8] || (t[8] = (a) => h.value = a), size: "95%", title: "条板转换列表" }, { content: o(() => [s(Xe, { showType: "coilPlate", visible: h.value, onSuccess: be }, null, 8, ["visible"])]), _: 1 }, 8, ["modelValue"])]);
  };
} };
export {
  Ft as default
};
