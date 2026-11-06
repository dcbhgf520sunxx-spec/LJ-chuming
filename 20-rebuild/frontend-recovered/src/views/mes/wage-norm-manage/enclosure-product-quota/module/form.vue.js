import { ref as R } from "vue";
import { computed as D } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as u } from "vue";
import { createBlock as m } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as L } from "vue";
import { createElementBlock as O } from "vue";
import { Fragment as E } from "vue";
import { renderList as h } from "vue";
import { toDisplayString as Y } from "vue";
import { createCommentVNode as f } from "vue";
import { createElementVNode as w } from "vue";
import { ElFormItem as $ } from "element-plus";
import { ElRadio as v } from "element-plus";
import { ElRadioGroup as G } from "element-plus";
import { ElInputNumber as H } from "element-plus";
import { ElInput as K } from "element-plus";
import { ElButton as W } from "element-plus";
import { ElForm as j } from "element-plus";
import { _ as A, s9 as p, sb as k, ao as Q, aV as X, kA as J, e0 as Z, e1 as ee } from "../../../../../shared/runtime.js";
const oe = { class: "detailList" }, le = { __name: "form", setup(te) {
  const g = R(), S = { workshopIdList: [], productType: void 0, boolSpecificationClass: p.NO.V, specificationClassEnum: k.LENGTH.V, price: void 0, detailParamList: [] }, { crud: c, form: o, CRUD: T } = Q(S, g);
  T.HOOK.beforeSubmit = () => {
    o.specificationClassEnum = k.LENGTH.V, o.boolSpecificationClass === p.YES.V && (o.price = void 0), o.boolSpecificationClass === p.NO.V && (o.detailParamList = []);
  };
  const U = D(() => o.boolSpecificationClass === p.NO.V ? "550px" : "700px"), N = { workshopIdList: [{ required: true, message: "请选择适用车间", trigger: "change" }], productType: [{ required: true, message: "请选择产品类型", trigger: "change" }], boolSpecificationClass: [{ required: true, message: "请选择规格分类", trigger: "change" }], price: [{ required: true, message: "请录入单价", trigger: "change" }] };
  function P(d) {
    d ? o.detailParamList = [{ comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberOne: void 0, numberTwo: void 0, price: void 0 }] : o.detailParamList = [];
  }
  function q(d) {
    d.push({ comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberOne: void 0, numberTwo: void 0, price: void 0 });
  }
  function I(d, a) {
    d.splice(a, 1);
  }
  return (d, a) => {
    const x = b("common-button"), s = $, _ = b("common-select"), B = v, M = G, V = H, y = K, C = W, z = j, F = b("common-dialog");
    return u(), m(F, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(c).cancelCU, visible: e(c).status.cu > 0, title: e(c).status.title, top: "5vh", width: U.value }, { titleRight: r(() => [t(x, { loading: e(c).status.cu === 2, type: "primary", size: "default", onClick: e(c).submitCU }, { default: r(() => a[5] || (a[5] = [L("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: r(() => [t(z, { ref_key: "formRef", ref: g, model: e(o), rules: N, size: "small", "label-width": "130px" }, { default: r(() => [t(s, { label: "适用车间：", prop: "workshopIdList" }, { default: r(() => [t(e(X), { modelValue: e(o).workshopIdList, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(o).workshopIdList = l), multiple: "", "collapse-tags": "", clearable: "", placeholder: "选择车间", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 }), t(s, { label: "产品类型：", prop: "productType" }, { default: r(() => [t(_, { modelValue: e(o).productType, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(o).productType = l), options: e(J).ENUM, placeholder: "选择产品类型", type: "enum", clearable: "", filterable: "", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(s, { label: "规格分类：", prop: "boolSpecificationClass" }, { default: r(() => [t(M, { modelValue: e(o).boolSpecificationClass, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(o).boolSpecificationClass = l), size: "small", style: { width: "340px" }, onChange: P }, { default: r(() => [(u(true), O(E, null, h(e(p).ENUM, (l) => (u(), m(B, { key: l.K, label: l.V }, { default: r(() => [L(Y(l.L), 1)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), e(o).boolSpecificationClass === e(p).NO.V ? (u(), m(s, { key: 0, label: "单价（元/米）：", prop: "price" }, { default: r(() => [t(V, { modelValue: e(o).price, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(o).price = l), placeholder: "录入金额", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 })) : f("", true), e(o).boolSpecificationClass === e(p).YES.V ? (u(true), O(E, { key: 1 }, h(e(o).detailParamList, (l, n) => (u(), m(s, { key: n, label: ` 长度（${n + 1}）` }, { default: r(() => [w("div", oe, [t(s, { prop: "detailParamList." + n + ".numberOne", rules: { required: true, message: "请填写", trigger: "blur" } }, { default: r(() => [t(y, { modelValue: l.numberOne, "onUpdate:modelValue": (i) => l.numberOne = i, modelModifiers: { number: true }, clearable: "", placeholder: "数字", type: "number", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), t(s, { prop: "detailParamList." + n + ".comparisonOperatorOne", rules: { required: true, message: "请选择", trigger: "change" } }, { default: r(() => [t(_, { modelValue: l.comparisonOperatorOne, "onUpdate:modelValue": (i) => l.comparisonOperatorOne = i, options: e(Z).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), a[6] || (a[6] = w("span", { class: "station-text" }, "X", -1)), t(s, { prop: "detailParamList." + n + ".comparisonOperatorTwo", rules: { required: true, message: "请选择", trigger: "change" } }, { default: r(() => [t(_, { modelValue: l.comparisonOperatorTwo, "onUpdate:modelValue": (i) => l.comparisonOperatorTwo = i, options: e(ee).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), t(s, { prop: "detailParamList." + n + ".numberTwo", rules: { required: true, message: "请填写", trigger: "blur" } }, { default: r(() => [t(y, { modelValue: l.numberTwo, "onUpdate:modelValue": (i) => l.numberTwo = i, modelModifiers: { number: true }, clearable: "", placeholder: "数字", type: "number", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), t(s, { prop: "detailParamList." + n + ".price", rules: { required: true, message: "请填写单价", trigger: "blur" } }, { default: r(() => [t(V, { modelValue: l.price, "onUpdate:modelValue": (i) => l.price = i, placeholder: "单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "120px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), n === 0 ? (u(), m(C, { key: 0, class: "detailList-button", icon: "el-icon-plus", size: "default", type: "primary", onClick: a[4] || (a[4] = (i) => q(e(o).detailParamList)) })) : f("", true), n > 0 ? (u(), m(C, { key: 1, class: "detailList-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (i) => I(e(o).detailParamList, n) }, null, 8, ["onClick"])) : f("", true)])]), _: 2 }, 1032, ["label"]))), 128)) : f("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title", "width"]);
  };
} }, se = A(le, [["__scopeId", "data-v-450ee98c"]]);
export {
  se as default
};
