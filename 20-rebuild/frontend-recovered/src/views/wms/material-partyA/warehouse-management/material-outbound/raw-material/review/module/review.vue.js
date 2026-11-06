import { inject as re } from "vue";
import { ref as s } from "vue";
import { computed as I } from "vue";
import { watch as ce } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as u } from "vue";
import { createBlock as c } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as d } from "vue";
import { createVNode as n } from "vue";
import { unref as i } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as v } from "vue";
import { isRef as de } from "vue";
import { ElTag as me } from "element-plus";
import { ElDatePicker as pe } from "element-plus";
import { ElTableColumn as fe } from "element-plus";
import { ElTooltip as ve } from "element-plus";
import { ElPopconfirm as _e } from "element-plus";
import { ElForm as we } from "element-plus";
import { _ as ye, jX as be, qS as ge, kc as ke, o as he, u as xe, A4 as Ve, A5 as z, cO as Re, jl as Ee, p as Ce, kD as _, aR as Se, k4 as Ne, jG as Te, k5 as Ie, jH as je, k6 as Be, G as De, zQ as Ue, zR as $e, ba as Pe, jN as Ae } from "../../../../../../../../shared/runtime.js";
import { R as ze } from "../../../../../../../../modules/review-convenient-operate-8438d44b.js";
const He = { key: 0, class: "batch-set-info child-mr-7" }, Oe = { key: 0 }, Le = { style: { color: "brown" } }, qe = { style: { color: "#3a8ee6" } }, Fe = { key: 1 }, Me = { __name: "review", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:modelValue"], setup(H, { emit: O }) {
  const B = O, D = H, L = re("permission"), h = s(), q = s(), r = s(false), p = s(false), y = s([]), o = s({}), x = s(0), V = s(false), b = s([]), R = s(), E = s(), F = s([...be, ["outboundAddress", ["parse-enum", ge]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), M = I(() => r.value), W = I(() => o.value && o.value.applicationSN ? `出库申请单：${o.value.applicationSN}` : "出库申请单"), { crud: G } = ke(), { maxHeight: K } = he({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => I(() => !p.value)), { visible: C, handleClose: S } = xe({ emit: B, props: D, closeHook: ee });
  ce(() => D.data, async (t) => {
    U(), t && t.id && (R.value = t.id, p.value = true, await X(), $(t.id));
  }, { immediate: true, deep: true });
  function U() {
    p.value = false, r.value = false, r.value = false, y.value = [], o.value = {};
  }
  function Q(t) {
    U(), $(t);
  }
  async function X() {
    b.value = await Ve(G.query);
  }
  async function $(t) {
    if (t) try {
      p.value = true;
      const e = await z(t);
      o.value = await J(e);
    } catch (e) {
      console.log("加载失败", e);
    } finally {
      p.value = false;
    }
  }
  async function J(t) {
    return await Re(t.list), t.list = await Ee(t.list, { toSmallest: false, toNum: false }), t;
  }
  async function Y(t, e) {
    try {
      r.value = true, await Ue({ listId: o.value.id, materialId: t.id }), o.value.list.splice(e, 1), o.value.list.length === 0 ? P() : ++x.value;
    } catch (w) {
      console.log("删除", w);
    } finally {
      r.value = false;
    }
  }
  async function Z() {
    try {
      r.value = true, await $e(o.value), o.value.reviewStatus = _.PASS.V, ++x.value;
    } catch (t) {
      console.log("通过提交", t);
    } finally {
      r.value = false;
    }
  }
  function P() {
    try {
      V.value && h.value ? h.value.removeCurrent() : S();
    } catch (t) {
      console.log("审核提交后", t), S();
    }
  }
  function ee() {
    x.value && B("refresh");
  }
  function ae() {
    o.value.list.forEach((t) => {
      t.outboundTime = E.value;
    });
  }
  function te(t) {
    return Pe(t, { props: ["quantity", ["mete", Ae.weight.precision]] });
  }
  return (t, e) => {
    const w = me, A = pe, N = k("common-button"), oe = k("print-table"), g = fe, le = ve, ne = _e, se = k("common-table"), ie = we, ue = k("common-drawer");
    return u(), c(ue, { ref_key: "drawerRef", ref: q, modelValue: i(C), "onUpdate:modelValue": e[4] || (e[4] = (a) => de(C) ? C.value = a : null), "before-close": i(S), "content-loading": p.value, "show-close": true, title: W.value, "custom-class": "raw-mat-application-review-form", size: "100%" }, { titleAfter: l(() => [o.value.applicant ? (u(), c(w, { key: 0, effect: "dark", type: "success" }, { default: l(() => [f(m(`申请人：${o.value.applicant.name} | ${o.value.applicant.deptName}`), 1)]), _: 1 })) : d("", true), n(w, { effect: "plain" }, { default: l(() => [f(m(`出库申请时间：${i(Ce)(o.value.createTime)}`), 1)]), _: 1 }), n(w, { effect: "plain" }, { default: l(() => [f("备注：" + m(i(z).remark || "-"), 1)]), _: 1 })]), titleRight: l(() => [o.value.reviewStatus === i(_).UNREVIEWED.V ? (u(), j("span", He, [n(A, { modelValue: E.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => E.value = a), placeholder: "批量设置出库时间", size: "default", type: "datetime", "value-format": "x" }, null, 8, ["modelValue"]), n(N, { size: "default", type: "success", onClick: ae }, { default: l(() => e[5] || (e[5] = [f("设置")])), _: 1, __: [5] })])) : d("", true), b.value && b.value.length > 1 ? (u(), c(ze, { key: 1, ref_key: "reviewConvenientRef", ref: h, modelValue: R.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => R.value = a), consequent: V.value, "onUpdate:consequent": e[2] || (e[2] = (a) => V.value = a), list: b.value, class: "convenient-operation", onChange: Q }, null, 8, ["modelValue", "consequent", "list"])) : d("", true), o.value.reviewStatus === i(_).UNREVIEWED.V ? (u(), c(N, { key: 2, loading: r.value, size: "default", type: "primary", onClick: Z }, { default: l(() => e[6] || (e[6] = [f("提交")])), _: 1, __: [6] }, 8, ["loading"])) : d("", true), o.value.reviewStatus === i(_).PASS.V ? (u(), c(oe, { key: 3, params: o.value.id, "api-key": "wmsRmOutboundReceipt", class: "filter-item", size: "default", type: "warning", onSuccess: P }, null, 8, ["params"])) : d("", true)]), content: l(() => [n(ie, { disabled: M.value, class: "form" }, { default: l(() => [n(se, { data: o.value.list, "data-format": F.value, "expand-row-keys": y.value, "max-height": i(K), "summary-method": te, "row-key": "id", "show-summary": "" }, { default: l(() => [n(Se, { "expand-row-keys": y.value, "onUpdate:expandRowKeys": e[3] || (e[3] = (a) => y.value = a), data: o.value.list, fixed: "left", "row-key": "id" }, { default: l(({ row: a }) => [n(Ne, { "basic-class": a.basicClass, row: a, "show-graphics": "", "show-remark": "" }, { default: l(() => [a.boolTransfer ? (u(), j("p", Oe, [e[7] || (e[7] = f(" 调拨： ")), e[8] || (e[8] = v("span", null, "（来源）", -1)), v("span", Le, m(a.sourceProject), 1), e[9] || (e[9] = v("span", null, " ▶ ", -1)), e[10] || (e[10] = v("span", null, "（目的）", -1)), v("span", qe, m(a.project), 1)])) : d("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), n(Te, { "basic-class": o.value.basicClass, fixed: "left", "show-outbound-mode": "" }, null, 8, ["basic-class"]), n(Ie), n(je), n(Be, { "show-area": false, "show-monomer": false, "show-project": "", showAreaBatchName: "", "show-transfer": "", showOutboundWorkshop: "" }), n(g, { align: "center", label: "出库目的地", prop: "outboundAddress", width: "100px" }), n(g, { align: "center", label: "领用人", width: "100px" }, { default: l(({ row: a }) => [a.recipient ? (u(), c(le, { key: 0, content: `${a.recipient.deptName}`, effect: "light", placement: "top" }, { default: l(() => [v("span", null, m(a.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : d("", true)]), _: 1 }), n(g, { align: "center", label: "出库时间", width: "195px" }, { default: l(({ row: a }) => [o.value.reviewStatus === i(_).UNREVIEWED.V ? (u(), c(A, { key: 0, modelValue: a.sourceRow.outboundTime, "onUpdate:modelValue": (T) => a.sourceRow.outboundTime = T, placeholder: "出库时间", type: "datetime", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (u(), j("span", Fe, m(a.outboundTime), 1))]), _: 1 }), i(De)(i(L).edit) && o.value.reviewStatus === i(_).UNREVIEWED.V ? (u(), c(g, { key: 0, align: "left", label: "操作", width: "70px" }, { default: l(({ row: a, $index: T }) => [n(ne, { title: `确认删除当前${a.classifyFullName}吗?`, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", onConfirm: (We) => Y(a, T) }, { reference: l(() => [n(N, { loading: r.value, icon: "el-icon-delete", size: "default", type: "danger" }, null, 8, ["loading"])]), _: 2 }, 1032, ["title", "onConfirm"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["disabled"])]), _: 1 }, 8, ["modelValue", "before-close", "content-loading", "title"]);
  };
} }, Xe = ye(Me, [["__scopeId", "data-v-9ef63449"]]);
export {
  Xe as default
};
