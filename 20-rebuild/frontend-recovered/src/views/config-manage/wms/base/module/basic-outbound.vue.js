import { inject as A } from "vue";
import { ref as d } from "vue";
import { computed as _ } from "vue";
import { onMounted as D } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as f } from "vue";
import { createBlock as p } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as w } from "vue";
import { createTextVNode as F } from "vue";
import { unref as s } from "vue";
import { createVNode as l } from "vue";
import { ElNotification as V } from "element-plus";
import { ElSwitch as I } from "element-plus";
import { ElFormItem as N } from "element-plus";
import { ElForm as R } from "element-plus";
import { ElCard as U } from "element-plus";
import { vLoading as G } from "element-plus";
import { d as P, gX as q, V as g, au as m, g_ as z } from "../../../../../shared/runtime.js";
import { u as M } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const W = { class: "clearfix" }, Q = { __name: "basic-outbound", setup(X) {
  const y = A("permission"), n = d({ boolAuxMatToWorkShopWay: void 0, boolGasOutAfterInbound: void 0, boolCanOutToOtherProject: void 0 }), a = d(n.value), i = d(false), u = d(false), O = _(() => P(a.value, n.value)), E = _(() => i.value || u.value);
  D(() => {
    h();
  });
  async function h() {
    i.value = true;
    try {
      const o = await q();
      a.value = g(o), n.value = o;
    } catch (o) {
      console.log("出库基础配置", o);
    } finally {
      i.value = false;
    }
  }
  async function C() {
    try {
      u.value = true, await z(a.value), V({ title: "出库基础配置设置成功", type: "success", duration: 2500 }), n.value = g(a.value), M("wmsConfig");
    } catch {
      V({ title: "出库基础配置设置失败", type: "error", duration: 2500 });
    } finally {
      u.value = false;
    }
  }
  return (o, e) => {
    const x = L("common-tip-button"), b = I, r = N, B = R, S = U, T = k("permission"), j = G;
    return f(), p(S, { shadow: "always" }, { header: t(() => [c("div", W, [e[3] || (e[3] = c("span", { class: "card-title" }, "出库基础配置", -1)), w((f(), p(x, { loading: u.value, disabled: O.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: C }, { default: t(() => e[2] || (e[2] = [F(" 保存 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])), [[T, s(y).basicOutboundEdit]])])]), default: t(() => [w((f(), p(B, { disabled: E.value, model: a.value, "label-position": "top", "label-width": "120px" }, { default: t(() => [l(r, { label: "气体即入即出" }, { default: t(() => [l(b, { modelValue: a.value.boolGasOutAfterInbound, "onUpdate:modelValue": e[0] || (e[0] = (v) => a.value.boolGasOutAfterInbound = v), "active-value": s(m).TRUE.V, "inactive-value": s(m).FALSE.V, class: "drawer-switch" }, null, 8, ["modelValue", "active-value", "inactive-value"])]), _: 1 }), l(r, null, { default: t(() => e[4] || (e[4] = [c("span", { class: "form-item-tip" }, "“气体”在通过入库审核后，无需办理，直接出库。", -1)])), _: 1, __: [4] }), l(r, { label: "项目仓物料可出库到其它项目" }, { default: t(() => [l(b, { modelValue: a.value.boolCanOutToOtherProject, "onUpdate:modelValue": e[1] || (e[1] = (v) => a.value.boolCanOutToOtherProject = v), "active-value": s(m).TRUE.V, "inactive-value": s(m).FALSE.V, class: "drawer-switch" }, null, 8, ["modelValue", "active-value", "inactive-value"])]), _: 1 }), l(r, null, { default: t(() => e[5] || (e[5] = [c("span", { class: "form-item-tip" }, "在项目仓中可以选择原材料出库到其它项目, 在仓管确认出库后，会生成已审核的物料调拨单（审核人为确认出库的用户）。", -1)])), _: 1, __: [5] })]), _: 1 }, 8, ["disabled", "model"])), [[j, i.value]])]), _: 1 });
  };
} };
export {
  Q as default
};
