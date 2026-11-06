import { inject as U } from "vue";
import { ref as h } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as u } from "vue";
import { unref as e } from "vue";
import { createVNode as t } from "vue";
import { createCommentVNode as M } from "vue";
import { createSlots as j } from "vue";
import { withCtx as i } from "vue";
import { withDirectives as w } from "vue";
import { createElementVNode as B } from "vue";
import { toDisplayString as b } from "vue";
import { createBlock as v } from "vue";
import { createTextVNode as Q } from "vue";
import { ElInput as D } from "element-plus";
import { Loading as O } from "@element-plus/icons-vue";
import { ElIcon as z } from "element-plus";
import { ElTag as q } from "element-plus";
import { l as m, B as $, cV as C, gF as H, cJ as R, jZ as A, ap as F, C as J, c as K, jN as c, L as P, E as W } from "../../../../../../shared/runtime.js";
function te(l) {
  return m({ module: "wms", url: "report/raw-materials/send-and-receive-storage/inventory", method: "get", params: l });
}
function Z(l) {
  return m({ module: "wms", url: "report/raw-materials/send-and-receive-storage/inventory/mete", method: "get", params: l });
}
function G(l) {
  return m({ module: "wms", url: "report/raw-materials/inventory/excel", method: "get", responseType: "blob", timeout: 6e7, params: l });
}
const X = { class: "head-container" }, Y = { key: 0 }, ee = { key: 0 }, ae = { __name: "header", setup(l) {
  const V = { workshopIds: void 0, basicClass: void 0, classifyId: void 0, specification: void 0 }, p = U("permission"), { crud: n, query: a, CRUD: E } = $(V), d = h(false), f = h();
  E.HOOK.beforeToQuery = () => {
    S();
  };
  async function S() {
    if (a.basicClass & C) {
      d.value = true;
      try {
        f.value = await Z(n.query) || 0;
      } catch (y) {
        console.log("获取汇总数据", y);
      } finally {
        d.value = false;
      }
    }
  }
  return (y, o) => {
    const _ = N("common-radio-button"), k = D, T = O, x = z, I = q, g = L("permission");
    return r(), u("div", X, [e(n).searchToggle ? (r(), u("div", Y, [t(H, { modelValue: e(a).workshopIds, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(a).workshopIds = s), class: "filter-item", clearable: "", multiple: "", placeholder: "仓库", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), t(_, { modelValue: e(a).basicClass, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(a).basicClass = s), options: e(R).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(_, { modelValue: e(a).orderSupplyType, "onUpdate:modelValue": o[2] || (o[2] = (s) => e(a).orderSupplyType = s), options: e(A).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enumSL", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(F, { modelValue: e(a).classifyId, "onUpdate:modelValue": o[3] || (o[3] = (s) => e(a).classifyId = s), "basic-class": e(a).basicClass, "check-strictly": "", class: "filter-item", clearable: "", "max-limit": "", multiple: "", placeholder: "可选择/输入科目、编号搜索", separator: " > ", "show-all-levels": "", size: "default", style: { width: "300px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "basic-class", "onChange"]), t(k, { modelValue: e(a).specification, "onUpdate:modelValue": o[4] || (o[4] = (s) => e(a).specification = s), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), t(e(J))])) : M("", true), t(e(W), null, j({ optLeft: i(() => [w((r(), v(P, { fn: e(G), params: e(a), "response-header-result": "" }, { default: i(() => o[5] || (o[5] = [Q(" 下载库存报表（根据查询条件） ")])), _: 1, __: [5] }, 8, ["fn", "params"])), [[g, e(p).download]])]), _: 2 }, [e(a).basicClass & e(C) ? { name: "viewLeft", fn: i(() => [w((r(), u("span", null, [t(I, { effect: "plain", class: "filter-item", size: "large" }, { default: i(() => [o[6] || (o[6] = B("span", null, "总量：", -1)), d.value ? (r(), v(x, { key: 1 }, { default: i(() => [t(T)]), _: 1 })) : (r(), u("span", ee, b(e(K)(f.value, "g", e(c).weight.unit, e(c).weight.precision)) + " " + b(e(c).weight.unit), 1))]), _: 1, __: [6] })])), [[g, e(p).get]])]), key: "0" } : void 0]), 1024)]);
  };
} }, le = Object.freeze(Object.defineProperty({ __proto__: null, default: ae }, Symbol.toStringTag, { value: "Module" }));
export {
  ae as _,
  te as g,
  le as h
};
