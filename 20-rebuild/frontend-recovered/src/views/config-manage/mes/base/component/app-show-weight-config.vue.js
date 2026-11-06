import { inject as M } from "vue";
import { ref as _ } from "vue";
import { computed as w } from "vue";
import { onMounted as O } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as V } from "vue";
import { createBlock as b } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as k } from "vue";
import { createTextVNode as u } from "vue";
import { unref as n } from "vue";
import { createVNode as l } from "vue";
import { ElRadioGroup as r } from "element-plus";
import { ElNotification as A } from "element-plus";
import { ElRadio as B } from "element-plus";
import { ElFormItem as N } from "element-plus";
import { ElForm as j } from "element-plus";
import { ElCard as R } from "element-plus";
import { vLoading as S } from "element-plus";
import { e as q, f as z } from "../../../../../modules/base-6bc46ddf.js";
import { d as F, V as T } from "../../../../../shared/runtime.js";
const I = { class: "clearfix" }, X = { __name: "app-show-weight-config", setup(H) {
  const y = M("permission"), f = _({ pack: void 0, carLoading: void 0, weighingGoods: void 0, checkOutWarehouse: void 0, logisticsManagement: void 0, receiveGoods: void 0 }), o = _(f.value), m = _(false), p = _(false), G = w(() => F(o.value, f.value)), C = w(() => m.value || p.value);
  O(() => {
    E();
  });
  async function E() {
    m.value = true;
    try {
      const { pack: i, carLoading: e, weighingGoods: v, checkOutWarehouse: t, logisticsManagement: s, receiveGoods: g } = await q();
      o.value = { pack: i, carLoading: e, weighingGoods: v, checkOutWarehouse: t, logisticsManagement: s, receiveGoods: g }, f.value = { pack: i, carLoading: e, weighingGoods: v, checkOutWarehouse: t, logisticsManagement: s, receiveGoods: g };
    } catch (i) {
      console.log("获取APP仓库显示重量配置", i);
    } finally {
      m.value = false;
    }
  }
  async function L() {
    p.value = true;
    try {
      await z(o.value), A({ title: "APP仓库显示重量配置成功", type: "success", duration: 2500 }), f.value = T(o.value);
    } catch (i) {
      console.log("设置APP仓库显示重量配置", i);
    } finally {
      p.value = false;
    }
  }
  return (i, e) => {
    const v = U("common-tip-button"), t = B, s = N, g = j, P = R, W = D("permission"), x = S;
    return V(), b(P, { shadow: "always" }, { header: a(() => [c("div", I, [e[7] || (e[7] = c("span", { class: "card-title" }, "APP仓库显示重量配置", -1)), k((V(), b(v, { loading: p.value, disabled: G.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: L }, { default: a(() => e[6] || (e[6] = [u(" 保存 ")])), _: 1, __: [6] }, 8, ["loading", "disabled"])), [[W, n(y).appShowWeightConfigEdit]])])]), default: a(() => [k((V(), b(g, { model: o.value, disabled: C.value, "label-width": "100px" }, { default: a(() => [l(s, { label: "打包", prop: "pack" }, { default: a(() => [l(n(r), { modelValue: o.value.pack, "onUpdate:modelValue": e[0] || (e[0] = (d) => o.value.pack = d) }, { default: a(() => [l(t, { value: 0 }, { default: a(() => e[8] || (e[8] = [u("净重")])), _: 1, __: [8] }), l(t, { value: 1 }, { default: a(() => e[9] || (e[9] = [u("毛重")])), _: 1, __: [9] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), l(s, { label: "装车", prop: "carLoading" }, { default: a(() => [l(n(r), { modelValue: o.value.carLoading, "onUpdate:modelValue": e[1] || (e[1] = (d) => o.value.carLoading = d) }, { default: a(() => [l(t, { value: 0 }, { default: a(() => e[10] || (e[10] = [u("净重")])), _: 1, __: [10] }), l(t, { value: 1 }, { default: a(() => e[11] || (e[11] = [u("毛重")])), _: 1, __: [11] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), l(s, { label: "货物过磅", prop: "weighingGoods" }, { default: a(() => [l(n(r), { modelValue: o.value.weighingGoods, "onUpdate:modelValue": e[2] || (e[2] = (d) => o.value.weighingGoods = d) }, { default: a(() => [l(t, { value: 0 }, { default: a(() => e[12] || (e[12] = [u("净重")])), _: 1, __: [12] }), l(t, { value: 1 }, { default: a(() => e[13] || (e[13] = [u("毛重")])), _: 1, __: [13] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), l(s, { label: "出库复核", prop: "checkOutWarehouse" }, { default: a(() => [l(n(r), { modelValue: o.value.checkOutWarehouse, "onUpdate:modelValue": e[3] || (e[3] = (d) => o.value.checkOutWarehouse = d) }, { default: a(() => [l(t, { value: 0 }, { default: a(() => e[14] || (e[14] = [u("净重")])), _: 1, __: [14] }), l(t, { value: 1 }, { default: a(() => e[15] || (e[15] = [u("毛重")])), _: 1, __: [15] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), l(s, { label: "物流管理", prop: "logisticsManagement" }, { default: a(() => [l(n(r), { modelValue: o.value.logisticsManagement, "onUpdate:modelValue": e[4] || (e[4] = (d) => o.value.logisticsManagement = d) }, { default: a(() => [l(t, { value: 0 }, { default: a(() => e[16] || (e[16] = [u("净重")])), _: 1, __: [16] }), l(t, { value: 1 }, { default: a(() => e[17] || (e[17] = [u("毛重")])), _: 1, __: [17] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), l(s, { label: "收货", prop: " receiveGoods" }, { default: a(() => [l(n(r), { modelValue: o.value.receiveGoods, "onUpdate:modelValue": e[5] || (e[5] = (d) => o.value.receiveGoods = d), disabled: "" }, { default: a(() => [l(t, { value: 0 }, { default: a(() => e[18] || (e[18] = [u("净重")])), _: 1, __: [18] }), l(t, { value: 1 }, { default: a(() => e[19] || (e[19] = [u("毛重")])), _: 1, __: [19] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[x, m.value]])]), _: 1 });
  };
} };
export {
  X as default
};
