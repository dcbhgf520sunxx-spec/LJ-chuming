import { ref as O } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as d } from "vue";
import { createBlock as p } from "vue";
import { withCtx as r } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as w } from "vue";
import { createElementBlock as h } from "vue";
import { Fragment as I } from "vue";
import { renderList as T } from "vue";
import { toDisplayString as A } from "vue";
import { createCommentVNode as f } from "vue";
import { createElementVNode as k } from "vue";
import { ElFormItem as z } from "element-plus";
import { ElRadio as $ } from "element-plus";
import { ElRadioGroup as D } from "element-plus";
import { ElInputNumber as P } from "element-plus";
import { ElInput as Y } from "element-plus";
import { ElButton as G } from "element-plus";
import { ElForm as j } from "element-plus";
import { g as H } from "../../../../../modules/artifact-quota-config-9f8a0591.js";
import { _ as X, s9 as _, ao as J, aV as K, a3 as Q, qq as U, e0 as Z, e1 as ee } from "../../../../../shared/runtime.js";
import { _ as te } from "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const oe = { class: "detailList" }, le = { __name: "form", setup(ae) {
  const g = O(), E = { workshopIdList: [], artifactClassIdList: [], calculationWay: void 0, boolSpecificationClass: _.NO.V, price: void 0, processId: void 0, detailList: [] }, y = O([]), { crud: c, form: l } = J(E, g), S = { workshopIdList: [{ required: true, message: "请选择适用车间", trigger: "change" }], artifactClassIdList: [{ required: true, message: "请选择构件类型", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], boolSpecificationClass: [{ required: true, message: "请选择规格分类", trigger: "change" }], calculationWay: [{ required: true, message: "请选择计算方式", trigger: "change" }], price: [{ required: true, message: "请输入单价", trigger: "blur" }] };
  function q(n) {
    n ? l.detailList = [{ comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberOne: void 0, numberTwo: void 0, price: void 0 }] : l.detailList = [];
  }
  function N(n) {
    n.push({ comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberOne: void 0, numberTwo: void 0, price: void 0 });
  }
  function W(n, a) {
    n.splice(a, 1);
  }
  async function x() {
    try {
      const { content: n } = await H({ mesProductEnum: 1 });
      y.value = n || [];
    } catch (n) {
      console.log(n);
    }
  }
  return x(), (n, a) => {
    const B = b("common-button"), s = z, m = b("common-select"), F = $, M = D, V = P, L = Y, C = G, R = j, v = b("common-dialog");
    return d(), p(v, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(c).cancelCU, visible: e(c).status.cu > 0, title: e(c).status.title, top: "5vh", width: "700px" }, { titleRight: r(() => [o(B, { loading: e(c).status.cu === 2, type: "primary", size: "default", onClick: e(c).submitCU }, { default: r(() => a[7] || (a[7] = [w("确认")])), _: 1, __: [7] }, 8, ["loading", "onClick"])]), default: r(() => [o(R, { ref_key: "formRef", ref: g, model: e(l), rules: S, size: "default", "label-width": "120px" }, { default: r(() => [o(s, { label: "适用车间：", prop: "workshopIdList" }, { default: r(() => [o(e(K), { modelValue: e(l).workshopIdList, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(l).workshopIdList = t), placeholder: "选择适用车间", multiple: "", "collapse-tags": "", clearable: "", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 }), o(s, { label: "构件类型：", prop: "artifactClassIdList" }, { default: r(() => [o(m, { modelValue: e(l).artifactClassIdList, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(l).artifactClassIdList = t), options: y.value, placeholder: "选择构件类型", type: "other", "data-structure": { key: "typeId", label: "typeName", value: "typeId" }, clearable: "", filterable: "", multiple: "", "collapse-tags": "", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), o(s, { label: "工序：", prop: "processId" }, { default: r(() => [o(e(te), { ref: "processSelectRef", modelValue: e(l).processId, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(l).processId = t), productType: e(Q).ARTIFACT.V, size: "default", filterable: "", clearable: "", multiple: false, style: { width: "340px" } }, null, 8, ["modelValue", "productType"])]), _: 1 }), o(s, { label: "规格分类：", prop: "boolSpecificationClass" }, { default: r(() => [o(M, { modelValue: e(l).boolSpecificationClass, "onUpdate:modelValue": a[3] || (a[3] = (t) => e(l).boolSpecificationClass = t), onChange: q }, { default: r(() => [(d(true), h(I, null, T(e(_).ENUM, (t) => (d(), p(F, { key: t.V, value: t.V }, { default: r(() => [w(A(t.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), o(s, { label: "计算方式：", prop: "calculationWay" }, { default: r(() => [o(m, { modelValue: e(l).calculationWay, "onUpdate:modelValue": a[4] || (a[4] = (t) => e(l).calculationWay = t), options: e(U).ENUM, placeholder: "选择计算方式", type: "enum", clearable: "", filterable: "", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), e(l).boolSpecificationClass === e(_).NO.V ? (d(), p(s, { key: 0, label: "单价：", prop: "price" }, { default: r(() => [o(V, { modelValue: e(l).price, "onUpdate:modelValue": a[5] || (a[5] = (t) => e(l).price = t), placeholder: "输入单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 })) : f("", true), e(l).boolSpecificationClass === e(_).YES.V && e(l).calculationWay ? (d(true), h(I, { key: 1 }, T(e(l).detailList, (t, u) => (d(), p(s, { key: u, label: `${e(l).calculationWay === e(U).ARTIFACT_WEIGHT.V ? "重量" : "零件数量"}（${u + 1}）` }, { default: r(() => [k("div", oe, [o(s, { prop: "detailList." + u + ".numberOne", rules: { required: true, message: "请填写", trigger: "blur" } }, { default: r(() => [o(L, { modelValue: t.numberOne, "onUpdate:modelValue": (i) => t.numberOne = i, modelModifiers: { number: true }, clearable: "", placeholder: "数字", type: "number", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), o(s, { prop: "detailList." + u + ".comparisonOperatorOne", rules: { required: true, message: "请选择", trigger: "change" } }, { default: r(() => [o(m, { modelValue: t.comparisonOperatorOne, "onUpdate:modelValue": (i) => t.comparisonOperatorOne = i, options: e(Z).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), a[8] || (a[8] = k("span", { class: "station-text" }, "X", -1)), o(s, { prop: "detailList." + u + ".comparisonOperatorTwo", rules: { required: true, message: "请选择", trigger: "change" } }, { default: r(() => [o(m, { modelValue: t.comparisonOperatorTwo, "onUpdate:modelValue": (i) => t.comparisonOperatorTwo = i, options: e(ee).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), o(s, { prop: "detailList." + u + ".numberTwo", rules: { required: true, message: "请填写", trigger: "blur" } }, { default: r(() => [o(L, { modelValue: t.numberTwo, "onUpdate:modelValue": (i) => t.numberTwo = i, modelModifiers: { number: true }, clearable: "", placeholder: "数字", type: "number", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), o(s, { prop: "detailList." + u + ".price", rules: { required: true, message: "请填写单价", trigger: "blur" } }, { default: r(() => [o(V, { modelValue: t.price, "onUpdate:modelValue": (i) => t.price = i, placeholder: "单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "120px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), u === 0 ? (d(), p(C, { key: 0, class: "detailList-button", icon: "el-icon-plus", size: "default", type: "primary", onClick: a[6] || (a[6] = (i) => N(e(l).detailList)) })) : f("", true), u > 0 ? (d(), p(C, { key: 1, class: "detailList-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (i) => W(e(l).detailList, u) }, null, 8, ["onClick"])) : f("", true)])]), _: 2 }, 1032, ["label"]))), 128)) : f("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ce = X(le, [["__scopeId", "data-v-f4bdbfa1"]]);
export {
  ce as default
};
