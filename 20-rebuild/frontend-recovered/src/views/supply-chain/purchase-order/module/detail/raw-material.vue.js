import { computed as w } from "vue";
import { ref as L } from "vue";
import { watch as ee } from "vue";
import { nextTick as ae } from "vue";
import { resolveComponent as H } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as r } from "vue";
import { createBlock as k } from "vue";
import { createSlots as te } from "vue";
import { unref as e } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as d } from "vue";
import { createCommentVNode as c } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as i } from "vue";
import { createElementVNode as l } from "vue";
import { createElementBlock as p } from "vue";
import { normalizeStyle as se } from "vue";
import { Fragment as C } from "vue";
import { toDisplayString as m } from "vue";
import { renderList as le } from "vue";
import { ElTag as ne } from "element-plus";
import { ElFormItem as re } from "element-plus";
import { ElDivider as oe } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { ElForm as pe } from "element-plus";
import { _ as ue, gt as de, ho as ce, o as me, i as I, jO as V, iF as z, jJ as F, am as R, jZ as U, bD as $, jT as fe, bR as _e, jU as ye, jV as ve, z as be, R as he, S as ge, jG as xe, k5 as ke, jH as we, cO as Me, jl as Ne, V as Se } from "../../../../../shared/runtime.js";
const Te = { key: 0 }, Ee = { class: "main-content" }, Le = { class: "form-left" }, Ce = { class: "flex-rss child-mr-10" }, Ie = { key: 0 }, Ve = { key: 1 }, Re = { key: 0 }, Ae = { key: 1 }, je = { key: 0 }, Pe = { key: 0 }, De = { key: 0 }, Be = { style: { "word-break": "break-all" } }, Oe = { key: 0, class: "pre-wrap" }, He = { class: "form-right" }, ze = { class: "right-head flex-rbs" }, Fe = { class: "assoc-preparation-list" }, Ue = { __name: "raw-material", setup($e) {
  const { CRUD: q, crud: M, detail: a } = de(), { loaded: T, rawMatClsKV: A } = ce(), { maxHeight: K, heightStyle: G } = me({ mainBox: ".purchase-order-raw-mat-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, () => M.detailVisible), J = w(() => I(a) && a.serialNumber ? `订单：${a.serialNumber}` : "订单"), j = w(() => a.preparationSNList && a.preparationSNList.length > 0), y = L(), N = L(/* @__PURE__ */ new Map()), h = L([]), W = w(() => {
    let v = [];
    return y.value ? v = N.value.get(y.value) : v = h.value, v || [];
  }), P = w(() => a.purchaseStatus === V.FINISHED.V), D = w(() => a.settlementStatus === z.SETTLED.V);
  q.HOOK.beforeDetailLoaded = (v, t) => {
    Y();
    const g = async () => {
      t.auxMaterialIds && (t.auxMaterialNames = t.auxMaterialIds.map((s) => {
        const u = A.value[s];
        return u ? u.name : "-";
      })), t.otherMaterialIds && (t.otherMaterialNames = t.otherMaterialIds.map((s) => {
        const u = A.value[s];
        return u ? u.name : "-";
      })), t.boolPartyA = t.supplyType === U.PARTY_A.V, Array.isArray(t.preparationList) && t.preparationList.length > 0 && (await Me(t.preparationList), await Ne(t.preparationList, { toNum: true }), t.preparationList.forEach((s) => {
        const u = N.value.get(s.preparationSN);
        u ? u.push(s) : N.value.set(s.preparationSN, [s]);
        const x = h.value.findIndex((b) => b.serialNumber === s.serialNumber && b.color === s.color && b.brand === s.brand);
        if (x > -1) h.value[x].quantity += s.quantity, h.value[x].mete += s.mete, h.value[x].preparationSNList.push(s.preparationSN);
        else {
          const b = Se(s);
          b.preparationSNList = [s.preparationSN], h.value.push(b);
        }
      }));
    };
    if (T.value) g();
    else {
      const s = ee(T, async (u) => {
        u && (await g(), ae(() => {
          s();
        }));
      }, { immediate: true });
    }
  };
  function Y() {
    y.value = void 0, N.value = /* @__PURE__ */ new Map(), h.value = [];
  }
  function Z(v) {
    v !== y.value ? y.value = v : y.value = void 0;
  }
  return (v, t) => {
    const g = ne, s = re, u = oe, x = ie, b = H("common-table"), Q = pe, X = H("common-drawer"), _ = S("parse-enum"), E = S("split"), B = S("empty-text"), O = S("parse-time");
    return r(), k(X, { ref: "drawerRef", visible: e(M).detailVisible, "content-loading": !e(T) || e(M).detailLoading, "before-close": e(M).cancelDetail, title: J.value, "show-close": true, size: j.value ? "100%" : "620px", "custom-class": "purchase-order-raw-mat-detail" }, te({ content: n(() => [l("div", Ee, [e(I)(e(a)) ? (r(), k(Q, { key: 0, model: e(a), size: "default", "label-position": "left", "label-width": "100px" }, { default: n(() => [l("div", { class: "form-content", style: se(e(G)) }, [l("div", Le, [o(s, { label: "物料种类", prop: "basicClass" }, { default: n(() => [l("div", Ce, [i(l("span", null, null, 512), [[_, { e: e(F), v: e(a).purchaseType, extra: "：" }]]), i(l("span", null, null, 512), [[_, { e: e(R), v: e(a).basicClass, bit: true, split: " | " }]])])]), _: 1 }), e(a).basicClass & e(R).MATERIAL.V ? (r(), k(s, { key: 0, label: "辅材明细", prop: "auxMaterialNames", style: { width: "100%", "word-break": "break-all" } }, { default: n(() => [e(a).auxMaterialIds.includes(0) ? (r(), p("span", Ie, "所有辅材")) : i((r(), p("span", Ve, null, 512)), [[E, e(a).auxMaterialNames]])]), _: 1 })) : c("", true), e(a).basicClass & e(R).OTHER.V ? (r(), k(s, { key: 1, label: "其它明细", prop: "otherMaterialNames", style: { width: "100%", "word-break": "break-all" } }, { default: n(() => [e(a).otherMaterialIds.includes(0) ? (r(), p("span", Re, "所有其它科目")) : i((r(), p("span", Ae, null, 512)), [[E, e(a).otherMaterialNames]])]), _: 1 })) : c("", true), e(a).supplyType === e(U).SELF.V ? (r(), p(C, { key: 2 }, [o(s, { label: "合同量", prop: "mete" }, { default: n(() => [l("span", null, m(e(a).mete) + " " + m(e(a).meteUnit), 1)]), _: 1 }), o(s, { label: "合同额", prop: "amount" }, { default: n(() => [l("span", null, m(e(a).amount) + " 元", 1), t[2] || (t[2] = d(" 【")), i(l("span", null, null, 512), [[_, { e: e($), v: e(a).invoiceType }]]), e(a).invoiceType !== e($).RECEIPT.V ? (r(), p("span", je, "（" + m(e(a).taxRate) + "%）", 1)) : c("", true), t[3] || (t[3] = d("】 "))]), _: 1, __: [2, 3] }), o(s, { label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: n(() => [i(l("span", null, null, 512), [[_, { e: e(fe), v: e(a).purchaseOrderPaymentMode }]])]), _: 1 })], 64)) : c("", true), o(s, { prop: "weightMeasurementMode", label: "计量方式" }, { default: n(() => [i(l("span", null, null, 512), [[_, { e: e(_e), v: e(a).weightMeasurementMode }]])]), _: 1 }), o(s, { label: "物流信息", prop: "logistics" }, { default: n(() => [i(l("span", null, null, 512), [[_, { e: e(ye), v: e(a).logisticsTransportType }]]), t[4] || (t[4] = d(" （费用")), i(l("span", null, null, 512), [[_, { e: e(ve), v: e(a).logisticsPayerType }]]), t[5] || (t[5] = d("） "))]), _: 1, __: [4, 5] }), o(s, { label: "供应商", prop: "supplier" }, { default: n(() => [e(a).supplier ? (r(), p("span", Pe, m(e(a).supplier.name), 1)) : c("", true)]), _: 1 }), o(s, { label: "签订主体", prop: "branchCompanyName", style: { width: "100%" } }, { default: n(() => [e(a).branchCompany ? (r(), p("span", De, m(e(a).branchCompany.name), 1)) : c("", true)]), _: 1 }), o(s, { label: "创建人", prop: "applicantName" }, { default: n(() => [i((r(), p("span", null, [d(m(e(a).applicantName), 1)])), [[B]]), t[6] || (t[6] = d(" （创建时间：")), i(l("span", null, null, 512), [[O, e(a).createTime]]), t[7] || (t[7] = d("） "))]), _: 1, __: [6, 7] }), o(s, { label: "最后操作人", prop: "lastOperatorName" }, { default: n(() => [i((r(), p("span", null, [d(m(e(a).lastOperatorName), 1)])), [[B]]), t[8] || (t[8] = d(" （操作时间：")), i(l("span", null, null, 512), [[O, e(a).userUpdateTime]]), t[9] || (t[9] = d("） "))]), _: 1, __: [8, 9] }), o(s, { label: "备注", prop: "remark", style: { width: "100%" } }, { default: n(() => [l("span", Be, m(e(a).remark), 1)]), _: 1 }), o(s, { label: "关联项目", class: "el-form-item-4", prop: "projectIds", style: { width: "100%" } }, { default: n(() => [e(F).RAW_MATERIAL.V === e(a).purchaseType ? (r(), p("span", Oe, m(e(a).projects ? e(a).projects.map((f) => e(be)(f, null, false)).join(`
`) : ""), 1)) : c("", true)]), _: 1 }), o(u, null, { default: n(() => t[10] || (t[10] = [l("span", { class: "title" }, "附件", -1)])), _: 1, __: [10] }), o(he, { "show-download": "", showView: "", "file-classify": e(ge).PURCHASE_ORDER_ATT.V, files: e(a).attachments, "onUpdate:files": t[0] || (t[0] = (f) => e(a).attachments = f), uploadable: false, "empty-text": "暂未上传采购合同附件" }, null, 8, ["file-classify", "files"])]), j.value ? (r(), p(C, { key: 0 }, [t[12] || (t[12] = l("div", { class: "vertical-dashed-divider" }, null, -1)), l("div", He, [l("div", ze, [l("span", Fe, [t[11] || (t[11] = l("span", { class: "label" }, "关联备料单", -1)), (r(true), p(C, null, le(e(a).preparationSNList, (f) => (r(), k(g, { key: f, effect: y.value === f ? "dark" : "plain", class: "preparation-sn-tag", onClick: (qe) => Z(f) }, { default: n(() => [d(m(f), 1)]), _: 2 }, 1032, ["effect", "onClick"]))), 128))])]), o(b, { ref: "tableRef", data: W.value, "max-height": e(K) - 150, "default-expand-all": false, "highlight-current-row": "", "row-key": "id" }, { default: n(() => [o(x, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), y.value ? c("", true) : (r(), k(x, { key: "preparationSNList", "show-overflow-tooltip": "", prop: "preparationSNList", label: "备料单号", "min-width": "140px", fixed: "left" }, { default: n(({ row: f }) => [i(l("span", null, null, 512), [[E, f.preparationSNList]])]), _: 1 })), o(xe, { "spec-merge": "", fixed: "left", "show-index": false }), o(ke, { fixed: "left" }), o(we)]), _: 1 }, 8, ["data", "max-height"])])], 64)) : c("", true)], 4)]), _: 1 }, 8, ["model"])) : c("", true)])]), _: 2 }, [e(I)(e(a)) ? { name: "titleAfter", fn: n(() => [e(a).boolPartyA ? (r(), k(g, { key: 0, type: "danger", effect: "dark", size: "default" }, { default: n(() => t[1] || (t[1] = [d("甲供")])), _: 1, __: [1] })) : c("", true), o(g, { type: P.value ? "success" : e(a).boolUsed ? "warning" : "info", effect: P.value ? "dark" : "plain", size: "default" }, { default: n(() => [i(l("span", null, null, 512), [[_, { e: e(V), v: e(a).purchaseStatus }]]), e(a).boolUsed && e(a).purchaseStatus === e(V).UNFINISHED.V ? (r(), p("span", Te, " (有入库)")) : c("", true)]), _: 1 }, 8, ["type", "effect"]), i(o(g, { type: D.value ? "success" : "info", effect: D.value ? "dark" : "plain", size: "default" }, null, 8, ["type", "effect"]), [[_, { e: e(z), v: e(a).settlementStatus }]])]), key: "0" } : void 0]), 1032, ["visible", "content-loading", "before-close", "title", "size"]);
  };
} }, Je = ue(Ue, [["__scopeId", "data-v-bb5d52b8"]]);
export {
  Je as default
};
