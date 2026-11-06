import { ref as _ } from "vue";
import { computed as A } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as y } from "vue";
import { createBlock as V } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { withDirectives as H } from "vue";
import { withModifiers as L } from "vue";
import { nextTick as G } from "vue";
import { ElTableColumn as K } from "element-plus";
import { ElForm as j } from "element-plus";
import { vLoading as W } from "element-plus";
import { t as J, a_ as X, o as Y, av as Z, b4 as ee, aT as le, aw as te } from "../../../../../../shared/runtime.js";
import { u as ae } from "../../../../../../modules/use-table-operate-4f84437f.js";
import { _ as oe } from "../../../../../../modules/cut-config-select-6e1b2706.js";
const ie = { style: { float: "right" } }, me = { __name: "batch-form", setup(ne) {
  const { decimalPrecision: U } = J(), T = { specPrefix: [{ required: true, message: "请选择截面类型", trigger: "change" }], cutConfigId: [{ required: true, message: "请选择下料方式", trigger: "change" }], wageQuotaType: [{ required: true, message: "请选择计量方式", trigger: "change" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], numerical: [{ validator: (r, a) => !(!a.minNumerical || !a.maxNumerical || a.maxNumerical < a.minNumerical), message: "请填写数值并且最大数值不得小于最小数值", trigger: "blur" }] }, N = { list: [] }, P = { unitPrice: void 0 }, h = /* @__PURE__ */ new Map([["specPrefix", -1], ["cutConfigId", "同上"], ["wageQuotaType", -1]]), b = _(), f = _(true), { CRUD: m, crud: n, form: s, ADD_FORM: k } = X(N, b), w = A(() => n.bStatus.cu > m.STATUS.NORMAL), { init: B, addRow: R, removeRow: S } = ae(P, 5, h), { tableValidate: O, cleanUpData: M, wrongCellMask: z } = te({ rules: T, ditto: h }), { maxHeight: E } = Y({ mainBox: ".drill-hole-config-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, w), I = _([Z.PL]);
  k.init = () => B(s.list);
  function D() {
    f.value = true, G(() => {
      f.value = false;
    });
  }
  return m.HOOK.beforeValidateBCU = () => {
    const { validResult: r, dealList: a } = O(s.list);
    if (r) s.list = a;
    else return r;
  }, n.submitBatchFormFormat = (r) => (M(r.list), r.list), (r, a) => {
    const p = d("common-button"), u = K, x = d("common-select"), g = d("common-input-number"), F = d("common-table"), Q = j, $ = d("common-dialog"), q = W;
    return y(), V($, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelBCU, visible: w.value, title: `${e(n).props.factory ? e(n).props.factory.name + "：" : ""}${e(n).bStatus.title}`, "show-close": false, "custom-class": "drill-hole-config-batch-add", width: "1000px", onOpened: D, top: "10vh" }, { titleRight: i(() => [v("span", ie, [t(p, { size: "default", type: "success", icon: "el-icon-plus", onClick: a[0] || (a[0] = (l) => e(R)(e(s).list)) }), t(p, { loading: e(n).bStatus.cu === e(m).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(n).submitBCU }, { default: i(() => a[1] || (a[1] = [C(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), t(ee, { type: "crudBatch" }), t(p, { size: "default", onClick: e(n).cancelBCU }, { default: i(() => a[2] || (a[2] = [C("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: i(() => [t(Q, { ref_key: "formRef", ref: b, model: e(s), disabled: e(n).bStatus.cu === e(m).STATUS.PROCESSING }, { default: i(() => [H((y(), V(F, { data: e(s).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": e(E), "cell-class-name": e(z), "row-key": "uid" }, { default: i(() => [t(u, { label: "序号", type: "index", align: "center", width: "60" }), t(u, { prop: "specPrefix", "show-overflow-tooltip": true, label: "截面类型", width: "160" }, { default: i(({ row: l, $index: o }) => [t(x, { modelValue: l.specPrefix, "onUpdate:modelValue": (c) => l.specPrefix = c, options: I.value, clearable: "", "show-extra": o !== 0, type: "enum", placeholder: "截面类型", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), t(u, { prop: "cutConfigId", "show-overflow-tooltip": true, label: "下料方式", width: "160" }, { default: i(({ row: l, $index: o }) => [t(oe, { placeholder: "下料方式", modelValue: l.cutConfigId, "onUpdate:modelValue": (c) => l.cutConfigId = c, clearable: "", "show-extra": o !== -1, style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 }), t(u, { prop: "numerical", "show-overflow-tooltip": true, label: "板厚范围", "min-width": "200", align: "center" }, { default: i(({ row: l }) => [t(g, { modelValue: l.minNumerical, "onUpdate:modelValue": (o) => l.minNumerical = o, step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), a[3] || (a[3] = v("span", null, " ~ ", -1)), t(g, { modelValue: l.maxNumerical, "onUpdate:modelValue": (o) => l.maxNumerical = o, step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(u, { prop: "wageQuotaType", "show-overflow-tooltip": true, label: "计量方式", width: "160" }, { default: i(({ row: l, $index: o }) => [t(x, { modelValue: l.wageQuotaType, "onUpdate:modelValue": (c) => l.wageQuotaType = c, options: e(le).ENUM, clearable: "", "show-extra": o !== 0, type: "enum", placeholder: "计量方式", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), t(u, { "show-overflow-tooltip": true, prop: "unitPrice", label: "单价", align: "center", width: "100px" }, { default: i(({ row: l }) => [t(g, { modelValue: l.unitPrice, "onUpdate:modelValue": (o) => l.unitPrice = o, step: 1, min: 0, precision: e(U).mes, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), t(u, { label: "操作", width: "55", align: "center" }, { default: i(({ $index: l }) => [t(p, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: L((o) => e(S)(e(s).list, l), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[q, f.value]])]), _: 1 }, 8, ["model", "disabled"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  me as default
};
