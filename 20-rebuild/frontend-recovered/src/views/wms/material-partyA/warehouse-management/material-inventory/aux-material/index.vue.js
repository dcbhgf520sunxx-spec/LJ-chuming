import { useStore as ie } from "vuex";
import { ref as u } from "vue";
import { computed as O } from "vue";
import { nextTick as re } from "vue";
import { watch as le } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as ce } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as ue } from "vue";
import { createVNode as s } from "vue";
import { unref as o } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as b } from "vue";
import { withCtx as _ } from "vue";
import { createCommentVNode as me } from "vue";
import { isRef as I } from "vue";
import { ElTableColumn as pe } from "element-plus";
import { vLoading as de } from "element-plus";
import { _ as fe, sP as be, x as _e, zH as r, bl as he, G as w, pB as V, cO as ye, jl as H, cS as P, i as ge, jG as Se, sO as we, k5 as ve, k6 as Ce, P as ze, a as xe } from "../../../../../../shared/runtime.js";
import { g as ke } from "../../../../../../modules/warehouse-management-aa3a73c1.js";
import { u as Ie } from "../../../../../../modules/use-index-info-d6256761.js";
import Ee from "./module/header.vue.js";
import Re from "../../material-outbound/raw-material/components/outbound-handling-form/index.vue.js";
import je from "../../../../material-transfer/raw-material/components/transfer-handling-form/index.vue.js";
import Fe from "../../../../material-freeze/freeze-handling-form/index.vue.js";
import Te from "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/index.vue.js";
import "../../../../../../modules/use-header-info-d26b03b1.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
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
const Me = { class: "app-container" }, Oe = { __name: "index", setup(Ue) {
  const Q = ie(), q = { add: false, edit: false, del: false, download: false }, v = u(), m = u([]), h = u([]), A = u([...be]), { CRUD: C, crud: c, columns: z } = _e({ title: "辅材物料仓", sort: ["id.desc"], invisibleColumns: [], requiredQuery: ["basicClass"], permission: { ...r }, optShow: { ...q }, crudApi: { get: ke } }, v), { headerRef: E, expandRowKeys: $, maxHeight: B, basicClass: p, currentRow: x, outboundHandlingVisible: R, transferHandlingVisible: j, movingInventoryHandlingVisible: F, freezeHandlingVisible: T, toTransfer: K, toOutHandle: N, toMovHandle: D, toFreezeHandle: L, handleOutboundSuccess: W, handleMovSuccess: G, handleTransferSuccess: J, handleFreezeSuccess: X } = Ie({ CRUD: C, crud: c, defaultBasicClass: he.MATERIAL.V }), Y = O(() => {
    const n = [w(r.outbound), w(r.transfer), w(r.freeze), w(r.movingInventory)];
    let t = n.length * 57;
    return n.forEach((a) => {
      a || (t = t - 57);
    }), t + "px";
  }), Z = O(() => {
    var n;
    return ((n = c.query) == null ? void 0 : n.projectWarehouseType) === V.PROJECT.V;
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
  function ee() {
    const n = [];
    c.selections.forEach((t) => {
      n.findIndex((a) => a.id === t.id) < 0 && n.push(t);
    }), h.value.forEach((t) => {
      n.findIndex((a) => a.id === t.id) < 0 && n.push(t);
    }), m.value = n;
  }
  C.HOOK.beforeRefresh = async (n) => {
    n.query.projectWarehouseType = V.PROJECT.V;
    const t = [];
    n.selections.forEach((a) => {
      t.findIndex((e) => e.id === a.id) < 0 && t.push(a);
    }), h.value.forEach((a) => {
      t.findIndex((e) => e.id === a.id) < 0 && t.push(a);
    }), m.value = t;
  }, C.HOOK.handleRefresh = async (n, { data: t }) => {
    E.value && E.value.updateListNumber(), await ye(t.content);
    const a = [];
    t.content = await H(t.content, { toSmallest: false, toNum: false }), t.content.forEach(async (e) => {
      e.operableQuantity = e.quantity - (e.frozenQuantity || 0), e.operableMete = e.mete - (e.frozenMete || 0), e.outboundUnitType === P.MEASURE.V ? (e.corQuantity = e.quantity, e.corFrozenQuantity = e.frozenQuantity, e.corOperableQuantity = e.operableQuantity) : (e.corQuantity = e.mete, e.corFrozenQuantity = e.frozenMete, e.corOperableQuantity = e.operableMete), Array.isArray(e.projectFrozen) && (e.projectFrozenKV = {}, e.projectFrozenForUnitKV = {}, e.projectFrozen = await H(e.projectFrozen, { measureUnit: e.measureUnit, accountingUnit: e.accountingUnit, accountingPrecision: e.accountingPrecision, measurePrecision: e.measurePrecision, toSmallest: false, toNum: true }), a.push(e.projectFrozen), e.projectFrozen.forEach((i) => {
        e.projectFrozenForUnitKV[i.projectId] = e.outboundUnitType === P.MEASURE.V ? i.quantity : i.mete, e.projectFrozenKV[i.projectId] = i;
      }));
    }), await Promise.all(a), await Promise.all(t.content), n.data = t.content, h.value = [], m.value && m.value.length > 0 && m.value.forEach((e) => {
      const i = n.data.find((f) => f.id === e.id);
      ge(i) ? re(() => {
        var f;
        (f = v.value) == null || f.toggleRowSelection(i, true);
      }) : h.value.push(e);
    });
  };
  function oe() {
    y(), g(), W();
  }
  function te() {
    y(), g(), J();
  }
  function ne() {
    y(), g(), G();
  }
  function ae() {
    y(), g(), X();
  }
  return u(), u(), u(), u(), u(false), le(() => Q.state.approval_list.approvalNum, async (n) => {
    c.refresh();
  }), (n, t) => {
    const a = pe, e = xe, i = U("common-button"), f = U("common-table"), k = ce("permission"), se = de;
    return d(), ue("div", Me, [s(o(Ee), { ref_key: "headerRef", ref: E, tableSelections: m.value, onClearTableSelection: y, onGetSelections: ee, onHandleClearSelection: g }, null, 8, ["tableSelections"]), S((d(), b(f, { key: `material_inventory_${o(c).query.basicClass}`, ref_key: "tableRef", ref: v, data: o(c).data, "data-format": A.value, "default-expand-all": false, "expand-row-keys": o($), "max-height": o(B), "row-key": "id", onSortChange: o(c).handleSortChange, onSelectionChange: o(c).selectionChangeHandler }, { default: _(() => [s(a, { align: "center", type: "selection", width: "55" }), s(Se, { "basic-class": o(p), columns: o(z), "frozen-viewable": "", "show-frozen-tip": "", sortable: "", onRefresh: o(c).toQuery }, null, 8, ["basic-class", "columns", "onRefresh"]), s(we, { "basic-class": o(p), columns: o(z), "equal-disabled": "" }, null, 8, ["basic-class", "columns"]), s(ve, { "basic-class": o(p), columns: o(z) }, null, 8, ["basic-class", "columns"]), s(Ce, { columns: o(z), "show-area": false, "show-monomer": false, "show-project": Z.value }, null, 8, ["columns", "show-project"]), o(w)([...o(r).outbound, ...o(r).transfer, ...o(r).freeze, ...o(r).movingInventory]) ? (d(), b(a, { key: 0, width: Y.value, align: "center", fixed: "right", label: "操作" }, { default: _(({ row: { sourceRow: l } }) => [S((d(), b(i, { size: "default", type: "primary", onClick: (M) => o(N)(l) }, { default: _(() => [s(e, { "icon-class": "wms-outbound" })]), _: 2 }, 1032, ["onClick"])), [[k, o(r).outbound]]), S((d(), b(i, { size: "default", type: "warning", onClick: (M) => o(K)(l) }, { default: _(() => [s(e, { "icon-class": "wms-transfer" })]), _: 2 }, 1032, ["onClick"])), [[k, o(r).transfer]]), S((d(), b(i, { size: "default", type: "info", onClick: (M) => o(L)(l) }, { default: _(() => [s(e, { "icon-class": "wms-freeze" })]), _: 2 }, 1032, ["onClick"])), [[k, o(r).freeze]]), S((d(), b(i, { size: "default", type: "danger", onClick: (M) => o(D)(l) }, { default: _(() => [s(e, { "icon-class": "wms-movingInventory" })]), _: 2 }, 1032, ["onClick"])), [[k, o(r).movingInventory]])]), _: 1 }, 8, ["width"])) : me("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[se, o(c).loading]]), s(o(ze)), s(Re, { visible: o(R), "onUpdate:visible": t[0] || (t[0] = (l) => I(R) ? R.value = l : null), "basic-class": o(p), material: o(x), onSuccess: oe }, null, 8, ["visible", "basic-class", "material"]), s(je, { visible: o(j), "onUpdate:visible": t[1] || (t[1] = (l) => I(j) ? j.value = l : null), "basic-class": o(p), material: o(x), onSuccess: te }, null, 8, ["visible", "basic-class", "material"]), s(Fe, { visible: o(T), "onUpdate:visible": t[2] || (t[2] = (l) => I(T) ? T.value = l : null), "basic-class": o(p), material: o(x), onSuccess: ae }, null, 8, ["visible", "basic-class", "material"]), s(Te, { visible: o(F), "onUpdate:visible": t[3] || (t[3] = (l) => I(F) ? F.value = l : null), "basic-class": o(p), material: o(x), onSuccess: ne }, null, 8, ["visible", "basic-class", "material"])]);
  };
} }, Qo = fe(Oe, [["__scopeId", "data-v-a76635d6"]]);
export {
  Qo as default
};
