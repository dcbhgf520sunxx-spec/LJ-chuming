import { inject as B } from "vue";
import { ref as r } from "vue";
import { computed as f } from "vue";
import { onMounted as N } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as c } from "vue";
import { createBlock as p } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as g } from "vue";
import { createTextVNode as k } from "vue";
import { unref as I } from "vue";
import { createVNode as o } from "vue";
import { ElNotification as b } from "element-plus";
import { ElFormItem as P } from "element-plus";
import { ElForm as U } from "element-plus";
import { ElCard as q } from "element-plus";
import { vLoading as z } from "element-plus";
import { _ as F, d as H, hH as O, V as h, hI as R } from "../../../../../shared/runtime.js";
const T = { class: "clearfix" }, A = { __name: "steel", setup(G) {
  const y = B("permission"), s = r({ steelPlateShortestSideMinLength: void 0, sectionSteelMinLength: void 0, steelCoilMinLength: void 0 }), t = r(s.value), i = r(false), d = r(false), S = f(() => H(t.value, s.value)), x = f(() => i.value || d.value);
  N(() => {
    V();
  });
  async function V() {
    i.value = true;
    try {
      const l = await O();
      t.value = h(l), s.value = l;
    } catch (l) {
      console.log("wms基础配置", l);
    } finally {
      i.value = false;
    }
  }
  async function w() {
    try {
      d.value = true, await R(t.value), b({ title: "钢材废料定义设置成功", type: "success", duration: 2500 }), s.value = h(t.value);
    } catch {
      b({ title: "钢材废料定义设置失败", type: "error", duration: 2500 });
    } finally {
      d.value = false;
    }
  }
  return (l, e) => {
    const L = v("common-tip-button"), u = v("common-input-number"), m = P, C = U, M = q, D = j("permission"), E = z;
    return c(), p(M, { shadow: "always" }, { header: a(() => [_("div", T, [e[4] || (e[4] = _("span", { class: "card-title" }, "钢材废料定义", -1)), g((c(), p(L, { loading: d.value, disabled: S.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: w }, { default: a(() => e[3] || (e[3] = [k(" 保存 ")])), _: 1, __: [3] }, 8, ["loading", "disabled"])), [[D, I(y).steelScrapDefinitionEdit]])]), e[5] || (e[5] = _("span", { class: "tip" }, "出库/入库/退库：小于限定的尺寸，直接进入废料列表", -1))]), default: a(() => [g((c(), p(C, { disabled: x.value, model: t.value, "label-position": "left", "label-width": "160px" }, { default: a(() => [o(m, { label: "钢板-最短边长度(mm)" }, { default: a(() => [o(u, { modelValue: t.value.steelPlateShortestSideMinLength, "onUpdate:modelValue": e[0] || (e[0] = (n) => t.value.steelPlateShortestSideMinLength = n), "controls-position": "right", precision: 0, min: 0, max: 1e5, style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), o(m, { label: "型材-长度(mm)" }, { default: a(() => [o(u, { modelValue: t.value.sectionSteelMinLength, "onUpdate:modelValue": e[1] || (e[1] = (n) => t.value.sectionSteelMinLength = n), "controls-position": "right", precision: 0, min: 0, max: 1e5, style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), o(m, { label: "钢卷-长度(mm)" }, { default: a(() => [o(u, { modelValue: t.value.steelCoilMinLength, "onUpdate:modelValue": e[2] || (e[2] = (n) => t.value.steelCoilMinLength = n), "controls-position": "right", precision: 0, min: 0, max: 1e5, style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["disabled", "model"])), [[E, i.value]])]), _: 1 });
  };
} }, Q = F(A, [["__scopeId", "data-v-da128098"]]);
export {
  Q as default
};
