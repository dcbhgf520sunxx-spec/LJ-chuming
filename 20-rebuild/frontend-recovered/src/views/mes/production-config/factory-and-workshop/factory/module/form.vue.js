import { ref as c } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as v } from "vue";
import { createBlock as I } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as U } from "vue";
import { ElFormItem as F } from "element-plus";
import { ElInput as N } from "element-plus";
import { ElColorPicker as R } from "element-plus";
import { ElInputNumber as E } from "element-plus";
import { ElForm as z } from "element-plus";
import { g as B } from "../../../../../../modules/factory-7a1d88b2.js";
import { _ as O, ao as q, b8 as M } from "../../../../../../shared/runtime.js";
const L = { __name: "form", setup(T) {
  const i = c(), p = c([]), f = { id: void 0, branchCompanyId: void 0, name: "", shortName: "", sort: 1, remark: "", tagColor: M }, { crud: n, form: l, CRUD: _ } = q(f, i), b = ["#ff4500", "#ff8c00", "#ffd700", "#90ee90", "#00ced1", "#1e90ff", "#c71585", "rgba(255, 69, 0, 0.68)", "rgb(255, 120, 0)", "hsv(51, 100, 98)", "hsva(120, 40, 94, 0.5)", "hsl(181, 100%, 37%)", "hsla(209, 100%, 56%, 0.73)", "#c7158577"], g = { sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }], branchCompanyId: [{ required: true, message: "请选择分支机构", trigger: "change" }], name: [{ required: true, message: "请填写工厂名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], shortName: [{ required: true, message: "请填写工厂简称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "blur" }] };
  _.HOOK.beforeSubmit = async () => {
  };
  async function y() {
    try {
      const { content: m } = await B();
      p.value = m;
    } catch (m) {
      console.log(m);
    }
  }
  return y(), (m, o) => {
    const h = u("common-button"), x = u("common-select"), s = F, d = N, C = R, V = E, k = z, w = u("common-dialog");
    return v(), I(w, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "500px" }, { titleRight: a(() => [t(h, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: a(() => o[6] || (o[6] = [U("确认")])), _: 1, __: [6] }, 8, ["loading", "onClick"])]), default: a(() => [t(k, { ref_key: "formRef", ref: i, model: e(l), rules: g, size: "default", "label-width": "90px" }, { default: a(() => [t(s, { label: "分支机构", prop: "branchCompanyId" }, { default: a(() => [t(x, { modelValue: e(l).branchCompanyId, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(l).branchCompanyId = r), options: p.value, "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", placeholder: "请选择分支机构", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(s, { label: "工厂名称", prop: "name" }, { default: a(() => [t(d, { modelValue: e(l).name, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(l).name = r), modelModifiers: { trim: true }, type: "text", placeholder: "请填写名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(s, { label: "工厂简称", prop: "shortName" }, { default: a(() => [t(d, { modelValue: e(l).shortName, "onUpdate:modelValue": o[2] || (o[2] = (r) => e(l).shortName = r), modelModifiers: { trim: true }, type: "text", placeholder: "请填写简称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(s, { label: "标签颜色", prop: "tagColor" }, { default: a(() => [t(C, { modelValue: e(l).tagColor, "onUpdate:modelValue": o[3] || (o[3] = (r) => e(l).tagColor = r), "show-alpha": "", predefine: b }, null, 8, ["modelValue"])]), _: 1 }), t(s, { label: "排序", prop: "sort" }, { default: a(() => [t(V, { modelValue: e(l).sort, "onUpdate:modelValue": o[4] || (o[4] = (r) => e(l).sort = r), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(s, { label: "备注", prop: "remark" }, { default: a(() => [t(d, { modelValue: e(l).remark, "onUpdate:modelValue": o[5] || (o[5] = (r) => e(l).remark = r), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 4, maxRows: 6 }, placeholder: "请填写备注", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, H = O(L, [["__scopeId", "data-v-7c31b053"]]);
export {
  H as default
};
