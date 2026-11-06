import { useStore as we } from "vuex";
import { ref as d } from "vue";
import { computed as A } from "vue";
import { watch as H } from "vue";
import { nextTick as Ee } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as ve } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as $ } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as f } from "vue";
import { withCtx as b } from "vue";
import { isRef as x } from "vue";
import { createCommentVNode as y } from "vue";
import { createElementVNode as Ce } from "vue";
import { ElTableColumn as ke } from "element-plus";
import { ElImage as xe } from "element-plus";
import { ElTooltip as ze } from "element-plus";
import { ElDialog as Ie } from "element-plus";
import { vLoading as Te } from "element-plus";
import { _ as Ve, zJ as Ue, sP as Pe, x as Re, zV as r, bl as D, G as u, pB as N, cO as je, jl as B, cS as K, i as Fe, cP as Oe, aR as qe, k4 as $e, jG as Me, sl as W, xY as G, sO as Qe, k5 as Ae, k6 as He, P as Le, ba as De, jN as Ne, a as Be } from "../../../../../../shared/runtime.js";
import { c as Ke } from "../../../../../../modules/warehouse-management-aa3a73c1.js";
import { u as We } from "../../../../../../modules/use-index-info-d6256761.js";
import Ge from "../../material-outbound/raw-material/components/outbound-handling-form/index.vue.js";
import Je from "../../../../material-transfer/raw-material/components/transfer-handling-form/index.vue.js";
import Ye from "./module/header.vue.js";
import { _ as Xe } from "../../../../../../modules/material-print-button-3ec7d08d.js";
import Ze from "../../material-outbound/raw-material/components/outbound-handling-form/module/steel-coil-plate.vue.js";
import et from "../../../../material-freeze/freeze-handling-form/index.vue.js";
import tt from "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/index.vue.js";
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
import "../../../../../../modules/use-header-info-d26b03b1.js";
import "../../../../../../modules/use-get-not-printed-material-4179d261.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/index.vue.js";
import "../../material-outbound/raw-material/components/current-user-outbound-list/module/list.vue.js";
import "../../material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js";
import "../../../../material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js";
import "../../../../../../modules/material-inventory-71cd4559.js";
import "../../material-label-print/index.vue.js";
import "../../material-label-print/material-mode/index.vue.js";
import "../../../../../../modules/material-mode-V2-9ef0c850.js";
import "../../material-label-print/material-mode/module/header.vue.js";
import "../../../../../../modules/use-print-4d7e67fe.js";
import "../../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../material-label-print/receipt-mode/index.vue.js";
import "../../../../../../modules/receipt-mode-V2-8c051f68.js";
import "../../material-label-print/receipt-mode/module/detail.vue.js";
import "../../material-label-print/receipt-mode/module/header.vue.js";
import "../../../../../../modules/receipt-mode-c54e9044.js";
import "./module/convert-confirm-list/index.vue.js";
import "./module/convert-confirm-list/module/header.vue.js";
import "./module/convert-confirm-list/module/detail.vue.js";
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
const ot = { class: "app-container" }, at = { class: "board-box" }, nt = ["onClick"], it = { key: 1 }, st = { __name: "index", setup(rt) {
  const J = we();
  Ue();
  const Y = { add: false, edit: false, del: false, download: false }, S = d(), h = d([]), w = d([]), M = d(false), Q = d(), P = d(false), X = d([...Pe]), { CRUD: z, crud: l, columns: g } = Re({ title: "钢材物料仓", sort: ["id.desc"], invisibleColumns: [], requiredQuery: ["basicClass"], permission: { ...r }, optShow: { ...Y }, crudApi: { get: Ke }, multiLineSorting: true }, S), { headerRef: R, expandRowKeys: I, maxHeight: Z, basicClass: _, currentRow: E, outboundHandlingVisible: j, transferHandlingVisible: F, movingInventoryHandlingVisible: O, freezeHandlingVisible: q, toTransfer: ee, toOutHandle: te, toMovHandle: oe, toFreezeHandle: ae, handleOutboundSuccess: ne, handleTransferSuccess: ie, handleFreezeSuccess: se, handleMovSuccess: re } = We({ CRUD: z, crud: l, defaultBasicClass: D.STEEL_PLATE.V }), le = A(() => {
    const a = _.value !== D.STEEL_COIL.V ? [u(r.outbound), u(r.transfer), u(r.freeze), u(r.labelPrint), u(r.movingInventory)] : [u(r.outbound), u(r.transfer), u(r.freeze), u(r.labelPrint), u(r.movingInventory), u(r.convert)];
    let o = a.length * 57;
    return a.forEach((i) => {
      i || (o = o - 57);
    }), o + "px";
  }), ce = A(() => {
    var a;
    return ((a = l.query) == null ? void 0 : a.projectWarehouseType) === N.PROJECT.V;
  });
  H(() => l.sort, (a) => {
    var i;
    const o = (i = S.value) == null ? void 0 : i.getColumns();
    o == null || o.forEach((t) => {
      t.sortable === "custom" && (t.order = "null", a == null || a.forEach((m) => {
        const p = m.split(".");
        p[0] === t.property && (p[1] === "asc" ? t.order = "ascending" : p[1] === "desc" && (t.order = "descending"));
      }));
    });
  }, { deep: true, immediate: true });
  function ue(a) {
    Q.value = a.imgUrl, P.value = true;
  }
  function v() {
    h.value = [], w.value = [];
  }
  function C() {
    var a;
    (a = S.value) == null || a.clearSelection();
  }
  function me(a) {
    l.selectionChangeHandler(a);
  }
  z.HOOK.beforeToQuery = async (a) => {
    a.query.projectId || (a.query.monomerId = void 0, a.query.areaId = void 0);
  };
  function pe() {
    const a = [];
    l.selections.forEach((o) => {
      a.findIndex((i) => i.id === o.id) < 0 && a.push(o);
    }), w.value.forEach((o) => {
      a.findIndex((i) => i.id === o.id) < 0 && a.push(o);
    }), h.value = a;
  }
  z.HOOK.beforeRefresh = async (a) => {
    a.query.projectWarehouseType = N.PROJECT.V;
    const o = [];
    a.selections.forEach((i) => {
      o.findIndex((t) => t.id === i.id) < 0 && o.push(i);
    }), w.value.forEach((i) => {
      o.findIndex((t) => t.id === i.id) < 0 && o.push(i);
    }), h.value = o;
  }, z.HOOK.handleRefresh = async (a, { data: o }) => {
    R.value && R.value.headerRefreshNum(), o.content.forEach((t) => {
      t.originQuantity = t.quantity - (t.frozenQuantity || 0);
    }), await je(o.content);
    const i = [];
    o.content = await B(o.content, { toSmallest: false, toNum: false }), o.content.forEach(async (t) => {
      t.operableQuantity = t.quantity - (t.frozenQuantity || 0), t.operableMete = t.mete - (t.frozenMete || 0), t.outboundUnitType === K.MEASURE.V ? (t.corQuantity = t.quantity, t.corFrozenQuantity = t.frozenQuantity, t.corOperableQuantity = t.operableQuantity) : (t.corQuantity = t.mete, t.corFrozenQuantity = t.frozenMete, t.corOperableQuantity = t.operableMete), Array.isArray(t.projectFrozen) && (t.projectFrozenKV = {}, t.projectFrozenForUnitKV = {}, t.projectFrozen = await B(t.projectFrozen, { measureUnit: t.measureUnit, accountingUnit: t.accountingUnit, accountingPrecision: t.accountingPrecision, measurePrecision: t.measurePrecision, toSmallest: false, toNum: true }), i.push(t.projectFrozen), t.projectFrozen.forEach((m) => {
        t.projectFrozenForUnitKV[m.projectId] = t.outboundUnitType === K.MEASURE.V ? m.quantity : m.mete, t.projectFrozenKV[m.projectId] = m;
      }));
    }), await Promise.all(i), await Promise.all(o.content), a.data = o.content, w.value = [], h.value && h.value.length > 0 && h.value.forEach((t) => {
      const m = a.data.find((p) => p.id === t.id);
      Fe(m) ? Ee(() => {
        var p;
        (p = S.value) == null || p.toggleRowSelection(m, true);
      }) : w.value.push(t);
    });
  };
  function de() {
    v(), C(), ne();
  }
  function fe() {
    v(), C(), ie();
  }
  function be() {
    v(), C(), se();
  }
  function _e() {
    v(), C(), re();
  }
  function ye(a) {
    return De(a, { props: ["quantity", ["mete", Ne.weight.precision]] });
  }
  return d(), d(), d(), d(), d(false), d(0), H(() => J.state.approval_list.approvalNum, async (a) => {
    l.refresh();
  }), (a, o) => {
    const i = ke, t = xe, m = Be, p = L("common-button"), T = ze, he = L("common-table"), ge = Ie, V = ve("permission"), Se = Te;
    return c(), $("div", ot, [s(e(Ye), { ref_key: "headerRef", ref: R, tableSelections: h.value, onClearTableSelection: v, onGetSelections: pe, onHandleClearSelection: C }, null, 8, ["tableSelections"]), k((c(), f(he, { key: `material_inventory_${e(l).query.basicClass}`, ref_key: "tableRef", ref: S, data: e(l).data, "data-format": X.value, "default-expand-all": false, "expand-row-keys": e(I), "max-height": e(Z), "summary-method": ye, "row-key": "id", "show-summary": "", onSortChange: e(l).handleSortChange, onSelectionChange: me }, { default: b(() => [e(_) === e(Oe).STEEL_PLATE.V ? (c(), f(qe, { key: 0, "expand-row-keys": e(I), "onUpdate:expandRowKeys": o[0] || (o[0] = (n) => x(I) ? I.value = n : null), data: e(l).data, "row-key": "id" }, { default: b(({ row: n }) => [s($e, { "basic-class": n.basicClass, row: n, "show-batch-no": false, "show-graphics": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"])) : y("", true), s(i, { align: "center", type: "selection", width: "55" }), s(Me, { "basic-class": e(_), columns: e(g), "frozen-viewable": "", showIsWhole: "", "show-frozen-tip": "", sortable: "", onRefresh: e(l).toQuery }, null, 8, ["basic-class", "columns", "onRefresh"]), e(g).visible("surplusSn") && e(l).query.basicClass & e(W).STEEL_PLATE.V && e(l).query.materialIsWhole === e(G).ODDMENT.V ? (c(), f(i, { key: "surplusSn", align: "center", label: "余料编号", prop: "surplusSn", "min-width": "130px", "show-overflow-tooltip": "" })) : y("", true), e(g).visible("imgUrl") && e(l).query.basicClass & e(W).STEEL_PLATE.V && e(l).query.materialIsWhole === e(G).ODDMENT.V ? (c(), f(i, { key: "imgUrl", prop: "imgUrl", label: "余料图片", align: "left", "min-width": "80px" }, { default: b(({ row: { sourceRow: n } }) => [Ce("div", at, [n.imgUrl ? (c(), $("div", { key: 0, style: { height: "23px", "line-height": "23px" }, onClick: (U) => ue(n) }, [s(t, { style: { width: "100%", height: "100%" }, src: n.imgUrl, fit: "contain" }, null, 8, ["src"])], 8, nt)) : (c(), $("span", it, "-"))])]), _: 1 })) : y("", true), s(Qe, { "basic-class": e(_), columns: e(g), "equal-disabled": "" }, null, 8, ["basic-class", "columns"]), s(Ae, { "basic-class": e(_), columns: e(g) }, null, 8, ["basic-class", "columns"]), s(He, { columns: e(g), "show-area": false, "show-monomer": false, "show-project": ce.value }, null, 8, ["columns", "show-project"]), s(i, { width: le.value, align: "left", fixed: "right", label: "操作" }, { default: b(({ row: { sourceRow: n } }) => [e(u)(e(r).outbound) ? (c(), f(T, { key: 0, content: "出库", placement: "top" }, { default: b(() => [k((c(), f(p, { size: "default", type: "primary", onClick: (U) => e(te)(n) }, { default: b(() => [s(m, { "icon-class": "wms-outbound" })]), _: 2 }, 1032, ["onClick"])), [[V, e(r).outbound]])]), _: 2 }, 1024)) : y("", true), e(u)(e(r).transfer) ? (c(), f(T, { key: 1, content: "调拨", placement: "top" }, { default: b(() => [k((c(), f(p, { size: "default", type: "warning", onClick: (U) => e(ee)(n) }, { default: b(() => [s(m, { "icon-class": "wms-transfer" })]), _: 2 }, 1032, ["onClick"])), [[V, e(r).transfer]])]), _: 2 }, 1024)) : y("", true), e(u)(e(r).labelPrint) ? (c(), f(Xe, { key: 2, material: n }, null, 8, ["material"])) : y("", true), e(u)(e(r).freeze) ? (c(), f(T, { key: 3, content: "冻结", placement: "top" }, { default: b(() => [k((c(), f(p, { size: "default", type: "info", onClick: (U) => e(ae)(n) }, { default: b(() => [s(m, { "icon-class": "wms-freeze" })]), _: 2 }, 1032, ["onClick"])), [[V, e(r).freeze]])]), _: 2 }, 1024)) : y("", true), e(u)(e(r).movingInventory) ? (c(), f(T, { key: 4, content: "移库", placement: "top" }, { default: b(() => [k((c(), f(p, { size: "default", type: "danger", onClick: (U) => e(oe)(n) }, { default: b(() => [s(m, { "icon-class": "wms-movingInventory" })]), _: 2 }, 1032, ["onClick"])), [[V, e(r).movingInventory]])]), _: 2 }, 1024)) : y("", true)]), _: 1 }, 8, ["width"])]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[Se, e(l).loading]]), s(e(Le)), s(Ge, { visible: e(j), "onUpdate:visible": o[1] || (o[1] = (n) => x(j) ? j.value = n : null), "basic-class": e(_), material: e(E), onSuccess: de }, null, 8, ["visible", "basic-class", "material"]), s(Je, { visible: e(F), "onUpdate:visible": o[2] || (o[2] = (n) => x(F) ? F.value = n : null), "basic-class": e(_), material: e(E), onSuccess: fe }, null, 8, ["visible", "basic-class", "material"]), s(Ze, { visible: M.value, "onUpdate:visible": o[3] || (o[3] = (n) => M.value = n), "basic-class": e(_), material: e(E), onSuccess: e(l).toQuery }, null, 8, ["visible", "basic-class", "material", "onSuccess"]), s(et, { visible: e(q), "onUpdate:visible": o[4] || (o[4] = (n) => x(q) ? q.value = n : null), "basic-class": e(_), material: e(E), onSuccess: be }, null, 8, ["visible", "basic-class", "material"]), s(tt, { visible: e(O), "onUpdate:visible": o[5] || (o[5] = (n) => x(O) ? O.value = n : null), "basic-class": e(_), material: e(E), onSuccess: _e }, null, 8, ["visible", "basic-class", "material"]), s(ge, { modelValue: P.value, "onUpdate:modelValue": o[6] || (o[6] = (n) => P.value = n), width: "60%" }, { default: b(() => [s(t, { style: { height: "500px" }, src: Q.value, fit: "contain" }, null, 8, ["src"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Oo = Ve(st, [["__scopeId", "data-v-f3c6f881"]]);
export {
  Oo as default
};
