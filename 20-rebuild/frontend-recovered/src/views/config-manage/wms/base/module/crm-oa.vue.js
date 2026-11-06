import { inject as N } from "vue";
import { ref as i } from "vue";
import { computed as u } from "vue";
import { onMounted as A } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as r } from "vue";
import { createBlock as d } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as f } from "vue";
import { createTextVNode as k } from "vue";
import { unref as p } from "vue";
import { createVNode as _ } from "vue";
import { ElNotification as v } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElForm as L } from "element-plus";
import { ElCard as S } from "element-plus";
import { vLoading as q } from "element-plus";
import { d as F, hv as U, V as b, au as I, hw as T } from "../../../../../shared/runtime.js";
import { u as G } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const H = { class: "clearfix" }, W = { __name: "crm-oa", setup(J) {
  const C = N("permission"), s = i({ enabled: void 0 }), e = i(s.value), l = i(false), n = i(false), y = u(() => F(e.value, s.value)), g = u(() => l.value || n.value);
  A(() => {
    w();
  });
  async function w() {
    l.value = true;
    try {
      const a = await U();
      e.value = b(a), s.value = a;
    } catch (a) {
      console.log("wms基础配置", a);
    } finally {
      l.value = false;
    }
  }
  async function h() {
    try {
      n.value = true, await T(e.value), v({ title: "CRM OA配置设置成功", type: "success", duration: 2500 }), s.value = b(e.value), G("wmsConfig");
    } catch {
      v({ title: "CRM OA配置设置失败", type: "error", duration: 2500 });
    } finally {
      n.value = false;
    }
  }
  return (a, o) => {
    const E = c("common-tip-button"), O = c("common-radio"), V = z, x = L, B = S, M = j("permission"), R = q;
    return r(), d(B, { shadow: "always" }, { header: t(() => [m("div", H, [o[2] || (o[2] = m("span", { class: "card-title" }, "CRM OA 配置", -1)), f((r(), d(E, { loading: n.value, disabled: y.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: h }, { default: t(() => o[1] || (o[1] = [k(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[M, p(C).crmOaConfigEdit]])])]), default: t(() => [f((r(), d(x, { disabled: g.value, model: e.value, "label-position": "left", "label-width": "130px" }, { default: t(() => [_(V, { label: "CRM OA" }, { default: t(() => [_(O, { modelValue: e.value.enabled, "onUpdate:modelValue": o[0] || (o[0] = (D) => e.value.enabled = D), options: p(I).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["disabled", "model"])), [[R, l.value]])]), _: 1 });
  };
} };
export {
  W as default
};
