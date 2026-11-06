import { ref as b } from "vue";
import { provide as R } from "vue";
import { computed as we } from "vue";
import { watch as _e } from "vue";
import { resolveComponent as H } from "vue";
import { resolveDirective as ke } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as Te } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as l } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as u } from "vue";
import { createTextVNode as y } from "vue";
import { createSlots as Ce } from "vue";
import { isRef as Ne } from "vue";
import { ElMessage as re } from "element-plus";
import { ElTableColumn as Oe } from "element-plus";
import { ElTooltip as xe } from "element-plus";
import { ElInputNumber as Ve } from "element-plus";
import { vLoading as We } from "element-plus";
import { t as ne, a as le, g as Ie, b as Ee } from "../../../../modules/print-record-2e0b6340.js";
import { c as Re, g as Se } from "../../../../modules/artifact-62fe68f7.js";
import { x as Ae, nK as k, o as Ue, a3 as F, mz as qe, p as B, bo as se, D as w, bd as Pe, br as ue, m4 as f, nL as $, bs as T, P as Me, ba as De } from "../../../../shared/runtime.js";
import { e as Le } from "../../../../modules/index-069ba252.js";
import Qe from "../components/label-print-header.vue.js";
import Ge from "../components/task-printed-record-drawer.vue.js";
import He from "../components/label-dlg.vue.js";
import { o as me } from "../../../../modules/one-code-number-list-af2f89eb.js";
import { u as Fe } from "../../../../modules/use-drawing-8a7ba23b.js";
import { b as Be } from "../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-3b2e6e51.js";
import "../../../../modules/label-6ff6c88d.js";
import "../../../../modules/base-6bc46ddf.js";
import "../../../../modules/use-label-print-e19db37a.js";
import "../../../../modules/index-b238c21c.js";
import "../components/has-task-productLine-select.vue.js";
import "../../../../modules/use-product-lines-79a95221.js";
import "../../../../modules/index-8356a01a.js";
import "../components/product-traceability-setting-drawer.vue.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const $e = { class: "app-container" }, je = { class: "head-container" }, ze = ["onDblclick"], Vt = { __name: "index", setup(Ke) {
  const pe = { add: false, edit: false, del: false, download: false }, C = b(), j = b(), { crud: s, columns: m } = Ae({ title: "产品标签-构件", permission: { ...k }, optShow: { ...pe }, crudApi: { ...Re }, queryOnPresenterCreated: false, invisibleColumns: ["totalNetWeight", "totalGrossWeight", "drawingNumber", "surfaceArea", "remark", "askCompleteTime"] }, j);
  s.page.size = 40;
  const { maxHeight: de } = Ue({ paginate: true }), { showDrawing: M, drawingRow: W, drawingPreview: ce } = Fe({ pidField: "id" }), A = b(false), _ = b({}), D = b(), L = b(false), I = F.ARTIFACT.V, z = F.MACHINE_PART.V | F.ASSEMBLE.V;
  R("productType", I);
  const fe = qe.ARTIFACT.V;
  R("printType", fe), R("taskPrintAdd", ne), R("taskSubscribePrintAdd", le);
  const K = we(() => {
    var t, i;
    return (i = (t = C.value) == null ? void 0 : t.printConfig) == null ? void 0 : i.type;
  }), U = b(), q = b(false), Y = b(), h = b([]), N = b([]), O = b();
  function be(t) {
    return De(t, { props: ["netWeight", "grossWeight", "drawingWeight", "quantity", "taskQuantity", "printQuantity"] });
  }
  function ge(t) {
    t.boolOneCode ? (h.value = t.numberStatusDTOS.map((i) => {
      var o;
      return i.isNotInStock = !i.status && ((o = C.value) == null ? void 0 : o.boolPrintWarehousing), i;
    }), Y.value = { row: t }, N.value = [], q.value = true) : J(t);
  }
  async function ye() {
    var t;
    if (!((t = N.value) != null && t.length)) {
      re.warning("请选择需要打印的一物一码编号");
      return;
    }
    try {
      const { row: i } = Y.value;
      i.numberList = N.value, i.printQuantity = N.value.length, await J(i);
    } catch (i) {
      console.log("一物一码打印标签失败", i);
    } finally {
      q.value = false;
    }
  }
  async function J(t) {
    var o;
    if ((o = C.value) != null && o.boolPrintWarehousing && t.warehouseQuantity < 1) return re.error("打印失败，所选产品未入库！");
    const i = t;
    s.query.manufactureType === f.OUTSOURCE.V && (i.quantity = t.warehouseQuantity);
    try {
      await C.value.print([i], s.query.manufactureType === f.OUTSOURCE.V ? "whId" : "taskId", s.query.manufactureType === f.OUTSOURCE.V ? le : ne);
    } catch (E) {
      console.log("打印标签失败", E);
    }
  }
  _e(() => O.value, () => {
    A.value && (_.value = P(U.value, O.value), console.log(_.value, "currentLabel"));
  });
  function he(t) {
    const i = t;
    U.value = i, s.query.manufactureType === f.OUTSOURCE.V && (i.quantity = t.warehouseQuantity), i.boolOneCode ? (h.value = i.numberStatusDTOS, O.value = h.value.length ? h.value[0].number : null, _.value = P(U.value, O.value)) : (h.value = [], _.value = P(U.value)), A.value = true;
  }
  function ve(t) {
    s.query.manufactureType === f.OUTSOURCE.V ? D.value = t.whId : D.value = t.taskId, L.value = true;
  }
  function P(t, i) {
    const { printConfig: o, spliceQrCodeUrl: E, QR_SCAN_PATH: X, requestUrl: x, companyName: Q } = C.value, G = { projectName: t.project.shortName, projectSerialNumber: t.project.serialNumber, printTime: t.printTime ? B(t.printTime, "{y}/{m}/{d}") : B((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), monomerName: t.monomer.name, areaName: t.area.name, name: t.name, serialNumber: t.serialNumber, productionLineName: t.productionLineName, oneCode: t.boolOneCode ? i ? `${i}/${t.quantity}` : "-" : "", quantity: t.quantity, specification: t.specification, drawingNumber: t.drawingNumber, weight: (o.weight === se.NET.V ? t.netWeight : o.weight === se.DRAWING_WEIGHT.V ? t.drawingWeight : t.grossWeight).toFixed(w.COM_WT__KG), length: t.length, areaBatch: t.areaBatch }, V = x, g = { id: t.id, ftype: Pe.MEW_PRODUCTION, factoryId: t.factoryId, taskId: t == null ? void 0 : t.taskId, whId: t == null ? void 0 : t.warehouseRecordId, type: I, wt: o.weight, sa: Number(o.showArea), sm: Number(o.showMonomer), lang: o.language };
    return t.taskId && (g.taskId = t.taskId), t.whId && (g.whId = t.whId), s.query.manufactureType === z && (g.type = z), g.taskId || delete g.taskId, g.whId || delete g.whId, t.boolOneCode && (g.num = i), { productType: I, labelType: K.value, component: G, printConfig: o, manufacturerName: o.manufacturerName || Q, qrCode: E(`${V}/trace`, g) };
  }
  return R("headerObj", { getLabelInfo: P, printLabelFunc: Le }), (t, i) => {
    var Z, ee, te, ae, ie, oe;
    const o = Oe, E = xe, X = Ve, x = H("common-button"), Q = H("common-table"), G = H("common-dialog"), V = ke("permission"), g = We;
    return n(), Te("div", $e, [c("div", je, [p(Qe, { ref_key: "headRef", ref: C, productionLineHasTaskApi: e(Se) }, null, 8, ["productionLineHasTaskApi"])]), S((n(), l(Q, { ref_key: "tableRef", ref: j, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(de), "row-key": "taskId", "show-summary": "", "summary-method": be, style: { width: "100%" }, onSortChange: e(s).handleSortChange, onSelectionChange: e(s).selectionChangeHandler }, { default: r(() => [p(o, { align: "center", type: "selection", width: "55" }), p(o, { align: "center", label: "序号", type: "index", width: "60" }), e(m).visible("name") ? (n(), l(o, { key: "name", "show-overflow-tooltip": true, align: "center", label: "名称", "min-width": "80px", prop: "name", sortable: "custom" }, { default: r((a) => {
      var v;
      return [p(e(ue), { show: e(s).query.manufactureType === e(f).HOMEMADE.V && a.row.taskPrintEnum !== e($).NOT_PRINTED.V, offset: 15, color: (v = e($).V[a.row.taskPrintEnum]) == null ? void 0 : v.COLOR, name: e($).VL[a.row.taskPrintEnum] }, null, 8, ["show", "color", "name"]), p(e(ue), { offset: 15, show: !!(a.row.printedQuantity && e(s).query.manufactureType !== e(f).HOMEMADE.V), color: "#e64242", name: "已打印" }, null, 8, ["show"]), c("span", null, d(a.row.name), 1)];
    }), _: 1 })) : u("", true), e(s).query.manufactureType === e(f).OUTSOURCE.V ? (n(), l(o, { key: 1, align: "center", label: "单体", "min-width": "150", prop: "monomer.name", "show-overflow-tooltip": "" })) : u("", true), e(s).query.manufactureType === e(f).OUTSOURCE.V ? (n(), l(o, { key: 2, align: "center", label: "区域", "min-width": "150", prop: "area.name", "show-overflow-tooltip": "" })) : u("", true), e(m).visible("serialNumber") ? (n(), l(o, { key: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "140px", prop: "serialNumber", sortable: "custom" }, { header: r(() => [p(E, { content: "双击编号可预览图纸", class: "item", effect: "light", placement: "top" }, { default: r(() => i[6] || (i[6] = [c("div", { style: { display: "inline-block" } }, [c("span", { style: { "margin-left": "10px" } }, "编号"), c("i", { class: "el-icon-info" })], -1)])), _: 1, __: [6] })]), default: r((a) => [c("span", { style: { cursor: "pointer" }, onDblclick: (v) => e(ce)(a.row) }, d(a.row.serialNumber), 41, ze)]), _: 1 })) : u("", true), e(m).visible("specification") ? (n(), l(o, { key: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "140px", prop: "specification", sortable: "custom" }, { default: r((a) => [c("span", null, d(a.row.specification), 1)]), _: 1 })) : u("", true), e(m).visible("length") ? (n(), l(o, { key: "length", label: `长度
(mm)`, "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "length", sortable: "custom" }, { default: r((a) => [y(d(e(T)(a.row.length, e(w).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : u("", true), e(m).visible("material") ? (n(), l(o, { key: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "80px", prop: "material", sortable: "custom" }, { default: r((a) => [c("span", null, d(a.row.material), 1)]), _: 1 })) : u("", true), e(m).visible("netWeight") ? (n(), l(o, { key: "netWeight", label: `单净重
(kg)`, "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "netWeight", sortable: "custom" }, { default: r((a) => [y(d(e(T)(a.row.netWeight, e(w).COM_WT__KG)), 1)]), _: 1 })) : u("", true), e(m).visible("grossWeight") ? (n(), l(o, { key: "grossWeight", label: `单毛重
(kg)`, "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "grossWeight", sortable: "custom" }, { default: r((a) => [y(d(e(T)(a.row.grossWeight, e(w).COM_WT__KG)), 1)]), _: 1 })) : u("", true), e(m).visible("drawingWeight") ? (n(), l(o, { key: "drawingWeight", label: `图纸单重
(kg)`, "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "drawingWeight", sortable: "custom" }, { default: r((a) => [y(d(e(T)(a.row.drawingWeight, e(w).COM_WT__KG)), 1)]), _: 1 })) : u("", true), e(m).visible("totalNetWeight") ? (n(), l(o, { key: "totalNetWeight", label: `总净重
(kg)`, "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "totalNetWeight", sortable: "custom" }, { default: r((a) => [y(d(e(T)(a.row.totalNetWeight, e(w).COM_WT__KG)), 1)]), _: 1 })) : u("", true), e(m).visible("totalGrossWeight") ? (n(), l(o, { key: "totalGrossWeight", label: `总毛重
(kg)`, "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "totalGrossWeight", sortable: "custom" }, { default: r((a) => [y(d(e(T)(a.row.totalGrossWeight, e(w).COM_WT__KG)), 1)]), _: 1 })) : u("", true), e(m).visible("drawingNumber") ? (n(), l(o, { key: "drawingNumber", "show-overflow-tooltip": true, label: "图号", "min-width": "140px", prop: "drawingNumber", sortable: "custom" }, { default: r((a) => [c("span", null, d(a.row.drawingNumber), 1)]), _: 1 })) : u("", true), e(m).visible("surfaceArea") ? (n(), l(o, { key: "surfaceArea", label: `面积
(㎡)`, align: "left", "min-width": "80px", prop: "surfaceArea", sortable: "custom" }, { default: r((a) => [y(d(e(T)(a.row.surfaceArea, e(w).COM_AREA__M2)), 1)]), _: 1 })) : u("", true), e(m).visible("remark") ? (n(), l(o, { key: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120px", prop: "remark" }, { default: r((a) => [c("span", null, d(a.row.remark), 1)]), _: 1 })) : u("", true), e(m).visible("quantity") && e(s).query.manufactureType === e(f).HOMEMADE.V ? (n(), l(o, { key: "quantity", align: "center", label: "清单数量", "min-width": "80px", prop: "quantity", sortable: "custom" })) : u("", true), e(m).visible("taskQuantity") && e(s).query.manufactureType === e(f).HOMEMADE.V ? (n(), l(o, { key: "taskQuantity", align: "center", label: "任务数量", "min-width": "80px", prop: "taskQuantity", sortable: "custom" })) : u("", true), e(m).visible("warehouseQuantity") ? (n(), l(o, { key: "warehouseQuantity", align: "center", label: "入库数量", "min-width": "85px", prop: "warehouseQuantity", sortable: "custom" })) : u("", true), e(m).visible("askCompleteTime") ? (n(), l(o, { key: "askCompleteTime", align: "center", label: "要求完成时间", prop: "askCompleteTime", sortable: "custom", width: "115px" }, { default: r(({ row: { sourceRow: a } }) => [c("span", null, d(e(B)(a.askCompleteTime, "{y}-{m}-{d}")), 1)]), _: 1 })) : u("", true), e(m).visible("printQuantity") ? (n(), l(o, { key: "printQuantity", align: "center", label: "打印数量", prop: "printQuantity", sortable: "custom", width: "120px" }, { default: r(({ row: { sourceRow: a } }) => [e(s).loading ? u("", true) : (n(), l(X, { key: 0, modelValue: a.printQuantity, "onUpdate:modelValue": (v) => a.printQuantity = v, disabled: a.boolOneCode, min: 0, step: 1, "controls-position": "right", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"]))]), _: 1 })) : u("", true), S((n(), l(o, { align: "center", fixed: "right", label: "操作", width: "225px" }, { default: r(({ row: { sourceRow: a } }) => [S(p(x, { icon: "el-icon-printer", size: "default", type: "success", onClick: (v) => ge(a) }, null, 8, ["onClick"]), [[V, e(k).print]]), S(p(x, { icon: "el-icon-view", size: "default", type: "primary", onClick: (v) => he(a) }, null, 8, ["onClick"]), [[V, e(k).preview]]), S((n(), l(x, { size: "default", type: "info", onClick: (v) => ve(a) }, { default: r(() => i[7] || (i[7] = [y("打印记录")])), _: 2, __: [7] }, 1032, ["onClick"])), [[V, e(k).record]])]), _: 1 })), [[V, [...e(k).print, ...e(k).preview, ...e(k).record]]])]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[g, e(s).loading]]), p(e(Me)), p(Ge, { visible: L.value, "onUpdate:visible": i[0] || (i[0] = (a) => L.value = a), getPrintRecord: e(s).query.manufactureType === e(f).OUTSOURCE.V ? e(Ie) : e(Ee), "task-id": D.value }, null, 8, ["visible", "getPrintRecord", "task-id"]), p(e(He), { visible: A.value, "onUpdate:visible": i[2] || (i[2] = (a) => A.value = a), "label-data": { ..._.value, quantityName: e(s).query.manufactureType === e(f).OUTSOURCE.V ? "入库数(件)" : "任务数(件)", printConfig: { ..._.value.printConfig, dateInProduced: e(s).query.manufactureType === e(f).OUTSOURCE.V ? false : (Z = _.value.printConfig) == null ? void 0 : Z.dateInProduced } }, labelType: K.value, productType: e(I) }, Ce({ _: 2 }, [h.value.length ? { name: "oneCode", fn: r(() => [p(e(me), { modelValue: O.value, "onUpdate:modelValue": i[1] || (i[1] = (a) => O.value = a), list: h.value, "max-height": 80, multiple: false, tagWidth: 100, style: { "margin-bottom": "15px" } }, { suffix: r(({ data: a }) => [i[8] || (i[8] = c("span", { style: { "margin-left": "5px", "margin-right": "5px" } }, " | ", -1)), c("span", null, d(a.name), 1)]), _: 1 }, 8, ["modelValue", "list"])]), key: "0" } : void 0]), 1032, ["visible", "label-data", "labelType", "productType"]), p(G, { modelValue: q.value, "onUpdate:modelValue": i[4] || (i[4] = (a) => q.value = a), center: false, "close-on-click-modal": false, title: "选择一物一码编号", width: "450px" }, { titleRight: r(() => [p(x, { size: "default", type: "primary", onClick: ye }, { default: r(() => i[9] || (i[9] = [y("确认")])), _: 1, __: [9] })]), default: r(() => [p(e(me), { modelValue: N.value, "onUpdate:modelValue": i[3] || (i[3] = (a) => N.value = a), list: h.value, boolPrintWarehousing: "", showPrintstatus: "" }, { suffix: r(({ data: a }) => [i[10] || (i[10] = c("span", { style: { "margin-left": "5px", "margin-right": "5px" } }, " | ", -1)), c("span", null, d(a.name), 1)]), _: 1 }, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"]), p(e(Be), { visible: e(M), "onUpdate:visible": i[5] || (i[5] = (a) => Ne(M) ? M.value = a : null), "area-id": e(s).query.areaId, "bool-bim": (ee = e(W)) == null ? void 0 : ee.boolBim, drawingSN: (te = e(W)) == null ? void 0 : te.drawingSN, "monomer-id": (ae = e(W)) == null ? void 0 : ae.monomerId, productId: (ie = e(W)) == null ? void 0 : ie.productId, productType: e(I), "serial-number": (oe = e(W)) == null ? void 0 : oe.serialNumber }, null, 8, ["visible", "area-id", "bool-bim", "drawingSN", "monomer-id", "productId", "productType", "serial-number"])]);
  };
} };
export {
  Vt as default
};
