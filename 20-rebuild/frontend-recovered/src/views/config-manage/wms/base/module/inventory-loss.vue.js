import { inject as j } from "vue";
import { ref as i } from "vue";
import { computed as f } from "vue";
import { onMounted as k } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as I } from "vue";
import { unref as y } from "vue";
import { createVNode as m } from "vue";
import { ElNotification as b } from "element-plus";
import { ElFormItem as R } from "element-plus";
import { ElForm as S } from "element-plus";
import { ElCard as q } from "element-plus";
import { vLoading as F } from "element-plus";
import { d as M, hf as U, V as c, hg as O, hh as A } from "../../../../../shared/runtime.js";
import { u as G } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const H = { class: "clearfix" }, W = { __name: "inventory-loss", setup(J) {
  const g = j("permission"), s = i({ inventoryType: void 0 }), e = i(s.value), n = i(false), l = i(false), w = f(() => M(e.value, s.value)), h = f(() => n.value || l.value);
  k(() => {
    C();
  });
  async function C() {
    n.value = true;
    try {
      const o = await U();
      e.value = c(o), s.value = o;
    } catch (o) {
      console.log("wms基础配置", o);
    } finally {
      n.value = false;
    }
  }
  async function E() {
    try {
      l.value = true, await A(e.value), b({ title: "盘亏基础配置设置成功", type: "success", duration: 2500 }), s.value = c(e.value), G("wmsConfig");
    } catch {
      b({ title: "盘亏基础配置设置失败", type: "error", duration: 2500 }), e.value = c(s.value);
    } finally {
      l.value = false;
    }
  }
  return (o, a) => {
    const V = v("common-tip-button"), x = v("common-radio"), p = R, L = S, D = q, N = z("permission"), T = F;
    return u(), d(D, { shadow: "always" }, { header: t(() => [r("div", H, [a[2] || (a[2] = r("span", { class: "card-title" }, "盘亏基础配置", -1)), _((u(), d(V, { disabled: w.value, loading: l.value, "show-tip": "", size: "default", style: { float: "right" }, type: "primary", onClick: E }, { default: t(() => a[1] || (a[1] = [I(" 保存 ")])), _: 1, __: [1] }, 8, ["disabled", "loading"])), [[N, y(g).basicReturnEdit]])])]), default: t(() => [_((u(), d(L, { disabled: h.value, model: e.value, "label-position": "left", "label-width": "130px" }, { default: t(() => [m(p, { label: "成本归属" }, { default: t(() => [m(x, { modelValue: e.value.inventoryType, "onUpdate:modelValue": a[0] || (a[0] = (B) => e.value.inventoryType = B), options: y(O).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), m(p, { "label-width": "0" }, { default: t(() => a[3] || (a[3] = [r("span", { class: "form-item-tip" }, "归属公司成本：盘亏的物料所产生的成本不会计入到项目中。", -1), r("span", { class: "form-item-tip" }, "归属项目成本：盘亏的物料所产生的成本计入所选择的项目中。", -1)])), _: 1, __: [3] })]), _: 1 }, 8, ["disabled", "model"])), [[T, n.value]])]), _: 1 });
  };
} };
export {
  W as default
};
