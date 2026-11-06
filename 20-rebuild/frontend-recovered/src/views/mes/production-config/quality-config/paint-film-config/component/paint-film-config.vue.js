import { ref as c } from "vue";
import { inject as q } from "vue";
import { computed as K } from "vue";
import { onMounted as j } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as E } from "vue";
import { createBlock as w } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as n } from "vue";
import { withDirectives as U } from "vue";
import { createTextVNode as y } from "vue";
import { unref as o } from "vue";
import { createVNode as l } from "vue";
import { Warning as p } from "@element-plus/icons-vue";
import { ElRadioGroup as X } from "element-plus";
import { ElNotification as G } from "element-plus";
import { ElSwitch as H } from "element-plus";
import { ElFormItem as J } from "element-plus";
import { ElIcon as O } from "element-plus";
import { ElRadio as Y } from "element-plus";
import { ElInputNumber as Z } from "element-plus";
import { ElCol as $ } from "element-plus";
import { ElRow as ee } from "element-plus";
import { ElForm as le } from "element-plus";
import { ElCard as se } from "element-plus";
import { vLoading as ae } from "element-plus";
import { l as V, _ as te, n as ne, dX as r } from "../../../../../../shared/runtime.js";
function oe(m) {
  return V({ url: "/api/paint/thickness/config/get", method: "get", params: m });
}
function ie(m) {
  return V({ url: "/api/paint/thickness/config/set", method: "put", data: m });
}
function ue(m) {
  return V({ url: "/api/paint/thickness/config/paintProcess", method: "get", params: m });
}
const re = { class: "clearfix" }, me = { class: "item-name" }, de = { class: "item-name" }, pe = { class: "item-name" }, ce = { style: { width: "100%", display: "flex", "justify-content": "space-around" } }, fe = { class: "item-name" }, ve = { class: "item-name" }, _e = { class: "item-name" }, be = { __name: "paint-film-config", setup(m) {
  const T = c([]), B = q("permission"), v = { ALL_TEST: { L: "全量检测", K: "ALL_TEST", V: 1 }, QUICK_TEST: { L: "快速检测", K: "QUICK_TEST", V: 2 } };
  ne(v);
  const L = c(), a = c({ enable: r.UN_ENABLE.V, detectionWay: v.ALL_TEST.V, mustScope: r.UN_ENABLE.V, allowManualFill: r.UN_ENABLE.V, processes: [], permissionRange: void 0, minThickness: null, maxThickness: null }), _ = c(false), b = c(false), A = { detectionWay: [{ required: true, message: "请选择上报数量检测方式", trigger: "change" }], processes: [{ required: true, message: "请选择漆膜厚度检测工序", trigger: "change" }], permissionRange: [{ required: true, validator: (s, e, f) => {
    (!a.value.minThickness || !a.value.maxThickness) && f(new Error("漆膜厚度允许范围")), f();
  }, trigger: "change" }] }, S = K(() => a.value.enable ? A : {});
  j(async () => {
    await z(), await F();
  });
  async function F() {
    _.value = true;
    try {
      const s = await oe();
      a.value.enable = (s == null ? void 0 : s.enable) || r.UN_ENABLE.V, a.value.detectionWay = (s == null ? void 0 : s.detectionWay) || v.ALL_TEST.V, a.value.mustScope = (s == null ? void 0 : s.mustScope) || r.UN_ENABLE.V, a.value.allowManualFill = (s == null ? void 0 : s.allowManualFill) || r.UN_ENABLE.V, a.value.processes = (s == null ? void 0 : s.processes) || [], a.value.minThickness = (s == null ? void 0 : s.minThickness) || void 0, a.value.maxThickness = (s == null ? void 0 : s.maxThickness) || void 0;
    } catch (s) {
      console.log("获取结构件漆膜厚度检测配置", s);
    } finally {
      _.value = false;
    }
  }
  async function z() {
    try {
      const { content: s = [] } = await ue();
      T.value = s;
    } catch (s) {
      console.log("获取结构件漆膜厚度检测配置", s);
    }
  }
  async function C() {
    if (await L.value.validate()) {
      b.value = true;
      try {
        await ie(a.value), G({ title: "结构件漆膜厚度检测配置成功", type: "success", duration: 2500 });
      } catch (e) {
        console.log("设置结构件漆膜厚度检测配置", e);
      } finally {
        b.value = false;
      }
    }
  }
  return (s, e) => {
    const f = k("common-tip-button"), g = H, u = J, d = O, N = Y, R = k("common-select-v2"), x = Z, h = $, D = ee, M = le, W = se, I = Q("permission"), P = ae;
    return E(), w(W, { shadow: "always" }, { header: t(() => [n("div", re, [e[8] || (e[8] = n("span", { class: "card-title" }, "结构件漆膜厚度检测配置", -1)), U((E(), w(f, { loading: b.value, disabled: s.submitDisabled, "show-tip": "", size: "mini", type: "primary", style: { float: "right" }, onClick: C }, { default: t(() => e[7] || (e[7] = [y(" 保存 ")])), _: 1, __: [7] }, 8, ["loading", "disabled"])), [[I, o(B).edit]])])]), default: t(() => [U((E(), w(M, { ref_key: "formRef", ref: L, model: a.value, rules: S.value, "label-width": "170px", "label-position": "left" }, { default: t(() => [l(D, { gutter: 20 }, { default: t(() => [l(h, { xs: 24, sm: 24, md: 12, lg: 12 }, { default: t(() => [l(u, { label: "启用漆膜厚度检测", prop: "enable" }, { default: t(() => [l(g, { modelValue: a.value.enable, "onUpdate:modelValue": e[0] || (e[0] = (i) => a.value.enable = i), "active-value": o(r).ENABLED.V, "inactive-value": o(r).UN_ENABLE.V, class: "drawer-switch" }, null, 8, ["modelValue", "active-value", "inactive-value"])]), _: 1 }), l(u, { label: "", "label-width": "0", class: "tip-form-item" }, { default: t(() => [n("span", me, [n("span", null, [l(d, { size: 18, class: "icon-style" }, { default: t(() => [l(o(p))]), _: 1 })]), e[9] || (e[9] = n("span", null, " 启用后，在油漆工序质检环节可以检测并上报漆膜厚度。", -1))])]), _: 1 }), l(u, { label: "上报数量检测方式", prop: "detectionWay" }, { default: t(() => [l(o(X), { modelValue: a.value.detectionWay, "onUpdate:modelValue": e[1] || (e[1] = (i) => a.value.detectionWay = i) }, { default: t(() => [l(N, { value: 1 }, { default: t(() => e[10] || (e[10] = [y("全量检测")])), _: 1, __: [10] }), l(N, { value: 2 }, { default: t(() => e[11] || (e[11] = [y("快速检测")])), _: 1, __: [11] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), l(u, { label: "", "label-width": "0", class: "tip-form-item" }, { default: t(() => [n("span", de, [n("span", null, [l(d, { size: 18, class: "icon-style" }, { default: t(() => [l(o(p))]), _: 1 })]), e[12] || (e[12] = n("span", null, " 全量检测：构件“完成”漆膜厚度检测才可通过质检。", -1)), e[13] || (e[13] = n("div", { style: { "text-indent": "1.5em" } }, "快速检测：构件“未完成”漆膜厚度检测也可通过质检，检测不作为通过质检的硬性条件。", -1))])]), _: 1 }), l(u, { label: "漆膜厚度检测工序", prop: "processes" }, { default: t(() => [l(R, { modelValue: a.value.processes, "onUpdate:modelValue": e[2] || (e[2] = (i) => a.value.processes = i), options: T.value, class: "filter-item", clearable: "", multiple: "", filterable: "", "collapse-tags": "", "collapse-tags-tooltip": "", "max-collapse-tags": 3, placeholder: "请配置油漆/喷漆工序", style: { width: "100%" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(u, { label: "", "label-width": "0", class: "tip-form-item" }, { default: t(() => [n("span", pe, [n("span", null, [l(d, { size: 18, class: "icon-style" }, { default: t(() => [l(o(p))]), _: 1 })]), e[14] || (e[14] = n("span", null, " 配置需要漆膜厚度检测的工序，例如“油漆”、“喷涂”等工序。", -1))])]), _: 1 }), l(u, { label: "漆膜厚度允许范围（统一标准)", prop: "permissionRange", "label-position": "top" }, { default: t(() => [n("div", ce, [n("span", null, [e[15] || (e[15] = n("span", null, "最小厚度（μm）", -1)), l(x, { modelValue: a.value.minThickness, "onUpdate:modelValue": e[3] || (e[3] = (i) => a.value.minThickness = i), min: 0, max: a.value.maxThickness || 999999999, precision: 0, controls: false, size: "default", style: { width: "160px" }, class: "filter-item", clearable: "", placeholder: "最小厚度(（μm）)" }, null, 8, ["modelValue", "max"])]), n("span", null, [e[16] || (e[16] = n("span", null, "最大厚度（μm）", -1)), l(x, { modelValue: a.value.maxThickness, "onUpdate:modelValue": e[4] || (e[4] = (i) => a.value.maxThickness = i), min: a.value.minThickness || 0, max: 999999999, precision: 0, controls: false, size: "default", style: { width: "160px" }, class: "filter-item", clearable: "", placeholder: "最大厚度(（μm）)" }, null, 8, ["modelValue", "min"])])])]), _: 1 }), l(u, { label: "", "label-width": "0", class: "tip-form-item" }, { default: t(() => [n("span", fe, [n("span", null, [l(d, { size: 18, class: "icon-style" }, { default: t(() => [l(o(p))]), _: 1 })]), e[17] || (e[17] = n("span", null, " 漆膜厚度超出设置范围视为漆膜厚度不合格。", -1)), e[18] || (e[18] = n("div", { style: { "text-indent": "1.5em" } }, "若项目或构件具有独立的厚度标准，请在项目或构件上进行独立设置。", -1))])]), _: 1 }), l(u, { label: "超出范围禁止通过质检", prop: "mustScope" }, { default: t(() => [l(g, { modelValue: a.value.mustScope, "onUpdate:modelValue": e[5] || (e[5] = (i) => a.value.mustScope = i), "active-value": o(r).ENABLED.V, "inactive-value": o(r).UN_ENABLE.V, class: "drawer-switch" }, null, 8, ["modelValue", "active-value", "inactive-value"])]), _: 1 }), l(u, { label: "", "label-width": "0", class: "tip-form-item" }, { default: t(() => [n("span", ve, [n("span", null, [l(d, { size: 18, class: "icon-style" }, { default: t(() => [l(o(p))]), _: 1 })]), e[19] || (e[19] = n("span", null, " 启用后，若漆膜检测厚度不在允许范围内，禁止通过质检。", -1))])]), _: 1 })]), _: 1 }), l(h, { xs: 24, sm: 24, md: 12, lg: 12 }, { default: t(() => [l(u, { label: "允许手动录入", prop: "allowManualFill" }, { default: t(() => [l(g, { modelValue: a.value.allowManualFill, "onUpdate:modelValue": e[6] || (e[6] = (i) => a.value.allowManualFill = i), "active-value": o(r).ENABLED.V, "inactive-value": o(r).UN_ENABLE.V, class: "drawer-switch" }, null, 8, ["modelValue", "active-value", "inactive-value"])]), _: 1 }), l(u, { label: "", "label-width": "0", class: "tip-form-item" }, { default: t(() => [n("span", _e, [n("span", null, [l(d, { size: 18, class: "icon-style" }, { default: t(() => [l(o(p))]), _: 1 })]), e[20] || (e[20] = n("span", null, " 启用后，在油漆工序质检环节允许手动录入漆膜厚度。", -1))])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules"])), [[P, _.value]])]), _: 1 });
  };
} }, we = te(be, [["__scopeId", "data-v-b9b7bb0c"]]);
export {
  we as default
};
