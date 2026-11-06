import { inject as z } from "vue";
import { ref as n } from "vue";
import { useStore as A } from "vuex";
import { computed as c } from "vue";
import { onMounted as L } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as r } from "vue";
import { createBlock as u } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as p } from "vue";
import { createTextVNode as F } from "vue";
import { unref as f } from "vue";
import { createVNode as v } from "vue";
import { ElNotification as _ } from "element-plus";
import { ElFormItem as M } from "element-plus";
import { ElForm as U } from "element-plus";
import { ElCard as I } from "element-plus";
import { vLoading as O } from "element-plus";
import { d as R, cq as T, V as b, au as G, cr as H } from "../../../../../shared/runtime.js";
const J = { class: "clearfix" }, W = { __name: "approval-config", setup(K) {
  const g = z("permission"), t = n({ requisition: false }), a = n(t.value), y = A(), s = n(false), l = n(false), h = c(() => R(a.value, t.value)), w = c(() => s.value || l.value);
  L(() => {
    C();
  });
  async function C() {
    s.value = true;
    try {
      const e = { requisition: await T() };
      a.value = b(e), t.value = e;
    } catch (i) {
      console.log("wms基础配置", i);
    } finally {
      s.value = false;
    }
  }
  async function q() {
    try {
      l.value = true, await H(Number(a.value.requisition)), _({ title: "审批配置设置成功", type: "success", duration: 2500 }), t.value = b(a.value), y.dispatch("config/fetchApprovalCfg");
    } catch {
      _({ title: "审批配置设置失败", type: "error", duration: 2500 });
    } finally {
      l.value = false;
    }
  }
  return (i, e) => {
    const E = d("common-tip-button"), V = d("common-radio"), x = M, N = U, D = I, B = S("permission"), j = O;
    return r(), u(D, { shadow: "always" }, { header: o(() => [m("div", J, [e[2] || (e[2] = m("span", { class: "card-title" }, "审批配置", -1)), p((r(), u(E, { loading: l.value, disabled: h.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: q }, { default: o(() => e[1] || (e[1] = [F(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[B, f(g).approvalConfigEdit]])])]), default: o(() => [p((r(), u(N, { disabled: w.value, model: a.value, "label-position": "left", "label-width": "130px" }, { default: o(() => [v(x, { label: "是否开启申购审批" }, { default: o(() => [v(V, { modelValue: a.value.requisition, "onUpdate:modelValue": e[0] || (e[0] = (k) => a.value.requisition = k), options: f(G).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["disabled", "model"])), [[j, s.value]])]), _: 1 });
  };
} };
export {
  W as default
};
