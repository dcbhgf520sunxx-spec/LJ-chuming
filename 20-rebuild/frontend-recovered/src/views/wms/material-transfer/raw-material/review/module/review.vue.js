import { ElMessage as be } from "element-plus";
import { ref as n } from "vue";
import { computed as _ } from "vue";
import { nextTick as ge } from "vue";
import { watch as xe } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as Te } from "vue";
import { openBlock as u } from "vue";
import { createBlock as y } from "vue";
import { withCtx as d } from "vue";
import { createVNode as o } from "vue";
import { createCommentVNode as T } from "vue";
import { unref as h } from "vue";
import { createElementVNode as Y } from "vue";
import { createTextVNode as V } from "vue";
import { withDirectives as q } from "vue";
import { createElementBlock as P } from "vue";
import { toDisplayString as K } from "vue";
import { isRef as he } from "vue";
import { ElTableColumn as Re } from "element-plus";
import { ElFormItem as ke } from "element-plus";
import { ElInput as Ce } from "element-plus";
import { ElForm as Ve } from "element-plus";
import { zl as Ae, zm as Be, zn as L, fK as Ne, _ as Ie, t as Ee, jX as Ue, bD as O, D as A, kc as Pe, o as Le, u as Se, Ba as De, Bb as G, cO as ze, jl as X, zd as Fe, Bc as He, zr as Me, aR as $e, k4 as je, jG as Ye, jH as qe, k5 as Ke, k6 as Oe, yB as Ge, bG as Xe, V as Je, Bd as Qe, Be as We, ba as Ze, jN as ea, i as aa } from "../../../../../../shared/runtime.js";
import { R as ta } from "../../../../../../modules/review-convenient-operate-8438d44b.js";
import { _ as la } from "../../../../../../modules/review-confirm-button-aa3600ad.js";
import sa from "./set-party-a-info.vue.js";
function na() {
  const r = (s, w) => w.boolPartyA && w.partyATransferType === L.BUY_IN.V ? !!s : true, m = { unitPrice: [{ validator: r, message: "请填写单价", trigger: "blur" }], amount: [{ validator: r, message: "请填写金额", trigger: "blur" }] };
  return { tableValidate: (s) => oa(s, m), wrongCellMask: (s) => Ae(s, m), cleanUpData: (s) => Be(s) };
}
function oa(r, m) {
  let s = true;
  if (r.filter((v) => v.boolPartyA && v.partyATransferType === L.BUY_IN.V).length === 0) return { dealList: r, validResult: s };
  const R = "请填写“买入甲供物料”的金额";
  for (const v in r) {
    const f = r[v];
    delete f.verify, f.verify = {};
    for (const c in m) f.verify[c] = Ne(c, m[c], f), f.verify[c] || (s = false);
  }
  return s || be({ message: R, type: "error" }), { dealList: r, validResult: s };
}
const ia = { key: 1 }, ra = { class: "flex-rss footer-info" }, ua = { __name: "review", props: { visible: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:visible"], setup(r, { emit: m }) {
  const { decimalPrecision: s } = Ee(), w = m, R = r, v = n(), f = n(), c = n(), p = n(false), b = n(false), g = n(false), k = n([]), a = n({}), S = n(0), B = n(false), C = n([]), N = n(), x = n(false), J = _(() => [...Ue, ["invoiceType", ["parse-enum", O, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", s.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", s.value.wms]], ["amount", ["to-thousand", A.YUAN]], ["amountExcludingVAT", ["to-thousand", A.YUAN]], ["inputVAT", ["to-thousand", A.YUAN]], ["realTime", "parse-time"]]), Q = _(() => b.value || g.value), W = _(() => p.value ? "调拨单：" : `调拨单：${a.value.serialNumber || ""}`), { crud: Z } = Pe(), { maxHeight: ee } = Le({ mainBox: ".raw-mat-transfer-application-review-form", extraBox: [".el-drawer__header", ".approval-comments", ".unfreeze-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => _(() => !p.value)), { visible: I, handleClose: E } = Se({ emit: w, props: R, field: "visible", showHook: ve, closeHook: me }), { tableValidate: ae, cleanUpData: D, wrongCellMask: te } = na(), z = _(() => a.value.list.some((e) => e.boolPartyA && e.partyATransferType === L.BUY_IN.V)), le = { invoiceType: [{ required: true, validator: (e, t, i) => {
    a.value.invoiceType || a.value.invoiceType === 0 ? a.value.invoiceType === O.SPECIAL.V && !aa(a.value.taxRate) ? i(new Error("请选择税率")) : i() : i(new Error("请选择发票及税率"));
  }, trigger: "change" }] }, se = _(() => (ge(() => {
    c.value && c.value.clearValidate();
  }), z.value ? le : {}));
  xe(() => R.data, async (e) => {
    F(), e && e.id && (N.value = e.id, p.value = true, await oe(), H(e.id));
  }, { immediate: true, deep: true });
  function F() {
    p.value = false, g.value = false, b.value = false, k.value = [], a.value = {};
  }
  function ne(e) {
    F(), H(e);
  }
  async function oe() {
    C.value = await De(Z.query);
  }
  async function H(e) {
    if (e) try {
      p.value = true;
      const t = await G(e);
      t.logistics = {}, a.value = await ie(t);
    } catch (t) {
      console.log("加载失败", t);
    } finally {
      p.value = false;
    }
  }
  async function ie(e) {
    if (await ze(e.list), e.list = await X(e.list, { toSmallest: false, toNum: true }), e.transferType !== Fe.RETURN_PARTY_A.V) {
      let t = 0;
      e.list.forEach((i) => {
        i.boolPartyA && t++;
      }), x.value = t > 0;
    } else x.value = false;
    return e;
  }
  async function re(e) {
    const { validResult: t, dealList: i } = ae(e.list);
    t && (e.list = i);
    const U = await c.value.validate();
    return t && U;
  }
  async function ue(e) {
    return D(e.list), e.list = await X(e.list, { toSmallest: true, toNum: true }), e;
  }
  async function ce() {
    try {
      if (b.value = true, !await re(a.value)) return;
      const t = Je(a.value), i = await ue(t);
      await Qe(i), M();
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      b.value = false;
    }
  }
  async function de() {
    try {
      g.value = true;
      const e = { id: a.value.id, approvalComments: a.value.approvalComments };
      await We(e), M();
    } catch (e) {
      console.log("退回", e);
    } finally {
      g.value = false;
    }
  }
  function M() {
    try {
      ++S.value, B.value && v.value ? v.value.removeCurrent() : E();
    } catch (e) {
      console.log("审核提交后", e), E();
    }
  }
  function ve() {
    a.value && a.value.list && D(a.value.list);
  }
  function me() {
    S.value && w("refresh");
  }
  function fe(e) {
    return Ze(e, { props: ["quantity", ["mete", ea.weight.precision], ["amount", A.YUAN]], toThousandFields: ["mete", "amount"] });
  }
  return (e, t) => {
    const i = Re, U = j("common-table"), pe = ke, ye = Ce, we = Ve, _e = j("common-drawer"), $ = Te("empty-text");
    return u(), y(_e, { ref_key: "drawerRef", ref: f, modelValue: h(I), "onUpdate:modelValue": t[6] || (t[6] = (l) => he(I) ? I.value = l : null), "before-close": h(E), "content-loading": p.value, "show-close": true, title: W.value, "custom-class": "raw-mat-transfer-application-review-form", size: "100%" }, { titleAfter: d(() => [o(He, { detail: a.value }, null, 8, ["detail"])]), titleRight: d(() => [C.value && C.value.length > 1 ? (u(), y(ta, { key: 0, ref_key: "reviewConvenientRef", ref: v, modelValue: N.value, "onUpdate:modelValue": t[0] || (t[0] = (l) => N.value = l), consequent: B.value, "onUpdate:consequent": t[1] || (t[1] = (l) => B.value = l), list: C.value, class: "convenient-operation", onChange: ne }, null, 8, ["modelValue", "consequent", "list"])) : T("", true), o(la, { "passed-fn": ce, "passed-loading": b.value, "returned-fn": de, "returned-loading": g.value }, null, 8, ["passed-loading", "returned-loading"])]), content: d(() => [o(we, { ref_key: "formRef", ref: c, disabled: Q.value, model: a.value, rules: se.value, class: "form", "label-position": "left", size: "default" }, { default: d(() => [a.value.boolHasUnfreeze ? (u(), y(Me, { key: 0, "basic-class": a.value.basicClass, list: a.value.unfreezeList, class: "unfreeze-info" }, null, 8, ["basic-class", "list"])) : T("", true), o(U, { "cell-class-name": h(te), data: a.value.list, "data-format": J.value, "expand-row-keys": k.value, "max-height": h(ee), "summary-method": fe, "row-key": "id", "show-summary": "" }, { default: d(() => [o($e, { "expand-row-keys": k.value, "onUpdate:expandRowKeys": t[2] || (t[2] = (l) => k.value = l), data: a.value.list, fixed: "left", "row-key": "id" }, { default: d(({ row: l }) => [x.value ? (u(), y(je, { key: 0, "basic-class": h(G).basicClass, row: l, "show-brand": "" }, { default: d(() => [Y("p", null, [t[7] || (t[7] = V(" 备注：")), q((u(), P("span", null, [V(K(l.remark), 1)])), [[$]])])]), _: 2 }, 1032, ["basic-class", "row"])) : (u(), P("p", ia, [t[8] || (t[8] = V(" 备注：")), q((u(), P("span", null, [V(K(l.remark), 1)])), [[$]])]))]), _: 1 }, 8, ["expand-row-keys", "data"]), o(Ye, { "basic-class": a.value.basicClass, fixed: "left" }, { afterMaterialSn: d(() => [o(i, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), o(qe, { "basic-class": a.value.basicClass }, null, 8, ["basic-class"]), x.value ? T("", true) : (u(), y(Ke, { key: 0, "basic-class": a.value.basicClass }, null, 8, ["basic-class"])), x.value && a.value && a.value.list ? (u(), y(sa, { key: 1, form: a.value }, null, 8, ["form"])) : T("", true), o(Oe, { "show-project": "", "show-monomer": "", "show-area": "" }), o(Ge, { label: "实际调拨时间" })]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"]), Y("div", ra, [z.value ? (u(), y(pe, { key: 0, class: "invoice-type-item", label: "发票及税率", "label-width": "95px", prop: "invoiceType" }, { default: d(() => [o(Xe, { invoiceType: a.value.invoiceType, "onUpdate:invoiceType": t[3] || (t[3] = (l) => a.value.invoiceType = l), taxRate: a.value.taxRate, "onUpdate:taxRate": t[4] || (t[4] = (l) => a.value.taxRate = l), classification: a.value.basicClass, class: "input-underline", default: "" }, null, 8, ["invoiceType", "taxRate", "classification"])]), _: 1 })) : T("", true), o(ye, { modelValue: a.value.approvalComments, "onUpdate:modelValue": t[5] || (t[5] = (l) => a.value.approvalComments = l), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])])]), _: 1 }, 8, ["disabled", "model", "rules"])]), _: 1 }, 8, ["modelValue", "before-close", "content-loading", "title"]);
  };
} }, ya = Ie(ua, [["__scopeId", "data-v-86038ce9"]]);
export {
  ya as default
};
