import { inject as re } from "vue";
import { ref as u } from "vue";
import { computed as H } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as r } from "vue";
import { createBlock as c } from "vue";
import { createSlots as ue } from "vue";
import { unref as l } from "vue";
import { withCtx as n } from "vue";
import { createElementBlock as B } from "vue";
import { Fragment as de } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as w } from "vue";
import { createCommentVNode as m } from "vue";
import { toDisplayString as g } from "vue";
import { isRef as ce } from "vue";
import { ElDatePicker as me } from "element-plus";
import { ElPopconfirm as pe } from "element-plus";
import { ElTableColumn as fe } from "element-plus";
import { ElTooltip as _e } from "element-plus";
import { ElForm as be } from "element-plus";
import { a as ve, d as ye, r as we, b as ge } from "../../../../../../../modules/review-a53b87d8.js";
import { _ as he, yX as ke, jX as xe, qS as Te, o as Ve, u as Ee, cO as Ce, jl as Se, G as D, kD as f, i as U, xT as h, aR as Re, k4 as Be, jG as De, k5 as Ne, jH as je, k6 as Ie, bl as He, aw as Ue, ba as $e, jN as Oe } from "../../../../../../../shared/runtime.js";
const Pe = { class: "batch-set-info child-mr-7" }, Fe = { key: 0 }, Le = { style: { color: "brown" } }, Me = { style: { color: "#3a8ee6" } }, ze = { key: 1 }, Ae = { __name: "list", props: { visible: { type: Boolean, default: false } }, emits: ["refresh", "update:visible"], setup($, { emit: O }) {
  const N = O, P = $, { loaded: j, lastTime: k } = ke(), x = re("permission"), F = u(), i = u(false), p = u(false), _ = u([]), o = u({}), b = u(0), T = u(), L = H(() => i.value);
  function I(e) {
    return U(k.value) && k.value.endTime ? e.getTime() < Number(k.value.endTime) + 1 * 1e3 || e.getTime() > (/* @__PURE__ */ new Date()).getTime() : e.getTime() > (/* @__PURE__ */ new Date()).getTime();
  }
  const M = u([...xe, ["outboundAddress", ["parse-enum", Te]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { maxHeight: z } = Ve({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => H(() => !p.value)), A = { outboundTime: [{ required: true, message: "请选择实际出库时间", trigger: "change" }] }, { visible: V, handleClose: W } = Ee({ emit: N, props: P, field: "visible", showHook: K, closeHook: X }), { tableValidate: q, wrongCellMask: G } = Ue({ rules: A });
  function K() {
    E(), J();
  }
  function X() {
    b.value && N("refresh");
  }
  function E() {
    p.value = false, i.value = false, i.value = false, _.value = [], o.value = {};
  }
  async function J() {
    try {
      p.value = true;
      const e = await ve();
      e && (o.value = await Q(e));
    } catch (e) {
      console.log("加载失败", e);
    } finally {
      p.value = false;
    }
  }
  async function Q(e) {
    return await Ce(e.list), e.list = await Se(e.list, { toSmallest: false, toNum: false }), e;
  }
  async function Y(e, a) {
    try {
      i.value = true, await ye({ listId: o.value.id, materialId: e.id }), o.value.list.splice(a, 1), ++b.value, o.value.list.length === 0 && E();
    } catch (v) {
      console.log("删除", v);
    } finally {
      i.value = false;
    }
  }
  async function Z() {
    try {
      const { validResult: e, dealList: a } = q(o.value.list);
      if (e) o.value.list = a;
      else return e;
      i.value = true, await we(o.value), o.value.reviewStatus = f.PASS.V, ++b.value;
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      i.value = false;
    }
  }
  async function ee() {
    try {
      i.value = true, await ge(o.value.id), ++b.value, E();
    } catch (e) {
      console.log("退回", e);
    } finally {
      i.value = false;
    }
  }
  function ae(e) {
    return $e(e, { props: ["quantity", ["mete", Oe.weight.precision]] });
  }
  function te() {
    o.value.list.forEach((e) => {
      e.outboundTime = T.value;
    });
  }
  return (e, a) => {
    const v = me, C = pe, oe = R("print-table"), y = fe, le = _e, se = R("common-table"), ne = be, ie = R("common-drawer");
    return r(), c(ie, { ref_key: "drawerRef", ref: F, modelValue: l(V), "onUpdate:modelValue": a[2] || (a[2] = (t) => ce(V) ? V.value = t : null), "before-close": l(W), "content-loading": p.value, "show-close": true, "custom-class": "raw-mat-application-review-form", size: "100%", title: "出库清单" }, ue({ content: n(() => [s(ne, { disabled: L.value, class: "form" }, { default: n(() => [s(se, { data: o.value.list, "data-format": M.value, "expand-row-keys": _.value, "max-height": l(z), "summary-method": ae, "row-key": "id", "cell-class-name": l(G), "show-summary": "" }, { default: n(() => [s(Re, { "expand-row-keys": _.value, "onUpdate:expandRowKeys": a[1] || (a[1] = (t) => _.value = t), data: o.value.list, fixed: "left", "row-key": "id" }, { default: n(({ row: t }) => [s(Be, { "basic-class": t.basicClass, row: t, "show-graphics": "", "show-remark": "" }, { default: n(() => [t.boolTransfer ? (r(), B("p", Fe, [a[6] || (a[6] = w(" 调拨： ")), a[7] || (a[7] = d("span", null, "（来源）", -1)), d("span", Le, g(t.sourceProject), 1), a[8] || (a[8] = d("span", null, " ▶ ", -1)), a[9] || (a[9] = d("span", null, "（目的）", -1)), d("span", Me, g(t.project), 1)])) : m("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(De, { "basic-class": o.value.basicClass, fixed: "left", "show-outbound-mode": "", showClassification: "" }, null, 8, ["basic-class"]), s(Ne), s(je), s(Ie, { "show-project": "", "show-monomer": "", "show-area": "", "show-workshop": "", "show-transfer": "", showOutboundWorkshop: "" }), s(y, { align: "center", label: "出库目的地", prop: "outboundAddress", width: "100px" }), s(y, { align: "center", label: "领用人", width: "100px" }, { default: n(({ row: t }) => [t.recipient ? (r(), c(le, { key: 0, content: `${t.recipient.deptName}`, effect: "light", placement: "top" }, { default: n(() => [d("span", null, g(t.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : m("", true)]), _: 1 }), s(y, { prop: "outboundTime", label: "实际出库时间", width: "195px", align: "center" }, { default: n(({ row: t }) => [o.value.reviewStatus === l(f).UNREVIEWED.V ? (r(), c(v, { key: 0, modelValue: t.sourceRow.outboundTime, "onUpdate:modelValue": (S) => t.sourceRow.outboundTime = S, type: "datetime", "value-format": "x", disabled: !l(j), disabledDate: I, placeholder: "实际出库时间" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])) : (r(), B("span", ze, g(t.outboundTime), 1))]), _: 1 }), l(D)(l(x).outbound) && o.value.reviewStatus === l(f).UNREVIEWED.V ? (r(), c(y, { key: 0, align: "left", label: "操作", width: "70px" }, { default: n(({ row: t, $index: S }) => [s(C, { title: `确认删除当前${t.classifyFullName}吗?`, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", onConfirm: (We) => Y(t, S) }, { reference: n(() => [s(h, { disabled: !!(t.basicClass & l(He).STEEL_COIL.V && t.length), loading: i.value, icon: "el-icon-delete", size: "default", type: "danger" }, null, 8, ["disabled", "loading"])]), _: 2 }, 1032, ["title", "onConfirm"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "cell-class-name"])]), _: 1 }, 8, ["disabled"])]), _: 2 }, [l(D)(l(x).outbound) ? { name: "titleRight", fn: n(() => [o.value.reviewStatus === l(f).UNREVIEWED.V && l(U)(o.value.list) ? (r(), B(de, { key: 0 }, [d("span", Pe, [s(v, { modelValue: T.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => T.value = t), disabled: !l(j), disabledDate: I, placeholder: "批量设置出库时间", type: "datetime", "value-format": "x" }, null, 8, ["modelValue", "disabled"]), s(h, { size: "default", type: "success", onClick: te }, { default: n(() => a[3] || (a[3] = [w("设置")])), _: 1, __: [3] })]), l(D)(l(x).outboundAudit) ? (r(), c(C, { key: 0, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "green", title: "确认通过？", onConfirm: Z }, { reference: n(() => [s(h, { loading: i.value, icon: "el-icon-promotion", size: "default", type: "primary" }, { default: n(() => a[4] || (a[4] = [w(" 确认出库 ")])), _: 1, __: [4] }, 8, ["loading"])]), _: 1 })) : m("", true), s(C, { "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", title: "确认清空？", onConfirm: ee }, { reference: n(() => [s(h, { loading: i.value, icon: "el-icon-document-delete", size: "default", type: "danger" }, { default: n(() => a[5] || (a[5] = [w(" 清 空 ")])), _: 1, __: [5] }, 8, ["loading"])]), _: 1 })], 64)) : m("", true), o.value.reviewStatus === l(f).PASS.V ? (r(), c(oe, { key: 1, params: o.value.id, "api-key": "wmsRmOutboundReceipt", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"])) : m("", true)]), key: "0" } : void 0]), 1032, ["modelValue", "before-close", "content-loading"]);
  };
} }, Xe = he(Ae, [["__scopeId", "data-v-de1c100d"]]);
export {
  Xe as default
};
