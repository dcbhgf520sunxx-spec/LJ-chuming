import { computed as L } from "vue";
import { ref as U } from "vue";
import { inject as C } from "vue";
import { reactive as M } from "vue";
import { watch as G } from "vue";
import { nextTick as J } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as d } from "vue";
import { withCtx as u } from "vue";
import { unref as i } from "vue";
import { Fragment as _ } from "vue";
import { renderList as b } from "vue";
import { createBlock as y } from "vue";
import { normalizeStyle as W } from "vue";
import { createCommentVNode as D } from "vue";
import { ElOption as X } from "element-plus";
import { ElOptionGroup as Y } from "element-plus";
import { ElSelect as K } from "element-plus";
import { ElInput as Q } from "element-plus";
import { ElDivider as Z } from "element-plus";
import { ElButton as q } from "element-plus";
import { _ as H, e3 as ee, dZ as ae, e4 as le, e0 as te, e1 as oe, d$ as ne, e5 as se, e2 as re } from "../../../../../../shared/runtime.js";
import { c as ie, d as de, g as ue } from "../../../../../../modules/project-assembly-welding-config-107f9ee1.js";
const ce = [{ key: "artifactTypeId", label: "构件类型", verify: true }, { key: "artifactNameList", label: "构件名称" }, { key: "processIdList", label: "选择工序", verify: true }, { key: "pricingManner", label: "牛腿数/零件比/截面" }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "organizationInsidePrice", label: "编制内单价", verify: true }, { key: "organizationOutsidePrice", label: "编制外单价", verify: true }];
const pe = { class: "calculation-container" }, me = { class: "form-container" }, fe = { class: "item" }, _e = { class: "item" }, be = { class: "item" }, Ve = { class: "item" }, ye = { class: "item" }, ve = { class: "item" }, ge = { class: "item" }, Le = { key: 0 }, he = { key: 1 }, Ie = { __name: "index", setup(ke, { expose: N }) {
  const T = L(() => a.id), I = U([]), E = C("projectData"), a = C("calculationFormData"), x = M({}), z = L(() => E ? ie : de), V = M(JSON.parse(JSON.stringify(ce))), P = L(() => ee(V, x)), S = L(() => ae(V)), h = U([]);
  (async () => {
    try {
      const l = await ue();
      if (l.content.length === 0) return re("warning", "构件暂无类型");
      const t = {};
      h.value = l.content, await l.content.forEach((n) => {
        const p = n.artifactClassification;
        t[p] || (t[p] = []), t[p].push(n);
      }), I.value = Object.entries(t).map(([n, p]) => ({ label: n === "1" ? "主构件" : "次构件", options: p }));
    } catch (l) {
      console.error("获取构件分类与工序失败:" + l);
    }
  })();
  const A = async () => {
    try {
      const l = await z.value(a.id);
      l.artifactNameList = l.artifactNameList || [], a.processIdList = l.processList[0].id, delete l.processList, Object.assign(a, l);
    } catch (l) {
      console.log(l);
    }
  }, B = L(() => {
    const l = h.value.find((t) => t.typeId === a.artifactTypeId);
    return l && (a.artifactNameList = l.artifactNameList), l ? l.artifactNameList : [];
  }), k = L(() => {
    const l = h.value.find((t) => t.typeId === a.artifactTypeId);
    return l ? l.processList : [];
  }), j = { artifactTypeId: ["artifactNameList", "processIdList"] }, R = (l) => {
    const t = j[l];
    t && t.forEach((n) => {
      Array.isArray(a[n]) ? a[n].splice(0) : a[n] = null;
    });
  }, w = (l) => {
    a.detailList.push({ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" });
  }, F = (l, t) => {
    a.detailList.splice(t, 1);
  };
  return G(() => a.pricingManner, async (l) => {
    let t = "";
    if (l) {
      l === 1 ? t = "牛腿数" : l === 2 ? t = "构零件比" : t = "构件截面";
      const n = V.findIndex((p) => p.key === "detailList");
      n !== -1 && await V.splice(n, 1), await J(), V.splice(5, 0, { key: "detailList", label: t });
    } else {
      const n = V.findIndex((p) => p.key === "detailList");
      V.splice(n, 1);
    }
  }), N({ formData: a, data: V, getDrillConfigInfo: A }), (l, t) => {
    const n = X, p = Y, v = K, g = Q, $ = Z, O = q;
    return r(), c("div", pe, [f("div", me, [d(se, { column: "1", "table-list": P.value, "form-data": i(a), "form-rules": S.value }, { artifactTypeId: u(({ item: o }) => [d(v, { placeholder: "请输入或选择构件类型", clearable: "", modelValue: i(a)[o], "onUpdate:modelValue": (e) => i(a)[o] = e, onChange: t[0] || (t[0] = (e) => R("artifactTypeId")), filterable: "", disabled: T.value }, { default: u(() => [(r(true), c(_, null, b(I.value, (e) => (r(), y(p, { key: e.label, label: e.label }, { default: u(() => [(r(true), c(_, null, b(e.options, (m) => (r(), y(n, { key: m.typeId, label: m.typeName, value: m.typeId }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["label"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), artifactNameList: u(({ item: o }) => [d(v, { placeholder: "请输入或选择构件名称", clearable: "", multiple: "", modelValue: i(a)[o], "onUpdate:modelValue": (e) => i(a)[o] = e, filterable: "" }, { default: u(() => [(r(true), c(_, null, b(B.value, (e, m) => (r(), y(n, { key: m, label: e, value: e }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), processIdList: u(({ item: o }) => [d(v, { placeholder: "请选择生产工序", clearable: "", modelValue: i(a)[o], "onUpdate:modelValue": (e) => i(a)[o] = e, disabled: !k.value.length }, { default: u(() => [(r(true), c(_, null, b(k.value, (e) => (r(), y(n, { key: e.id, label: e.name, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), pricingManner: u(({ item: o }) => [d(v, { placeholder: "请选择", clearable: "", modelValue: i(a)[o], "onUpdate:modelValue": (e) => i(a)[o] = e, disabled: "" }, { default: u(() => [(r(true), c(_, null, b(i(le).V, (e) => (r(), y(n, { key: e.V, value: e.V, label: e.L }, null, 8, ["value", "label"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), detailList: u(({ item: o }) => [(r(true), c(_, null, b(i(a)[o], (e, m) => (r(), c("div", { key: m, class: "Radius-container", style: W({ "margin-bottom": i(a)[o].length > 1 ? "5px" : "0" }) }, [f("div", fe, [d(g, { clearable: "", modelValue: e.numberOne, "onUpdate:modelValue": (s) => e.numberOne = s, modelModifiers: { number: true }, type: "number", placeholder: "数字" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), f("div", _e, [d(v, { modelValue: e.comparisonOperatorOne, "onUpdate:modelValue": (s) => e.comparisonOperatorOne = s, clearable: "" }, { default: u(() => [(r(true), c(_, null, b(i(te).V, (s) => (r(), y(n, { key: s.V, label: s.L, value: s.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), t[1] || (t[1] = f("div", { class: "item" }, [f("span", { class: "station-text" }, "X")], -1)), f("div", be, [d(v, { modelValue: e.comparisonOperatorTwo, "onUpdate:modelValue": (s) => e.comparisonOperatorTwo = s, clearable: "" }, { default: u(() => [(r(true), c(_, null, b(i(oe).V, (s) => (r(), y(n, { key: s.V, label: s.L, value: s.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), f("div", Ve, [d(g, { placeholder: "数字", type: "number", clearable: "", modelValue: e.numberTwo, "onUpdate:modelValue": (s) => e.numberTwo = s, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), f("div", ye, [d($, { direction: "vertical", style: { height: "100%" } })]), f("div", ve, [d(g, { modelValue: e.organizationInsidePrice, "onUpdate:modelValue": (s) => e.organizationInsidePrice = s, modelModifiers: { number: true }, placeholder: "编制内价格", clearable: "", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), f("div", ge, [d(g, { modelValue: e.organizationOutsidePrice, "onUpdate:modelValue": (s) => e.organizationOutsidePrice = s, modelModifiers: { number: true }, placeholder: "编制外价格", clearable: "", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), m === 0 ? (r(), c("div", Le, [d(O, { icon: "el-icon-plus", type: "primary", plain: "", size: "default", onClick: (s) => w(e) }, null, 8, ["onClick"])])) : D("", true), m !== 0 ? (r(), c("div", he, [d(O, { icon: "el-icon-delete", type: "danger", plain: "", size: "default", onClick: (s) => F(e, m) }, null, 8, ["onClick"])])) : D("", true)], 4))), 128))]), measurementManner: u(({ item: o }) => [d(v, { placeholder: "请选择计量方式", clearable: "", modelValue: i(a)[o], "onUpdate:modelValue": (e) => i(a)[o] = e }, { default: u(() => [(r(true), c(_, null, b(i(ne).V, (e) => (r(), y(n, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), organizationInsidePrice: u(({ item: o }) => [d(g, { placeholder: "请输入编制内单价", clearable: "", type: "number", modelValue: i(a)[o], "onUpdate:modelValue": (e) => i(a)[o] = e, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), organizationOutsidePrice: u(({ item: o }) => [d(g, { placeholder: "请输入编制外单价", clearable: "", type: "number", modelValue: i(a)[o], "onUpdate:modelValue": (e) => i(a)[o] = e, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["table-list", "form-data", "form-rules"])])]);
  };
} }, De = H(Ie, [["__scopeId", "data-v-f19d6508"]]);
export {
  De as default
};
