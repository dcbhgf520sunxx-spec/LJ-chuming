import { watch as D } from "vue";
import { ref as k } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as l } from "vue";
import { createBlock as m } from "vue";
import { withCtx as a } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as A } from "vue";
import { createElementVNode as R } from "vue";
import { withDirectives as L } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as t } from "vue";
import { createElementBlock as u } from "vue";
import { isRef as F } from "vue";
import { ElDescriptionsItem as P } from "element-plus";
import { ElDescriptions as U } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { ElTooltip as S } from "element-plus";
import { vLoading as z } from "element-plus";
import { g as H } from "../../../../../modules/outsourcing-receiving-3624908c.js";
import { u as G, o as J, tS as d, jl as K, cO as Q, G as X, p as Y, pz as Z, pA as $ } from "../../../../../shared/runtime.js";
const ee = { class: "head-container" }, ae = { key: 1 }, te = { key: 0 }, ne = { key: 1 }, le = { key: 0 }, oe = { key: 1 }, ie = { key: 0 }, ce = { key: 1 }, me = { __name: "delivery-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(c, { emit: x }) {
  const M = x, h = c, { visible: _, handleClose: E } = G({ emit: M, props: h });
  D(_, (p) => {
    p && q();
  });
  const N = k(), I = k([]), T = k(), b = k(false), { maxHeight: B } = J({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: false, extraHeight: 10 }, T);
  async function q() {
    var f, g;
    let p = [];
    b.value = true;
    try {
      p = await H({ operateId: (f = h.detailInfo) == null ? void 0 : f.id }) || [], ((g = h.detailInfo) == null ? void 0 : g.productType) === d.RAW_MATERIAL.V && await K(p, { toNum: true }, { mete: ["mete", "actualReceivedMete"], quantity: ["quantity"] });
    } catch (r) {
      console.log("收货明细", r);
    } finally {
      I.value = p, Q(I.value), b.value = false;
    }
  }
  return (p, f) => {
    const g = v("print-table"), r = P, C = U, s = O, j = S, W = v("common-table"), w = v("common-drawer"), V = z;
    return l(), m(w, { ref_key: "drawerRef", ref: T, title: "发货明细", "close-on-click-modal": false, modelValue: o(_), "onUpdate:modelValue": f[0] || (f[0] = (e) => F(_) ? _.value = e : null), direction: "rtl", "before-close": o(E), "custom-class": "delivery-detail", size: "80%" }, { titleAfter: a(() => {
      var e;
      return [o(X)(c.permission.print) ? (l(), m(g, { key: 0, "api-key": "outsourcingReceivingRecord", params: (e = c.detailInfo) == null ? void 0 : e.id, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])) : A("", true)];
    }), content: a(() => [R("div", ee, [L((l(), m(C, { column: 3, border: "" }, { default: a(() => [i(r, { span: 2, align: "center", "label-class-name": "contractLabel", label: "项目" }, { default: a(() => [y(t(c.detailInfo.projectName || "-"), 1)]), _: 1 }), i(r, { align: "center", "label-class-name": "contractLabel", label: "采购合同号" }, { default: a(() => [y(t(c.detailInfo.orderSerialNumber), 1)]), _: 1 }), i(r, { align: "center", "label-class-name": "contractLabel", label: "材料类型" }, { default: a(() => {
      var e;
      return [y(t(o(d).VL[(e = c.detailInfo) == null ? void 0 : e.productType]), 1)];
    }), _: 1 }), i(r, { align: "center", "label-class-name": "contractLabel", label: "收货人" }, { default: a(() => [y(t(c.detailInfo.userName), 1)]), _: 1 }), i(r, { align: "center", "label-class-name": "contractLabel", label: "收货日期" }, { default: a(() => [y(t(o(Y)(c.detailInfo.receivedTime, "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 })), [[V, b.value]])]), L((l(), m(W, { ref_key: "tableRef", ref: N, data: I.value, "max-height": o(B) }, { default: a(() => [i(s, { label: "序号", type: "index", align: "center", width: "60" }), c.detailInfo.productType !== o(d).RAW_MATERIAL.V ? (l(), m(s, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center" }, { default: a(({ row: e }) => {
      var n;
      return [R("span", null, t(((n = e.monomer) == null ? void 0 : n.name) || "-"), 1)];
    }), _: 1 })) : A("", true), c.detailInfo.productType !== o(d).RAW_MATERIAL.V ? (l(), m(s, { key: "area.name", prop: "area.name", label: "区域", align: "center" }, { default: a(({ row: e }) => {
      var n;
      return [R("span", null, t(((n = e.area) == null ? void 0 : n.name) || "-"), 1)];
    }), _: 1 })) : A("", true), i(s, { key: "name", prop: "name", label: "名称", align: "center" }), i(s, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), i(s, { key: "specificationMerge", prop: "specificationMerge", label: "规格", align: "center" }, { default: a(({ row: e }) => [e.productType === o(d).RAW_MATERIAL.V ? (l(), m(j, { key: 0, content: o(Z)(e), placement: "left" }, { default: a(() => [R("span", null, t(o($)(e)), 1)]), _: 2 }, 1032, ["content"])) : (l(), u("span", ae, t(e.specification || "-"), 1))]), _: 1 }), i(s, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center" }), i(s, { key: "quantity", prop: "quantity", label: "数量", align: "center" }, { default: a(({ row: e }) => {
      var n;
      return [c.detailInfo.productType === o(d).RAW_MATERIAL.V ? (l(), u("span", te, t(((n = e.quantity) == null ? void 0 : n.toFixed(+e.measurePrecision)) || "-"), 1)) : (l(), u("span", ne, t(e.quantity || "-"), 1))];
    }), _: 1 }), i(s, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), i(s, { key: "mete", prop: "mete", label: "核算量", align: "center" }, { default: a(({ row: e }) => {
      var n;
      return [c.detailInfo.productType === o(d).RAW_MATERIAL.V ? (l(), u("span", le, t(((n = e.mete) == null ? void 0 : n.toFixed(+e.accountingPrecision)) || "-"), 1)) : (l(), u("span", oe, t(e.mete || "-"), 1))];
    }), _: 1 }), i(s, { key: "actualReceivedMete", prop: "actualReceivedMete", label: "实收量", align: "center" }, { default: a(({ row: e }) => {
      var n;
      return [c.detailInfo.productType === o(d).RAW_MATERIAL.V ? (l(), u("span", ie, t(((n = e.actualReceivedMete) == null ? void 0 : n.toFixed(+e.accountingPrecision)) || "-"), 1)) : (l(), u("span", ce, t(e.actualReceivedMete || "-"), 1))];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[V, b.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  me as default
};
