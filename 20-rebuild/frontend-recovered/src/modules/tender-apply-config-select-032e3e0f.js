import { g as T } from "./tender-apply-c04ffc5b.js";
import { i as S, b as u, dw as E, ai as V } from "../shared/runtime.js";
import { ref as s } from "vue";
import { computed as h } from "vue";
import { watch as b } from "vue";
import { nextTick as R } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as k } from "vue";
import { unref as w } from "vue";
const j = { __name: "tender-apply-config-select", props: { modelValue: { type: [Number, String, Array] }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, crmTenderRequestConfigEnum: { type: [Number, String] }, crmSpecialBubmissionStatusEnum: { type: [Number, String] } }, emits: ["change", "info-change", "update:modelValue"], setup(v, { emit: y }) {
  const i = y, e = v, n = s(), r = s([]), d = s({}), m = s(false), c = h(() => r.value);
  b(() => e.modelValue, (l) => {
    n.value = l;
  }, { immediate: true }), b([() => e.crmProjectInformationConfigEnum, () => e.crmSpecialBubmissionStatusEnum], (l) => {
    f();
  }, { immediate: true }), f();
  async function f() {
    var l;
    r.value = [];
    try {
      m.value = false;
      const a = await T({ crmTenderRequestConfigEnum: e.crmTenderRequestConfigEnum, crmSpecialBubmissionStatusEnum: e.crmSpecialBubmissionStatusEnum });
      r.value = ((l = a[0]) == null ? void 0 : l.crmTenderRequestConfigDTOS) || [], B();
    } catch (a) {
      console.log(a);
    } finally {
      m.value = true;
    }
  }
  function p(l) {
    let a = l;
    u(a) && (a = void 0);
    const t = !V(a, e.modelValue), o = u(a) && u(e.modelValue);
    t && !o && (i("update:modelValue", a), i("change", a), g(a, e.modelValue));
  }
  function g(l, a) {
    const t = l ? d.value[l] : null, o = a ? d.value[a] : null;
    i("info-change", t, o);
  }
  function B() {
    S(n.value) ? g(n.value) : C();
  }
  function C() {
    R(() => {
      if (!(u(c.value) || n.value) && e.default) {
        n.value = c.value[0].id, p(n.value);
        return;
      }
    });
  }
  return (l, a) => {
    const t = q("common-select");
    return _(), k(t, { modelValue: n.value, "onUpdate:modelValue": a[0] || (a[0] = (o) => n.value = o), size: e.size, disabled: e.disabled, multiple: e.multiple, "collapse-tags": e.collapseTags, loading: !m.value, clearable: e.clearable, filterable: e.filterable, crmTenderRequestConfigEnum: e.crmTenderRequestConfigEnum, placeholder: `${w(E).VL[e.crmTenderRequestConfigEnum]}`, options: c.value, onChange: p }, null, 8, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "filterable", "crmTenderRequestConfigEnum", "placeholder", "options"]);
  };
} };
export {
  j as _
};
