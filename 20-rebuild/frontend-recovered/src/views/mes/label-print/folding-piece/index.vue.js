import { ref as f } from "vue";
import { provide as K } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as r } from "vue";
import { withCtx as l } from "vue";
import { unref as e } from "vue";
import { withKeys as S } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as s } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as m } from "vue";
import { createTextVNode as P } from "vue";
import { ElInput as $ } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElInputNumber as H } from "element-plus";
import { vLoading as W } from "element-plus";
import { c as B } from "../../../../modules/enclosure-6f8adfb8.js";
import { x as j, o as G, kA as J, br as X, bs as _, D as h, P as Y, bo as Z, c as ee, a3 as te } from "../../../../shared/runtime.js";
import { e as oe } from "../../../../modules/index-069ba252.js";
import ae from "../components/label-print-header.vue.js";
import le from "../components/task-printed-record-drawer.vue.js";
import ne from "./module/label-dlg.vue.js";
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
const ie = { class: "app-container" }, re = { class: "head-container" }, Se = { __name: "index", setup(se) {
  const V = { get: [""], edit: [""], add: [""], del: [""] }, R = { add: false, edit: false, del: false, download: false }, g = f(), E = f(), { crud: p, columns: u, CRUD: I } = j({ title: "产品标签-折边件", permission: { ...V }, optShow: { ...R }, crudApi: { ...B }, requiredQuery: ["areaId", "productionLineId"], queryOnPresenterCreated: false, invisibleColumns: ["remark"] }, E), { maxHeight: U } = G({ paginate: true });
  I.HOOK.beforeToQuery = () => {
    p.query.category = J.FOLDING_PIECE.V;
  };
  const k = f(false), L = f({}), T = f(), C = f(false);
  async function q(o) {
    try {
      await g.value.print([o]);
    } catch (i) {
      console.log("打印标签失败", i);
    }
  }
  function O(o) {
    L.value = A(o), k.value = true;
  }
  function Q(o) {
    T.value = o.taskId, C.value = true;
  }
  function A(o) {
    console.log(g.value);
    const { getLine: i, printConfig: d, spliceQrCodeUrl: a, QR_SCAN_PATH: x, requestUrl: w } = g.value, N = { projectName: o.project.shortName, monomerName: d.showMonomer ? o.monomer.name : "", areaName: d.showArea ? o.area.name : "", name: o.name, serialNumber: o.serialNumber, quantity: o.quantity, specification: o.specification, drawingNumber: o.drawingNumber, weight: Z.NET.V ? o.netWeight.toFixed(h.COM_WT__KG) : o.grossWeight.toFixed(h.COM_WT__KG), length: ee(o.length, "mm", "m", h.MES_ARTIFACT_L__M) }, y = i(), t = w;
    return { component: N, productionLineName: d.showProductionLine ? `${y.factoryName}-${y.name}` : "", manufacturerName: d.manufacturerName, qrCode: a(`${t}/#${x.ARTIFACT_TASK}`, { id: o.id, factoryId: y.factoryId, taskId: o.taskId, type: te.ARTIFACT.V, wt: d.weight, mn: d.manufacturerName, sl: Number(d.showProductionLine), sa: Number(d.showArea), sm: Number(d.showMonomer) }) };
  }
  return K("headerObj", { getLabelInfo: A, printLabelFunc: oe }), (o, i) => {
    const d = $, a = z, x = H, w = M("common-button"), N = M("common-table"), y = W;
    return n(), D("div", ie, [c("div", re, [r(ae, { ref_key: "headRef", ref: g }, { customSearch: l(() => [r(d, { modelValue: e(p).query.name, "onUpdate:modelValue": i[0] || (i[0] = (t) => e(p).query.name = t), size: "default", placeholder: "输入名称搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: S(e(p).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(d, { modelValue: e(p).query.serialNumber, "onUpdate:modelValue": i[1] || (i[1] = (t) => e(p).query.serialNumber = t), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: S(e(p).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"])]), _: 1 }, 512)]), F((n(), s(N, { ref_key: "tableRef", ref: E, data: e(p).data, "empty-text": e(p).emptyText, "max-height": e(U), style: { width: "100%" }, "row-key": "taskId", onSortChange: e(p).handleSortChange, onSelectionChange: e(p).selectionChangeHandler }, { default: l(() => [r(a, { type: "selection", width: "55", align: "center" }), r(a, { label: "序号", type: "index", align: "center", width: "60" }), e(u).visible("name") ? (n(), s(a, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", "min-width": "120px" }, { default: l((t) => [r(e(X), { show: !!t.row.printedQuantity, name: "已打印", color: "#e64242", offset: 15 }, null, 8, ["show"]), c("span", null, b(t.row.name), 1)]), _: 1 })) : m("", true), e(u).visible("serialNumber") ? (n(), s(a, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" }, { default: l((t) => [c("span", null, b(t.row.serialNumber), 1)]), _: 1 })) : m("", true), e(u).visible("color") ? (n(), s(a, { key: "color", prop: "color", sortable: "custom", "show-overflow-tooltip": true, label: "颜色", "min-width": "100px" }, { default: l((t) => [c("span", null, b(t.row.color), 1)]), _: 1 })) : m("", true), e(u).visible("material") ? (n(), s(a, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "120px" }, { default: l((t) => [c("span", null, b(t.row.material), 1)]), _: 1 })) : m("", true), e(u).visible("length") ? (n(), s(a, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `单长
(mm)`, align: "center", "min-width": "80px" }, { default: l((t) => [c("span", null, b(e(_)(t.row.length, e(h).MES_ENCLOSURE_L__MM)), 1)]), _: 1 })) : m("", true), e(u).visible("thickness") ? (n(), s(a, { key: "thickness", prop: "thickness", sortable: "custom", "show-overflow-tooltip": true, label: `板厚
(mm)`, align: "center", "min-width": "80px" }, { default: l((t) => [c("span", null, b(e(_)(t.row.thickness, e(h).MES_ENCLOSURE_T__MM)), 1)]), _: 1 })) : m("", true), e(u).visible("width") ? (n(), s(a, { key: "width", prop: "width", sortable: "custom", "show-overflow-tooltip": true, label: `有效宽度
(mm)`, align: "center", "min-width": "80px" }, { default: l((t) => [c("span", null, b(e(_)(t.row.width, e(h).MES_ENCLOSURE_W__MM)), 1)]), _: 1 })) : m("", true), e(u).visible("totalArea") ? (n(), s(a, { key: "totalArea", prop: "totalArea", sortable: "custom", label: `总面积
(㎡)`, align: "left", "min-width": "80px" }, { default: l((t) => [c("span", null, b(e(_)(t.row.totalArea, e(h).COM_AREA__M2)), 1)]), _: 1 })) : m("", true), e(u).visible("totalLength") ? (n(), s(a, { key: "totalLength", prop: "totalLength", sortable: "custom", "show-overflow-tooltip": true, label: `总长度
(m)`, align: "center", "min-width": "80px" }, { default: l((t) => [c("span", null, b(e(_)(t.row.totalLength, e(h).MES_ENCLOSURE_L__M)), 1)]), _: 1 })) : m("", true), e(u).visible("weight") ? (n(), s(a, { key: "weight", prop: "weight", sortable: "custom", "show-overflow-tooltip": true, label: `重量
(kg)`, align: "center", "min-width": "80px" }, { default: l((t) => [c("span", null, b(e(_)(t.row.weight, e(h).COM_WT__KG)), 1)]), _: 1 })) : m("", true), e(u).visible("remark") ? (n(), s(a, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120px" }, { default: l((t) => [c("span", null, b(t.row.remark), 1)]), _: 1 })) : m("", true), e(u).visible("quantity") ? (n(), s(a, { key: "quantity", prop: "quantity", sortable: "custom", label: "数量", align: "center", "min-width": "70px" })) : m("", true), e(u).visible("printQuantity") ? (n(), s(a, { key: "printQuantity", prop: "printQuantity", sortable: "custom", label: "打印数量", align: "center", width: "120px" }, { default: l(({ row: { sourceRow: t } }) => [r(x, { modelValue: t.printQuantity, "onUpdate:modelValue": (v) => t.printQuantity = v, step: 1, min: 0, size: "default", style: { width: "100%" }, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : m("", true), r(a, { label: "操作", width: "225px", align: "center", fixed: "right" }, { default: l(({ row: { sourceRow: t } }) => [r(w, { icon: "el-icon-printer", type: "success", size: "default", onClick: (v) => q(t) }, null, 8, ["onClick"]), r(w, { icon: "el-icon-view", type: "primary", size: "default", onClick: (v) => O(t) }, null, 8, ["onClick"]), r(w, { type: "info", size: "default", onClick: (v) => Q(t) }, { default: l(() => i[4] || (i[4] = [P("打印记录")])), _: 2, __: [4] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[y, e(p).loading]]), r(e(Y)), r(le, { visible: C.value, "onUpdate:visible": i[2] || (i[2] = (t) => C.value = t), "task-id": T.value }, null, 8, ["visible", "task-id"]), r(e(ne), { visible: k.value, "onUpdate:visible": i[3] || (i[3] = (t) => k.value = t), "label-data": L.value }, null, 8, ["visible", "label-data"])]);
  };
} };
export {
  Se as default
};
