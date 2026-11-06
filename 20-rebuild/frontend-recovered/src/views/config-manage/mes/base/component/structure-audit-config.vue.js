import { inject as k } from "vue";
import { ref as n } from "vue";
import { computed as f } from "vue";
import { onMounted as B } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as r } from "vue";
import { createBlock as d } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as v } from "vue";
import { createTextVNode as c } from "vue";
import { unref as y } from "vue";
import { createVNode as u } from "vue";
import { ElRadioGroup as G } from "element-plus";
import { ElNotification as L } from "element-plus";
import { ElRadio as P } from "element-plus";
import { ElFormItem as R } from "element-plus";
import { ElForm as q } from "element-plus";
import { ElCard as z } from "element-plus";
import { vLoading as A } from "element-plus";
import { N as F, O } from "../../../../../modules/base-6bc46ddf.js";
import { d as I, G as M, V as U } from "../../../../../shared/runtime.js";
const H = { class: "clearfix" }, X = { __name: "structure-audit-config", setup(J) {
  const m = k("permission"), s = n({ auditType: void 0 }), o = n(s.value), l = n(false), i = n(false), b = f(() => I(o.value, s.value)), g = f(() => l.value || i.value);
  B(() => {
    w();
  });
  async function w() {
    if (M(m.machinePartStructureGet)) {
      l.value = true;
      try {
        const a = await F(), e = a == null ? void 0 : a.auditType;
        o.value = { auditType: e }, s.value = { auditType: e };
      } catch (a) {
        console.log("获取构件部件特征定义审批配置", a);
      } finally {
        l.value = false;
      }
    }
  }
  async function E() {
    i.value = true;
    try {
      await O(o.value), L({ title: "配置成功", type: "success", duration: 2500 }), s.value = U(o.value);
    } catch (a) {
      console.log("设置构件部件特征定义审批配置", a);
    } finally {
      i.value = false;
    }
  }
  return (a, e) => {
    const V = S("common-tip-button"), p = P, C = R, T = q, x = z, h = j("permission"), D = A;
    return r(), d(x, { shadow: "always" }, { header: t(() => [_("div", H, [e[2] || (e[2] = _("span", { class: "card-title" }, "构件、部件特征定义配置", -1)), v((r(), d(V, { loading: i.value, disabled: b.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: E }, { default: t(() => e[1] || (e[1] = [c(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[h, y(m).machinePartStructureEdit]])])]), default: t(() => [v((r(), d(T, { model: o.value, disabled: g.value, "label-width": "100px" }, { default: t(() => [u(C, { label: "是否审批", prop: "type" }, { default: t(() => [u(y(G), { modelValue: o.value.auditType, "onUpdate:modelValue": e[0] || (e[0] = (N) => o.value.auditType = N) }, { default: t(() => [u(p, { value: true }, { default: t(() => e[3] || (e[3] = [c("是")])), _: 1, __: [3] }), u(p, { value: false }, { default: t(() => e[4] || (e[4] = [c("否")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[D, l.value]])]), _: 1 });
  };
} };
export {
  X as default
};
