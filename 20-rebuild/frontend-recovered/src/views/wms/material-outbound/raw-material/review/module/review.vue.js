import { inject as me } from "vue";
import { ref as i } from "vue";
import { computed as j } from "vue";
import { watch as pe } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as r } from "vue";
import { createBlock as d } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as c } from "vue";
import { createVNode as l } from "vue";
import { unref as u } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as f } from "vue";
import { isRef as fe } from "vue";
import { ElTag as ve } from "element-plus";
import { ElDatePicker as _e } from "element-plus";
import { ElTableColumn as we } from "element-plus";
import { ElTooltip as ye } from "element-plus";
import { ElPopconfirm as be } from "element-plus";
import { ElForm as ge } from "element-plus";
import { e as he, f as ke, d as xe, r as Ve, b as Te } from "../../../../../../modules/review-a53b87d8.js";
import { _ as Re, yX as Ee, jX as Ce, qS as Se, kc as Ne, o as Ie, u as je, cO as De, jl as Be, p as $e, kD as v, aR as Ue, k4 as Pe, jG as Oe, k5 as He, jH as Le, k6 as qe, G as Ae, i as Fe, ba as ze, jN as Me } from "../../../../../../shared/runtime.js";
import { R as We } from "../../../../../../modules/review-convenient-operate-8438d44b.js";
import { _ as Ge } from "../../../../../../modules/review-confirm-button-aa3600ad.js";
const Ke = { key: 0, class: "batch-set-info child-mr-7" }, Xe = { key: 0 }, Je = { style: { color: "brown" } }, Qe = { style: { color: "#3a8ee6" } }, Ye = { key: 1 }, Ze = { __name: "review", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:modelValue"], setup(L, { emit: q }) {
  const B = q, $ = L, { loaded: A, lastTime: x } = Ee();
  function F(e) {
    return Fe(x.value) && x.value.endTime ? e.getTime() < Number(x.value.endTime) + 1 * 1e3 || e.getTime() > (/* @__PURE__ */ new Date()).getTime() : e.getTime() > (/* @__PURE__ */ new Date()).getTime();
  }
  const z = me("permission"), V = i(), M = i(), s = i(false), m = i(false), _ = i([]), o = i({}), w = i(0), T = i(false), y = i([]), R = i(), E = i(), W = i([...Ce, ["outboundAddress", ["parse-enum", Se]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), G = j(() => s.value), K = j(() => o.value && o.value.applicationSN ? `出库申请单：${o.value.applicationSN}` : "出库申请单"), { crud: X } = Ne(), { maxHeight: J } = Ie({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => j(() => !m.value)), { visible: C, handleClose: S } = je({ emit: B, props: $, closeHook: oe });
  pe(() => $.data, async (e) => {
    U(), e && e.id && (R.value = e.id, m.value = true, await Y(), P(e.id));
  }, { immediate: true, deep: true });
  function U() {
    m.value = false, s.value = false, s.value = false, _.value = [], o.value = {};
  }
  function Q(e) {
    U(), P(e);
  }
  async function Y() {
    y.value = await he(X.query);
  }
  async function P(e) {
    if (e) try {
      m.value = true;
      const a = await ke(e);
      o.value = await Z(a);
    } catch (a) {
      console.log("加载失败", a);
    } finally {
      m.value = false;
    }
  }
  async function Z(e) {
    return await De(e.list), e.list = await Be(e.list, { toSmallest: false, toNum: false }), e;
  }
  async function ee(e, a) {
    try {
      s.value = true, await xe({ listId: o.value.id, materialId: e.id }), o.value.list.splice(a, 1), o.value.list.length === 0 ? N() : ++w.value;
    } catch (b) {
      console.log("删除", b);
    } finally {
      s.value = false;
    }
  }
  async function ae() {
    try {
      s.value = true, await Ve(o.value), o.value.reviewStatus = v.PASS.V, ++w.value;
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      s.value = false;
    }
  }
  async function te() {
    try {
      s.value = true, await Te(o.value.id), ++w.value, N();
    } catch (e) {
      console.log("退回", e);
    } finally {
      s.value = false;
    }
  }
  function N() {
    try {
      T.value && V.value ? V.value.removeCurrent() : S();
    } catch (e) {
      console.log("审核提交后", e), S();
    }
  }
  function oe() {
    w.value && B("refresh");
  }
  function le() {
    o.value.list.forEach((e) => {
      e.outboundTime = E.value;
    });
  }
  function ne(e) {
    return ze(e, { props: ["quantity", ["mete", Me.weight.precision]] });
  }
  return (e, a) => {
    const b = ve, O = _e, H = h("common-button"), se = h("print-table"), g = we, ie = ye, ue = be, re = h("common-table"), de = ge, ce = h("common-drawer");
    return r(), d(ce, { ref_key: "drawerRef", ref: M, modelValue: u(C), "onUpdate:modelValue": a[4] || (a[4] = (t) => fe(C) ? C.value = t : null), "content-loading": m.value, "before-close": u(S), title: K.value, "show-close": true, size: "100%", "custom-class": "raw-mat-application-review-form" }, { titleAfter: n(() => [o.value.applicant ? (r(), d(b, { key: 0, type: "success", effect: "dark" }, { default: n(() => [k(p(`申请人：${o.value.applicant.name} | ${o.value.applicant.deptName}`), 1)]), _: 1 })) : c("", true), l(b, { effect: "plain" }, { default: n(() => [k(p(`出库申请时间：${u($e)(o.value.createTime)}`), 1)]), _: 1 })]), titleRight: n(() => [o.value.reviewStatus === u(v).UNREVIEWED.V ? (r(), D("span", Ke, [l(O, { modelValue: E.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => E.value = t), type: "datetime", "value-format": "x", placeholder: "批量设置出库时间", size: "default" }, null, 8, ["modelValue"]), l(H, { type: "success", size: "default", onClick: le }, { default: n(() => a[5] || (a[5] = [k("设置")])), _: 1, __: [5] })])) : c("", true), y.value && y.value.length > 1 ? (r(), d(We, { key: 1, ref_key: "reviewConvenientRef", ref: V, modelValue: R.value, "onUpdate:modelValue": a[1] || (a[1] = (t) => R.value = t), consequent: T.value, "onUpdate:consequent": a[2] || (a[2] = (t) => T.value = t), list: y.value, onChange: Q, class: "convenient-operation" }, null, 8, ["modelValue", "consequent", "list"])) : c("", true), o.value.reviewStatus === u(v).UNREVIEWED.V ? (r(), d(Ge, { key: 2, "passed-loading": s.value, "returned-loading": s.value, "passed-fn": ae, "returned-fn": te }, null, 8, ["passed-loading", "returned-loading"])) : c("", true), o.value.reviewStatus === u(v).PASS.V ? (r(), d(se, { key: 3, "api-key": "wmsRmOutboundReceipt", params: o.value.id, size: "default", type: "warning", class: "filter-item", onSuccess: N }, null, 8, ["params"])) : c("", true)]), content: n(() => [l(de, { class: "form", disabled: G.value }, { default: n(() => [l(re, { data: o.value.list, "data-format": W.value, "max-height": u(J), "show-summary": "", "summary-method": ne, "expand-row-keys": _.value, "row-key": "id" }, { default: n(() => [l(Ue, { data: o.value.list, "expand-row-keys": _.value, "onUpdate:expandRowKeys": a[3] || (a[3] = (t) => _.value = t), "row-key": "id", fixed: "left" }, { default: n(({ row: t }) => [l(Pe, { "basic-class": t.basicClass, row: t, "show-remark": "", "show-graphics": "" }, { default: n(() => [t.boolTransfer ? (r(), D("p", Xe, [a[6] || (a[6] = k(" 调拨： ")), a[7] || (a[7] = f("span", null, "（来源）", -1)), f("span", Je, p(t.sourceProject), 1), a[8] || (a[8] = f("span", null, " ▶ ", -1)), a[9] || (a[9] = f("span", null, "（目的）", -1)), f("span", Qe, p(t.project), 1)])) : c("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["data", "expand-row-keys"]), l(Oe, { "basic-class": o.value.basicClass, "show-outbound-mode": "", fixed: "left" }, null, 8, ["basic-class"]), l(He), l(Le), l(qe, { "show-project": "", "show-monomer": "", "show-area": "", "show-transfer": "", showOutboundWorkshop: "" }), l(g, { label: "出库目的地", width: "100px", prop: "outboundAddress", align: "center" }), l(g, { label: "领用人", width: "100px", align: "center" }, { default: n(({ row: t }) => [t.recipient ? (r(), d(ie, { key: 0, placement: "top", effect: "light", content: `${t.recipient.deptName}` }, { default: n(() => [f("span", null, p(t.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : c("", true)]), _: 1 }), l(g, { label: "实际出库时间", width: "195px", align: "center" }, { default: n(({ row: t }) => [o.value.reviewStatus === u(v).UNREVIEWED.V ? (r(), d(O, { key: 0, modelValue: t.sourceRow.outboundTime, "onUpdate:modelValue": (I) => t.sourceRow.outboundTime = I, type: "datetime", "value-format": "x", disabled: !u(A), disabledDate: F, placeholder: "实际出库时间" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])) : (r(), D("span", Ye, p(t.outboundTime), 1))]), _: 1 }), u(Ae)(u(z).edit) && o.value.reviewStatus === u(v).UNREVIEWED.V ? (r(), d(g, { key: 0, label: "操作", width: "70px", align: "left" }, { default: n(({ row: t, $index: I }) => [l(ue, { "confirm-button-text": "确定", "cancel-button-text": "取消", icon: "el-icon-info", "icon-color": "red", title: `确认删除当前${t.classifyFullName}吗?`, onConfirm: (ea) => ee(t, I) }, { reference: n(() => [l(H, { loading: s.value, type: "danger", icon: "el-icon-delete", size: "default" }, null, 8, ["loading"])]), _: 2 }, 1032, ["title", "onConfirm"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["disabled"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, sa = Re(Ze, [["__scopeId", "data-v-9fef54db"]]);
export {
  sa as default
};
