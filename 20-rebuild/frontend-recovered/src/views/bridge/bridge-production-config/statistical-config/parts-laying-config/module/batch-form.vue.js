import { ref as x } from "vue";
import { computed as q } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as y } from "vue";
import { createBlock as V } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { withDirectives as A } from "vue";
import { withModifiers as D } from "vue";
import { nextTick as H } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElForm as G } from "element-plus";
import { vLoading as K } from "element-plus";
import { a_ as j, o as W, b4 as J, av as X, aT as Y, aw as Z } from "../../../../../../shared/runtime.js";
import { u as ee } from "../../../../../../modules/use-table-operate-4f84437f.js";
import { _ as le } from "../../../../../../modules/bridge-cut-config-select-0a6713ab.js";
const te = { style: { float: "right" } }, ue = { __name: "batch-form", setup(ae) {
  const U = { specPrefix: [{ required: true, message: "请选择截面类型", trigger: "change" }], cutConfigId: [{ required: true, message: "请选择下料方式", trigger: "change" }], wageQuotaType: [{ required: true, message: "请选择计量方式", trigger: "change" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], numerical: [{ validator: (r, a) => !(!a.minNumerical || !a.maxNumerical || a.maxNumerical < a.minNumerical), message: "请填写数值并且最大数值不得小于最小数值", trigger: "blur" }] }, N = { list: [] }, T = { unitPrice: void 0 }, _ = /* @__PURE__ */ new Map([["specPrefix", -1], ["cutConfigId", "同上"], ["wageQuotaType", -1]]), h = x(), f = x(true), { CRUD: m, crud: i, form: s, ADD_FORM: k } = j(N, h), b = q(() => i.bStatus.cu > m.STATUS.NORMAL), { init: B, addRow: R, removeRow: S } = ee(T, 5, _), { tableValidate: P, cleanUpData: M, wrongCellMask: O } = Z({ rules: U, ditto: _ }), { maxHeight: E } = W({ mainBox: ".drill-hole-config-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, b);
  k.init = () => B(s.list);
  function z() {
    f.value = true, H(() => {
      f.value = false;
    });
  }
  return m.HOOK.beforeValidateBCU = () => {
    const { validResult: r, dealList: a } = P(s.list);
    if (r) s.list = a;
    else return r;
  }, i.submitBatchFormFormat = (r) => (M(r.list), r.list), (r, a) => {
    const p = c("common-button"), u = L, w = c("common-select"), g = c("common-input-number"), I = c("common-table"), F = G, Q = c("common-dialog"), $ = K;
    return y(), V(Q, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(i).cancelBCU, visible: b.value, title: `${e(i).props.factory ? e(i).props.factory.name + "：" : ""}${e(i).bStatus.title}`, "show-close": false, "custom-class": "drill-hole-config-batch-add", width: "1000px", onOpened: z, top: "10vh" }, { titleRight: n(() => [v("span", te, [t(p, { size: "default", type: "success", icon: "el-icon-plus", onClick: a[0] || (a[0] = (l) => e(R)(e(s).list)) }), t(p, { loading: e(i).bStatus.cu === e(m).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(i).submitBCU }, { default: n(() => a[1] || (a[1] = [C(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), t(J, { type: "crudBatch" }), t(p, { size: "default", onClick: e(i).cancelBCU }, { default: n(() => a[2] || (a[2] = [C("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: n(() => [t(F, { ref_key: "formRef", ref: h, model: e(s), disabled: e(i).bStatus.cu === e(m).STATUS.PROCESSING }, { default: n(() => [A((y(), V(I, { data: e(s).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": e(E), "cell-class-name": e(O), "row-key": "uid" }, { default: n(() => [t(u, { label: "序号", type: "index", align: "center", width: "60" }), t(u, { prop: "specPrefix", "show-overflow-tooltip": true, label: "截面类型", width: "160" }, { default: n(({ row: l, $index: o }) => [t(w, { modelValue: l.specPrefix, "onUpdate:modelValue": (d) => l.specPrefix = d, options: e(X).ENUM, clearable: "", "show-extra": o !== 0, type: "enum", placeholder: "截面类型", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), t(u, { prop: "cutConfigId", "show-overflow-tooltip": true, label: "下料方式", width: "160" }, { default: n(({ row: l, $index: o }) => [t(le, { placeholder: "下料方式", modelValue: l.cutConfigId, "onUpdate:modelValue": (d) => l.cutConfigId = d, clearable: "", "show-extra": o !== -1, style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 }), t(u, { prop: "numerical", "show-overflow-tooltip": true, label: "板厚范围", "min-width": "200", align: "center" }, { default: n(({ row: l }) => [t(g, { modelValue: l.minNumerical, "onUpdate:modelValue": (o) => l.minNumerical = o, step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), a[3] || (a[3] = v("span", null, " ~ ", -1)), t(g, { modelValue: l.maxNumerical, "onUpdate:modelValue": (o) => l.maxNumerical = o, step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(u, { prop: "wageQuotaType", "show-overflow-tooltip": true, label: "计量方式", width: "160" }, { default: n(({ row: l, $index: o }) => [t(w, { modelValue: l.wageQuotaType, "onUpdate:modelValue": (d) => l.wageQuotaType = d, options: e(Y).ENUM, clearable: "", "show-extra": o !== 0, type: "enum", placeholder: "计量方式", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), t(u, { "show-overflow-tooltip": true, prop: "unitPrice", label: "单价", align: "center", width: "100px" }, { default: n(({ row: l }) => [t(g, { modelValue: l.unitPrice, "onUpdate:modelValue": (o) => l.unitPrice = o, step: 1, min: 0, precision: 2, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(u, { label: "操作", width: "55", align: "center" }, { default: n(({ $index: l }) => [t(p, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: D((o) => e(S)(e(s).list, l), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[$, f.value]])]), _: 1 }, 8, ["model", "disabled"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  ue as default
};
