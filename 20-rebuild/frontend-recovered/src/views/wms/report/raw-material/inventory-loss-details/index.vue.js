import { ref as j } from "vue";
import { computed as T } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as b } from "vue";
import { withDirectives as w } from "vue";
import { unref as i } from "vue";
import { createBlock as s } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as l } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as m } from "vue";
import { ElTableColumn as M } from "element-plus";
import { vLoading as P } from "element-plus";
import { BO as k, b as A, j as U, am as h, i as r, hj as x, _ as D, jX as I, x as O, BP as Q, BQ as F, o as q, cO as H, jl as Y, ux as $, P as G, ba as K, jN as W, D as y } from "../../../../../shared/runtime.js";
import X from "./module/header.vue.js";
function z(e, a) {
  const c = [], p = [];
  return r(e.thickness) && p.push(e.thickness), r(e.width) && p.push(e.width), r(e.length) && p.push(e.length), r(p) && c.push(p.join("*")), a === x.LEFT_SPEC.V ? r(e.specification) && c.unshift(e.specification) : r(e.specification) && c.push(e.specification), c.join(" * ");
}
function J(e, a) {
  const c = [];
  return r(e.length) && c.push(e.length), a === x.LEFT_SPEC.V ? r(e.specification) && e.specificationLabels !== "无规格" && c.unshift(e.specification) : r(e.specification) && e.specificationLabels !== "无规格" && c.push(e.specification), c.join(" * ");
}
function Z(e, a) {
  const c = [], p = [];
  return r(e.thickness) && p.push(e.thickness), r(e.width) && p.push(e.width), r(e.length) && p.push(e.length), r(p) && c.push(p.join("*")), a === x.LEFT_SPEC.V ? r(e.specification) && e.specificationLabels !== "无规格" && c.unshift(e.specification) : r(e.specification) && e.specificationLabels !== "无规格" && c.push(e.specification), c.join(" * ");
}
function ee(e) {
  let a = k();
  switch (A(a) && (U.dispatch("wms/fetchWmsConfig"), a = k()), e.basicClass) {
    case h.STEEL_PLATE.V:
      return z(e, a);
    case h.SECTION_STEEL.V:
      return J(e, a);
    case h.STEEL_COIL.V:
      return Z(e, a);
    case h.MATERIAL.V:
      return S(e);
    case h.OTHER.V:
      return te(e);
    case h.GAS.V:
      return ie(e);
    default:
      return S(e);
  }
}
function S(e) {
  const a = [];
  return r(e.specification) && e.specificationLabels !== "无规格" && a.push(e.specification), a.join(" * ");
}
function te(e) {
  const a = [];
  return r(e.specification) && e.specificationLabels !== "无规格" && a.push(e.specification), a.join(" * ");
}
function ie(e) {
  return e.specification;
}
const ae = { class: "app-container" }, ne = { class: "color-red" }, se = { class: "color-red" }, ce = { class: "color-red" }, oe = { class: "color-red" }, le = { class: "color-red" }, re = { __name: "index", setup(e) {
  const a = { add: false, edit: false, del: false, download: false }, c = j(), p = T(() => [...I, ["deficitProject", ["parse-project", { onlyShortName: true }]], ["createTime", ["parse-time"]]]), { CRUD: V, crud: E, columns: o } = O({ title: "盘亏明细", sort: ["id.desc"], invisibleColumns: ["remark"], permission: { ...Q }, optShow: { ...a }, crudApi: { get: F } }, c), { maxHeight: N } = q({ paginate: true });
  function v(g) {
    return K(g, { props: ["quantity", ["mete", W.weight.precision], "deficitQuantity", "deficitMete", ["amount", y.YUAN], ["amountExcludingVat", y.YUAN], ["inputVat", y.YUAN]], toThousandFields: ["amount", "amountExcludingVat", "inputVat"] });
  }
  return V.HOOK.handleRefresh = async (g, { data: _ }) => {
    _.content.forEach((t) => {
      t.deficitReceipt = { id: t.deficitId, serialNumber: t.deficitSerialNumber };
    }), await H(_.content), await Y(_.content, { toSmallest: false, toNum: true }, { quantity: ["quantity", "deficitQuantity"], mete: ["mete", "deficitMete"] }), _.content.forEach((t) => {
      t.deficitQuantity = -t.deficitQuantity, t.deficitMete = -t.deficitMete, t.amount = -t.amount, t.amountExcludingVat = -t.amountExcludingVat, t.inputVat = -t.inputVat;
    });
  }, (g, _) => {
    const t = M, C = B("common-table"), L = P;
    return n(), R("div", ae, [b(X), w((n(), s(C, { ref_key: "tableRef", ref: c, data: i(E).data, "data-format": p.value, "max-height": i(N), "summary-method": v, "highlight-current-row": "", "row-key": "id", "show-summary": "" }, { default: f(() => [b(t, { align: "center", label: "序号", type: "index", width: "60" }), i(o).visible("createTime") ? (n(), s(t, { key: "createTime", "show-overflow-tooltip": true, align: "left", label: "盘亏时间", prop: "createTime", width: "150" })) : l("", true), i(o).visible("classifyName") ? (n(), s(t, { key: "classifyName", align: "left", label: "名称", "min-width": "100", prop: "classifyName", "show-overflow-tooltip": "" })) : l("", true), b(t, { align: "center", label: "规格", "min-width": "150px", prop: "specification", "show-overflow-tooltip": "" }, { default: f(({ row: u }) => [d("span", null, m(i(ee)(u)), 1)]), _: 1 }), i(o).visible("brand") ? (n(), s(t, { key: "brand", align: "center", label: "品牌", "min-width": "100px", prop: "brand" })) : l("", true), i(o).visible("color") ? (n(), s(t, { key: "color", align: "center", label: "颜色", "min-width": "100px", prop: "color" })) : l("", true), i(o).visible("heatNoAndBatchNo") ? (n(), s(t, { key: "heatNoAndBatchNo", align: "center", label: "炉批号/卷号", "min-width": "100px", prop: "heatNoAndBatchNo" })) : l("", true), i(o).visible("project") ? (n(), s(t, { key: "project", align: "center", label: "项目", "min-width": "120px", prop: "project" })) : l("", true), i(o).visible("warehouse.name") ? (n(), s(t, { key: "warehouse.name", align: "center", label: "仓库", "min-width": "100px", prop: "warehouse.name" })) : l("", true), i(o).visible("measureUnit") ? (n(), s(t, { key: "measureUnit", align: "center", label: "计量单位", prop: "measureUnit", width: "80" })) : l("", true), i(o).visible("accountingUnit") ? (n(), s(t, { key: "accountingUnit", align: "center", label: "核算单位", prop: "accountingUnit", width: "80px" })) : l("", true), i(o).visible("deficitQuantity") ? (n(), s(t, { key: "deficitQuantity", align: "center", label: "盘亏数量", "min-width": "105px", prop: "deficitQuantity" }, { default: f(({ row: u }) => [d("span", ne, m(u.deficitQuantity), 1)]), _: 1 })) : l("", true), i(o).visible("deficitMete") ? (n(), s(t, { key: "deficitMete", align: "center", label: "盘亏重量", "min-width": "135px", prop: "deficitMete" }, { default: f(({ row: u }) => [d("span", se, m(u.deficitMete), 1)]), _: 1 })) : l("", true), i(o).visible("amount") ? (n(), s(t, { key: "amount", label: `盘亏金额
含税`, align: "center", "min-width": "135px", prop: "amount" }, { default: f(({ row: u }) => [d("span", ce, m(u.amount), 1)]), _: 1 })) : l("", true), i(o).visible("amountExcludingVat") ? (n(), s(t, { key: "amountExcludingVat", label: `盘亏金额
不含税`, align: "center", "min-width": "135px", prop: "amountExcludingVat" }, { default: f(({ row: u }) => [d("span", oe, m(u.amountExcludingVat), 1)]), _: 1 })) : l("", true), i(o).visible("inputVat") ? (n(), s(t, { key: "inputVat", align: "center", label: "进项税", "min-width": "135px", prop: "inputVat" }, { default: f(({ row: u }) => [d("span", le, m(u.inputVat), 1)]), _: 1 })) : l("", true), i(o).visible("deficitProject") ? (n(), s(t, { key: "deficitProject", align: "center", label: "归属项目", "min-width": "135px", prop: "deficitProject" })) : l("", true), i(o).visible("deficitReceipt.serialNumber") ? (n(), s(t, { key: "deficitReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "盘亏单号", "min-width": "155", prop: "deficitReceipt.serialNumber" }, { default: f(({ row: u }) => [b(i($), { receipt: u.deficitReceipt, "receipt-types": ["INVENTORY_LOSS"] }, null, 8, ["receipt"])]), _: 1 })) : l("", true), i(o).visible("remark") ? (n(), s(t, { key: "remark", align: "center", label: "备注", "min-width": "135px", prop: "remark" })) : l("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[L, i(E).loading]]), b(i(G))]);
  };
} }, de = D(re, [["__scopeId", "data-v-717e701d"]]);
export {
  de as default
};
