import { ref as C } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withKeys as m } from "vue";
import { withCtx as p } from "vue";
import { createBlock as V } from "vue";
import { createTextVNode as x } from "vue";
import { createCommentVNode as k } from "vue";
import { ElMessage as f } from "element-plus";
import { ElMessageBox as v } from "element-plus";
import { ElInput as w } from "element-plus";
import { l as i, B, C as N, G as O, E, b as K } from "../../../../shared/runtime.js";
function j(t) {
  return i({ module: "crm", url: "business/license/information/pageList", method: "get", params: t });
}
function U(t) {
  return i({ module: "crm", url: "business/license/information/update/info", method: "post", params: t });
}
function M(t) {
  return i({ module: "crm", url: "business/license/information", method: "get", params: t });
}
const z = { get: j }, Q = { class: "head-container" }, T = { __name: "header", props: { permission: { type: Object, default: () => {
} } }, setup(t) {
  const y = { companyName: void 0, creditCode: void 0 }, { crud: l, query: r } = B(y), s = C();
  async function _() {
    if (K(s.value)) {
      f.error("请先填写社会统一信用代码/名称！");
      return;
    }
    try {
      await v.confirm("此操作将会该企业添加到工商企业信息库中, 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", closeOnClickModal: false, type: "warning" }), await M({ companyNameOrCreditCode: s.value }), f.success("添加成功"), l.toQuery();
    } catch (d) {
      console.log(d);
    }
  }
  return (d, o) => {
    const u = w, g = b("common-button");
    return c(), h("div", Q, [a(u, { class: "filter-item", style: { width: "220px" }, placeholder: "企业名称", modelValue: e(r).companyName, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(r).companyName = n), clearable: "", onKeyup: m(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(u, { class: "filter-item", style: { width: "220px" }, placeholder: "社会统一信用代码", modelValue: e(r).creditCode, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(r).creditCode = n), clearable: "", onKeyup: m(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(N)), a(e(E), null, { optLeft: p(() => [a(u, { style: { width: "250px", "margin-right": "10px" }, modelValue: s.value, "onUpdate:modelValue": o[2] || (o[2] = (n) => s.value = n), placeholder: "社会统一信用代码/名称" }, null, 8, ["modelValue"]), e(O)(t.permission.add) ? (c(), V(g, { key: 0, type: "success", size: "default", onClick: _ }, { default: p(() => o[3] || (o[3] = [x("添加企业")])), _: 1, __: [3] })) : k("", true)]), _: 1 })]);
  };
} }, L = Object.freeze(Object.defineProperty({ __proto__: null, default: T }, Symbol.toStringTag, { value: "Module" }));
export {
  T as _,
  z as c,
  L as h,
  U as u
};
