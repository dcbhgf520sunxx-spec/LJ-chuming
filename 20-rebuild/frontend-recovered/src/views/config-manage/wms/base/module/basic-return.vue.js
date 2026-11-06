import { inject as T } from "vue";
import { ref as d } from "vue";
import { computed as v } from "vue";
import { onMounted as U } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as p } from "vue";
import { createBlock as c } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as o } from "vue";
import { withDirectives as y } from "vue";
import { createTextVNode as k } from "vue";
import { unref as f } from "vue";
import { createVNode as n } from "vue";
import { ElNotification as w } from "element-plus";
import { ElFormItem as A } from "element-plus";
import { ElForm as L } from "element-plus";
import { ElCard as M } from "element-plus";
import { vLoading as S } from "element-plus";
import { d as q, h6 as F, V as g, h7 as I, h8 as O, h9 as G } from "../../../../../shared/runtime.js";
import { u as H } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const J = { class: "clearfix" }, X = { __name: "basic-return", setup(K) {
  const V = T("permission"), l = d({ returnType: void 0, returnDestination: void 0 }), t = d(l.value), i = d(false), r = d(false), E = v(() => q(t.value, l.value)), D = v(() => i.value || r.value);
  U(() => {
    C();
  });
  async function C() {
    i.value = true;
    try {
      const s = await F();
      t.value = g(s), l.value = s;
    } catch (s) {
      console.log("wms基础配置", s);
    } finally {
      i.value = false;
    }
  }
  async function h() {
    try {
      r.value = true, await G(t.value), w({ title: "退库审核配置设置成功", type: "success", duration: 2500 }), l.value = g(t.value), H("wmsConfig");
    } catch {
      w({ title: "退库审核配置设置失败", type: "error", duration: 2500 });
    } finally {
      r.value = false;
    }
  }
  return (s, e) => {
    const x = b("common-tip-button"), _ = b("common-radio"), u = A, B = L, N = M, R = j("permission"), z = S;
    return p(), c(N, { shadow: "always" }, { header: a(() => [o("div", J, [e[3] || (e[3] = o("span", { class: "card-title" }, "退库审核配置", -1)), y((p(), c(x, { disabled: E.value, loading: r.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: h }, { default: a(() => e[2] || (e[2] = [k(" 保存 ")])), _: 1, __: [2] }, 8, ["disabled", "loading"])), [[R, f(V).basicReturnEdit]])])]), default: a(() => [y((p(), c(B, { disabled: D.value, model: t.value, "label-position": "left", "label-width": "130px" }, { default: a(() => [n(u, { label: "审核方式" }, { default: a(() => [n(_, { modelValue: t.value.returnType, "onUpdate:modelValue": e[0] || (e[0] = (m) => t.value.returnType = m), options: f(I).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 }), n(u, { "label-width": "0" }, { default: a(() => e[4] || (e[4] = [o("span", { class: "form-item-tip" }, "办理退库时选择通过方式，默认提交需要审核，可配置提交即通过", -1), o("span", { class: "form-item-tip" }, "审核后通过: 物料退库提交后需审核通过则视为退库成功:", -1), o("span", { class: "form-item-tip" }, "提交即通过:物料退库无需审核处理，提交后即视为退库成功:", -1)])), _: 1, __: [4] }), n(u, { label: "退库目的地" }, { default: a(() => [n(_, { modelValue: t.value.returnDestination, "onUpdate:modelValue": e[1] || (e[1] = (m) => t.value.returnDestination = m), options: f(O).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), n(u, { "label-width": "0" }, { default: a(() => e[5] || (e[5] = [o("span", { class: "form-item-tip" }, "按出库原路返回：物料出库到项目A，物料退库也是退回到项目A的库存中。", -1), o("span", { class: "form-item-tip" }, "直退至公共库：不管物料出库到哪里，物料退库都直接退回到公共库中。", -1), o("span", { class: "form-item-tip" }, "(系统自动处理：物料先退库至出库项目仓库 → 再调拨至公共库)。", -1)])), _: 1, __: [5] })]), _: 1 }, 8, ["disabled", "model"])), [[z, i.value]])]), _: 1 });
  };
} };
export {
  X as default
};
