import { ref as x } from "vue";
import { inject as h } from "vue";
import { computed as C } from "vue";
import { nextTick as J } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as c } from "vue";
import { createBlock as y } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { unref as n } from "vue";
import { createTextVNode as N } from "vue";
import { createElementBlock as w } from "vue";
import { Fragment as I } from "vue";
import { renderList as T } from "vue";
import { toDisplayString as Z } from "vue";
import { createElementVNode as R } from "vue";
import { createCommentVNode as ee } from "vue";
import { ElFormItem as oe } from "element-plus";
import { ElCascader as te } from "element-plus";
import { ElRadio as ne } from "element-plus";
import { ElRadioGroup as ae } from "element-plus";
import { ElOption as ie } from "element-plus";
import { ElSelect as le } from "element-plus";
import { ElInputNumber as re } from "element-plus";
import { ElForm as se } from "element-plus";
import { _ as de, s3 as V, ao as ue, qe as U, e8 as M, qb as L, aV as pe, e0 as ce, e1 as me } from "../../../../../shared/runtime.js";
const fe = { class: "conditionList" }, be = { __name: "form", setup(_e) {
  const v = x(), S = { branchCompanyIdList: [], workshopIdList: [], artifactClassIdList: [], processId: void 0, quotaType: V.CONSTANT.V, conditionList: [], measureUnit: void 0, organizationInsidePrice: void 0, organizationOutsidePrice: void 0 }, P = h("processOptions"), $ = h("branchList"), B = h("classificationOptions"), { crud: m, form: o, CRUD: O } = ue(S, v), F = [U.TON.L, U.METER.L, U.PIECE.L], A = C(() => ({ value: "id", label: "name", children: "nameInfos", expandTrigger: "hover", emitPath: false })), j = C(() => {
    let r = [];
    return P.value.length && o.productClassificationEnum && P.value.forEach((e) => {
      e.name === M.VL[o.productClassificationEnum] && (r = e.nameInfos);
    }), r;
  }), D = C(() => B.value.filter((r) => r.productClassificationEnum === o.productClassificationEnum)), _ = (r, e) => {
    const l = ["numberOne", "comparisonOperatorOne", "comparisonOperatorTwo", "numberTwo"].filter((s) => s !== e).map((s) => r[s]).some((s) => s != null && s !== ""), d = r[e];
    return !(l && (d == null || d === ""));
  }, f = x({ branchCompanyIdList: [{ required: true, message: "请选择适用机构", trigger: "change" }], workshopIdList: [{ required: true, message: "请选择适用车间", trigger: "change" }], artifactClassIdList: [{ required: true, message: "请选择构件类型", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], quotaType: [{ required: true, message: "请选择规格分类", trigger: "change" }], measureUnit: [{ required: true, message: "请输入计量单位", trigger: "change" }], organizationInsidePrice: [{ required: true, message: "请输入编制内单价", trigger: "blur" }], organizationOutsidePrice: [{ required: true, message: "请输入编制外单价", trigger: "blur" }] });
  J(() => {
    Object.values(L.V).map((r) => ({ conditionEnum: r.V })).forEach((r, e) => {
      f.value[`conditionList.${e}.numberOne`] = [{ validator: () => _(o.conditionList[e], "numberOne"), message: "请填写", trigger: "blur" }], f.value[`conditionList.${e}.comparisonOperatorOne`] = [{ validator: () => _(o.conditionList[e], "comparisonOperatorOne"), message: "请选择", trigger: "change" }], f.value[`conditionList.${e}.comparisonOperatorTwo`] = [{ validator: () => _(o.conditionList[e], "comparisonOperatorTwo"), message: "请选择", trigger: "change" }], f.value[`conditionList.${e}.numberTwo`] = [{ validator: () => _(o.conditionList[e], "numberTwo"), message: "请填写", trigger: "blur" }];
    });
  });
  function H(r) {
    r === V.VARIABLE.V ? o.conditionList = Object.values(L.V).map((e) => ({ conditionEnum: e.V, numberOne: void 0, comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberTwo: void 0 })) : o.conditionList = [];
  }
  O.HOOK.beforeSubmit = () => {
    o.conditionList = o.conditionList.filter((r) => r.comparisonOperatorOne);
  };
  function k(r = []) {
    return Object.values(L.V).map((u) => ({ conditionEnum: u.V })).map((u) => r.find((l) => l.conditionEnum === u.conditionEnum) || { conditionEnum: u.conditionEnum, numberOne: void 0, comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberTwo: void 0 });
  }
  return O.HOOK.afterAddError = () => {
    o.conditionList = k(o.conditionList);
  }, O.HOOK.afterEditError = () => {
    o.conditionList = k(o.conditionList);
  }, (r, e) => {
    const u = b("common-button"), E = b("common-select-v2"), l = oe, d = b("common-select"), s = te, K = ne, Q = ae, q = b("common-input-number"), Y = ie, G = le, z = re, W = se, X = b("common-dialog");
    return c(), y(X, { "append-to-body": "", "close-on-click-modal": false, "before-close": n(m).cancelCU, visible: n(m).status.cu > 0, title: n(m).status.title, top: "2vh", width: "600px" }, { titleRight: i(() => [a(u, { loading: n(m).status.cu === 2, type: "primary", size: "default", onClick: n(m).submitCU }, { default: i(() => e[9] || (e[9] = [N("确认")])), _: 1, __: [9] }, 8, ["loading", "onClick"])]), default: i(() => [a(W, { ref_key: "formRef", ref: v, model: n(o), rules: f.value, size: "default", "label-width": "150px" }, { default: i(() => [a(l, { label: "适用机构：", prop: "branchCompanyIdList" }, { default: i(() => [a(E, { modelValue: n(o).branchCompanyIdList, "onUpdate:modelValue": e[0] || (e[0] = (t) => n(o).branchCompanyIdList = t), options: n($), "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", multiple: "", "collapse-tags": "", type: "other", size: "default", placeholder: "选择适用机构", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), a(l, { label: "适用车间：", prop: "workshopIdList" }, { default: i(() => [a(n(pe), { modelValue: n(o).workshopIdList, "onUpdate:modelValue": e[1] || (e[1] = (t) => n(o).workshopIdList = t), placeholder: "选择适用车间", multiple: "", "collapse-tags": "", clearable: "", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 }), a(l, { label: "零件类型：", prop: "productClassificationEnum" }, { default: i(() => [a(d, { modelValue: n(o).productClassificationEnum, "onUpdate:modelValue": e[2] || (e[2] = (t) => n(o).productClassificationEnum = t), options: n(M).ENUM, type: "enum", filterable: "", clearable: "", placeholder: "请选择零件类型", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), a(l, { label: "零件种类：", prop: "machinePartClassIdList" }, { default: i(() => [a(d, { modelValue: n(o).machinePartClassIdList, "onUpdate:modelValue": e[3] || (e[3] = (t) => n(o).machinePartClassIdList = t), options: D.value, type: "other", filterable: "", clearable: "", multiple: "", disabled: !n(o).productClassificationEnum, dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择零件分类", style: { width: "340px" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), a(l, { label: "工序：", prop: "processId" }, { default: i(() => [a(s, { ref: "processIdRef", options: j.value, "check-strictly": "", modelValue: n(o).processId, "onUpdate:modelValue": e[4] || (e[4] = (t) => n(o).processId = t), props: A.value, disabled: !n(o).productClassificationEnum, separator: " > ", "show-all-levels": "", clearable: "", size: "default", style: { width: "340px" }, placeholder: "选择工序" }, null, 8, ["options", "modelValue", "props", "disabled"])]), _: 1 }), a(l, { label: "定额类型：", prop: "quotaType" }, { default: i(() => [a(Q, { modelValue: n(o).quotaType, "onUpdate:modelValue": e[5] || (e[5] = (t) => n(o).quotaType = t), onChange: H, style: { width: "340px" } }, { default: i(() => [(c(true), w(I, null, T(n(V).ENUM, (t) => (c(), y(K, { key: t.V, value: t.V }, { default: i(() => [N(Z(t.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), n(o).quotaType === n(V).VARIABLE.V ? (c(true), w(I, { key: 0 }, T(n(o).conditionList, (t, g) => (c(), y(l, { key: t.conditionEnum, label: `${n(L).VL[t.conditionEnum]}：`, prop: "v.conditionEnum" }, { default: i(() => [R("div", fe, [a(l, { prop: `conditionList.${g}.numberOne` }, { default: i(() => [a(q, { modelValue: t.numberOne, "onUpdate:modelValue": (p) => t.numberOne = p, step: 1, min: 0, max: 999999999, controls: false, precision: 0, placeholder: "数字", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), a(l, { prop: `conditionList.${g}.comparisonOperatorOne` }, { default: i(() => [a(d, { modelValue: t.comparisonOperatorOne, "onUpdate:modelValue": (p) => t.comparisonOperatorOne = p, options: n(ce).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), e[10] || (e[10] = R("span", { class: "station-text" }, "X", -1)), a(l, { prop: `conditionList.${g}.comparisonOperatorTwo` }, { default: i(() => [a(d, { modelValue: t.comparisonOperatorTwo, "onUpdate:modelValue": (p) => t.comparisonOperatorTwo = p, options: n(me).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), a(l, { prop: `conditionList.${g}.numberTwo` }, { default: i(() => [a(q, { modelValue: t.numberTwo, "onUpdate:modelValue": (p) => t.numberTwo = p, step: 1, min: 0, max: 999999999, controls: false, precision: 0, placeholder: "数字", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"])])]), _: 2 }, 1032, ["label"]))), 128)) : ee("", true), a(l, { label: "计量单位：", prop: "measureUnit" }, { default: i(() => [a(G, { modelValue: n(o).measureUnit, "onUpdate:modelValue": e[6] || (e[6] = (t) => n(o).measureUnit = t), clearable: "", size: "default", placeholder: "计量单位", style: { width: "340px" } }, { default: i(() => [(c(), w(I, null, T(F, (t) => a(Y, { key: t, label: t, value: t }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), a(l, { label: "编制内单价（元）：", prop: "organizationInsidePrice" }, { default: i(() => [a(z, { modelValue: n(o).organizationInsidePrice, "onUpdate:modelValue": e[7] || (e[7] = (t) => n(o).organizationInsidePrice = t), placeholder: "输入单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 }), a(l, { label: "编制外单价（元）：", prop: "organizationOutsidePrice" }, { default: i(() => [a(z, { modelValue: n(o).organizationOutsidePrice, "onUpdate:modelValue": e[8] || (e[8] = (t) => n(o).organizationOutsidePrice = t), placeholder: "输入单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Oe = de(be, [["__scopeId", "data-v-6353b335"]]);
export {
  Oe as default
};
