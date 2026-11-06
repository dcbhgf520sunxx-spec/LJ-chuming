import { inject as y } from "vue";
import { ref as x } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as g } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as M } from "vue";
import { createElementVNode as q } from "vue";
import { ElInput as $ } from "element-plus";
import { ElFormItem as K } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElForm as D } from "element-plus";
import { _ as G, o as L, ao as P, G as Z, d8 as J, d9 as Q, a as S, aw as X } from "../../../../../shared/runtime.js";
import { u as Y } from "../../../../../modules/use-table-operate-4f84437f.js";
const ee = { class: "spec-main-content" }, oe = { __name: "form", setup(te) {
  const b = y("currentNode"), V = y("permission"), U = { name: void 0, classificationId: void 0, boolWeightedAverage: void 0, list: [] }, k = { code: void 0, value: void 0, sort: void 0 }, C = { name: [{ required: true, message: "请输入规格名称", trigger: "blur" }], boolWeightedAverage: [{ required: true, message: "请选择是否参加加权平均", trigger: "change" }] }, w = { code: [{ required: true, message: "请输入编码", trigger: "blur" }], value: [{ required: true, message: "请输入规格", trigger: "blur" }] }, v = x(), m = x(), { maxHeight: R } = L({ extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body", ".spec-main-content"], navbar: false, extraHeight: 120, minHeight: 300 }, () => v.value.loaded), { CRUD: c, crud: d, form: l } = P(U, m), { init: A, addRow: z, removeRow: F } = Y(k, 10);
  c.HOOK.beforeToAdd = () => {
    l.name = b.value.name;
  }, c.HOOK.afterToAdd = () => {
    A(l.list);
  };
  const { tableValidate: B, cleanUpData: H, wrongCellMask: O } = X({ rules: w });
  c.HOOK.beforeValidateCU = () => {
    const { validResult: r, dealList: a } = B(l.list);
    if (r) l.list = a;
    else return r;
  }, d.submitFormFormat = (r) => (r.classificationId = b.value.id, H(r.list), r);
  function W(r) {
    m.value.validateField(r);
  }
  return (r, a) => {
    const f = u("common-button"), p = $, h = K, E = u("common-radio"), s = j, N = u("common-table"), T = D, I = u("common-drawer");
    return _(), g(I, { ref_key: "drawerRef", ref: v, "before-close": e(d).cancelCU, "show-close": true, size: 1e3, title: e(d).status.title, visible: e(d).status.cu > 0 }, { titleRight: n(() => [t(f, { size: "default", type: "success", icon: "el-icon-plus", onClick: a[0] || (a[0] = (o) => e(z)(e(l).list)) }), t(f, { loading: e(d).status.cu === 2, size: "default", type: "primary", onClick: e(d).submitCU }, { default: n(() => a[4] || (a[4] = [M("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), content: n(() => [q("div", ee, [t(T, { ref_key: "formRef", ref: m, model: e(l), rules: C, size: "default", "label-width": "80px" }, { default: n(() => [t(h, { label: "规格名称", prop: "name" }, { default: n(() => [t(p, { modelValue: e(l).name, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(l).name = o), class: "input-underline", maxlength: "10", placeholder: "请填写规格名称", size: "default", style: { width: "350px" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 }), t(h, { label: "加权平均", prop: "boolWeightedAverage" }, { default: n(() => [t(E, { modelValue: e(l).boolWeightedAverage, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(l).boolWeightedAverage = o), disabled: !e(Z)(e(V).weightedAverage), options: e(J).ENUM, type: "enum", onChange: a[3] || (a[3] = (o) => W("boolWeightedAverage")) }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), t(N, { "cell-class-name": (o) => e(O)(o, w), data: e(l).list, "max-height": e(R), "show-empty-symbol": false, border: "", "return-source-data": "", "row-key": "uid" }, { default: n(() => [t(s, { align: "center", label: "序号", type: "index", width: "60" }), t(s, { align: "center", label: "编码", prop: "code", width: "100" }, { default: n((o) => [t(p, { modelValue: o.row.code, "onUpdate:modelValue": (i) => o.row.code = i, modelModifiers: { trim: true }, readonly: o.row.boolUsed, class: "input-underline", maxlength: "3", placeholder: "编码", size: "default", style: { width: "100%" }, type: "text", onBlur: () => {
      o.row.code = e(Q)(o.row.code, 3);
    } }, null, 8, ["modelValue", "onUpdate:modelValue", "readonly", "onBlur"])]), _: 1 }), t(s, { align: "center", label: "规格", "min-width": "180", prop: "value" }, { default: n((o) => [t(p, { modelValue: o.row.value, "onUpdate:modelValue": (i) => o.row.value = i, modelModifiers: { trim: true }, readonly: o.row.boolUsed, class: "input-underline", maxlength: "64", placeholder: "规格", size: "default", style: { width: "100%" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue", "readonly"])]), _: 1 }), t(s, { align: "center", label: "操作", width: "80" }, { default: n((o) => [o.row.boolUsed ? (_(), g(S, { key: 1, class: "icon icon-readonly", "icon-class": "readonly" })) : (_(), g(f, { key: 0, icon: "el-icon-minus", type: "danger", style: { padding: "5px" }, size: "default", onClick: (i) => e(F)(e(l).list, o.$index) }, null, 8, ["onClick"]))]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, re = G(oe, [["__scopeId", "data-v-a2faffbf"]]);
export {
  re as default
};
