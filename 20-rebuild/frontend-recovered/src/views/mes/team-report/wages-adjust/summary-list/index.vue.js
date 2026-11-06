import { openBlock as n } from "vue";
import { createElementBlock as g } from "vue";
import { unref as t } from "vue";
import { createBlock as d } from "vue";
import { withCtx as a } from "vue";
import { renderSlot as T } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as o } from "vue";
import { Fragment as W } from "vue";
import { ElTableColumn as b } from "element-plus";
import { computed as D } from "vue";
import { resolveDynamicComponent as P } from "vue";
import { inject as j } from "vue";
import { ref as L } from "vue";
import { provide as U } from "vue";
import { resolveComponent as q } from "vue";
import { createVNode as y } from "vue";
import { withDirectives as H } from "vue";
import { createTextVNode as K } from "vue";
import { vLoading as z } from "element-plus";
import { l as G, b as h, c as F, D as E, a3 as r, x as X, o as Y, G as B, P as J } from "../../../../../shared/runtime.js";
import { c as Q } from "../../../../../modules/detail-bead30a9.js";
import { e as Z } from "../../../../../modules/mes-ee117a22.js";
import _ from "./module/header.vue.js";
import "../../../../../modules/use-unshow-productType-by-mode-dfef77e4.js";
function ee(e) {
  return G({ module: "mes", url: "wages/product/classify/page", method: "get", params: e });
}
const p = { get: ee }, te = { __name: "artifact", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean, default: false }, category: { type: Number }, unitNewLine: { type: Boolean, default: true }, unShowField: { type: Array, default: () => [] } }, setup(e) {
  return (m, s) => {
    const l = b;
    return n(), g(W, null, [!e.unShowField.includes("name") && (t(h)(e.columns) || e.columns.visible("name")) ? (n(), d(l, { key: 0, "show-overflow-tooltip": true, prop: "name", label: "名称", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed, align: "center" }, { default: a(({ row: i }) => [T(m.$slots, "namePrefix", { row: i }), u("span", null, c(i.name), 1)]), _: 3 }, 8, ["width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("quantity") && (t(h)(e.columns) || e.columns.visible("quantity")) ? (n(), d(l, { key: 1, "show-overflow-tooltip": true, prop: "quantity", label: "数量(件)", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: a(({ row: i }) => [u("span", null, c(i.quantity), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("totalNetWeight") && (t(h)(e.columns) || e.columns.visible("totalNetWeight")) ? (n(), d(l, { key: 2, "show-overflow-tooltip": true, prop: "totalNetWeight", label: `重量${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: a(({ row: i }) => [u("span", null, c(i.totalNetWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : o("", true)], 64);
  };
} }, ie = { __name: "machine-part", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean }, unitNewLine: { type: Boolean, default: true }, unShowField: { type: Array, default: () => [] }, category: { type: Number } }, setup(e) {
  return (m, s) => {
    const l = b;
    return n(), g(W, null, [!e.unShowField.includes("name") && (t(h)(e.columns) || e.columns.visible("name")) ? (n(), d(l, { key: 0, "show-overflow-tooltip": true, prop: "name", label: "名称", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed, align: "center" }, { default: a(({ row: i }) => [T(m.$slots, "namePrefix", { row: i }), u("span", null, c(i.name), 1)]), _: 3 }, 8, ["width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("steelSpec") && (t(h)(e.columns) || e.columns.visible("steelSpec")) ? (n(), d(l, { key: 1, "show-overflow-tooltip": true, prop: "steelSpec", label: "厚度/规格", width: e.fixedWidth ? "140px" : "", "min-width": e.fixedWidth ? "" : "140px", fixed: e.fixed, align: "center" }, { default: a(({ row: i }) => [u("span", null, c(i.steelSpec), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("material") && (t(h)(e.columns) || e.columns.visible("material")) ? (n(), d(l, { key: 2, "show-overflow-tooltip": true, prop: "material", label: "材质", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", fixed: e.fixed, align: "center" }, { default: a(({ row: i }) => [u("span", null, c(i.material), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("quantity") && (t(h)(e.columns) || e.columns.visible("quantity")) ? (n(), d(l, { key: 3, "show-overflow-tooltip": true, prop: "quantity", label: "零件数", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: a(({ row: i }) => [u("span", null, c(i.quantity), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("totalNetWeight") && (t(h)(e.columns) || e.columns.visible("totalNetWeight")) ? (n(), d(l, { key: 4, "show-overflow-tooltip": true, prop: "totalNetWeight", label: `零件量${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: a(({ row: i }) => [u("span", null, c(i.totalNetWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : o("", true)], 64);
  };
} }, ne = { __name: "enclosure", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean }, unitNewLine: { type: Boolean, default: true }, category: { type: Number }, unShowField: { type: Array, default: () => [] } }, setup(e) {
  return (m, s) => {
    const l = b;
    return n(), g(W, null, [!e.unShowField.includes("category") && (t(h)(e.columns) || e.columns.visible("category")) ? (n(), d(l, { key: 0, "show-overflow-tooltip": true, prop: "category", label: "类型", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed, align: "center" }, { default: a(({ row: i }) => [u("span", null, c(i.category), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("quantity") && (t(h)(e.columns) || e.columns.visible("quantity")) ? (n(), d(l, { key: 1, "show-overflow-tooltip": true, prop: "quantity", label: "数量(件)", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: a(({ row: i }) => [u("span", null, c(i.quantity), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("totalArea") && (t(h)(e.columns) || e.columns.visible("totalArea")) ? (n(), d(l, { key: 2, "show-overflow-tooltip": true, prop: "totalArea", label: `总面积${e.unitNewLine ? `
` : ""}(㎡)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: a(({ row: i }) => [u("span", null, c(t(F)(i.totalArea, "mm2", "m2", t(E).COM_AREA__M2)), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("totalLength") && (t(h)(e.columns) || e.columns.visible("totalLength")) ? (n(), d(l, { key: 3, "show-overflow-tooltip": true, prop: "totalLength", label: `总长度${e.unitNewLine ? `
` : ""}(m)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: a(({ row: i }) => [u("span", null, c(t(F)(i.totalLength, "mm", "m", t(E).MES_ENCLOSURE_L__M)), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : o("", true)], 64);
  };
} }, le = { __name: "assemble", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean }, unShowField: { type: Array, default: () => [] }, unitNewLine: { type: Boolean, default: true }, category: { type: Number } }, setup(e) {
  return (m, s) => {
    const l = b;
    return n(), g(W, null, [!e.unShowField.includes("serialNumber") && (t(h)(e.columns) || e.columns.visible("serialNumber")) ? (n(), d(l, { key: 0, "show-overflow-tooltip": true, prop: "serialNumber", label: "部件号", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed, align: "center" }, { default: a(({ row: i }) => [u("span", null, c(i.serialNumber), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("quantity") && (t(h)(e.columns) || e.columns.visible("quantity")) ? (n(), d(l, { key: 1, "show-overflow-tooltip": true, prop: "quantity", label: "数量(件)", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: a(({ row: i }) => [u("span", null, c(i.quantity), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : o("", true), !e.unShowField.includes("netWeight") && (t(h)(e.columns) || e.columns.visible("netWeight")) ? (n(), d(l, { key: 2, "show-overflow-tooltip": true, prop: "netWeight", label: `重量${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: a(({ row: i }) => [u("span", null, c(i.netWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : o("", true)], 64);
  };
} }, de = { __name: "index", props: { productType: { type: Number }, unitNewLine: { type: Boolean, default: true }, category: { type: Number }, columns: { type: Object }, unShowField: { type: Array, default: () => [] }, fixed: { type: String }, fixedWidth: { type: Boolean } }, setup(e) {
  const m = e, s = D(() => {
    switch (m.productType) {
      case r.ARTIFACT.V:
        return te;
      case r.MACHINE_PART.V:
        return ie;
      case r.ENCLOSURE.V:
        return ne;
      case r.AUXILIARY_MATERIAL.V:
        return null;
      case r.ASSEMBLE.V:
        return le;
      default:
        return null;
    }
  });
  return (l, i) => (n(), d(P(s.value), { columns: e.columns, category: e.category, fixed: e.fixed, unitNewLine: e.unitNewLine, fixedWidth: e.fixedWidth, unShowField: e.unShowField }, null, 8, ["columns", "category", "fixed", "unitNewLine", "fixedWidth", "unShowField"]));
} }, ae = { class: "app-container" }, ue = { class: "head-container" }, xe = { __name: "index", emits: ["setInfo", "setDetailInfo", "refreshAuditNumber"], setup(e, { expose: m, emit: s }) {
  const l = { add: false, edit: false, del: false, download: false }, i = s, v = j("permission"), C = L(), A = L(), { crud: f, columns: R, CRUD: k } = X({ title: "工价调整汇总", permission: { ...v }, optShow: { ...l }, crudApi: { ...p }, hasPagination: true }, A), { maxHeight: $ } = Y({ paginate: true });
  U("query", f.query), k.HOOK.beforeRefresh = () => {
    f.crudApi.get = f.query.productType & r.ASSEMBLE.V ? Q.get : p.get, i("refreshAuditNumber");
  }, k.HOOK.handleRefresh = (S, x) => {
    x.data.content = x.data.content.map((w, N) => (w.rowId = N + "" + Math.random(), w));
  };
  function V(S) {
    f.query.productType & r.ASSEMBLE.V ? i("setDetailInfo", S) : i("setInfo", S);
  }
  return m({ query: f.query }), (S, x) => {
    const w = b, N = q("common-button"), M = q("common-table"), O = z;
    return n(), g("div", ae, [u("div", ue, [y(t(_), { ref_key: "headRef", ref: C }, null, 512)]), H((n(), d(M, { ref_key: "tableRef", ref: A, data: t(f).data, "data-format": t(Z), "empty-text": t(f).emptyText, "max-height": t($), "row-key": "rowId", style: { width: "100%" } }, { default: a(() => [y(w, { label: "序号", type: "index", align: "center", width: "60" }), y(t(de), { productType: t(f).query.productType, columns: t(R), unitNewLine: false }, null, 8, ["productType", "columns"]), t(B)(t(v).get) && !(t(f).query.productType & t(r).ASSEMBLE.V) || t(B)(t(v).edit) && t(f).query.productType & t(r).ASSEMBLE.V ? (n(), d(w, { key: 0, align: "center", prop: "prop", label: "操作", width: "100" }, { default: a(({ row: I }) => [y(N, { type: "warning", size: "default", onClick: (oe) => V(I) }, { default: a(() => x[0] || (x[0] = [K("修改")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 })) : o("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[O, t(f).loading]]), y(t(J))]);
  };
} };
export {
  xe as default
};
