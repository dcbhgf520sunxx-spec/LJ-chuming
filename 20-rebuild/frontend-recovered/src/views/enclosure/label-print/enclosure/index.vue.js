import { ref as f } from "vue";
import { provide as k } from "vue";
import { computed as F } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as p } from "vue";
import { withDirectives as w } from "vue";
import { unref as e } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as u } from "vue";
import { createTextVNode as K } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElInputNumber as W } from "element-plus";
import { vLoading as Y } from "element-plus";
import { c as J, d as X } from "../../../../modules/enclosure-6f8adfb8.js";
import { x as Z, o as ee, a3 as te, mz as oe, br as ae, bs as V, D as C, kA as ne, c as le, P as ie, p as q, bd as re } from "../../../../shared/runtime.js";
import { d as se } from "../../../../modules/index-069ba252.js";
import { b as _ } from "../../../../modules/enclosure-365a2177.js";
import pe from "../components/label-print-header.vue.js";
import ue from "../components/task-printed-record-drawer.vue.js";
import ce from "../components/label-dlg.vue.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-3b2e6e51.js";
import "../../../../modules/label-6ff6c88d.js";
import "../../../../modules/index-b238c21c.js";
import "../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../modules/index-8356a01a.js";
const me = { class: "app-container" }, de = { class: "head-container" }, Me = { __name: "index", setup(be) {
  const Q = { add: false, edit: false, del: false, download: false }, v = f(), R = f(), { crud: m, columns: s, CRUD: D } = Z({ title: "产品标签-围护", permission: { ..._ }, optShow: { ...Q }, crudApi: { ...J }, requiredQuery: ["planId", "productionLineId"], queryOnPresenterCreated: false, invisibleColumns: ["remark"] }, R), { maxHeight: P } = ee({ paginate: true });
  D.HOOK.beforeToQuery = () => {
    m.query.lineId = m.query.productionLineId;
  };
  const E = f(false), S = f({}), U = f(), N = f(false), g = te.ENCLOSURE.V;
  k("permission", _), k("productType", g);
  const A = oe.ENCLOSURE.V;
  k("printType", A);
  const I = F(() => {
    var o, a;
    return (a = (o = v.value) == null ? void 0 : o.printConfig) == null ? void 0 : a.type;
  });
  async function $(o) {
    try {
      await v.value.print([o]);
    } catch (a) {
      console.log("打印标签失败", a);
    }
  }
  function H(o) {
    S.value = M(o), E.value = true;
  }
  function z(o) {
    U.value = o.taskId, N.value = true;
  }
  function M(o) {
    var t, b;
    const { printConfig: a, spliceQrCodeUrl: n, QR_SCAN_PATH: T, requestUrl: y, companyName: x } = v.value, h = { projectName: (t = o.project) == null ? void 0 : t.shortName, printTime: o.printTime ? q(o.printTime, "{y}/{m}/{d}") : q((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), name: o.name, serialNumber: o.serialNumber, color: o.color, plate: o.plate, thickness: o.thickness && ((b = o.thickness) == null ? void 0 : b.toFixed(C.MES_ENCLOSURE_T__MM)), length: o.length, quantity: o.quantity, specification: o.specification, drawingNumber: o.drawingNumber }, L = y;
    return { productType: g, labelType: I.value, component: h, printConfig: a, manufacturerName: a.manufacturerName || x, qrCode: n(`${L}${T.ENCLOSURE_TASK}`, { id: o.id, ftype: re.MEW_PRODUCTION, factoryId: o.factoryId, taskId: o.taskId, type: g, sa: Number(a.showArea), sm: Number(a.showMonomer) }) };
  }
  return k("headerObj", { getLabelInfo: M, printLabelFunc: se }), (o, a) => {
    const n = G, T = W, y = O("common-button"), x = O("common-table"), h = j("permission"), L = Y;
    return l(), B("div", me, [c("div", de, [p(pe, { ref_key: "headRef", ref: v }, null, 512)]), w((l(), i(x, { ref_key: "tableRef", ref: R, data: e(m).data, "empty-text": e(m).emptyText, "max-height": e(P), "show-empty-symbol": false, style: { width: "100%" }, "row-key": "id", onSortChange: e(m).handleSortChange, onSelectionChange: e(m).selectionChangeHandler }, { default: r(() => [p(n, { type: "selection", width: "55", align: "center" }), p(n, { label: "序号", type: "index", align: "center", width: "60" }), e(s).visible("name") ? (l(), i(n, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", "min-width": "120px" }, { default: r((t) => [p(e(ae), { show: t.row.boolPrinted, name: "已打印", color: "#e64242", offset: 15 }, null, 8, ["show"]), c("span", null, d(t.row.name), 1)]), _: 1 })) : u("", true), e(s).visible("serialNumber") ? (l(), i(n, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" }, { default: r((t) => [c("span", null, d(t.row.serialNumber), 1)]), _: 1 })) : u("", true), e(s).visible("color") ? (l(), i(n, { key: "color", prop: "color", sortable: "custom", "show-overflow-tooltip": true, label: "颜色", "min-width": "100px" }, { default: r((t) => [c("span", null, d(t.row.color || "-"), 1)]), _: 1 })) : u("", true), e(s).visible("length") ? (l(), i(n, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: "单长(mm)", align: "center", "min-width": "80px" }, { default: r((t) => [c("span", null, d(e(V)(t.row.length, e(C).MES_ENCLOSURE_L__MM) || "-"), 1)]), _: 1 })) : u("", true), e(s).visible("thickness") ? (l(), i(n, { key: "thickness", prop: "thickness", sortable: "custom", "show-overflow-tooltip": true, label: "板厚(mm)", align: "center", "min-width": "80px" }, { default: r((t) => [c("span", null, d(e(V)(t.row.thickness, e(C).MES_ENCLOSURE_T__MM) || "-"), 1)]), _: 1 })) : u("", true), e(s).visible("plate") && e(m).query.category !== e(ne).FOLDING_PIECE.V ? (l(), i(n, { key: "plate", prop: "plate", sortable: "custom", "show-overflow-tooltip": true, label: "板型", align: "center", "min-width": "80px" }, { default: r((t) => [c("span", null, d(t.row.plate || "-"), 1)]), _: 1 })) : u("", true), e(s).visible("totalLength") ? (l(), i(n, { key: "totalLength", prop: "totalLength", sortable: "custom", "show-overflow-tooltip": true, label: "总长度(m)", align: "center", "min-width": "80px" }, { default: r((t) => [c("span", null, d(e(le)(t.row.totalLength, "mm", "m", e(C).MES_ENCLOSURE_L__M) || "-"), 1)]), _: 1 })) : u("", true), e(s).visible("remark") ? (l(), i(n, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120px" }, { default: r((t) => [c("span", null, d(t.row.remark), 1)]), _: 1 })) : u("", true), e(s).visible("quantity") ? (l(), i(n, { key: "quantity", prop: "quantity", sortable: "custom", label: "数量", align: "center", "min-width": "70px" })) : u("", true), e(s).visible("taskQuantity") ? (l(), i(n, { key: "taskQuantity", prop: "taskQuantity", sortable: "custom", label: "任务数", align: "center", "min-width": "70px" })) : u("", true), e(s).visible("printQuantity") ? (l(), i(n, { key: "printQuantity", prop: "printQuantity", sortable: "custom", label: "打印数量", align: "center", width: "120px" }, { default: r(({ row: { sourceRow: t } }) => [p(T, { modelValue: t.printQuantity, "onUpdate:modelValue": (b) => t.printQuantity = b, step: 1, min: 0, size: "default", style: { width: "100%" }, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : u("", true), p(n, { label: "操作", width: "225px", align: "center", fixed: "right" }, { default: r(({ row: t }) => [w(p(y, { icon: "el-icon-printer", type: "success", size: "default", onClick: (b) => $(t) }, null, 8, ["onClick"]), [[h, e(_).print]]), w(p(y, { icon: "el-icon-view", type: "primary", size: "default", onClick: (b) => H(t) }, null, 8, ["onClick"]), [[h, e(_).preview]]), w((l(), i(y, { type: "info", size: "default", onClick: (b) => z(t) }, { default: r(() => a[2] || (a[2] = [K("打印记录")])), _: 2, __: [2] }, 1032, ["onClick"])), [[h, e(_).record]])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[L, e(m).loading]]), p(e(ie)), p(ue, { visible: N.value, "onUpdate:visible": a[0] || (a[0] = (t) => N.value = t), "task-id": U.value, getEnclosureRecord: e(X) }, null, 8, ["visible", "task-id", "getEnclosureRecord"]), p(e(ce), { visible: E.value, "onUpdate:visible": a[1] || (a[1] = (t) => E.value = t), "label-data": S.value, productType: e(g), labelType: I.value }, null, 8, ["visible", "label-data", "productType", "labelType"])]);
  };
} };
export {
  Me as default
};
