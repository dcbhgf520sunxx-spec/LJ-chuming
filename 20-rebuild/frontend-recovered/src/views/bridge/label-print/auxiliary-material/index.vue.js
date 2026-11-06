import { ref as u } from "vue";
import { provide as N } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as a } from "vue";
import { withDirectives as D } from "vue";
import { unref as t } from "vue";
import { createBlock as c } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as _ } from "vue";
import { createTextVNode as O } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElInputNumber as z } from "element-plus";
import { vLoading as F } from "element-plus";
import { g as H } from "../../../../modules/print-record-c36add77.js";
import { l as Y, x as X, o as G, F as J, bc as K, P as W, p as M, bd as Z } from "../../../../shared/runtime.js";
import { p as ee } from "../../../../modules/index-069ba252.js";
import { i as P } from "../../../../modules/bridge-86f96a4f.js";
import { _ as te } from "../../../../modules/index-5ab69a0f.js";
import { _ as ne } from "../../../../modules/index-6a17f241.js";
import ae from "./module/header.vue.js";
import ie from "../components/label-dlg.vue.js";
import oe from "../components/task-printed-record-drawer.vue.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-3b2e6e51.js";
import "../../../../modules/bridge-label-a62ef559.js";
import "../../../../modules/use-label-print-47f6f6b0.js";
import "../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
function le(U) {
  return Y({ module: "bridge", url: "print/auxiliary-material", method: "get", params: U });
}
const re = { get: le }, se = { class: "app-container" }, pe = { class: "head-container" }, Re = { __name: "index", setup(U) {
  const S = { add: false, edit: false, del: false, download: false }, g = u(), R = u(), { crud: m, columns: r } = X({ title: "产品标签-配套件", permission: { ...P }, optShow: { ...S }, crudApi: { ...re }, queryOnPresenterCreated: false }, R), { maxHeight: $ } = G({ paginate: true }), h = u(false), A = u({}), V = u(), v = u(false), d = J.AUXILIARY_MATERIAL.V;
  N("productType", d);
  const L = K.COMMON.V;
  async function E(n) {
    try {
      await g.value.print([n]);
    } catch (i) {
      console.log("打印标签失败", i);
    }
  }
  function Q(n) {
    A.value = I(n), h.value = true;
  }
  function q(n) {
    V.value = n.id, v.value = true;
  }
  function I(n) {
    var e, s;
    const { printConfig: i, spliceQrCodeUrl: o, QR_SCAN_PATH: w, requestUrl: C, companyName: f } = g.value, x = { projectName: (e = n.project) == null ? void 0 : e.shortName, printTime: n.printTime ? M(n.printTime, "{y}/{m}/{d}") : M((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), monomerName: (s = n.monomer) == null ? void 0 : s.name, name: n.classifyName, serialNumber: n.serialNumber, color: n.color, brand: n.brand, quantity: n.mete, specification: n.specification, drawingNumber: n.drawingNumber }, T = C;
    return { productType: d, labelType: L, component: x, printConfig: i, manufacturerName: i.manufacturerName || f, qrCode: o(`${T}${w.AUXILIARY_MATERIAL}`, { id: n.id, ftype: Z.BRIDGE_PRODUCTION, type: d }) };
  }
  return N("permission", P), N("headerObj", { getLabelInfo: I, printLabelFunc: ee }), (n, i) => {
    const o = j, w = k("table-cell-tag"), C = z, f = k("common-button"), x = k("common-table"), T = F;
    return p(), B("div", se, [b("div", pe, [a(ae, { ref_key: "headRef", ref: g }, null, 512)]), D((p(), c(x, { ref_key: "tableRef", ref: R, data: t(m).data, "empty-text": t(m).emptyText, "max-height": t($), style: { width: "100%" }, "row-key": "id", onSortChange: t(m).handleSortChange, onSelectionChange: t(m).selectionChangeHandler }, { default: l(() => [a(o, { type: "selection", width: "55", align: "center" }), a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(t(te), { columns: t(r), showMonomer: "" }, null, 8, ["columns"]), a(t(ne), { productType: t(d), columns: t(r) }, { namePrefix: l(({ row: e }) => [a(w, { show: !!e.printedQuantity, name: "已打印", color: "#e64242", offset: 15 }, null, 8, ["show"])]), _: 1 }, 8, ["productType", "columns"]), t(r).visible("measureUnit") ? (p(), c(o, { key: 0, "show-overflow-tooltip": true, prop: "measureUnit", label: "计量单位", align: "center", "min-width": "70px" }, { default: l(({ row: e }) => [b("span", null, y(e.measureUnit), 1)]), _: 1 })) : _("", true), t(r).visible("quantity") ? (p(), c(o, { key: 1, "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center", "min-width": "120px" }, { default: l(({ row: e }) => [b("span", null, y(e.quantity), 1)]), _: 1 })) : _("", true), t(r).visible("accountingUnit") ? (p(), c(o, { key: 2, "show-overflow-tooltip": true, prop: "accountingUnit", label: "核算单位", align: "center", "min-width": "70px" }, { default: l(({ row: e }) => [b("span", null, y(e.accountingUnit), 1)]), _: 1 })) : _("", true), t(r).visible("mete") ? (p(), c(o, { key: 3, "show-overflow-tooltip": true, prop: "mete", label: "核算量", align: "center", "min-width": "120px" }, { default: l(({ row: e }) => [b("span", null, y(e.mete), 1)]), _: 1 })) : _("", true), t(r).visible("printQuantity") ? (p(), c(o, { key: "printQuantity", prop: "printQuantity", sortable: "custom", label: "打印数量", align: "center", width: "120px" }, { default: l((e) => [a(C, { modelValue: e.row.printQuantity, "onUpdate:modelValue": (s) => e.row.printQuantity = s, step: 1, min: 0, size: "default", style: { width: "100%" }, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : _("", true), a(o, { label: "操作", width: "225px", align: "center", fixed: "right" }, { default: l((e) => [a(f, { icon: "el-icon-printer", type: "success", size: "default", onClick: (s) => E(e.row) }, null, 8, ["onClick"]), a(f, { icon: "el-icon-view", type: "primary", size: "default", onClick: (s) => Q(e.row) }, null, 8, ["onClick"]), a(f, { type: "info", size: "default", onClick: (s) => q(e.row) }, { default: l(() => i[2] || (i[2] = [O("打印记录")])), _: 2, __: [2] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[T, t(m).loading]]), a(t(W)), a(oe, { visible: v.value, "onUpdate:visible": i[0] || (i[0] = (e) => v.value = e), "task-id": V.value, getPrintRecord: t(H) }, null, 8, ["visible", "task-id", "getPrintRecord"]), a(t(ie), { visible: h.value, "onUpdate:visible": i[1] || (i[1] = (e) => h.value = e), "label-data": A.value, productType: t(d), labelType: t(L) }, null, 8, ["visible", "label-data", "productType", "labelType"])]);
  };
} };
export {
  Re as default
};
