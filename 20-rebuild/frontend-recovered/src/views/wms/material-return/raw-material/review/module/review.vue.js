import { ref as d } from "vue";
import { computed as x } from "vue";
import { watch as re } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as M } from "vue";
import { createBlock as T } from "vue";
import { withCtx as c } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { isRef as S } from "vue";
import { createCommentVNode as A } from "vue";
import { normalizeClass as ue } from "vue";
import { ElTableColumn as ce } from "element-plus";
import { ElInput as de } from "element-plus";
import { ElForm as me } from "element-plus";
import { _ as pe, jX as fe, kc as be, o as we, u as ve, sQ as _e, A_ as he, A$ as ge, B0 as Ce, B1 as Ee, bl as u, i as P, cO as _, jl as h, iX as ye, B2 as Re, B3 as xe, aR as Me, jG as O, k5 as U, k6 as H, k4 as Te, B4 as Se, yB as Le, ba as Ve, jN as ke } from "../../../../../../shared/runtime.js";
import { u as Ne } from "../../../../../../modules/use-continuous-review-34fb5c14.js";
import { R as Be } from "../../../../../../modules/review-convenient-operate-8438d44b.js";
import { _ as Ie } from "../../../../../../modules/review-confirm-button-aa3600ad.js";
const $e = { __name: "review", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:modelValue"], setup(j, { emit: q }) {
  const L = q, V = j, D = d(), m = d(false), w = d([]), F = x(() => B.value || N.value), g = d(), C = d({}), e = d(), z = d([...fe, ["remark", "empty-text"], ["realTime", "parse-time"]]), { crud: K } = be(), { maxHeight: Q } = we({ mainBox: ".raw-mat-return-application-review-form", extraBox: [".el-drawer__header", ".approval-comments"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => x(() => !m.value)), { visible: E, handleClose: k } = ve({ emit: L, props: V, closeHook: ie }), { baseUnit: p } = _e(), { reviewNext: y, currentRecordId: v, pendingReviewIdList: R, operateRecordNumber: X, returnedLoading: N, passedLoading: B, reviewConvenientRef: G, reviewInit: J, detailInit: W, passed: Y, returned: Z, handleConvenientChange: ee } = Ne({ detailMethod: I, passedMethod: () => he(e.value), returnedMethod: () => ge(e.value), pendingListMethod: () => Ce(K.query), detailInitCallBack: se, closeDlg: k }), ae = x(() => e.value && e.value.serialNumber ? `退库单：${e.value.serialNumber}` : "退库单");
  re(() => V.data, async (a) => {
    W(), a && a.id && (v.value = a.id, m.value = true, J(), I(a.id));
  }, { immediate: true, deep: true });
  function se() {
    m.value = false, w.value = [];
  }
  function te(a, l, o) {
    C.value = a, g.value = a.source;
  }
  async function I(a) {
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
    g.value = void 0, C.value = {};
    const l = [], o = [];
    (a.basicClass === u.STEEL_PLATE.V || a.basicClass & u.SECTION_STEEL.V) && a.list.forEach(async (s) => {
      if (s.boolReturns && P(s.list)) {
        await _(s.list);
        const f = await h(s.list, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] }), r = s.list.map((oe) => oe.source);
        await _(r);
        const i = await h(r, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] });
        l.push(f), o.push(i);
      }
    }), await Promise.all(o), await Promise.all(l), await _(a.list), await h(a.list, { toNum: true });
    const b = a.list.map((s) => s.source);
    return await _(b), await h(b, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete"] }), a.list.forEach((s) => {
      s.actualMete = s.mete;
    }), (a.basicClass === u.STEEL_PLATE.V || a.basicClass === u.SECTION_STEEL.V) && a.list.forEach(async (s) => {
      if (s.uid = s.id, s.boolReturns && P(s.list)) {
        let f = 0;
        s.list.forEach((r) => {
          r.pid = s.id, r.uid = r.id, r.singleReturnMete && (f += r.singleReturnMete);
        }), s.detailMete = ye(f, p.value[a.basicClass].weight.precision) * (s.quantity || 0), s.actualMete = s.detailMete;
      }
    }), a;
  }
  function ie() {
    X.value && L("refresh");
  }
  function ne(a) {
    var o;
    const l = e.value.basicClass && p.value && p.value[e.value.basicClass] ? (o = p.value[e.value.basicClass]) == null ? void 0 : o.measure.precision : 0;
    return Ve(a, { props: [["quantity", l], ["actualMete", ke.weight.precision], "mete"] });
  }
  return (a, l) => {
    const o = ce, b = $("common-table"), s = de, f = me, r = $("common-drawer");
    return M(), T(r, { ref_key: "drawerRef", ref: D, modelValue: t(E), "onUpdate:modelValue": l[4] || (l[4] = (i) => S(E) ? E.value = i : null), "before-close": t(k), "content-loading": m.value, "show-close": true, title: ae.value, "custom-class": "raw-mat-return-application-review-form", size: "100%" }, { titleAfter: c(() => [n(Re, { detail: e.value }, null, 8, ["detail"])]), titleRight: c(() => [t(R) && t(R).length > 1 ? (M(), T(Be, { key: 0, ref_key: "reviewConvenientRef", ref: G, modelValue: t(v), "onUpdate:modelValue": l[0] || (l[0] = (i) => S(v) ? v.value = i : null), consequent: t(y), "onUpdate:consequent": l[1] || (l[1] = (i) => S(y) ? y.value = i : null), list: t(R), class: "convenient-operation", onChange: t(ee) }, null, 8, ["modelValue", "consequent", "list", "onChange"])) : A("", true), n(Ie, { "passed-fn": t(Y), "passed-loading": t(B), "returned-fn": t(Z), "returned-loading": t(N) }, null, 8, ["passed-fn", "passed-loading", "returned-fn", "returned-loading"])]), content: c(() => [n(f, { disabled: F.value, class: "form" }, { default: c(() => [n(xe, { "basic-class": e.value.basicClass, material: g.value, class: "material-info" }, null, 8, ["basic-class", "material"]), n(b, { ref: "tableRef", data: e.value.list, "data-format": z.value, "expand-row-keys": w.value, "max-height": t(Q), "summary-method": ne, "default-expand-all": "", "highlight-current-row": "", "row-key": "id", "show-summary": "", onRowClick: te }, { default: c(() => [n(Me, { "expand-row-keys": w.value, "onUpdate:expandRowKeys": l[2] || (l[2] = (i) => w.value = i), data: e.value.list, fixed: "left", "row-key": "id" }, { default: c(({ row: i }) => [(e.value.basicClass === t(u).STEEL_PLATE.V || e.value.basicClass === t(u).SECTION_STEEL.V) && i.boolReturns ? (M(), T(b, { key: i.id, class: ue(C.value.uid === i.uid ? "child-table" : ""), data: i.list, stripe: false, style: { margin: "10px 0" } }, { default: c(() => [n(O, { "basic-class": i.basicClass, fixed: "left" }, { afterMaterialSn: c(() => [n(o, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 2 }, 1032, ["basic-class"]), n(U, { "basic-class": i.basicClass }, null, 8, ["basic-class"]), n(o, { label: `数量 (${t(p)[e.value.basicClass].measure.unit})`, align: "center", prop: "singleQuantity", width: "110px" }, null, 8, ["label"]), n(o, { key: "singleReturnMete", label: `总重 (${t(p)[e.value.basicClass].weight.unit})`, align: "center", prop: "singleReturnMete", width: "120px" }, null, 8, ["label"]), n(H)]), _: 2 }, 1032, ["class", "data"])) : A("", true), n(Te, { "basic-class": i.basicClass, row: i, "show-batch-no": false, "show-graphics": "", "show-remark": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), n(O, { "basic-class": e.value.basicClass, showTip: e.value.basicClass === t(u).STEEL_PLATE.V || e.value.basicClass === t(u).SECTION_STEEL.V, fixed: "left" }, { afterMaterialSn: c(() => [n(o, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class", "showTip"]), n(U, { "basic-class": e.value.basicClass }, null, 8, ["basic-class"]), n(Se, { "basic-class": e.value.basicClass, showTip: e.value.basicClass === t(u).STEEL_PLATE.V || e.value.basicClass === t(u).SECTION_STEEL.V }, null, 8, ["basic-class", "showTip"]), n(H, { "show-project": "", "show-monomer": false, "show-area": false }), n(Le, { label: "实际退库时间" })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), n(s, { modelValue: e.value.approvalComments, "onUpdate:modelValue": l[3] || (l[3] = (i) => e.value.approvalComments = i), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["disabled"])]), _: 1 }, 8, ["modelValue", "before-close", "content-loading", "title"]);
  };
} }, je = pe($e, [["__scopeId", "data-v-35f6ccdf"]]);
export {
  je as default
};
