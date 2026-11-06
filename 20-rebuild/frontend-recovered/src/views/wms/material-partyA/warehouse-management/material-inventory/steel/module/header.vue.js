import { ref as w } from "vue";
import { computed as Ee } from "vue";
import { onMounted as Te } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as Ve } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as D } from "vue";
import { unref as e } from "vue";
import { createVNode as a } from "vue";
import { withCtx as o } from "vue";
import { createCommentVNode as B } from "vue";
import { withDirectives as y } from "vue";
import { createBlock as d } from "vue";
import { createTextVNode as p } from "vue";
import { isRef as I } from "vue";
import { ElBadge as we } from "element-plus";
import { sl as b, pB as Ie, zW as Le, gF as ke, r9 as Oe, fv as Pe, ya as Re, C as ze, L as Ae, zI as Ue, cP as L, G as Be, E as qe, jl as Me, rJ as h, c as Ne, jN as je, a as xe } from "../../../../../../../shared/runtime.js";
import { d as We, e as $e, f as He, c as Qe, h as Fe } from "../../../../../../../modules/warehouse-management-aa3a73c1.js";
import { u as De } from "../../../../../../../modules/use-header-info-d26b03b1.js";
import { u as Ge } from "../../../../../../../modules/use-get-not-printed-material-4179d261.js";
import Je from "../../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import Ke from "../../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import Xe from "../../../../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import Ye from "../../../material-label-print/index.vue.js";
import Ze from "./convert-confirm-list/index.vue.js";
import et from "../../../../../comps/real-time-inventory/index.vue.js";
import tt from "../../../../../material-freeze/freeze-batch-handling-form/index.vue.js";
import st from "../../../../../material-moving-inventory/raw-material/components/moving-inventory-batch-handling-form/index.vue.js";
import "../../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../../../../../../modules/transfer-handling-96ed23ad.js";
import "../../../../../../../modules/material-inventory-71cd4559.js";
import "../../../material-label-print/material-mode/index.vue.js";
import "../../../../../../../modules/material-mode-V2-9ef0c850.js";
import "../../../material-label-print/material-mode/module/header.vue.js";
import "../../../../../../../modules/use-print-4d7e67fe.js";
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
import "./convert-confirm-list/module/detail.vue.js";
import "./convert-confirm-list/module/review.vue.js";
import "../../../../../../../modules/review-confirm-button-aa3600ad.js";
import "../../../../../../../modules/freeze-handling-a93ff3c0.js";
import "../../../../../../../modules/application-0ee072a2.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const at = { class: "head-container" }, it = { key: 0 }, xt = { __name: "header", props: { tableSelections: { type: Array, default: () => [] } }, emits: ["clearTableSelection", "getSelections", "handleClearSelection"], setup(G, { expose: J, emit: K }) {
  const { CRUD: q, crud: i, query: l, permission: f, currentUserOutboundListRef: X, batchOutboundHandlingVisible: k, batchTransferHandlingVisible: O, batchMovingInventoryHandlingVisible: P, batchFreezeHandlingVisible: R, updateListNumber: M, toOutboundRecord: Y, toBatchOutbound: Z, toBatchFreeze: ee, handleBatchOutbound: te, toBatchTransfer: se, toBatchMovingInventory: ae, handleTransferOutbound: ie, handleMovingInventoryOutbound: le, handleFreezeOutbound: oe, openFreezeRecords: ne } = De({ defaultBasicClass: b.STEEL_PLATE.V, defaultBoolPartyA: true, defaultProjectWarehouseType: Ie.PROJECT.V }), z = w(false), S = w(false), g = w(0), { notPrintedMaterialNumber: N, refresh: j } = Ge(), x = w(0), E = G, n = K, W = Ee(() => N.value ? N.value.totalMaterial : 0);
  Te(async () => {
  });
  function re() {
    n("getSelections"), Z();
  }
  function ue() {
    n("getSelections"), se();
  }
  function ce() {
    n("getSelections"), ee();
  }
  function me() {
    n("getSelections"), ae();
  }
  function de() {
    n("clearTableSelection"), n("handleClearSelection");
  }
  function fe() {
    n("clearTableSelection"), n("handleClearSelection"), te();
  }
  function pe() {
    n("clearTableSelection"), n("handleClearSelection"), ie();
  }
  function be() {
    n("clearTableSelection"), n("handleClearSelection"), oe();
  }
  function ye() {
    n("clearTableSelection"), n("handleClearSelection"), le();
  }
  function ve() {
    T(), i.toQuery();
  }
  async function $(u) {
    switch (u) {
      case b.STEEL_PLATE.V:
        i.crudApi.get = Qe;
        break;
      case b.SECTION_STEEL.V:
        i.crudApi.get = He;
        break;
      case b.STEEL_COIL.V:
        i.crudApi.get = $e;
        break;
      case b.OTHER_STEEL_MATERIALS.V:
        i.crudApi.get = We;
        break;
    }
    A(), await i.resetQuery(), i.data = [], i.setColumns();
  }
  function Ce() {
    n("clearTableSelection"), n("handleClearSelection");
  }
  function _e() {
    i.refresh(), j();
  }
  function he() {
    z.value = true;
  }
  function Se() {
    S.value = true;
  }
  async function A() {
    var V, v, c, C, _, m, s, H, Q, F;
    const t = { mete: await Fe(i.query) };
    await Me(t, { basicClass: i.query.basicClass, measureUnit: (v = (V = h[i.query.basicClass]) == null ? void 0 : V.measure) == null ? void 0 : v.unit, accountingUnit: (C = (c = h[i.query.basicClass]) == null ? void 0 : c.weight) == null ? void 0 : C.unit, accountingPrecision: (m = (_ = h[i.query.basicClass]) == null ? void 0 : _.weight) == null ? void 0 : m.precision, measurePrecision: (H = (s = h[i.query.basicClass]) == null ? void 0 : s.measure) == null ? void 0 : H.precision }), x.value = Ne(t.mete, (F = (Q = h[i.query.basicClass]) == null ? void 0 : Q.weight) == null ? void 0 : F.unit, "t", je.weight.precision);
  }
  q.HOOK.afterRefresh = async (u) => {
    u.query.boolPartyA = true, A(), u.query.basicClass === b.STEEL_COIL.V && T();
  }, q.HOOK.afterRefresh = async (u) => {
    u.query.boolPartyA = true, A(), u.query.basicClass === b.STEEL_COIL.V && T();
  };
  async function T() {
    g.value = 0;
    try {
      g.value = await Le() || 0;
    } catch (u) {
      console.log("未审核数量", u);
    }
  }
  function ge() {
    T(), M();
  }
  return J({ updateListNumber: M, headerRefreshNum: ge, handleBasicClassChange: $ }), (u, t) => {
    const V = U("common-radio-button"), v = xe, c = U("common-button"), C = we, _ = U("common-drawer"), m = Ve("permission");
    return r(), D("div", at, [e(i).searchToggle ? (r(), D("div", it, [a(Re, { "basic-class": e(l).basicClass, query: e(l), "show-warehouse": false, "to-query": e(i).toQuery, multiple: "", onSearchQuery: de }, { firstItem: o(() => [a(ke, { modelValue: e(l).workshopIds, "onUpdate:modelValue": t[0] || (t[0] = (s) => e(l).workshopIds = s), class: "filter-item", clearable: "", multiple: "", placeholder: "仓库", style: { width: "200px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "onChange"]), a(Oe, { modelValue: e(l).warehouseIds, "onUpdate:modelValue": t[1] || (t[1] = (s) => e(l).warehouseIds = s), basicClass: e(l).basicClass, "workshop-id": e(l).workshopIds, class: "filter-item", clearable: "", multiple: "", placeholder: "存储位置", style: { width: "200px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "basicClass", "workshop-id", "onChange"])]), afterProjectWarehouseType: o(() => [a(V, { modelValue: e(l).basicClass, "onUpdate:modelValue": t[2] || (t[2] = (s) => e(l).basicClass = s), options: e(b).ENUM, class: "filter-item", size: "default", type: "enum", onChange: $ }, null, 8, ["modelValue", "options"])]), afterWarehouse: o(() => [a(Pe, { modelValue: e(l).projectId, "onUpdate:modelValue": t[3] || (t[3] = (s) => e(l).projectId = s), class: "filter-item", clearable: "", isAll: "", placeholder: "项目", style: { width: "200px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "onChange"])]), _: 1 }, 8, ["basic-class", "query", "to-query"]), a(e(ze), { onResetClick: Ce })])) : B("", true), a(e(qe), null, { optLeft: o(() => [y((r(), d(c, { class: "filter-item", size: "default", type: "primary", onClick: re }, { default: o(() => [a(v, { "icon-class": "wms-outbound" }), t[10] || (t[10] = p(" 批量出库 "))]), _: 1, __: [10] })), [[m, e(f).outbound]]), y((r(), d(c, { class: "filter-item", size: "default", type: "warning", onClick: ue }, { default: o(() => [a(v, { "icon-class": "wms-transfer" }), t[11] || (t[11] = p(" 批量调拨 "))]), _: 1, __: [11] })), [[m, e(f).transfer]]), y((r(), d(c, { class: "filter-item", size: "default", type: "info", onClick: ce }, { default: o(() => [a(v, { "icon-class": "wms-freeze" }), t[12] || (t[12] = p(" 批量冻结 "))]), _: 1, __: [12] })), [[m, e(f).freeze]]), y((r(), d(c, { class: "filter-item", size: "default", type: "danger", onClick: me }, { default: o(() => [a(v, { "icon-class": "wms-movingInventory" }), t[13] || (t[13] = p(" 批量移库 "))]), _: 1, __: [13] })), [[m, e(f).movingInventory]])]), viewLeft: o(() => [a(Ae, { fn: e(Ue), params: { basicClass: [e(L).STEEL_PLATE.V, e(L).SECTION_STEEL.V, e(L).STEEL_COIL.V, e(L).OTHER_STEEL_MATERIALS.V], boolPartyA: true, specification: e(l).specification }, "response-header-result": true, class: "filter-item", icon: "", type: "warning" }, { default: o(() => t[14] || (t[14] = [p(" 甲供物料库存导出 ")])), _: 1, __: [14] }, 8, ["fn", "params"]), e(l).basicClass && e(l).basicClass !== e(b).OTHER_STEEL_MATERIALS.V ? (r(), d(et, { key: 0, RealtimeWeight: x.value }, null, 8, ["RealtimeWeight"])) : B("", true), y((r(), d(C, { hidden: g.value <= 0, value: g.value, style: { "z-index": "2" } }, { default: o(() => [a(c, { class: "filter-item", size: "default", type: "warning", onClick: Se }, { default: o(() => t[15] || (t[15] = [p("条板转换清单 ")])), _: 1, __: [15] })]), _: 1 }, 8, ["hidden", "value"])), [[m, e(f).convertListBtn]]), y((r(), d(C, { hidden: W.value <= 0, value: W.value, style: { "z-index": "1" } }, { default: o(() => [a(c, { class: "filter-item", icon: "el-icon-printer", size: "default", type: "primary", onClick: he }, { default: o(() => t[16] || (t[16] = [p(" 标签打印 ")])), _: 1, __: [16] })]), _: 1 }, 8, ["hidden", "value"])), [[m, e(f).labelPrint]]), e(Be)(e(f).outbound) ? (r(), d(Je, { key: 1, ref_key: "currentUserOutboundListRef", ref: X, onRefresh: _e }, null, 512)) : B("", true), y((r(), d(c, { class: "filter-item", icon: "el-icon-clock", size: "default", type: "info", onClick: e(Y) }, { default: o(() => t[17] || (t[17] = [p("出库记录 ")])), _: 1, __: [17] }, 8, ["onClick"])), [[m, e(f).outboundRecord]]), y((r(), d(c, { class: "filter-item", icon: "el-icon-lock", size: "default", type: "info", onClick: e(ne) }, { default: o(() => t[18] || (t[18] = [p(" 冻结记录 ")])), _: 1, __: [18] }, 8, ["onClick"])), [[m, e(f).freezeRecord]])]), _: 1 }), a(Ke, { visible: e(k), "onUpdate:visible": t[4] || (t[4] = (s) => I(k) ? k.value = s : null), "basic-class": e(l).basicClass, "material-list": E.tableSelections, "project-id": e(l).projectId, "project-warehouse-type": e(l).projectWarehouseType, onSuccess: fe }, null, 8, ["visible", "basic-class", "material-list", "project-id", "project-warehouse-type"]), a(Xe, { visible: e(O), "onUpdate:visible": t[5] || (t[5] = (s) => I(O) ? O.value = s : null), "basic-class": e(l).basicClass, "material-list": E.tableSelections, onSuccess: pe }, null, 8, ["visible", "basic-class", "material-list"]), a(tt, { visible: e(R), "onUpdate:visible": t[6] || (t[6] = (s) => I(R) ? R.value = s : null), "basic-class": e(l).basicClass, "material-list": E.tableSelections, onSuccess: be }, null, 8, ["visible", "basic-class", "material-list"]), a(st, { visible: e(P), "onUpdate:visible": t[7] || (t[7] = (s) => I(P) ? P.value = s : null), "basic-class": e(l).basicClass, "material-list": E.tableSelections, onSuccess: ye }, null, 8, ["visible", "basic-class", "material-list"]), a(_, { modelValue: z.value, "onUpdate:modelValue": t[8] || (t[8] = (s) => z.value = s), size: "90%", title: "标签打印" }, { content: o(() => [a(Ye, { onPrintedSuccess: e(j) }, null, 8, ["onPrintedSuccess"])]), _: 1 }, 8, ["modelValue"]), a(_, { modelValue: S.value, "onUpdate:modelValue": t[9] || (t[9] = (s) => S.value = s), size: "95%", title: "条板转换列表" }, { content: o(() => [a(Ze, { showType: "coilPlate", visible: S.value, onSuccess: ve }, null, 8, ["visible"])]), _: 1 }, 8, ["modelValue"])]);
  };
} };
export {
  xt as default
};
