import { inject as re } from "vue";
import { ref as v } from "vue";
import { computed as u } from "vue";
import { watch as ue } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as ce } from "vue";
import { openBlock as l } from "vue";
import { createBlock as c } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as I } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as d } from "vue";
import { isRef as b } from "vue";
import { createElementBlock as de } from "vue";
import { Fragment as me } from "vue";
import { createElementVNode as x } from "vue";
import { withDirectives as pe } from "vue";
import { ElTag as fe } from "element-plus";
import { ElTableColumn as ve } from "element-plus";
import { ElInput as _e } from "element-plus";
import { ElForm as he } from "element-plus";
import { _ as we, t as ge, jX as ye, bD as be, D as m, kc as xe, G as Ae, jZ as Ve, o as ke, u as Ne, AP as Ce, AQ as Te, AR as Re, AS as Ee, cO as Pe, jl as je, AH as Be, AK as Ie, bV as Fe, xn as Se, zr as Ue, jG as De, k5 as Le, jH as He, jI as $e, k6 as ze, yB as Me, ba as Ye, jN as qe } from "../../../../../../shared/runtime.js";
import { R as Oe } from "../../../../../../modules/review-convenient-operate-8438d44b.js";
import { _ as Ge } from "../../../../../../modules/review-confirm-button-aa3600ad.js";
import { u as Ke } from "../../../../../../modules/use-continuous-review-34fb5c14.js";
const Qe = { class: "remark" }, Xe = { __name: "review", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:modelValue"], setup(F, { emit: S }) {
  const { decimalPrecision: _ } = ge(), A = S, V = F, U = re("permission"), D = v(), i = v(false), k = v([]), L = u(() => R.value || T.value), p = v({}), e = v({}), H = u(() => [...ye, ["invoiceType", ["parse-enum", be, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", _.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", _.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", _.value.wms]], ["unitPriceNoFreight", ["to-thousand", _.value.wms]], ["amount", ["to-thousand", m.YUAN]], ["amountExcludingVAT", ["to-thousand", m.YUAN]], ["amountNoFreight", ["to-thousand", m.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", m.YUAN]], ["inputVAT", ["to-thousand", m.YUAN]], ["inputVATNoFreight", ["to-thousand", m.YUAN]], ["realTime", "parse-time"]]), { crud: $ } = xe(), f = u(() => e.value.purchaseOrder || {}), N = u(() => Ae(U.showAmount)), z = u(() => {
    var a;
    return ((a = f.value) == null ? void 0 : a.supplyType) === Ve.PARTY_A.V;
  }), M = u(() => i.value ? "退货单" : `退货单：${e.value.serialNumber}（ ${f.value.supplier ? f.value.supplier.name : ""} ）`), { maxHeight: Y } = ke({ mainBox: ".raw-mat-reject-application-review-form", extraBox: [".el-drawer__header", ".approval-comments", ".unfreeze-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => u(() => !i.value)), { visible: w, handleClose: C } = Ne({ emit: A, props: V, closeHook: ee }), { reviewNext: g, currentRecordId: h, pendingReviewIdList: y, operateRecordNumber: q, returnedLoading: T, passedLoading: R, reviewConvenientRef: O, reviewInit: G, detailInit: K, passed: Q, returned: X, handleConvenientChange: Z } = Ke({ detailMethod: E, passedMethod: () => Ce(p.value), returnedMethod: () => Te(p.value), pendingListMethod: () => Re($.query), detailInitCallBack: J, closeDlg: C });
  ue(() => V.data, async (a) => {
    K(), a && a.id && (h.value = a.id, i.value = true, G(), E(a.id));
  }, { immediate: true, deep: true });
  function J() {
    i.value = false, k.value = [];
  }
  async function E(a) {
    if (a) try {
      i.value = true;
      const s = await Ee(a);
      e.value = await W(s), p.value = { id: e.value.id };
    } catch (s) {
      console.log("加载失败", s);
    } finally {
      i.value = false;
    }
  }
  async function W(a) {
    return console.log(1111), await Pe(a.list), await je(a.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), a;
  }
  function ee() {
    q.value && A("refresh");
  }
  function ae(a) {
    return Ye(a, { props: ["quantity", ["mete", qe.weight.precision]] });
  }
  return (a, s) => {
    const P = fe, te = ve, se = j("common-table"), oe = _e, le = he, ne = j("common-drawer"), ie = ce("empty-text");
    return l(), c(ne, { ref_key: "drawerRef", ref: D, modelValue: t(w), "onUpdate:modelValue": s[3] || (s[3] = (r) => b(w) ? w.value = r : null), "before-close": t(C), "content-loading": i.value, "show-close": true, title: M.value, "custom-class": "raw-mat-reject-application-review-form", size: "100%" }, { titleAfter: n(() => [o(Be, { detail: e.value, order: f.value }, null, 8, ["detail", "order"]), e.value.rejectFreightType ? (l(), c(P, { key: 0 }, { default: n(() => [B(I(t(Ie).VL[e.value.rejectFreightType]), 1)]), _: 1 })) : d("", true), e.value.freight ? (l(), c(P, { key: 1, type: "warning" }, { default: n(() => [B("退运费金额:" + I(t(Fe)(e.value.freight, t(m).YUAN)), 1)]), _: 1 })) : d("", true)]), titleRight: n(() => [t(y) && t(y).length > 1 ? (l(), c(Oe, { key: 0, ref_key: "reviewConvenientRef", ref: O, modelValue: t(h), "onUpdate:modelValue": s[0] || (s[0] = (r) => b(h) ? h.value = r : null), consequent: t(g), "onUpdate:consequent": s[1] || (s[1] = (r) => b(g) ? g.value = r : null), list: t(y), class: "convenient-operation", onChange: t(Z) }, null, 8, ["modelValue", "consequent", "list", "onChange"])) : d("", true), N.value ? (l(), c(Se, { key: 1, "purchase-id": f.value.id, size: "default" }, null, 8, ["purchase-id"])) : d("", true), o(Ge, { "passed-fn": t(Q), "passed-loading": t(R), "returned-fn": t(X), "returned-loading": t(T) }, null, 8, ["passed-fn", "passed-loading", "returned-fn", "returned-loading"])]), content: n(() => [e.value.boolHasUnfreeze ? (l(), c(Ue, { key: 0, "basic-class": e.value.basicClass, list: e.value.unfreezeList, class: "unfreeze-info" }, null, 8, ["basic-class", "list"])) : d("", true), o(le, { disabled: L.value, model: p.value, class: "form" }, { default: n(() => [o(se, { data: e.value.list, "data-format": H.value, "expand-row-keys": k.value, "max-height": t(Y), "summary-method": ae, "row-key": "id", "show-summary": "" }, { default: n(() => [o(De, { "basic-class": e.value.basicClass }, { afterMaterialSn: n(() => [o(te, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), o(Le, { "basic-class": e.value.basicClass }, null, 8, ["basic-class"]), o(He, { "basic-class": e.value.basicClass }, null, 8, ["basic-class"]), N.value ? (l(), de(me, { key: 0 }, [z.value ? d("", true) : (l(), c($e, { key: 0 }))], 64)) : d("", true), o(ze, { "show-project": "", "show-monomer": false, "show-area": false }), o(Me, { label: "实际退货时间" })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), x("p", Qe, [s[4] || (s[4] = x("span", { class: "label-after" }, "备注", -1)), pe(x("span", null, null, 512), [[ie, e.value.remark]])]), o(oe, { modelValue: p.value.approvalComments, "onUpdate:modelValue": s[2] || (s[2] = (r) => p.value.approvalComments = r), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["disabled", "model"])]), _: 1 }, 8, ["modelValue", "before-close", "content-loading", "title"]);
  };
} }, ta = we(Xe, [["__scopeId", "data-v-5fc146e2"]]);
export {
  ta as default
};
