import { ref as q } from "vue";
import { inject as P } from "vue";
import { computed as H } from "vue";
import { nextTick as Q } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as m } from "vue";
import { createBlock as O } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { createTextVNode as z } from "vue";
import { createElementBlock as I } from "vue";
import { Fragment as h } from "vue";
import { renderList as C } from "vue";
import { toDisplayString as Y } from "vue";
import { createElementVNode as N } from "vue";
import { createCommentVNode as K } from "vue";
import { ElFormItem as G } from "element-plus";
import { ElRadio as W } from "element-plus";
import { ElRadioGroup as X } from "element-plus";
import { ElOption as J } from "element-plus";
import { ElSelect as Z } from "element-plus";
import { ElInputNumber as ee } from "element-plus";
import { ElForm as oe } from "element-plus";
import { _ as te, s3 as E, ao as ne, qe as p, qa as y, aV as ae, a3 as le, e0 as ie, e1 as re } from "../../../../../shared/runtime.js";
import { _ as se } from "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const de = { class: "conditionList" }, ue = { __name: "form", setup(me) {
  const w = q(), R = { branchCompanyIdList: [], workshopIdList: [], assembleClassIdList: [], processId: void 0, quotaType: E.CONSTANT.V, conditionList: [], measureUnit: void 0, organizationInsidePrice: void 0, organizationOutsidePrice: void 0 }, x = P("assembleClassIdList"), S = P("branchList"), { crud: c, form: n, CRUD: T } = ne(R, w), $ = H(() => n.processId === 38 ? [p.TON.L, p.METER.L, p.PIECE.L, p.PERFORATE_QUANTITY.L] : [p.TON.L, p.METER.L, p.PIECE.L]), L = (r, e) => {
    const i = ["numberOne", "comparisonOperatorOne", "comparisonOperatorTwo", "numberTwo"].filter((s) => s !== e).map((s) => r[s]).some((s) => s != null && s !== ""), _ = r[e];
    return !(i && (_ == null || _ === ""));
  }, f = q({ branchCompanyIdList: [{ required: true, message: "请选择适用机构", trigger: "change" }], workshopIdList: [{ required: true, message: "请选择适用车间", trigger: "change" }], assembleClassIdList: [{ required: true, message: "请选择部件类型", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], quotaType: [{ required: true, message: "请选择规格分类", trigger: "change" }], measureUnit: [{ required: true, message: "请输入计量单位", trigger: "change" }], organizationInsidePrice: [{ required: true, message: "请输入编制内单价", trigger: "blur" }], organizationOutsidePrice: [{ required: true, message: "请输入编制外单价", trigger: "blur" }] });
  Q(() => {
    Object.values(y.V).map((r) => ({ conditionEnum: r.V })).forEach((r, e) => {
      f.value[`conditionList.${e}.numberOne`] = [{ validator: () => L(n.conditionList[e], "numberOne"), message: "请填写", trigger: "blur" }], f.value[`conditionList.${e}.comparisonOperatorOne`] = [{ validator: () => L(n.conditionList[e], "comparisonOperatorOne"), message: "请选择", trigger: "change" }], f.value[`conditionList.${e}.comparisonOperatorTwo`] = [{ validator: () => L(n.conditionList[e], "comparisonOperatorTwo"), message: "请选择", trigger: "change" }], f.value[`conditionList.${e}.numberTwo`] = [{ validator: () => L(n.conditionList[e], "numberTwo"), message: "请填写", trigger: "blur" }];
    });
  });
  function A(r) {
    r === E.VARIABLE.V ? n.conditionList = Object.values(y.V).map((e) => ({ conditionEnum: e.V, numberOne: void 0, comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberTwo: void 0 })) : n.conditionList = [];
  }
  T.HOOK.beforeSubmit = () => {
    n.conditionList = n.conditionList.filter((r) => r.comparisonOperatorOne);
  };
  function U(r = []) {
    return Object.values(y.V).map((d) => ({ conditionEnum: d.V })).map((d) => r.find((i) => i.conditionEnum === d.conditionEnum) || { conditionEnum: d.conditionEnum, numberOne: void 0, comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberTwo: void 0 });
  }
  return T.HOOK.afterAddError = () => {
    n.conditionList = U(n.conditionList);
  }, T.HOOK.afterEditError = () => {
    n.conditionList = U(n.conditionList);
  }, (r, e) => {
    const d = g("common-button"), b = g("common-select-v2"), i = G, _ = W, s = X, v = g("common-input-number"), B = g("common-select"), F = J, M = Z, k = ee, j = oe, D = g("common-dialog");
    return m(), O(D, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(c).cancelCU, visible: t(c).status.cu > 0, title: t(c).status.title, top: "2vh", width: "600px" }, { titleRight: l(() => [a(d, { loading: t(c).status.cu === 2, type: "primary", size: "default", onClick: t(c).submitCU }, { default: l(() => e[8] || (e[8] = [z("确认")])), _: 1, __: [8] }, 8, ["loading", "onClick"])]), default: l(() => [a(j, { ref_key: "formRef", ref: w, model: t(n), rules: f.value, size: "default", "label-width": "150px" }, { default: l(() => [a(i, { label: "适用机构：", prop: "branchCompanyIdList" }, { default: l(() => [a(b, { modelValue: t(n).branchCompanyIdList, "onUpdate:modelValue": e[0] || (e[0] = (o) => t(n).branchCompanyIdList = o), options: t(S), "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", multiple: "", "collapse-tags": "", type: "other", size: "default", placeholder: "选择适用机构", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), a(i, { label: "适用车间：", prop: "workshopIdList" }, { default: l(() => [a(t(ae), { modelValue: t(n).workshopIdList, "onUpdate:modelValue": e[1] || (e[1] = (o) => t(n).workshopIdList = o), placeholder: "选择适用车间", multiple: "", "collapse-tags": "", clearable: "", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 }), a(i, { label: "部件类型：", prop: "assembleClassIdList" }, { default: l(() => [a(b, { modelValue: t(n).assembleClassIdList, "onUpdate:modelValue": e[2] || (e[2] = (o) => t(n).assembleClassIdList = o), options: t(x), placeholder: "选择部件类型", type: "other", "data-structure": { key: "typeId", label: "typeName", value: "typeId" }, clearable: "", filterable: "", multiple: "", "collapse-tags": "", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), a(i, { label: "工序：", prop: "processId" }, { default: l(() => [a(t(se), { ref: "processSelectRef", modelValue: t(n).processId, "onUpdate:modelValue": e[3] || (e[3] = (o) => t(n).processId = o), productType: t(le).ASSEMBLE.V, size: "default", filterable: "", clearable: "", multiple: false, style: { width: "340px" } }, null, 8, ["modelValue", "productType"])]), _: 1 }), a(i, { label: "定额类型：", prop: "quotaType" }, { default: l(() => [a(s, { modelValue: t(n).quotaType, "onUpdate:modelValue": e[4] || (e[4] = (o) => t(n).quotaType = o), onChange: A, style: { width: "340px" } }, { default: l(() => [(m(true), I(h, null, C(t(E).ENUM, (o) => (m(), O(_, { key: o.V, value: o.V }, { default: l(() => [z(Y(o.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(n).quotaType === t(E).VARIABLE.V ? (m(true), I(h, { key: 0 }, C(t(n).conditionList, (o, V) => (m(), O(i, { key: o.conditionEnum, label: `${t(y).VL[o.conditionEnum]}：`, prop: "v.conditionEnum" }, { default: l(() => [N("div", de, [a(i, { prop: `conditionList.${V}.numberOne` }, { default: l(() => [a(v, { modelValue: o.numberOne, "onUpdate:modelValue": (u) => o.numberOne = u, step: 1, min: 0, max: 999999999, controls: false, precision: 0, placeholder: "数字", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), a(i, { prop: `conditionList.${V}.comparisonOperatorOne` }, { default: l(() => [a(B, { modelValue: o.comparisonOperatorOne, "onUpdate:modelValue": (u) => o.comparisonOperatorOne = u, options: t(ie).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), e[9] || (e[9] = N("span", { class: "station-text" }, "X", -1)), a(i, { prop: `conditionList.${V}.comparisonOperatorTwo` }, { default: l(() => [a(b, { modelValue: o.comparisonOperatorTwo, "onUpdate:modelValue": (u) => o.comparisonOperatorTwo = u, options: t(re).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), a(i, { prop: `conditionList.${V}.numberTwo` }, { default: l(() => [a(v, { modelValue: o.numberTwo, "onUpdate:modelValue": (u) => o.numberTwo = u, step: 1, min: 0, max: 999999999, controls: false, precision: 0, placeholder: "数字", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"])])]), _: 2 }, 1032, ["label"]))), 128)) : K("", true), a(i, { label: "计量单位：", prop: "measureUnit" }, { default: l(() => [a(M, { modelValue: t(n).measureUnit, "onUpdate:modelValue": e[5] || (e[5] = (o) => t(n).measureUnit = o), clearable: "", size: "default", placeholder: "计量单位", style: { width: "340px" } }, { default: l(() => [(m(true), I(h, null, C($.value, (o) => (m(), O(F, { key: o, label: o, value: o }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), a(i, { label: "编制内单价（元）：", prop: "organizationInsidePrice" }, { default: l(() => [a(k, { modelValue: t(n).organizationInsidePrice, "onUpdate:modelValue": e[6] || (e[6] = (o) => t(n).organizationInsidePrice = o), placeholder: "输入单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 }), a(i, { label: "编制外单价（元）：", prop: "organizationOutsidePrice" }, { default: l(() => [a(k, { modelValue: t(n).organizationOutsidePrice, "onUpdate:modelValue": e[7] || (e[7] = (o) => t(n).organizationOutsidePrice = o), placeholder: "输入单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Le = te(ue, [["__scopeId", "data-v-6cb3ec89"]]);
export {
  Le as default
};
