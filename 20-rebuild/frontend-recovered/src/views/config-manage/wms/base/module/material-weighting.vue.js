import { inject as U } from "vue";
import { ref as n } from "vue";
import { computed as _ } from "vue";
import { onMounted as H } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as p } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as a } from "vue";
import { withDirectives as v } from "vue";
import { createTextVNode as O } from "vue";
import { unref as c } from "vue";
import { createVNode as u } from "vue";
import { createElementBlock as R } from "vue";
import { toDisplayString as I } from "vue";
import { createCommentVNode as j } from "vue";
import { ElNotification as w } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElForm as F } from "element-plus";
import { ElCard as G } from "element-plus";
import { vLoading as q } from "element-plus";
import { h3 as T, h4 as i, V as A, h5 as J } from "../../../../../shared/runtime.js";
import { u as K } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const P = { class: "clearfix" }, Q = { key: 0, style: { color: "red" } }, ee = { __name: "material-weighting", setup(X) {
  const b = U("permission"), o = n({ weightedType: void 0 }), f = n(), s = n(o.value), r = n(false), d = n(false), V = _(() => {
    var t, e;
    return ((t = s.value) == null ? void 0 : t.weightedType) === ((e = o.value) == null ? void 0 : e.weightedType);
  }), E = _(() => r.value || d.value);
  H(() => {
    C();
  });
  async function C() {
    r.value = true;
    try {
      const t = await T();
      t.boolUpdate ? (t.weightedTipType = t.weightedType === i.WHOLE.V ? i.SINGLE.V : i.WHOLE.V, t.weightedType = t.weightedTipType) : t.weightedTipType = null, o.value = t, s.value = A(t);
    } catch (t) {
      console.log("获取物料加权配置", t);
    } finally {
      r.value = false;
    }
  }
  async function L() {
    try {
      if (!await f.value.validate()) return;
      d.value = true, await J({ weightedType: s.value.weightedType }), w({ title: "物料加权配置设置成功", type: "success", duration: 2500 });
      const e = await T();
      e.boolUpdate ? (e.weightedTipType = e.weightedType === i.WHOLE.V ? i.SINGLE.V : i.WHOLE.V, e.weightedType = e.weightedTipType) : e.weightedTipType = null, o.value = e, K("wmsConfig");
    } catch {
      w({ title: "物料加权配置设置失败", type: "error", duration: 2500 });
    } finally {
      d.value = false;
    }
  }
  return (t, e) => {
    const W = h("common-tip-button"), N = h("common-radio"), g = z, x = F, D = G, k = M("permission"), S = q;
    return p(), m(D, { shadow: "always" }, { header: l(() => [a("div", P, [e[2] || (e[2] = a("span", { class: "card-title" }, "物料加权配置", -1)), v((p(), m(W, { loading: d.value, disabled: V.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: L }, { default: l(() => e[1] || (e[1] = [O(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[k, c(b).materialWeightingEdit]])])]), default: l(() => [v((p(), m(x, { ref_key: "formRef", ref: f, disabled: E.value, model: s.value, "label-position": "left", "label-width": "80px" }, { default: l(() => [u(g, { label: "加权方式" }, { default: l(() => {
      var y;
      return [u(N, { modelValue: s.value.weightedType, "onUpdate:modelValue": e[0] || (e[0] = (B) => s.value.weightedType = B), options: c(i).ENUM, type: "enum" }, null, 8, ["modelValue", "options"]), (y = o.value) != null && y.boolUpdate ? (p(), R("span", Q, " （次月修改为：" + I(c(i).VL[o.value.weightedTipType]) + "） ", 1)) : j("", true)];
    }), _: 1 }), u(g, { "label-width": "0" }, { default: l(() => e[3] || (e[3] = [a("span", { class: "form-item-tip" }, "加权方式变更，在未发生物料入库时，即时生效。反之，次月（月末加权后）生效。", -1), a("span", { class: "form-item-tip" }, "全库加权：材料会以公司为维度进行加权平均计算，即相同材料在全库价格相同。(甲供材料仍按照项目库单独计算)。", -1), a("span", { class: "form-item-tip" }, "单库加权：材料会以项目为维度进行加权平均的计算，即相同材料在公共库、不同项目库的价格不相同。", -1), a("span", { class: "form-item-tip", style: { "margin-top": "25px" } }, "全库加权的影响（相对于单库加权）：", -1), a("span", { class: "form-item-tip" }, '1. 甲供材料调拨不提供“借用”与“买入”功能，与 "非甲供物料" 调拨处理方式相同。', -1), a("span", { class: "form-item-tip" }, "2. 存货明细账不体现调拨数据，且存货明细账只可按全库查询。", -1), a("span", { class: "form-item-tip" }, "3. 收发存报表查询时（未选择项目，即全库查询）会进行项目汇总。", -1)])), _: 1, __: [3] })]), _: 1 }, 8, ["disabled", "model"])), [[S, r.value]])]), _: 1 });
  };
} };
export {
  ee as default
};
