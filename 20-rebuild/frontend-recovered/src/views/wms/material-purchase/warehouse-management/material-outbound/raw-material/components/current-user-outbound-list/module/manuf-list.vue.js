import { inject as ae } from "vue";
import { ref as u } from "vue";
import { computed as B } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as r } from "vue";
import { createBlock as c } from "vue";
import { createSlots as te } from "vue";
import { unref as o } from "vue";
import { withCtx as n } from "vue";
import { createElementBlock as R } from "vue";
import { Fragment as oe } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as E } from "vue";
import { createCommentVNode as m } from "vue";
import { toDisplayString as D } from "vue";
import { isRef as le } from "vue";
import { ElDatePicker as ne } from "element-plus";
import { ElPopconfirm as se } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { ElTooltip as ue } from "element-plus";
import { ElForm as re } from "element-plus";
import { a as ce, d as de, r as me, b as fe } from "../../../../../../../../../modules/review-a53b87d8.js";
import { _ as pe, jX as _e, qS as ve, o as be, u as ye, cO as we, jl as ge, G as C, kD as f, i as he, xT as y, jG as xe, sO as ke, bl as Ve, ba as Ee, jN as Ce } from "../../../../../../../../../shared/runtime.js";
import Se from "../../../../../material-inventory/manufactured/manufactured-essential-information/index.vue.js";
import "../../../../../material-inventory/manufactured/manufactured-essential-information/module/enclosure.vue.js";
import "../../../../../material-inventory/manufactured/manufactured-essential-information/module/structure.vue.js";
const Te = { class: "batch-set-info child-mr-7" }, Be = { key: 1 }, Re = { __name: "manuf-list", props: { visible: { type: Boolean, default: false } }, emits: ["refresh", "update:visible"], setup(I, { emit: j }) {
  const S = j, H = I, w = ae("permission"), U = u(), s = u(false), d = u(false), T = u([]), a = u({}), p = u(0), _ = u(), L = B(() => s.value), O = u([..._e, ["outboundAddress", ["parse-enum", ve]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { maxHeight: P } = be({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => B(() => !d.value)), { visible: g, handleClose: z } = ye({ emit: S, props: H, field: "visible", showHook: F, closeHook: M });
  function F() {
    h(), $();
  }
  function M() {
    p.value && S("refresh");
  }
  function h() {
    d.value = false, s.value = false, s.value = false, T.value = [], a.value = {};
  }
  async function $() {
    try {
      d.value = true;
      const e = await ce();
      e && (a.value = await A(e));
    } catch (e) {
      console.log("加载失败", e);
    } finally {
      _.value = (/* @__PURE__ */ new Date()).getTime(), d.value = false;
    }
  }
  async function A(e) {
    return await we(e.list), e.list = await ge(e.list, { toSmallest: false, toNum: false }), e;
  }
  async function q(e, i) {
    try {
      s.value = true, await de({ listId: a.value.id, materialId: e.id }), a.value.list.splice(i, 1), ++p.value, a.value.list.length === 0 && h();
    } catch (v) {
      console.log("删除", v);
    } finally {
      s.value = false;
    }
  }
  async function W() {
    try {
      s.value = true, await me(a.value), a.value.reviewStatus = f.PASS.V, ++p.value;
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      s.value = false;
    }
  }
  async function G() {
    try {
      s.value = true, await fe(a.value.id), ++p.value, h();
    } catch (e) {
      console.log("退回", e);
    } finally {
      s.value = false;
    }
  }
  function K(e) {
    return Ee(e, { props: ["quantity", ["mete", Ce.weight.precision]] });
  }
  function X() {
    a.value.list.forEach((e) => {
      e.outboundTime = _.value;
    });
  }
  return (e, i) => {
    const v = ne, x = se, J = V("print-table"), b = ie, Q = ue, Y = V("common-table"), Z = re, ee = V("common-drawer");
    return r(), c(ee, { ref_key: "drawerRef", ref: U, modelValue: o(g), "onUpdate:modelValue": i[1] || (i[1] = (t) => le(g) ? g.value = t : null), "before-close": o(z), "content-loading": d.value, "show-close": true, "custom-class": "raw-mat-application-review-form", size: "100%", title: "出库清单" }, te({ content: n(() => [l(Z, { disabled: L.value, class: "form" }, { default: n(() => [l(Y, { data: a.value.list, "data-format": O.value, "expand-row-keys": T.value, "max-height": o(P), "summary-method": K, "row-key": "id", "show-summary": "" }, { default: n(() => [l(xe, { "basic-class": a.value.basicClass, fixed: "left", "show-outbound-mode": "", showClassification: "" }, null, 8, ["basic-class"]), l(Se, { "basic-class": a.value.basicClass }, null, 8, ["basic-class"]), l(b, { key: "material", align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), l(ke, { "basic-class": a.value.basicClass, "equal-disabled": "" }, null, 8, ["basic-class"]), l(b, { align: "center", label: "领用人", width: "100px" }, { default: n(({ row: t }) => [t.recipient ? (r(), c(Q, { key: 0, content: `${t.recipient.deptName}`, effect: "light", placement: "top" }, { default: n(() => [N("span", null, D(t.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : m("", true)]), _: 1 }), l(b, { align: "center", label: "出库时间", width: "195px" }, { default: n(({ row: t }) => [a.value.reviewStatus === o(f).UNREVIEWED.V ? (r(), c(v, { key: 0, modelValue: t.sourceRow.outboundTime, "onUpdate:modelValue": (k) => t.sourceRow.outboundTime = k, placeholder: "出库时间", type: "datetime", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), R("span", Be, D(t.outboundTime), 1))]), _: 1 }), o(C)(o(w).outbound) && a.value.reviewStatus === o(f).UNREVIEWED.V ? (r(), c(b, { key: 0, align: "left", label: "操作", width: "70px" }, { default: n(({ row: t, $index: k }) => [l(x, { title: `确认删除当前${t.classifyFullName}吗?`, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", onConfirm: (Ne) => q(t, k) }, { reference: n(() => [l(y, { disabled: !!(t.basicClass & o(Ve).STEEL_COIL.V && t.length), loading: s.value, icon: "el-icon-delete", size: "default", type: "danger" }, null, 8, ["disabled", "loading"])]), _: 2 }, 1032, ["title", "onConfirm"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["disabled"])]), _: 2 }, [o(C)(o(w).outbound) ? { name: "titleRight", fn: n(() => [a.value.reviewStatus === o(f).UNREVIEWED.V && o(he)(a.value.list) ? (r(), R(oe, { key: 0 }, [N("span", Te, [l(v, { modelValue: _.value, "onUpdate:modelValue": i[0] || (i[0] = (t) => _.value = t), placeholder: "批量设置出库时间", type: "datetime", "value-format": "x" }, null, 8, ["modelValue"]), l(y, { size: "default", type: "success", onClick: X }, { default: n(() => i[2] || (i[2] = [E("设置")])), _: 1, __: [2] })]), o(C)(o(w).outboundAudit) ? (r(), c(x, { key: 0, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "green", title: "确认通过？", onConfirm: W }, { reference: n(() => [l(y, { loading: s.value, icon: "el-icon-s-promotion", size: "default", type: "primary" }, { default: n(() => i[3] || (i[3] = [E(" 确认出库 ")])), _: 1, __: [3] }, 8, ["loading"])]), _: 1 })) : m("", true), l(x, { "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", title: "确认清空？", onConfirm: G }, { reference: n(() => [l(y, { loading: s.value, icon: "el-icon-document-delete", size: "default", type: "danger" }, { default: n(() => i[4] || (i[4] = [E(" 清 空 ")])), _: 1, __: [4] }, 8, ["loading"])]), _: 1 })], 64)) : m("", true), a.value.reviewStatus === o(f).PASS.V ? (r(), c(J, { key: 1, params: a.value.id, "api-key": "wmsRmOutboundReceipt", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"])) : m("", true)]), key: "0" } : void 0]), 1032, ["modelValue", "before-close", "content-loading"]);
  };
} }, Oe = pe(Re, [["__scopeId", "data-v-d5107420"]]);
export {
  Oe as default
};
