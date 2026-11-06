import { _ as S, ku as k, kv as x, c1 as B, kw as R, ai as P, b as w, kq as c, u as O } from "../../../../shared/runtime.js";
import { ref as p } from "vue";
import { computed as j } from "vue";
import { watch as A } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as N } from "vue";
import { createElementVNode as I } from "vue";
import { normalizeStyle as M } from "vue";
import { ElCascader as L } from "element-plus";
import { resolveComponent as _ } from "vue";
import { createBlock as C } from "vue";
import { withCtx as g } from "vue";
import { createTextVNode as z } from "vue";
import { unref as i } from "vue";
import { isRef as D } from "vue";
import { ElMessage as E } from "element-plus";
const H = { class: "project-cascader-container" }, $ = { __name: "project-cascader-v2", props: { modelValue: { type: [Array, Number] }, projectType: { type: Number, default: k }, showChildren: { type: Boolean, default: true }, checkStrictly: { type: Boolean, default: false }, expandTrigger: { type: String, default: "hover" }, collapseTags: { type: Boolean, default: false }, emitPath: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, showAllLevels: { type: Boolean, default: false }, placeholder: { type: String, default: "可选择项目" } }, emits: ["update:modelValue", "change"], setup(v, { emit: T }) {
  const u = p([]), V = p([]), o = p([]), r = T, t = v, s = p(), d = p(false), y = j(() => ({ value: "id", label: "label", children: "children", checkStrictly: t.checkStrictly, expandTrigger: t.expandTrigger, emitPath: t.emitPath, multiple: t.multiple }));
  n(), A(() => t.modelValue, (a) => {
    a instanceof Array ? s.value = [...a] : s.value = a, f(a);
  }, { immediate: true });
  async function n() {
    var a;
    try {
      const l = await x() || [];
      u.value = l == null ? void 0 : l.map((e) => ({ ...e, label: e.serialNumber + " " + e.shortName })), o.value = (a = u.value) == null ? void 0 : a.filter((e) => e.status === B.PROCESS.V), V.value = R(u.value);
    } catch (l) {
      console.log(l, "获取项目失败");
    }
  }
  const h = j(() => d.value ? V.value : u.value);
  A(d, (a) => {
    let l = s.value;
    if (Array.isArray(s.value)) a ? l = u.value.map((e) => e.id).filter((e) => s.value.includes(e)) : l = o.value.map((e) => e.id).filter((e) => s.value.includes(e));
    else {
      let e = false;
      a ? e = u.value.some((m) => m.id === s.value) : e = o.value.some((m) => m.id === s.value), e || (l = void 0);
    }
    f(l);
  }, { immediate: true });
  function f(a) {
    const l = !P(a, t.modelValue), e = w(a) && w(t.modelValue);
    return l && !e ? (r("update:modelValue", a), r("change", a), true) : false;
  }
  return (a, l) => {
    const e = L;
    return b(), U("span", H, [N(e, { modelValue: s.value, "onUpdate:modelValue": l[0] || (l[0] = (m) => s.value = m), clearable: t.clearable, "collapse-tags": v.collapseTags, disabled: t.disabled, filterable: t.filterable, options: h.value, placeholder: t.placeholder, props: y.value, "show-all-levels": t.showAllLevels, class: "project-cascader", style: { width: "100%" }, onChange: f }, null, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "filterable", "options", "placeholder", "props", "show-all-levels"]), I("span", { style: M({ color: d.value ? "cornflowerblue" : "#c1c2c5" }), class: "all-tip", onClick: l[1] || (l[1] = (m) => d.value = !d.value) }, " All ", 4)]);
  };
} }, q = S($, [["__scopeId", "data-v-9cd8120e"]]), Y = { __name: "contract-type-select-form", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible", "next"], setup(v, { emit: T }) {
  const u = T, V = v, o = p(c.MASTER_CONTRACT.V), r = p(), { visible: t, handleClose: s } = O({ emit: u, props: V, field: "visible" });
  function d() {
    if (!o.value) return E.error("请选择合同类型");
    if (o.value !== c.MASTER_CONTRACT.V && !r.value) return E.error("请选择项目");
    s(), u("next", { contractType: o, projectId: r });
  }
  return A(() => o.value, (y) => {
    y === c.MASTER_CONTRACT.V && (r.value = null);
  }), (y, n) => {
    const h = _("common-button"), f = _("common-radio"), a = _("project-cascader"), l = _("common-dialog");
    return b(), C(l, { modelValue: i(t), "onUpdate:modelValue": n[3] || (n[3] = (e) => D(t) ? t.value = e : null), "before-close": i(s), title: "选择项目类型", width: "420px" }, { titleRight: g(() => [N(h, { size: "mini", type: "primary", onClick: d }, { default: g(() => n[4] || (n[4] = [z("下一步")])), _: 1, __: [4] })]), default: g(() => [N(f, { modelValue: o.value, "onUpdate:modelValue": n[0] || (n[0] = (e) => o.value = e), disabledVal: [i(c).REPLENISHMENT_CONTRACT.V], options: i(c).ENUM, style: { width: "100%", "margin-bottom": "15px" }, type: "enum" }, null, 8, ["modelValue", "disabledVal", "options"]), o.value !== i(c).QUANTITY_ADDITION_CONTRACT.V ? (b(), C(a, { key: 0, modelValue: r.value, "onUpdate:modelValue": n[1] || (n[1] = (e) => r.value = e), disabled: o.value === i(c).MASTER_CONTRACT.V, showChildren: o.value === i(c).REPLENISHMENT_CONTRACT.V, clearable: "", style: { width: "100%" } }, null, 8, ["modelValue", "disabled", "showChildren"])) : (b(), C(i(q), { key: 1, modelValue: r.value, "onUpdate:modelValue": n[2] || (n[2] = (e) => r.value = e), clearable: "", style: { width: "100%" } }, null, 8, ["modelValue"]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Y as default
};
