import { ref as z } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as p } from "vue";
import { createBlock as E } from "vue";
import { withCtx as l } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { createTextVNode as U } from "vue";
import { createElementVNode as g } from "vue";
import { createElementBlock as b } from "vue";
import { Fragment as F } from "vue";
import { renderList as B } from "vue";
import { withDirectives as N } from "vue";
import { vShow as q } from "vue";
import { ElInput as P } from "element-plus";
import { ElFormItem as R } from "element-plus";
import { ElInputNumber as S } from "element-plus";
import { ElForm as D } from "element-plus";
import { _ as M, g8 as T, ao as j, g7 as $ } from "../../../../../shared/runtime.js";
const A = { class: "process-container" }, G = { class: "process-box" }, H = { __name: "form", setup(J) {
  const _ = z(), x = T(["reimbursement_type"]), v = { key: "id", label: "label", value: "id" }, V = { iid: void 0, name: "", sort: 1, dictionaryIdList: [] }, { crud: n, form: t } = j(V, _), h = { name: [{ required: true, message: "请填写费用类型名称", trigger: "blur" }, { min: 1, max: 30, message: "长度在 1 到 30 个字符", trigger: "blur" }], sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }], dictionaryIdList: [{ validator: (c, o, a) => {
    if (o && o.length) for (const m in o) o[m] || a(new Error("请选择费用类型"));
    a();
  }, trigger: "change" }], category: [{ required: true, message: "请输入类别", trigger: "change" }] };
  function I() {
    t.dictionaryIdList.push(void 0);
  }
  function L(c) {
    t.dictionaryIdList.splice(c, 1);
  }
  return (c, o) => {
    const a = u("common-button"), m = P, i = R, f = u("common-select"), k = S, w = D, C = u("common-drawer");
    return p(), E(C, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, "wrapper-closable": false, size: "860px" }, { titleRight: l(() => [s(a, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: l(() => o[3] || (o[3] = [U("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), content: l(() => [s(w, { ref_key: "formRef", ref: _, model: e(t), rules: h, size: "default", "label-width": "140px" }, { default: l(() => [s(i, { label: "类型名称", prop: "name" }, { default: l(() => [s(m, { modelValue: e(t).name, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(t).name = r), type: "text", placeholder: "请填写费用类型名称", style: { width: "270px" }, maxlength: "30" }, null, 8, ["modelValue"])]), _: 1 }), s(i, { label: "类别", prop: "category" }, { default: l(() => [s(f, { modelValue: e(t).category, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(t).category = r), options: e($).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "类别", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), s(i, { label: "排序", prop: "sort" }, { default: l(() => [s(k, { modelValue: e(t).sort, "onUpdate:modelValue": o[2] || (o[2] = (r) => e(t).sort = r), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), s(i, { label: "费用明细", prop: "dictionaryIdList" }, { default: l(() => [g("div", A, [g("div", G, [(p(true), b(F, null, B(e(t).dictionaryIdList, (r, d) => (p(), b("div", { key: d, class: "process-drawer" }, [s(f, { modelValue: e(t).dictionaryIdList[d], "onUpdate:modelValue": (y) => e(t).dictionaryIdList[d] = y, options: e(x).reimbursement_type, type: "other", size: "default", dataStructure: v, clearable: "", class: "filter-item", placeholder: "费用类型", style: { width: "250px" }, "disabled-val": e(t).dictionaryIdList }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled-val"]), N(s(a, { icon: "el-icon-delete", size: "default", type: "danger", style: { "margin-left": "6px" }, onClick: (y) => L(d) }, null, 8, ["onClick"]), [[q, e(t).dictionaryIdList && e(t).dictionaryIdList.length > 1]])]))), 128))]), s(a, { icon: "el-icon-plus", size: "default", type: "success", style: { margin: "0 0 12px 6px" }, onClick: I })])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, W = M(H, [["__scopeId", "data-v-a0fdc969"]]);
export {
  W as default
};
