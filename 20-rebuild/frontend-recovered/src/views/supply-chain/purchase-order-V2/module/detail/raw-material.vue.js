import { computed as v } from "vue";
import { ref as M } from "vue";
import { watch as J } from "vue";
import { nextTick as W } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as n } from "vue";
import { createBlock as y } from "vue";
import { createSlots as Y } from "vue";
import { unref as e } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as d } from "vue";
import { createCommentVNode as m } from "vue";
import { withDirectives as i } from "vue";
import { createElementVNode as r } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as o } from "vue";
import { normalizeStyle as Z } from "vue";
import { toDisplayString as u } from "vue";
import { ElTag as G } from "element-plus";
import { ElFormItem as Q } from "element-plus";
import { ElDivider as X } from "element-plus";
import { ElForm as ee } from "element-plus";
import { _ as ae, gt as te, ho as se, i as w, jO as N, iF as D, fE as le, jJ as P, am as g, bR as ne, bD as L, jU as re, jV as oe, z as ie, R as pe, S as ue, jZ as de } from "../../../../../shared/runtime.js";
const me = { key: 0 }, ce = { class: "main-content" }, _e = { class: "form-left" }, fe = { key: 0 }, ye = { class: "flex-rss child-mr-10" }, be = { key: 0 }, ve = { key: 1 }, he = { key: 0 }, we = { key: 1 }, ke = { key: 0 }, Te = { key: 0 }, Ee = { key: 0 }, Me = { key: 0, class: "pre-wrap" }, Ne = { style: { "word-break": "break-all" } }, ge = { __name: "raw-material", setup(Se) {
  const { CRUD: j, crud: k, detail: a } = te(), { loaded: T, rawMatClsKV: S } = se(), z = v(() => w(a) && a.serialNumber ? `订单：${a.serialNumber}` : "订单"), U = v(() => a.preparationSNList && a.preparationSNList.length > 0), O = M(), B = M(/* @__PURE__ */ new Map()), F = M([]), x = v(() => a.purchaseStatus === N.FINISHED.V), C = v(() => a.settlementStatus === D.SETTLED.V);
  j.HOOK.beforeDetailLoaded = (b, t) => {
    H();
    const f = async () => {
      t.auxMaterialIds && (t.auxMaterialNames = t.auxMaterialIds.map((l) => {
        const c = S.value[l];
        return c ? c.name : "-";
      })), t.otherMaterialIds && (t.otherMaterialNames = t.otherMaterialIds.map((l) => {
        const c = S.value[l];
        return c ? c.name : "-";
      })), t.boolPartyA = t.supplyType === de.PARTY_A.V;
    };
    if (T.value) f();
    else {
      const l = J(T, async (c) => {
        c && (await f(), W(() => {
          l();
        }));
      }, { immediate: true });
    }
  };
  function H() {
    O.value = void 0, B.value = /* @__PURE__ */ new Map(), F.value = [];
  }
  return (b, t) => {
    const f = G, l = Q, c = X, K = A("common-button"), $ = ee, q = A("common-drawer"), _ = h("parse-enum"), V = h("split"), I = h("empty-text"), R = h("parse-time");
    return n(), y(q, { ref: "drawerRef", visible: e(k).detailVisible, "content-loading": !e(T) || e(k).detailLoading, "before-close": e(k).cancelDetail, title: z.value, "show-close": true, size: U.value ? "100%" : "820px", "custom-class": "purchase-order-raw-mat-detail" }, Y({ content: s(() => [r("div", ce, [e(w)(e(a)) ? (n(), y($, { key: 0, model: e(a), size: "default", "label-position": "left", "label-width": "100px" }, { default: s(() => [r("div", { class: "form-content", style: Z(`height: ${b.maxHeight - 90}px`) }, [r("div", _e, [o(l, { label: "合同编号", prop: "serialNumber" }, { default: s(() => [r("span", null, u(e(a).serialNumber), 1)]), _: 1 }), o(l, { label: "采购目的", prop: "orderPlace" }, { default: s(() => [e(a).orderPlace ? (n(), p("span", fe, u(e(le).V[e(a).orderPlace].SL), 1)) : m("", true)]), _: 1 }), o(l, { label: "材料类型", prop: "basicClass" }, { default: s(() => [r("div", ye, [i(r("span", null, null, 512), [[_, { e: e(P), v: e(a).purchaseType, extra: "：" }]]), i(r("span", null, null, 512), [[_, { e: e(g), v: e(a).basicClass, bit: true, split: " | " }]])])]), _: 1 }), e(a).basicClass & e(g).MATERIAL.V ? (n(), y(l, { key: 0, label: "辅材明细", prop: "auxMaterialNames", style: { width: "100%", "word-break": "break-all" } }, { default: s(() => [e(a).auxMaterialIds.includes(0) ? (n(), p("span", be, "所有辅材")) : i((n(), p("span", ve, null, 512)), [[V, e(a).auxMaterialNames]])]), _: 1 })) : m("", true), e(a).basicClass & e(g).OTHER.V ? (n(), y(l, { key: 1, label: "其它明细", prop: "otherMaterialNames", style: { width: "100%", "word-break": "break-all" } }, { default: s(() => [e(a).otherMaterialIds.includes(0) ? (n(), p("span", he, "所有其它科目")) : i((n(), p("span", we, null, 512)), [[V, e(a).otherMaterialNames]])]), _: 1 })) : m("", true), o(l, { prop: "weightMeasurementMode", label: "计量方式" }, { default: s(() => [i(r("span", null, null, 512), [[_, { e: e(ne), v: e(a).weightMeasurementMode }]])]), _: 1 }), o(l, { label: "供应商", prop: "supplier" }, { default: s(() => [e(a).supplier ? (n(), p("span", ke, u(e(a).supplier.name), 1)) : m("", true)]), _: 1 }), o(l, { label: "采购单位", prop: "branchCompanyName", style: { width: "100%" } }, { default: s(() => [e(a).branchCompany ? (n(), p("span", Te, u(e(a).branchCompany.name), 1)) : m("", true)]), _: 1 }), o(l, { label: "发票及税率", prop: "invoiceType" }, { default: s(() => [i(r("span", null, null, 512), [[_, { e: e(L), v: b.form.invoiceType }]]), b.form.invoiceType !== e(L).RECEIPT.V ? (n(), p("span", Ee, "（" + u(b.form.taxRate) + "%）", 1)) : m("", true), t[2] || (t[2] = d("】 "))]), _: 1, __: [2] }), o(l, { label: "物流信息", prop: "logistics" }, { default: s(() => [i(r("span", null, null, 512), [[_, { e: e(re), v: e(a).logisticsTransportType }]]), t[3] || (t[3] = d(" （费用")), i(r("span", null, null, 512), [[_, { e: e(oe), v: e(a).logisticsPayerType }]]), t[4] || (t[4] = d("） "))]), _: 1, __: [3, 4] }), o(l, { label: "合同量", prop: "mete" }, { default: s(() => [r("span", null, u(e(a).mete) + " " + u(e(a).meteUnit), 1)]), _: 1 }), o(l, { label: "合同额", prop: "amount" }, { default: s(() => [r("span", null, u(e(a).amount) + " 元", 1)]), _: 1 }), o(l, { label: "关联项目", class: "el-form-item-4", prop: "projectIds", style: { width: "100%" } }, { default: s(() => [e(P).RAW_MATERIAL.V === e(a).purchaseType ? (n(), p("span", Me, u(e(a).projects ? e(a).projects.map((E) => e(ie)(E, null, false)).join(`
`) : ""), 1)) : m("", true)]), _: 1 }), o(l, { label: "创建人", prop: "applicantName" }, { default: s(() => [i((n(), p("span", null, [d(u(e(a).applicantName), 1)])), [[I]]), t[5] || (t[5] = d(" （创建时间：")), i(r("span", null, null, 512), [[R, e(a).createTime]]), t[6] || (t[6] = d("） "))]), _: 1, __: [5, 6] }), o(l, { label: "编制人", prop: "lastOperatorName" }, { default: s(() => [i((n(), p("span", null, [d(u(e(a).lastOperatorName), 1)])), [[I]]), t[7] || (t[7] = d(" （操作时间：")), i(r("span", null, null, 512), [[R, e(a).userUpdateTime]]), t[8] || (t[8] = d("） "))]), _: 1, __: [7, 8] }), o(l, { label: "备注", prop: "remark", style: { width: "100%" } }, { default: s(() => [r("span", Ne, u(e(a).remark), 1)]), _: 1 }), o(c, null, { default: s(() => t[9] || (t[9] = [r("span", { class: "title" }, "附件", -1)])), _: 1, __: [9] }), o(pe, { "show-download": "", showView: true, "file-classify": e(ue).PURCHASE_ORDER_ATT.V, files: e(a).attachments, "onUpdate:files": t[0] || (t[0] = (E) => e(a).attachments = E), uploadable: false, "empty-text": "暂未上传采购合同附件" }, null, 8, ["file-classify", "files"]), o(K, null, { default: s(() => t[10] || (t[10] = [d("查看审批记录")])), _: 1, __: [10] })])], 4)]), _: 1 }, 8, ["model"])) : m("", true)])]), _: 2 }, [e(w)(e(a)) ? { name: "titleAfter", fn: s(() => [e(a).boolPartyA ? (n(), y(f, { key: 0, type: "danger", effect: "dark", size: "default" }, { default: s(() => t[1] || (t[1] = [d("甲供")])), _: 1, __: [1] })) : m("", true), e(w)(e(a).purchaseStatus) ? (n(), y(f, { key: 1, type: x.value ? "success" : e(a).boolUsed ? "warning" : "info", effect: x.value ? "dark" : "plain", size: "default" }, { default: s(() => [i(r("span", null, null, 512), [[_, { e: e(N), v: e(a).purchaseStatus }]]), e(a).boolUsed && e(a).purchaseStatus === e(N).UNFINISHED.V ? (n(), p("span", me, " (有入库)")) : m("", true)]), _: 1 }, 8, ["type", "effect"])) : m("", true), i(o(f, { type: C.value ? "success" : "info", effect: C.value ? "dark" : "plain", size: "default" }, null, 8, ["type", "effect"]), [[_, { e: e(D), v: e(a).settlementStatus }]])]), key: "0" } : void 0]), 1032, ["visible", "content-loading", "before-close", "title", "size"]);
  };
} }, Ve = ae(ge, [["__scopeId", "data-v-09db9abe"]]);
export {
  Ve as default
};
