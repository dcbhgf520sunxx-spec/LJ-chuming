import { ref as c } from "vue";
import { watch as _ } from "vue";
import { openBlock as g } from "vue";
import { createBlock as N } from "vue";
import { withCtx as i } from "vue";
import { createElementBlock as I } from "vue";
import { Fragment as h } from "vue";
import { renderList as w } from "vue";
import { ElOption as C } from "element-plus";
import { ElSelect as S } from "element-plus";
import { inject as z } from "vue";
import { resolveComponent as j } from "vue";
import { createVNode as v } from "vue";
import { createTextVNode as x } from "vue";
import { unref as y } from "vue";
import { ElRadioGroup as E } from "element-plus";
import { createCommentVNode as R } from "vue";
import { isRef as U } from "vue";
import { ElRadio as L } from "element-plus";
import { bJ as O, i as P, u as $ } from "../../../../../shared/runtime.js";
const A = { __name: "index", props: { modelValue: { type: [Number, String] }, projectId: { type: Number, default: void 0 }, packType: { type: Number, default: void 0 }, size: { type: String, default: "default" }, placeholder: { type: String, default: "请选择包单号" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false } }, emits: ["update:modelValue", "change"], setup(o, { expose: V, emit: k }) {
  const r = k, u = o, m = c(false), a = c(), t = c([]), n = c([]);
  _(() => u.modelValue, (l) => {
    a.value = l;
  }, { immediate: true }), _(a, (l) => {
    p(l);
  }), _(() => u.packType, (l) => {
    l && (t.value = n.value.filter((e) => e.productType === l));
  }, { immediate: true });
  function p(l) {
    r("update:modelValue", l), r("change", l);
  }
  function T() {
    return t.value;
  }
  async function B() {
    t.value = [];
    let l = [];
    m.value = true;
    try {
      const { content: e } = await O({ projectId: u.projectId }) || [];
      l = e.map((d) => ({ value: d.id, label: `${d.serialNumber}`, productType: d.productType }));
    } catch (e) {
      console.log("获取包单号列表", e);
    } finally {
      n.value = l, t.value = u.packType ? n.value.filter((e) => e.productType === u.packType) : l, u.default && P(t.value) ? a.value = t.value[0].value : a.value = void 0, p(a.value), m.value = false;
    }
  }
  return B(), V({ getOptions: T }), (l, e) => {
    const d = C, b = S;
    return g(), N(b, { modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (s) => a.value = s), size: o.size, disabled: o.disabled, multiple: o.multiple, "collapse-tags": o.collapseTags, loading: m.value, clearable: o.clearable, placeholder: o.placeholder, filterable: "", onChange: p }, { default: i(() => [(g(true), I(h, null, w(t.value, (s) => (g(), N(d, { key: s.value, label: s.label, value: s.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "placeholder"]);
  };
} }, D = { key: 0, style: { "margin-top": "15px" } }, J = { __name: "index", props: { visible: { type: Boolean, default: false }, packLoading: { type: Boolean, default: false }, packType: { type: Number, default: void 0 } }, emits: ["update:visible", "handlePack"], setup(o, { expose: V, emit: k }) {
  const r = k, u = o, m = z("projectId"), a = c(true), t = c(), { visible: n, handleClose: p } = $({ emit: r, props: u, field: "visible" });
  function T() {
    a.value = true, t.value = void 0, p();
  }
  function B() {
    r("handlePack", { isNew: a.value, selectBagId: t.value });
  }
  return V({ handleSuccess: T }), (l, e) => {
    const d = j("common-button"), b = L, s = j("common-dialog");
    return g(), N(s, { title: "选择新增类型", modelValue: y(n), "onUpdate:modelValue": e[2] || (e[2] = (f) => U(n) ? n.value = f : null), "before-close": y(p), width: "450px" }, { titleRight: i(() => [v(d, { loading: o.packLoading, type: "primary", size: "default", onClick: B }, { default: i(() => e[3] || (e[3] = [x("确 定")])), _: 1, __: [3] }, 8, ["loading"])]), default: i(() => [v(y(E), { modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (f) => a.value = f) }, { default: i(() => [v(b, { value: true }, { default: i(() => e[4] || (e[4] = [x("生成新包单")])), _: 1, __: [4] }), v(b, { value: false }, { default: i(() => e[5] || (e[5] = [x("使用原有包单")])), _: 1, __: [5] })]), _: 1 }, 8, ["modelValue"]), a.value ? R("", true) : (g(), I("div", D, [v(y(A), { modelValue: t.value, "onUpdate:modelValue": e[1] || (e[1] = (f) => t.value = f), "project-id": y(m), packType: o.packType, style: { width: "100%" } }, null, 8, ["modelValue", "project-id", "packType"])]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  J as default
};
