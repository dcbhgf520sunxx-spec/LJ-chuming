import { ref as u } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as b } from "vue";
import { createBlock as g } from "vue";
import { withCtx as t } from "vue";
import { unref as i } from "vue";
import { createTextVNode as U } from "vue";
import { createCommentVNode as B } from "vue";
import { createVNode as d } from "vue";
import { isRef as E } from "vue";
import { ElMessage as R } from "element-plus";
import { ElFormItem as T } from "element-plus";
import { ElForm as z } from "element-plus";
import { u as A } from "../../../../../modules/use-crm-user-tree-f2f683a5.js";
import { l as v, u as F, G as N } from "../../../../../shared/runtime.js";
function P(o) {
  return v({ module: "crm", url: "business/center/get/project/public/pool", method: "get", params: o });
}
function S(o) {
  return v({ module: "crm", url: "business/center/assignment/project", method: "post", data: o });
}
const W = { get: P }, M = { __name: "distribution-dialog", props: { modelValue: { type: Boolean, default: void 0 }, currentData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(o, { emit: h }) {
  const r = o, y = h, { userTree: I } = A(), { visible: s, handleClose: m } = F({ emit: y, props: r, showHook: j }), f = u([]), l = u({ userId: void 0 }), p = u(), V = { userId: [{ required: true, message: "请选择分配人员", trigger: "change" }] };
  function j() {
    _(I.value[0].children);
  }
  function _(n) {
    n.forEach((e) => {
      e.isUser ? f.value.push(e) : _(e.children);
    });
  }
  async function k() {
    if (await p.value.validate()) {
      console.log(r.currentData);
      try {
        const e = { crmProjectInformationWarehousingId: r.currentData.id, userId: l.value.userId };
        await S(e), R.success("分配成功"), m();
      } catch (e) {
        console.log(e, "项目分配");
      }
    }
  }
  return (n, e) => {
    const w = c("common-button"), x = c("common-select-v2"), C = T, D = z, O = c("common-dialog");
    return b(), g(O, { title: "项目分配", modelValue: i(s), "onUpdate:modelValue": e[1] || (e[1] = (a) => E(s) ? s.value = a : null), "close-on-click-modal": false, width: "500px", "before-close": i(m) }, { titleRight: t(() => [i(N)(o.permission.confirm) ? (b(), g(w, { key: 0, type: "primary", size: "default", onClick: k }, { default: t(() => e[2] || (e[2] = [U(" 确认 ")])), _: 1, __: [2] })) : B("", true)]), default: t(() => [d(D, { ref_key: "formRef", ref: p, model: l.value, rules: V, "label-width": "90px" }, { default: t(() => [d(C, { label: "选择人员", prop: "userId" }, { default: t(() => [d(x, { style: { width: "100%" }, clearable: "", modelValue: l.value.userId, "onUpdate:modelValue": e[0] || (e[0] = (a) => l.value.userId = a), options: f.value, filterable: "", dataStructure: { value: "id", label: "label", key: "id" }, type: "other", placeholder: "请选择人员" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, J = Object.freeze(Object.defineProperty({ __proto__: null, default: M }, Symbol.toStringTag, { value: "Module" }));
export {
  M as _,
  W as c,
  J as d
};
