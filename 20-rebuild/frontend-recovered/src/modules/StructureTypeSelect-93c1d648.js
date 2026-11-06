import { ref as p } from "vue";
import { onMounted as V } from "vue";
import { watch as x } from "vue";
import { toRefs as L } from "vue";
import { computed as f } from "vue";
import { openBlock as m } from "vue";
import { createBlock as S } from "vue";
import { withCtx as T } from "vue";
import { createElementBlock as w } from "vue";
import { Fragment as z } from "vue";
import { renderList as B } from "vue";
import { mergeProps as k } from "vue";
import { unref as O } from "vue";
import { ElOption as E } from "element-plus";
import { ElSelect as K } from "element-plus";
import { g as A } from "./structure-type-config-b977de76.js";
import { _ as C } from "../shared/runtime.js";
function F(e) {
  const s = p([]), r = p([]), c = p(false), v = (a) => (a || []).map((t) => ({ ...t, label: t.name || t.label, value: t.id || t.value })), i = (a) => {
    if (!a) {
      s.value = r.value.map(({ label: u, value: o }) => ({ label: u, value: o }));
      return;
    }
    const t = r.value.filter((u) => u.projectType !== void 0 ? u.projectType === a : true);
    s.value = t.map(({ label: u, value: o }) => ({ label: u, value: o }));
  }, n = async () => {
    try {
      c.value = true;
      const { content: a = [] } = await A(), t = a || [];
      r.value = v(t || []);
      const u = e && e.value !== void 0 ? e.value : e;
      i(u);
    } catch (a) {
      console.error("获取结构类型列表失败:", a), r.value = [], s.value = [];
    } finally {
      c.value = false;
    }
  };
  return V(() => {
    n();
  }), e && e.value !== void 0 && x(e, (a) => {
    i(a);
  }), { structureTypeList: s, rawList: r, loading: c, refetch: n };
}
const P = { __name: "StructureTypeSelect", props: { modelValue: null, projectType: { type: [String, Number, Object], default: void 0 }, dataStructure: { type: Object, default: null }, disabled: { type: Boolean, default: false }, clearable: { type: Boolean, default: true }, placeholder: { type: String, default: "请选择结构类型" }, size: { type: String, default: "default" }, extraAttrs: { type: Object, default: () => ({}) } }, emits: ["update:modelValue"], setup(e, { emit: s }) {
  const r = e, c = s, { modelValue: v, projectType: i, dataStructure: n } = L(r), { structureTypeList: a, loading: t } = F(i), u = f(() => n.value && n.value.label || "label"), o = f(() => n.value && n.value.value || "value"), _ = f(() => (a.value || []).map((l) => ({ label: l[u.value] ?? l.label ?? l.name ?? "", value: l[o.value] ?? l.value ?? l.id ?? l.K ?? l.V ?? l }))), b = f({ get() {
    return v.value;
  }, set(l) {
    c("update:modelValue", l);
  } });
  return (l, y) => {
    const g = E, h = K;
    return m(), S(h, k({ modelValue: b.value, "onUpdate:modelValue": y[0] || (y[0] = (d) => b.value = d), placeholder: e.placeholder, disabled: e.disabled, clearable: e.clearable, filterable: true, loading: O(t), size: e.size }, e.extraAttrs, { class: "structure-type-select" }), { default: T(() => [(m(true), w(z, null, B(_.value, (d) => (m(), S(g, { key: d.value, label: d.label, value: d.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 16, ["modelValue", "placeholder", "disabled", "clearable", "loading", "size"]);
  };
} }, M = C(P, [["__scopeId", "data-v-cfda3e75"]]);
export {
  M as s
};
