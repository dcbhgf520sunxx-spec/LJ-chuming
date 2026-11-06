import { ref as F } from "vue";
import { computed as V } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as O } from "vue";
import { createBlock as z } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as r } from "vue";
import { unref as n } from "vue";
import { createElementVNode as s } from "vue";
import { isRef as I } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { InfoFilled as $ } from "@element-plus/icons-vue";
import { ElIcon as G } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { _ as K, u as X, o as Y, p6 as v, qo as Z, qp as ee, qq as oe, bV as te } from "../../../../../shared/runtime.js";
import { u as ae } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { a as le } from "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
const re = { style: { display: "inline-block" } }, ne = ["onDblclick"], ie = { __name: "parts-summary-list", props: { visible: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(m, { emit: C }) {
  const A = C, w = m, k = F(), { visible: b, handleClose: B } = X({ emit: A, props: w, field: "visible", showHook: q }), { showDrawing: y, drawingRow: d, drawingPreview: S } = ae({ pidField: "productId", productTypeField: "MACHINE_PART" }), { maxHeight: H } = Y({ mainBox: ".reporting-approval-parts-summary-list", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, k), P = V(() => {
    var u;
    return ((u = w.currentRow) == null ? void 0 : u.subList.map((i) => {
      var a, f, _;
      return i.serialNumber = ((a = i.product) == null ? void 0 : a.serialNumber) || void 0, i.productId = ((f = i.product) == null ? void 0 : f.id) || void 0, i.monomerId = ((_ = i.monomer) == null ? void 0 : _.id) || void 0, i;
    })) || [];
  }), j = V(() => {
    switch (w.currentRow.productTypeEnum) {
      case v.ARTIFACT.V:
        return oe;
      case v.ASSEMBLE.V:
        return ee;
      case v.MACHINE_PART.V:
        return Z;
      default:
        return;
    }
  });
  function q() {
  }
  return (D, u) => {
    const i = Q, a = U, f = $, _ = G, M = J, L = E("common-table"), W = E("common-dialog");
    return O(), z(W, { ref_key: "dialogRef", ref: k, title: "零件汇总表", modelValue: n(b), "onUpdate:modelValue": u[1] || (u[1] = (l) => I(b) ? b.value = l : null), width: "70%", "before-close": n(B), "show-close": true, top: "5vh", "custom-class": "reporting-approval-parts-summary-list" }, { titleAfter: o(() => [t(i, { type: "success", size: "large", class: "tag-style" }, { default: o(() => {
      var l;
      return [h("定额编号：" + r((l = m.currentRow) == null ? void 0 : l.quotaConfigNumber), 1)];
    }), _: 1 }), t(i, { type: "success", size: "large", class: "tag-style" }, { default: o(() => {
      var l, c;
      return [h("下料方式：" + r((c = (l = m.currentRow) == null ? void 0 : l.process) == null ? void 0 : c.name), 1)];
    }), _: 1 }), t(i, { type: "success", size: "large", class: "tag-style" }, { default: o(() => {
      var l, c;
      return [h(" 计算方式：" + r((l = m.currentRow) != null && l.calculationWay ? j.value.VL[(c = m.currentRow) == null ? void 0 : c.calculationWay] : "-"), 1)];
    }), _: 1 })]), default: o(() => {
      var l, c, N, T, x, R;
      return [t(L, { ref: "tableRef", data: P.value, "max-height": n(H), style: { width: "100%" } }, { default: o(() => [t(a, { label: "序号", type: "index", align: "center", width: "60" }), t(a, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "项目", align: "center", "min-width": "200" }, { default: o((e) => {
        var p, g;
        return [s("span", null, r((p = e.row.project) == null ? void 0 : p.serialNumber) + " - " + r((g = e.row.project) == null ? void 0 : g.shortName), 1)];
      }), _: 1 }), t(a, { key: "taskOrderNumber", prop: "taskOrderNumber", "show-overflow-tooltip": "", label: "任务工单号", align: "center", "min-width": "180" }, { default: o((e) => [s("span", null, r(e.row.taskOrderNumber || "-"), 1)]), _: 1 }), t(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "零件编号", align: "center" }, { header: o(() => [t(M, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: o(() => [s("div", re, [u[2] || (u[2] = s("span", { style: { "margin-left": "10px" } }, "零件编号", -1)), t(_, null, { default: o(() => [t(f)]), _: 1 })])]), _: 1 })]), default: o((e) => {
        var p;
        return [s("span", { style: { cursor: "pointer", color: "#409eff" }, onDblclick: (g) => n(S)(e.row) }, r(((p = e.row.product) == null ? void 0 : p.serialNumber) || "-"), 41, ne)];
      }), _: 1 }), t(a, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center" }, { default: o((e) => {
        var p;
        return [s("span", null, r(((p = e.row.product) == null ? void 0 : p.specification) || "-"), 1)];
      }), _: 1 }), t(a, { key: "accountingQuantity", prop: "accountingQuantity", "show-overflow-tooltip": "", label: "核算量", align: "center" }, { default: o((e) => [s("span", null, r(e.row.accountingQuantity ?? "-"), 1)]), _: 1 }), t(a, { key: "unit", prop: "unit", "show-overflow-tooltip": "", label: "单位", align: "center" }, { default: o((e) => [s("span", null, r(e.row.unit || "-"), 1)]), _: 1 }), t(a, { key: "defineType", prop: "defineType", "show-overflow-tooltip": "", label: "定义类型", align: "center" }, { default: o((e) => [s("span", null, r(e.row.defineType || "-"), 1)]), _: 1 }), t(a, { key: "price", prop: "price", "show-overflow-tooltip": "", label: "定额单价(元)", align: "center" }, { default: o((e) => [s("span", null, r(n(te)(e.row.price, 2) || "-"), 1)]), _: 1 }), t(a, { key: "totalPrice", prop: "totalPrice", "show-overflow-tooltip": "", label: "金额(元)", align: "center" }, { default: o((e) => [s("span", null, r(e.row.totalPrice || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), t(n(le), { modelValue: n(y), "onUpdate:modelValue": u[0] || (u[0] = (e) => I(y) ? y.value = e : null), drawingSN: (l = n(d)) == null ? void 0 : l.drawingSN, "bool-bim": (c = n(d)) == null ? void 0 : c.boolBim, "serial-number": (N = n(d)) == null ? void 0 : N.serialNumber, productId: (T = n(d)) == null ? void 0 : T.productId, productType: (x = n(d)) == null ? void 0 : x.productType, "monomer-id": (R = n(d)) == null ? void 0 : R.monomerId }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType", "monomer-id"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, fe = K(ie, [["__scopeId", "data-v-2dc6a9c6"]]);
export {
  fe as default
};
