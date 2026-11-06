import { computed as v } from "vue";
import { ref as E } from "vue";
import { watch as J } from "vue";
import { nextTick as W } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as r } from "vue";
import { createBlock as b } from "vue";
import { createSlots as Y } from "vue";
import { unref as e } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as m } from "vue";
import { createCommentVNode as d } from "vue";
import { createVNode as n } from "vue";
import { withDirectives as i } from "vue";
import { createElementVNode as o } from "vue";
import { createElementBlock as p } from "vue";
import { normalizeStyle as Z } from "vue";
import { toDisplayString as u } from "vue";
import { ElTag as G } from "element-plus";
import { ElFormItem as Q } from "element-plus";
import { ElDivider as X } from "element-plus";
import { ElForm as ee } from "element-plus";
import { _ as ae, gt as te, ho as se, i as M, jO as N, iF as D, fE as le, jJ as L, am as g, bR as ne, bD as j, jU as oe, jV as re, z as ie, R as pe, S as ue, jZ as me } from "../../../../../shared/runtime.js";
const de = { key: 0 }, ce = { class: "main-content" }, _e = { class: "form-left" }, fe = { key: 0 }, ye = { class: "flex-rss child-mr-10" }, be = { key: 0 }, ve = { key: 1 }, he = { key: 0 }, we = { key: 1 }, ke = { key: 0 }, Te = { key: 0 }, Ee = { key: 0 }, Me = { key: 0, class: "pre-wrap" }, Ne = { style: { "word-break": "break-all" } }, ge = { __name: "raw-material", setup(Se) {
  const { CRUD: P, crud: w, detail: a } = te(), { loaded: k, rawMatClsKV: S } = se(), z = v(() => M(a) && a.serialNumber ? `订单：${a.serialNumber}` : "订单"), U = v(() => a.preparationSNList && a.preparationSNList.length > 0), O = E(), B = E(/* @__PURE__ */ new Map()), F = E([]), x = v(() => a.purchaseStatus === N.FINISHED.V), C = v(() => a.settlementStatus === D.SETTLED.V);
  P.HOOK.beforeDetailLoaded = (y, t) => {
    H();
    const f = async () => {
      t.auxMaterialIds && (t.auxMaterialNames = t.auxMaterialIds.map((l) => {
        const c = S.value[l];
        return c ? c.name : "-";
      })), t.otherMaterialIds && (t.otherMaterialNames = t.otherMaterialIds.map((l) => {
        const c = S.value[l];
        return c ? c.name : "-";
      })), t.boolPartyA = t.supplyType === me.PARTY_A.V;
    };
    if (k.value) f();
    else {
      const l = J(k, async (c) => {
        c && (await f(), W(() => {
          l();
        }));
      }, { immediate: true });
    }
  };
  function H() {
    O.value = void 0, B.value = /* @__PURE__ */ new Map(), F.value = [];
  }
  return (y, t) => {
    const f = G, l = Q, c = X, K = A("common-button"), $ = ee, q = A("common-drawer"), _ = h("parse-enum"), V = h("split"), I = h("empty-text"), R = h("parse-time");
    return r(), b(q, { ref: "drawerRef", visible: e(w).detailVisible, "content-loading": !e(k) || e(w).detailLoading, "before-close": e(w).cancelDetail, title: z.value, "show-close": true, size: U.value ? "100%" : "820px", "custom-class": "purchase-order-raw-mat-detail" }, Y({ content: s(() => [o("div", ce, [e(M)(e(a)) ? (r(), b($, { key: 0, model: e(a), size: "small", "label-position": "left", "label-width": "100px" }, { default: s(() => [o("div", { class: "form-content", style: Z(`height: ${y.maxHeight - 90}px`) }, [o("div", _e, [n(l, { label: "合同编号", prop: "serialNumber" }, { default: s(() => [o("span", null, u(e(a).serialNumber), 1)]), _: 1 }), n(l, { label: "采购目的", prop: "level" }, { default: s(() => [e(a).level ? (r(), p("span", fe, u(e(le).V[e(a).level].SL), 1)) : d("", true)]), _: 1 }), n(l, { label: "材料类型", prop: "basicClass" }, { default: s(() => [o("div", ye, [i(o("span", null, null, 512), [[_, { e: e(L), v: e(a).purchaseType, extra: "：" }]]), i(o("span", null, null, 512), [[_, { e: e(g), v: e(a).basicClass, bit: true, split: " | " }]])])]), _: 1 }), e(a).basicClass & e(g).MATERIAL.V ? (r(), b(l, { key: 0, label: "辅材明细", prop: "auxMaterialNames", style: { width: "100%", "word-break": "break-all" } }, { default: s(() => [e(a).auxMaterialIds.includes(0) ? (r(), p("span", be, "所有辅材")) : i((r(), p("span", ve, null, 512)), [[V, e(a).auxMaterialNames]])]), _: 1 })) : d("", true), e(a).basicClass & e(g).OTHER.V ? (r(), b(l, { key: 1, label: "其它明细", prop: "otherMaterialNames", style: { width: "100%", "word-break": "break-all" } }, { default: s(() => [e(a).otherMaterialIds.includes(0) ? (r(), p("span", he, "所有其它科目")) : i((r(), p("span", we, null, 512)), [[V, e(a).otherMaterialNames]])]), _: 1 })) : d("", true), n(l, { prop: "weightMeasurementMode", label: "计量方式" }, { default: s(() => [i(o("span", null, null, 512), [[_, { e: e(ne), v: e(a).weightMeasurementMode }]])]), _: 1 }), n(l, { label: "供应商", prop: "supplier" }, { default: s(() => [e(a).supplier ? (r(), p("span", ke, u(e(a).supplier.name), 1)) : d("", true)]), _: 1 }), n(l, { label: "签订主体", prop: "branchCompanyName", style: { width: "100%" } }, { default: s(() => [e(a).branchCompany ? (r(), p("span", Te, u(e(a).branchCompany.name), 1)) : d("", true)]), _: 1 }), n(l, { label: "发票及税率", prop: "invoiceType" }, { default: s(() => [i(o("span", null, null, 512), [[_, { e: e(j), v: y.form.invoiceType }]]), y.form.invoiceType !== e(j).RECEIPT.V ? (r(), p("span", Ee, "（" + u(y.form.taxRate) + "%）", 1)) : d("", true), t[2] || (t[2] = m("】 "))]), _: 1, __: [2] }), n(l, { label: "物流信息", prop: "logistics" }, { default: s(() => [i(o("span", null, null, 512), [[_, { e: e(oe), v: e(a).logisticsTransportType }]]), t[3] || (t[3] = m(" （费用")), i(o("span", null, null, 512), [[_, { e: e(re), v: e(a).logisticsPayerType }]]), t[4] || (t[4] = m("） "))]), _: 1, __: [3, 4] }), n(l, { label: "合同量", prop: "mete" }, { default: s(() => [o("span", null, u(e(a).mete) + " " + u(e(a).meteUnit), 1)]), _: 1 }), n(l, { label: "合同额", prop: "amount" }, { default: s(() => [o("span", null, u(e(a).amount) + " 元", 1)]), _: 1 }), n(l, { label: "关联项目", class: "el-form-item-4", prop: "projectIds", style: { width: "100%" } }, { default: s(() => [e(L).RAW_MATERIAL.V === e(a).purchaseType ? (r(), p("span", Me, u(e(a).projects ? e(a).projects.map((T) => e(ie)(T, null, false)).join(`
`) : ""), 1)) : d("", true)]), _: 1 }), n(l, { label: "创建人", prop: "applicantName" }, { default: s(() => [i((r(), p("span", null, [m(u(e(a).applicantName), 1)])), [[I]]), t[5] || (t[5] = m(" （创建时间：")), i(o("span", null, null, 512), [[R, e(a).createTime]]), t[6] || (t[6] = m("） "))]), _: 1, __: [5, 6] }), n(l, { label: "编制人", prop: "lastOperatorName" }, { default: s(() => [i((r(), p("span", null, [m(u(e(a).lastOperatorName), 1)])), [[I]]), t[7] || (t[7] = m(" （操作时间：")), i(o("span", null, null, 512), [[R, e(a).userUpdateTime]]), t[8] || (t[8] = m("） "))]), _: 1, __: [7, 8] }), n(l, { label: "备注", prop: "remark", style: { width: "100%" } }, { default: s(() => [o("span", Ne, u(e(a).remark), 1)]), _: 1 }), n(c, null, { default: s(() => t[9] || (t[9] = [o("span", { class: "title" }, "附件", -1)])), _: 1, __: [9] }), n(pe, { "show-download": "", showView: true, "file-classify": e(ue).PURCHASE_ORDER_ATT.V, files: e(a).attachments, "onUpdate:files": t[0] || (t[0] = (T) => e(a).attachments = T), uploadable: false, "empty-text": "暂未上传采购合同附件" }, null, 8, ["file-classify", "files"]), n(K, null, { default: s(() => t[10] || (t[10] = [m("查看审批记录")])), _: 1, __: [10] })])], 4)]), _: 1 }, 8, ["model"])) : d("", true)])]), _: 2 }, [e(M)(e(a)) ? { name: "titleAfter", fn: s(() => [e(a).boolPartyA ? (r(), b(f, { key: 0, type: "danger", effect: "dark", size: "small" }, { default: s(() => t[1] || (t[1] = [m("甲供")])), _: 1, __: [1] })) : d("", true), n(f, { type: x.value ? "success" : e(a).boolUsed ? "warning" : "info", effect: x.value ? "dark" : "plain", size: "small" }, { default: s(() => [i(o("span", null, null, 512), [[_, { e: e(N), v: e(a).purchaseStatus }]]), e(a).boolUsed && e(a).purchaseStatus === e(N).UNFINISHED.V ? (r(), p("span", de, " (有入库)")) : d("", true)]), _: 1 }, 8, ["type", "effect"]), i(n(f, { type: C.value ? "success" : "info", effect: C.value ? "dark" : "plain", size: "small" }, null, 8, ["type", "effect"]), [[_, { e: e(D), v: e(a).settlementStatus }]])]), key: "0" } : void 0]), 1032, ["visible", "content-loading", "before-close", "title", "size"]);
  };
} }, Ve = ae(ge, [["__scopeId", "data-v-2134ebfc"]]);
export {
  Ve as default
};
