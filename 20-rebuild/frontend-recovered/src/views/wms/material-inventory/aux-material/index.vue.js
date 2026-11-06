import { ref as I } from "vue";
import { computed as O } from "vue";
import { nextTick as ae } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as ie } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as se } from "vue";
import { createVNode as i } from "vue";
import { unref as o } from "vue";
import { withDirectives as g } from "vue";
import { createBlock as f } from "vue";
import { withCtx as b } from "vue";
import { createCommentVNode as re } from "vue";
import { isRef as E } from "vue";
import { ElTableColumn as le } from "element-plus";
import { vLoading as ce } from "element-plus";
import { sP as ue, x as me, yI as l, bl as pe, G as w, pB as de, cO as fe, jl as H, cS as P, i as be, jG as he, sO as ye, k5 as _e, k6 as ge, P as we, a as Se } from "../../../../shared/runtime.js";
import { a as Ce } from "../../../../modules/material-inventory-71cd4559.js";
import { u as ve } from "../../../../modules/use-index-info-7d139262.js";
import ze from "./module/header.vue.js";
import ke from "../../material-outbound/raw-material/components/outbound-handling-form/index.vue.js";
import xe from "../../material-transfer/raw-material/components/transfer-handling-form/index.vue.js";
import Ie from "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/index.vue.js";
import Ee from "../../material-freeze/freeze-handling-form/index.vue.js";
import "../../../../modules/use-header-info-748a27c2.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import "../../../../modules/review-a53b87d8.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import "../../../../modules/workshop-select-210dd661.js";
import "../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import "../../../../modules/transfer-handling-96ed23ad.js";
import "../../material-freeze/freeze-batch-handling-form/index.vue.js";
import "../../../../modules/freeze-handling-a93ff3c0.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-batch-handling-form/index.vue.js";
import "../../../../modules/application-0ee072a2.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-plate.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/components/common-form-item.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/components/common-material-info.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/section-steel.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/components/descriptions-material-info.vue.js";
import "../../../../modules/index-330e9f5e.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/aux-mat.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/gas.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/other.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/components/common-form-item.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/steel-plate.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/components/common-material-info.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/section-steel.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/steel-coil.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/aux-mat.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/gas.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/other.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/steel-plate.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/components/common-form-item.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/components/common-material-info.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/section-steel.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/steel-coil.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/components/descriptions-material-info.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/aux-mat.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/gas.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/other.vue.js";
import "../../material-freeze/freeze-handling-form/module/steel-plate.vue.js";
import "../../material-freeze/freeze-handling-form/components/common-form-item.vue.js";
import "../../material-freeze/freeze-handling-form/components/common-material-info.vue.js";
import "../../material-freeze/freeze-handling-form/module/section-steel.vue.js";
import "../../material-freeze/freeze-handling-form/module/steel-coil.vue.js";
import "../../material-freeze/freeze-handling-form/components/descriptions-material-info.vue.js";
import "../../material-freeze/freeze-handling-form/module/aux-mat.vue.js";
import "../../material-freeze/freeze-handling-form/module/gas.vue.js";
import "../../material-freeze/freeze-handling-form/module/other.vue.js";
const Re = { class: "app-container" }, Oo = { __name: "index", setup(je) {
  const Q = { add: false, edit: false, del: false, download: false }, S = I(), u = I([]), h = I([]), A = I([...ue]), { CRUD: C, crud: c, columns: v } = me({ title: "辅材物料仓", sort: ["id.desc"], invisibleColumns: [], requiredQuery: ["basicClass"], permission: { ...l }, optShow: { ...Q }, crudApi: { get: Ce } }, S), { headerRef: R, expandRowKeys: $, maxHeight: q, basicClass: m, currentRow: z, outboundHandlingVisible: j, transferHandlingVisible: F, movingInventoryHandlingVisible: T, freezeHandlingVisible: M, toTransfer: B, toOutHandle: K, toMovHandle: D, toFreezeHandle: N, handleOutboundSuccess: L, handleMovSuccess: G, handleTransferSuccess: W, handleFreezeSuccess: J } = ve({ CRUD: C, crud: c, defaultBasicClass: pe.MATERIAL.V }), X = O(() => {
    let n = 220;
    return [w(l.outbound), w(l.transfer), w(l.freeze), w(l.movingInventory)].forEach((a) => {
      a || (n = n - 50);
    }), n + "px";
  }), k = O(() => {
    var n;
    return ((n = c.query) == null ? void 0 : n.projectWarehouseType) === de.PROJECT.V;
  });
  function y() {
    u.value = [], h.value = [];
  }
  function _() {
    S.value.clearSelection();
  }
  C.HOOK.beforeToQuery = async (n) => {
    n.query.projectId || (n.query.monomerId = void 0, n.query.areaId = void 0);
  };
  function Y() {
    const n = [];
    c.selections.forEach((t) => {
      n.findIndex((a) => a.id === t.id) < 0 && n.push(t);
    }), h.value.forEach((t) => {
      n.findIndex((a) => a.id === t.id) < 0 && n.push(t);
    }), u.value = n;
  }
  C.HOOK.beforeRefresh = async (n) => {
    const t = [];
    n.selections.forEach((a) => {
      t.findIndex((e) => e.id === a.id) < 0 && t.push(a);
    }), h.value.forEach((a) => {
      t.findIndex((e) => e.id === a.id) < 0 && t.push(a);
    }), u.value = t;
  }, C.HOOK.handleRefresh = async (n, { data: t }) => {
    R.value && R.value.updateListNumber(), await fe(t.content);
    const a = [];
    t.content = await H(t.content, { toSmallest: false, toNum: false }), t.content.forEach(async (e) => {
      e.operableQuantity = e.quantity - (e.frozenQuantity || 0), e.operableMete = e.mete - (e.frozenMete || 0), e.outboundUnitType === P.MEASURE.V ? (e.corQuantity = e.quantity, e.corFrozenQuantity = e.frozenQuantity, e.corOperableQuantity = e.operableQuantity) : (e.corQuantity = e.mete, e.corFrozenQuantity = e.frozenMete, e.corOperableQuantity = e.operableMete), Array.isArray(e.projectFrozen) && (e.projectFrozenKV = {}, e.projectFrozenForUnitKV = {}, e.projectFrozen = await H(e.projectFrozen, { measureUnit: e.measureUnit, accountingUnit: e.accountingUnit, accountingPrecision: e.accountingPrecision, measurePrecision: e.measurePrecision, toSmallest: false, toNum: true }), a.push(e.projectFrozen), e.projectFrozen.forEach((s) => {
        e.projectFrozenForUnitKV[s.projectId] = e.outboundUnitType === P.MEASURE.V ? s.quantity : s.mete, e.projectFrozenKV[s.projectId] = s;
      }));
    }), await Promise.all(a), await Promise.all(t.content), n.data = t.content, h.value = [], u.value && u.value.length > 0 && u.value.forEach((e) => {
      const s = n.data.find((d) => d.id === e.id);
      be(s) ? ae(() => {
        var d;
        (d = S.value) == null || d.toggleRowSelection(s, true);
      }) : h.value.push(e);
    });
  };
  function Z() {
    y(), _(), L();
  }
  function ee() {
    y(), _(), W();
  }
  function oe() {
    y(), _(), G();
  }
  function te() {
    y(), _(), J();
  }
  return (n, t) => {
    const a = le, e = Se, s = V("common-button"), d = V("common-table"), x = ie("permission"), ne = ce;
    return p(), se("div", Re, [i(o(ze), { ref_key: "headerRef", ref: R, tableSelections: u.value, onClearTableSelection: y, onGetSelections: Y, onHandleClearSelection: _ }, null, 8, ["tableSelections"]), g((p(), f(d, { key: `material_inventory_${o(c).query.basicClass}`, ref_key: "tableRef", ref: S, data: o(c).data, "data-format": A.value, "default-expand-all": false, "expand-row-keys": o($), "max-height": o(q), "row-key": "id", onSortChange: o(c).handleSortChange, onSelectionChange: o(c).selectionChangeHandler }, { default: b(() => [i(a, { align: "center", fixed: "left", type: "selection", width: "55" }), i(he, { "basic-class": o(m), columns: o(v), "frozen-viewable": "", "show-frozen-tip": "", sortable: "", onRefresh: o(c).toQuery }, null, 8, ["basic-class", "columns", "onRefresh"]), i(ye, { "basic-class": o(m), columns: o(v), "equal-disabled": "" }, null, 8, ["basic-class", "columns"]), i(_e, { "basic-class": o(m), columns: o(v) }, null, 8, ["basic-class", "columns"]), i(ge, { columns: o(v), "show-area": k.value, "show-monomer": k.value, "show-project": k.value, "show-workshop": k.value }, null, 8, ["columns", "show-area", "show-monomer", "show-project", "show-workshop"]), o(w)([...o(l).outbound, ...o(l).transfer]) ? (p(), f(a, { key: 0, width: X.value, align: "center", fixed: "right", label: "操作" }, { default: b(({ row: { sourceRow: r } }) => [g((p(), f(s, { size: "default", type: "primary", onClick: (U) => o(K)(r) }, { default: b(() => [i(e, { "icon-class": "wms-outbound" })]), _: 2 }, 1032, ["onClick"])), [[x, o(l).outbound]]), g((p(), f(s, { size: "default", type: "warning", onClick: (U) => o(B)(r) }, { default: b(() => [i(e, { "icon-class": "wms-transfer" })]), _: 2 }, 1032, ["onClick"])), [[x, o(l).transfer]]), g((p(), f(s, { size: "default", type: "info", onClick: (U) => o(N)(r) }, { default: b(() => [i(e, { "icon-class": "wms-freeze" })]), _: 2 }, 1032, ["onClick"])), [[x, o(l).freeze]]), g((p(), f(s, { size: "default", type: "danger", onClick: (U) => o(D)(r) }, { default: b(() => [i(e, { "icon-class": "wms-movingInventory" })]), _: 2 }, 1032, ["onClick"])), [[x, o(l).movingInventory]])]), _: 1 }, 8, ["width"])) : re("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[ne, o(c).loading]]), i(o(we)), i(ke, { visible: o(j), "onUpdate:visible": t[0] || (t[0] = (r) => E(j) ? j.value = r : null), "basic-class": o(m), material: o(z), onSuccess: Z }, null, 8, ["visible", "basic-class", "material"]), i(xe, { visible: o(F), "onUpdate:visible": t[1] || (t[1] = (r) => E(F) ? F.value = r : null), "basic-class": o(m), material: o(z), onSuccess: ee }, null, 8, ["visible", "basic-class", "material"]), i(Ie, { visible: o(T), "onUpdate:visible": t[2] || (t[2] = (r) => E(T) ? T.value = r : null), "basic-class": o(m), material: o(z), onSuccess: oe }, null, 8, ["visible", "basic-class", "material"]), i(Ee, { visible: o(M), "onUpdate:visible": t[3] || (t[3] = (r) => E(M) ? M.value = r : null), "basic-class": o(m), material: o(z), onSuccess: te }, null, 8, ["visible", "basic-class", "material"])]);
  };
} };
export {
  Oo as default
};
