import { ref as v } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as i } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { unref as l } from "vue";
import { createTextVNode as p } from "vue";
import { createCommentVNode as A } from "vue";
import { createElementVNode as b } from "vue";
import { withDirectives as V } from "vue";
import { createVNode as t } from "vue";
import { toDisplayString as o } from "vue";
import { createElementBlock as _ } from "vue";
import { Fragment as I } from "vue";
import { renderList as O } from "vue";
import { isRef as S } from "vue";
import { ElDescriptionsItem as M } from "element-plus";
import { ElTag as z } from "element-plus";
import { ElDescriptions as U } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { ElTooltip as $ } from "element-plus";
import { vLoading as J } from "element-plus";
import { p as K, q as Q } from "../../../modules/purchase-data-analysis-1b2dc5a0.js";
import { u as W, G as B, cO as X, jl as Y, o as Z, L as ee, aN as ae, bv as te, jP as D, pz as le, pA as oe, p as ne } from "../../../shared/runtime.js";
const se = { class: "head-container" }, ie = { key: 0 }, re = { key: 1 }, ce = { key: 0 }, me = { __name: "purchase-order-record-detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(n, { emit: N }) {
  const C = v(), m = v([]), w = v(false), E = N, y = n, { visible: h, handleClose: T } = W({ emit: E, props: y, field: "visible", showHook: j });
  async function j() {
    var r, c;
    if (!B((r = y.permission) == null ? void 0 : r.detail)) return false;
    let g = [];
    try {
      w.value = true;
      const { content: f = [] } = await K({ id: (c = y.detailData) == null ? void 0 : c.id });
      g = f || [];
    } catch (f) {
      console.log("获取采购订单记录失败", f);
    } finally {
      m.value = g, await X(m.value), await Y(m.value, { toNum: true }, { quantity: ["quantity"], mete: ["mete"], amount: ["price"] }), w.value = false;
    }
  }
  const { maxHeight: H } = Z({ mainBox: ".purchase-detail-class", extraBox: [".el-drawer__header", ".head-container", "title-class"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: true, navbar: false, extraHeight: 30 }, h);
  return (g, r) => {
    const c = M, f = z, R = U, s = G, q = $, F = k("common-table"), P = k("common-drawer"), x = J;
    return i(), u(P, { "custom-class": "purchase-detail-class", ref_key: "drawerRef", ref: C, title: "采购订单记录", modelValue: l(h), "onUpdate:modelValue": r[0] || (r[0] = (e) => S(h) ? h.value = e : null), direction: "rtl", "before-close": l(T), size: "70%" }, { titleRight: a(() => {
      var e, d, L;
      return [l(B)((e = n.permission) == null ? void 0 : e.download) ? (i(), u(ee, { key: 0, fn: l(Q), params: { orderId: (d = n.detailData) == null ? void 0 : d.id }, disabled: !((L = m.value) != null && L.length) }, { default: a(() => r[1] || (r[1] = [p(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : A("", true)];
    }), content: a(() => [b("div", se, [V((i(), u(R, { column: 2, border: "" }, { default: a(() => [t(c, { align: "center", "label-class-name": "contractLabel", label: "供应商" }, { default: a(() => {
      var e, d;
      return [p(o(((d = (e = n.detailData) == null ? void 0 : e.supplier) == null ? void 0 : d.name) || "-"), 1)];
    }), _: 1 }), t(c, { align: "center", "label-class-name": "contractLabel", label: "采购合同号" }, { default: a(() => {
      var e;
      return [p(o(((e = n.detailData) == null ? void 0 : e.serialNumber) || "-"), 1)];
    }), _: 1 }), t(c, { align: "center", "label-class-name": "contractLabel", label: "签订主体" }, { default: a(() => {
      var e;
      return [p(o(((e = n.detailData) == null ? void 0 : e.branchCompany.name) || "-"), 1)];
    }), _: 1 }), t(c, { align: "center", "label-class-name": "contractLabel", label: "类别" }, { default: a(() => [(i(true), _(I, null, O(l(ae)(l(te).getBits(l(D), n.detailData.basicClass, "V")), (e) => (i(), u(f, { style: { "margin-right": "5px" }, key: e, type: l(D).V[e].T, effect: "light", "disable-transitions": "" }, { default: a(() => [p(o(l(D).VL[e]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), t(c, { align: "center", "label-class-name": "contractLabel", label: "合同额（元）" }, { default: a(() => {
      var e;
      return [p(o(((e = n.detailData) == null ? void 0 : e.amount) || 0), 1)];
    }), _: 1 }), t(c, { align: "center", "label-class-name": "contractLabel", label: "累计入库额（元）" }, { default: a(() => {
      var e;
      return [p(o(((e = n.detailData) == null ? void 0 : e.inboundAmount) || 0), 1)];
    }), _: 1 })]), _: 1 })), [[x, g.descriptionLoading]])]), r[2] || (r[2] = b("div", { class: "title-class", style: { "font-weight": "bolder", "margin-bottom": "6px" } }, "入库明细", -1)), V((i(), u(F, { ref: "tableRef", data: m.value, "max-height": l(H), style: { width: "100%" } }, { default: a(() => [t(s, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(s, { "show-overflow-tooltip": true, prop: "classifyName", label: "物料种类", align: "center" }, { default: a(({ row: e }) => [n.detailData.purchaseType === 2 ? (i(), _("span", ie, o(e.manufacturedName || "-"), 1)) : (i(), _("span", re, o(e.classifyName || "-"), 1))]), _: 1 }), t(s, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center", "min-width": "180" }, { default: a(({ row: e }) => [n.detailData.purchaseType === 2 ? (i(), _("span", ce, o(e.specification || "-"), 1)) : (i(), u(q, { key: 1, content: l(le)(e), placement: "left" }, { default: a(() => [b("span", null, o(l(oe)(e) || "-"), 1)]), _: 2 }, 1032, ["content"]))]), _: 1 }), t(s, { "show-overflow-tooltip": true, prop: "accountingUnit", label: "单位", align: "center", width: "100" }), t(s, { "show-overflow-tooltip": true, prop: n.detailData.purchaseType === 2 ? "quantity" : "mete", label: "数量", align: "center" }), t(s, { "show-overflow-tooltip": true, prop: "price", label: "单价", align: "center" }), t(s, { "show-overflow-tooltip": true, prop: "amount", label: "金额", align: "center" }), t(s, { "show-overflow-tooltip": true, prop: "rejectAmount", label: "退货金额", align: "center" }), t(s, { "show-overflow-tooltip": true, prop: "applicantName", label: "办理人", align: "center" }, { default: a(({ row: e }) => {
      var d;
      return [b("span", null, o(((d = e.applicant) == null ? void 0 : d.name) || "-"), 1)];
    }), _: 1 }), t(s, { "show-overflow-tooltip": true, prop: "applicantDate", label: "入库日期", align: "center" }, { default: a(({ row: e }) => [b("span", null, o(e.applicantDate ? l(ne)(e.applicantDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[x, w.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  me as default
};
