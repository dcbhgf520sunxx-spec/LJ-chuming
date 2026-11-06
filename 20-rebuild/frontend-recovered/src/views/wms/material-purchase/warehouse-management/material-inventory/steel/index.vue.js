import { useStore as Ee } from "vuex";
import { ref as b } from "vue";
import { computed as H } from "vue";
import { nextTick as we } from "vue";
import { watch as B } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as Ce } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as Q } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as f } from "vue";
import { withCtx as p } from "vue";
import { isRef as z } from "vue";
import { createCommentVNode as y } from "vue";
import { createElementVNode as ke } from "vue";
import { ElTableColumn as Ie } from "element-plus";
import { ElImage as xe } from "element-plus";
import { ElTooltip as ze } from "element-plus";
import { ElDialog as Ve } from "element-plus";
import { vLoading as Te } from "element-plus";
import { _ as Ue, jY as Pe, sP as Re, x as je, Ax as l, bl as P, G as u, pB as Le, cO as Oe, jl as D, cS as K, i as Fe, cP as $e, aR as qe, k4 as Qe, jG as Me, sl as W, xY as G, sO as Ae, k5 as He, k6 as Be, P as Ne, ba as De, jN as Ke, a as We } from "../../../../../../shared/runtime.js";
import { c as Ge } from "../../../../../../modules/warehouse-management-aa3a73c1.js";
import { u as Ye } from "../../../../../../modules/use-index-info-a6458974.js";
import Je from "../../material-outbound/raw-material/components/outbound-handling-form/index.vue.js";
import Xe from "../../../../material-transfer/raw-material/components/transfer-handling-form/index.vue.js";
import Ze from "./module/header.vue.js";
import { _ as et } from "../../../../../../modules/material-print-button-3ec7d08d.js";
import tt from "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil-plate.vue.js";
import ot from "../../../../material-freeze/freeze-handling-form/index.vue.js";
import at from "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/index.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-plate.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/components/common-material-info.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/section-steel.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/components/descriptions-material-info.vue.js";
import "../../../../../../modules/index-330e9f5e.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/aux-mat.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/gas.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/other.vue.js";
import "../../../../../../modules/transfer-handling-96ed23ad.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/components/common-form-item.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/steel-plate.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/components/common-material-info.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/section-steel.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/steel-coil.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/aux-mat.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/gas.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-handling-form/module/other.vue.js";
import "../../../../../../modules/use-header-info-847d35a5.js";
import "../../../../../../modules/use-get-not-printed-material-4179d261.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/module/manuf-list.vue.js";
import "../../../../../../modules/review-a53b87d8.js";
import "../manufactured/manufactured-essential-information/index.vue.js";
import "../manufactured/manufactured-essential-information/module/enclosure.vue.js";
import "../manufactured/manufactured-essential-information/module/structure.vue.js";
import "../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import "../../../../../../modules/material-inventory-71cd4559.js";
import "../../material-label-print/index.vue.js";
import "../../material-label-print/material-mode/index.vue.js";
import "../../../../../../modules/material-mode-V2-9ef0c850.js";
import "../../material-label-print/material-mode/module/header.vue.js";
import "../../../../../../modules/use-print-7c5ddea7.js";
import "../../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../material-label-print/receipt-mode/index.vue.js";
import "../../../../../../modules/receipt-mode-V2-8c051f68.js";
import "../../material-label-print/receipt-mode/module/detail.vue.js";
import "../../material-label-print/receipt-mode/module/header.vue.js";
import "../../../../../../modules/receipt-mode-c54e9044.js";
import "./module/convert-confirm-list/index.vue.js";
import "./module/convert-confirm-list/module/header.vue.js";
import "./module/convert-confirm-list/module/review.vue.js";
import "../../../../../../modules/review-confirm-button-aa3600ad.js";
import "../../../../comps/real-time-inventory/index.vue.js";
import "../../../../material-freeze/freeze-batch-handling-form/index.vue.js";
import "../../../../../../modules/freeze-handling-a93ff3c0.js";
import "../../../../material-moving-inventory/raw-material/components/moving-inventory-batch-handling-form/index.vue.js";
import "../../../../../../modules/application-0ee072a2.js";
import "../../../../../../modules/workshop-select-210dd661.js";
import "../../../../../../modules/popover-confirm-35927771.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil-plate-form.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil-preview.vue.js";
import "../../material-outbound/raw-material/components/outbound-handling-form/module/preview-form.vue.js";
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
const nt = { class: "app-container" }, it = { class: "board-box" }, st = ["onClick"], lt = { key: 1 }, rt = { __name: "index", setup(ct) {
  const Y = Ee(), J = { add: false, edit: false, del: false, download: false }, v = b(), h = b([]), E = b([]), R = b(false);
  b(false);
  const M = b(), j = b(false), { coilPlateConvertList: A } = Pe(), X = b([...Re]), { CRUD: V, crud: r, columns: g } = je({ title: "钢材物料仓", sort: ["id.desc"], invisibleColumns: [], requiredQuery: ["basicClass"], permission: { ...l }, optShow: { ...J }, crudApi: { get: Ge }, multiLineSorting: true }, v), { headerRef: L, expandRowKeys: T, maxHeight: Z, basicClass: _, currentRow: S, outboundHandlingVisible: O, transferHandlingVisible: F, movingInventoryHandlingVisible: $, freezeHandlingVisible: q, toTransfer: ee, toOutHandle: te, toMovHandle: oe, toFreezeHandle: ae, handleOutboundSuccess: ne, handleTransferSuccess: ie, handleFreezeSuccess: se, handleMovSuccess: le } = Ye({ CRUD: V, crud: r, defaultBasicClass: P.STEEL_PLATE.V }), re = H(() => {
    const a = _.value !== P.STEEL_COIL.V ? [u(l.outbound), u(l.transfer), u(l.freeze), u(l.labelPrint), u(l.movingInventory)] : [u(l.outbound), u(l.transfer), u(l.freeze), u(l.labelPrint), u(l.movingInventory), u(l.convert)];
    let o = a.length * 57;
    return a.forEach((s) => {
      s || (o = o - 57);
    }), o + "px";
  });
  b();
  const ce = H(() => {
    var a;
    return ((a = r.query) == null ? void 0 : a.projectWarehouseType) !== Le.PUBLIC.V;
  });
  function ue(a) {
    M.value = a.imgUrl, j.value = true;
  }
  function me(a) {
    S.value = a, R.value = true;
  }
  function w() {
    h.value = [], E.value = [];
  }
  function C() {
    var a;
    (a = v.value) == null || a.clearSelection();
  }
  function pe(a) {
    r.selectionChangeHandler(a);
  }
  V.HOOK.beforeToQuery = async (a) => {
    a.query.projectId || (a.query.monomerId = void 0, a.query.areaId = void 0);
  };
  function de() {
    const a = [];
    r.selections.forEach((o) => {
      a.findIndex((s) => s.id === o.id) < 0 && a.push(o);
    }), E.value.forEach((o) => {
      a.findIndex((s) => s.id === o.id) < 0 && a.push(o);
    }), h.value = a;
  }
  V.HOOK.beforeRefresh = async (a) => {
    const o = [];
    a.selections.forEach((s) => {
      o.findIndex((t) => t.id === s.id) < 0 && o.push(s);
    }), E.value.forEach((s) => {
      o.findIndex((t) => t.id === s.id) < 0 && o.push(s);
    }), h.value = o;
  }, V.HOOK.handleRefresh = async (a, { data: o }) => {
    L.value && L.value.headerRefreshNum(), o.content.forEach((t) => {
      t.originQuantity = t.quantity - (t.frozenQuantity || 0);
    }), await Oe(o.content);
    const s = [];
    o.content = await D(o.content, { toSmallest: false, toNum: false }), o.content.forEach(async (t) => {
      t.operableQuantity = t.quantity - (t.frozenQuantity || 0), t.operableMete = t.mete - (t.frozenMete || 0), t.outboundUnitType === K.MEASURE.V ? (t.corQuantity = t.quantity, t.corFrozenQuantity = t.frozenQuantity, t.corOperableQuantity = t.operableQuantity) : (t.corQuantity = t.mete, t.corFrozenQuantity = t.frozenMete, t.corOperableQuantity = t.operableMete), Array.isArray(t.projectFrozen) && (t.projectFrozenKV = {}, t.projectFrozenForUnitKV = {}, t.projectFrozen = await D(t.projectFrozen, { measureUnit: t.measureUnit, accountingUnit: t.accountingUnit, accountingPrecision: t.accountingPrecision, measurePrecision: t.measurePrecision, toSmallest: false, toNum: true }), s.push(t.projectFrozen), t.projectFrozen.forEach((m) => {
        t.projectFrozenForUnitKV[m.projectId] = t.outboundUnitType === K.MEASURE.V ? m.quantity : m.mete, t.projectFrozenKV[m.projectId] = m;
      }));
    }), await Promise.all(s), await Promise.all(o.content), a.data = o.content, E.value = [], h.value && h.value.length > 0 && h.value.forEach((t) => {
      const m = a.data.find((d) => d.id === t.id);
      Fe(m) ? we(() => {
        var d;
        (d = v.value) == null || d.toggleRowSelection(m, true);
      }) : E.value.push(t);
    });
  }, B(() => r.sort, (a) => {
    var s;
    const o = (s = v.value) == null ? void 0 : s.getColumns();
    o == null || o.forEach((t) => {
      t.sortable === "custom" && (t.order = "null", a == null || a.forEach((m) => {
        const d = m.split(".");
        d[0] === t.property && (d[1] === "asc" ? t.order = "ascending" : d[1] === "desc" && (t.order = "descending"));
      }));
    });
  }, { deep: true, immediate: true });
  function fe() {
    w(), C(), ne();
  }
  function be() {
    w(), C(), ie();
  }
  function _e() {
    w(), C(), se();
  }
  function ye() {
    w(), C(), le();
  }
  function he(a) {
    return De(a, { props: ["quantity", ["mete", Ke.weight.precision]] });
  }
  return b(), b(), b(), b(0), B(() => Y.state.approval_list.approvalNum, async (a) => {
    r.refresh();
  }), (a, o) => {
    const s = Ie, t = xe, m = We, d = N("common-button"), k = ze, ge = N("common-table"), Se = Ve, U = Ce("permission"), ve = Te;
    return c(), Q("div", nt, [i(e(Ze), { ref_key: "headerRef", ref: L, tableSelections: h.value, onClearTableSelection: w, onGetSelections: de, onHandleClearSelection: C }, null, 8, ["tableSelections"]), x((c(), f(ge, { key: `material_inventory_${e(r).query.basicClass}`, ref_key: "tableRef", ref: v, data: e(r).data, "data-format": X.value, "default-expand-all": false, "expand-row-keys": e(T), "max-height": e(Z), "summary-method": he, "row-key": "id", "show-summary": "", onSortChange: e(r).handleSortChange, onSelectionChange: pe }, { default: p(() => [e(_) === e($e).STEEL_PLATE.V ? (c(), f(qe, { key: 0, "expand-row-keys": e(T), "onUpdate:expandRowKeys": o[0] || (o[0] = (n) => z(T) ? T.value = n : null), data: e(r).data, fixed: "left", "row-key": "id" }, { default: p(({ row: n }) => [i(Qe, { "basic-class": n.basicClass, row: n, "show-batch-no": false, "show-graphics": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"])) : y("", true), i(s, { align: "center", type: "selection", width: "55" }), i(Me, { "basic-class": e(_), columns: e(g), "frozen-viewable": "", "show-frozen-tip": "", showIsWhole: "", sortable: "", onRefresh: e(r).toQuery }, null, 8, ["basic-class", "columns", "onRefresh"]), e(g).visible("surplusSn") && e(r).query.basicClass & e(W).STEEL_PLATE.V && e(r).query.materialIsWhole === e(G).ODDMENT.V ? (c(), f(s, { key: "surplusSn", align: "center", label: "余料编号", "min-width": "130px", prop: "surplusSn", "show-overflow-tooltip": "" })) : y("", true), e(g).visible("imgUrl") && e(r).query.basicClass & e(W).STEEL_PLATE.V && e(r).query.materialIsWhole === e(G).ODDMENT.V ? (c(), f(s, { key: "imgUrl", align: "left", label: "余料图片", "min-width": "80px", prop: "imgUrl" }, { default: p(({ row: { sourceRow: n } }) => [ke("div", it, [n.imgUrl ? (c(), Q("div", { key: 0, style: { height: "23px", "line-height": "23px" }, onClick: (I) => ue(n) }, [i(t, { src: n.imgUrl, fit: "contain", style: { width: "100%", height: "100%" } }, null, 8, ["src"])], 8, st)) : (c(), Q("span", lt, "-"))])]), _: 1 })) : y("", true), i(Ae, { "basic-class": e(_), columns: e(g), "equal-disabled": "" }, null, 8, ["basic-class", "columns"]), i(He, { "basic-class": e(_), columns: e(g) }, null, 8, ["basic-class", "columns"]), i(Be, { columns: e(g), "show-area": false, "show-monomer": false, "show-project": ce.value }, null, 8, ["columns", "show-project"]), i(s, { width: re.value, align: "left", fixed: "right", label: "操作" }, { default: p(({ row: { sourceRow: n } }) => [e(u)(e(l).convert) && e(_) === e(P).STEEL_COIL.V ? (c(), f(k, { key: 0, content: e(A).includes(n.classifyId) ? "条板转换" : "该物料未配置条板转换物料配置,不能操作", placement: "top" }, { default: p(() => [i(d, { disabled: !(e(A).includes(n.classifyId) && e(_) === e(P).STEEL_COIL.V && n.corOperableQuantity > 0), size: "default", type: "info", onClick: (I) => me(n) }, { default: p(() => [i(m, { "icon-class": "switch" })]), _: 2 }, 1032, ["disabled", "onClick"])]), _: 2 }, 1032, ["content"])) : y("", true), e(u)(e(l).outbound) ? (c(), f(k, { key: 1, content: "出库", placement: "top" }, { default: p(() => [x((c(), f(d, { size: "default", type: "primary", onClick: (I) => e(te)(n) }, { default: p(() => [i(m, { "icon-class": "wms-outbound" })]), _: 2 }, 1032, ["onClick"])), [[U, e(l).outbound]])]), _: 2 }, 1024)) : y("", true), e(u)(e(l).transfer) ? (c(), f(k, { key: 2, content: "调拨", placement: "top" }, { default: p(() => [x((c(), f(d, { size: "default", type: "warning", onClick: (I) => e(ee)(n) }, { default: p(() => [i(m, { "icon-class": "wms-transfer" })]), _: 2 }, 1032, ["onClick"])), [[U, e(l).transfer]])]), _: 2 }, 1024)) : y("", true), e(u)(e(l).labelPrint) ? (c(), f(et, { key: 3, material: n }, null, 8, ["material"])) : y("", true), e(u)(e(l).freeze) ? (c(), f(k, { key: 4, content: "冻结", placement: "top" }, { default: p(() => [x((c(), f(d, { size: "default", type: "info", onClick: (I) => e(ae)(n) }, { default: p(() => [i(m, { "icon-class": "wms-freeze" })]), _: 2 }, 1032, ["onClick"])), [[U, e(l).freeze]])]), _: 2 }, 1024)) : y("", true), e(u)(e(l).movingInventory) ? (c(), f(k, { key: 5, content: "移库", placement: "top" }, { default: p(() => [x((c(), f(d, { size: "default", type: "danger", onClick: (I) => e(oe)(n) }, { default: p(() => [i(m, { "icon-class": "wms-movingInventory" })]), _: 2 }, 1032, ["onClick"])), [[U, e(l).movingInventory]])]), _: 2 }, 1024)) : y("", true)]), _: 1 }, 8, ["width"])]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[ve, e(r).loading]]), i(e(Ne)), i(Je, { visible: e(O), "onUpdate:visible": o[1] || (o[1] = (n) => z(O) ? O.value = n : null), "basic-class": e(_), material: e(S), onSuccess: fe }, null, 8, ["visible", "basic-class", "material"]), i(Xe, { visible: e(F), "onUpdate:visible": o[2] || (o[2] = (n) => z(F) ? F.value = n : null), "basic-class": e(_), material: e(S), onSuccess: be }, null, 8, ["visible", "basic-class", "material"]), i(tt, { visible: R.value, "onUpdate:visible": o[3] || (o[3] = (n) => R.value = n), "basic-class": e(_), material: e(S), onSuccess: e(r).toQuery }, null, 8, ["visible", "basic-class", "material", "onSuccess"]), i(ot, { visible: e(q), "onUpdate:visible": o[4] || (o[4] = (n) => z(q) ? q.value = n : null), "basic-class": e(_), material: e(S), onSuccess: _e }, null, 8, ["visible", "basic-class", "material"]), i(at, { visible: e($), "onUpdate:visible": o[5] || (o[5] = (n) => z($) ? $.value = n : null), "basic-class": e(_), material: e(S), onSuccess: ye }, null, 8, ["visible", "basic-class", "material"]), i(Se, { modelValue: j.value, "onUpdate:modelValue": o[6] || (o[6] = (n) => j.value = n), width: "60%" }, { default: p(() => [i(t, { src: M.value, fit: "contain", style: { height: "500px" } }, null, 8, ["src"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Ao = Ue(rt, [["__scopeId", "data-v-35eb73d7"]]);
export {
  Ao as default
};
