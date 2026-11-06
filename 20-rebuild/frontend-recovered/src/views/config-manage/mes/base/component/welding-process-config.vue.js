import { ref as s } from "vue";
import { inject as F } from "vue";
import { computed as b } from "vue";
import { onMounted as L } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as p } from "vue";
import { createBlock as f } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as w } from "vue";
import { withDirectives as V } from "vue";
import { createTextVNode as P } from "vue";
import { unref as l } from "vue";
import { createVNode as r } from "vue";
import { withKeys as T } from "vue";
import { withModifiers as U } from "vue";
import { ElNotification as C } from "element-plus";
import { ElFormItem as k } from "element-plus";
import { ElForm as B } from "element-plus";
import { ElCard as j } from "element-plus";
import { vLoading as z } from "element-plus";
import { R as A, S as K } from "../../../../../modules/base-6bc46ddf.js";
import { _ as W, fq as d, d as Y, V as G } from "../../../../../shared/runtime.js";
import { u as H } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const J = { class: "clearfix" }, Q = { __name: "welding-process-config", setup(X) {
  const u = s({ usageMode: d.INDEPENDENT_MANIFESTATION.V, acquisitionFrequency: 30 }), _ = s(), a = s(u.value), E = F("permission"), n = s(false), i = s(false), v = b(() => Y(a.value, u.value)), N = b(() => n.value || i.value);
  L(() => {
    g();
  });
  const g = async () => {
    n.value = true;
    try {
      const o = await A();
      a.value = G(o), u.value = o;
    } catch (o) {
      console.log("wms基础配置", o);
    } finally {
      n.value = false;
    }
  }, q = async () => {
    try {
      if (!await _.value.validate()) return;
      i.value = true, await K(a.value), C({ title: "焊接工艺配置设置成功", type: "success", duration: 2500 }), H("wmsConfig"), v.value = true, g();
    } catch {
      C({ title: "焊接工艺配置设置失败", type: "error", duration: 2500 });
    } finally {
      i.value = false;
    }
  };
  return (o, e) => {
    const D = c("common-tip-button"), y = k, x = c("common-radio"), I = c("common-input-number"), M = B, S = j, R = O("permission"), h = z;
    return p(), f(S, { shadow: "always" }, { header: t(() => [w("div", J, [e[4] || (e[4] = w("span", { class: "card-title" }, "焊接工艺配置", -1)), V((p(), f(D, { style: { float: "right" }, size: "default", type: "primary", loading: i.value, "show-tip": "", onClick: q, disabled: v.value }, { default: t(() => e[3] || (e[3] = [P(" 保存 ")])), _: 1, __: [3] }, 8, ["loading", "disabled"])), [[R, l(E).weldingProcessConfigEdit]])])]), default: t(() => [V((p(), f(M, { ref_key: "formRef", ref: _, disabled: N.value, model: a.value }, { default: t(() => [r(y, { label: "焊接工艺使用模式" }), r(x, { modelValue: a.value.usageMode, "onUpdate:modelValue": e[0] || (e[0] = (m) => a.value.usageMode = m), options: l(d).ENUM, disabledVal: [l(d).LINK_PRODUCTION_PROCESS.V, l(d).ONLY_DISPLAY.V], type: "enum", size: "default" }, null, 8, ["modelValue", "options", "disabledVal"]), r(y, { label: "焊接参数实时采集频次设置" }, { default: t(() => [r(I, { modelValue: a.value.acquisitionFrequency, "onUpdate:modelValue": e[1] || (e[1] = (m) => a.value.acquisitionFrequency = m), "controls-position": "right", precision: 0, min: 1, max: 60, style: { width: "200px" }, onKeydown: e[2] || (e[2] = T(U(() => {
    }, ["prevent"]), ["enter"])) }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["disabled", "model"])), [[h, n.value]])]), _: 1 });
  };
} }, se = W(Q, [["__scopeId", "data-v-0a4dc579"]]);
export {
  se as default
};
