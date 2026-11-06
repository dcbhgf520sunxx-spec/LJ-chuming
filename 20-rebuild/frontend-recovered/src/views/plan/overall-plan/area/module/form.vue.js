import { ref as C } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as c } from "vue";
import { createBlock as b } from "vue";
import { withCtx as n } from "vue";
import { createVNode as r } from "vue";
import { unref as t } from "vue";
import { createTextVNode as x } from "vue";
import { ElRadioGroup as O } from "element-plus";
import { createElementBlock as M } from "vue";
import { Fragment as q } from "vue";
import { renderList as R } from "vue";
import { toDisplayString as j } from "vue";
import { ElFormItem as F } from "element-plus";
import { ElRadioButton as z } from "element-plus";
import { ElInput as B } from "element-plus";
import { ElDatePicker as N } from "element-plus";
import { ElInputNumber as P } from "element-plus";
import { ElForm as S } from "element-plus";
import { _ as A, mw as V, ao as H } from "../../../../../shared/runtime.js";
const K = { __name: "form", props: { projectId: { type: [Number, String], default: void 0 }, typeInfo: { type: Array, default: () => [] }, globalProject: { type: Object, default: () => {
} }, currentMonomer: { type: Object, default: () => {
} } }, setup(y) {
  const g = C(), u = y, T = { key: "no", label: "name", value: "no" }, I = { id: void 0, monomerId: void 0, name: "", axis: "", type: V.HOMEMADE.V, productType: void 0, date: void 0, sort: 1, remark: "" }, { CRUD: _, crud: m, form: a } = H(I, g), k = { productType: [{ required: true, message: "请选择产品类型", trigger: "change" }], type: [{ required: true, message: "请选择制造方式", trigger: "change" }], date: [{ required: true, validator: (l, e, s) => {
    if (!e) s(new Error("请选择完成时间"));
    else if (m.form.productType && u.typeInfo && u.typeInfo.length > 0) {
      const p = u.typeInfo.find((d) => d.no === m.form.productType);
      e > p.date ? s(new Error("不能超过产品类型完成时间")) : s();
    }
  }, trigger: "change" }], sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }], name: [{ required: true, message: "请填写区域名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], axis: [{ required: true, message: "请填写轴线或标高", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "blur" }] };
  function w(l) {
    if (m.form.productType && u.typeInfo && u.typeInfo.length > 0) {
      const e = u.typeInfo.find((s) => s.no === m.form.productType);
      return l.getTime() - 864e4 > e.date || (u.currentMonomer.startDate ? l.getTime() < u.currentMonomer.startDate : l.getTime() < u.globalProject.startDate);
    } else return l.getTime() < (u.currentMonomer.startDate ? l.getTime() < u.currentMonomer.startDate : l.getTime() < u.globalProject.startDate);
  }
  return _.HOOK.afterToAdd = (l, e) => {
    l.form.productType = l.query.productType;
  }, _.HOOK.beforeSubmit = (l, e) => (l.form.monomerId = l.query.monomerId, !!l.form.monomerId), (l, e) => {
    const s = f("common-button"), p = f("common-radio-button"), d = F, E = z, i = B, D = N, v = P, U = S, h = f("common-drawer");
    return c(), b(h, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(m).cancelCU, visible: t(m).status.cu > 0, title: t(m).status.title, "wrapper-closable": false, size: "700px" }, { titleRight: n(() => [r(s, { loading: t(m).status.cu === 2, type: "primary", size: "default", onClick: t(m).submitCU }, { default: n(() => e[7] || (e[7] = [x("确认")])), _: 1, __: [7] }, 8, ["loading", "onClick"])]), content: n(() => [r(U, { ref_key: "formRef", ref: g, model: t(a), rules: k, size: "default", "label-width": "120px" }, { default: n(() => [r(d, { label: "产品类型", prop: "productType" }, { default: n(() => [r(p, { modelValue: t(a).productType, "onUpdate:modelValue": e[0] || (e[0] = (o) => t(a).productType = o), options: y.typeInfo, type: "other", dataStructure: T, class: "filter-item" }, null, 8, ["modelValue", "options"])]), _: 1 }), r(d, { label: "制造方式", prop: "type" }, { default: n(() => [r(t(O), { modelValue: t(a).type, "onUpdate:modelValue": e[1] || (e[1] = (o) => t(a).type = o), size: "default", class: "filter-item", onChange: t(m).toQuery }, { default: n(() => [(c(true), M(q, null, R(t(V).ENUM, (o) => (c(), b(E, { key: o.V, value: o.V }, { default: n(() => [x(j(o.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue", "onChange"])]), _: 1 }), r(d, { label: "区域名称", prop: "name" }, { default: n(() => [r(i, { modelValue: t(a).name, "onUpdate:modelValue": e[2] || (e[2] = (o) => t(a).name = o), type: "text", placeholder: "请填写区域名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), r(d, { label: "轴线/标高", prop: "axis" }, { default: n(() => [r(i, { modelValue: t(a).axis, "onUpdate:modelValue": e[3] || (e[3] = (o) => t(a).axis = o), type: "text", placeholder: "请填写轴线或标高", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), r(d, { label: "完成时间", prop: "date" }, { default: n(() => [r(D, { modelValue: t(a).date, "onUpdate:modelValue": e[4] || (e[4] = (o) => t(a).date = o), type: "date", "value-format": "x", placeholder: "选择完成日期", style: { width: "270px" }, disabledDate: w }, null, 8, ["modelValue"])]), _: 1 }), r(d, { label: "排序", prop: "sort" }, { default: n(() => [r(v, { modelValue: t(a).sort, "onUpdate:modelValue": e[5] || (e[5] = (o) => t(a).sort = o), modelModifiers: { number: true }, min: 1, max: 999, step: 1, placeholder: "请填写排序值", "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), r(d, { label: "备注", prop: "remark" }, { default: n(() => [r(i, { modelValue: t(a).remark, "onUpdate:modelValue": e[6] || (e[6] = (o) => t(a).remark = o), type: "textarea", autosize: { minRows: 4, maxRows: 6 }, placeholder: "请填写备注", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, J = A(K, [["__scopeId", "data-v-8e2f79ca"]]);
export {
  J as default
};
