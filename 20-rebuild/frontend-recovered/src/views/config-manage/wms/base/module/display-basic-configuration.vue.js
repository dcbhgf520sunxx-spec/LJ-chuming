import { inject as k } from "vue";
import { ref as n } from "vue";
import { computed as p } from "vue";
import { onMounted as z } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as v } from "vue";
import { createTextVNode as M } from "vue";
import { unref as b } from "vue";
import { createVNode as c } from "vue";
import { ElNotification as g } from "element-plus";
import { ElFormItem as q } from "element-plus";
import { ElForm as F } from "element-plus";
import { ElCard as R } from "element-plus";
import { vLoading as U } from "element-plus";
import { d as I, hi as O, V as m, hj as T, hk as W } from "../../../../../shared/runtime.js";
import { u as A } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const G = { class: "clearfix" }, Q = { __name: "display-basic-configuration", setup(H) {
  const w = k("permission"), s = n({ steelsSpeShowConfig: void 0 }), e = n(s.value), i = n(false), l = n(false), y = p(() => I(e.value, s.value)), h = p(() => i.value || l.value);
  z(() => {
    C();
  });
  async function C() {
    i.value = true;
    try {
      const o = await O();
      e.value = m(o), s.value = o;
    } catch (o) {
      console.log("wms基础配置", o);
    } finally {
      i.value = false;
    }
  }
  async function S() {
    try {
      l.value = true, await W(e.value), g({ title: "显示基础配置设置成功", type: "success", duration: 2500 }), s.value = m(e.value), A("wmsConfig");
    } catch {
      g({ title: "显示基础配置设置失败", type: "error", duration: 2500 }), e.value = m(s.value);
    } finally {
      l.value = false;
    }
  }
  return (o, a) => {
    const E = _("common-tip-button"), V = _("common-radio"), f = q, x = F, B = R, D = L("permission"), N = U;
    return u(), d(B, { shadow: "always" }, { header: t(() => [r("div", G, [a[2] || (a[2] = r("span", { class: "card-title" }, "显示基础配置", -1)), v((u(), d(E, { disabled: y.value, loading: l.value, "show-tip": "", size: "default", style: { float: "right" }, type: "primary", onClick: S }, { default: t(() => a[1] || (a[1] = [M(" 保存 ")])), _: 1, __: [1] }, 8, ["disabled", "loading"])), [[D, b(w).displayBasicConfiguratioEdit]])])]), default: t(() => [v((u(), d(x, { disabled: h.value, model: e.value, "label-position": "left", "label-width": "130px" }, { default: t(() => [c(f, { label: "钢材规格拼接方式" }, { default: t(() => [c(V, { modelValue: e.value.steelsSpeShowConfig, "onUpdate:modelValue": a[0] || (a[0] = (j) => e.value.steelsSpeShowConfig = j), options: b(T).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), c(f, { "label-width": "0" }, { default: t(() => a[3] || (a[3] = [r("span", { class: "form-item-tip" }, " 1.在所有存在规格合并展示的物料相关报表，规格展示方式跟随【钢材规格拼接方式】配置。 ", -1), r("span", { class: "form-item-tip" }, " 2.“材质”指配置管理模块→WMS配置→规格配置的内容。（型材类型默认：型材库规格 * 材质） ", -1)])), _: 1, __: [3] })]), _: 1 }, 8, ["disabled", "model"])), [[N, i.value]])]), _: 1 });
  };
} };
export {
  Q as default
};
