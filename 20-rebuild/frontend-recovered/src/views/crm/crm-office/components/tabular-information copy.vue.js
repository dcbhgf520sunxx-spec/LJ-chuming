import { ref as x } from "vue";
import { computed as h } from "vue";
import { watchEffect as P } from "vue";
import { watch as k } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as t } from "vue";
import { createBlock as u } from "vue";
import { withCtx as y } from "vue";
import { createElementVNode as g } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as O } from "vue";
import { renderList as w } from "vue";
import { normalizeStyle as V } from "vue";
import { toDisplayString as T } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as B } from "vue";
import { unref as E } from "vue";
import { ElInput as $ } from "element-plus";
import { ElCheckbox as j } from "element-plus";
import { ElCheckboxGroup as M } from "element-plus";
import { ElDatePicker as z } from "element-plus";
import { ElFormItem as G } from "element-plus";
import { ElForm as J } from "element-plus";
import { _ as W, dA as _, R as Q, S as q } from "../../../../shared/runtime.js";
import { _ as H } from "../../../../modules/region-cascader-39b54da2.js";
const X = { class: "table-body-box" }, Y = { __name: "tabular-information copy", props: { informationList: { type: Array, default: () => [] }, currenSignIn: { type: Number, default: void 0 }, followUpForm: { type: Object, default: () => {
} }, readyCheckForm: { type: Object, default: () => {
} }, tenderForm: { type: Object, default: () => {
} }, giveUpForm: { type: Object, default: () => {
} } }, setup(U, { expose: C }) {
  const r = U, a = x({}), N = x(), I = h(() => {
    const n = [];
    return r.formItemList.forEach((o) => {
      o.fillOutType === "table" && o.isShow && n.push(o.argumentName);
    }), n;
  }), F = h(() => {
    const n = {};
    return r.formItemList.forEach((o) => {
      o.isShow && (n[o.argumentName] = o.rules);
    }), n;
  });
  P(() => {
    I.value.forEach((n) => {
      k(() => a.value[n], (o) => {
        var d;
        (d = N.value) == null || d.validateField(n);
      }, { deep: true });
    });
  }), k(() => r.currenSignIn, () => {
    switch (a.value = {}, r.currenSignIn) {
      case _.PROJECT_TRACK_DOWN.V:
        a.value = r.followUpForm;
        break;
      case _.QUALIFICATION_REVIEW.V:
        a.value = r.readyCheckForm;
        break;
      case _.APPLICATION_TENDER.V:
        a.value = r.tenderForm;
        break;
      case _.PROJECT_GIVE_UP.V:
        a.value = r.giveUpForm;
        break;
      default:
        a.value = {};
    }
  }, { immediate: true });
  function A(n, o) {
    console.log(`value:${n}`, `key: ${o}`);
    let d, m, i;
    r.informationList.forEach((p) => {
      p.fieldName === "计划开工日期" && (d = p.argumentName), p.fieldName === "计划完工日期" && (m = p.argumentName), p.fieldName === "总工期" && (i = p.argumentName);
    });
    const c = Number(a.value[d]), f = Number(a.value[m]);
    c && f && (a.value[i] = Math.floor(Math.abs(c - f) / 864e5), console.log(a.value[d], "satrtKey"), console.log(a.value[m], "endKey"));
  }
  function D(n) {
    let o = false;
    return n instanceof Array ? o = true : o = false, o;
  }
  return C({ submitForm: h(() => a.value) }), (n, o) => {
    const d = $, m = b("common-select"), i = j, c = M, f = z, p = b("common-input-number"), L = b("common-radio"), R = G, S = J;
    return t(), u(S, { ref_key: "formRef", ref: N, "label-width": "135px", "label-position": "right", model: a.value, rules: F.value }, { default: y(() => [g("div", X, [(t(true), v(O, null, w(r.informationList, (e, K) => (t(), v("div", { class: "cells-item", style: V({ width: e.span === 1 ? "902px" : "451px" }), key: K }, [g("span", { class: "cells-label", style: V({ height: e.fillOutType === "table" ? "117px" : "48px", "line-height": e.fillOutType === "table" ? "117px" : "48px" }) }, T(e.fieldName), 5), g("span", { class: "cells-value", style: V({ width: e.span === 1 ? `${902 - 130}px` : `${448 - 162}px`, height: e.fillOutType === "table" ? "117px" : "48px", "line-height": e.fillOutType === "table" ? "40px" : "48px" }) }, [e.isShow ? (t(), u(R, { key: 0, prop: e.argumentName }, { default: y(() => [e.fillOutType === "input" ? (t(), u(d, { key: 0, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, style: { width: "100%", height: "100%" }, class: "input-border-none", disabled: e.boolDisabled }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])) : s("", true), e.fillOutType === "select" ? (t(), u(m, { key: 1, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, style: { width: "100%", height: "100%" }, options: e.myOptions, class: "input-border-none", disabled: e.boolDisabled }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"])) : s("", true), e.fillOutType === "checkBox" && D(a.value[e.argumentName]) ? (t(), u(c, { key: 2, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, style: { "line-height": "65px" } }, { default: y(() => [(t(true), v(O, null, w(e.myOptions, (l) => (t(), u(i, { key: l.K, label: l.V, value: l.V }, { default: y(() => [B(T(l.L), 1)]), _: 2 }, 1032, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])) : s("", true), e.fillOutType === "datePicker" ? (t(), u(f, { key: 3, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, style: { width: "100%", height: "100%" }, "value-format": "x", class: "input-border-none", disabled: e.boolDisabled, onChange: (l) => A(a.value[e.argumentName], e.argumentName) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])) : s("", true), e.fillOutType === "numInput" ? (t(), u(p, { key: 4, class: "input-border-none", controls: false, style: { width: "100%" }, clearable: "", modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, min: 0, max: 999999999, precision: 2, step: 0.01 }, null, 8, ["modelValue", "onUpdate:modelValue"])) : s("", true), e.fillOutType === "regionCascader" ? (t(), u(E(H), { key: 5, style: { width: "100%", height: "100%" }, class: "input-border-none" })) : s("", true), e.fillOutType === "textareaInput" ? (t(), u(d, { key: 6, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, style: { width: "100%", height: "100%" }, type: "textarea", class: "input-border-none" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : s("", true), e.fillOutType === "radio" ? (t(), u(L, { key: 7, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, options: e.myOptions, style: { height: "100%", width: "100%", "line-height": "65px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : s("", true), e.fillOutType === "table" ? (t(), u(Q, { key: 8, files: a.value[e.argumentName], "onUpdate:files": (l) => a.value[e.argumentName] = l, showView: "", "show-download": "", delDisabled: true, "file-classify": E(q).RECORD_ATT.V }, null, 8, ["files", "onUpdate:files", "file-classify"])) : s("", true)]), _: 2 }, 1032, ["prop"])) : s("", true)], 4)], 4))), 128))])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, oe = W(Y, [["__scopeId", "data-v-629f15a9"]]);
export {
  oe as default
};
