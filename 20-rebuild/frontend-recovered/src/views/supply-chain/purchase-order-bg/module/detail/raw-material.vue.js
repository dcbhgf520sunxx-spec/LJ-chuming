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
import { createVNode as i } from "vue";
import { withDirectives as o } from "vue";
import { createElementVNode as l } from "vue";
import { createElementBlock as p } from "vue";
import { normalizeStyle as se } from "vue";
import { Fragment as C } from "vue";
import { toDisplayString as m } from "vue";
import { renderList as le } from "vue";
import { ElTag as ne } from "element-plus";
import { ElFormItem as re } from "element-plus";
import { ElDivider as ie } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
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
    const g = ne, s = re, u = ie, x = oe, b = H("common-table"), Q = pe, X = H("common-drawer"), _ = S("parse-enum"), E = S("split"), B = S("empty-text"), O = S("parse-time");
    return r(), k(X, { ref: "drawerRef", "before-close": e(M).cancelDetail, "content-loading": !e(T) || e(M).detailLoading, "show-close": true, size: j.value ? "100%" : "720px", title: J.value, visible: e(M).detailVisible, "custom-class": "purchase-order-raw-mat-detail" }, te({ content: n(() => [l("div", Ee, [e(I)(e(a)) ? (r(), k(Q, { key: 0, model: e(a), "label-position": "left", "label-width": "100px", size: "default" }, { default: n(() => [l("div", { style: se(e(G)), class: "form-content" }, [l("div", Le, [i(s, { label: "物料种类", prop: "basicClass" }, { default: n(() => [l("div", Ce, [o(l("span", null, null, 512), [[_, { e: e(F), v: e(a).purchaseType, extra: "：" }]]), o(l("span", null, null, 512), [[_, { e: e(R), v: e(a).basicClass, bit: true, split: " | " }]])])]), _: 1 }), e(a).basicClass & e(R).MATERIAL.V ? (r(), k(s, { key: 0, label: "辅材明细", prop: "auxMaterialNames", style: { width: "100%", "word-break": "break-all" } }, { default: n(() => [e(a).auxMaterialIds.includes(0) ? (r(), p("span", Ie, "所有辅材")) : o((r(), p("span", Ve, null, 512)), [[E, e(a).auxMaterialNames]])]), _: 1 })) : c("", true), e(a).basicClass & e(R).OTHER.V ? (r(), k(s, { key: 1, label: "其它明细", prop: "otherMaterialNames", style: { width: "100%", "word-break": "break-all" } }, { default: n(() => [e(a).otherMaterialIds.includes(0) ? (r(), p("span", Re, "所有其它科目")) : o((r(), p("span", Ae, null, 512)), [[E, e(a).otherMaterialNames]])]), _: 1 })) : c("", true), e(a).supplyType === e(U).SELF.V ? (r(), p(C, { key: 2 }, [i(s, { label: "合同量", prop: "mete" }, { default: n(() => [l("span", null, m(e(a).mete) + " " + m(e(a).meteUnit), 1)]), _: 1 }), i(s, { label: "合同额", prop: "amount" }, { default: n(() => [l("span", null, m(e(a).amount) + " 元", 1), t[2] || (t[2] = d(" 【")), o(l("span", null, null, 512), [[_, { e: e($), v: e(a).invoiceType }]]), e(a).invoiceType !== e($).RECEIPT.V ? (r(), p("span", je, "（" + m(e(a).taxRate) + "%）", 1)) : c("", true), t[3] || (t[3] = d("】 "))]), _: 1, __: [2, 3] }), i(s, { label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: n(() => [o(l("span", null, null, 512), [[_, { e: e(fe), v: e(a).purchaseOrderPaymentMode }]])]), _: 1 })], 64)) : c("", true), i(s, { label: "计量方式", prop: "weightMeasurementMode" }, { default: n(() => [o(l("span", null, null, 512), [[_, { e: e(_e), v: e(a).weightMeasurementMode }]])]), _: 1 }), i(s, { label: "物流信息", prop: "logistics" }, { default: n(() => [o(l("span", null, null, 512), [[_, { e: e(ye), v: e(a).logisticsTransportType }]]), t[4] || (t[4] = d(" （费用")), o(l("span", null, null, 512), [[_, { e: e(ve), v: e(a).logisticsPayerType }]]), t[5] || (t[5] = d("） "))]), _: 1, __: [4, 5] }), i(s, { label: "供应商", prop: "supplier" }, { default: n(() => [e(a).supplier ? (r(), p("span", Pe, m(e(a).supplier.name), 1)) : c("", true)]), _: 1 }), i(s, { label: "签订主体", prop: "branchCompanyName", style: { width: "100%" } }, { default: n(() => [e(a).branchCompany ? (r(), p("span", De, m(e(a).branchCompany.name), 1)) : c("", true)]), _: 1 }), i(s, { label: "创建人", prop: "applicantName" }, { default: n(() => [o((r(), p("span", null, [d(m(e(a).applicantName), 1)])), [[B]]), t[6] || (t[6] = d(" （创建时间：")), o(l("span", null, null, 512), [[O, e(a).createTime]]), t[7] || (t[7] = d("） "))]), _: 1, __: [6, 7] }), i(s, { label: "最后操作人", prop: "lastOperatorName" }, { default: n(() => [o((r(), p("span", null, [d(m(e(a).lastOperatorName), 1)])), [[B]]), t[8] || (t[8] = d(" （操作时间：")), o(l("span", null, null, 512), [[O, e(a).userUpdateTime]]), t[9] || (t[9] = d("） "))]), _: 1, __: [8, 9] }), i(s, { label: "备注", prop: "remark", style: { width: "100%" } }, { default: n(() => [l("span", Be, m(e(a).remark), 1)]), _: 1 }), i(s, { class: "el-form-item-4", label: "关联项目", prop: "projectIds", style: { width: "100%" } }, { default: n(() => [e(F).RAW_MATERIAL.V === e(a).purchaseType ? (r(), p("span", Oe, m(e(a).projects ? e(a).projects.map((f) => e(be)(f, null, false)).join(`
`) : ""), 1)) : c("", true)]), _: 1 }), i(u, null, { default: n(() => t[10] || (t[10] = [l("span", { class: "title" }, "附件", -1)])), _: 1, __: [10] }), i(he, { files: e(a).attachments, "onUpdate:files": t[0] || (t[0] = (f) => e(a).attachments = f), "file-classify": e(ge).PURCHASE_ORDER_ATT.V, uploadable: false, showView: true, "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])]), j.value ? (r(), p(C, { key: 0 }, [t[12] || (t[12] = l("div", { class: "vertical-dashed-divider" }, null, -1)), l("div", He, [l("div", ze, [l("span", Fe, [t[11] || (t[11] = l("span", { class: "label" }, "关联备料单", -1)), (r(true), p(C, null, le(e(a).preparationSNList, (f) => (r(), k(g, { key: f, effect: y.value === f ? "dark" : "plain", class: "preparation-sn-tag", onClick: (qe) => Z(f) }, { default: n(() => [d(m(f), 1)]), _: 2 }, 1032, ["effect", "onClick"]))), 128))])]), i(b, { ref: "tableRef", data: W.value, "default-expand-all": false, "max-height": e(K) - 150, "highlight-current-row": "", "row-key": "id" }, { default: n(() => [i(x, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), y.value ? c("", true) : (r(), k(x, { key: "preparationSNList", fixed: "left", label: "备料单号", "min-width": "140px", prop: "preparationSNList", "show-overflow-tooltip": "" }, { default: n(({ row: f }) => [o(l("span", null, null, 512), [[E, f.preparationSNList]])]), _: 1 })), i(xe, { "show-index": false, specificationLable: "型号", fixed: "left", "spec-merge": "" }), i(ke, { fixed: "left" }), i(we)]), _: 1 }, 8, ["data", "max-height"])])], 64)) : c("", true)], 4)]), _: 1 }, 8, ["model"])) : c("", true)])]), _: 2 }, [e(I)(e(a)) ? { name: "titleAfter", fn: n(() => [e(a).boolPartyA ? (r(), k(g, { key: 0, effect: "dark", size: "default", type: "danger" }, { default: n(() => t[1] || (t[1] = [d("甲供")])), _: 1, __: [1] })) : c("", true), i(g, { effect: P.value ? "dark" : "plain", type: P.value ? "success" : e(a).boolUsed ? "warning" : "info", size: "default" }, { default: n(() => [o(l("span", null, null, 512), [[_, { e: e(V), v: e(a).purchaseStatus }]]), e(a).boolUsed && e(a).purchaseStatus === e(V).UNFINISHED.V ? (r(), p("span", Te, " (有入库)")) : c("", true)]), _: 1 }, 8, ["effect", "type"]), o(i(g, { effect: D.value ? "dark" : "plain", type: D.value ? "success" : "info", size: "default" }, null, 8, ["effect", "type"]), [[_, { e: e(z), v: e(a).settlementStatus }]])]), key: "0" } : void 0]), 1032, ["before-close", "content-loading", "size", "title", "visible"]);
  };
} }, Je = ue(Ue, [["__scopeId", "data-v-1f712bc2"]]);
export {
  Je as default
};
