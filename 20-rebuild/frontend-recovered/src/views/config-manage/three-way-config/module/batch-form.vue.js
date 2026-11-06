import { ref as U } from "vue";
import { reactive as D } from "vue";
import { computed as I } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as w } from "vue";
import { createBlock as x } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as V } from "vue";
import { withDirectives as P } from "vue";
import { withModifiers as z } from "vue";
import { nextTick as G } from "vue";
import { ElTableColumn as K } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElForm as j } from "element-plus";
import { vLoading as Y } from "element-plus";
import { a_ as J, o as Q, dY as W, cB as X, aw as Z } from "../../../../shared/runtime.js";
import { u as ee } from "../../../../modules/use-table-operate-4f84437f.js";
const te = { style: { float: "right" } }, se = { __name: "batch-form", props: { modelValue: { type: Boolean, require: true } }, setup(oe) {
  const p = U(true), v = D({ list: [] }), T = { name: void 0, hookUrl: void 0, status: void 0 }, C = { name: [{ required: true, max: 50, message: "请填写名称不超过50个字符", trigger: "blur" }], hookUrl: [{ required: true, max: 50, message: "请填写URL路径不超过50个字符", trigger: "blur" }], status: [{ required: true, message: "请选择状态", trigger: "change" }], notificationType: [{ required: true, message: "请选择业务流程类型", trigger: "change" }] }, f = /* @__PURE__ */ new Map([["status", -1]]), _ = U(), { CRUD: c, crud: s, form: i } = J(v, _), g = I(() => s.bStatus.cu > c.STATUS.NORMAL), { init: b, addRow: B, removeRow: R } = ee(T, 5, f), { tableValidate: S, cleanUpData: E, wrongCellMask: M } = Z({ rules: C, ditto: f }), { maxHeight: O } = Q({ mainBox: ".rivet-weld-config-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, g);
  c.HOOK.afterToAdd = () => {
    b(i.list);
  };
  function L() {
    b(i.list), p.value = true, G(() => {
      p.value = false;
    });
  }
  return c.HOOK.beforeValidateBCU = () => {
    const { validResult: u, dealList: n } = S(i.list);
    if (u) i.list = n;
    else return u;
  }, s.submitBatchFormFormat = async (u) => {
    var d;
    return E(u.list), (d = u.list) == null ? void 0 : d.map((l) => ({ name: l.name, hookUrl: l.hookUrl, status: l.status, notificationType: l.notificationType }));
  }, (u, n) => {
    const d = m("common-button"), l = K, h = $, y = m("common-select"), N = m("common-table"), q = j, H = m("common-drawer"), A = Y;
    return w(), x(H, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(s).cancelBCU, visible: g.value, title: e(s).bStatus.title, "show-close": false, "custom-class": "three-way-config-batch-form", size: "60%", onOpened: L }, { titleRight: a(() => [k("span", te, [t(d, { type: "success", icon: "el-icon-plus", onClick: n[0] || (n[0] = (o) => e(B)(e(i).list)) }), t(d, { loading: e(s).bStatus.cu === e(c).STATUS.PROCESSING, type: "primary", onClick: e(s).submitBCU }, { default: a(() => n[1] || (n[1] = [V(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), t(d, { style: { "margin-left": "8px" }, onClick: e(s).cancelBCU }, { default: a(() => n[2] || (n[2] = [V(" 关 闭 ")])), _: 1, __: [2] }, 8, ["onClick"])])]), content: a(() => [k("div", null, [t(q, { ref_key: "formRef", ref: _, model: e(i), disabled: e(s).bStatus.cu === e(c).STATUS.PROCESSING }, { default: a(() => [P((w(), x(N, { data: e(i).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": e(O) - 20, "cell-class-name": e(M), "row-key": "uid" }, { default: a(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", align: "center" }, { default: a(({ row: o }) => [t(h, { modelValue: o.name, "onUpdate:modelValue": (r) => o.name = r, modelModifiers: { trim: true }, type: "text", clearable: "", placeholder: "名称", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(l, { key: "hookUrl", prop: "hookUrl", "show-overflow-tooltip": true, label: "URL路径", align: "center" }, { default: a(({ row: o }) => [t(h, { modelValue: o.hookUrl, "onUpdate:modelValue": (r) => o.hookUrl = r, modelModifiers: { trim: true }, type: "text", clearable: "", placeholder: "URL路径", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(l, { key: "notificationType", prop: "notificationType", "show-overflow-tooltip": true, label: "业务流程", align: "center" }, { default: a(({ row: o }) => [t(y, { modelValue: o.notificationType, "onUpdate:modelValue": (r) => o.notificationType = r, options: e(W).ENUM, type: "enum", clearable: "", multiple: "", "collapse-tags": "", "max-collapse-tags": 1, placeholder: "业务流程", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), t(l, { key: "status", prop: "status", "show-overflow-tooltip": true, label: "状态", align: "center", width: "140px" }, { default: a(({ row: o, $index: r }) => [t(y, { modelValue: o.status, "onUpdate:modelValue": (F) => o.status = F, options: e(X).ENUM, type: "enum", size: "default", clearable: "", "show-extra": r !== 0, class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), t(l, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: a(({ $index: o }) => [t(d, { type: "danger", icon: "el-icon-delete", style: { padding: "6px" }, onClick: z((r) => e(R)(e(i).list, o), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[A, p.value]])]), _: 1 }, 8, ["model", "disabled"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  se as default
};
