import { ref as h } from "vue";
import { computed as v } from "vue";
import { watchEffect as M } from "vue";
import { watch as w } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as r } from "vue";
import { createBlock as s } from "vue";
import { withCtx as i } from "vue";
import { createVNode as E } from "vue";
import { createElementBlock as D } from "vue";
import { Fragment as U } from "vue";
import { renderList as O } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as W } from "vue";
import { toDisplayString as G } from "vue";
import { unref as I } from "vue";
import { ElInput as J } from "element-plus";
import { ElCheckbox as q } from "element-plus";
import { ElCheckboxGroup as z } from "element-plus";
import { ElDatePicker as Q } from "element-plus";
import { ElFormItem as H } from "element-plus";
import { ElDescriptionsItem as X } from "element-plus";
import { ElDescriptions as Y } from "element-plus";
import { ElForm as Z } from "element-plus";
import { b as ee } from "../../../../modules/project-information-053c195b.js";
import { _ as ae, dA as p, R as le, S as oe } from "../../../../shared/runtime.js";
import { _ as te } from "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
const ne = { __name: "tabular-information", props: { informationList: { type: Array, default: () => [] }, currenSignIn: { type: Number, default: void 0 }, followUpForm: { type: Object, default: () => {
} }, readyCheckForm: { type: Object, default: () => {
} }, tenderForm: { type: Object, default: () => {
} }, giveUpForm: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} } }, setup(N, { expose: T }) {
  const u = N, a = h({}), f = h(), C = h(["followUpMethods", "followUpAttachment", "remark", "cost", "attachmentIds", "abandonAttachment"]), k = h([]), F = v(() => {
    var n;
    const o = [];
    return console.log(u.informationList, "props.informationList"), (n = u.informationList) == null || n.forEach((t) => {
      t.isShow && o.push(t.argumentName);
    }), o;
  }), x = v(() => {
    var n;
    const o = {};
    return (n = u.informationList) == null || n.forEach((t) => {
      t.isShow && (o[t.argumentName] = t.rules);
    }), o;
  });
  M(() => {
    var o;
    (o = F.value) == null || o.forEach((n) => {
      w(() => a.value[n], (t) => {
        var c;
        (c = f.value) == null || c.validateField(n);
      }, { deep: true });
    });
  }), w(() => u.currenSignIn, async () => {
    switch (a.value = {}, u.currenSignIn) {
      case p.PROJECT_TRACK_DOWN.V:
        a.value = u.followUpForm;
        break;
      case p.QUALIFICATION_REVIEW.V:
        a.value = u.readyCheckForm;
        break;
      case p.APPLICATION_TENDER.V:
        a.value = u.tenderForm, await S();
        break;
      case p.PROJECT_GIVE_UP.V:
        a.value = u.giveUpForm;
        break;
      default:
        a.value = {};
    }
  }, { immediate: true });
  function A(o, n) {
    var g;
    console.log(`value:${o}`, `key: ${n}`);
    let t, c, b;
    (g = u.informationList) == null || g.forEach((m) => {
      m.fieldName === "计划开工日期" && (t = m.argumentName), m.fieldName === "计划完工日期" && (c = m.argumentName), m.fieldName === "总工期" && (b = m.argumentName);
    });
    const _ = Number(a.value[t]), y = Number(a.value[c]);
    _ && y && (a.value[b] = Math.floor(Math.abs(_ - y) / 864e5), console.log(a.value[t], "satrtKey"), console.log(a.value[c], "endKey"));
  }
  function R(o, n, t) {
    if (t.fieldName === "计划开工日期" && Number(a.value.endDate)) return o > new Date(Number(a.value.endDate));
    if (t.fieldName === "计划完工日期" && Number(a.value.startDate)) return o < new Date(Number(a.value.startDate));
  }
  function L(o) {
    let n = false;
    return o instanceof Array ? n = true : n = false, n;
  }
  async function S() {
    if (u.currenSignIn === p.APPLICATION_TENDER.V) try {
      const o = await ee({ id: u.currentRow.id });
      k.value = o || [];
    } catch (o) {
      console.log(o, "获取审批的标书类型的列表失败");
    }
  }
  const P = () => new Promise((o, n) => {
    f.value.validate((t) => {
      t ? o(true) : n(false);
    });
  });
  return T({ submitForm: v(() => a.value), initFormRef: v(() => f.value), validateForm: P }), (o, n) => {
    const t = J, c = V("common-select-v2"), b = q, _ = z, y = Q, g = V("common-input-number"), m = V("common-radio"), $ = H, K = X, j = Y, B = Z;
    return N.currenSignIn ? (r(), s(B, { key: 0, ref_key: "formRef", ref: f, model: a.value, rules: x.value, class: "demo-form" }, { default: i(() => [E(j, { class: "margin-top", column: 2, border: "" }, { default: i(() => [(r(true), D(U, null, O(u.informationList, (e) => (r(), s(K, { span: C.value.includes(e.argumentName) ? 2 : 1, key: e, label: e.fieldName, "label-class-name": e.isWrite ? "my-label" : "" }, { default: i(() => [E($, { label: "", prop: e.argumentName }, { default: i(() => [e.fillOutType === "input" ? (r(), s(t, { key: 0, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, style: { width: "100%", height: "100%" }, class: "input-border-none", maxlength: "50", clearable: "", disabled: e.boolDisabled, placeholder: `请填写${e.fieldName}` }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "placeholder"])) : d("", true), e.fillOutType === "select" ? (r(), s(c, { key: 1, style: { width: "100%" }, clearable: "", filterable: "", modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, options: e.myOptions, dataStructure: { value: "id", label: "name", key: "id" }, type: "other", class: "input-border-none", disabled: e.boolDisabled, placeholder: `请选择${e.fieldName}` }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled", "placeholder"])) : d("", true), e.fillOutType === "checkBox" && L(a.value[e.argumentName]) ? (r(), s(_, { key: 2, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l }, { default: i(() => [(r(true), D(U, null, O(e.myOptions, (l) => (r(), s(b, { key: l.K, label: l.V, value: l.V, disabled: !!(e.argumentName === "tenderRequirement" && k.value.includes(l.V)) }, { default: i(() => [W(G(l.L), 1)]), _: 2 }, 1032, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])) : d("", true), e.fillOutType === "datePicker" ? (r(), s(y, { key: 3, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, style: { width: "100%", height: "100%" }, "value-format": "x", clearable: "", class: "input-border-none", placeholder: `请选择${e.fieldName}`, disabled: e.boolDisabled, "disabled-date": (l) => R(l, a.value[e.argumentName], e), onChange: (l) => A(a.value[e.argumentName], e.argumentName) }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder", "disabled", "disabled-date", "onChange"])) : d("", true), e.fillOutType === "numInput" ? (r(), s(g, { key: 4, class: "input-border-none", controls: false, style: { width: "100%" }, clearable: "", modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, min: 0, max: 999999999, precision: 2, step: 0.01, placeholder: `请填写${e.fieldName}` }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])) : d("", true), e.fillOutType === "regionCascader" ? (r(), s(I(te), { key: 5, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, style: { width: "100%", height: "100%" }, class: "input-border-none", clearable: "", checkStrictly: true, placeholder: `请选择${e.fieldName}` }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])) : d("", true), e.fillOutType === "textareaInput" ? (r(), s(t, { key: 6, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, style: { width: "100%", height: "100%" }, type: "textarea", maxlength: "500", clearable: "", class: "input-border-none", placeholder: `请填写${e.fieldName}` }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])) : d("", true), e.fillOutType === "radio" ? (r(), s(m, { key: 7, modelValue: a.value[e.argumentName], "onUpdate:modelValue": (l) => a.value[e.argumentName] = l, options: e.myOptions, style: { height: "100%", width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : d("", true), e.fillOutType === "table" ? (r(), s(le, { key: 8, files: a.value[e.argumentName], "onUpdate:files": (l) => a.value[e.argumentName] = l, showView: "", "show-download": "", delDisabled: !N.currenSignIn, "file-classify": I(oe).RECORD_ATT.V }, null, 8, ["files", "onUpdate:files", "delDisabled", "file-classify"])) : d("", true)]), _: 2 }, 1032, ["prop"])]), _: 2 }, 1032, ["span", "label", "label-class-name"]))), 128))]), _: 1 })]), _: 1 }, 8, ["model", "rules"])) : d("", true);
  };
} }, ie = ae(ne, [["__scopeId", "data-v-35f064e2"]]);
export {
  ie as default
};
