import { ref as k } from "vue";
import { inject as q } from "vue";
import { computed as R } from "vue";
import { nextTick as oe } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as c } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as z } from "vue";
import { createElementBlock as C } from "vue";
import { Fragment as T } from "vue";
import { renderList as h } from "vue";
import { toDisplayString as te } from "vue";
import { createElementVNode as M } from "vue";
import { createCommentVNode as ae } from "vue";
import { ElFormItem as ne } from "element-plus";
import { ElRadio as ie } from "element-plus";
import { ElRadioGroup as le } from "element-plus";
import { ElOption as re } from "element-plus";
import { ElSelect as se } from "element-plus";
import { ElInputNumber as ue } from "element-plus";
import { ElForm as de } from "element-plus";
import { _ as pe, s3 as L, ao as me, qe as I, f9 as S, q9 as O, aV as ce, es as A, a3 as fe, e0 as be, e1 as ge, eu as _e } from "../../../../../shared/runtime.js";
import { _ as Ve } from "../../../../../modules/process-select-b35dffc0.js";
import { u as Le } from "../../../../../modules/use-section-all-504a2069.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const Oe = { class: "conditionList" }, Ee = { __name: "form", setup(ye) {
  const { loaded: x, artifactSectionAll: B } = Le(), w = k(), $ = { branchCompanyIdList: [], workshopIdList: [], productClassificationEnum: void 0, artifactClassIdList: [], processId: void 0, quotaType: L.CONSTANT.V, conditionList: [], measureUnit: void 0, organizationInsidePrice: void 0, organizationOutsidePrice: void 0 }, F = q("artifactTypeList"), D = q("branchList"), { crud: f, form: t, CRUD: E } = me($, w), j = [I.TON.L, I.METER.L, I.PIECE.L], Y = R(() => {
    var r;
    return (r = F.value) == null ? void 0 : r.filter((o) => o.artifactClassification === t.productClassificationEnum);
  }), U = (r) => R(() => {
    var u, m, i;
    return ((i = (m = (u = B.value) == null ? void 0 : u[_e.PRODUCT_NAME.V]) == null ? void 0 : m.find((s) => Number(s.productClassificationEnum) === r.V)) == null ? void 0 : i.sectionWarehouseConfigDTOList) || [];
  }), H = U(S.PRIMARY_MEMBER), K = U(S.SECONDARY_MEMBER), _ = (r, o) => {
    const i = ["numberOne", "comparisonOperatorOne", "comparisonOperatorTwo", "numberTwo"].filter((d) => d !== o).map((d) => r[d]).some((d) => d != null && d !== ""), s = r[o];
    return !(i && (s == null || s === ""));
  }, b = k({ branchCompanyIdList: [{ required: true, message: "请选择适用机构", trigger: "change" }], workshopIdList: [{ required: true, message: "请选择适用车间", trigger: "change" }], productClassificationEnum: [{ required: true, message: "请选主次构件类型", trigger: "change" }], artifactClassIdList: [{ required: true, message: "请选择构件类型", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], quotaType: [{ required: true, message: "请选择规格分类", trigger: "change" }], measureUnit: [{ required: true, message: "请输入计量单位", trigger: "change" }], organizationInsidePrice: [{ required: true, message: "请输入编制内单价", trigger: "blur" }], organizationOutsidePrice: [{ required: true, message: "请输入编制外单价", trigger: "blur" }] });
  oe(() => {
    Object.values(O.V).map((r) => ({ conditionEnum: r.V })).forEach((r, o) => {
      b.value[`conditionList.${o}.numberOne`] = [{ validator: () => _(t.conditionList[o], "numberOne"), message: "请填写", trigger: "blur" }], b.value[`conditionList.${o}.comparisonOperatorOne`] = [{ validator: () => _(t.conditionList[o], "comparisonOperatorOne"), message: "请选择", trigger: "change" }], b.value[`conditionList.${o}.comparisonOperatorTwo`] = [{ validator: () => _(t.conditionList[o], "comparisonOperatorTwo"), message: "请选择", trigger: "change" }], b.value[`conditionList.${o}.numberTwo`] = [{ validator: () => _(t.conditionList[o], "numberTwo"), message: "请填写", trigger: "blur" }];
    });
  });
  function Q(r) {
    r === L.VARIABLE.V ? t.conditionList = Object.values(O.V).map((o) => ({ conditionEnum: o.V, numberOne: void 0, comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberTwo: void 0 })) : t.conditionList = [];
  }
  function W(r) {
    t.artifactNameList = [], t.artifactClassIdList = [];
  }
  E.HOOK.beforeSubmit = () => {
    t.conditionList = t.conditionList.filter((r) => r.comparisonOperatorOne);
  };
  function v(r = []) {
    return Object.values(O.V).map((u) => ({ conditionEnum: u.V })).map((u) => r.find((i) => i.conditionEnum === u.conditionEnum) || { conditionEnum: u.conditionEnum, numberOne: void 0, comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberTwo: void 0 });
  }
  return E.HOOK.afterAddError = () => {
    t.conditionList = v(t.conditionList);
  }, E.HOOK.afterEditError = () => {
    t.conditionList = v(t.conditionList);
  }, (r, o) => {
    const u = g("common-button"), m = g("common-select-v2"), i = ne, s = g("common-select"), d = ie, G = le, N = g("common-input-number"), X = re, J = se, P = ue, Z = de, ee = g("common-dialog");
    return c(), y(ee, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(f).cancelCU, visible: e(f).status.cu > 0, title: e(f).status.title, top: "2vh", width: "600px" }, { titleRight: l(() => [n(u, { loading: e(f).status.cu === 2, type: "primary", size: "default", onClick: e(f).submitCU }, { default: l(() => o[10] || (o[10] = [z("确认")])), _: 1, __: [10] }, 8, ["loading", "onClick"])]), default: l(() => [n(Z, { ref_key: "formRef", ref: w, model: e(t), rules: b.value, size: "default", "label-width": "150px" }, { default: l(() => [n(i, { label: "适用机构：", prop: "branchCompanyIdList" }, { default: l(() => [n(m, { modelValue: e(t).branchCompanyIdList, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).branchCompanyIdList = a), options: e(D), "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", multiple: "", "collapse-tags": "", type: "other", size: "default", placeholder: "选择适用机构", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), n(i, { label: "适用车间：", prop: "workshopIdList" }, { default: l(() => [n(e(ce), { modelValue: e(t).workshopIdList, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).workshopIdList = a), placeholder: "选择适用车间", multiple: "", "collapse-tags": "", clearable: "", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 }), n(i, { label: "主次构件类型：", prop: "productClassificationEnum" }, { default: l(() => [n(s, { modelValue: e(t).productClassificationEnum, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).productClassificationEnum = a), options: e(A).ENUM, placeholder: "主次构件类型", type: "enum", clearable: "", style: { width: "340px" }, onChange: W }, null, 8, ["modelValue", "options"])]), _: 1 }), n(i, { label: "构件类型：", prop: "artifactClassIdList" }, { default: l(() => [n(s, { modelValue: e(t).artifactClassIdList, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).artifactClassIdList = a), options: Y.value, placeholder: "选择构件类型", type: "other", "data-structure": { key: "typeId", label: "typeName", value: "typeId" }, clearable: "", filterable: "", multiple: "", "collapse-tags": "", style: { width: "340px" }, disabled: !e(t).productClassificationEnum }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), n(i, { label: "构件名称：", prop: "artifactNameList" }, { default: l(() => [n(s, { modelValue: e(t).artifactNameList, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).artifactNameList = a), options: e(t).productClassificationEnum === e(A).SMALL.V ? e(K) : e(H), type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, filterable: "", multiple: "", "collapse-tags": "", placeholder: "选择构件名称【不填默认全部】", style: { width: "340px" }, disabled: !e(x) || !e(t).productClassificationEnum }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), n(i, { label: "工序：", prop: "processId" }, { default: l(() => [n(e(Ve), { ref: "processSelectRef", modelValue: e(t).processId, "onUpdate:modelValue": o[5] || (o[5] = (a) => e(t).processId = a), productType: e(fe).ARTIFACT.V, size: "default", filterable: "", clearable: "", multiple: false, style: { width: "340px" } }, null, 8, ["modelValue", "productType"])]), _: 1 }), n(i, { label: "定额类型：", prop: "quotaType" }, { default: l(() => [n(G, { modelValue: e(t).quotaType, "onUpdate:modelValue": o[6] || (o[6] = (a) => e(t).quotaType = a), onChange: Q, style: { width: "340px" } }, { default: l(() => [(c(true), C(T, null, h(e(L).ENUM, (a) => (c(), y(d, { key: a.V, value: a.V }, { default: l(() => [z(te(a.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), e(t).quotaType === e(L).VARIABLE.V ? (c(true), C(T, { key: 0 }, h(e(t).conditionList, (a, V) => (c(), y(i, { key: a.conditionEnum, label: `${e(O).VL[a.conditionEnum]}：`, prop: "v.conditionEnum" }, { default: l(() => [M("div", Oe, [n(i, { prop: `conditionList.${V}.numberOne` }, { default: l(() => [n(N, { modelValue: a.numberOne, "onUpdate:modelValue": (p) => a.numberOne = p, step: 1, min: 0, max: 999999999, controls: false, precision: 0, placeholder: "数字", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), n(i, { prop: `conditionList.${V}.comparisonOperatorOne` }, { default: l(() => [n(s, { modelValue: a.comparisonOperatorOne, "onUpdate:modelValue": (p) => a.comparisonOperatorOne = p, options: e(be).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), o[11] || (o[11] = M("span", { class: "station-text" }, "X", -1)), n(i, { prop: `conditionList.${V}.comparisonOperatorTwo` }, { default: l(() => [n(s, { modelValue: a.comparisonOperatorTwo, "onUpdate:modelValue": (p) => a.comparisonOperatorTwo = p, options: e(ge).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), n(i, { prop: `conditionList.${V}.numberTwo` }, { default: l(() => [n(N, { modelValue: a.numberTwo, "onUpdate:modelValue": (p) => a.numberTwo = p, step: 1, min: 0, max: 999999999, controls: false, precision: 0, placeholder: "数字", class: "conditionList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"])])]), _: 2 }, 1032, ["label"]))), 128)) : ae("", true), n(i, { label: "计量单位：", prop: "measureUnit" }, { default: l(() => [n(J, { modelValue: e(t).measureUnit, "onUpdate:modelValue": o[7] || (o[7] = (a) => e(t).measureUnit = a), clearable: "", size: "default", placeholder: "计量单位", style: { width: "340px" } }, { default: l(() => [(c(), C(T, null, h(j, (a) => n(X, { key: a, label: a, value: a }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), n(i, { label: "编制内单价（元）：", prop: "organizationInsidePrice" }, { default: l(() => [n(P, { modelValue: e(t).organizationInsidePrice, "onUpdate:modelValue": o[8] || (o[8] = (a) => e(t).organizationInsidePrice = a), placeholder: "输入编制内单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 }), n(i, { label: "编制外单价（元）：", prop: "organizationOutsidePrice" }, { default: l(() => [n(P, { modelValue: e(t).organizationOutsidePrice, "onUpdate:modelValue": o[9] || (o[9] = (a) => e(t).organizationOutsidePrice = a), placeholder: "输入编制外单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Ne = pe(Ee, [["__scopeId", "data-v-3a6cdd90"]]);
export {
  Ne as default
};
