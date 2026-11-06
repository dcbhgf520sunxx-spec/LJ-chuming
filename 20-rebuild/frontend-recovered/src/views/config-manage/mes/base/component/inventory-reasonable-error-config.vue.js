import { inject as G } from "vue";
import { ref as i } from "vue";
import { computed as C } from "vue";
import { watch as M } from "vue";
import { onMounted as J } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as m } from "vue";
import { createBlock as x } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as R } from "vue";
import { toDisplayString as L } from "vue";
import { withDirectives as O } from "vue";
import { unref as w } from "vue";
import { createElementBlock as D } from "vue";
import { Fragment as N } from "vue";
import { renderList as X } from "vue";
import { createCommentVNode as Y } from "vue";
import { ElNotification as Z } from "element-plus";
import { ElFormItem as $ } from "element-plus";
import { ElForm as ee } from "element-plus";
import { ElBadge as ae } from "element-plus";
import { ElTabPane as te } from "element-plus";
import { ElTabs as oe } from "element-plus";
import { ElCard as le } from "element-plus";
import { vLoading as ne } from "element-plus";
import { r as se, t as ie } from "../../../../../modules/base-6bc46ddf.js";
import { _ as ue, a3 as d, n as re, d as de, V as k } from "../../../../../shared/runtime.js";
const ce = { class: "flex-rbc" }, me = { class: "flex-rsc" }, pe = { __name: "inventory-reasonable-error-config", setup(ve) {
  const I = G("permission"), A = [d.ARTIFACT, d.ASSEMBLE, d.MACHINE_PART], y = { MONOMER: { L: "单体", K: "MONOMER", V: 2 }, AREA: { L: "区域", K: "AREA", V: 4 } };
  re(y);
  const p = i(A[0].K), v = C(() => d.KV[p.value]), V = i(y.MONOMER.V), u = i({}), E = i({}), o = i({}), _ = i(false), f = i(false), h = i(true), K = C(() => _.value || f.value);
  M(() => p.value, () => {
    o.value = u.value[v.value] || {};
  }, { immediate: true }), M(() => u.value, () => {
    let l = true;
    for (const e in u.value) de(u.value[e], E.value[e]) || (l = false);
    h.value = l;
  }, { deep: true }), J(() => {
    B();
  });
  async function B() {
    _.value = true;
    try {
      const l = await se(), e = {}, n = {};
      for (const r of l.detailDTOList) e[r.productType] = r, n[r.productType] = k(r);
      V.value = l.rangeActionEnum, u.value = e, o.value = e[v.value] || {}, E.value = n;
    } catch (l) {
      console.log("获取清单合理误差配置失败", l);
    } finally {
      _.value = false;
    }
  }
  async function S() {
    try {
      f.value = true, await ie({ rangeActionEnum: V.value, detailDTOList: Object.values(u.value) }), Z({ title: "清单合理误差配置成功", type: "success", duration: 2500 }), h.value = true, E.value = k(u.value);
    } catch (l) {
      console.log("设置清单合理误差配置失败", l);
    } finally {
      f.value = false;
    }
  }
  return (l, e) => {
    const n = $, r = ee, j = T("common-tip-button"), U = ae, c = T("common-input-number"), F = te, P = oe, W = le, z = Q("permission"), H = ne;
    return m(), x(W, { shadow: "always" }, { header: a(() => [g("div", ce, [g("div", me, [e[6] || (e[6] = g("span", { class: "card-title" }, "清单合理误差配置", -1)), t(r, { inline: "", "label-width": "120px" }, { default: a(() => [t(n, { label: "生效范围：" }, { default: a(() => [R(L(y.VL[V.value]), 1)]), _: 1 })]), _: 1 })]), O((m(), x(j, { loading: f.value, disabled: h.value, "show-tip": "", size: "default", type: "primary", onClick: S }, { default: a(() => e[7] || (e[7] = [R(" 保存 ")])), _: 1, __: [7] }, 8, ["loading", "disabled"])), [[z, w(I).inventoryReasonableErrorConfigEdit]])])]), default: a(() => [t(P, { modelValue: p.value, "onUpdate:modelValue": e[5] || (e[5] = (b) => p.value = b), "tab-position": "left" }, { default: a(() => [(m(), D(N, null, X(A, (b, q) => t(F, { key: q, name: b.K }, { label: a(() => [t(U, { "is-dot": "", hidden: "" }, { default: a(() => [g("span", null, L(b.L), 1)]), _: 2 }, 1024)]), default: a(() => [O((m(), x(r, { disabled: K.value, model: o.value, "label-position": "right", "label-width": v.value !== w(d).MACHINE_PART.V ? "120px" : "150px" }, { default: a(() => [t(n, { label: "长度（MM）" }, { default: a(() => [t(c, { modelValue: o.value.length, "onUpdate:modelValue": e[0] || (e[0] = (s) => o.value.length = s), "controls-position": "right", precision: 2, min: 0, max: 1e5, style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), t(n, { label: "单净重（KG）" }, { default: a(() => [t(c, { modelValue: o.value.netWeight, "onUpdate:modelValue": e[1] || (e[1] = (s) => o.value.netWeight = s), "controls-position": "right", precision: 2, min: 0, max: 1e5, style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), t(n, { label: "单毛重（KG）" }, { default: a(() => [t(c, { modelValue: o.value.grossWeight, "onUpdate:modelValue": e[2] || (e[2] = (s) => o.value.grossWeight = s), "controls-position": "right", precision: 2, min: 0, max: 1e5, style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), v.value & w(d).MACHINE_PART.V ? (m(), D(N, { key: 0 }, [t(n, { label: "规格（厚度 MM）" }, { default: a(() => [t(c, { modelValue: o.value.thickness, "onUpdate:modelValue": e[3] || (e[3] = (s) => o.value.thickness = s), "controls-position": "right", precision: 2, min: 0, max: 1e5, style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), t(n, { label: "规格（宽度 MM）" }, { default: a(() => [t(c, { modelValue: o.value.width, "onUpdate:modelValue": e[4] || (e[4] = (s) => o.value.width = s), "controls-position": "right", precision: 2, min: 0, max: 1e5, style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })], 64)) : Y("", true)]), _: 1 }, 8, ["disabled", "model", "label-width"])), [[H, _.value]])]), _: 2 }, 1032, ["name"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 });
  };
} }, ye = ue(pe, [["__scopeId", "data-v-b6a32349"]]);
export {
  ye as default
};
