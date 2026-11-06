import { inject as B } from "vue";
import { ref as n } from "vue";
import { computed as v } from "vue";
import { onMounted as A } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as d } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as z } from "vue";
import { unref as N } from "vue";
import { createVNode as r } from "vue";
import { ElNotification as y } from "element-plus";
import { ElCheckbox as L } from "element-plus";
import { ElFormItem as S } from "element-plus";
import { ElForm as q } from "element-plus";
import { ElCard as F } from "element-plus";
import { vLoading as U } from "element-plus";
import { d as I, hx as M, V as b, hy as O } from "../../../../../shared/runtime.js";
import { u as T } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const G = { class: "clearfix" }, Q = { __name: "basic-reject", setup(H) {
  const w = B("permission"), o = n({ materialAmountDisplayWay: { application: void 0, review: void 0 } }), a = n(o.value), s = n(false), i = n(false), g = v(() => I(a.value, o.value)), V = v(() => s.value || i.value);
  A(() => {
    D();
  });
  async function D() {
    s.value = true;
    try {
      const t = await M();
      a.value = b(t), o.value = t;
    } catch (t) {
      console.log("wms退货配置", t);
    } finally {
      s.value = false;
    }
  }
  async function x() {
    try {
      i.value = true, await O(a.value), y({ title: "退货基础配置设置成功", type: "success", duration: 2500 }), o.value = b(a.value), T("wmsConfig");
    } catch {
      y({ title: "退货基础配置设置失败", type: "error", duration: 2500 });
    } finally {
      i.value = false;
    }
  }
  return (t, e) => {
    const C = R("common-tip-button"), p = L, f = S, h = q, j = F, E = W("permission"), k = U;
    return d(), m(j, { shadow: "always" }, { header: l(() => [c("div", G, [e[3] || (e[3] = c("span", { class: "card-title" }, "退货基础配置", -1)), _((d(), m(C, { loading: i.value, disabled: g.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: x }, { default: l(() => e[2] || (e[2] = [z(" 保存 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])), [[E, N(w).basicRejectEdit]])])]), default: l(() => [_((d(), m(h, { disabled: V.value, model: a.value, "label-position": "left", "label-width": "160px" }, { default: l(() => [r(f, { label: "退货页面物料金额显示" }, { default: l(() => [r(p, { modelValue: a.value.materialAmountDisplayWay.application, "onUpdate:modelValue": e[0] || (e[0] = (u) => a.value.materialAmountDisplayWay.application = u), label: "退货申请列表", size: "default" }, null, 8, ["modelValue"]), r(p, { modelValue: a.value.materialAmountDisplayWay.review, "onUpdate:modelValue": e[1] || (e[1] = (u) => a.value.materialAmountDisplayWay.review = u), label: "退货审核列表", size: "default" }, null, 8, ["modelValue"]), r(f, null, { default: l(() => e[4] || (e[4] = [c("span", { class: "form-item-tip" }, "勾选后，会在对应的业务场景展示物料金额。", -1)])), _: 1, __: [4] })]), _: 1 })]), _: 1 }, 8, ["disabled", "model"])), [[k, s.value]])]), _: 1 });
  };
} };
export {
  Q as default
};
