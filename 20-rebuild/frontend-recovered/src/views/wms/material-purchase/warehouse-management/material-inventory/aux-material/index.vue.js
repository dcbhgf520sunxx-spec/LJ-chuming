import { useStore as ie } from "vuex";
import { ref as u } from "vue";
import { computed as T } from "vue";
import { nextTick as se } from "vue";
import { watch as re } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as le } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as ce } from "vue";
import { createVNode as i } from "vue";
import { unref as o } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as b } from "vue";
import { withCtx as _ } from "vue";
import { createCommentVNode as ue } from "vue";
import { isRef as k } from "vue";
import { ElTableColumn as me } from "element-plus";
import { vLoading as pe } from "element-plus";
import { _ as de, sP as fe, x as be, Af as r, bl as _e, G as w, pB as he, cO as ye, jl as H, cS as O, i as ge, jG as Se, sO as we, k5 as ve, k6 as Ce, P as ze, a as xe } from "../../../../../../shared/runtime.js";
import { g as Ie } from "../../../../../../modules/warehouse-management-aa3a73c1.js";
import { u as ke } from "../../../../../../modules/use-index-info-a6458974.js";
import je from "./module/header.vue.js";
import Ee from "../../material-outbound/raw-material/components/outbound-handling-form/index.vue.js";
import Fe from "../../../../material-transfer/raw-material/components/transfer-handling-form/index.vue.js";
import Re from "../../../../material-freeze/freeze-handling-form/index.vue.js";
import Ue from "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/index.vue.js";
import "../../../../../../modules/use-header-info-847d35a5.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/module/manuf-list.vue.js";
import "../../../../../../modules/review-a53b87d8.js";
import "../manufactured/manufactured-essential-information/index.vue.js";
import "../manufactured/manufactured-essential-information/module/enclosure.vue.js";
import "../manufactured/manufactured-essential-information/module/structure.vue.js";
import "../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import "../../../../../../modules/transfer-handling-96ed23ad.js";
import "../../../../../../modules/material-inventory-71cd4559.js";
import "../../../../material-freeze/freeze-batch-handling-form/index.vue.js";
import "../../../../../../modules/freeze-handling-a93ff3c0.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-batch-handling-form/index.vue.js";
import "../../../../../../modules/application-0ee072a2.js";
import "../../../../../../modules/workshop-select-210dd661.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-plate.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/components/common-material-info.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/section-steel.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/components/descriptions-material-info.vue.js";
import "../../../../../../modules/index-330e9f5e.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/aux-mat.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/gas.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/other.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/components/common-form-item.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/steel-plate.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/components/common-material-info.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/section-steel.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/steel-coil.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/aux-mat.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/gas.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/other.vue.js";
import "../../../../material-freeze/freeze-handling-form/module/steel-plate.vue.js";
import "../../../../material-freeze/freeze-handling-form/components/common-form-item.vue.js";
import "../../../../material-freeze/freeze-handling-form/components/common-material-info.vue.js";
import "../../../../material-freeze/freeze-handling-form/module/section-steel.vue.js";
import "../../../../material-freeze/freeze-handling-form/module/steel-coil.vue.js";
import "../../../../material-freeze/freeze-handling-form/components/descriptions-material-info.vue.js";
import "../../../../material-freeze/freeze-handling-form/module/aux-mat.vue.js";
import "../../../../material-freeze/freeze-handling-form/module/gas.vue.js";
import "../../../../material-freeze/freeze-handling-form/module/other.vue.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/steel-plate.vue.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/components/common-form-item.vue.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/components/common-material-info.vue.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/section-steel.vue.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/steel-coil.vue.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/components/descriptions-material-info.vue.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/aux-mat.vue.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/gas.vue.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/other.vue.js";
const Me = { class: "app-container" }, Te = { __name: "index", setup(Ve) {
  const P = ie(), Q = { add: false, edit: false, del: false, download: false }, v = u(), m = u([]), h = u([]), A = u([...fe]), { CRUD: C, crud: c, columns: z } = be({ title: "辅材物料仓", sort: ["id.desc"], invisibleColumns: [], requiredQuery: ["basicClass"], permission: { ...r }, optShow: { ...Q }, crudApi: { get: Ie } }, v), { headerRef: j, expandRowKeys: $, maxHeight: q, basicClass: p, currentRow: x, outboundHandlingVisible: E, transferHandlingVisible: F, movingInventoryHandlingVisible: R, freezeHandlingVisible: U, toTransfer: B, toOutHandle: K, toMovHandle: N, toFreezeHandle: D, handleOutboundSuccess: L, handleTransferSuccess: G, handleMovSuccess: W, handleFreezeSuccess: J } = ke({ CRUD: C, crud: c, defaultBasicClass: _e.MATERIAL.V }), X = T(() => {
    const n = [w(r.outbound), w(r.transfer), w(r.freeze), w(r.movingInventory)];
    let t = n.length * 57;
    return n.forEach((a) => {
      a || (t = t - 55);
    }), t + "px";
  }), Y = T(() => {
    var n;
    return ((n = c.query) == null ? void 0 : n.projectWarehouseType) !== he.PUBLIC.V;
  });
  function y() {
    m.value = [], h.value = [];
  }
  function g() {
    var n;
    (n = v.value) == null || n.clearSelection();
  }
  C.HOOK.beforeToQuery = async (n) => {
    n.query.projectId || (n.query.monomerId = void 0, n.query.areaId = void 0);
  };
  function Z() {
    const n = [];
    c.selections.forEach((t) => {
      n.findIndex((a) => a.id === t.id) < 0 && n.push(t);
    }), h.value.forEach((t) => {
      n.findIndex((a) => a.id === t.id) < 0 && n.push(t);
    }), m.value = n;
  }
  C.HOOK.beforeRefresh = async (n) => {
    const t = [];
    n.selections.forEach((a) => {
      t.findIndex((e) => e.id === a.id) < 0 && t.push(a);
    }), h.value.forEach((a) => {
      t.findIndex((e) => e.id === a.id) < 0 && t.push(a);
    }), m.value = t;
  }, C.HOOK.handleRefresh = async (n, { data: t }) => {
    j.value && j.value.updateListNumber(), await ye(t.content);
    const a = [];
    t.content = await H(t.content, { toSmallest: false, toNum: false }), t.content.forEach(async (e) => {
      e.operableQuantity = e.quantity - (e.frozenQuantity || 0), e.operableMete = e.mete - (e.frozenMete || 0), e.outboundUnitType === O.MEASURE.V ? (e.corQuantity = e.quantity, e.corFrozenQuantity = e.frozenQuantity, e.corOperableQuantity = e.operableQuantity) : (e.corQuantity = e.mete, e.corFrozenQuantity = e.frozenMete, e.corOperableQuantity = e.operableMete), Array.isArray(e.projectFrozen) && (e.projectFrozenKV = {}, e.projectFrozenForUnitKV = {}, e.projectFrozen = await H(e.projectFrozen, { measureUnit: e.measureUnit, accountingUnit: e.accountingUnit, accountingPrecision: e.accountingPrecision, measurePrecision: e.measurePrecision, toSmallest: false, toNum: true }), a.push(e.projectFrozen), e.projectFrozen.forEach((s) => {
        e.projectFrozenForUnitKV[s.projectId] = e.outboundUnitType === O.MEASURE.V ? s.quantity : s.mete, e.projectFrozenKV[s.projectId] = s;
      }));
    }), await Promise.all(a), await Promise.all(t.content), n.data = t.content, h.value = [], m.value && m.value.length > 0 && m.value.forEach((e) => {
      const s = n.data.find((f) => f.id === e.id);
      ge(s) ? se(() => {
        var f;
        (f = v.value) == null || f.toggleRowSelection(s, true);
      }) : h.value.push(e);
    });
  };
  function ee() {
    y(), g(), L();
  }
  function oe() {
    y(), g(), W();
  }
  function te() {
    y(), g(), G();
  }
  function ne() {
    y(), g(), J();
  }
  return u(), u(), u(), u(), u(false), re(() => P.state.approval_list.approvalNum, async (n) => {
    c.refresh();
  }), (n, t) => {
    const a = me, e = xe, s = V("common-button"), f = V("common-table"), I = le("permission"), ae = pe;
    return d(), ce("div", Me, [i(o(je), { ref_key: "headerRef", ref: j, tableSelections: m.value, onClearTableSelection: y, onGetSelections: Z, onHandleClearSelection: g }, null, 8, ["tableSelections"]), S((d(), b(f, { key: `material_inventory_${o(c).query.basicClass}`, ref_key: "tableRef", ref: v, data: o(c).data, "data-format": A.value, "default-expand-all": false, "expand-row-keys": o($), "max-height": o(q), "row-key": "id", onSortChange: o(c).handleSortChange, onSelectionChange: o(c).selectionChangeHandler }, { default: _(() => [i(a, { align: "center", type: "selection", width: "55" }), i(Se, { "basic-class": o(p), columns: o(z), "frozen-viewable": "", "show-frozen-tip": "", sortable: "", onRefresh: o(c).toQuery }, null, 8, ["basic-class", "columns", "onRefresh"]), i(we, { "basic-class": o(p), columns: o(z), "equal-disabled": "" }, null, 8, ["basic-class", "columns"]), i(ve, { "basic-class": o(p), columns: o(z) }, null, 8, ["basic-class", "columns"]), i(Ce, { columns: o(z), "show-area": false, "show-monomer": false, "show-project": Y.value }, null, 8, ["columns", "show-project"]), o(w)([...o(r).outbound, ...o(r).transfer, ...o(r).freeze, ...o(r).movingInventory]) ? (d(), b(a, { key: 0, width: X.value, align: "center", fixed: "right", label: "操作" }, { default: _(({ row: { sourceRow: l } }) => [S((d(), b(s, { size: "default", type: "primary", onClick: (M) => o(K)(l) }, { default: _(() => [i(e, { "icon-class": "wms-outbound" })]), _: 2 }, 1032, ["onClick"])), [[I, o(r).outbound]]), S((d(), b(s, { size: "default", type: "warning", onClick: (M) => o(B)(l) }, { default: _(() => [i(e, { "icon-class": "wms-transfer" })]), _: 2 }, 1032, ["onClick"])), [[I, o(r).transfer]]), S((d(), b(s, { size: "default", type: "info", onClick: (M) => o(D)(l) }, { default: _(() => [i(e, { "icon-class": "wms-freeze" })]), _: 2 }, 1032, ["onClick"])), [[I, o(r).freeze]]), S((d(), b(s, { size: "default", type: "danger", onClick: (M) => o(N)(l) }, { default: _(() => [i(e, { "icon-class": "wms-movingInventory" })]), _: 2 }, 1032, ["onClick"])), [[I, o(r).movingInventory]])]), _: 1 }, 8, ["width"])) : ue("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[ae, o(c).loading]]), i(o(ze)), i(Ee, { visible: o(E), "onUpdate:visible": t[0] || (t[0] = (l) => k(E) ? E.value = l : null), "basic-class": o(p), material: o(x), onSuccess: ee }, null, 8, ["visible", "basic-class", "material"]), i(Fe, { visible: o(F), "onUpdate:visible": t[1] || (t[1] = (l) => k(F) ? F.value = l : null), "basic-class": o(p), material: o(x), onSuccess: te }, null, 8, ["visible", "basic-class", "material"]), i(Re, { visible: o(U), "onUpdate:visible": t[2] || (t[2] = (l) => k(U) ? U.value = l : null), "basic-class": o(p), material: o(x), onSuccess: ne }, null, 8, ["visible", "basic-class", "material"]), i(Ue, { visible: o(R), "onUpdate:visible": t[3] || (t[3] = (l) => k(R) ? R.value = l : null), "basic-class": o(p), material: o(x), onSuccess: oe }, null, 8, ["visible", "basic-class", "material"])]);
  };
} }, Ko = de(Te, [["__scopeId", "data-v-dd9e93dd"]]);
export {
  Ko as default
};
