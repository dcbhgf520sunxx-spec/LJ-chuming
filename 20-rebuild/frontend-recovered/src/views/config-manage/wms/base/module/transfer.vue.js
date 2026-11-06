import { inject as k } from "vue";
import { ref as r } from "vue";
import { computed as f } from "vue";
import { onMounted as z } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as o } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as S } from "vue";
import { unref as v } from "vue";
import { createVNode as m } from "vue";
import { ElNotification as b } from "element-plus";
import { ElFormItem as q } from "element-plus";
import { ElForm as F } from "element-plus";
import { ElCard as M } from "element-plus";
import { vLoading as R } from "element-plus";
import { d as U, ha as A, V as y, h7 as I, hb as O } from "../../../../../shared/runtime.js";
import { u as G } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const H = { class: "clearfix" }, W = { __name: "transfer", setup(J) {
  const g = k("permission"), l = r({ transferType: void 0 }), a = r(l.value), n = r(false), i = r(false), w = f(() => U(a.value, l.value)), h = f(() => n.value || i.value);
  z(() => {
    C();
  });
  async function C() {
    n.value = true;
    try {
      const t = await A();
      a.value = y(t), l.value = t;
    } catch (t) {
      console.log("wms基础配置", t);
    } finally {
      n.value = false;
    }
  }
  async function E() {
    try {
      i.value = true, await O(a.value), b({ title: "调拨审核配置设置成功", type: "success", duration: 2500 }), l.value = y(a.value), G("wmsConfig");
    } catch {
      b({ title: "调拨审核配置设置失败", type: "error", duration: 2500 });
    } finally {
      i.value = false;
    }
  }
  return (t, e) => {
    const V = p("common-tip-button"), x = p("common-radio"), c = q, B = F, T = M, D = L("permission"), N = R;
    return u(), d(T, { shadow: "always" }, { header: s(() => [o("div", H, [e[2] || (e[2] = o("span", { class: "card-title" }, "调拨审核配置", -1)), _((u(), d(V, { loading: i.value, disabled: w.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: E }, { default: s(() => e[1] || (e[1] = [S(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[D, v(g).transferEdit]])])]), default: s(() => [_((u(), d(B, { disabled: h.value, model: a.value, "label-position": "left", "label-width": "130px" }, { default: s(() => [m(c, { label: "审核方式" }, { default: s(() => [m(x, { modelValue: a.value.transferType, "onUpdate:modelValue": e[0] || (e[0] = (j) => a.value.transferType = j), options: v(I).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 }), m(c, { "label-width": "0" }, { default: s(() => e[3] || (e[3] = [o("span", { class: "form-item-tip" }, "办理调拨时选择通过方式，默认提交需要审核，可配置提交即通过", -1), o("span", { class: "form-item-tip" }, "审核后通过: 物料调拨提交后需审核通过则视为调拨成功:", -1), o("span", { class: "form-item-tip" }, "提交即通过:物料调拨无需审核处理，提交后即视为调拨成功:", -1), o("span", { class: "form-item-tip" }, "注意: 甲供调拨(包含借用、买入、归还、归还甲方) 审核方式固定为“审核后通过”不受该配置影响。", -1)])), _: 1, __: [3] })]), _: 1 }, 8, ["disabled", "model"])), [[N, n.value]])]), _: 1 });
  };
} };
export {
  W as default
};
