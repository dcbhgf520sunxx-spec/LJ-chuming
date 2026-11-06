import { ref as h } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as q } from "vue";
import { createBlock as I } from "vue";
import { withCtx as l } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { createTextVNode as v } from "vue";
import { ElInput as C } from "element-plus";
import { ElFormItem as D } from "element-plus";
import { ElDatePicker as U } from "element-plus";
import { ElInputNumber as E } from "element-plus";
import { ElForm as F } from "element-plus";
import { _ as O, ao as R } from "../../../../../../../shared/runtime.js";
const z = { __name: "form", props: { detailInfo: { type: Object, default: () => {
} } }, setup(c) {
  const i = c, u = h(), _ = { id: void 0, monomerId: void 0, name: "", quantityWork: void 0, date: void 0, remark: "" }, { CRUD: g, crud: m, form: a } = R(_, u), b = { date: [{ required: true, validator: (o, t, d) => {
    t || d(new Error("请选择交货时间")), d();
  }, trigger: "change" }], quantityWork: [{ required: true, message: "请填写工程量", trigger: "change", type: "number" }], name: [{ required: true, message: "请填写批次命名", trigger: "blur" }, { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }], remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "blur" }] };
  function y(o) {
    return o.getTime() < i.detailInfo.startDate || o.getTime() > i.detailInfo.endDate;
  }
  return g.HOOK.beforeSubmit = (o, t) => (o.form.projectId = o.query.projectId, o.form.category = o.query.category, !!o.form.category), (o, t) => {
    const d = f("common-button"), p = C, s = D, x = U, k = E, w = F, V = f("common-drawer");
    return q(), I(V, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(m).cancelCU, visible: e(m).status.cu > 0, title: e(m).status.title, "wrapper-closable": false, size: "700px" }, { titleRight: l(() => [r(d, { loading: e(m).status.cu === 2, type: "primary", size: "default", onClick: e(m).submitCU }, { default: l(() => t[4] || (t[4] = [v("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), content: l(() => [r(w, { ref_key: "formRef", ref: u, model: e(a), rules: b, size: "default", "label-width": "120px" }, { default: l(() => [r(s, { label: "批次命名", prop: "name" }, { default: l(() => [r(p, { modelValue: e(a).name, "onUpdate:modelValue": t[0] || (t[0] = (n) => e(a).name = n), modelModifiers: { trim: true }, type: "text", placeholder: "请填写", style: { width: "270px" }, maxlength: "20" }, null, 8, ["modelValue"])]), _: 1 }), r(s, { label: "交货时间", prop: "date" }, { default: l(() => [r(x, { modelValue: e(a).date, "onUpdate:modelValue": t[1] || (t[1] = (n) => e(a).date = n), type: "date", "value-format": "x", placeholder: "选择交货时间", style: { width: "270px" }, disabledDate: y }, null, 8, ["modelValue"])]), _: 1 }), r(s, { label: "工程量", prop: "quantityWork" }, { default: l(() => [r(k, { modelValue: e(a).quantityWork, "onUpdate:modelValue": t[2] || (t[2] = (n) => e(a).quantityWork = n), modelModifiers: { number: true }, min: 0, max: 99999999, step: 1, placeholder: "请填写", "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), r(s, { label: "备注", prop: "remark" }, { default: l(() => [r(p, { modelValue: e(a).remark, "onUpdate:modelValue": t[3] || (t[3] = (n) => e(a).remark = n), modelModifiers: { trim: true }, type: "textarea", "show-word-limit": "", autosize: { minRows: 4, maxRows: 6 }, maxlength: "200", placeholder: "请填写备注", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, M = O(z, [["__scopeId", "data-v-73fc5399"]]);
export {
  M as default
};
