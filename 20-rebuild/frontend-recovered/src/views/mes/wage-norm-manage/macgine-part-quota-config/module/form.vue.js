import { ref as g } from "vue";
import { computed as b } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as p } from "vue";
import { createBlock as c } from "vue";
import { withCtx as s } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as U } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as I } from "vue";
import { renderList as v } from "vue";
import { toDisplayString as H } from "vue";
import { createCommentVNode as _ } from "vue";
import { createElementVNode as S } from "vue";
import { ElFormItem as J } from "element-plus";
import { ElCascader as K } from "element-plus";
import { ElRadio as Q } from "element-plus";
import { ElRadioGroup as Z } from "element-plus";
import { ElInputNumber as ee } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElButton as te } from "element-plus";
import { ElForm as le } from "element-plus";
import { a as oe, g as re } from "../../../../../modules/macgine-part-quota-config-e44baebd.js";
import { _ as se, s9 as y, ao as ie, e8 as h, aV as ne, qo as de, e0 as ue, e1 as pe } from "../../../../../shared/runtime.js";
const ce = { class: "detailList" }, me = { __name: "form", setup(fe) {
  const C = g(), N = { workshopIdList: [], machinePartType: void 0, machinePartClassIdList: [], calculationWay: void 0, boolSpecificationClass: y.NO.V, detailList: [] }, { crud: m, form: t } = ie(N, C), O = g(), V = g([]), w = g([]), q = b(() => w.value.filter((r) => r.productClassificationEnum === t.machinePartType)), x = b(() => {
    let r = [];
    return V.value.length && t.machinePartType && V.value.forEach((a) => {
      a.name === h.VL[t.machinePartType] && (r = a.nameInfos);
    }), r;
  }), M = b(() => {
    var a, f, i, u;
    let r = "";
    return t.machinePartType === h.xingcai.V ? r = "截面" : t.machinePartType === h.gangban.V && (r = "板厚"), ((u = (i = (f = (a = O.value) == null ? void 0 : a.getCheckedNodes()) == null ? void 0 : f[0]) == null ? void 0 : i.pathLabels) == null ? void 0 : u[1]) === "钻孔类" && (r = "孔径φ"), r;
  }), B = b(() => ({ value: "id", label: "name", children: "nameInfos", expandTrigger: "hover", emitPath: false })), R = { workshopIdList: [{ required: true, message: "请选择车间", trigger: "change" }], machinePartType: [{ required: true, message: "请选择零件类型", trigger: "change" }], machinePartClassIdList: [{ required: true, message: "请选择零件分类", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], calculationWay: [{ required: true, message: "请选择计算方式", trigger: "change" }], boolSpecificationClass: [{ required: true, message: "请选择规格分类", trigger: "change" }], price: [{ required: true, message: "请输入单价", trigger: "blur" }] };
  function W(r) {
    r ? t.detailList = [{ comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberOne: void 0, numberTwo: void 0, price: void 0 }] : t.detailList = [];
  }
  async function z(r) {
    try {
      const { content: a } = await oe({ mesProductEnum: 1 });
      w.value = a || [];
    } catch (a) {
      console.log(a);
    }
  }
  z();
  function F(r) {
    r.push({ comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberOne: void 0, numberTwo: void 0, price: void 0 });
  }
  function $(r, a) {
    r.splice(a, 1);
  }
  async function D() {
    try {
      const { content: r } = await re();
      V.value = r || [], console.log(r);
    } catch (r) {
      console.log(r);
    }
  }
  return D(), (r, a) => {
    const f = L("common-button"), i = J, u = L("common-select"), Y = K, j = Q, G = Z, P = ee, T = ae, k = te, X = le, A = L("common-dialog");
    return p(), c(A, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(m).cancelCU, visible: e(m).status.cu > 0, title: e(m).status.title, top: "5vh", width: "700px" }, { titleRight: s(() => [o(f, { loading: e(m).status.cu === 2, type: "primary", size: "default", onClick: e(m).submitCU }, { default: s(() => a[8] || (a[8] = [U("确认")])), _: 1, __: [8] }, 8, ["loading", "onClick"])]), default: s(() => [o(X, { ref_key: "formRef", ref: C, model: e(t), rules: R, size: "default", "label-width": "120px" }, { default: s(() => [o(i, { label: "适用车间：", prop: "workshopIdList" }, { default: s(() => [o(e(ne), { modelValue: e(t).workshopIdList, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).workshopIdList = l), placeholder: "请选择车间", style: { width: "340px" }, multiple: "", "collapse-tags": "", class: "filter-item", clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), o(i, { label: "零件类型：", prop: "machinePartType" }, { default: s(() => [o(u, { modelValue: e(t).machinePartType, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).machinePartType = l), options: e(h).ENUM, type: "enum", filterable: "", clearable: "", placeholder: "请选择零件类型", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, { label: "零件分类：", prop: "machinePartClassIdList" }, { default: s(() => [o(u, { modelValue: e(t).machinePartClassIdList, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).machinePartClassIdList = l), options: q.value, type: "other", filterable: "", clearable: "", multiple: "", disabled: !e(t).machinePartType, dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择零件分类", style: { width: "340px" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), o(i, { label: "工序：", prop: "processId" }, { default: s(() => [o(Y, { ref_key: "processIdRef", ref: O, options: x.value, "check-strictly": "", modelValue: e(t).processId, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).processId = l), props: B.value, disabled: !e(t).machinePartType, separator: " > ", "show-all-levels": "", clearable: "", size: "default", style: { width: "340px" }, placeholder: "选择工序" }, null, 8, ["options", "modelValue", "props", "disabled"])]), _: 1 }), o(i, { label: "计算方式", prop: "calculationWay" }, { default: s(() => [o(u, { modelValue: e(t).calculationWay, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).calculationWay = l), options: e(de).ENUM, type: "enum", clearable: "", placeholder: "请选择计算方式", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, { label: "规格分类", prop: "boolSpecificationClass" }, { default: s(() => [o(G, { modelValue: e(t).boolSpecificationClass, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).boolSpecificationClass = l), onChange: W }, { default: s(() => [(p(true), E(I, null, v(e(y).ENUM, (l) => (p(), c(j, { key: l.V, value: l.V }, { default: s(() => [U(H(l.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), e(t).boolSpecificationClass === e(y).NO.V ? (p(), c(i, { key: 0, label: "单价：", prop: "price" }, { default: s(() => [o(P, { modelValue: e(t).price, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).price = l), placeholder: "输入单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 })) : _("", true), e(t).boolSpecificationClass === e(y).YES.V && e(t).machinePartType ? (p(true), E(I, { key: 1 }, v(e(t).detailList, (l, d) => (p(), c(i, { key: d, label: `${M.value}（${d + 1}）` }, { default: s(() => [S("div", ce, [o(i, { prop: "detailList." + d + ".numberOne", rules: { required: true, message: "请填写", trigger: "blur" } }, { default: s(() => [o(T, { modelValue: l.numberOne, "onUpdate:modelValue": (n) => l.numberOne = n, modelModifiers: { number: true }, clearable: "", placeholder: "数字", type: "number", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), o(i, { prop: "detailList." + d + ".comparisonOperatorOne", rules: { required: true, message: "请选择", trigger: "change" } }, { default: s(() => [o(u, { modelValue: l.comparisonOperatorOne, "onUpdate:modelValue": (n) => l.comparisonOperatorOne = n, options: e(ue).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), a[9] || (a[9] = S("span", { class: "station-text" }, "X", -1)), o(i, { prop: "detailList." + d + ".comparisonOperatorTwo", rules: { required: true, message: "请选择", trigger: "change" } }, { default: s(() => [o(u, { modelValue: l.comparisonOperatorTwo, "onUpdate:modelValue": (n) => l.comparisonOperatorTwo = n, options: e(pe).ENUM, placeholder: "选择", type: "enum", clearable: "", filterable: "", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"]), o(i, { prop: "detailList." + d + ".numberTwo", rules: { required: true, message: "请填写", trigger: "blur" } }, { default: s(() => [o(T, { modelValue: l.numberTwo, "onUpdate:modelValue": (n) => l.numberTwo = n, modelModifiers: { number: true }, clearable: "", placeholder: "数字", type: "number", class: "detailList-item" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), o(i, { prop: "detailList." + d + ".price", rules: { required: true, message: "请填写单价", trigger: "blur" } }, { default: s(() => [o(P, { modelValue: l.price, "onUpdate:modelValue": (n) => l.price = n, placeholder: "单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "120px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), d === 0 ? (p(), c(k, { key: 0, class: "detailList-button", icon: "el-icon-plus", size: "default", type: "primary", onClick: a[7] || (a[7] = (n) => F(e(t).detailList)) })) : _("", true), d > 0 ? (p(), c(k, { key: 1, class: "detailList-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (n) => $(e(t).detailList, d) }, null, 8, ["onClick"])) : _("", true)])]), _: 2 }, 1032, ["label"]))), 128)) : _("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, he = se(me, [["__scopeId", "data-v-0a208d2d"]]);
export {
  he as default
};
