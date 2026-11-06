import { ref as c } from "vue";
import { computed as x } from "vue";
import { watch as re } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as M } from "vue";
import { createBlock as T } from "vue";
import { withCtx as d } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { isRef as V } from "vue";
import { createCommentVNode as A } from "vue";
import { normalizeClass as ue } from "vue";
import { ElTableColumn as ce } from "element-plus";
import { ElInput as de } from "element-plus";
import { ElForm as me } from "element-plus";
import { _ as pe, jX as fe, kc as be, o as ve, u as we, sQ as _e, A_ as ge, A$ as Ce, B0 as he, B1 as Ee, bl as r, i as P, cO as _, jl as g, iX as ye, B2 as Re, B3 as xe, aR as Me, jG as O, k5 as H, k6 as U, k4 as Te, ba as Ve } from "../../../../../../shared/runtime.js";
import { u as Le } from "../../../../../../modules/use-continuous-review-34fb5c14.js";
import ke from "./material-unit-quantity-columns/index.vue.js";
import { R as Se } from "../../../../../../modules/review-convenient-operate-8438d44b.js";
import { _ as Be } from "../../../../../../modules/review-confirm-button-aa3600ad.js";
import "./material-unit-quantity-columns/module/raw-mat.vue.js";
const Ie = { __name: "review", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:modelValue"], setup(q, { emit: j }) {
  const L = j, k = q, D = c(), m = c(false), v = c([]), F = x(() => I.value || B.value), C = c(), h = c({}), e = c(), z = c([...fe, ["remark", "empty-text"]]), { crud: K } = be(), { maxHeight: Q } = ve({ mainBox: ".raw-mat-return-application-review-form", extraBox: [".el-drawer__header", ".approval-comments"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => x(() => !m.value)), { visible: E, handleClose: S } = we({ emit: L, props: k, closeHook: ie }), { baseUnit: p } = _e(), { reviewNext: y, currentRecordId: w, pendingReviewIdList: R, operateRecordNumber: X, returnedLoading: B, passedLoading: I, reviewConvenientRef: G, reviewInit: J, detailInit: W, passed: Y, returned: Z, handleConvenientChange: ee } = Le({ detailMethod: N, passedMethod: () => ge(e.value), returnedMethod: () => Ce(e.value), pendingListMethod: () => he(K.query), detailInitCallBack: se, closeDlg: S }), ae = x(() => e.value && e.value.serialNumber ? `退库单：${e.value.serialNumber}` : "退库单");
  re(() => k.data, async (a) => {
    W(), a && a.id && (w.value = a.id, m.value = true, J(), N(a.id));
  }, { immediate: true, deep: true });
  function se() {
    m.value = false, v.value = [];
  }
  function te(a, l, u) {
    h.value = a, C.value = a.source;
  }
  async function N(a) {
    if (a) try {
      m.value = true;
      const l = await Ee(a);
      e.value = await le(l);
    } catch (l) {
      console.log("加载失败", l);
    } finally {
      m.value = false;
    }
  }
  async function le(a) {
    C.value = void 0, h.value = {};
    const l = [], u = [];
    (a.basicClass === r.STEEL_PLATE.V || a.basicClass & r.SECTION_STEEL.V) && a.list.forEach(async (s) => {
      if (s.boolReturns && P(s.list)) {
        await _(s.list);
        const f = await g(s.list, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] }), o = s.list.map((oe) => oe.source);
        await _(o);
        const i = await g(o, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] });
        l.push(f), u.push(i);
      }
    }), await Promise.all(u), await Promise.all(l), await _(a.list), await g(a.list, { toNum: true });
    const b = a.list.map((s) => s.source);
    return await _(b), await g(b, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete"] }), a.list.forEach((s) => {
      s.actualMete = s.mete;
    }), (a.basicClass === r.STEEL_PLATE.V || a.basicClass === r.SECTION_STEEL.V) && a.list.forEach(async (s) => {
      if (s.uid = s.id, s.boolReturns && P(s.list)) {
        let f = 0;
        s.list.forEach((o) => {
          o.pid = s.id, o.uid = o.id, o.singleReturnMete && (f += o.singleReturnMete);
        }), s.detailMete = ye(f, p.value[a.basicClass].weight.precision) * (s.quantity || 0), s.actualMete = s.detailMete;
      }
    }), a;
  }
  function ie() {
    X.value && L("refresh");
  }
  function ne(a) {
    var u;
    const l = e.value.basicClass && p.value && p.value[e.value.basicClass] ? (u = p.value[e.value.basicClass]) == null ? void 0 : u.measure.precision : 0;
    return Ve(a, { props: [["quantity", l], "actualMete", "mete"] });
  }
  return (a, l) => {
    const u = ce, b = $("common-table"), s = de, f = me, o = $("common-drawer");
    return M(), T(o, { ref_key: "drawerRef", ref: D, modelValue: t(E), "onUpdate:modelValue": l[4] || (l[4] = (i) => V(E) ? E.value = i : null), "content-loading": m.value, "before-close": t(S), title: ae.value, "show-close": true, size: "100%", "custom-class": "raw-mat-return-application-review-form" }, { titleAfter: d(() => [n(Re, { detail: e.value }, null, 8, ["detail"])]), titleRight: d(() => [t(R) && t(R).length > 1 ? (M(), T(Se, { key: 0, ref_key: "reviewConvenientRef", ref: G, modelValue: t(w), "onUpdate:modelValue": l[0] || (l[0] = (i) => V(w) ? w.value = i : null), consequent: t(y), "onUpdate:consequent": l[1] || (l[1] = (i) => V(y) ? y.value = i : null), list: t(R), onChange: t(ee), class: "convenient-operation" }, null, 8, ["modelValue", "consequent", "list", "onChange"])) : A("", true), n(Be, { "passed-loading": t(I), "returned-loading": t(B), "passed-fn": t(Y), "returned-fn": t(Z) }, null, 8, ["passed-loading", "returned-loading", "passed-fn", "returned-fn"])]), content: d(() => [n(f, { class: "form", disabled: F.value }, { default: d(() => [n(xe, { class: "material-info", "basic-class": e.value.basicClass, material: C.value }, null, 8, ["basic-class", "material"]), n(b, { ref: "tableRef", data: e.value.list, "data-format": z.value, "max-height": t(Q), "show-summary": "", "summary-method": ne, "default-expand-all": "", "expand-row-keys": v.value, "row-key": "id", "highlight-current-row": "", onRowClick: te }, { default: d(() => [n(Me, { data: e.value.list, "expand-row-keys": v.value, "onUpdate:expandRowKeys": l[2] || (l[2] = (i) => v.value = i), "row-key": "id", fixed: "left" }, { default: d(({ row: i }) => [(e.value.basicClass === t(r).STEEL_PLATE.V || e.value.basicClass === t(r).SECTION_STEEL.V) && i.boolReturns ? (M(), T(b, { class: ue(h.value.uid === i.uid ? "child-table" : ""), key: i.id, data: i.list, style: { margin: "10px 0" }, stripe: false }, { default: d(() => [n(O, { "basic-class": i.basicClass, fixed: "left" }, null, 8, ["basic-class"]), n(H, { "basic-class": i.basicClass }, null, 8, ["basic-class"]), n(u, { prop: "singleQuantity", align: "center", width: "110px", label: `数量 (${t(p)[e.value.basicClass].measure.unit})` }, null, 8, ["label"]), n(u, { key: "singleReturnMete", prop: "singleReturnMete", align: "center", label: `总重 (${t(p)[e.value.basicClass].weight.unit})`, width: "120px" }, null, 8, ["label"]), n(U)]), _: 2 }, 1032, ["class", "data"])) : A("", true), n(Te, { "basic-class": i.basicClass, row: i, "show-batch-no": false, "show-remark": "", "show-graphics": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["data", "expand-row-keys"]), n(O, { "basic-class": e.value.basicClass, showTip: e.value.basicClass === t(r).STEEL_PLATE.V || e.value.basicClass === t(r).SECTION_STEEL.V, fixed: "left" }, null, 8, ["basic-class", "showTip"]), n(H, { "basic-class": e.value.basicClass }, null, 8, ["basic-class"]), n(ke, { showTip: e.value.basicClass === t(r).STEEL_PLATE.V || e.value.basicClass === t(r).SECTION_STEEL.V, "basic-class": e.value.basicClass }, null, 8, ["showTip", "basic-class"]), n(U, { "show-project": "", "show-monomer": false, "show-area": false })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"]), n(s, { class: "approval-comments", modelValue: e.value.approvalComments, "onUpdate:modelValue": l[3] || (l[3] = (i) => e.value.approvalComments = i), rows: 2, maxlength: "1000", type: "textarea", "show-word-limit": "", placeholder: "审核意见", style: { "margin-top": "5px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["disabled"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, qe = pe(Ie, [["__scopeId", "data-v-435a4a74"]]);
export {
  qe as default
};
