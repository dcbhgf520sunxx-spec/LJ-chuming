import { ref as n } from "vue";
import { useStore as I } from "vuex";
import { computed as N } from "vue";
import { resolveComponent as z } from "vue";
import { unref as t } from "vue";
import { openBlock as u } from "vue";
import { createBlock as p } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as H } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as h } from "vue";
import { createCommentVNode as _ } from "vue";
import { withDirectives as L } from "vue";
import { ElMessage as j } from "element-plus";
import { ElCheckbox as q } from "element-plus";
import { ElFormItem as M } from "element-plus";
import { ElForm as R } from "element-plus";
import { ElCard as S } from "element-plus";
import { vLoading as G } from "element-plus";
import { _ as O, d as T, G as m, eX as U, eL as X, eY as Y } from "../../../../../shared/runtime.js";
const A = { key: 0, style: { float: "right" } }, J = { __name: "home-page", setup(K) {
  const l = X.home, f = { isEnable: void 0 }, b = n(), v = I(), d = n(false), r = n(false), e = n({ ...f }), c = n({ ...f }), k = N(() => !T(e.value, c.value));
  C();
  async function C() {
    if (m(l.get)) {
      d.value = true;
      try {
        const { isEnable: o } = await U() || {};
        c.value = { isEnable: o }, e.value = { isEnable: o };
      } catch (o) {
        console.log("error", o);
      } finally {
        d.value = false;
      }
    }
  }
  async function E() {
    r.value = true;
    try {
      await Y(e.value), c.value = { ...e.value }, j.success("修改成功"), v.dispatch("user/getInfo"), v.dispatch("config/fetchConfigInfo");
    } catch (o) {
      console.log("设置基础信息：门户首页", o);
    } finally {
      r.value = false;
    }
  }
  function x() {
    e.value = { ...c.value };
  }
  return (o, a) => {
    const g = z("common-button"), V = q, w = M, P = R, B = S, F = G;
    return t(m)(t(l).get) ? (u(), p(B, { key: 0, class: "box-card", shadow: "hover" }, { header: s(() => [a[3] || (a[3] = H("span", { class: "title" }, "门户首页配置", -1)), t(m)(t(l).edit) && k.value ? (u(), y("div", A, [i(g, { size: "default", type: "warning", onClick: x }, { default: s(() => a[1] || (a[1] = [h("取消修改")])), _: 1, __: [1] }), i(g, { loading: r.value, size: "default", type: "success", onClick: E }, { default: s(() => a[2] || (a[2] = [h("保存")])), _: 1, __: [2] }, 8, ["loading"])])) : _("", true)]), default: s(() => [L((u(), y("div", null, [i(P, { ref_key: "homeFormRef", ref: b, model: e.value }, { default: s(() => [i(w, { label: "是否开启门户首页", prop: "arrangement" }, { default: s(() => [t(m)(t(l).edit) ? (u(), p(V, { key: 0, modelValue: e.value.isEnable, "onUpdate:modelValue": a[0] || (a[0] = (D) => e.value.isEnable = D) }, null, 8, ["modelValue"])) : _("", true)]), _: 1 })]), _: 1 }, 8, ["model"])])), [[F, d.value || r.value]])]), _: 1 })) : _("", true);
  };
} }, Z = O(J, [["__scopeId", "data-v-21ee5310"]]);
export {
  Z as default
};
