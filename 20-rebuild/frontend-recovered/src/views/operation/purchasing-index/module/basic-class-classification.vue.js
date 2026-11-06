import { sz as V, b as c, ai as g } from "../../../../shared/runtime.js";
import { ref as i } from "vue";
import { watch as r } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as j } from "vue";
const _ = { __name: "basic-class-classification", props: { modelValue: { type: [Number, String], default: void 0 }, basicClass: { type: Number, default: void 0 }, placeholder: { type: String, default: "请选择" } }, emits: ["change", "update:modelValue"], setup(u, { expose: m, emit: p }) {
  const d = p, t = u, l = i([]), o = i();
  r(() => t.modelValue, (e) => {
    o.value = e;
  }, { immediate: true }), r(() => t.basicClass, (e) => {
    e && f();
  }, { immediate: true });
  async function f() {
    try {
      const e = await V(t.basicClass);
      l.value = e;
    } catch (e) {
      console.log(e, "根据基础物料分类查询科目");
    }
  }
  function b(e) {
    let a = e;
    c(a) && (a = void 0);
    const s = !g(a, t.modelValue), n = c(a) && c(t.modelValue);
    s && !n && (d("update:modelValue", a), d("change", a));
  }
  function h(e) {
    return l.value.find((a) => a.subjectId === e);
  }
  return m({ getOption: h }), (e, a) => {
    const s = C("common-select");
    return v(), y("div", null, [j(s, { modelValue: o.value, "onUpdate:modelValue": a[0] || (a[0] = (n) => o.value = n), options: l.value, type: "other", placeholder: u.placeholder, clearable: "", filterable: "", dataStructure: { key: "subjectId", label: "name", value: "subjectId" }, onChange: b }, null, 8, ["modelValue", "options", "placeholder"])]);
  };
} };
export {
  _ as default
};
