import { ref as k } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as m } from "vue";
import { createBlock as c } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as N } from "vue";
import { createElementBlock as y } from "vue";
import { Fragment as E } from "vue";
import { renderList as H } from "vue";
import { toDisplayString as x } from "vue";
import { createCommentVNode as _ } from "vue";
import { normalizeStyle as A } from "vue";
import { createElementVNode as f } from "vue";
import { ElFormItem as P } from "element-plus";
import { ElRadio as G } from "element-plus";
import { ElRadioGroup as j } from "element-plus";
import { ElInputNumber as Y } from "element-plus";
import { ElInput as K } from "element-plus";
import { ElButton as X } from "element-plus";
import { ElForm as J } from "element-plus";
import { l as b, _ as Q, s9 as U, sa as w, ao as Z, aV as ee, a3 as te, qp as oe, e0 as I, e1 as q } from "../../../../../shared/runtime.js";
import { _ as le } from "../../../../../modules/process-select-b35dffc0.js";
function ae(u) {
  return b({ module: "mes", url: "wage-quota-management/assemble-quota-config/page", method: "get", params: u });
}
function se(u) {
  return b({ module: "mes", url: "wage-quota-management/assemble-quota-config", method: "post", data: u });
}
function ie(u) {
  return b({ module: "mes", url: "wage-quota-management/assemble-quota-config", method: "put", data: u });
}
function ne(u) {
  return b({ module: "mes", url: "wage-quota-management/assemble-quota-config", method: "delete", params: u });
}
function we(u) {
  return b({ module: "mes", url: "wage-quota-management/assemble-quota-config/status", method: "put", params: u });
}
function re(u) {
  return b({ module: "mes", url: "productProcess/assemble-type-process-select", method: "get", params: u });
}
const Ve = { get: ae, add: se, edit: ie, del: ne };
const ue = { class: "detailList" }, de = { class: "detailList" }, me = { class: "classify-group-operation" }, pe = { __name: "form", setup(u) {
  const C = k(), T = k([]), S = { workshopIdList: [], assembleClassIdList: [], calculationWay: void 0, boolSpecificationClass: U.YES.V, classificationWayEnum: w.SECTION_HEIGHT.V, price: void 0, processId: void 0, detailList: [{ sectionHeightNumberOne: void 0, sectionHeightComparisonOperatorOne: void 0, sectionHeightNumberTwo: void 0, sectionHeightComparisonOperatorTwo: void 0, webThicknessNumberOne: void 0, webThicknessComparisonOperatorOne: void 0, webThicknessNumberTwo: void 0, webThicknessComparisonOperatorTwo: void 0, price: void 0 }] }, { crud: g, form: a } = Z(S, C), W = { workshopIdList: [{ required: true, message: "请选择车间", trigger: "change" }], assembleClassIdList: [{ required: true, message: "请选择构件类型", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], boolSpecificationClass: [{ required: true, message: "请选择规格分类", trigger: "change" }], classificationWayEnum: [{ required: true, message: "请选择分类方式", trigger: "change" }], calculationWay: [{ required: true, message: "请选择计算方式", trigger: "change" }], price: [{ required: true, message: "请输入单价", trigger: "blur" }] };
  function M(d) {
    d ? a.detailList = [{ sectionHeightNumberOne: void 0, sectionHeightComparisonOperatorOne: void 0, sectionHeightNumberTwo: void 0, sectionHeightComparisonOperatorTwo: void 0, webThicknessNumberOne: void 0, webThicknessComparisonOperatorOne: void 0, webThicknessNumberTwo: void 0, webThicknessComparisonOperatorTwo: void 0, price: void 0 }] : a.detailList = [];
  }
  function B(d) {
    d.push({ sectionHeightNumberOne: void 0, sectionHeightComparisonOperatorOne: void 0, sectionHeightNumberTwo: void 0, sectionHeightComparisonOperatorTwo: void 0, webThicknessNumberOne: void 0, webThicknessComparisonOperatorOne: void 0, webThicknessNumberTwo: void 0, webThicknessComparisonOperatorTwo: void 0, price: void 0 });
  }
  function z(d, s) {
    d.splice(s, 1);
  }
  return (async () => {
    try {
      const { content: d } = await re({ mesProductEnum: 1 });
      T.value = d || [];
    } catch (d) {
      console.log(d);
    }
  })(), (d, s) => {
    const $ = V("common-button"), n = P, p = V("common-select"), D = G, F = j, O = Y, h = K, L = X, R = J, v = V("common-dialog");
    return m(), c(v, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(g).cancelCU, visible: e(g).status.cu > 0, title: e(g).status.title, top: "5vh", width: "750px" }, { titleRight: l(() => [o($, { loading: e(g).status.cu === 2, type: "primary", size: "default", onClick: e(g).submitCU }, { default: l(() => s[7] || (s[7] = [N("确认")])), _: 1, __: [7] }, 8, ["loading", "onClick"])]), default: l(() => [o(R, { ref_key: "formRef", ref: C, model: e(a), rules: W, size: "default", "label-width": "160px" }, { default: l(() => [o(n, { label: "适用车间", prop: "workshopIdList" }, { default: l(() => [o(e(ee), { modelValue: e(a).workshopIdList, "onUpdate:modelValue": s[0] || (s[0] = (t) => e(a).workshopIdList = t), placeholder: "请选择车间", style: { width: "340px" }, multiple: "", "collapse-tags": "", class: "filter-item", clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), o(n, { label: "类型：", prop: "assembleClassIdList" }, { default: l(() => [o(p, { modelValue: e(a).assembleClassIdList, "onUpdate:modelValue": s[1] || (s[1] = (t) => e(a).assembleClassIdList = t), options: T.value, placeholder: "选择构件类型", type: "other", "data-structure": { key: "typeId", label: "typeName", value: "typeId" }, clearable: "", filterable: "", multiple: "", "collapse-tags": "", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), o(n, { label: "工序：", prop: "processId" }, { default: l(() => [o(e(le), { ref: "processSelectRef", modelValue: e(a).processId, "onUpdate:modelValue": s[2] || (s[2] = (t) => e(a).processId = t), productType: e(te).ASSEMBLE.V, size: "default", filterable: "", clearable: "", multiple: false, style: { width: "340px" } }, null, 8, ["modelValue", "productType"])]), _: 1 }), o(n, { label: "规格分类：", prop: "classificationWayEnum" }, { default: l(() => [o(F, { modelValue: e(a).classificationWayEnum, "onUpdate:modelValue": s[3] || (s[3] = (t) => e(a).classificationWayEnum = t), onChange: M }, { default: l(() => [(m(true), y(E, null, H(e(w).ENUM, (t) => (m(), c(D, { key: t.V, value: t.V }, { default: l(() => [N(x(t.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), o(n, { label: "计算方式：", prop: "calculationWay" }, { default: l(() => [o(p, { modelValue: e(a).calculationWay, "onUpdate:modelValue": s[4] || (s[4] = (t) => e(a).calculationWay = t), options: e(oe).ENUM, placeholder: "选择计算方式", type: "enum", clearable: "", filterable: "", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), e(a).boolSpecificationClass === e(U).NO.V ? (m(), c(n, { key: 0, label: "单价：", prop: "price" }, { default: l(() => [o(O, { modelValue: e(a).price, "onUpdate:modelValue": s[5] || (s[5] = (t) => e(a).price = t), placeholder: "输入单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 })) : _("", true), e(a).classificationWayEnum ? (m(true), y(E, { key: 1 }, H(e(a).detailList, (t, r) => (m(), y("div", { class: "classify-group", key: r, style: A({ "align-items": e(a).classificationWayEnum === e(w).SECTION_HEIGHT_AND_WEB_THICKNESS.V ? "center" : "flex-start" }) }, [f("div", null, [o(n, { label: `截面分类(mm)(${r + 1})` }, { default: l(() => [f("div", ue, [o(n, { prop: "detailList." + r + ".sectionHeightNumberOne", rules: { required: true, message: "请填写", trigger: "blur" } }, { default: l(() => [o(h, { modelValue: t.sectionHeightNumberOne, "onUpdate:modelValue": (i) => t.sectionHeightNumberOne = i, modelModifiers: { number: true }, clearable: "", placeholder: "数字", type: "number", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), o(n, { prop: "detailList." + r + ".sectionHeightComparisonOperatorOne", rules: { required: true, message: "请选择", trigger: "change" } }, { default: l(() => [o(p, { modelValue: t.sectionHeightComparisonOperatorOne, "onUpdate:modelValue": (i) => t.sectionHeightComparisonOperatorOne = i, options: e(I).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), s[8] || (s[8] = f("span", { class: "station-text" }, "X", -1)), o(n, { prop: "detailList." + r + ".sectionHeightComparisonOperatorTwo", rules: { required: true, message: "请选择", trigger: "change" } }, { default: l(() => [o(p, { modelValue: t.sectionHeightComparisonOperatorTwo, "onUpdate:modelValue": (i) => t.sectionHeightComparisonOperatorTwo = i, options: e(q).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), o(n, { prop: "detailList." + r + ".sectionHeightNumberTwo", rules: { required: true, message: "请填写", trigger: "blur" } }, { default: l(() => [o(h, { modelValue: t.sectionHeightNumberTwo, "onUpdate:modelValue": (i) => t.sectionHeightNumberTwo = i, modelModifiers: { number: true }, clearable: "", placeholder: "数字", type: "number", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"])])]), _: 2 }, 1032, ["label"]), e(a).classificationWayEnum === e(w).SECTION_HEIGHT_AND_WEB_THICKNESS.V ? (m(), c(n, { key: 0, label: `腹板厚度分类(mm)(${r + 1})` }, { default: l(() => [f("div", de, [o(n, { prop: "detailList." + r + ".webThicknessNumberOne", rules: { required: true, message: "请填写", trigger: "blur" } }, { default: l(() => [o(h, { modelValue: t.webThicknessNumberOne, "onUpdate:modelValue": (i) => t.webThicknessNumberOne = i, modelModifiers: { number: true }, clearable: "", placeholder: "数字", type: "number", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), o(n, { prop: "detailList." + r + ".webThicknessComparisonOperatorOne", rules: { required: true, message: "请选择", trigger: "change" } }, { default: l(() => [o(p, { modelValue: t.webThicknessComparisonOperatorOne, "onUpdate:modelValue": (i) => t.webThicknessComparisonOperatorOne = i, options: e(I).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), s[9] || (s[9] = f("span", { class: "station-text" }, "X", -1)), o(n, { prop: "detailList." + r + ".webThicknessComparisonOperatorTwo", rules: { required: true, message: "请选择", trigger: "change" } }, { default: l(() => [o(p, { modelValue: t.webThicknessComparisonOperatorTwo, "onUpdate:modelValue": (i) => t.webThicknessComparisonOperatorTwo = i, options: e(q).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), o(n, { prop: "detailList." + r + ".webThicknessNumberTwo", rules: { required: true, message: "请填写", trigger: "blur" } }, { default: l(() => [o(h, { modelValue: t.webThicknessNumberTwo, "onUpdate:modelValue": (i) => t.webThicknessNumberTwo = i, modelModifiers: { number: true }, clearable: "", placeholder: "数字", type: "number", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"])])]), _: 2 }, 1032, ["label"])) : _("", true)]), f("div", me, [o(n, { prop: "detailList." + r + ".price", rules: { required: true, message: "请填写单价", trigger: "blur" } }, { default: l(() => [o(O, { modelValue: t.price, "onUpdate:modelValue": (i) => t.price = i, placeholder: "单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "120px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), r === 0 ? (m(), c(L, { key: 0, class: "detailList-button", icon: "el-icon-plus", size: "default", type: "primary", onClick: s[6] || (s[6] = (i) => B(e(a).detailList)) })) : _("", true), r > 0 ? (m(), c(L, { key: 1, class: "detailList-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (i) => z(e(a).detailList, r) }, null, 8, ["onClick"])) : _("", true)])], 4))), 128)) : _("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ce = Q(pe, [["__scopeId", "data-v-b07edf6f"]]), ye = Object.freeze(Object.defineProperty({ __proto__: null, default: ce }, Symbol.toStringTag, { value: "Module" }));
export {
  Ve as c,
  ne as d,
  we as e,
  ye as f,
  ce as m
};
