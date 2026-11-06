import { ref as d } from "vue";
import { provide as I } from "vue";
import { computed as oe } from "vue";
import { watch as le } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as ie } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as u } from "vue";
import { withDirectives as ne } from "vue";
import { unref as a } from "vue";
import { createBlock as r } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as m } from "vue";
import { createTextVNode as g } from "vue";
import { createSlots as re } from "vue";
import { ElMessage as se } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { ElInputNumber as me } from "element-plus";
import { vLoading as pe } from "element-plus";
import { a as de } from "../../../../modules/print-record-c36add77.js";
import { l as ce, x as be, o as fe, F as ge, bq as he, p as P, bo as ve, D as h, bd as ye, br as we, bs as k, P as _e } from "../../../../shared/runtime.js";
import { a as ke } from "../../../../modules/index-069ba252.js";
import { j as Ce } from "../../../../modules/bridge-86f96a4f.js";
import xe from "../components/label-print-header.vue.js";
import Te from "../components/task-printed-record-drawer.vue.js";
import Ne from "../components/label-dlg.vue.js";
import { o as K } from "../../../../modules/one-code-number-list-d40dfaf0.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-3b2e6e51.js";
import "../../../../modules/bridge-label-a62ef559.js";
import "../../../../modules/use-label-print-47f6f6b0.js";
import "../../../../modules/index-2d037787.js";
import "../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../modules/index-8356a01a.js";
import "../../../../modules/use-bridge-product-lines-0fd5db98.js";
function We(Q) {
  return ce({ module: "bridge", url: "print/box", method: "get", params: Q });
}
const Oe = { get: We }, Ve = { class: "app-container" }, Re = { class: "head-container" }, Je = { __name: "index", setup(Q) {
  const j = { add: false, edit: false, del: false, download: false }, C = d(), D = d(), { crud: x, columns: s } = be({ title: "产品标签-分段", permission: { ...Ce }, optShow: { ...j }, crudApi: { ...Oe }, requiredQuery: ["areaId", "productionLineId"], queryOnPresenterCreated: false, invisibleColumns: ["totalNetWeight", "totalGrossWeight", "drawingNumber", "surfaceArea", "remark", "askCompleteTime"] }, D), { maxHeight: z } = fe({ paginate: true }), T = d(false), N = d({}), E = d(), R = d(false), W = ge.BOX.V;
  I("productType", W);
  const H = he.BOX.V;
  I("printType", H);
  const G = oe(() => {
    var t, o;
    return (o = (t = C.value) == null ? void 0 : t.printConfig) == null ? void 0 : o.type;
  }), U = d(), O = d(false), q = d(), b = d([]), y = d([]), w = d();
  function X(t, o) {
    return !t.boolOneCode;
  }
  function Y(t) {
    t.boolOneCode ? (b.value = t.numberStatusDTOS, q.value = { row: t }, y.value = [], O.value = true) : B(t);
  }
  async function J() {
    var t;
    if (!((t = y.value) != null && t.length)) {
      se.warning("请选择需要打印的一物一码编号");
      return;
    }
    try {
      const { row: o } = q.value;
      o.numberList = y.value, o.printQuantity = y.value.length, await B(o);
    } catch (o) {
      console.log("一物一码打印标签失败", o);
    } finally {
      O.value = false;
    }
  }
  async function B(t) {
    try {
      await C.value.print([t]);
    } catch (o) {
      console.log("打印标签失败", o);
    }
  }
  le(() => w.value, () => {
    T.value && (N.value = V(U.value, w.value));
  });
  function Z(t) {
    U.value = t, t.boolOneCode ? (b.value = t.numberStatusDTOS, w.value = b.value.length ? b.value[0].number : null, N.value = V(t, w.value)) : (b.value = [], N.value = V(t)), T.value = true;
  }
  function ee(t) {
    E.value = t.taskId, R.value = true;
  }
  function V(t, o) {
    var $;
    ($ = C.value) == null || $.handleLinesLoaded();
    const { getLine: i, printConfig: f, spliceQrCodeUrl: _, QR_SCAN_PATH: S, requestUrl: L, companyName: A, company: e } = C.value, v = e.website && e.website.includes("://") ? e.website.split("://")[1] : e.website, te = { projectName: t.project.shortName, printTime: t.printTime ? P(t.printTime, "{y}/{m}/{d}") : P((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), monomerName: t.monomer.name, areaName: t.area.name, name: t.name, serialNumber: t.serialNumber, oneCode: t.boolOneCode ? o ? `${o}/${b.value.length}` : "-" : "", quantity: t.quantity, specification: t.specification, drawingNumber: t.drawingNumber, weight: f.weight === ve.NET.V ? t.netWeight.toFixed(h.COM_WT__KG) : t.grossWeight.toFixed(h.COM_WT__KG), width: t.width, length: t.length, thickness: t.thickness }, ae = L, F = { id: t.id, ftype: ye.BRIDGE_PRODUCTION, factoryId: t.factoryId, taskId: t.taskId, type: W, wt: f.weight, sa: Number(f.showArea), sm: Number(f.showMonomer) };
    return t.boolOneCode && (F.num = o), { productType: W, labelType: G.value, component: te, printConfig: f, productionLineName: i().name, logo: e.logo, manufacturerPhone: e.telephone, manufacturerURL: v ? v.split("/")[0] : "", manufacturerName: f.manufacturerName || A, qrCode: _(`${ae}${S.BRIDGE_BOX_TASK}`, F) };
  }
  return I("headerObj", { getLabelInfo: V, printLabelFunc: ke }), (t, o) => {
    const i = ue, f = me, _ = M("common-button"), S = M("common-table"), L = M("common-dialog"), A = pe;
    return n(), ie("div", Ve, [c("div", Re, [u(xe, { ref_key: "headRef", ref: C }, null, 512)]), ne((n(), r(S, { ref_key: "tableRef", ref: D, data: a(x).data, "empty-text": a(x).emptyText, "max-height": a(z), style: { width: "100%" }, "row-key": "id", onSortChange: a(x).handleSortChange, onSelectionChange: a(x).selectionChangeHandler }, { default: l(() => [u(i, { type: "selection", width: "55", align: "center", selectable: X }), u(i, { label: "序号", type: "index", align: "center", width: "60" }), a(s).visible("name") ? (n(), r(i, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", "min-width": "120px" }, { default: l((e) => [u(a(we), { show: !!e.row.printedQuantity, name: "已打印", color: "#e64242", offset: 15 }, null, 8, ["show"]), c("span", null, p(e.row.name), 1)]), _: 1 })) : m("", true), a(s).visible("serialNumber") ? (n(), r(i, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" }, { default: l((e) => [c("span", null, p(e.row.serialNumber), 1)]), _: 1 })) : m("", true), a(s).visible("specification") ? (n(), r(i, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", "min-width": "140px" }, { default: l((e) => [c("span", null, p(e.row.specification), 1)]), _: 1 })) : m("", true), a(s).visible("length") ? (n(), r(i, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "center", "min-width": "80px" }, { default: l((e) => [g(p(a(k)(e.row.length, a(h).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : m("", true), a(s).visible("material") ? (n(), r(i, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: l((e) => [c("span", null, p(e.row.material), 1)]), _: 1 })) : m("", true), a(s).visible("netWeight") ? (n(), r(i, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "center", "min-width": "80px" }, { default: l((e) => [g(p(a(k)(e.row.netWeight, a(h).COM_WT__KG)), 1)]), _: 1 })) : m("", true), a(s).visible("grossWeight") ? (n(), r(i, { key: "grossWeight", prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "center", "min-width": "80px" }, { default: l((e) => [g(p(a(k)(e.row.grossWeight, a(h).COM_WT__KG)), 1)]), _: 1 })) : m("", true), a(s).visible("totalNetWeight") ? (n(), r(i, { key: "totalNetWeight", prop: "totalNetWeight", sortable: "custom", "show-overflow-tooltip": true, label: `总净重
(kg)`, align: "center", "min-width": "80px" }, { default: l((e) => [g(p(a(k)(e.row.totalNetWeight, a(h).COM_WT__KG)), 1)]), _: 1 })) : m("", true), a(s).visible("totalGrossWeight") ? (n(), r(i, { key: "totalGrossWeight", prop: "totalGrossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `总毛重
(kg)`, align: "center", "min-width": "80px" }, { default: l((e) => [g(p(a(k)(e.row.totalGrossWeight, a(h).COM_WT__KG)), 1)]), _: 1 })) : m("", true), a(s).visible("drawingNumber") ? (n(), r(i, { key: "drawingNumber", prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "140px" }, { default: l((e) => [c("span", null, p(e.row.drawingNumber), 1)]), _: 1 })) : m("", true), a(s).visible("surfaceArea") ? (n(), r(i, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", label: `面积
(㎡)`, align: "left", "min-width": "80px" }, { default: l((e) => [g(p(a(k)(e.row.surfaceArea, a(h).COM_AREA__M2)), 1)]), _: 1 })) : m("", true), a(s).visible("remark") ? (n(), r(i, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120px" }, { default: l((e) => [c("span", null, p(e.row.remark), 1)]), _: 1 })) : m("", true), a(s).visible("quantity") ? (n(), r(i, { key: "quantity", prop: "quantity", sortable: "custom", label: "清单数量", align: "center", "min-width": "80px" })) : m("", true), a(s).visible("taskQuantity") ? (n(), r(i, { key: "taskQuantity", prop: "taskQuantity", sortable: "custom", label: "任务数量", align: "center", "min-width": "80px" })) : m("", true), a(s).visible("askCompleteTime") ? (n(), r(i, { key: "askCompleteTime", prop: "askCompleteTime", sortable: "custom", label: "要求完成时间", align: "center", width: "115px" }, { default: l(({ row: { sourceRow: e } }) => [c("span", null, p(a(P)(e.askCompleteTime, "{y}-{m}-{d}")), 1)]), _: 1 })) : m("", true), a(s).visible("printQuantity") ? (n(), r(i, { key: "printQuantity", prop: "printQuantity", sortable: "custom", label: "打印数量", align: "center", width: "120px" }, { default: l((e) => [u(f, { modelValue: e.row.printQuantity, "onUpdate:modelValue": (v) => e.row.printQuantity = v, step: 1, min: 0, size: "default", disabled: e.row.boolOneCode, style: { width: "100%" }, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 })) : m("", true), u(i, { label: "操作", width: "225px", align: "center", fixed: "right" }, { default: l((e) => [u(_, { icon: "el-icon-printer", type: "success", size: "default", onClick: (v) => Y(e.row) }, null, 8, ["onClick"]), u(_, { icon: "el-icon-view", type: "primary", size: "default", onClick: (v) => Z(e.row) }, null, 8, ["onClick"]), u(_, { type: "info", size: "default", onClick: (v) => ee(e.row) }, { default: l(() => o[5] || (o[5] = [g("打印记录")])), _: 2, __: [5] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[A, a(x).loading]]), u(a(_e)), u(Te, { visible: R.value, "onUpdate:visible": o[0] || (o[0] = (e) => R.value = e), "task-id": E.value, getPrintRecord: a(de) }, null, 8, ["visible", "task-id", "getPrintRecord"]), u(a(Ne), { visible: T.value, "onUpdate:visible": o[2] || (o[2] = (e) => T.value = e), "label-data": N.value, productType: a(W), labelType: G.value }, re({ _: 2 }, [b.value.length ? { name: "oneCode", fn: l(() => [u(a(K), { style: { "margin-bottom": "15px" }, modelValue: w.value, "onUpdate:modelValue": o[1] || (o[1] = (e) => w.value = e), list: b.value, tagWidth: 100, multiple: false, "max-height": 80 }, { suffix: l(({ data: e }) => [o[6] || (o[6] = c("span", { style: { "margin-left": "5px", "margin-right": "5px" } }, " | ", -1)), c("span", null, p(e.name), 1)]), _: 1 }, 8, ["modelValue", "list"])]), key: "0" } : void 0]), 1032, ["visible", "label-data", "productType", "labelType"]), u(L, { title: "选择一物一码编号", modelValue: O.value, "onUpdate:modelValue": o[4] || (o[4] = (e) => O.value = e), center: false, "close-on-click-modal": false, width: "450px" }, { titleRight: l(() => [u(_, { type: "primary", size: "default", onClick: J }, { default: l(() => o[7] || (o[7] = [g("确认")])), _: 1, __: [7] })]), default: l(() => [u(a(K), { modelValue: y.value, "onUpdate:modelValue": o[3] || (o[3] = (e) => y.value = e), list: b.value }, { suffix: l(({ data: e }) => [o[8] || (o[8] = c("span", { style: { "margin-left": "5px", "margin-right": "5px" } }, " | ", -1)), c("span", null, p(e.name), 1)]), _: 1 }, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"])]);
  };
} };
export {
  Je as default
};
