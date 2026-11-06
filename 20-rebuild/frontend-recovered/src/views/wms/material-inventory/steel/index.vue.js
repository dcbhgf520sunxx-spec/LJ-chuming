import { ref as w } from "vue";
import { computed as H } from "vue";
import { nextTick as ue } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as pe } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as de } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as d } from "vue";
import { withCtx as p } from "vue";
import { isRef as E } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElTableColumn as fe } from "element-plus";
import { ElTooltip as be } from "element-plus";
import { vLoading as ye } from "element-plus";
import { sP as _e, x as he, y$ as i, bl as k, G as l, pB as Se, cO as ge, jl as Q, cS as q, i as ve, am as we, aR as Ce, k4 as Ee, jG as ke, sO as ze, k5 as xe, k6 as Ie, P as Te, ba as Re, jN as Ve, a as je } from "../../../../shared/runtime.js";
import { d as Fe } from "../../../../modules/material-inventory-71cd4559.js";
import { u as Oe } from "../../../../modules/use-index-info-7d139262.js";
import Pe from "../../material-outbound/raw-material/components/outbound-handling-form/index.vue.js";
import Ue from "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/index.vue.js";
import $e from "../../material-transfer/raw-material/components/transfer-handling-form/index.vue.js";
import Le from "../../material-freeze/freeze-handling-form/index.vue.js";
import He from "./module/header.vue.js";
import { _ as Me } from "../../../../modules/material-print-button-3ec7d08d.js";
import Qe from "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil-plate.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-plate.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/components/common-form-item.vue.js";
import "../../../../modules/workshop-select-210dd661.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/components/common-material-info.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/section-steel.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/components/descriptions-material-info.vue.js";
import "../../../../modules/index-330e9f5e.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/aux-mat.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/gas.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/other.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/steel-plate.vue.js";
import "../../../../modules/application-0ee072a2.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/components/common-form-item.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/components/common-material-info.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/section-steel.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/steel-coil.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/components/descriptions-material-info.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/aux-mat.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/gas.vue.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/module/other.vue.js";
import "../../../../modules/transfer-handling-96ed23ad.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/components/common-form-item.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/steel-plate.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/components/common-material-info.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/section-steel.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/steel-coil.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/aux-mat.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/gas.vue.js";
import "../../material-transfer/raw-material/components/transfer-handling-form/module/other.vue.js";
import "../../material-freeze/freeze-handling-form/module/steel-plate.vue.js";
import "../../../../modules/freeze-handling-a93ff3c0.js";
import "../../material-freeze/freeze-handling-form/components/common-form-item.vue.js";
import "../../material-freeze/freeze-handling-form/components/common-material-info.vue.js";
import "../../material-freeze/freeze-handling-form/module/section-steel.vue.js";
import "../../material-freeze/freeze-handling-form/module/steel-coil.vue.js";
import "../../material-freeze/freeze-handling-form/components/descriptions-material-info.vue.js";
import "../../material-freeze/freeze-handling-form/module/aux-mat.vue.js";
import "../../material-freeze/freeze-handling-form/module/gas.vue.js";
import "../../material-freeze/freeze-handling-form/module/other.vue.js";
import "../../../../modules/use-header-info-748a27c2.js";
import "../../../../modules/use-get-not-printed-material-4179d261.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import "../../../../modules/review-a53b87d8.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import "../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import "../../material-freeze/freeze-batch-handling-form/index.vue.js";
import "../../material-label-print/index.vue.js";
import "../../material-label-print/material-mode/index.vue.js";
import "../../material-label-print/material-mode/module/header.vue.js";
import "../../../../modules/use-print-d47bc68b.js";
import "../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../material-label-print/receipt-mode/index.vue.js";
import "../../../../modules/receipt-mode-c54e9044.js";
import "../../material-label-print/receipt-mode/module/detail.vue.js";
import "../../material-label-print/receipt-mode/module/header.vue.js";
import "./module/convert-confirm-list/index.vue.js";
import "./module/convert-confirm-list/module/header.vue.js";
import "./module/convert-confirm-list/module/review.vue.js";
import "../../../../modules/review-confirm-button-aa3600ad.js";
import "../../material-moving-inventory/raw-material/components/moving-inventory-batch-handling-form/index.vue.js";
import "../../../../modules/popover-confirm-35927771.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil-plate-form.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil-preview.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/preview-form.vue.js";
const qe = { class: "app-container" }, bo = { __name: "index", setup(Ae) {
  const A = { add: false, edit: false, del: false, download: false }, z = w(), y = w([]), S = w([]), j = w(false), B = w([..._e]), { CRUD: x, crud: f, columns: I } = he({ title: "钢材物料仓", sort: ["id.desc"], invisibleColumns: [], requiredQuery: ["basicClass"], permission: { ...i }, optShow: { ...A }, crudApi: { get: Fe } }, z), { headerRef: F, expandRowKeys: T, maxHeight: K, basicClass: m, currentRow: h, outboundHandlingVisible: O, transferHandlingVisible: P, movingInventoryHandlingVisible: U, freezeHandlingVisible: $, toTransfer: N, toOutHandle: D, toMovHandle: W, toFreezeHandle: G, handleOutboundSuccess: J, handleTransferSuccess: X, handleFreezeSuccess: Y, handleMovSuccess: Z } = Oe({ CRUD: x, crud: f, defaultBasicClass: k.STEEL_PLATE.V }), ee = H(() => {
    let a = m.value === k.STEEL_COIL.V ? 320 : 270;
    return (m.value !== k.STEEL_COIL.V ? [l(i.outbound), l(i.transfer), l(i.freeze), l(i.labelPrint), l(i.movingInventory)] : [l(i.outbound), l(i.transfer), l(i.freeze), l(i.labelPrint), l(i.movingInventory), l(i.convert)]).forEach((r) => {
      r || (a = a - 50);
    }), a + "px";
  }), L = H(() => {
    var a;
    return ((a = f.query) == null ? void 0 : a.projectWarehouseType) === Se.PROJECT.V;
  });
  function te(a) {
    h.value = a, j.value = true;
  }
  function g() {
    y.value = [], S.value = [];
  }
  function v() {
    z.value.clearSelection();
  }
  function oe(a) {
    f.selectionChangeHandler(a);
  }
  x.HOOK.beforeToQuery = async (a) => {
    a.query.projectId || (a.query.monomerId = void 0, a.query.areaId = void 0);
  };
  function ae() {
    const a = [];
    f.selections.forEach((o) => {
      a.findIndex((r) => r.id === o.id) < 0 && a.push(o);
    }), S.value.forEach((o) => {
      a.findIndex((r) => r.id === o.id) < 0 && a.push(o);
    }), y.value = a;
  }
  x.HOOK.beforeRefresh = async (a) => {
    const o = [];
    a.selections.forEach((r) => {
      o.findIndex((t) => t.id === r.id) < 0 && o.push(r);
    }), S.value.forEach((r) => {
      o.findIndex((t) => t.id === r.id) < 0 && o.push(r);
    }), y.value = o;
  }, x.HOOK.handleRefresh = async (a, { data: o }) => {
    F.value && F.value.headerRefreshNum(), await ge(o.content);
    const r = [];
    o.content = await Q(o.content, { toSmallest: false, toNum: false }), o.content.forEach(async (t) => {
      t.operableQuantity = t.quantity - (t.frozenQuantity || 0), t.operableMete = t.mete - (t.frozenMete || 0), t.outboundUnitType === q.MEASURE.V ? (t.corQuantity = t.quantity, t.corFrozenQuantity = t.frozenQuantity, t.corOperableQuantity = t.operableQuantity) : (t.corQuantity = t.mete, t.corFrozenQuantity = t.frozenMete, t.corOperableQuantity = t.operableMete), Array.isArray(t.projectFrozen) && (t.projectFrozenKV = {}, t.projectFrozenForUnitKV = {}, t.projectFrozen = await Q(t.projectFrozen, { measureUnit: t.measureUnit, accountingUnit: t.accountingUnit, accountingPrecision: t.accountingPrecision, measurePrecision: t.measurePrecision, toSmallest: false, toNum: true }), r.push(t.projectFrozen), t.projectFrozen.forEach((c) => {
        t.projectFrozenForUnitKV[c.projectId] = t.outboundUnitType === q.MEASURE.V ? c.quantity : c.mete, t.projectFrozenKV[c.projectId] = c;
      }));
    }), await Promise.all(r), await Promise.all(o.content), a.data = o.content, S.value = [], y.value && y.value.length > 0 && y.value.forEach((t) => {
      const c = a.data.find((b) => b.id === t.id);
      ve(c) ? ue(() => {
        var b;
        (b = z.value) == null || b.toggleRowSelection(c, true);
      }) : S.value.push(t);
    });
  };
  function ne() {
    g(), v(), J();
  }
  function ie() {
    g(), v(), X();
  }
  function se() {
    g(), v(), Z();
  }
  function re() {
    g(), v(), Y();
  }
  function le(a) {
    return Re(a, { props: ["quantity", ["mete", Ve.weight.precision]] });
  }
  return (a, o) => {
    const r = fe, t = je, c = M("common-button"), b = be, ce = M("common-table"), R = pe("permission"), me = ye;
    return u(), de("div", qe, [s(e(He), { ref_key: "headerRef", ref: F, tableSelections: y.value, onClearTableSelection: g, onGetSelections: ae, onHandleClearSelection: v }, null, 8, ["tableSelections"]), C((u(), d(ce, { key: `material_inventory_${e(f).query.basicClass}`, ref_key: "tableRef", ref: z, data: e(f).data, "data-format": B.value, "default-expand-all": false, "expand-row-keys": e(T), "max-height": e(K), "summary-method": le, "row-key": "id", "show-summary": "", onSortChange: e(f).handleSortChange, onSelectionChange: oe }, { default: p(() => [e(m) === e(we).STEEL_PLATE.V ? (u(), d(Ce, { key: 0, "expand-row-keys": e(T), "onUpdate:expandRowKeys": o[0] || (o[0] = (n) => E(T) ? T.value = n : null), data: e(f).data, fixed: "left", "row-key": "id" }, { default: p(({ row: n }) => [s(Ee, { "basic-class": n.basicClass, row: n, "show-batch-no": false, "show-graphics": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"])) : _("", true), s(r, { align: "center", fixed: "left", "min-": "", type: "selection", width: "55" }), s(ke, { "basic-class": e(m), columns: e(I), fixed: "left", showIsWhole: "", "frozen-viewable": "", "show-frozen-tip": "", sortable: "", onRefresh: e(f).toQuery }, null, 8, ["basic-class", "columns", "onRefresh"]), s(ze, { "basic-class": e(m), columns: e(I), "equal-disabled": "" }, null, 8, ["basic-class", "columns"]), s(xe, { "basic-class": e(m), columns: e(I) }, null, 8, ["basic-class", "columns"]), s(Ie, { columns: e(I), "show-area": L.value, "show-monomer": L.value, "show-project": L.value }, null, 8, ["columns", "show-area", "show-monomer", "show-project"]), s(r, { width: ee.value, align: "left", fixed: "right", label: "操作" }, { default: p(({ row: { sourceRow: n } }) => [e(l)(e(i).convert) && e(m) === e(k).STEEL_COIL.V ? (u(), d(b, { key: 0, content: "条板转换", placement: "top" }, { default: p(() => [s(c, { onClick: (V) => te(n), type: "info", size: "default", disabled: !(n.classifyFullName.indexOf("卷板") > -1 && e(m) === e(k).STEEL_COIL.V) }, { default: p(() => [s(t, { "icon-class": "switch" })]), _: 2 }, 1032, ["onClick", "disabled"])]), _: 2 }, 1024)) : _("", true), e(l)(e(i).outbound) ? (u(), d(b, { key: 1, content: "出库", placement: "top" }, { default: p(() => [C((u(), d(c, { size: "default", type: "primary", onClick: (V) => e(D)(n) }, { default: p(() => [s(t, { "icon-class": "wms-outbound" })]), _: 2 }, 1032, ["onClick"])), [[R, e(i).outbound]])]), _: 2 }, 1024)) : _("", true), e(l)(e(i).transfer) ? (u(), d(b, { key: 2, content: "调拨", placement: "top" }, { default: p(() => [C((u(), d(c, { size: "default", type: "warning", onClick: (V) => e(N)(n) }, { default: p(() => [s(t, { "icon-class": "wms-transfer" })]), _: 2 }, 1032, ["onClick"])), [[R, e(i).transfer]])]), _: 2 }, 1024)) : _("", true), e(l)(e(i).labelPrint) ? (u(), d(Me, { key: 3, material: n }, null, 8, ["material"])) : _("", true), e(l)(e(i).freeze) ? (u(), d(b, { key: 4, content: "冻结", placement: "top" }, { default: p(() => [C((u(), d(c, { size: "default", type: "info", onClick: (V) => e(G)(n) }, { default: p(() => [s(t, { "icon-class": "wms-freeze" })]), _: 2 }, 1032, ["onClick"])), [[R, e(i).freeze]])]), _: 2 }, 1024)) : _("", true), e(l)(e(i).movingInventory) ? (u(), d(b, { key: 5, content: "移库", placement: "top" }, { default: p(() => [C((u(), d(c, { size: "default", type: "danger", onClick: (V) => e(W)(n) }, { default: p(() => [s(t, { "icon-class": "wms-movingInventory" })]), _: 2 }, 1032, ["onClick"])), [[R, e(i).movingInventory]])]), _: 2 }, 1024)) : _("", true)]), _: 1 }, 8, ["width"])]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[me, e(f).loading]]), s(e(Te)), s(Pe, { visible: e(O), "onUpdate:visible": o[1] || (o[1] = (n) => E(O) ? O.value = n : null), "basic-class": e(m), material: e(h), onSuccess: ne }, null, 8, ["visible", "basic-class", "material"]), s($e, { visible: e(P), "onUpdate:visible": o[2] || (o[2] = (n) => E(P) ? P.value = n : null), "basic-class": e(m), material: e(h), onSuccess: ie }, null, 8, ["visible", "basic-class", "material"]), s(Qe, { visible: j.value, "onUpdate:visible": o[3] || (o[3] = (n) => j.value = n), "basic-class": e(m), material: e(h), onSuccess: e(f).toQuery }, null, 8, ["visible", "basic-class", "material", "onSuccess"]), s(Le, { visible: e($), "onUpdate:visible": o[4] || (o[4] = (n) => E($) ? $.value = n : null), "basic-class": e(m), material: e(h), onSuccess: re }, null, 8, ["visible", "basic-class", "material"]), s(Ue, { visible: e(U), "onUpdate:visible": o[5] || (o[5] = (n) => E(U) ? U.value = n : null), "basic-class": e(m), material: e(h), onSuccess: se }, null, 8, ["visible", "basic-class", "material"])]);
  };
} };
export {
  bo as default
};
