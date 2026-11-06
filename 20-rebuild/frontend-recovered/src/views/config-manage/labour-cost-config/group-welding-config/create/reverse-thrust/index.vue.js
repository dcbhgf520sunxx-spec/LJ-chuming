import { inject as M } from "vue";
import { ref as T } from "vue";
import { reactive as L } from "vue";
import { computed as V } from "vue";
import { watch as U } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as p } from "vue";
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
import { dZ as B, _ as j, b as A, e3 as O, e7 as R, e8 as $, e9 as F, d$ as K, e5 as N, e2 as Q } from "../../../../../../shared/runtime.js";
import { b as Z } from "../../../../../../modules/drilling-config-d5ae6cbb.js";
const P = [{ key: "machinePartType", label: "零件类型", verify: true }, { key: "steelClassificationId", label: "零件分类", verify: true }, { key: "specificationPrefixType", label: "规格前缀类型", value: "选中分类自动展示" }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "fixedPrice", label: "输入一口价", verify: true }], q = B(P);
const z = { class: "calculation-container" }, G = { class: "form-container" }, H = { __name: "index", setup(J, { expose: x }) {
  const a = M("reverSetFromData");
  Object.assign(a, { steelClassificationId: null, machinePartType: "" });
  const f = T([]), u = L({}), b = V(() => !A(a.id)), v = async () => {
    const { content: o } = await Z({ productClassificationEnum: a.machinePartType });
    if (o.length === 0) return Q("warning", "该类型下暂无零件分类");
    o.forEach((s) => {
      const r = { id: s.id, name: s.name, keyword: "" };
      s.links.forEach((d) => {
        r.keyword += `【 ${d.keyword} 】`;
      }), f.value.push(r);
    });
  }, k = (o) => {
    f.value.splice(0), a.steelClassificationId = null, u.specificationPrefixType = "选中分类自动展示", a.machinePartType && v();
  }, h = T(""), g = (o) => {
    o ? (h.value = f.value.find((s) => s.id === o).keyword, Object.assign(u, { specificationPrefixType: h })) : u.specificationPrefixType = "选中分类自动展示";
  }, C = V(() => O(P, u));
  return U(() => a, (o) => {
    var s;
    o.machinePartType && v(), ((s = o.specificationPrefixTypeList) == null ? void 0 : s.length) > 0 && (u.specificationPrefixType = o.specificationPrefixTypeList.reduce((r, d) => `${r}【 ${d} 】`, "")), o.fixedPrice = R(o.fixedPrice);
  }, { deep: true, immediate: true }), x({ formData: a }), (o, s) => {
    const r = D, d = S, I = w;
    return n(), p("div", z, [E("div", G, [c(N, { column: 1, "table-list": C.value, "form-data": l(a), "form-rules": l(q) }, { machinePartType: i(({ item: t }) => [c(d, { placeholder: "请选择零件类型", clearable: "", disabled: b.value, modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e, onChange: k }, { default: i(() => [(n(true), p(m, null, _(l($).V, (e) => (n(), y(r, { key: e.K, label: e.L, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), steelClassificationId: i(({ item: t }) => [c(d, { disabled: b.value, placeholder: "请选择零件分类", clearable: "", modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e, onChange: g }, { default: i(() => [(n(true), p(m, null, _(f.value, (e) => (n(), y(r, { label: e.name, key: e.id, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), statisticsMode: i(({ item: t }) => [c(d, { disabled: b.value, placeholder: "请选择统计模式", clearable: "", modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e }, { default: i(() => [(n(true), p(m, null, _(l(F).V, (e) => (n(), y(r, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue"])]), measurementManner: i(({ item: t }) => [c(d, { placeholder: "请选择计量方式", clearable: "", modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e }, { default: i(() => [(n(true), p(m, null, _(l(K).V, (e) => (n(), y(r, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), fixedPrice: i(({ item: t }) => [c(I, { type: "number", placeholder: "请输入价格", clearable: "", modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e, modelModifiers: { number: true } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["table-list", "form-data", "form-rules"])])]);
  };
} }, ee = j(H, [["__scopeId", "data-v-d6d8e4fc"]]);
export {
  ee as default
};
