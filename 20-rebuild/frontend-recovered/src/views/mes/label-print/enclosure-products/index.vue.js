import { ref as h } from "vue";
import { provide as _ } from "vue";
import { computed as W } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as Y } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as l } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as p } from "vue";
import { createTextVNode as J } from "vue";
import { ElMessage as X } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElInputNumber as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { c as ae, b as P, e as Q, g as oe, f as ne, d as ie } from "../../../../modules/enclosure-6f8adfb8.js";
import { x as le, o as re, a3 as se, mz as ue, br as pe, bs as A, D as C, kA as ce, c as me, P as de, m4 as T, p as D, bd as be } from "../../../../shared/runtime.js";
import { d as fe } from "../../../../modules/index-069ba252.js";
import { b } from "../../../../modules/enclosure-365a2177.js";
import ye from "../components/label-print-header.vue.js";
import he from "../components/task-printed-record-drawer.vue.js";
import _e from "../components/label-dlg.vue.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-3b2e6e51.js";
import "../../../../modules/label-6ff6c88d.js";
import "../../../../modules/base-6bc46ddf.js";
import "../../../../modules/print-record-2e0b6340.js";
import "../../../../modules/use-label-print-e19db37a.js";
import "../../../../modules/index-b238c21c.js";
import "../components/has-task-productLine-select.vue.js";
import "../../../../modules/use-product-lines-79a95221.js";
import "../../../../modules/index-8356a01a.js";
import "../components/product-traceability-setting-drawer.vue.js";
const ve = { class: "app-container" }, ge = { class: "head-container" }, je = { __name: "index", setup(ke) {
  const H = { add: false, edit: false, del: false, download: false }, v = h(), O = h(), { crud: r, columns: s, CRUD: $ } = le({ title: "产品标签-围护", permission: { ...b }, optShow: { ...H }, crudApi: { ...ae }, queryOnPresenterCreated: false, invisibleColumns: ["remark"] }, O), { maxHeight: F } = re({ paginate: true });
  $.HOOK.beforeToQuery = () => {
    r.query.lineId = r.query.productionLineId;
  };
  const E = h(false), N = h({}), x = h(), S = h(false), w = se.ENCLOSURE.V;
  _("permission", b), _("productType", w);
  const z = ue.ENCLOSURE.V;
  _("printType", z), _("taskPrintAdd", P), _("taskSubscribePrintAdd", Q);
  const I = W(() => {
    var t, n;
    return (n = (t = v.value) == null ? void 0 : t.printConfig) == null ? void 0 : n.type;
  });
  async function j(t) {
    var n;
    try {
      if ((n = v.value) != null && n.boolPrintWarehousing && t.warehouseQuantity < 1) return X.error("打印失败，所选产品未入库！");
      await v.value.print([t], r.query.manufactureType === T.OUTSOURCE.V ? "whId" : "taskId", r.query.manufactureType === T.OUTSOURCE.V ? Q : P);
    } catch (o) {
      console.log("打印标签失败", o);
    }
  }
  function B(t) {
    N.value = V(t), console.log(N.value), E.value = true;
  }
  function K(t) {
    r.query.manufactureType === T.OUTSOURCE.V ? x.value = t.whId : x.value = t.taskId, S.value = true;
  }
  function V(t) {
    var f, q;
    const { printConfig: n, spliceQrCodeUrl: o, QR_SCAN_PATH: R, requestUrl: g, companyName: U } = v.value, y = { projectName: (f = t.project) == null ? void 0 : f.shortName, printTime: t.printTime ? D(t.printTime, "{y}/{m}/{d}") : D((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), name: t.name, serialNumber: t.serialNumber, color: t.color, plate: t.plate, thickness: t.thickness && ((q = t.thickness) == null ? void 0 : q.toFixed(C.MES_ENCLOSURE_T__MM)), length: t.length, quantity: t.quantity, specification: t.specification, drawingNumber: t.drawingNumber }, L = g, a = { id: t.id, ftype: be.MEW_PRODUCTION, factoryId: t.factoryId, taskId: t == null ? void 0 : t.taskId, whId: t == null ? void 0 : t.whId, type: w, sa: Number(n.showArea), sm: Number(n.showMonomer) };
    return a.taskId || delete a.taskId, a.whId || delete a.whId, { productType: w, labelType: I.value, component: y, printConfig: n, manufacturerName: n.manufacturerName || U, qrCode: o(`${L}${R.ENCLOSURE_TASK}`, a) };
  }
  return _("headerObj", { getLabelInfo: V, printLabelFunc: fe }), (t, n) => {
    const o = Z, R = ee, g = M("common-button"), U = M("common-table"), y = G("permission"), L = te;
    return i(), Y("div", ve, [m("div", ge, [c(ye, { ref_key: "headRef", ref: v, productionLineHasTaskApi: e(oe) }, null, 8, ["productionLineHasTaskApi"])]), k((i(), l(U, { ref_key: "tableRef", ref: O, data: e(r).data, "empty-text": e(r).emptyText, "max-height": e(F), "show-empty-symbol": false, "row-key": "taskId", style: { width: "100%" }, onSortChange: e(r).handleSortChange, onSelectionChange: e(r).selectionChangeHandler }, { default: u(() => [c(o, { align: "center", type: "selection", width: "55" }), c(o, { align: "center", label: "序号", type: "index", width: "60" }), e(s).visible("name") ? (i(), l(o, { key: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "120px", prop: "name", sortable: "custom" }, { default: u((a) => [c(e(pe), { offset: 15, show: a.row.boolPrinted, color: "#e64242", name: "已打印" }, null, 8, ["show"]), m("span", null, d(a.row.name), 1)]), _: 1 })) : p("", true), e(s).visible("serialNumber") ? (i(), l(o, { key: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "140px", prop: "serialNumber", sortable: "custom" }, { default: u((a) => [m("span", null, d(a.row.serialNumber), 1)]), _: 1 })) : p("", true), e(s).visible("color") ? (i(), l(o, { key: "color", "show-overflow-tooltip": true, label: "颜色", "min-width": "100px", prop: "color", sortable: "custom" }, { default: u((a) => [m("span", null, d(a.row.color || "-"), 1)]), _: 1 })) : p("", true), e(s).visible("length") ? (i(), l(o, { key: "length", label: "单长(mm)", "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "length", sortable: "custom" }, { default: u((a) => [m("span", null, d(e(A)(a.row.length, e(C).MES_ENCLOSURE_L__MM) || "-"), 1)]), _: 1 })) : p("", true), e(s).visible("thickness") ? (i(), l(o, { key: "thickness", label: "板厚(mm)", "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "thickness", sortable: "custom" }, { default: u((a) => [m("span", null, d(e(A)(a.row.thickness, e(C).MES_ENCLOSURE_T__MM) || "-"), 1)]), _: 1 })) : p("", true), e(s).visible("plate") && e(r).query.category !== e(ce).FOLDING_PIECE.V ? (i(), l(o, { key: "plate", label: "板型", "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "plate", sortable: "custom" }, { default: u((a) => [m("span", null, d(a.row.plate || "-"), 1)]), _: 1 })) : p("", true), e(s).visible("totalLength") ? (i(), l(o, { key: "totalLength", label: "总长度(m)", "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "totalLength", sortable: "custom" }, { default: u((a) => [m("span", null, d(e(me)(a.row.totalLength, "mm", "m", e(C).MES_ENCLOSURE_L__M) || "-"), 1)]), _: 1 })) : p("", true), e(s).visible("remark") ? (i(), l(o, { key: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120px", prop: "remark" }, { default: u((a) => [m("span", null, d(a.row.remark), 1)]), _: 1 })) : p("", true), e(s).visible("quantity") ? (i(), l(o, { key: "quantity", align: "center", label: "数量", "min-width": "70px", prop: "quantity", sortable: "custom" })) : p("", true), e(s).visible("taskQuantity") ? (i(), l(o, { key: "taskQuantity", align: "center", label: "任务数", "min-width": "70px", prop: "taskQuantity", sortable: "custom" })) : p("", true), e(s).visible("warehouseQuantity") ? (i(), l(o, { key: "warehouseQuantity", align: "center", label: "入库数量", "min-width": "80px", prop: "warehouseQuantity", sortable: "custom" })) : p("", true), e(s).visible("printQuantity") ? (i(), l(o, { key: "printQuantity", align: "center", label: "打印数量", prop: "printQuantity", sortable: "custom", width: "120px" }, { default: u(({ row: { sourceRow: a } }) => [c(R, { modelValue: a.printQuantity, "onUpdate:modelValue": (f) => a.printQuantity = f, min: 0, step: 1, "controls-position": "right", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : p("", true), k((i(), l(o, { align: "center", fixed: "right", label: "操作", width: "225px" }, { default: u(({ row: a }) => [k(c(g, { icon: "el-icon-printer", size: "default", type: "success", onClick: (f) => j(a) }, null, 8, ["onClick"]), [[y, e(b).print]]), k(c(g, { icon: "el-icon-view", size: "default", type: "primary", onClick: (f) => B(a) }, null, 8, ["onClick"]), [[y, e(b).preview]]), k((i(), l(g, { size: "default", type: "info", onClick: (f) => K(a) }, { default: u(() => n[2] || (n[2] = [J(" 打印记录 ")])), _: 2, __: [2] }, 1032, ["onClick"])), [[y, e(b).record]])]), _: 1 })), [[y, [...e(b).print, ...e(b).preview, ...e(b).record]]])]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[L, e(r).loading]]), c(e(de)), c(he, { visible: S.value, "onUpdate:visible": n[0] || (n[0] = (a) => S.value = a), "get-print-record": e(r).query.manufactureType === e(T).OUTSOURCE.V ? e(ne) : e(ie), "task-id": x.value }, null, 8, ["visible", "get-print-record", "task-id"]), c(e(_e), { visible: E.value, "onUpdate:visible": n[1] || (n[1] = (a) => E.value = a), "label-data": N.value, labelType: I.value, productType: e(w) }, null, 8, ["visible", "label-data", "labelType", "productType"])]);
  };
} };
export {
  je as default
};
