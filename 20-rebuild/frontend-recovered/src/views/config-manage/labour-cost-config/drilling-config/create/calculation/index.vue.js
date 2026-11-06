import { ref as P } from "vue";
import { provide as Q } from "vue";
import { inject as W } from "vue";
import { reactive as k } from "vue";
import { computed as M } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as s } from "vue";
import { withCtx as d } from "vue";
import { unref as t } from "vue";
import { Fragment as y } from "vue";
import { renderList as b } from "vue";
import { createBlock as _ } from "vue";
import { normalizeStyle as X } from "vue";
import { createCommentVNode as x } from "vue";
import { ElOption as Z } from "element-plus";
import { ElSelect as q } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElDivider as ee } from "element-plus";
import { ElButton as ae } from "element-plus";
import { _ as le, b as te, e3 as oe, dZ as ne, e8 as ie, e9 as se, ek as re, e0 as de, e1 as ue, d$ as ce, e5 as pe, e2 as D } from "../../../../../../shared/runtime.js";
import { c as me, b as fe, a as ye } from "../../../../../../modules/drilling-config-d5ae6cbb.js";
const E = [{ key: "machinePartType", label: "零件类型", verify: true }, { key: "steelClassificationId", label: "零件分类", verify: true }, { key: "specificationPrefixType", label: "规格前缀类型", value: "选中分类自动展示" }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "processIdList", label: "生产方式", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }], be = [{ key: "machinePartType", label: "零件类型", verify: true }, { key: "steelClassificationId", label: "零件分类", verify: true }, { key: "specificationPrefixType", label: "规格前缀类型", value: "选中分类自动展示" }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "processIdList", label: "生产方式", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "pricingManner", label: "板厚/孔径", verify: true }, { key: "detailList", label: "(mm)" }], _e = [{ key: "machinePartType", label: "零件类型", verify: true }, { key: "steelClassificationId", label: "零件分类", verify: true }, { key: "specificationPrefixType", label: "规格前缀类型", value: "选中分类自动展示" }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "processIdList", label: "生产方式", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "organizationInsidePrice", label: "编制内单价", verify: true }, { key: "organizationOutsidePrice", label: "编制外单价", verify: true }];
const ve = { class: "calculation-container" }, Ve = { class: "form-container" }, he = { class: "item" }, ke = { class: "item" }, ge = { class: "item" }, Pe = { class: "item" }, Oe = { class: "item" }, Me = { class: "item" }, Le = { class: "item" }, Te = { key: 0 }, Ce = { key: 1 }, Ue = { __name: "index", setup(Ie, { expose: w }) {
  const z = P([]);
  Q("formRefList", z);
  const a = W("calculationFormData"), V = P([]), h = k({}), L = P([]), O = M(() => !te(a.id)), f = k(JSON.parse(JSON.stringify(E))), N = M(() => oe(f, h)), B = M(() => ne(f)), T = async () => {
    const { content: i } = await fe({ productClassificationEnum: a.machinePartType });
    if (i.length === 0) return D("warning", "该类型下暂无零件分类");
    V.value.splice(0), i.forEach((r) => {
      const u = { id: r.id, name: r.name, keyword: "" };
      r.links.forEach((p) => {
        u.keyword += `【 ${p.keyword} 】`;
      }), V.value.push(u);
    });
  }, C = P(""), J = (i) => {
    i ? (C.value = V.value.find((r) => r.id === i).keyword, h.specificationPrefixType = C.value) : h.specificationPrefixType = "选中分类自动展示";
  }, U = async () => {
    try {
      const i = await ye();
      if (i.length === 0) return D("warning", "该类型下暂无生产方式");
      L.value = i;
    } catch (i) {
      console.log(i);
    }
  }, A = async () => {
    var i;
    a.statisticsMode && I(a.statisticsMode);
    try {
      const r = await me(a.id);
      r.steelClassificationId && T(), (i = r.processIdList) != null && i.length && U(), Object.assign(a, r), h.specificationPrefixType = r.specificationPrefixTypeList.reduce((u, p) => `${u}【 ${p} 】`, "");
    } catch (r) {
      console.log(r);
    }
  }, R = async () => {
    V.value.splice(0), a.steelClassificationId = null, h.specificationPrefixType = "选中分类自动展示", a.machinePartType && (await T(), await U());
  }, $ = (i) => {
    a.detailList.push({ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" });
  }, j = (i, r) => {
    a.detailList.splice(r, 1);
  }, F = k(JSON.parse(JSON.stringify(_e))), K = k(JSON.parse(JSON.stringify(be))), G = k(JSON.parse(JSON.stringify(E))), I = async (i) => {
    i === 2 ? (await f.splice(0), await f.push(...F)) : i === 3 && (await f.splice(0), await f.push(...K)), i || (await f.splice(0), await f.push(...G));
  };
  return w({ formData: a, data: f, getDrillConfigInfo: A }), (i, r) => {
    const u = Z, p = q, v = H, Y = ee, S = ae;
    return n(), c("div", ve, [m("div", Ve, [s(pe, { column: 1, "table-list": N.value, "form-data": t(a), "form-rules": B.value }, { machinePartType: d(({ item: l }) => [s(p, { placeholder: "请选择零件类型", clearable: "", disabled: O.value, modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, onChange: R }, { default: d(() => [(n(true), c(y, null, b(t(ie).V, (e) => (n(), _(u, { key: e.K, label: e.L, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), steelClassificationId: d(({ item: l }) => [s(p, { placeholder: "请选择零件分类", clearable: "", disabled: O.value, modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, onChange: J }, { default: d(() => [(n(true), c(y, null, b(V.value, (e) => (n(), _(u, { label: e.name, key: e.id, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), statisticsMode: d(({ item: l }) => [s(p, { onChange: I, disabled: O.value, placeholder: "请选择统计模式", clearable: "", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e }, { default: d(() => [(n(true), c(y, null, b(t(se).V, (e) => (n(), _(u, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), processIdList: d(({ item: l }) => [s(p, { placeholder: "请选择生产方式", clearable: "", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, multiple: "" }, { default: d(() => [(n(true), c(y, null, b(L.value, (e) => (n(), _(u, { key: e.id, label: e.name, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), pricingManner: d(({ item: l }) => [s(p, { placeholder: "请选择板厚或孔径", clearable: "", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e }, { default: d(() => [(n(true), c(y, null, b(t(re).V, (e) => (n(), _(u, { key: e.V, value: e.V, label: e.L }, null, 8, ["value", "label"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), detailList: d(({ item: l }) => [(n(true), c(y, null, b(t(a)[l], (e, g) => (n(), c("div", { key: g, class: "Radius-container", style: X({ "margin-bottom": t(a)[l].length > 1 ? "5px" : "0" }) }, [m("div", he, [s(v, { clearable: "", modelValue: e.numberOne, "onUpdate:modelValue": (o) => e.numberOne = o, modelModifiers: { number: true }, type: "number", placeholder: "数字" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), m("div", ke, [s(p, { modelValue: e.comparisonOperatorOne, "onUpdate:modelValue": (o) => e.comparisonOperatorOne = o, clearable: "" }, { default: d(() => [(n(true), c(y, null, b(t(de).V, (o) => (n(), _(u, { key: o.V, label: o.L, value: o.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), r[0] || (r[0] = m("div", { class: "item" }, [m("span", { class: "station-text" }, "X")], -1)), m("div", ge, [s(p, { modelValue: e.comparisonOperatorTwo, "onUpdate:modelValue": (o) => e.comparisonOperatorTwo = o, clearable: "" }, { default: d(() => [(n(true), c(y, null, b(t(ue).V, (o) => (n(), _(u, { key: o.V, label: o.L, value: o.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), m("div", Pe, [s(v, { placeholder: "数字", type: "number", clearable: "", modelValue: e.numberTwo, "onUpdate:modelValue": (o) => e.numberTwo = o, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), m("div", Oe, [s(Y, { direction: "vertical", style: { height: "100%" } })]), m("div", Me, [s(v, { modelValue: e.organizationInsidePrice, "onUpdate:modelValue": (o) => e.organizationInsidePrice = o, modelModifiers: { number: true }, placeholder: "编制内价格", clearable: "", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), m("div", Le, [s(v, { modelValue: e.organizationOutsidePrice, "onUpdate:modelValue": (o) => e.organizationOutsidePrice = o, modelModifiers: { number: true }, placeholder: "编制外价格", clearable: "", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), g === 0 ? (n(), c("div", Te, [s(S, { icon: "el-icon-plus", type: "primary", plain: "", size: "default", onClick: (o) => $(e) }, null, 8, ["onClick"])])) : x("", true), g !== 0 ? (n(), c("div", Ce, [s(S, { icon: "el-icon-delete", type: "danger", plain: "", size: "default", onClick: (o) => j(e, g) }, null, 8, ["onClick"])])) : x("", true)], 4))), 128))]), measurementManner: d(({ item: l }) => [s(p, { placeholder: "请选择计量方式", clearable: "", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e }, { default: d(() => [(n(true), c(y, null, b(t(ce).V, (e) => (n(), _(u, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), organizationInsidePrice: d(({ item: l }) => [s(v, { placeholder: "请输入编制内单价", clearable: "", type: "number", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), organizationOutsidePrice: d(({ item: l }) => [s(v, { placeholder: "请输入编制外单价", clearable: "", type: "number", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["table-list", "form-data", "form-rules"])])]);
  };
} }, Ee = le(Ue, [["__scopeId", "data-v-e1bc4f69"]]);
export {
  Ee as default
};
