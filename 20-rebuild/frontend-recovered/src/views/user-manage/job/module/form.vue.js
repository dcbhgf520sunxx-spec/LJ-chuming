import { ref as m } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as R } from "vue";
import { createBlock as h } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { ElInput as F } from "element-plus";
import { ElFormItem as M } from "element-plus";
import { ElInputNumber as S } from "element-plus";
import { ElPopover as T } from "element-plus";
import { ElForm as B } from "element-plus";
import { d as P } from "../../../../modules/dept-398bb184.js";
import { _ as q, cB as _, ao as z } from "../../../../shared/runtime.js";
import { m as D } from "../../../../modules/tree-select-86c0f12c.js";
const j = { __name: "form", setup(A) {
  const p = m(), b = m(), g = m(), u = m(false), c = m([]), y = { id: void 0, name: "", sort: 1, enabled: _.TRUE.V, deptId: void 0, deptName: void 0 }, { crud: a, form: o } = z(y, p), v = { name: [{ required: true, message: "请填写名称", trigger: "blur" }], sort: [{ required: true, message: "请填写序号", trigger: "blur", type: "number" }], deptId: { required: true, message: "所属部门不能为空", trigger: "change" } };
  V();
  async function V() {
    try {
      c.value = await P({ hasRoot: true });
    } catch (d) {
      console.log("部门tree", d);
    }
  }
  function x(d) {
    o.deptId = d.id, o.deptName = d.name, u.value = false;
  }
  return (d, t) => {
    const k = i("common-button"), f = F, s = M, w = S, E = i("common-radio"), I = T, U = B, N = i("common-dialog");
    return R(), h(N, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: e(a).status.cu > 0, title: e(a).status.title, width: "600px" }, { titleRight: n(() => [l(k, { loading: e(a).status.cu === 2, type: "primary", size: "default", onClick: e(a).submitCU }, { default: n(() => t[5] || (t[5] = [C("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: n(() => [l(U, { ref_key: "formRef", ref: p, model: e(o), rules: v, size: "default", "label-width": "80px", inline: true }, { default: n(() => [l(s, { label: "名称", prop: "name" }, { default: n(() => [l(f, { modelValue: e(o).name, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(o).name = r), modelModifiers: { trim: true }, style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 }), l(s, { label: "排序", prop: "sort" }, { default: n(() => [l(w, { modelValue: e(o).sort, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(o).sort = r), modelModifiers: { number: true }, min: 0, max: 999, "controls-position": "right", style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 }), l(s, { label: "状态", prop: "enabled" }, { default: n(() => [l(E, { modelValue: e(o).enabled, "onUpdate:modelValue": t[2] || (t[2] = (r) => e(o).enabled = r), options: e(_).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(s, { label: "所属部门", prop: "deptId" }, { default: n(() => [l(I, { placement: "top-start", width: "450", trigger: "click", visible: u.value, "onUpdate:visible": t[4] || (t[4] = (r) => u.value = r), ref_key: "menuPopover", ref: b }, { reference: n(() => [l(f, { modelValue: e(o).deptName, "onUpdate:modelValue": t[3] || (t[3] = (r) => e(o).deptName = r), style: { width: "450px" }, placeholder: "点击选择所属部门", readonly: "" }, null, 8, ["modelValue"])]), default: n(() => [l(D, { ref_key: "menuSelectRef", ref: g, onSelected: x, style: { width: "400px" }, pid: e(o).deptId, defaultProps: { children: "children", label: "name" }, treeMenu: c.value }, null, 8, ["pid", "treeMenu"])]), _: 1 }, 8, ["visible"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, O = q(j, [["__scopeId", "data-v-9f8fc041"]]);
export {
  O as default
};
