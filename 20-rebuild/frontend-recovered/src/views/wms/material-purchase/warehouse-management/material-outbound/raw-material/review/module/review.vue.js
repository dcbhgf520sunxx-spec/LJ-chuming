import { inject as ce } from "vue";
import { ref as u } from "vue";
import { computed as U } from "vue";
import { watch as de } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as i } from "vue";
import { createBlock as r } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as c } from "vue";
import { createVNode as s } from "vue";
import { unref as l } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as y } from "vue";
import { isRef as pe } from "vue";
import { ElTag as me } from "element-plus";
import { ElDatePicker as fe } from "element-plus";
import { ElTableColumn as ve } from "element-plus";
import { ElTooltip as _e } from "element-plus";
import { ElPopconfirm as we } from "element-plus";
import { ElForm as ye } from "element-plus";
import { _ as be, jX as he, qS as ke, kc as ge, o as Ve, u as Re, A4 as Se, A5 as $, cO as xe, jl as Ee, p as Te, gG as d, kD as b, aR as Ce, k4 as Ne, jG as Oe, k5 as Ue, jH as De, G as Ie, zQ as Pe, zR as je, ba as Be, jN as Ae } from "../../../../../../../../shared/runtime.js";
import { _ as Le } from "../../../../../../../../modules/index-4b5f34f4.js";
import { R as $e } from "../../../../../../../../modules/review-convenient-operate-8438d44b.js";
const ze = { key: 0, class: "batch-set-info child-mr-7" }, He = { key: 0 }, Me = { style: { color: "brown" } }, qe = { style: { color: "#3a8ee6" } }, Fe = { key: 1 }, We = { __name: "review", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:modelValue"], setup(z, { emit: H }) {
  const I = H, P = z, M = ce("permission"), V = u(), q = u(), p = u(false), v = u(false), h = u([]), e = u({}), R = u(0), S = u(false), k = u([]), x = u(), E = u(), F = u([...he, ["outboundAddress", ["parse-enum", ke]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), W = U(() => p.value), G = U(() => e.value && e.value.applicationSN ? `出库申请单：${e.value.applicationSN}` : "出库申请单"), { crud: K } = ge(), { maxHeight: Q } = Ve({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => U(() => !v.value)), { visible: T, handleClose: C } = Re({ emit: I, props: P, closeHook: ae });
  de(() => P.data, async (o) => {
    j(), o && o.id && (x.value = o.id, v.value = true, await Y(), B(o.id));
  }, { immediate: true, deep: true });
  function j() {
    v.value = false, p.value = false, p.value = false, h.value = [], e.value = {};
  }
  function X(o) {
    j(), B(o);
  }
  async function Y() {
    k.value = await Se(K.query);
  }
  async function B(o) {
    if (o) try {
      v.value = true;
      const a = await $(o);
      e.value = await J(a);
    } catch (a) {
      console.log("加载失败", a);
    } finally {
      v.value = false;
    }
  }
  async function J(o) {
    return await xe(o.list), o.list = await Ee(o.list, { toSmallest: false, toNum: false }), o;
  }
  async function Z(o, a) {
    try {
      p.value = true, await Pe({ listId: e.value.id, materialId: o.id }), e.value.list.splice(a, 1), e.value.list.length === 0 ? A() : ++R.value;
    } catch (_) {
      console.log("删除", _);
    } finally {
      p.value = false;
    }
  }
  async function ee() {
    try {
      p.value = true, await je(e.value), e.value.reviewStatus = b.PASS.V, ++R.value;
    } catch (o) {
      console.log("通过提交", o);
    } finally {
      p.value = false;
    }
  }
  function A() {
    try {
      S.value && V.value ? V.value.removeCurrent() : C();
    } catch (o) {
      console.log("审核提交后", o), C();
    }
  }
  function ae() {
    R.value && I("refresh");
  }
  function te() {
    e.value.list.forEach((o) => {
      o.outboundTime = E.value;
    });
  }
  function oe(o) {
    return Be(o, { props: ["quantity", ["mete", Ae.weight.precision]] });
  }
  return (o, a) => {
    const _ = me, L = fe, N = g("common-button"), le = g("print-table"), w = ve, ne = _e, se = we, ie = g("common-table"), ue = ye, re = g("common-drawer");
    return i(), r(re, { ref_key: "drawerRef", ref: q, modelValue: l(T), "onUpdate:modelValue": a[4] || (a[4] = (t) => pe(T) ? T.value = t : null), "before-close": l(C), "content-loading": v.value, "show-close": true, title: G.value, "custom-class": "raw-mat-application-review-form", size: "100%" }, { titleAfter: n(() => [e.value.applicant ? (i(), r(_, { key: 0, effect: "dark", type: "success" }, { default: n(() => [f(m(`申请人：${e.value.applicant.name} | ${e.value.applicant.deptName}`), 1)]), _: 1 })) : c("", true), s(_, { effect: "plain" }, { default: n(() => [f(m(`出库申请时间：${l(Te)(e.value.createTime)}`), 1)]), _: 1 }), s(_, { effect: "plain", type: "warning" }, { default: n(() => [f("出库类型：" + m(l(d).VL[e.value.outboundTypeSelection]), 1)]), _: 1 }), s(_, { effect: "plain" }, { default: n(() => [f("备注：" + m(l($).remark || "-"), 1)]), _: 1 })]), titleRight: n(() => [e.value.reviewStatus === l(b).UNREVIEWED.V && e.value.outboundTypeSelection === l(d).PRODUCE.V ? (i(), D("span", ze, [s(L, { modelValue: E.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => E.value = t), placeholder: "批量设置出库时间", size: "default", type: "datetime", "value-format": "x" }, null, 8, ["modelValue"]), s(N, { size: "default", type: "success", onClick: te }, { default: n(() => a[5] || (a[5] = [f("设置")])), _: 1, __: [5] })])) : c("", true), k.value && k.value.length > 1 ? (i(), r($e, { key: 1, ref_key: "reviewConvenientRef", ref: V, modelValue: x.value, "onUpdate:modelValue": a[1] || (a[1] = (t) => x.value = t), consequent: S.value, "onUpdate:consequent": a[2] || (a[2] = (t) => S.value = t), list: k.value, class: "convenient-operation", onChange: X }, null, 8, ["modelValue", "consequent", "list"])) : c("", true), e.value.reviewStatus === l(b).UNREVIEWED.V && e.value.outboundTypeSelection === l(d).PRODUCE.V ? (i(), r(N, { key: 2, loading: p.value, size: "default", type: "primary", onClick: ee }, { default: n(() => a[6] || (a[6] = [f("提交")])), _: 1, __: [6] }, 8, ["loading"])) : c("", true), e.value.reviewStatus === l(b).PASS.V ? (i(), r(le, { key: 3, params: e.value.id, "api-key": "wmsRmOutboundReceipt", class: "filter-item", size: "default", type: "warning", onSuccess: A }, null, 8, ["params"])) : c("", true)]), content: n(() => [s(ue, { disabled: W.value, class: "form" }, { default: n(() => [s(ie, { data: e.value.list, "data-format": F.value, "expand-row-keys": h.value, "max-height": l(Q), "summary-method": oe, "row-key": "id", "show-summary": "" }, { default: n(() => [s(Ce, { "expand-row-keys": h.value, "onUpdate:expandRowKeys": a[3] || (a[3] = (t) => h.value = t), data: e.value.list, fixed: "left", "row-key": "id" }, { default: n(({ row: t }) => [s(Ne, { "basic-class": t.basicClass, row: t, "show-graphics": "", "show-remark": "" }, { default: n(() => [t.boolTransfer ? (i(), D("p", He, [a[7] || (a[7] = f(" 调拨： ")), a[8] || (a[8] = y("span", null, "（来源）", -1)), y("span", Me, m(t.sourceProject), 1), a[9] || (a[9] = y("span", null, " ▶ ", -1)), a[10] || (a[10] = y("span", null, "（目的）", -1)), y("span", qe, m(t.project), 1)])) : c("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(Oe, { "basic-class": e.value.basicClass, fixed: "left", "show-outbound-mode": "" }, { afterMaterialSn: n(() => [s(w, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), s(Ue), s(De), s(Le, { "show-area": false, "show-monomer": false, "show-project": e.value.outboundTypeSelection !== l(d).FOR_SALE.V, showOutboundWorkshop: e.value.outboundTypeSelection === l(d).PRODUCE.V || e.value.outboundTypeSelection === l(d).TEMPORARY_LOAN.V, workshopLabel: e.value.outboundTypeSelection === l(d).PRODUCE.V ? "领用车间" : "借用车间", "show-transfer": "", "show-workshop": "", showAreaBatchName: "" }, null, 8, ["show-project", "showOutboundWorkshop", "workshopLabel"]), e.value.outboundTypeSelection === l(d).PRODUCE.V ? (i(), r(w, { key: 0, align: "center", label: "出库目的地", prop: "outboundAddress", width: "100px" })) : c("", true), e.value.outboundTypeSelection === l(d).OUTSOURCE.V ? (i(), r(w, { key: "purchase.serialNumber", align: "center", label: "所属采购合同", prop: "purchase.serialNumber", width: "145px" })) : c("", true), s(w, { align: "center", label: "领用人", width: "100px" }, { default: n(({ row: t }) => [t.recipient ? (i(), r(ne, { key: 0, content: `${t.recipient.deptName}`, effect: "light", placement: "top" }, { default: n(() => [y("span", null, m(t.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : c("", true)]), _: 1 }), s(w, { align: "center", label: "出库时间", width: "195px" }, { default: n(({ row: t }) => [e.value.reviewStatus === l(b).UNREVIEWED.V && e.value.outboundTypeSelection === l(d).PRODUCE.V ? (i(), r(L, { key: 0, modelValue: t.sourceRow.outboundTime, "onUpdate:modelValue": (O) => t.sourceRow.outboundTime = O, placeholder: "出库时间", type: "datetime", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (i(), D("span", Fe, m(t.outboundTime), 1))]), _: 1 }), l(Ie)(l(M).edit) && e.value.reviewStatus === l(b).UNREVIEWED.V ? (i(), r(w, { key: 2, align: "left", label: "操作", width: "70px" }, { default: n(({ row: t, $index: O }) => [s(se, { title: `确认删除当前${t.classifyFullName}吗?`, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", onConfirm: (Ge) => Z(t, O) }, { reference: n(() => [s(N, { loading: p.value, icon: "el-icon-delete", size: "default", type: "danger" }, null, 8, ["loading"])]), _: 2 }, 1032, ["title", "onConfirm"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["disabled"])]), _: 1 }, 8, ["modelValue", "before-close", "content-loading", "title"]);
  };
} }, Je = be(We, [["__scopeId", "data-v-866a7ed6"]]);
export {
  Je as default
};
