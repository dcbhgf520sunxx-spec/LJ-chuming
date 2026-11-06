import { inject as M } from "vue";
import { ref as V } from "vue";
import { reactive as L } from "vue";
import { computed as T } from "vue";
import { watch as U } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as c } from "vue";
import { withCtx as i } from "vue";
import { unref as l } from "vue";
import { Fragment as m } from "vue";
import { renderList as _ } from "vue";
import { createBlock as y } from "vue";
import { ElOption as D } from "element-plus";
import { ElSelect as S } from "element-plus";
import { ElInput as w } from "element-plus";
import { dZ as B, _ as A, b as R, e3 as $, e7 as j, e8 as F, e9 as K, d$ as O, e5 as N, e2 as Q } from "../../../../../../shared/runtime.js";
import { b as Z } from "../../../../../../modules/drilling-config-d5ae6cbb.js";
const x = [{ key: "machinePartType", label: "零件类型", verify: true }, { key: "steelClassificationId", label: "零件分类", verify: true }, { key: "specificationPrefixType", label: "规格前缀类型", value: "选中分类自动展示" }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "fixedPrice", label: "输入一口价", verify: true }], q = B(x);
const z = { class: "calculation-container" }, G = { class: "form-container" }, H = { __name: "index", setup(J, { expose: P }) {
  const a = M("reverSetFromData"), u = V([]), p = L({}), b = T(() => !R(a.id)), v = async () => {
    const { content: o } = await Z({ productClassificationEnum: a.machinePartType });
    if (o.length === 0) return Q("warning", "该类型下暂无零件分类");
    u.value.splice(0), o.forEach((r) => {
      const s = { id: r.id, name: r.name, keyword: "" };
      r.links.forEach((d) => {
        s.keyword += `【 ${d.keyword} 】`;
      }), u.value.push(s);
    });
  }, k = (o) => {
    u.value.splice(0), a.steelClassificationId = null, p.specificationPrefixType = "选中分类自动展示", a.machinePartType && v();
  }, h = V(""), g = (o) => {
    o ? (h.value = u.value.find((r) => r.id === o).keyword, Object.assign(p, { specificationPrefixType: h })) : p.specificationPrefixType = "选中分类自动展示";
  }, C = T(() => $(x, p));
  return U(() => a, (o) => {
    var r;
    o.machinePartType && v(), ((r = o.specificationPrefixTypeList) == null ? void 0 : r.length) > 0 && (p.specificationPrefixType = o.specificationPrefixTypeList.reduce((s, d) => `${s}【 ${d} 】`, "")), o.fixedPrice = j(o.fixedPrice);
  }, { deep: true, immediate: true }), P({ formData: a }), (o, r) => {
    const s = D, d = S, I = w;
    return n(), f("div", z, [E("div", G, [c(N, { column: 1, "table-list": C.value, "form-data": l(a), "form-rules": l(q) }, { machinePartType: i(({ item: t }) => [c(d, { placeholder: "请选择零件类型", clearable: "", disabled: b.value, modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e, onChange: k }, { default: i(() => [(n(true), f(m, null, _(l(F).V, (e) => (n(), y(s, { key: e.K, label: e.L, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), steelClassificationId: i(({ item: t }) => [c(d, { disabled: b.value, placeholder: "请选择零件分类", clearable: "", modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e, onChange: g }, { default: i(() => [(n(true), f(m, null, _(u.value, (e) => (n(), y(s, { label: e.name, key: e.id, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), statisticsMode: i(({ item: t }) => [c(d, { disabled: b.value, placeholder: "请选择统计模式", clearable: "", modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e }, { default: i(() => [(n(true), f(m, null, _(l(K).V, (e) => (n(), y(s, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), measurementManner: i(({ item: t }) => [c(d, { placeholder: "请选择计量方式", clearable: "", modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e }, { default: i(() => [(n(true), f(m, null, _(l(O).V, (e) => (n(), y(s, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), fixedPrice: i(({ item: t }) => [c(I, { type: "number", placeholder: "请输入价格", clearable: "", modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["table-list", "form-data", "form-rules"])])]);
  };
} }, ee = A(H, [["__scopeId", "data-v-a9b7fed5"]]);
export {
  ee as default
};
