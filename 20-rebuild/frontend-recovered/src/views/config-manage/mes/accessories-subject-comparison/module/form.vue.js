import { ref as m } from "vue";
import { computed as E } from "vue";
import { nextTick as z } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as x } from "vue";
import { createBlock as A } from "vue";
import { withCtx as n } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as D } from "vue";
import { unref as l } from "vue";
import { createElementVNode as Q } from "vue";
import { createElementBlock as W } from "vue";
import { Fragment as X } from "vue";
import { renderList as Y } from "vue";
import { toDisplayString as Z } from "vue";
import { withKeys as ee } from "vue";
import { ElMessage as L } from "element-plus";
import { ElTag as ae } from "element-plus";
import { ElInput as le } from "element-plus";
import { ElFormItem as se } from "element-plus";
import { ElForm as ie } from "element-plus";
import { l as y, _ as te, ao as ne, f3 as T, i as h, cJ as ue } from "../../../../../shared/runtime.js";
function oe(s) {
  return y({ url: "/api/system/auxiliary/mes/selectList", method: "get", params: s });
}
function re(s) {
  return y({ url: "/api/system/auxiliary/mes/save", method: "post", data: [s] });
}
function ce(s) {
  return y({ url: "/api/system/auxiliary/mes/update", method: "put", data: s });
}
function de(s) {
  return y({ url: `/api/system/auxiliary/mes/selectById?id=${s}`, method: "get" });
}
function me(s) {
  return y({ url: "/api/system/auxiliary/mes/del", method: "delete", data: s });
}
function fe(s) {
  return y({ url: "/api/system/auxiliary/mes/getClassification", method: "get", params: s });
}
const Ce = { get: oe, edit: ce, add: re, del: me, detail: de };
const ye = { class: "tax-list flex-rsc" }, pe = { __name: "form", setup(s) {
  const M = { auxiliaryNameList: [], accountingUnit: void 0, basicClass: void 0, mesAuxiliaryRelevancyClass: [], mesAuxiliaryRelevancyClassDTOParams: [], meteDiff: void 0 }, k = m(), I = m(), { CRUD: N, crud: p, form: e } = ne(M, k), C = m([]), V = m([]), b = E(() => p.status.edit > 0), U = m(false), f = m(), c = m(), w = m(false), B = E(() => !!(b.value && e.accountingUnit === f.value.accountingUnit && T(e.auxiliaryNameList, f.value.auxiliaryNameList, void 0, false) && e.basicClass === f.value.basicClass && e.meteDiff === f.value.meteDiff && T(e.mesAuxiliaryRelevancyClass, f.value.mesAuxiliaryRelevancyClass, void 0, false))), F = { auxiliaryNameList: [{ required: true, message: "请输入配套件名称", trigger: "blur" }], accountingUnit: [{ required: true, message: "请输入配套件核算单位", trigger: "blur" }], basicClass: [{ required: true, message: "请选择配套件核算单位", trigger: "change" }], mesAuxiliaryRelevancyClass: [{ required: true, message: "请选择关联物料科目名称", trigger: "change" }], meteDiff: [{ required: true, message: "请输入核算量误差值", trigger: "blur" }] };
  N.HOOK.beforeEditDetailLoaded = async (o, a) => {
    await z(() => {
      if (h(e.mesAuxiliaryRelevancyClassDTOS)) {
        const t = [];
        e.mesAuxiliaryRelevancyClassDTOS.forEach((r) => {
          t.push(r.classifyId);
        }), e.mesAuxiliaryRelevancyClass = t, V.value = e.mesAuxiliaryRelevancyClassDTOS, f.value = JSON.parse(JSON.stringify(a));
      }
    }), await O();
  }, N.HOOK.beforeSubmit = () => {
    if (b.value) {
      const o = [];
      V.value.forEach((a) => {
        e.mesAuxiliaryRelevancyClass.includes(a.classifyId) || o.push(a.id);
      }), e.delMesAuxiliaryRelevancyClassIds = o;
    }
  };
  async function O() {
    if (C.value = [], h(e.basicClass) && h(e.accountingUnit)) {
      const o = { basicClass: e.basicClass, accountingUnit: e.accountingUnit }, a = await fe(o), t = [];
      for (const r in a) t.push({ classifyId: Number(r), classifyName: a[r] });
      C.value = t;
    }
  }
  function q(o) {
    var t;
    const a = [];
    o || (e.mesAuxiliaryRelevancyClass = []), (t = e.mesAuxiliaryRelevancyClass) == null || t.forEach((r) => {
      var d, _;
      const v = (d = C.value) == null ? void 0 : d.find((g) => r === Number(g.classifyId));
      b.value ? ((_ = V.value) == null ? void 0 : _.findIndex((g) => g.classifyId === r)) === -1 && a.push(v) : a.push(v);
    }), e.mesAuxiliaryRelevancyClassDTOParams = a;
  }
  async function K() {
    U.value = true;
    try {
      await p.submitCU();
    } finally {
      U.value = false;
    }
  }
  function P() {
    w.value = false, c.value = void 0;
  }
  function j() {
    w.value = true, z(() => {
      I.value.focus();
    });
  }
  function S() {
    if (e.auxiliaryNameList.includes(c.value)) {
      L.warning("当前配套件名称已存在");
      return;
    }
    if (c.value.includes(",") || c.value.includes("，")) {
      L.warning('配套件名称不能包含"，",","等字符');
      return;
    }
    h(c.value) && e.auxiliaryNameList.push(c.value), P();
  }
  function J(o) {
    e.auxiliaryNameList.splice(e.auxiliaryNameList.indexOf(o), 1), e.auxiliaryNameList.length === 0 && L.warning("至少保留一条配套件名称");
  }
  return (o, a) => {
    const t = R("common-button"), r = ae, v = le, d = se, _ = R("common-select"), g = R("common-input-number"), H = ie, $ = R("common-dialog");
    return x(), A($, { "before-close": l(p).cancelCU, "close-on-click-modal": false, "content-loading": l(p).editDetailLoading, title: b.value ? "编辑" : "新增", visible: l(p).status.cu > l(N).STATUS.NORMAL, "append-to-body": "", width: "40%" }, { titleRight: n(() => [u(t, { disabled: B.value, loading: U.value, size: "default", type: "primary", onClick: K }, { default: n(() => a[5] || (a[5] = [D(" 提交 ")])), _: 1, __: [5] }, 8, ["disabled", "loading"])]), default: n(() => [u(H, { ref_key: "formRef", ref: k, model: l(e), rules: F, "label-position": "left", "label-width": "200px", size: "default" }, { default: n(() => [u(d, { label: "配套件名称", prop: "auxiliaryNameList" }, { default: n(() => [Q("div", ye, [(x(true), W(X, null, Y(l(e).auxiliaryNameList, (i, G) => (x(), A(r, { key: G, "disable-transitions": false, closable: "", size: "large", onClose: (_e) => J(i) }, { default: n(() => [D(Z(i), 1)]), _: 2 }, 1032, ["onClose"]))), 128)), w.value ? (x(), A(v, { key: 0, ref_key: "inputRef", ref: I, modelValue: c.value, "onUpdate:modelValue": a[0] || (a[0] = (i) => c.value = i), class: "input-new-tag", placeholder: "配套件名称", size: "default", onBlur: S, onKeyup: ee(S, ["enter"]) }, null, 8, ["modelValue"])) : (x(), A(t, { key: 1, class: "button-new-tag", icon: "el-icon-plus", size: "default", onClick: j }, { default: n(() => a[6] || (a[6] = [D(" 添加 ")])), _: 1, __: [6] }))])]), _: 1 }), u(d, { label: "配套件核算单位", prop: "accountingUnit" }, { default: n(() => [u(v, { modelValue: l(e).accountingUnit, "onUpdate:modelValue": a[1] || (a[1] = (i) => l(e).accountingUnit = i), class: "input-underline", clearable: "", placeholder: "请输入配套件核算单位", size: "default", style: { width: "100%" }, onChange: O }, null, 8, ["modelValue"])]), _: 1 }), u(d, { label: "物料类型", prop: "basicClass" }, { default: n(() => [u(_, { modelValue: l(e).basicClass, "onUpdate:modelValue": a[2] || (a[2] = (i) => l(e).basicClass = i), options: l(ue).ENUM, class: "input-underline", clearable: "", placeholder: "请选择物料类型", size: "default", style: { width: "100%" }, type: "enum", onChange: O }, null, 8, ["modelValue", "options"])]), _: 1 }), u(d, { label: "关联物料科目名称", prop: "mesAuxiliaryRelevancyClass" }, { default: n(() => [u(_, { modelValue: l(e).mesAuxiliaryRelevancyClass, "onUpdate:modelValue": a[3] || (a[3] = (i) => l(e).mesAuxiliaryRelevancyClass = i), dataStructure: { key: "classifyId", label: "classifyName", value: "classifyId" }, options: C.value, class: "input-underline", clearable: "", filterable: "", multiple: "", placeholder: "请选择关联物料科目名称", size: "default", style: { width: "100%" }, type: "other", onChange: q }, null, 8, ["modelValue", "options"])]), _: 1 }), u(d, { label: "核算量误差值（%）", prop: "meteDiff" }, { default: n(() => [u(g, { modelValue: l(e).meteDiff, "onUpdate:modelValue": a[4] || (a[4] = (i) => l(e).meteDiff = i), controls: false, max: 999999999, min: 0, step: 1, center: "left", class: "input-underline", placeholder: "核算量误差值（%）", size: "default", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, ve = te(pe, [["__scopeId", "data-v-5784a8df"]]), be = Object.freeze(Object.defineProperty({ __proto__: null, default: ve }, Symbol.toStringTag, { value: "Module" }));
export {
  Ce as c,
  be as f,
  ve as m
};
