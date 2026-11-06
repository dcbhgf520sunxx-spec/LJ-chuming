import { ref as f } from "vue";
import { watch as y } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as A } from "vue";
import { withCtx as I } from "vue";
import { createBlock as b } from "vue";
import { createCommentVNode as h } from "vue";
import { Fragment as _ } from "vue";
import { renderList as V } from "vue";
import { ElOption as k } from "element-plus";
import { ElSelect as w } from "element-plus";
import { _ as N, m5 as C, i as j } from "../../../../shared/runtime.js";
const z = { class: "monomer-box filter-item", style: { display: "inline-block" } }, L = { key: 0, style: { "font-size": "12px", color: "red", "margin-left": "10px" } }, D = { __name: "monomer-select", props: { projectId: { type: [Number, String] }, modelValue: { type: [Number, String, Array] }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, showAll: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: true }, defaultValue: { type: [Number, String, Array], default: void 0 }, placeholder: { type: String, default: "请选择单体" }, productType: { type: [Number, String], default: void 0 }, mainProductType: { type: [Number, String], default: void 0 }, filterArea: { type: Boolean, default: true }, showTips: { type: Boolean, default: false } }, emits: ["change", "update:modelValue", "getAreaInfo", "getCurrentInfo"], setup(n, { expose: S, emit: B }) {
  const s = B, p = f(false), o = f(), m = f([]), d = f([]), l = n;
  y(() => l.projectId, (e) => {
    v();
  }, { deep: true, immediate: true }), y(() => l.mainProductType, (e) => {
    e && v();
  }), y(() => l.modelValue, (e) => {
    o.value = e;
  }, { immediate: true });
  async function v() {
    if (m.value = [], d.value = [], !l.projectId) {
      o.value = void 0, c(o.value);
      return;
    }
    let e = [];
    p.value = true;
    try {
      const { content: a = [] } = await C(l.projectId);
      d.value = a || [], e = a.map((t) => ({ value: t.id, label: t.name }));
    } catch (a) {
      console.log("获取单体列表", a);
    } finally {
      m.value = e, l.default && j(e) ? (o.value = e[0].value, c(o.value)) : (o.value = l.defaultValue ? l.defaultValue : void 0, c(o.value)), p.value = false;
    }
  }
  function T(e) {
    return d.value.find((a) => a.id === e);
  }
  function x(e) {
    var a;
    return (a = d.value.find((t) => t.id === e)) == null ? void 0 : a.productTypeList.reduce((t, r) => t | r.type, 0);
  }
  function c(e) {
    var a;
    if (!Array.isArray(e)) {
      let t = {};
      e ? t = d.value.find((u) => u.id === e) : (e = void 0, t = {});
      let r = [];
      l.filterArea && l.productType ? r = ((a = t == null ? void 0 : t.areaSimpleList) == null ? void 0 : a.length) && t.areaSimpleList.filter((u) => u.productType & l.productType) || [] : r = (t == null ? void 0 : t.areaSimpleList) || [], s("getAreaInfo", r, e), s("getCurrentInfo", t);
    }
    s("update:modelValue", e), s("change", e);
  }
  return S({ getOption: T, getProductType: x }), (e, a) => {
    const t = k, r = w;
    return i(), g("div", z, [A(r, { modelValue: o.value, "onUpdate:modelValue": a[0] || (a[0] = (u) => o.value = u), clearable: n.clearable, "collapse-tags": n.collapseTags, disabled: n.disabled, loading: p.value, multiple: n.multiple, "no-data-text": n.projectId ? "无数据" : "未选择项目", placeholder: n.placeholder, size: n.size, filterable: "", onChange: c }, { default: I(() => [n.showAll ? (i(), b(t, { key: 0, value: void 0, label: "全部单体" })) : h("", true), (i(true), g(_, null, V(m.value, (u) => (i(), b(t, { key: u.value, label: u.label, value: u.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "loading", "multiple", "no-data-text", "placeholder", "size"]), n.showTips ? (i(), g("span", L, "*当前单体下未创建批次")) : h("", true)]);
  };
} }, P = N(D, [["__scopeId", "data-v-6cf12349"]]);
export {
  P as default
};
