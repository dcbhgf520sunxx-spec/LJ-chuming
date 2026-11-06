import { ref as x } from "vue";
import { computed as $ } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as V } from "vue";
import { createBlock as v } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as a } from "vue";
import { unref as l } from "vue";
import { createTextVNode as k } from "vue";
import { withDirectives as L } from "vue";
import { withModifiers as q } from "vue";
import { nextTick as G } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElForm as K } from "element-plus";
import { vLoading as j } from "element-plus";
import { a_ as W, o as J, b4 as Q, av as X, aw as Y } from "../../../../../../shared/runtime.js";
import { u as Z } from "../../../../../../modules/use-table-operate-4f84437f.js";
const ee = { style: { float: "right" } }, se = { __name: "batch-form", setup(le) {
  const B = { specPrefix: [{ required: true, message: "请选择零件规格前缀", trigger: "change" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], numThickness: [{ validator: (s, e) => !(!e.minThickness || !e.maxThickness || e.maxThickness < e.minThickness), message: "请填写板厚并且最大板厚不得小于最小板厚", trigger: "blur" }], numBoreDiameter: [{ validator: (s, e) => !(!e.minBoreDiameter || !e.maxBoreDiameter || e.maxBoreDiameter < e.minBoreDiameter), message: "请填写孔径并且最大孔径不得小于最小孔径", trigger: "blur" }] }, y = { list: [] }, T = { unitPrice: void 0 }, b = /* @__PURE__ */ new Map([["specPrefix", -1]]), _ = x(), f = x(true), { CRUD: m, crud: i, form: r, ADD_FORM: w } = W(y, _), g = $(() => i.bStatus.cu > m.STATUS.NORMAL), { init: U, addRow: C, removeRow: D } = Z(T, 5, b), { tableValidate: R, cleanUpData: S, wrongCellMask: P } = Y({ rules: B, ditto: b }), { maxHeight: N } = J({ mainBox: ".drill-hole-config-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, g);
  w.init = () => U(r.list);
  function z() {
    f.value = true, G(() => {
      f.value = false;
    });
  }
  return m.HOOK.beforeValidateBCU = () => {
    const { validResult: s, dealList: e } = R(r.list);
    if (s) r.list = e;
    else return s;
  }, i.submitBatchFormFormat = (s) => (S(s.list), s.list), (s, e) => {
    const p = c("common-button"), d = I, O = c("common-select"), u = c("common-input-number"), M = c("common-table"), E = K, F = c("common-dialog"), A = j;
    return V(), v(F, { "append-to-body": "", "close-on-click-modal": false, "before-close": l(i).cancelBCU, visible: g.value, title: `${l(i).props.factory ? l(i).props.factory.name + "：" : ""}${l(i).bStatus.title}`, "show-close": false, "custom-class": "drill-hole-config-batch-add", width: "1000px", onOpened: z, top: "10vh" }, { titleRight: n(() => [h("span", ee, [a(p, { size: "default", type: "success", icon: "el-icon-plus", onClick: e[0] || (e[0] = (t) => l(C)(l(r).list)) }), a(p, { loading: l(i).bStatus.cu === l(m).STATUS.PROCESSING, type: "primary", size: "default", onClick: l(i).submitBCU }, { default: n(() => e[1] || (e[1] = [k(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), a(Q, { type: "crudBatch" }), a(p, { size: "default", onClick: l(i).cancelBCU }, { default: n(() => e[2] || (e[2] = [k("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: n(() => [a(E, { ref_key: "formRef", ref: _, model: l(r), disabled: l(i).bStatus.cu === l(m).STATUS.PROCESSING }, { default: n(() => [L((V(), v(M, { data: l(r).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": l(N), "cell-class-name": l(P), "row-key": "uid" }, { default: n(() => [a(d, { label: "序号", type: "index", align: "center", width: "60" }), a(d, { prop: "specPrefix", "show-overflow-tooltip": true, label: "零件规格前缀", width: "160" }, { default: n(({ row: t, $index: o }) => [a(O, { modelValue: t.specPrefix, "onUpdate:modelValue": (H) => t.specPrefix = H, options: l(X).ENUM, clearable: "", "show-extra": o !== 0, type: "enum", placeholder: "零件规格前缀", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), a(d, { prop: "numThickness", "show-overflow-tooltip": true, label: "板厚数值（毫米）", "min-width": "200", align: "center" }, { default: n(({ row: t }) => [a(u, { modelValue: t.minThickness, "onUpdate:modelValue": (o) => t.minThickness = o, step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小板厚(毫米)", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), e[3] || (e[3] = h("span", null, " ~ ", -1)), a(u, { modelValue: t.maxThickness, "onUpdate:modelValue": (o) => t.maxThickness = o, step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大板厚(毫米)", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(d, { prop: "numBoreDiameter", "show-overflow-tooltip": true, label: "孔径数值范围（毫米）", "min-width": "200", align: "center" }, { default: n(({ row: t }) => [a(u, { modelValue: t.minBoreDiameter, "onUpdate:modelValue": (o) => t.minBoreDiameter = o, step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小孔径(毫米)", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), e[4] || (e[4] = h("span", null, " ~ ", -1)), a(u, { modelValue: t.maxBoreDiameter, "onUpdate:modelValue": (o) => t.maxBoreDiameter = o, step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大孔径(毫米)", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(d, { "show-overflow-tooltip": true, prop: "unitPrice", label: "单价（元/个）", align: "center", width: "100px" }, { default: n(({ row: t }) => [a(u, { modelValue: t.unitPrice, "onUpdate:modelValue": (o) => t.unitPrice = o, step: 1, min: 0, precision: 2, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(d, { label: "操作", width: "55", align: "center" }, { default: n(({ $index: t }) => [a(p, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: q((o) => l(D)(l(r).list, t), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[A, f.value]])]), _: 1 }, 8, ["model", "disabled"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  se as default
};
