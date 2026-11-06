import { inject as N } from "vue";
import { ref as r } from "vue";
import { computed as f } from "vue";
import { onMounted as R } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as c } from "vue";
import { createBlock as m } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as p } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as k } from "vue";
import { unref as A } from "vue";
import { createVNode as l } from "vue";
import { ElNotification as w } from "element-plus";
import { ElSwitch as L } from "element-plus";
import { ElFormItem as X } from "element-plus";
import { ElForm as q } from "element-plus";
import { ElCard as z } from "element-plus";
import { vLoading as F } from "element-plus";
import { d as U, g$ as I, V as b, h0 as M } from "../../../../../shared/runtime.js";
import { u as O } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const $ = { class: "clearfix" }, P = { __name: "report-center", setup(G) {
  const g = N("permission"), s = r({ amountShow: 0, amountExcludingTAXShow: 0 }), a = r(s.value), n = r(false), i = r(false), h = f(() => U(a.value, s.value)), y = f(() => n.value || i.value);
  R(() => {
    C();
  });
  async function C() {
    n.value = true;
    try {
      const o = await I();
      a.value = b(o), s.value = o;
    } catch (o) {
      console.log("报表中心配置", o);
    } finally {
      n.value = false;
    }
  }
  async function V() {
    try {
      i.value = true, await M(a.value), w({ title: "报表中心配置设置成功", type: "success", duration: 2500 }), s.value = b(a.value), O("wmsConfig");
    } catch {
      w({ title: "报表中心配置设置失败", type: "error", duration: 2500 });
    } finally {
      i.value = false;
    }
  }
  return (o, e) => {
    const E = T("common-tip-button"), v = L, u = X, S = q, x = z, B = j("permission"), D = F;
    return c(), m(x, { shadow: "always" }, { header: t(() => [p("div", $, [e[3] || (e[3] = p("span", { class: "card-title" }, "报表中心配置（入库明细和出库明细）", -1)), _((c(), m(E, { loading: i.value, disabled: h.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: V }, { default: t(() => e[2] || (e[2] = [k(" 保存 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])), [[B, A(g).reportCenterEdit]])])]), default: t(() => [_((c(), m(S, { disabled: y.value, model: a.value, "label-position": "top", "label-width": "120px" }, { default: t(() => [l(u, { label: "含税价显示" }, { default: t(() => [l(v, { modelValue: a.value.amountShow, "onUpdate:modelValue": e[0] || (e[0] = (d) => a.value.amountShow = d), "active-value": 1, "inactive-value": 0, class: "drawer-switch" }, null, 8, ["modelValue"])]), _: 1 }), l(u, { label: "不含税价显示" }, { default: t(() => [l(v, { modelValue: a.value.amountExcludingTAXShow, "onUpdate:modelValue": e[1] || (e[1] = (d) => a.value.amountExcludingTAXShow = d), "active-value": 1, "inactive-value": 0, class: "drawer-switch" }, null, 8, ["modelValue"])]), _: 1 }), l(u, null, { default: t(() => e[4] || (e[4] = [p("span", { class: "form-item-tip" }, "选择任何一项，税率必须显示（普票除外）。", -1)])), _: 1, __: [4] })]), _: 1 }, 8, ["disabled", "model"])), [[D, n.value]])]), _: 1 });
  };
} };
export {
  P as default
};
