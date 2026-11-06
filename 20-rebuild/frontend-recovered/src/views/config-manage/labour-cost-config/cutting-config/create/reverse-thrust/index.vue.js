import { inject as P } from "vue";
import { reactive as A } from "vue";
import { ref as E } from "vue";
import { computed as p } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as O } from "vue";
import { createVNode as i } from "vue";
import { withCtx as s } from "vue";
import { unref as t } from "vue";
import { Fragment as m } from "vue";
import { renderList as b } from "vue";
import { createBlock as f } from "vue";
import { ElOption as z } from "element-plus";
import { ElSelect as R } from "element-plus";
import { ElInput as j } from "element-plus";
import { dZ as B, _ as K, e3 as N, e8 as $, e9 as G, d$ as Q, ei as Z, e5 as q, e2 as H } from "../../../../../../shared/runtime.js";
import { f as J, h as W } from "../../../../../../modules/cutting-config-59e818a6.js";
import { g as X } from "../../../../../../modules/project-cutting-config-562d5e35.js";
const g = [{ key: "machinePartType", label: "零件类型", verify: true }, { key: "steelClassificationId", label: "零件分类" }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "boolFixedPrice", label: "是否是一口价", verify: true }, { key: "processIdList", label: "生产方式" }, { key: "measurementManner", label: "计量方式" }, { key: "organizationInsidePrice", label: "编制内单价", verify: true }, { key: "organizationOutsidePrice", label: "编制外单价", verify: true }], Y = B(g);
const ee = { class: "calculation-container" }, ae = { class: "form-container" }, le = { __name: "index", setup(te, { expose: L }) {
  const a = P("reverSetFromData"), C = P("projectData");
  a.boolFixedPrice = true;
  const k = A({}), y = E([]), M = p(() => N(g, k)), T = p(() => C ? X : J), U = p(() => {
    const o = y.value.find((d) => d.typeId === a.steelClassificationId);
    return o ? o.processList : [];
  }), h = async () => {
    if (!a.machinePartType) return y.value = [];
    try {
      const { content: o } = await W({ machinePartClassification: a.machinePartType });
      if (o.length === 0) return H("warning", "零件暂无分类");
      y.value = o;
    } catch (o) {
      console.error("获取零件工序失败;" + o);
    }
  }, x = async () => {
    try {
      const { machinePartType: o, steelClassificationId: d, statisticsMode: r, boolFixedPrice: u, processIdList: v, measurementManner: l, organizationInsidePrice: e, organizationOutsidePrice: w } = await T.value(a.id);
      Object.assign(a, { machinePartType: o, steelClassificationId: d, statisticsMode: r, boolFixedPrice: u, processIdList: v, measurementManner: l, organizationInsidePrice: e, organizationOutsidePrice: w }), await h();
    } catch (o) {
      console.error("获取配置详情失败:" + o);
    }
  }, D = { machinePartType: ["steelClassificationId", "statisticsMode", "processIdList", "measurementManner"], steelClassificationId: ["statisticsMode", "processIdList", "measurementManner"] }, _ = (o) => {
    const d = D[o];
    d && d.forEach((r) => {
      Array.isArray(a[r]) ? a[r].splice(0) : a[r] = null;
    });
  }, F = async (o) => {
    _("machinePartType"), await h();
  }, I = p(() => a.boolFixedPrice), S = p(() => a.machinePartType === 4), V = p(() => a.id);
  return L({ formData: a, getProcessInfo: x }), (o, d) => {
    const r = z, u = R, v = j;
    return n(), c("div", ee, [O("div", ae, [i(q, { column: "1", "table-list": M.value, "form-data": t(a), "form-rules": t(Y) }, { machinePartType: s(({ item: l }) => [i(u, { disabled: V.value, placeholder: "请选择零件类型", clearable: "", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, onChange: F }, { default: s(() => [(n(true), c(m, null, b(t($).V, (e) => (n(), f(r, { key: e.K, label: e.L, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), steelClassificationId: s(({ item: l }) => [i(u, { disabled: S.value || V.value, placeholder: "请输入或选择零件分类", clearable: "", filterable: "", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, onChange: d[0] || (d[0] = (e) => _("steelClassificationId")) }, { default: s(() => [(n(true), c(m, null, b(y.value, (e) => (n(), f(r, { label: e.typeName, key: e.typeId, value: e.typeId }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), statisticsMode: s(({ item: l }) => [i(u, { disabled: V.value, placeholder: "请选择统计模式", clearable: "", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e }, { default: s(() => [(n(true), c(m, null, b(t(G).V, (e) => (n(), f(r, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), boolFixedPrice: s(({ item: l }) => [i(u, { modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, placeholder: "请选择是否一口价", onChange: d[1] || (d[1] = (e) => _("boolFixedPrice")) }, { default: s(() => [i(r, { label: "是", value: true })]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), processIdList: s(({ item: l }) => [i(u, { placeholder: "请选择生产工序", clearable: "", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, multiple: "", disabled: I.value }, { default: s(() => [(n(true), c(m, null, b(U.value, (e) => (n(), f(r, { key: e.id, label: e.name, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), measurementManner: s(({ item: l }) => [i(u, { placeholder: "请选择计量方式", clearable: "", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, disabled: I.value }, { default: s(() => [t(a).steelClassificationId !== 1 ? (n(true), c(m, { key: 0 }, b(t(Q).V, (e) => (n(), f(r, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128)) : (n(true), c(m, { key: 1 }, b(t(Z).V, (e) => (n(), f(r, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), organizationInsidePrice: s(({ item: l }) => [i(v, { placeholder: "请输入编制内单价", clearable: "", type: "number", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), organizationOutsidePrice: s(({ item: l }) => [i(v, { placeholder: "请输入编制外单价", clearable: "", type: "number", modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["table-list", "form-data", "form-rules"])])]);
  };
} }, de = K(le, [["__scopeId", "data-v-746053bb"]]);
export {
  de as default
};
