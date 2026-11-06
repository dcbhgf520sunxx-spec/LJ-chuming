import { useStore as L } from "vuex";
import { ref as l } from "vue";
import { computed as z } from "vue";
import { watch as X } from "vue";
import { resolveComponent as H } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as Z } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withDirectives as u } from "vue";
import { createBlock as m } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as ee } from "vue";
import { isRef as g } from "vue";
import { ElTableColumn as oe } from "element-plus";
import { vLoading as se } from "element-plus";
import { _ as ae, sP as te, x as ne, zT as a, bl as ie, G as d, pB as $, jG as re, sO as le, k5 as ce, k6 as me, P as pe, a as ue } from "../../../../../../shared/runtime.js";
import { a as de } from "../../../../../../modules/warehouse-management-aa3a73c1.js";
import { u as fe } from "../../../../../../modules/use-index-info-d6256761.js";
import _e from "./module/header.vue.js";
import be from "../../material-outbound/raw-material/components/outbound-handling-form/index.vue.js";
import ve from "../../../../material-transfer/raw-material/components/transfer-handling-form/index.vue.js";
import he from "../../../../material-freeze/freeze-handling-form/index.vue.js";
import ye from "../../../../material-moving-inventory/raw-material/components/moving-inventory-handling-form/index.vue.js";
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
const ge = { class: "app-container" }, Ce = { __name: "index", setup(we) {
  const T = L(), O = { add: false, edit: false, del: false, download: false }, I = l(), q = l([...te]), { CRUD: C, crud: i, columns: f } = ne({ title: "气体物料仓", sort: ["id.desc"], invisibleColumns: [], requiredQuery: ["basicClass"], permission: { ...a }, optShow: { ...O }, crudApi: { get: de } }, I), { headerRef: P, expandRowKeys: V, maxHeight: j, basicClass: r, currentRow: _, outboundHandlingVisible: w, transferHandlingVisible: k, movingInventoryHandlingVisible: S, freezeHandlingVisible: x, toTransfer: E, toOutHandle: B, toMovHandle: D, toFreezeHandle: M, handleOutboundSuccess: U, handleTransferSuccess: A, handleMovSuccess: F, handleRefresh: G, handleFreezeSuccess: W } = fe({ CRUD: C, crud: i, defaultBasicClass: ie.GAS.V }), K = z(() => {
    const s = [d(a.outbound), d(a.transfer), d(a.freeze), d(a.movingInventory)];
    let t = s.length * 57;
    return s.forEach((b) => {
      b || (t = t - 57);
    }), t + "px";
  }), N = z(() => {
    var s;
    return ((s = i.query) == null ? void 0 : s.projectWarehouseType) === $.PROJECT.V;
  });
  return C.HOOK.beforeToQuery = async (s) => {
    s.query.projectId || (s.query.monomerId = void 0, s.query.areaId = void 0);
  }, C.HOOK.beforeRefresh = async (s) => {
    s.query.projectWarehouseType = $.PROJECT.V;
  }, l(), l(), l(), l(), l(false), X(() => T.state.approval_list.approvalNum, async (s) => {
    i.refresh();
  }), (s, t) => {
    const b = oe, v = ue, h = H("common-button"), J = H("common-table"), y = Y("permission"), Q = se;
    return c(), Z("div", ge, [o(e(_e), { ref_key: "headerRef", ref: P }, null, 512), u((c(), m(J, { key: `material_inventory_${e(i).query.basicClass}`, ref_key: "tableRef", ref: I, data: e(i).data, "data-format": q.value, "default-expand-all": false, "expand-row-keys": e(V), "max-height": e(j), "row-key": "id", onSortChange: e(i).handleSortChange, onSelectionChange: e(i).selectionChangeHandler }, { default: p(() => [o(b, { align: "center", type: "selection", width: "55" }), o(re, { "basic-class": e(r), columns: e(f), "frozen-viewable": "", "show-frozen-tip": "", sortable: "", onRefresh: e(G) }, null, 8, ["basic-class", "columns", "onRefresh"]), o(le, { "basic-class": e(r), columns: e(f), "equal-disabled": "" }, null, 8, ["basic-class", "columns"]), o(ce, { "basic-class": e(r), columns: e(f) }, null, 8, ["basic-class", "columns"]), o(me, { columns: e(f), "show-area": false, "show-monomer": false, "show-project": N.value }, null, 8, ["columns", "show-project"]), e(d)([...e(a).outbound, ...e(a).transfer, ...e(a).freeze, ...e(a).movingInventory]) ? (c(), m(b, { key: 0, width: K.value, align: "center", fixed: "right", label: "操作" }, { default: p(({ row: { sourceRow: n } }) => [u((c(), m(h, { size: "default", type: "primary", onClick: (R) => e(B)(n) }, { default: p(() => [o(v, { "icon-class": "wms-outbound" })]), _: 2 }, 1032, ["onClick"])), [[y, e(a).outbound]]), u((c(), m(h, { size: "default", type: "warning", onClick: (R) => e(E)(n) }, { default: p(() => [o(v, { "icon-class": "wms-transfer" })]), _: 2 }, 1032, ["onClick"])), [[y, e(a).transfer]]), u((c(), m(h, { size: "default", type: "info", onClick: (R) => e(M)(n) }, { default: p(() => [o(v, { "icon-class": "wms-freeze" })]), _: 2 }, 1032, ["onClick"])), [[y, e(a).freeze]]), u((c(), m(h, { size: "default", type: "danger", onClick: (R) => e(D)(n) }, { default: p(() => [o(v, { "icon-class": "wms-movingInventory" })]), _: 2 }, 1032, ["onClick"])), [[y, e(a).movingInventory]])]), _: 1 }, 8, ["width"])) : ee("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[Q, e(i).loading]]), o(e(pe)), o(be, { visible: e(w), "onUpdate:visible": t[0] || (t[0] = (n) => g(w) ? w.value = n : null), "basic-class": e(r), material: e(_), onSuccess: e(U) }, null, 8, ["visible", "basic-class", "material", "onSuccess"]), o(ve, { visible: e(k), "onUpdate:visible": t[1] || (t[1] = (n) => g(k) ? k.value = n : null), "basic-class": e(r), material: e(_), onSuccess: e(A) }, null, 8, ["visible", "basic-class", "material", "onSuccess"]), o(he, { visible: e(x), "onUpdate:visible": t[2] || (t[2] = (n) => g(x) ? x.value = n : null), "basic-class": e(r), material: e(_), onSuccess: e(W) }, null, 8, ["visible", "basic-class", "material", "onSuccess"]), o(ye, { visible: e(S), "onUpdate:visible": t[3] || (t[3] = (n) => g(S) ? S.value = n : null), "basic-class": e(r), material: e(_), onSuccess: e(F) }, null, 8, ["visible", "basic-class", "material", "onSuccess"])]);
  };
} }, Ro = ae(Ce, [["__scopeId", "data-v-2b459d74"]]);
export {
  Ro as default
};
