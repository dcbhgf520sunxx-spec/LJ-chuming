import { ref as c } from "vue";
import { watch as I } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as d } from "vue";
import { createBlock as E } from "vue";
import { withCtx as a } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as S } from "vue";
import { createElementVNode as j } from "vue";
import { createElementBlock as F } from "vue";
import { Fragment as O } from "vue";
import { renderList as A } from "vue";
import { unref as V } from "vue";
import { ElMessage as N } from "element-plus";
import { ElCheckbox as T } from "element-plus";
import { ElCheckboxGroup as q } from "element-plus";
import { ElFormItem as M } from "element-plus";
import { ElInput as U } from "element-plus";
import { ElForm as D } from "element-plus";
import { l as m, u as G, bv as H, dH as P } from "../../../../../shared/runtime.js";
function J(o) {
  return m({ module: "crm", url: "tech/entrust/get/tech/entrust/list", method: "get", params: o });
}
function $(o) {
  return m({ module: "crm", url: "tech/entrust/get/special/programs/detail", method: "get", params: o });
}
function K(o) {
  return m({ module: "crm", url: "tech/entrust/save/special/programs", method: "post", data: o });
}
const ee = { get: J }, Q = { style: { padding: "10px 80px" } }, W = { __name: "form", props: { modelValue: { type: Boolean, default: void 0 }, detailInfo: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(o, { emit: x }) {
  const y = c(false), p = c([]), w = c([]), t = c({ businessEssentials: void 0, checkList: [] }), f = c({}), _ = o, b = x, { visible: g, handleClose: h } = G({ emit: b, props: _ });
  I(() => g.value, async (u) => {
    var e;
    u && (t.value.checkList = [], p.value = (e = H.toArr(P)) == null ? void 0 : e.filter((l) => l.V !== 2));
  }, { immediate: true });
  const L = { checkList: [{ required: true, message: "请选择提报的流程业务", trigger: "change" }], businessEssentials: [{ required: true, message: "请填写内容要点", trigger: "blur" }] };
  async function B() {
    var e;
    if (await f.value.validate()) try {
      const l = (e = t.value.checkList) == null ? void 0 : e.map((r) => {
        var i;
        return { id: (i = _.detailInfo) == null ? void 0 : i.id, crmSpecialBubmissionStatusEnum: r, businessEssentials: t.value.businessEssentials };
      });
      await K(l) && (N.success("提报成功"), b("success"), h());
    } catch (l) {
      console.log(l, "提报失败");
    }
  }
  return (u, e) => {
    const l = k("common-button"), v = T, r = q, i = M, C = U, z = D, R = k("common-dialog");
    return d(), E(R, { visible: V(g), "close-on-click-modal": false, "before-close": V(h), title: "专案提报", width: "600px", top: "10vh" }, { titleRight: a(() => [n(l, { type: "primary", size: "default", disabled: w.value.length === 6, onClick: B, loading: y.value }, { default: a(() => e[2] || (e[2] = [S(" 提报 ")])), _: 1, __: [2] }, 8, ["disabled", "loading"])]), default: a(() => [n(z, { ref_key: "formRef", ref: f, model: t.value, rules: L, size: "default", "label-position": "top", "label-width": "100px" }, { default: a(() => [n(i, { label: "请选择需要提报的流程业务：", prop: "checkList" }, { default: a(() => [j("div", Q, [n(r, { modelValue: t.value.checkList, "onUpdate:modelValue": e[0] || (e[0] = (s) => t.value.checkList = s) }, { default: a(() => [(d(true), F(O, null, A(p.value, (s) => (d(), E(v, { key: s.V, style: { width: "100px" }, size: "large", label: s.L, checked: s.checked, value: s.V }, null, 8, ["label", "checked", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])])]), _: 1 }), n(i, { label: "业务要点", prop: "businessEssentials" }, { default: a(() => [n(C, { modelValue: t.value.businessEssentials, "onUpdate:modelValue": e[1] || (e[1] = (s) => t.value.businessEssentials = s), type: "textarea", autosize: { minRows: 2, maxRows: 4 }, maxlength: "25", "show-word-limit": "", placeholder: "请填写业务要点", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, te = Object.freeze(Object.defineProperty({ __proto__: null, default: W }, Symbol.toStringTag, { value: "Module" }));
export {
  W as _,
  ee as c,
  te as f,
  $ as g
};
