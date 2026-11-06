import { inject as B } from "vue";
import { ref as p } from "vue";
import { computed as y } from "vue";
import { onMounted as L } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as f } from "vue";
import { createBlock as v } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as g } from "vue";
import { withDirectives as w } from "vue";
import { createTextVNode as q } from "vue";
import { unref as i } from "vue";
import { createVNode as o } from "vue";
import { ElNotification as x } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElForm as F } from "element-plus";
import { ElCard as O } from "element-plus";
import { vLoading as P } from "element-plus";
import { hr as R, V as _, au as c, hs as W } from "../../../../../shared/runtime.js";
import { j as A } from "../../../../../modules/judgeSameValue-9683bdce.js";
import { u as I } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const T = { class: "clearfix" }, X = { __name: "outbound-list-edit", setup(G) {
  const E = B("permission"), n = p({}), e = p(n.value), u = p(false), d = p(false), h = y(() => A(e.value, n.value)), C = y(() => u.value || d.value);
  L(() => {
    b();
  });
  async function b() {
    u.value = true;
    try {
      const s = await R();
      e.value = _(s), n.value = s;
    } catch (s) {
      console.log("生产使用出库清单编辑", s);
    } finally {
      u.value = false;
    }
  }
  async function N() {
    try {
      d.value = true, await W(e.value), x({ title: "生产使用出库清单编辑设置成功", type: "success", duration: 2500 }), b(), n.value = _(e.value), I("wmsConfig");
    } catch {
      x({ title: "生产使用出库清单编辑设置失败", type: "error", duration: 2500 }), e.value = _(n.value);
    } finally {
      d.value = false;
    }
  }
  return (s, t) => {
    const U = V("common-tip-button"), r = V("common-radio"), m = z, j = F, k = O, D = S("permission"), M = P;
    return f(), v(k, { shadow: "always" }, { header: a(() => [g("div", T, [t[5] || (t[5] = g("span", { class: "card-title" }, "生产使用出库清单是否可编辑配置", -1)), w((f(), v(U, { disabled: h.value, loading: d.value, "show-tip": "", size: "default", style: { float: "right" }, type: "primary", onClick: N }, { default: a(() => t[4] || (t[4] = [q(" 保存 ")])), _: 1, __: [4] }, 8, ["disabled", "loading"])), [[D, i(E).outboundListEditAbleEdit]])])]), default: a(() => [w((f(), v(j, { disabled: C.value, model: e.value, "label-position": "left", "label-width": "200px" }, { default: a(() => [o(m, { label: "数量/核算量：", "label-width": "140px", style: { "margin-left": "10px" } }, { default: a(() => [o(r, { modelValue: e.value.quantity, "onUpdate:modelValue": t[0] || (t[0] = (l) => e.value.quantity = l), options: i(c).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(m, { label: "项目：", "label-width": "140px", style: { "margin-left": "10px" } }, { default: a(() => [o(r, { modelValue: e.value.project, "onUpdate:modelValue": t[1] || (t[1] = (l) => e.value.project = l), options: i(c).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(m, { label: "出库车间：", "label-width": "140px", style: { "margin-left": "10px" } }, { default: a(() => [o(r, { modelValue: e.value.mesWorkshop, "onUpdate:modelValue": t[2] || (t[2] = (l) => e.value.mesWorkshop = l), options: i(c).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(m, { label: "领料人：", "label-width": "140px", style: { "margin-left": "10px" } }, { default: a(() => [o(r, { modelValue: e.value.recipient, "onUpdate:modelValue": t[3] || (t[3] = (l) => e.value.recipient = l), options: i(c).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["disabled", "model"])), [[M, u.value]])]), _: 1 });
  };
} };
export {
  X as default
};
