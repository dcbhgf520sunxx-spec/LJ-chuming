import { ref as c } from "vue";
import { provide as M } from "vue";
import { computed as J } from "vue";
import { watch as X } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as Z } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as m } from "vue";
import { withDirectives as ee } from "vue";
import { unref as a } from "vue";
import { createBlock as r } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as u } from "vue";
import { createTextVNode as g } from "vue";
import { createSlots as te } from "vue";
import { ElMessage as ae } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElInputNumber as oe } from "element-plus";
import { vLoading as ie } from "element-plus";
import { l as ne, x as re, nQ as se, o as ue, a3 as U, mz as me, p as Q, bo as pe, D as f, bd as de, br as ce, bs as _, P as be } from "../../../../shared/runtime.js";
import { e as fe } from "../../../../modules/index-069ba252.js";
import ge from "../components/label-print-header.vue.js";
import he from "../components/label-dlg.vue.js";
import { o as F } from "../../../../modules/one-code-number-list-af2f89eb.js";
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
function ve(I) {
  return ne({ module: "mes", url: "print/part", method: "get", params: I });
}
const ye = { get: ve }, _e = { class: "app-container" }, we = { class: "head-container" }, Fe = { __name: "index", setup(I) {
  const B = { add: false, edit: false, del: false, download: false }, T = c(), L = c(), { crud: w, columns: s } = re({ title: "产品标签-直发件", permission: { ...se }, optShow: { ...B }, crudApi: { ...ye }, requiredQuery: ["areaId"], queryOnPresenterCreated: false, invisibleColumns: ["totalNetWeight", "totalGrossWeight", "drawingNumber", "surfaceArea", "remark", "askCompleteTime"] }, L), { maxHeight: K } = ue({ paginate: true }), k = c(false), x = c({}), A = U.MACHINE_PART.V | U.ASSEMBLE.V;
  M("productType", A);
  const $ = me.ARTIFACT.V;
  M("printType", $);
  const q = J(() => {
    var t, l;
    return (l = (t = T.value) == null ? void 0 : t.printConfig) == null ? void 0 : l.type;
  }), D = c(), N = c(false), G = c(), b = c([]), h = c([]), v = c();
  function H(t, l) {
    return !t.boolOneCode;
  }
  function j(t) {
    t.boolOneCode ? (b.value = t.numberStatusDTOS, G.value = { row: t }, h.value = [], N.value = true) : P(t);
  }
  async function z() {
    var t;
    if (!((t = h.value) != null && t.length)) {
      ae.warning("请选择需要打印的一物一码编号");
      return;
    }
    try {
      const { row: l } = G.value;
      l.numberList = h.value, l.printQuantity = h.value.length, await P(l);
    } catch (l) {
      console.log("一物一码打印标签失败", l);
    } finally {
      N.value = false;
    }
  }
  async function P(t) {
    try {
      await T.value.print([t]);
    } catch (l) {
      console.log("打印标签失败", l);
    }
  }
  X(() => v.value, () => {
    k.value && (x.value = W(D.value, v.value));
  });
  function Y(t) {
    D.value = t, t.boolOneCode ? (b.value = t.numberStatusDTOS, v.value = b.value.length ? b.value[0].number : null, x.value = W(t, v.value)) : (b.value = [], x.value = W(t)), k.value = true;
  }
  function W(t, l) {
    const { printConfig: o, spliceQrCodeUrl: V, QR_SCAN_PATH: C, requestUrl: O, companyName: S } = T.value, R = { projectName: t.project.shortName, printTime: t.printTime ? Q(t.printTime, "{y}/{m}/{d}") : Q((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), monomerName: t.monomer.name, areaName: t.area.name, name: t.name, serialNumber: t.serialNumber, oneCode: t.boolOneCode ? l ? `${l}/${b.value.length}` : "-" : "", quantity: t.quantity, specification: t.specification, drawingNumber: t.drawingNumber, weight: o.weight === pe.NET.V ? t.netWeight.toFixed(f.COM_WT__KG) : t.grossWeight.toFixed(f.COM_WT__KG), length: t.length, areaBatch: t.areaBatch }, e = O, y = { id: t.id, ftype: de.MEW_PRODUCTION, factoryId: t.factoryId, taskId: t.taskId, type: t.productType, wt: o.weight, sa: Number(o.showArea), sm: Number(o.showMonomer), wid: t.workshopId };
    return t.boolOneCode && (y.num = l), { productType: A, labelType: q.value, component: R, printConfig: o, manufacturerName: o.manufacturerName || S, qrCode: V(`${e}${C.ARTIFACT_TASK}`, y) };
  }
  return M("headerObj", { getLabelInfo: W, printLabelFunc: fe }), (t, l) => {
    const o = le, V = oe, C = E("common-button"), O = E("common-table"), S = E("common-dialog"), R = ie;
    return n(), Z("div", _e, [d("div", we, [m(ge, { ref_key: "headRef", ref: T }, null, 512)]), ee((n(), r(O, { ref_key: "tableRef", ref: L, data: a(w).data, "empty-text": a(w).emptyText, "max-height": a(K), style: { width: "100%" }, onSortChange: a(w).handleSortChange, onSelectionChange: a(w).selectionChangeHandler }, { default: i(() => [m(o, { type: "selection", width: "55", align: "center", selectable: H }), m(o, { label: "序号", type: "index", align: "center", width: "60" }), a(s).visible("serialNumber") ? (n(), r(o, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" }, { default: i((e) => [m(a(ce), { show: !!e.row.printedQuantity, name: "已打印", color: "#e64242", offset: 15 }, null, 8, ["show"]), d("span", null, p(e.row.serialNumber), 1)]), _: 1 })) : u("", true), a(s).visible("specification") ? (n(), r(o, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", "min-width": "140px" }, { default: i((e) => [d("span", null, p(e.row.specification), 1)]), _: 1 })) : u("", true), a(s).visible("length") ? (n(), r(o, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "center", "min-width": "80px" }, { default: i((e) => [g(p(a(_)(e.row.length, a(f).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : u("", true), a(s).visible("material") ? (n(), r(o, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: i((e) => [d("span", null, p(e.row.material), 1)]), _: 1 })) : u("", true), a(s).visible("netWeight") ? (n(), r(o, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "center", "min-width": "80px" }, { default: i((e) => [g(p(a(_)(e.row.netWeight, a(f).COM_WT__KG)), 1)]), _: 1 })) : u("", true), a(s).visible("grossWeight") ? (n(), r(o, { key: "grossWeight", prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "center", "min-width": "80px" }, { default: i((e) => [g(p(a(_)(e.row.grossWeight, a(f).COM_WT__KG)), 1)]), _: 1 })) : u("", true), a(s).visible("totalNetWeight") ? (n(), r(o, { key: "totalNetWeight", prop: "totalNetWeight", sortable: "custom", "show-overflow-tooltip": true, label: `总净重
(kg)`, align: "center", "min-width": "80px" }, { default: i((e) => [g(p(a(_)(e.row.totalNetWeight, a(f).COM_WT__KG)), 1)]), _: 1 })) : u("", true), a(s).visible("totalGrossWeight") ? (n(), r(o, { key: "totalGrossWeight", prop: "totalGrossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `总毛重
(kg)`, align: "center", "min-width": "80px" }, { default: i((e) => [g(p(a(_)(e.row.totalGrossWeight, a(f).COM_WT__KG)), 1)]), _: 1 })) : u("", true), a(s).visible("drawingNumber") ? (n(), r(o, { key: "drawingNumber", prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "140px" }, { default: i((e) => [d("span", null, p(e.row.drawingNumber), 1)]), _: 1 })) : u("", true), a(s).visible("surfaceArea") ? (n(), r(o, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", label: `面积
(㎡)`, align: "left", "min-width": "80px" }, { default: i((e) => [g(p(a(_)(e.row.surfaceArea, a(f).COM_AREA__M2)), 1)]), _: 1 })) : u("", true), a(s).visible("remark") ? (n(), r(o, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120px" }, { default: i((e) => [d("span", null, p(e.row.remark), 1)]), _: 1 })) : u("", true), a(s).visible("quantity") ? (n(), r(o, { key: "quantity", prop: "quantity", sortable: "custom", label: "清单数量", align: "center", "min-width": "80px" })) : u("", true), a(s).visible("taskQuantity") ? (n(), r(o, { key: "taskQuantity", prop: "taskQuantity", sortable: "custom", label: "任务数量", align: "center", "min-width": "80px" })) : u("", true), a(s).visible("askCompleteTime") ? (n(), r(o, { key: "askCompleteTime", prop: "askCompleteTime", sortable: "custom", label: "要求完成时间", align: "center", width: "115px" }, { default: i(({ row: { sourceRow: e } }) => [d("span", null, p(a(Q)(e.askCompleteTime, "{y}-{m}-{d}")), 1)]), _: 1 })) : u("", true), a(s).visible("printQuantity") ? (n(), r(o, { key: "printQuantity", prop: "printQuantity", sortable: "custom", label: "打印数量", align: "center", width: "120px" }, { default: i(({ row: { sourceRow: e } }) => [m(V, { modelValue: e.printQuantity, "onUpdate:modelValue": (y) => e.printQuantity = y, step: 1, min: 0, size: "default", disabled: e.boolOneCode, style: { width: "100%" }, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 })) : u("", true), m(o, { label: "操作", width: "225px", align: "center", fixed: "right" }, { default: i(({ row: { sourceRow: e } }) => [m(C, { icon: "el-icon-printer", type: "success", size: "default", onClick: (y) => j(e) }, null, 8, ["onClick"]), m(C, { icon: "el-icon-view", type: "primary", size: "default", onClick: (y) => Y(e) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[R, a(w).loading]]), m(a(be)), m(a(he), { visible: k.value, "onUpdate:visible": l[1] || (l[1] = (e) => k.value = e), "label-data": x.value, productType: A, labelType: q.value }, te({ _: 2 }, [b.value.length ? { name: "oneCode", fn: i(() => [m(a(F), { style: { "margin-bottom": "15px" }, modelValue: v.value, "onUpdate:modelValue": l[0] || (l[0] = (e) => v.value = e), list: b.value, tagWidth: 100, multiple: false, "max-height": 80 }, { suffix: i(({ data: e }) => [l[4] || (l[4] = d("span", { style: { "margin-left": "5px", "margin-right": "5px" } }, " | ", -1)), d("span", null, p(e.name), 1)]), _: 1 }, 8, ["modelValue", "list"])]), key: "0" } : void 0]), 1032, ["visible", "label-data", "labelType"]), m(S, { title: "选择一物一码编号", modelValue: N.value, "onUpdate:modelValue": l[3] || (l[3] = (e) => N.value = e), center: false, "close-on-click-modal": false, width: "450px" }, { titleRight: i(() => [m(C, { type: "primary", size: "default", onClick: z }, { default: i(() => l[5] || (l[5] = [g("确认")])), _: 1, __: [5] })]), default: i(() => [m(a(F), { modelValue: h.value, "onUpdate:modelValue": l[2] || (l[2] = (e) => h.value = e), list: b.value }, { suffix: i(({ data: e }) => [l[6] || (l[6] = d("span", { style: { "margin-left": "5px", "margin-right": "5px" } }, " | ", -1)), d("span", null, p(e.name), 1)]), _: 1 }, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"])]);
  };
} };
export {
  Fe as default
};
