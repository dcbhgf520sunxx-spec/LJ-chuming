import { inject as j } from "vue";
import { ref as i } from "vue";
import { computed as c } from "vue";
import { onMounted as k } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as r } from "vue";
import { createBlock as u } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as p } from "vue";
import { withDirectives as v } from "vue";
import { createTextVNode as I } from "vue";
import { unref as f } from "vue";
import { createVNode as _ } from "vue";
import { ElNotification as y } from "element-plus";
import { ElFormItem as L } from "element-plus";
import { ElForm as S } from "element-plus";
import { ElCard as q } from "element-plus";
import { vLoading as F } from "element-plus";
import { d as M, hl as R, V as d, hm as U, hn as O } from "../../../../../shared/runtime.js";
import { u as A } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const H = { class: "clearfix" }, W = { __name: "inventory-type", setup(J) {
  const b = j("permission"), t = i({ inventoryGainType: void 0 }), e = i(t.value), s = i(false), l = i(false), g = c(() => M(e.value, t.value)), h = c(() => s.value || l.value);
  k(() => {
    w();
  });
  async function w() {
    s.value = true;
    try {
      const a = await R();
      e.value = d(a), t.value = a;
    } catch (a) {
      console.log("wms基础配置", a);
    } finally {
      s.value = false;
    }
  }
  async function C() {
    try {
      l.value = true, await O(e.value), y({ title: "物料获取配置设置成功", type: "success", duration: 2500 }), t.value = d(e.value), A("wmsConfig");
    } catch {
      y({ title: "物料获取配置设置失败", type: "error", duration: 2500 }), e.value = d(t.value);
    } finally {
      l.value = false;
    }
  }
  return (a, o) => {
    const E = m("common-tip-button"), T = m("common-radio"), V = L, G = S, x = q, D = z("permission"), N = F;
    return r(), u(x, { shadow: "always" }, { header: n(() => [p("div", H, [o[2] || (o[2] = p("span", { class: "card-title" }, "物料获取配置", -1)), v((r(), u(E, { disabled: g.value, loading: l.value, "show-tip": "", size: "default", style: { float: "right" }, type: "primary", onClick: C }, { default: n(() => o[1] || (o[1] = [I(" 保存 ")])), _: 1, __: [1] }, 8, ["disabled", "loading"])), [[D, f(b).inventoryGainTypeEdit]])])]), default: n(() => [v((r(), u(G, { disabled: h.value, model: e.value, "label-position": "left", "label-width": "130px" }, { default: n(() => [_(V, { label: "物料获取" }, { default: n(() => [_(T, { modelValue: e.value.inventoryGainType, "onUpdate:modelValue": o[0] || (o[0] = (B) => e.value.inventoryGainType = B), options: f(U).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["disabled", "model"])), [[N, s.value]])]), _: 1 });
  };
} };
export {
  W as default
};
