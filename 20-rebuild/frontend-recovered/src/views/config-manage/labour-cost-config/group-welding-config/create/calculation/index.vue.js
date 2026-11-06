import { inject as C } from "vue";
import { ref as M } from "vue";
import { provide as Y } from "vue";
import { reactive as g } from "vue";
import { computed as v } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as m } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as r } from "vue";
import { withCtx as u } from "vue";
import { unref as n } from "vue";
import { Fragment as b } from "vue";
import { renderList as f } from "vue";
import { createBlock as _ } from "vue";
import { normalizeStyle as Q } from "vue";
import { createCommentVNode as U } from "vue";
import { ElOption as X } from "element-plus";
import { ElSelect as Z } from "element-plus";
import { ElInput as q } from "element-plus";
import { ElDivider as H } from "element-plus";
import { ElButton as ee } from "element-plus";
import { _ as ae, b as le, e3 as te, dZ as oe, em as ne, en as se, e0 as ie, e1 as re, d$ as de, e5 as ue, e2 as ce } from "../../../../../../shared/runtime.js";
import { c as me, d as pe, g as be } from "../../../../../../modules/project-group-welding-config-ee2755b6.js";
const P = [{ key: "assembleConfigId", label: "部件类型", verify: true }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "processIdList", label: "生产方式", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "organizationInsidePrice", label: "编制内单价", verify: true }, { key: "organizationOutsidePrice", label: "编制外单价", verify: true }], fe = [{ key: "assembleConfigId", label: "部件类型", verify: true }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "processIdList", label: "生产方式", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "organizationInsidePrice", label: "编制内单价", verify: true }, { key: "organizationOutsidePrice", label: "编制外单价", verify: true }], ye = [{ key: "assembleConfigId", label: "部件类型", verify: true }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "processIdList", label: "生产方式", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "organizationInsidePrice", label: "编制内单价", verify: true }, { key: "organizationOutsidePrice", label: "编制外单价", verify: true }];
const _e = { class: "calculation-container" }, Ve = { class: "form-container" }, ge = { class: "item" }, ve = { class: "item" }, he = { class: "item" }, Oe = { class: "item" }, ke = { class: "item" }, Le = { class: "item" }, Ie = { class: "item" }, Ce = { key: 0 }, Me = { key: 1 }, Ue = { __name: "index", setup(Pe, { expose: S }) {
  const z = C("projectData"), D = M([]);
  Y("formRefList", D);
  const a = C("calculationFormData");
  Object.assign(a, { assembleConfigId: null, steelClassificationId: null, processIdList: null, statisticsMode: null, measurementManner: null, detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }] });
  const k = g({}), N = v(() => z ? me : pe), x = v(() => !le(a.id)), c = g(JSON.parse(JSON.stringify(P))), E = v(() => te(c, k)), T = v(() => oe(c)), O = M([]);
  (async () => {
    try {
      const { content: l } = await be();
      if (l.length === 0) return ce("warning", "暂无部件分类");
      O.value = l;
    } catch (l) {
      console.log(l);
    }
  })();
  const B = v(() => {
    const l = O.value.find((o) => o.typeId === a.assembleConfigId);
    return l ? l.processList : [];
  }), J = async () => {
    a.statisticsMode && await L(a.statisticsMode, a.pricingManner);
    try {
      const l = await N.value(a.id);
      l.processIdList = l.processIdList[0], Object.assign(a, l), k.specificationPrefixType = l.assembleSpecPrefixList.reduce((o, d) => `${o}【 ${d} 】`, "");
    } catch (l) {
      console.log(l);
    }
  }, A = { assembleConfigId: ["statisticsMode", "processIdList", "measurementManner"] }, R = (l) => {
    const o = A[l];
    o && o.forEach((d) => {
      Array.isArray(a[d]) ? a[d].splice(0) : a[d] = null;
    });
  }, $ = (l) => {
    a.detailList.push({ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" });
  }, j = (l, o) => {
    a.detailList.splice(o, 1);
  }, w = g(JSON.parse(JSON.stringify(ye))), F = g(JSON.parse(JSON.stringify(fe))), G = g(JSON.parse(JSON.stringify(P))), L = async (l, o) => {
    l === 2 ? (await c.splice(0), c.push(...w)) : l === 1 && (await c.splice(0), c.push(...F), o === 2 ? c.push({ key: "detailList", label: "腹板厚度" }) : o === 1 && c.push({ key: "detailList", label: "截面" })), l || (c.splice(0), c.push(...G));
  }, K = (l) => {
    if (l) {
      let o = "";
      l === 1 ? o = "截面" : o = "腹板厚度", c.push({ key: "detailList", label: o });
    } else {
      const o = c.findIndex((d) => d.key === "detailList");
      c.splice(o, 1);
    }
  };
  return S({ formData: a, data: c, getDrillConfigInfo: J }), (l, o) => {
    const d = X, y = Z, V = q, W = H, I = ee;
    return i(), m("div", _e, [p("div", Ve, [r(ue, { column: 1, "table-list": E.value, "form-data": n(a), "form-rules": T.value }, { assembleConfigId: u(({ item: t }) => [r(y, { placeholder: "请选择部件类型", clearable: "", filterable: "", disabled: x.value, modelValue: n(a)[t], "onUpdate:modelValue": (e) => n(a)[t] = e, onChange: o[0] || (o[0] = (e) => R("assembleConfigId")) }, { default: u(() => [(i(true), m(b, null, f(O.value, (e) => (i(), _(d, { key: e.typeId, label: e.typeName, value: e.typeId }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), statisticsMode: u(({ item: t }) => [r(y, { onChange: L, placeholder: "请选择统计模式", clearable: "", modelValue: n(a)[t], "onUpdate:modelValue": (e) => n(a)[t] = e }, { default: u(() => [(i(true), m(b, null, f(n(ne).V, (e) => (i(), _(d, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), processIdList: u(({ item: t }) => [r(y, { placeholder: "请选择生产工序", clearable: "", modelValue: n(a)[t], "onUpdate:modelValue": (e) => n(a)[t] = e }, { default: u(() => [(i(true), m(b, null, f(B.value, (e) => (i(), _(d, { key: e.id, label: e.name, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), pricingManner: u(({ item: t }) => [r(y, { placeholder: "请选择", clearable: "", modelValue: n(a)[t], "onUpdate:modelValue": (e) => n(a)[t] = e, onChange: K }, { default: u(() => [(i(true), m(b, null, f(n(se).V, (e) => (i(), _(d, { key: e.V, value: e.V, label: e.L }, null, 8, ["value", "label"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), detailList: u(({ item: t }) => [(i(true), m(b, null, f(n(a)[t], (e, h) => (i(), m("div", { key: h, class: "Radius-container", style: Q({ "margin-bottom": n(a)[t].length > 1 ? "5px" : "0" }) }, [p("div", ge, [r(V, { clearable: "", modelValue: e.numberOne, "onUpdate:modelValue": (s) => e.numberOne = s, modelModifiers: { number: true }, type: "number", placeholder: "数字" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), p("div", ve, [r(y, { modelValue: e.comparisonOperatorOne, "onUpdate:modelValue": (s) => e.comparisonOperatorOne = s, clearable: "" }, { default: u(() => [(i(true), m(b, null, f(n(ie).V, (s) => (i(), _(d, { key: s.V, label: s.L, value: s.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), o[1] || (o[1] = p("div", { class: "item" }, [p("span", { class: "station-text" }, "X")], -1)), p("div", he, [r(y, { modelValue: e.comparisonOperatorTwo, "onUpdate:modelValue": (s) => e.comparisonOperatorTwo = s, clearable: "" }, { default: u(() => [(i(true), m(b, null, f(n(re).V, (s) => (i(), _(d, { key: s.V, label: s.L, value: s.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), p("div", Oe, [r(V, { placeholder: "数字", type: "number", clearable: "", modelValue: e.numberTwo, "onUpdate:modelValue": (s) => e.numberTwo = s, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), p("div", ke, [r(W, { direction: "vertical", style: { height: "100%" } })]), p("div", Le, [r(V, { modelValue: e.organizationInsidePrice, "onUpdate:modelValue": (s) => e.organizationInsidePrice = s, modelModifiers: { number: true }, placeholder: "编制内价格", clearable: "", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), p("div", Ie, [r(V, { modelValue: e.organizationOutsidePrice, "onUpdate:modelValue": (s) => e.organizationOutsidePrice = s, modelModifiers: { number: true }, placeholder: "编制外价格", clearable: "", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), h === 0 ? (i(), m("div", Ce, [r(I, { icon: "el-icon-plus", type: "primary", plain: "", size: "default", onClick: (s) => $(e) }, null, 8, ["onClick"])])) : U("", true), h !== 0 ? (i(), m("div", Me, [r(I, { icon: "el-icon-delete", type: "danger", plain: "", size: "default", onClick: (s) => j(e, h) }, null, 8, ["onClick"])])) : U("", true)], 4))), 128))]), measurementManner: u(({ item: t }) => [r(y, { placeholder: "请选择计量方式", clearable: "", modelValue: n(a)[t], "onUpdate:modelValue": (e) => n(a)[t] = e }, { default: u(() => [(i(true), m(b, null, f(n(de).V, (e) => (i(), _(d, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), organizationInsidePrice: u(({ item: t }) => [r(V, { placeholder: "请输入编制内单价", clearable: "", type: "number", modelValue: n(a)[t], "onUpdate:modelValue": (e) => n(a)[t] = e, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), organizationOutsidePrice: u(({ item: t }) => [r(V, { placeholder: "请输入编制外单价", clearable: "", type: "number", modelValue: n(a)[t], "onUpdate:modelValue": (e) => n(a)[t] = e, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["table-list", "form-data", "form-rules"])])]);
  };
} }, xe = ae(Ue, [["__scopeId", "data-v-1431a5c2"]]);
export {
  xe as default
};
