import { ref as v } from "vue";
import { provide as _ } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as X } from "vue";
import { createElementVNode as R } from "vue";
import { createVNode as p } from "vue";
import { withDirectives as C } from "vue";
import { unref as e } from "vue";
import { createBlock as l } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as m } from "vue";
import { toDisplayString as S } from "vue";
import { createTextVNode as G } from "vue";
import { ElTableColumn as J } from "element-plus";
import { ElInputNumber as K } from "element-plus";
import { vLoading as Z } from "element-plus";
import { l as w, x as ee, nO as c, o as te, a3 as ie, bh as ae, m4 as g, P as ne, p as D, ky as re, bd as oe } from "../../../../shared/runtime.js";
import { f as le } from "../../../../modules/index-069ba252.js";
import se from "../components/label-print-header.vue.js";
import ue from "../components/label-dlg.vue.js";
import pe from "../components/task-printed-record-drawer.vue.js";
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
function me(o) {
  return o != null && o.manufactureType ? w({ module: "mes", url: "subscribe/print/auxiliary-material", method: "get", params: { ...o, manufactureType: void 0 } }) : w({ module: "mes", url: "print/auxiliary-material", method: "get", params: { ...o, manufactureType: void 0 } });
}
function j({ id: o, quantity: T, startTime: d, endTime: y, numberList: n }) {
  return w({ url: "/api/mes/building/subscribe/print/auxiliary/print", method: "post", data: { materialId: o, quantity: T, startTime: d, endTime: y, numberList: n } });
}
function B({ id: o, quantity: T, startTime: d, endTime: y, numberList: n }) {
  return w({ url: "/api/mes/building/print/record/material", method: "post", data: { materialId: o, quantity: T, startTime: d, endTime: y, numberList: n } });
}
function ce(o) {
  return w({ url: `/api/mes/building/print/record/material/${o}`, method: "get" });
}
function de(o) {
  return w({ url: `/api/mes/building/subscribe/print/record/auxiliary/${o}`, method: "get" });
}
const be = { get: me }, fe = { class: "app-container" }, ye = { class: "head-container" }, Me = { __name: "index", setup(o) {
  const T = { add: false, edit: false, del: false, download: false }, d = v(), y = v(), { crud: n, columns: s } = ee({ title: "产品标签-配套件", permission: { ...c }, optShow: { ...T }, crudApi: { ...be }, queryOnPresenterCreated: false }, y), { maxHeight: H } = te({ paginate: true }), I = v(false), q = v({}), P = v(), V = v(false), U = ie.AUXILIARY_MATERIAL.V;
  _("productType", U), _("printType", ""), _("taskPrintAdd", B), _("taskSubscribePrintAdd", j);
  const L = ae.COMMON.V;
  async function z(t) {
    try {
      await d.value.print([t], "id", n.query.manufactureType === g.OUTSOURCE.V ? j : B);
    } catch (u) {
      console.log("打印标签失败", u);
    }
  }
  function Y(t) {
    console.log(t, "row"), q.value = M(t), I.value = true;
  }
  function F(t) {
    P.value = t.id, V.value = true;
  }
  function M(t) {
    var i, b, Q, $;
    const { printConfig: u, spliceQrCodeUrl: a, QR_SCAN_PATH: N, requestUrl: A, companyName: k } = d.value, O = { projectName: (i = t.project) == null ? void 0 : i.name, projectSN: (b = t.project) == null ? void 0 : b.serialNumber, printTime: t.printTime ? D(t.printTime, "{y}/{m}/{d}") : D((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), monomerName: (Q = t.monomer) == null ? void 0 : Q.name, areaName: ($ = t.area) == null ? void 0 : $.name, name: t.name, unit: t.measureUnit, useProperty: re.VL[t.useProperty], quantity: t.quantity, specification: t.specification }, h = A, x = { id: t.productId, ftype: oe.MEW_PRODUCTION, taskId: t.taskId, whId: t == null ? void 0 : t.warehouseRecordId, type: U };
    return t.taskId && (x.taskId = t.taskId), t.whId && (x.whId = t.whId), { productType: U, labelType: L, component: O, printConfig: u, manufacturerName: u.manufacturerName || k, qrCode: a(`${h}${N.AUXILIARY_MATERIAL}`, x) };
  }
  return _("permission", c), _("headerObj", { getLabelInfo: M, printLabelFunc: le }), (t, u) => {
    const a = J, N = E("table-cell-tag"), A = K, k = E("common-button"), O = E("common-table"), h = W("permission"), x = Z;
    return r(), X("div", fe, [R("div", ye, [p(se, { ref_key: "headRef", ref: d }, null, 512)]), C((r(), l(O, { ref_key: "tableRef", ref: y, data: e(n).data, "empty-text": e(n).emptyText, "max-height": e(H), style: { width: "100%" }, "row-key": "taskId", onSortChange: e(n).handleSortChange, onSelectionChange: e(n).selectionChangeHandler }, { default: f(() => [p(a, { type: "selection", width: "55", align: "center" }), p(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(s).visible("userName") && e(n).query.manufactureType === e(g).OUTSOURCE.V ? (r(), l(a, { key: "userName", "show-overflow-tooltip": true, label: "创建人", "min-width": "140px", prop: "userName", sortable: "custom" })) : m("", true), e(s).visible("serialNumber") && e(n).query.manufactureType === e(g).OUTSOURCE.V ? (r(), l(a, { key: "serialNumber", "show-overflow-tooltip": true, label: "物料编号", "min-width": "100px", prop: "serialNumber", sortable: "custom" }, { default: f((i) => [p(N, { offset: 15, show: !!i.row.printedQuantity, color: "#e64242", name: "已打印" }, null, 8, ["show"]), R("span", null, S(i.row.serialNumber), 1)]), _: 1 })) : m("", true), e(s).visible("classifyName") && e(n).query.manufactureType === e(g).OUTSOURCE.V ? (r(), l(a, { key: "classifyName", "show-overflow-tooltip": true, align: "center", label: "物料种类", "min-width": "80px", prop: "classifyName", sortable: "custom" })) : m("", true), e(s).visible("name") && e(n).query.manufactureType === e(g).HOMEMADE.V ? (r(), l(a, { key: "name", "show-overflow-tooltip": true, align: "center", label: "名称", "min-width": "100px", prop: "name", sortable: "custom" }, { default: f((i) => [p(N, { offset: 15, show: !!i.row.printedQuantity, color: "#e64242", name: "已打印" }, null, 8, ["show"]), R("span", null, S(i.row.name), 1)]), _: 1 })) : m("", true), e(s).visible("specification") ? (r(), l(a, { key: "specification", "show-overflow-tooltip": true, align: "center", label: "规格", "min-width": "80px", prop: "specification", sortable: "custom" })) : m("", true), e(s).visible("measureUnit") ? (r(), l(a, { key: "measureUnit", "show-overflow-tooltip": true, align: "center", label: "计量单位", "min-width": "70px", prop: "measureUnit", sortable: "custom" })) : m("", true), e(s).visible("quantity") ? (r(), l(a, { key: "quantity", align: "center", label: "数量", "min-width": "80px", prop: "quantity", sortable: "custom" })) : m("", true), e(s).visible("accountingUnit") ? (r(), l(a, { key: "accountingUnit", "show-overflow-tooltip": true, label: "核算单位", "min-width": "70px", prop: "accountingUnit" })) : m("", true), e(s).visible("mete") ? (r(), l(a, { key: "mete", align: "center", label: "核算量", "min-width": "80px", prop: "mete", sortable: "custom" })) : m("", true), e(s).visible("remark") ? (r(), l(a, { key: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120px", prop: "remark" }, { default: f((i) => [R("span", null, S(i.row.remark), 1)]), _: 1 })) : m("", true), e(s).visible("printQuantity") ? (r(), l(a, { key: "printQuantity", prop: "printQuantity", sortable: "custom", label: "打印数量", align: "center", width: "120px" }, { default: f(({ row: { sourceRow: i } }) => [p(A, { modelValue: i.printQuantity, "onUpdate:modelValue": (b) => i.printQuantity = b, step: 1, min: 0, size: "default", style: { width: "100%" }, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : m("", true), C((r(), l(a, { label: "操作", width: "225px", align: "center", fixed: "right" }, { default: f(({ row: { sourceRow: i } }) => [C(p(k, { icon: "el-icon-printer", type: "success", size: "default", onClick: (b) => z(i) }, null, 8, ["onClick"]), [[h, e(c).print]]), C(p(k, { icon: "el-icon-view", type: "primary", size: "default", onClick: (b) => Y(i) }, null, 8, ["onClick"]), [[h, e(c).preview]]), C((r(), l(k, { type: "info", size: "default", onClick: (b) => F(i) }, { default: f(() => u[2] || (u[2] = [G("打印记录")])), _: 2, __: [2] }, 1032, ["onClick"])), [[h, e(c).record]])]), _: 1 })), [[h, [...e(c).print, ...e(c).preview, ...e(c).record]]])]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[x, e(n).loading]]), p(e(ne)), p(pe, { visible: V.value, "onUpdate:visible": u[0] || (u[0] = (i) => V.value = i), "task-id": P.value, getPrintRecord: e(n).query.manufactureType === e(g).OUTSOURCE.V ? e(de) : e(ce) }, null, 8, ["visible", "task-id", "getPrintRecord"]), p(e(ue), { visible: I.value, "onUpdate:visible": u[1] || (u[1] = (i) => I.value = i), "label-data": q.value, productType: e(U), labelType: e(L) }, null, 8, ["visible", "label-data", "productType", "labelType"])]);
  };
} };
export {
  Me as default
};
