import { inject as P } from "vue";
import { ref as l } from "vue";
import { computed as _ } from "vue";
import { onMounted as j } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as m } from "vue";
import { createBlock as f } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as g } from "vue";
import { createTextVNode as N } from "vue";
import { unref as A } from "vue";
import { createVNode as s } from "vue";
import { ElNotification as y } from "element-plus";
import { ElFormItem as q } from "element-plus";
import { ElForm as z } from "element-plus";
import { ElCard as F } from "element-plus";
import { vLoading as O } from "element-plus";
import { d as U, h1 as I, V as h, h2 as M } from "../../../../../shared/runtime.js";
import { u as T } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const G = { class: "clearfix" }, W = { __name: "party-a-borrow-return", setup(H) {
  const w = P("permission"), n = l({ boolReturnByOtherProject: false, steelPlateSideLengthDiff: void 0, sectionSteelLengthDiff: void 0, steelCoilLengthDiff: void 0 }), p = l(), t = l(n.value), i = l(false), r = l(false), D = _(() => U(t.value, n.value)), V = _(() => i.value || r.value);
  j(() => {
    x();
  });
  async function x() {
    i.value = true;
    try {
      const a = await I();
      t.value = h(a), n.value = a;
    } catch (a) {
      console.log("获取入库钢材配置", a);
    } finally {
      i.value = false;
    }
  }
  async function L() {
    try {
      if (!await p.value.validate()) return;
      r.value = true, await M(t.value), y({ title: "入库钢材配置设置成功", type: "success", duration: 2500 }), n.value = h(t.value), T("wmsConfig");
    } catch {
      y({ title: "基础钢材配置设置失败", type: "error", duration: 2500 });
    } finally {
      r.value = false;
    }
  }
  return (a, e) => {
    const C = b("common-tip-button"), v = b("common-input-number"), u = q, S = z, B = F, R = k("permission"), E = O;
    return m(), f(B, { shadow: "always" }, { header: o(() => [c("div", G, [e[3] || (e[3] = c("span", { class: "card-title" }, "甲供材料借用归还配置", -1)), g((m(), f(C, { loading: r.value, disabled: D.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: L }, { default: o(() => e[2] || (e[2] = [N(" 保存 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])), [[R, A(w).partyABorrowReturnEdit]])])]), default: o(() => [g((m(), f(S, { ref_key: "formRef", ref: p, disabled: V.value, model: t.value, "label-position": "left", "label-width": "170px" }, { default: o(() => [s(u, { label: "钢板-边长度误差(mm)" }, { default: o(() => [s(v, { modelValue: t.value.steelPlateSideLengthDiff, "onUpdate:modelValue": e[0] || (e[0] = (d) => t.value.steelPlateSideLengthDiff = d), "controls-position": "right", precision: 0, min: 0, max: 1e5, style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), s(u, { label: "型材-长度误差(mm)" }, { default: o(() => [s(v, { modelValue: t.value.sectionSteelLengthDiff, "onUpdate:modelValue": e[1] || (e[1] = (d) => t.value.sectionSteelLengthDiff = d), "controls-position": "right", precision: 0, min: 0, max: 1e5, style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), s(u, null, { default: o(() => e[4] || (e[4] = [c("span", { class: "form-item-tip" }, " 可归还列表中不会检索出误差范围外的钢材。 ", -1)])), _: 1, __: [4] })]), _: 1 }, 8, ["disabled", "model"])), [[E, i.value]])]), _: 1 });
  };
} };
export {
  W as default
};
