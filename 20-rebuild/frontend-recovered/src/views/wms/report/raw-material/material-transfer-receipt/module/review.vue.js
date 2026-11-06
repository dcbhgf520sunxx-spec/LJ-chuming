import { ElMessage as be } from "element-plus";
import { ref as n } from "vue";
import { computed as b } from "vue";
import { nextTick as _e } from "vue";
import { watch as ge } from "vue";
import { resolveComponent as $ } from "vue";
import { resolveDirective as xe } from "vue";
import { openBlock as r } from "vue";
import { createBlock as y } from "vue";
import { withCtx as v } from "vue";
import { createVNode as u } from "vue";
import { createCommentVNode as R } from "vue";
import { unref as T } from "vue";
import { createElementVNode as j } from "vue";
import { createTextVNode as V } from "vue";
import { withDirectives as q } from "vue";
import { createElementBlock as E } from "vue";
import { toDisplayString as K } from "vue";
import { isRef as Re } from "vue";
import { ElFormItem as Te } from "element-plus";
import { ElInput as he } from "element-plus";
import { ElForm as ke } from "element-plus";
import { zl as Ce, zm as Ve, zn as L, fK as Ae, _ as Be, t as Ie, jX as Ne, bD as O, D as A, kc as Ue, o as Pe, u as Ee, Ba as Le, Bb as G, cO as De, jl as X, zd as ze, zr as Fe, aR as He, k4 as Se, jG as Me, jH as Ye, k5 as $e, k6 as je, bG as qe, V as Ke, Bd as Oe, Be as Ge, ba as Xe, i as Je } from "../../../../../../shared/runtime.js";
import { R as Qe } from "../../../../../../modules/review-convenient-operate-8438d44b.js";
import { _ as We } from "../../../../../../modules/review-confirm-button-aa3600ad.js";
import Ze from "./common-title-info.vue.js";
import ea from "./set-party-a-info.vue.js";
function aa() {
  const i = (s, w) => w.boolPartyA && w.partyATransferType === L.BUY_IN.V ? !!s : true, m = { unitPrice: [{ validator: i, message: "请填写单价", trigger: "blur" }], amount: [{ validator: i, message: "请填写金额", trigger: "blur" }] };
  return { tableValidate: (s) => ta(s, m), wrongCellMask: (s) => Ce(s, m), cleanUpData: (s) => Ve(s) };
}
function ta(i, m) {
  let s = true;
  if (i.filter((d) => d.boolPartyA && d.partyATransferType === L.BUY_IN.V).length === 0) return { dealList: i, validResult: s };
  const h = "请填写“买入甲供物料”的金额";
  for (const d in i) {
    const f = i[d];
    delete f.verify, f.verify = {};
    for (const c in m) f.verify[c] = Ae(c, m[c], f), f.verify[c] || (s = false);
  }
  return s || be({ message: h, type: "error" }), { dealList: i, validResult: s };
}
const la = { key: 1 }, sa = { class: "flex-rss footer-info" }, na = { __name: "review", props: { visible: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:visible"], setup(i, { emit: m }) {
  const { decimalPrecision: s } = Ie(), w = m, h = i, d = n(), f = n(), c = n(), p = n(false), _ = n(false), g = n(false), k = n([]), a = n({}), D = n(0), B = n(false), C = n([]), I = n(), x = n(false), J = b(() => [...Ne, ["invoiceType", ["parse-enum", O, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", s.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", s.value.wms]], ["amount", ["to-thousand", A.YUAN]], ["amountExcludingVAT", ["to-thousand", A.YUAN]], ["inputVAT", ["to-thousand", A.YUAN]]]), Q = b(() => _.value || g.value), W = b(() => p.value ? "调拨单：" : `调拨单：${a.value.serialNumber || ""}`), { crud: Z } = Ue(), { maxHeight: ee } = Pe({ mainBox: ".raw-mat-transfer-application-review-form", extraBox: [".el-drawer__header", ".approval-comments", ".unfreeze-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => b(() => !p.value)), { visible: N, handleClose: U } = Ee({ emit: w, props: h, field: "visible", showHook: ve, closeHook: me }), { tableValidate: ae, cleanUpData: z, wrongCellMask: te } = aa(), F = b(() => a.value.list.some((e) => e.boolPartyA && e.partyATransferType === L.BUY_IN.V)), le = { invoiceType: [{ required: true, validator: (e, t, o) => {
    if (a.value.invoiceType || a.value.invoiceType === 0) if (a.value.invoiceType === O.SPECIAL.V && !Je(a.value.taxRate)) {
      o(new Error("请选择税率"));
      return;
    } else o();
    else {
      o(new Error("请选择发票及税率"));
      return;
    }
  }, trigger: "change" }] }, se = b(() => (_e(() => {
    c.value && c.value.clearValidate();
  }), F.value ? le : {}));
  ge(() => h.data, async (e) => {
    H(), e && e.id && (I.value = e.id, p.value = true, await oe(), S(e.id));
  }, { immediate: true, deep: true });
  function H() {
    p.value = false, g.value = false, _.value = false, k.value = [], a.value = {};
  }
  function ne(e) {
    H(), S(e);
  }
  async function oe() {
    C.value = await Le(Z.query);
  }
  async function S(e) {
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
    if (await De(e.list), e.list = await X(e.list, { toSmallest: false, toNum: true }), e.transferType !== ze.RETURN_PARTY_A.V) {
      let t = 0;
      e.list.forEach((o) => {
        o.boolPartyA && t++;
      }), x.value = t > 0;
    } else x.value = false;
    return e;
  }
  async function re(e) {
    const { validResult: t, dealList: o } = ae(e.list);
    t && (e.list = o);
    const P = await c.value.validate();
    return t && P;
  }
  async function ue(e) {
    return z(e.list), e.list = await X(e.list, { toSmallest: true, toNum: true }), e;
  }
  async function ce() {
    try {
      if (_.value = true, !await re(a.value)) return;
      const t = Ke(a.value), o = await ue(t);
      await Oe(o), M();
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      _.value = false;
    }
  }
  async function de() {
    try {
      g.value = true;
      const e = { id: a.value.id, approvalComments: a.value.approvalComments };
      await Ge(e), M();
    } catch (e) {
      console.log("退回", e);
    } finally {
      g.value = false;
    }
  }
  function M() {
    try {
      ++D.value, B.value && d.value ? d.value.removeCurrent() : U();
    } catch (e) {
      console.log("审核提交后", e), U();
    }
  }
  function ve() {
    a.value && a.value.list && z(a.value.list);
  }
  function me() {
    D.value && w("refresh");
  }
  function fe(e) {
    return Xe(e, { props: ["quantity", "mete", ["amount", A.YUAN]], toThousandFields: ["mete", "amount"] });
  }
  return (e, t) => {
    const o = $("common-table"), P = Te, pe = he, ye = ke, we = $("common-drawer"), Y = xe("empty-text");
    return r(), y(we, { ref_key: "drawerRef", ref: f, modelValue: T(N), "onUpdate:modelValue": t[6] || (t[6] = (l) => Re(N) ? N.value = l : null), "content-loading": p.value, "before-close": T(U), title: W.value, "show-close": true, size: "100%", "custom-class": "raw-mat-transfer-application-review-form" }, { titleAfter: v(() => [u(Ze, { detail: a.value }, null, 8, ["detail"])]), titleRight: v(() => [C.value && C.value.length > 1 ? (r(), y(Qe, { key: 0, ref_key: "reviewConvenientRef", ref: d, modelValue: I.value, "onUpdate:modelValue": t[0] || (t[0] = (l) => I.value = l), consequent: B.value, "onUpdate:consequent": t[1] || (t[1] = (l) => B.value = l), list: C.value, onChange: ne, class: "convenient-operation" }, null, 8, ["modelValue", "consequent", "list"])) : R("", true), u(We, { "passed-loading": _.value, "returned-loading": g.value, "passed-fn": ce, "returned-fn": de }, null, 8, ["passed-loading", "returned-loading"])]), content: v(() => [u(ye, { ref_key: "formRef", ref: c, class: "form", model: a.value, rules: se.value, disabled: Q.value, "label-position": "left", size: "default" }, { default: v(() => [a.value.boolHasUnfreeze ? (r(), y(Fe, { key: 0, class: "unfreeze-info", "basic-class": a.value.basicClass, list: a.value.unfreezeList }, null, 8, ["basic-class", "list"])) : R("", true), u(o, { data: a.value.list, "data-format": J.value, "max-height": T(ee), "show-summary": "", "cell-class-name": T(te), "summary-method": fe, "expand-row-keys": k.value, "row-key": "id" }, { default: v(() => [u(He, { data: a.value.list, "expand-row-keys": k.value, "onUpdate:expandRowKeys": t[2] || (t[2] = (l) => k.value = l), "row-key": "id", fixed: "left" }, { default: v(({ row: l }) => [x.value ? (r(), y(Se, { key: 0, "basic-class": T(G).basicClass, row: l, "show-brand": "" }, { default: v(() => [j("p", null, [t[7] || (t[7] = V(" 备注：")), q((r(), E("span", null, [V(K(l.remark), 1)])), [[Y]])])]), _: 2 }, 1032, ["basic-class", "row"])) : (r(), E("p", la, [t[8] || (t[8] = V(" 备注：")), q((r(), E("span", null, [V(K(l.remark), 1)])), [[Y]])]))]), _: 1 }, 8, ["data", "expand-row-keys"]), u(Me, { "basic-class": a.value.basicClass, fixed: "left" }, null, 8, ["basic-class"]), u(Ye, { "basic-class": a.value.basicClass }, null, 8, ["basic-class"]), x.value ? R("", true) : (r(), y($e, { key: 0, "basic-class": a.value.basicClass }, null, 8, ["basic-class"])), x.value && a.value && a.value.list ? (r(), y(ea, { key: 1, form: a.value }, null, 8, ["form"])) : R("", true), u(je, { "show-project": "", "show-monomer": "", "show-area": "" })]), _: 1 }, 8, ["data", "data-format", "max-height", "cell-class-name", "expand-row-keys"]), j("div", sa, [F.value ? (r(), y(P, { key: 0, class: "invoice-type-item", label: "发票及税率", prop: "invoiceType", "label-width": "95px" }, { default: v(() => [u(qe, { class: "input-underline", invoiceType: a.value.invoiceType, "onUpdate:invoiceType": t[3] || (t[3] = (l) => a.value.invoiceType = l), taxRate: a.value.taxRate, "onUpdate:taxRate": t[4] || (t[4] = (l) => a.value.taxRate = l), classification: a.value.basicClass, default: "" }, null, 8, ["invoiceType", "taxRate", "classification"])]), _: 1 })) : R("", true), u(pe, { class: "approval-comments", modelValue: a.value.approvalComments, "onUpdate:modelValue": t[5] || (t[5] = (l) => a.value.approvalComments = l), rows: 2, maxlength: "1000", type: "textarea", "show-word-limit": "", placeholder: "审核意见", style: { "margin-top": "5px" } }, null, 8, ["modelValue"])])]), _: 1 }, 8, ["model", "rules", "disabled"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, ma = Be(na, [["__scopeId", "data-v-6bb84d3d"]]);
export {
  ma as default
};
