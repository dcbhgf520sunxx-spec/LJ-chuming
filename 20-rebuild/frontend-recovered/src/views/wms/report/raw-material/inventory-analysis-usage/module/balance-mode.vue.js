import { computed as b } from "vue";
import { ref as r } from "vue";
import { inject as Q } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as M } from "vue";
import { createBlock as E } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as _ } from "vue";
import { createElementVNode as t } from "vue";
import { normalizeStyle as $ } from "vue";
import { unref as n } from "vue";
import { toDisplayString as G } from "vue";
import { withDirectives as J } from "vue";
import { ElNotification as K } from "element-plus";
import { ElFormItem as W } from "element-plus";
import { ElPopover as X } from "element-plus";
import { ElForm as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { _ as ee, u as le, o as oe, d as te, V as g, BL as N, BM as u } from "../../../../../../shared/runtime.js";
import { p as ae } from "../../../../../../modules/inventory-analysis-usage-4b0f952d.js";
const se = "/static/png/wms-merge-d6a1f070.png", ne = "/static/png/wms-not-merge-61b75626.png";
const ie = { style: { "margin-bottom": "30px" } }, de = { class: "module" }, ue = { style: { display: "flex" } }, re = { class: "form-item-tip" }, me = { style: { width: "500px" } }, pe = ["src"], ve = { style: { width: "500px" } }, ce = ["src"], fe = { __name: "balance-mode", props: { visible: { type: Boolean, default: false }, inventoryBase: { type: Object, default: () => ({}) } }, emits: ["update:visible", "handleInventoryBase"], setup(y, { emit: I }) {
  const w = I, c = y, U = b(() => "结存模式"), { visible: k, handleClose: h } = le({ emit: w, props: c, field: "visible", showHook: z }), { maxHeight: C } = oe({ mainBox: [".raw-mat-send-and-receive-storage-balance-mode"], extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], navbar: false, clientHRepMainH: true, extraHeight: 100 }), V = r(false), m = r({ boolEndMonth: false }), l = r(m.value), j = Q("crud"), x = r(false), p = r(false), H = b(() => te(l.value, m.value)), L = b(() => x.value || p.value);
  function z() {
    R();
  }
  function D() {
    l.value.workshopId || (l.value.warehouseId = false);
  }
  async function R() {
    try {
      V.value = true, l.value = g(c.inventoryBase), m.value = g(c.inventoryBase);
    } catch (f) {
      console.error(f);
    } finally {
      V.value = false;
    }
  }
  async function S() {
    try {
      p.value = true, await ae(l.value), K({ title: "结存模式变更成功", type: "success", duration: 2500 }), m.value = g(l.value), h(), w("handleInventoryBase"), j.toQuery();
    } catch {
    } finally {
      p.value = false;
    }
  }
  return (f, e) => {
    const q = v("common-tip-button"), d = v("common-radio"), i = W, A = v("common-button"), F = X, O = Y, T = v("common-dialog"), P = Z;
    return M(), E(T, { ref: "drawerRef", "before-close": n(h), "close-on-click-modal": false, "close-on-press-escape": false, title: U.value, visible: n(k), "custom-class": "raw-mat-send-and-receive-storage-balance-mode", "show-close": "", width: "35%" }, { titleRight: a(() => [o(q, { disabled: H.value, loading: p.value, class: "filter-item", "show-tip": "", size: "default", type: "primary", onClick: S }, { default: a(() => e[7] || (e[7] = [_(" 保存 ")])), _: 1, __: [7] }, 8, ["disabled", "loading"])]), default: a(() => {
      var B;
      return [t("div", { style: $(`height: ${n(C)}px;overflow-y: auto`) }, [t("div", ie, " 当前结存模式：" + G(n(N).VL[(B = y.inventoryBase) == null ? void 0 : B.boolEndMonth]), 1), t("div", null, [J((M(), E(O, { disabled: L.value, model: l.value }, { default: a(() => [t("div", de, [o(i, { label: "模式：" }, { default: a(() => [o(d, { modelValue: l.value.boolEndMonth, "onUpdate:modelValue": e[0] || (e[0] = (s) => l.value.boolEndMonth = s), options: n(N).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, null, { default: a(() => e[8] || (e[8] = [t("div", { class: "form-item-tip" }, " 月度自动结存：每到月底会自动进行结存，按月维度生成统计数据。 ", -1), t("div", { class: "form-item-tip" }, " 手动结存：由用户手动进行结存操作，结存时间范围可由用户自由控制。 ", -1)])), _: 1, __: [8] })]), o(i, { label: "字段配置：" }), t("div", ue, [t("div", null, [o(i, { label: "品牌：", "label-width": "100px" }, { default: a(() => [o(d, { modelValue: l.value.brand, "onUpdate:modelValue": e[1] || (e[1] = (s) => l.value.brand = s), options: n(u).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, { label: "项目：", "label-width": "100px" }, { default: a(() => [o(d, { modelValue: l.value.projectId, "onUpdate:modelValue": e[2] || (e[2] = (s) => l.value.projectId = s), options: n(u).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, { label: "仓库：", "label-width": "100px" }, { default: a(() => [o(d, { modelValue: l.value.workshopId, "onUpdate:modelValue": e[3] || (e[3] = (s) => l.value.workshopId = s), options: n(u).ENUM, type: "enum", onChange: D }, null, 8, ["modelValue", "options"])]), _: 1 })]), t("div", null, [o(i, { label: "颜色：", "label-width": "100px" }, { default: a(() => [o(d, { modelValue: l.value.color, "onUpdate:modelValue": e[4] || (e[4] = (s) => l.value.color = s), options: n(u).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, { label: "炉批号：", "label-width": "100px" }, { default: a(() => [o(d, { modelValue: l.value.heatNoAndBatchNo, "onUpdate:modelValue": e[5] || (e[5] = (s) => l.value.heatNoAndBatchNo = s), options: n(u).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, { label: "存储位置：", "label-width": "100px" }, { default: a(() => [o(d, { modelValue: l.value.warehouseId, "onUpdate:modelValue": e[6] || (e[6] = (s) => l.value.warehouseId = s), disabled: !l.value.workshopId, options: n(u).ENUM, type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })])]), o(i, null, { default: a(() => [t("div", re, [e[12] || (e[12] = _("     以“品牌”字段为例： ")), o(F, { width: 550, class: "box-item", placement: "top", title: "示例", trigger: "click" }, { reference: a(() => [o(A, { class: "filter-item", size: "default", type: "success" }, { default: a(() => e[9] || (e[9] = [_(" 示例 ")])), _: 1, __: [9] })]), default: a(() => [t("div", null, [e[10] || (e[10] = t("div", null, "合并:", -1)), t("div", me, [t("img", { src: n(se), class: "img-merge", style: { width: "100%" } }, null, 8, pe)])]), e[11] || (e[11] = t("div", null, "不合并:", -1)), t("div", ve, [t("img", { src: n(ne), class: "img-not-merge", style: { width: "100%" } }, null, 8, ce)])]), _: 1, __: [11] })])]), _: 1 }), o(i, null, { default: a(() => e[13] || (e[13] = [t("div", { class: "form-item-tip" }, "     合并：其它参数相同，品牌不同时，进行合并。 ", -1), t("div", { class: "form-item-tip" }, "     不合并：其它参数相同，品牌不同时，不进行合并。 ", -1)])), _: 1, __: [13] })]), _: 1 }, 8, ["disabled", "model"])), [[P, x.value]])])], 4)];
    }), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, ye = ee(fe, [["__scopeId", "data-v-fb83a70b"]]);
export {
  ye as default
};
